package pck.client.pacman;

import java.util.ArrayList;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.media.client.Audio;
import pck.client.PracticaPR12;
import pck.client.TCanvas;
import pck.client.TFrmInstrucciones;
import pck.client.TFrmResultado;
import pck.client.pacman.TComida.TMurocomida;
import pck.client.pacman.TLaberintoMuro.TMuro;

public class TPrincipalPacman {
	//****** ATRIBUTOS
	private Context2d context;
	private TCanvas canvas;
	
	private TLaberintoMuro laberintoMuro;
	private TComida comida;
	private TPacman pacman;
	private TPacman fantasma;
	private TPacman fantasma2;
	private TPacman fantasma3;
	private TPacman fantasma4;
	private Audio musicFondo;
	private Audio musicComida;
	private Audio musicMuerte;
	private Timer t;
	private Timer t1;
	private int tecla;
	private int score;
	private int index;
	private int teclaf;
	private int teclaf2;
	private int teclaf3;
	private int teclaf4;
	private int nivel;
	private int acumulador;

	private String niveltext;
	private int vida;
	private int bitcomidaespecial;
	private int bitcomidaespecialadicional;
	private int tiempofuera;
	//private int quienchoco;
	
	
	
	
	//****** PROPIEDADES *****
			public Canvas getCanvas(){
				return canvas.getCanvas();
				
			}
	//***** CONSTRUCTOR *****		
	
		public TPrincipalPacman(int a) {
			canvas=new TCanvas();
			
			//canvas=_canvas;
			context=canvas.getContext();
			if(a==1){ nivel=a;Window.alert("nivel facil");}else
			if(a==2){nivel=a;Window.alert("nivel medio");}else
			if(a==3){nivel=a;Window.alert("nivel dificil");}
			
		// TODO Auto-generated constructor stub
			
			laberintoMuro=new TLaberintoMuro(canvas);
		    laberintoMuro.DibujarMuros();
			comida=new TComida(canvas);
		    comida.DibujarMurosco();
		    vida=5;
		    tecla=1;
		    teclaf=1;
		    teclaf2=1;
		    teclaf3=1;
		    teclaf4=1;  
		    bitcomidaespecial=0;
		    bitcomidaespecialadicional=0;
		    tiempofuera=1;
		   // quienchoco=0;
		    RootPanel.get("miooooo").add(new HTML("bit1 = "+Double.toString(bitcomidaespecial)+"     bit2 = "+Double.toString(bitcomidaespecialadicional)));
		    RootPanel.get("m").add(new HTML("tiempo de chance =  0"));
		    
			musicFondo=Audio.createIfSupported();
			musicFondo.setSrc("fondo.mp3");
			musicFondo.play();
	}
		public void puntuacion(){
			score=score+1;
			
			RootPanel.get("mio").clear();	
			if(nivel==1){	niveltext="FACIL";RootPanel.get("mio").add(new HTML("NIVEL FACIL "));}else
			if(nivel==2){	niveltext="MEDIO";RootPanel.get("mio").add(new HTML("NIVEL MEDIO"));}else
			if(nivel==3){	niveltext="DIFICIL";RootPanel.get("mio").add(new HTML("NIVEL DIFICIL "));				
			}	
			
			RootPanel.get("mio").add(new HTML("VIDAS = "+Double.toString(vida)));
			RootPanel.get("mio").add(new HTML("COMIDA = "+Double.toString(score)));
			acumulador=score;
			acumulador=acumulador*200;	
			RootPanel.get("mio").add(new HTML("PUNTOS = "+Double.toString(acumulador)));
		}
		private int InterseccionX(double _x1,double _w1,double _x2,double _w2){
		int estado=0;
				
		if(_x1<=_x2+_w2 && _x2+_w2<=_x1+_w1){
			//Window.alert("1");
			estado=1;
		}//end if
		else if(_x1<=_x2 && _x2<=_x1+_w1){
			//Window.alert("2");
			estado=1;
		}//end if
		else if(_x2<=_x1+_w1 && _x1+_w1<=_x2+_w2){
			//Window.alert("3");
			estado=1;
		}//end if
		else if(_x2<=_x1 && _x1<=_x2+_w2){
			//Window.alert("4");
			estado=1;
		}//end if
		
		return estado;
	}//end function
	private int InterseccionY(double _y1,double _h1,double _y2,double _h2){
		int estado=0;
		if(_y1<=_y2+_h2 && _y2+_h2<=_y1+_h1){
			estado=1;

		}//end if
		else if(_y1<=_y2 && _y2<=_y1+_h1){
			estado=1;
		
		}//end if
		else if(_y2<=_y1+_h1 && _y1+_h1<=_y2+_h2){
			estado=1;
			
		}//end if
		else if(_y2<=_y1 && _y1<=_y2+_h2){
			estado=1;
		
		}//end if

		return estado;
	}
	private int ChocaPacmanComidaX(double _x,TPacman mostro){
		int estado=0;
		ArrayList<TMurocomida> murosco=comida.getComida(); 
			
			for(int i=0;i<murosco.size();i++){
				 
				
				double _x1=murosco.get(i).x;
				double _w1=murosco.get(i).w;
				double _y1=murosco.get(i).y;
				double _h1=murosco.get(i).h;
				
				//double _x2=pacman.getX();
				double _x2=_x;
				double _w2=mostro.getW(); //en este caso es solo para el pacman
				double _y2=mostro.getY();
				double _h2=mostro.getH();
				
				//ALGORITMO DE INTERSECCION DE AREAS
				if(InterseccionX(_x1,_w1,_x2,_w2)==1 && InterseccionY(_y1,_h1,_y2,_h2)==1){
					estado=1;   //este estado no se usa
			//comida
					puntuacion();
					//si come comida especial
					if ((murosco.get(i).x==210 && murosco.get(i).y==20) ){
						bitcomidaespecial=1;
						//Window.alert("inicialmente si reconoce la especial"); 
					
					}
					
					//si come una segunda pastilla adicional cuando ya comio una
					if ((murosco.get(i).x==210 && murosco.get(i).y==425)){
						bitcomidaespecialadicional=2;
					}
					
					
					
					RootPanel.get("miooooo").clear();
					RootPanel.get("miooooo").add(new HTML("bit1 = "+Double.toString(bitcomidaespecial)+"     bit2 = "+Double.toString(bitcomidaespecialadicional)));
					
					
					
					musicComida=Audio.createIfSupported();
					musicComida.setSrc("come.mp3");
					musicComida.play();
					murosco.remove(i);
					//RootPanel.get("mio").add(new HTML("tamaño de la lista: "+Double.toString(murosco.size())));
					context.clearRect(_x1, _y1, _w1, _h1);
					if(murosco.size()==0){
						parar();
						Window.alert("ganaste");
						Window.alert("FELICITACIONES SUPERO EL NIVEL"+niveltext);
						
						///
						//PracticaPR12 reiniciar=new PracticaPR12();
						//reiniciar.onModuleLoad();
						 if(nivel==1){
							 RootPanel.get("nivel1").remove(index);
							 TPrincipalPacman _pacman=new TPrincipalPacman(2);
							//cargamos el pacman en el contenedor de la tabla2
							RootPanel.get("nivel2").add(_pacman.getCanvas()); 
							_pacman.Ejecutar(50,75);		}
						 else
							 if(nivel==2){
								 RootPanel.get("nivel2").remove(index);
								 TPrincipalPacman _pacman=new TPrincipalPacman(3);
								//cargamos el pacman en el contenedor de la tabla2
								RootPanel.get("nivel3").add(_pacman.getCanvas()); 
								_pacman.Ejecutar(50,50);		}
							 else
							{
								 RootPanel.get("nivel3").remove(index);
								 Window.alert("FELICITACIONES SUPERO TODOS LOS NIVELES");
					 TFrmResultado res=new TFrmResultado();
						RootPanel.get("inst").add(res);		
							}
						
					}
					break; //salimos del bucle inmediatamente
				}//end if
													
			}//end for
		return estado;

	}//end function
	
	private int ChocaMuroX(double _x, TPacman mostro){
		int estado=0;
		ArrayList<TMuro> muros=laberintoMuro.getMuros();
			
			for(int i=0;i<muros.size();i++){
				 
				
				double _x1=muros.get(i).x;
				double _w1=muros.get(i).w;
				double _y1=muros.get(i).y;
				double _h1=muros.get(i).h;
				
				//double _x2=pacman.getX();
				double _x2=_x;
				double _w2=mostro.getW();
				double _y2=mostro.getY();
				double _h2=mostro.getH();
				
				//ALGORITMO DE INTERSECCION DE AREAS
				if(InterseccionX(_x1,_w1,_x2,_w2)==1 && InterseccionY(_y1,_h1,_y2,_h2)==1){
					estado=1;
					break; //salimos del bucle inmediatamente
				}//end if
													
			}//end for
		return estado;
	}//end function
	
	private int ChocaComidaX(double _x, TPacman mostro){
		int estado=0;  //esto tampoco se usa
		ArrayList<TMurocomida> murosco=comida.getComida(); 
			
			for(int i=0;i<murosco.size();i++){
				 
				
				double _x1=murosco.get(i).x;
				double _w1=murosco.get(i).w;
				double _y1=murosco.get(i).y;
				double _h1=murosco.get(i).h;
				
				//double _x2=pacman.getX();
				double _x2=_x;
				double _w2=mostro.getW();
				double _y2=mostro.getY();
				double _h2=mostro.getH();
				
				
				//ALGORITMO DE INTERSECCION DE AREAS
				if(InterseccionX(_x1,_w1,_x2,_w2)==1 && InterseccionY(_y1,_h1,_y2,_h2)==1){
					estado=1;
						comida.DibujarMurosco2(_x1, _y1, _w1, _h1);
						//RootPanel.get("mio").add(new HTML("1"));
					//break; //salimos del bucle inmediatamente
					
				}//end if
													
			}//end for
		return estado;
	}//end function
	
	
	private int ChocaComidaY(double _y, TPacman mostro){
		int estado=0;
		ArrayList<TMurocomida> murosco=comida.getComida();
			
		for(int i=0;i<murosco.size();i++){
			 
			
			double _x1=murosco.get(i).x;
			double _w1=murosco.get(i).w;
			double _y1=murosco.get(i).y;
			double _h1=murosco.get(i).h;
				
				double _x2=mostro.getX();
				double _w2=mostro.getW();
				//double _y2=pacman.getY();
				double _y2=_y;
				double _h2=mostro.getH();
				
				//ALGORITMO DE INTERSECCION DE AREAS
				if(InterseccionX(_x1,_w1,_x2,_w2)==1 && InterseccionY(_y1,_h1,_y2,_h2)==1){
					estado=1;
					comida.DibujarMurosco2(_x1, _y1, _w1, _h1);
					//RootPanel.get("mio").add(new HTML("2"));
					//break; //salimos del bucle inmediatamente
				}//end if
									
			}//end for
		return estado;
	}//end function
	
	private int ChocaPacmanComidaY(double _y,TPacman mostro){
		int estado=0;
		ArrayList<TMurocomida> murosco=comida.getComida(); 
		
		for(int i=0;i<murosco.size();i++){
			 
			
			double _x1=murosco.get(i).x;
			double _w1=murosco.get(i).w;
			double _y1=murosco.get(i).y;
			double _h1=murosco.get(i).h;
				
			double _x2=mostro.getX();
			double _w2=mostro.getW(); //en este caso es solo para el pacman
			double _y2=mostro.getY();
			double _h2=mostro.getH();
				
				//ALGORITMO DE INTERSECCION DE AREAS
				if(InterseccionX(_x1,_w1,_x2,_w2)==1 && InterseccionY(_y1,_h1,_y2,_h2)==1){
					estado=2;
					//comida
					puntuacion();
					if ((murosco.get(i).x==210 && murosco.get(i).y==20) ||(murosco.get(i).x==210 && murosco.get(i).y==425)){
						bitcomidaespecial=1;
						//Window.alert("inicialmente si reconoce la especial"); 
					
					}
					
					//si come una segunda pastilla adicional cuando ya comio una
					if ((murosco.get(i).x==210 && murosco.get(i).y==425)){
						bitcomidaespecialadicional=2;
					}
										
					
					
					RootPanel.get("miooooo").clear();
					RootPanel.get("miooooo").add(new HTML("bit1 = "+Double.toString(bitcomidaespecial)+"     bit2 = "+Double.toString(bitcomidaespecialadicional)));
					
					musicComida=Audio.createIfSupported();
					musicComida.setSrc("come.mp3");
					musicComida.play();
					murosco.remove(i);
					//RootPanel.get("mio").add(new HTML("tamaño de la lista: "+Double.toString(murosco.size())));
					//RootPanel.get("mio").add(new HTML(Double.toString(estado)));
					context.clearRect(_x1, _y1, _w1, _h1);
					if(murosco.size()==0){
						parar();
						Window.alert("ganaste");
						Window.alert("FELICITACIONES SUPERO EL NIVEL"+niveltext);
						
						//PracticaPR12 reiniciar=new PracticaPR12();
						//reiniciar.onModuleLoad();
						 if(nivel==1){
							 RootPanel.get("nivel1").remove(index);
							 TPrincipalPacman _pacman=new TPrincipalPacman(2);
							
							//cargamos el pacman en el contenedor de la tabla2
							RootPanel.get("nivel2").add(_pacman.getCanvas()); 
							_pacman.Ejecutar(50,75);		}
						 else
							 if(nivel==2){
								 RootPanel.get("nivel2").remove(index);
								 TPrincipalPacman _pacman=new TPrincipalPacman(3);
								//cargamos el pacman en el contenedor de la tabla2
								RootPanel.get("nivel3").add(_pacman.getCanvas()); 
								_pacman.Ejecutar(50,50);		}
							 else
							{
								 RootPanel.get("nivel3").remove(index); 
								 Window.alert("FELICITACIONES SUPERO TODOS LOS NIVELES");
					 TFrmResultado res=new TFrmResultado();
						RootPanel.get("inst").add(res);		
							}	
							
					}
					break; //salimos del bucle inmediatamente
				}//end if
									
			}//end for
		return estado;
	}//end function
	private int ChocaMuroY(double _y, TPacman mostro){

		int estado=0;
		ArrayList<TMuro> muros=laberintoMuro.getMuros();
			
		for(int i=0;i<muros.size();i++){
			 
			
			double _x1=muros.get(i).x;
			double _w1=muros.get(i).w;
			double _y1=muros.get(i).y;
			double _h1=muros.get(i).h;
				
				double _x2=mostro.getX();
				double _w2=mostro.getW();
				//double _y2=pacman.getY();
				double _y2=_y;
				double _h2=mostro.getH();
				
				//ALGORITMO DE INTERSECCION DE AREAS
				if(InterseccionX(_x1,_w1,_x2,_w2)==1 && InterseccionY(_y1,_h1,_y2,_h2)==1){
					estado=1;
					break; //salimos del bucle inmediatamente
				}//end if
									
			}//end for
		return estado;
	}//end function
	
	
	//falta poner un timer
	
	private int Choque(){
		int estadoch=0;
		
		
		
		double _x2=pacman.getX();
		double _w2=pacman.getW();
		double _y2=pacman.getY();
		double _h2=pacman.getH();
		
		//verificamos choque con el fantasma1
			double _x1=fantasma.getX();
			double _w1=fantasma.getW();
			double _y1=fantasma.getY();
			double _h1=fantasma.getH();
			
			
			
			//puntuacion();
			
			
			if(InterseccionX(_x1,_w1,_x2,_w2)==1 && InterseccionY(_y1,_h1,_y2,_h2)==1){
				
				estadoch=1;
				//RootPanel.get("mio").clear();
				//RootPanel.get("mio").add(new HTML("hay chokef1"));
				//Window.alert("rwerew");
				
				//si pacman no comio la pastilla especial, no se le descontaran vidas
				if (bitcomidaespecial==0 && bitcomidaespecialadicional==0){ // si es cero es lo normalss
					
				musicMuerte=Audio.createIfSupported();
				musicMuerte.setSrc("muerte.mp3");
				musicMuerte.play();
				//Window.alert("moriste");
				//Window.alert("moriste");
				vida=vida-1;
				 if (vida==0){
					puntuacion();
					parar();
					 Window.alert("fin del juego");
					 if(nivel==1){RootPanel.get("nivel1").remove(index);}
					 else
				     if(nivel==2){RootPanel.get("nivel2").remove(index);}
						 else
						{
							 RootPanel.get("nivel3").remove(index);		
						}			
					
						///
						//PracticaPR12 reiniciar=new PracticaPR12();
						//reiniciar.onModuleLoad();
					 TFrmResultado res=new TFrmResultado();
						RootPanel.get("inst").add(res);			
					
				 }
					
			}// fin .... si pacman no comio la pastilla especial, no se le descontaran vidas
				if (bitcomidaespecial==1 || bitcomidaespecialadicional==2){
					// para reubicar el fantasma luego del choque especial
				 	
				    context.clearRect(_x1, _y1, _w1, _h1);
				 	fantasma.setX(351);
				    fantasma.setY(11);
				 	
					
				    
				    ArrayList<TMurocomida> murosco=comida.getComida(); 
					
					for(int i=0;i<murosco.size();i++){
						 
						
						double _x11=murosco.get(i).x;
						double _w11=murosco.get(i).w;
						double _y11=murosco.get(i).y;
						double _h11=murosco.get(i).h;
						
						
						//ALGORITMO DE INTERSECCION DE AREAS
						if(InterseccionX(_x11,_w11,_x1,_w1)==1 && InterseccionY(_y11,_h11,_y1,_h1)==1){
								comida.DibujarMurosco2(_x11, _y11, _w11, _h11);
								//RootPanel.get("mio").add(new HTML("1"));
							//break; //salimos del bucle inmediatamente
							
						}//end if
															
					}//end for
				}
				
				//puntuacion();
				}//end if
				
				
				
		
			
			
			// verificamos choque con el fantasma2
			double _xf2=fantasma2.getX();
			double _wf2=fantasma2.getW();
			double _yf2=fantasma2.getY();
			double _hf2=fantasma2.getH();
			

			if(InterseccionX(_xf2,_wf2,_x2,_w2)==1 && InterseccionY(_yf2,_hf2,_y2,_h2)==1){
				estadoch=1;
				//RootPanel.get("mio").clear();
				//RootPanel.get("mio").add(new HTML("hay chokef2"));
				
				//si pacman comio la pastilla especial, no se le descontaran vidas
				if (bitcomidaespecial==0 && bitcomidaespecialadicional==0){ //si no comio ninguna pastilla
					
				
				musicMuerte=Audio.createIfSupported();
				musicMuerte.setSrc("muerte.mp3");
				musicMuerte.play();
				//Window.alert("moriste");
				//Window.alert("moriste");
				vida=vida-1;
				 if (vida==0){
					 puntuacion();
						parar();
					 Window.alert("fin del juego");
						
					 if(nivel==1){RootPanel.get("nivel1").remove(index);}
					 else
				     if(nivel==2){RootPanel.get("nivel2").remove(index);}
						 else
						{
							 RootPanel.get("nivel3").remove(index);		
						}			
						
				
					
						///
						//PracticaPR12 reiniciar=new PracticaPR12();
						//reiniciar.onModuleLoad();
						 TFrmResultado res=new TFrmResultado();
							RootPanel.get("inst").add(res);			
						
				
				 }
				 
				    
				 
			}// fin .... si pacman comio la pastilla especial, no se le descontaran vidas
				if (bitcomidaespecial==1 || bitcomidaespecialadicional==2){ // si comio alguna pastilla
					//// para reubicar el fantasma2 luego del choque especial
				    context.clearRect(_xf2, _yf2, _wf2, _hf2);
				    fantasma2.setX(11);
				    fantasma2.setY(416);
					
				    ArrayList<TMurocomida> murosco=comida.getComida(); 
				    
					for(int i=0;i<murosco.size();i++){
						 
						
						double _x11=murosco.get(i).x;
						double _w11=murosco.get(i).w;
						double _y11=murosco.get(i).y;
						double _h11=murosco.get(i).h;
						
						
						//ALGORITMO DE INTERSECCION DE AREAS
						if(InterseccionX(_x11,_w11,_xf2,_wf2)==1 && InterseccionY(_y11,_h11,_yf2,_hf2)==1){
								comida.DibujarMurosco2(_x11, _y11, _w11, _h11);
								//RootPanel.get("mio").add(new HTML("1"));
							//break; //salimos del bucle inmediatamente
							
						}//end if
															
					}//end for
				}
			//puntuacion();
				 
				}//end if
			
			//verificamos choque con el fantasma3
			double _xf3=fantasma3.getX();
			double _wf3=fantasma3.getW();
			double _yf3=fantasma3.getY();
			double _hf3=fantasma3.getH();
			

			if(InterseccionX(_xf3,_wf3,_x2,_w2)==1 && InterseccionY(_yf3,_hf3,_y2,_h2)==1){
				estadoch=1;
				//RootPanel.get("mio").clear();
				//RootPanel.get("mio").add(new HTML("hay chokef3"));
				
				//si pacman comio la pastilla especial, no se le descontaran vidas
				if (bitcomidaespecial==0 && bitcomidaespecialadicional==0){
					
				musicMuerte=Audio.createIfSupported();
				musicMuerte.setSrc("muerte.mp3");
				musicMuerte.play();
				//Window.alert("moriste");
				//Window.alert("moriste");
				vida=vida-1;
				 if (vida==0){
				puntuacion();
				parar();
					 Window.alert("fin del juego");
					 if(nivel==1){RootPanel.get("nivel1").remove(index);}
					 else
				     if(nivel==2){RootPanel.get("nivel2").remove(index);}
						 else
						{
							 RootPanel.get("nivel3").remove(index);		
						}			
						
						
					
						///
						//PracticaPR12 reiniciar=new PracticaPR12();
						//reiniciar.onModuleLoad();
						 TFrmResultado res=new TFrmResultado();
							RootPanel.get("inst").add(res);			
						
				 }
				 
				 
				    
				 
				}// fin .... si pacman comio la pastilla especial, no se le descontaran vidas
				if (bitcomidaespecial==1 || bitcomidaespecialadicional==2){
					//para reubicar el fantasma3 luego del choque especial
				    context.clearRect(_xf3, _yf3, _wf3, _hf3);
				    fantasma3.setX(211);
				    fantasma3.setY(261);
					
				    ArrayList<TMurocomida> murosco=comida.getComida(); 
				    for(int i=0;i<murosco.size();i++){
						 
						
						double _x11=murosco.get(i).x;
						double _w11=murosco.get(i).w;
						double _y11=murosco.get(i).y;
						double _h11=murosco.get(i).h;
						
						
						//ALGORITMO DE INTERSECCION DE AREAS
						if(InterseccionX(_x11,_w11,_xf3,_wf3)==1 && InterseccionY(_y11,_h11,_yf3,_hf3)==1){
								comida.DibujarMurosco2(_x11, _y11, _w11, _h11);
								//RootPanel.get("mio").add(new HTML("1"));
							//break; //salimos del bucle inmediatamente
							
						}//end if
															
					}//end for
				}
				//puntuacion();
				 
				}//end if
			
			//verificamos choque con el fantasma4
			double _xf4=fantasma4.getX();
			double _wf4=fantasma4.getW();
			double _yf4=fantasma4.getY();
			double _hf4=fantasma4.getH();
			

			if(InterseccionX(_xf4,_wf4,_x2,_w2)==1 && InterseccionY(_yf4,_hf4,_y2,_h2)==1){
				estadoch=1;
				//RootPanel.get("mio").clear();
				//RootPanel.get("mio").add(new HTML("hay chokef4"));
				
				//si pacman comio la pastilla especial, no se le descontaran vidas
				if (bitcomidaespecial==0 && bitcomidaespecialadicional==0){
					
				musicMuerte=Audio.createIfSupported();
				musicMuerte.setSrc("muerte.mp3");
				musicMuerte.play();
				//Window.alert("moriste");
				//Window.alert("moriste");
				vida=vida-1;
				 if (vida==0){
					puntuacion();
					parar();
					 Window.alert("fin del juego");
					 if(nivel==1){RootPanel.get("nivel1").remove(index);}
					 else
				     if(nivel==2){RootPanel.get("nivel2").remove(index);}
						 else
						{
							 RootPanel.get("nivel3").remove(index);		
						}			
						
						
				
						///
						//PracticaPR12 reiniciar=new PracticaPR12();
						//reiniciar.onModuleLoad();
						 TFrmResultado res=new TFrmResultado();
							RootPanel.get("inst").add(res);			
							
				 }
				 
				 
				}// fin .... si pacman comio la pastilla especial, no se le descontaran vidas
				if (bitcomidaespecial==1 || bitcomidaespecialadicional==2){
					//para reubicar el fantasma4 luego del choque especial
				    context.clearRect(_xf4, _yf4, _wf4, _hf4);
				    fantasma4.setX(161);
				    fantasma4.setY(261);
					
				    ArrayList<TMurocomida> murosco=comida.getComida(); 
				    for(int i=0;i<murosco.size();i++){
						 
						
						double _x11=murosco.get(i).x;
						double _w11=murosco.get(i).w;
						double _y11=murosco.get(i).y;
						double _h11=murosco.get(i).h;
						
						
						//ALGORITMO DE INTERSECCION DE AREAS
						if(InterseccionX(_x11,_w11,_xf4,_wf4)==1 && InterseccionY(_y11,_h11,_yf4,_hf4)==1){
								comida.DibujarMurosco2(_x11, _y11, _w11, _h11);
								//RootPanel.get("mio").add(new HTML("1"));
							//break; //salimos del bucle inmediatamente
							
						}//end if
															
					}//end for
				}
				//puntuacion();
				 
				}//end if
			
			return estadoch;
			
			//poner final de timer
		
	}//end functuion
	
	
	//************METODOS PUBLICOS
	public void parar(){
		t.cancel();
		t1.cancel();	
		musicFondo.pause();
	}
	
	
	public void Ejecutar(int velP,int velF){
		//fantasma.Ejecutarf();
	puntuacion();	
		//musicFondo.play();
		

		    pacman=new TPacman(canvas);
		    pacman.setW(34);
		    pacman.setH(34);
		    
		    fantasma=new TPacman(canvas);
		    fantasma.setX(351);
		    fantasma.setY(11);
		    
		    fantasma2=new TPacman(canvas);
		    fantasma2.setX(11);
		    fantasma2.setY(416);
		    
		    fantasma3=new TPacman(canvas);
		    fantasma3.setX(211);
		    fantasma3.setY(261);
		    
		    fantasma4=new TPacman(canvas);
		    fantasma4.setX(161);
		    fantasma4.setY(261);
		    
		    

		    
		    //1= mov derecha
		  //2= mov izquierda
		  //3= mov arriba
		  //4= mov abajo
		    
		    t=new Timer(){
				
				 public void run()
				{
					 
					 double pospacx=pacman.getX();
					 double pospacy=pacman.getY();
					 
					 double posfanx=fantasma.getX();
					 double posfany=fantasma.getY();
					 
					 
					 if(teclaf==1){
						 
						 double x1=fantasma.PostXMoverDerecha();
						 double x1c=fantasma.getX()-5;
						 ChocaComidaX(x1c, fantasma);
							if(ChocaMuroX(x1, fantasma)==1){
								//	Window.alert("CHOCO DERECHA");
								double y=fantasma.PostYMoverArriba();
								if(ChocaMuroY(y, fantasma)==1){
									//	Window.alert("CHOCO ARRIBA");
									double y4=fantasma.PostYMoverAbajo();
									if(ChocaMuroY(y4, fantasma)==1){
											teclaf=2;
										}else{teclaf=4;}
									}
								else{teclaf=3;}
							}
							else{
								
								//fantasma.MoverDerechaf(bitcomidaespecial);
								tiempofuera=fantasma.MoverDerechaf(bitcomidaespecial,bitcomidaespecialadicional);
								
								if(pospacy<=posfany){
									double y=fantasma.PostYMoverArriba();
									if(ChocaMuroY(y, fantasma)==1){
										//	Window.alert("CHOCO ARRIBA");
										double y4=fantasma.PostYMoverAbajo();
										if(ChocaMuroY(y4, fantasma)==1){
												//teclaf=2;
											}else{teclaf=4;}
										}
									else{teclaf=3;}
									}
									else{
									double y2=fantasma.PostYMoverAbajo();
									if(ChocaMuroY(y2, fantasma)==1){
										//	Window.alert("CHOCO ARRIBA");
										double y4=fantasma.PostYMoverArriba();
										if(ChocaMuroY(y4, fantasma)==1){
												//teclaf=2;
											}else{teclaf=3;}
										}
									else{teclaf=4;}
									}
							}
					 }
					 
					 if(teclaf==2){
						 
						 double x1=fantasma.PostXMoverIzquierda();
						 double x1c=fantasma.getX();
						 ChocaComidaX(x1c, fantasma);
							if(ChocaMuroX(x1, fantasma)==1){
								//	Window.alert("CHOCO DERECHA");
								double y=fantasma.PostYMoverArriba();
								if(ChocaMuroY(y, fantasma)==1){
									//	Window.alert("CHOCO ARRIBA");
									double y4=fantasma.PostYMoverAbajo();
									if(ChocaMuroY(y4, fantasma)==1){
											teclaf=1;
										}else{teclaf=4;}
									}
								else{teclaf=3;}
							}
							else{
								//fantasma.MoverIzquierdaf(bitcomidaespecial);
								tiempofuera=fantasma.MoverIzquierdaf(bitcomidaespecial,bitcomidaespecialadicional);
								
								if(pospacy<=posfany){
									double y=fantasma.PostYMoverArriba();
									if(ChocaMuroY(y, fantasma)==1){
										//	Window.alert("CHOCO ARRIBA");
										double y4=fantasma.PostYMoverAbajo();
										if(ChocaMuroY(y4, fantasma)==1){
												//teclaf=1;
											}else{teclaf=4;}
										}
									else{teclaf=3;}
									}
									else{
									double y2=fantasma.PostYMoverAbajo();
									if(ChocaMuroY(y2, fantasma)==1){
										//	Window.alert("CHOCO ARRIBA");
										double y4=fantasma.PostYMoverArriba();
										if(ChocaMuroY(y4, fantasma)==1){
												//teclaf=1;
											}else{teclaf=3;}
										}
									else{teclaf=4;}
									}
								
							}
					 }
					 
					 if(teclaf==3){
						
						 double x1=fantasma.PostYMoverArriba();
						 double x1c=fantasma.getY()+5;
						 ChocaComidaY(x1c, fantasma);
							if(ChocaMuroY(x1, fantasma)==1){
								//	Window.alert("CHOCO DERECHA");
								double y=fantasma.PostXMoverDerecha();
								if(ChocaMuroX(y, fantasma)==1){
									//	Window.alert("CHOCO ARRIBA");
									double y4=fantasma.PostXMoverIzquierda();
									if(ChocaMuroX(y4, fantasma)==1){
											teclaf=4;
										}else{teclaf=2;}
									}
								else{teclaf=1;}
							}
							else{
								//fantasma.MoverArribaf(bitcomidaespecial);
								tiempofuera=fantasma.MoverArribaf(bitcomidaespecial,bitcomidaespecialadicional);
								
								if(pospacx>=posfanx){
								double y=fantasma.PostXMoverDerecha();
								if(ChocaMuroX(y, fantasma)==1){
									//	Window.alert("CHOCO ARRIBA");
									double y4=fantasma.PostXMoverIzquierda();
									if(ChocaMuroX(y4, fantasma)==1){
										//	Window.alert("CHOCO ARRIBA");
										}else{teclaf=2;}
									}
								else{teclaf=1;}
								}
								else{
								double y2=fantasma.PostXMoverIzquierda();
								if(ChocaMuroX(y2, fantasma)==1){
									//	Window.alert("CHOCO ARRIBA");
									double y4=fantasma.PostXMoverDerecha();
									if(ChocaMuroX(y4, fantasma)==1){
										//	Window.alert("CHOCO ARRIBA");
										}else{teclaf=1;}
									}
								else{teclaf=2;}
								}
								
							}
						 
					 }
					 
					 if(teclaf==4){
						 double x1=fantasma.PostYMoverAbajo();
						 double x1c=fantasma.getY()-5;
						 ChocaComidaY(x1c, fantasma);
							if(ChocaMuroY(x1, fantasma)==1){
								//	Window.alert("CHOCO DERECHA");
								double y=fantasma.PostXMoverDerecha();
								if(ChocaMuroX(y, fantasma)==1){
									//	Window.alert("CHOCO ARRIBA");
									double y4=fantasma.PostXMoverIzquierda();
									if(ChocaMuroX(y4, fantasma)==1){
											teclaf=3;
										}else{teclaf=2;}
									}
								else{teclaf=1;}
							}
							else{
								 //fantasma.MoverAbajof(bitcomidaespecial);
								 tiempofuera=fantasma.MoverAbajof(bitcomidaespecial,bitcomidaespecialadicional);
								
								if(pospacx>=posfanx){
									double y=fantasma.PostXMoverDerecha();
									if(ChocaMuroX(y, fantasma)==1){
										//	Window.alert("CHOCO ARRIBA");
										double y4=fantasma.PostXMoverIzquierda();
										if(ChocaMuroX(y4, fantasma)==1){
											//	Window.alert("CHOCO ARRIBA");
											}else{teclaf=2;}
										}
									else{teclaf=1;}
									}
									else{
									double y2=fantasma.PostXMoverIzquierda();
									if(ChocaMuroX(y2, fantasma)==1){
										//	Window.alert("CHOCO ARRIBA");
										double y4=fantasma.PostXMoverDerecha();
										if(ChocaMuroX(y4, fantasma)==1){
											//	Window.alert("CHOCO ARRIBA");
											}else{teclaf=1;}
										}
									else{teclaf=2;}
									}
								
							}
					 }
					 
				
					 
					 
					 
					 double posfanx2=fantasma2.getX();
					 double posfany2=fantasma2.getY();
					 
					 if(teclaf2==1){
						 
						 double x1=fantasma2.PostXMoverDerecha();
						 double x1c=fantasma2.getX()-5;
						 ChocaComidaX(x1c, fantasma2);
							if(ChocaMuroX(x1, fantasma2)==1){
								//	Window.alert("CHOCO DERECHA");
								double y=fantasma2.PostYMoverArriba();
								if(ChocaMuroY(y, fantasma2)==1){
									//	Window.alert("CHOCO ARRIBA");
									double y4=fantasma2.PostYMoverAbajo();
									if(ChocaMuroY(y4, fantasma2)==1){
											teclaf2=2;
										}else{teclaf2=4;}
									}
								else{teclaf2=3;}
							}
							else{
								tiempofuera=fantasma2.MoverDerechaf(bitcomidaespecial,bitcomidaespecialadicional);
								
								if(pospacy<posfany2){
									double y=fantasma2.PostYMoverArriba();
									if(ChocaMuroY(y, fantasma2)==1){
										//	Window.alert("CHOCO ARRIBA");
										double y4=fantasma2.PostYMoverAbajo();
										if(ChocaMuroY(y4, fantasma2)==1){
												//teclaf=2;
											}else{teclaf2=4;}
										}
									else{teclaf2=3;}
									}
									else{
									double y2=fantasma2.PostYMoverAbajo();
									if(ChocaMuroY(y2, fantasma2)==1){
										//	Window.alert("CHOCO ARRIBA");
										double y4=fantasma.PostYMoverArriba();
										if(ChocaMuroY(y4, fantasma2)==1){
												//teclaf=2;
											}else{teclaf2=3;}
										}
									else{teclaf2=4;}
									}
								
							}
					 }
					 
					 if(teclaf2==2){
						 
						 double x1=fantasma2.PostXMoverIzquierda();
						 double x1c=fantasma2.getX();
						 ChocaComidaX(x1c, fantasma2);
							if(ChocaMuroX(x1, fantasma2)==1){
								//	Window.alert("CHOCO DERECHA");
								double y=fantasma2.PostYMoverArriba();
								if(ChocaMuroY(y, fantasma2)==1){
									//	Window.alert("CHOCO ARRIBA");
									double y4=fantasma2.PostYMoverAbajo();
									if(ChocaMuroY(y4, fantasma2)==1){
											teclaf2=1;
										}else{teclaf2=4;}
									}
								else{teclaf2=3;}
							}
							else{
								tiempofuera=fantasma2.MoverIzquierdaf(bitcomidaespecial,bitcomidaespecialadicional);
								if(pospacy<posfany2){
									double y=fantasma2.PostYMoverArriba();
									if(ChocaMuroY(y, fantasma2)==1){
										//	Window.alert("CHOCO ARRIBA");
										double y4=fantasma2.PostYMoverAbajo();
										if(ChocaMuroY(y4, fantasma2)==1){
												//teclaf=2;
											}else{teclaf2=4;}
										}
									else{teclaf2=3;}
									}
									else{
									double y2=fantasma2.PostYMoverAbajo();
									if(ChocaMuroY(y2, fantasma2)==1){
										//	Window.alert("CHOCO ARRIBA");
										double y4=fantasma2.PostYMoverArriba();
										if(ChocaMuroY(y4, fantasma2)==1){
												//teclaf=2;
											}else{teclaf2=3;}
										}
									else{teclaf2=4;}
									}
								
							}
					 }
					 
					 if(teclaf2==3){
						
						 double x1=fantasma2.PostYMoverArriba();
						 double x1c=fantasma2.getY()+5;
						 ChocaComidaY(x1c, fantasma2);
							if(ChocaMuroY(x1, fantasma2)==1){
								//	Window.alert("CHOCO DERECHA");
								double y=fantasma2.PostXMoverDerecha();
								if(ChocaMuroX(y, fantasma2)==1){
									//	Window.alert("CHOCO ARRIBA");
									double y4=fantasma2.PostXMoverIzquierda();
									if(ChocaMuroX(y4, fantasma2)==1){
											teclaf2=4;
										}else{teclaf2=2;}
									}
								else{teclaf2=1;}
							}
							else{
								tiempofuera=fantasma2.MoverArribaf(bitcomidaespecial,bitcomidaespecialadicional);
								
								if(pospacx>posfanx2){
									double y=fantasma2.PostXMoverDerecha();
									if(ChocaMuroX(y, fantasma2)==1){
										//	Window.alert("CHOCO ARRIBA");
										double y4=fantasma2.PostXMoverIzquierda();
										if(ChocaMuroX(y4, fantasma2)==1){
											//	Window.alert("CHOCO ARRIBA");
											}else{teclaf2=2;}
										}
									else{teclaf2=1;}
									}
									else{
									double y2=fantasma2.PostXMoverIzquierda();
									if(ChocaMuroX(y2, fantasma2)==1){
										//	Window.alert("CHOCO ARRIBA");
										double y4=fantasma2.PostXMoverDerecha();
										if(ChocaMuroX(y4, fantasma2)==1){
											//	Window.alert("CHOCO ARRIBA");
											}else{teclaf2=1;}
										}
									else{
										teclaf2=2;}
									}
								
							}
						 
					 }
					 
					 if(teclaf2==4){
						 double x1=fantasma2.PostYMoverAbajo();
						 double x1c=fantasma2.getY()-5;
						 ChocaComidaY(x1c, fantasma2);
							if(ChocaMuroY(x1, fantasma2)==1){
								//	Window.alert("CHOCO DERECHA");
								double y=fantasma2.PostXMoverDerecha();
								if(ChocaMuroX(y, fantasma2)==1){
									//	Window.alert("CHOCO ARRIBA");
									double y4=fantasma2.PostXMoverIzquierda();
									if(ChocaMuroX(y4, fantasma2)==1){
											teclaf2=3;
										}else{teclaf2=2;}
									}
								else{teclaf2=1;}
							}
							else{
								tiempofuera=fantasma2.MoverAbajof(bitcomidaespecial,bitcomidaespecialadicional);
								
								if(pospacx>posfanx2){
									double y=fantasma2.PostXMoverDerecha();
									if(ChocaMuroX(y, fantasma2)==1){
										//	Window.alert("CHOCO ARRIBA");
										double y4=fantasma2.PostXMoverIzquierda();
										if(ChocaMuroX(y4, fantasma2)==1){
											//	Window.alert("CHOCO ARRIBA");
											}else{teclaf2=2;}
										}
									else{teclaf2=1;}
									}
									else{
									double y2=fantasma2.PostXMoverIzquierda();
									if(ChocaMuroX(y2, fantasma2)==1){
										//	Window.alert("CHOCO ARRIBA");
										double y4=fantasma2.PostXMoverDerecha();
										if(ChocaMuroX(y4, fantasma2)==1){
											//	Window.alert("CHOCO ARRIBA");
											}else{teclaf2=1;}
										}
									else{teclaf2=2;}
									}
								
							}
					 }
					 
				
					 
					
					 
					 if(teclaf3==1){
						 
						 double x1=fantasma3.PostXMoverDerecha();
						 double x1c=fantasma3.getX()-5;
						 ChocaComidaX(x1c, fantasma3);
							if(ChocaMuroX(x1, fantasma3)==1){
								//	Window.alert("CHOCO DERECHA");
								double y=fantasma3.PostYMoverArriba();
								if(ChocaMuroY(y, fantasma3)==1){
									//	Window.alert("CHOCO ARRIBA");
									double y4=fantasma3.PostYMoverAbajo();
									if(ChocaMuroY(y4, fantasma3)==1){
											teclaf3=2;
										}else{teclaf3=4;}
									}
								else{teclaf3=3;}
							}
							else{
								tiempofuera=fantasma3.MoverDerechaf(bitcomidaespecial,bitcomidaespecialadicional);
								double y=fantasma3.PostYMoverArriba();
								if(ChocaMuroY(y, fantasma3)==1){
									//	Window.alert("CHOCO ARRIBA");
									double y4=fantasma3.PostYMoverAbajo();
									if(ChocaMuroY(y4, fantasma3)==1){
										//	Window.alert("CHOCO ARRIBA");
										}else{teclaf3=4;}
									}
								else{teclaf3=3;}
								
							}
					 }
					 
					 if(teclaf3==2){
						 
						 double x1=fantasma3.PostXMoverIzquierda();
						 double x1c=fantasma3.getX();
						 ChocaComidaX(x1c, fantasma3);
							if(ChocaMuroX(x1, fantasma3)==1){
								//	Window.alert("CHOCO DERECHA");
								double y=fantasma3.PostYMoverArriba();
								if(ChocaMuroY(y, fantasma3)==1){
									//	Window.alert("CHOCO ARRIBA");
									double y4=fantasma3.PostYMoverAbajo();
									if(ChocaMuroY(y4, fantasma3)==1){
											teclaf3=1;
										}else{teclaf3=4;}
									}
								else{teclaf3=3;}
							}
							else{
								tiempofuera=fantasma3.MoverIzquierdaf(bitcomidaespecial,bitcomidaespecialadicional);
								double y=fantasma3.PostYMoverArriba();
								if(ChocaMuroY(y, fantasma3)==1){
									//	Window.alert("CHOCO ARRIBA");
									double y4=fantasma3.PostYMoverAbajo();
									if(ChocaMuroY(y4, fantasma3)==1){
										//	Window.alert("CHOCO ARRIBA");
										}else{teclaf3=4;}
									}
								else{teclaf3=3;}
								
							}
					 }
					 
					 if(teclaf3==3){
						
						 double x1=fantasma3.PostYMoverArriba();
						 double x1c=fantasma3.getY()+5;
						 ChocaComidaY(x1c, fantasma3);
							if(ChocaMuroY(x1, fantasma3)==1){
								//	Window.alert("CHOCO DERECHA");
								double y=fantasma3.PostXMoverDerecha();
								if(ChocaMuroX(y, fantasma3)==1){
									//	Window.alert("CHOCO ARRIBA");
									double y4=fantasma3.PostXMoverIzquierda();
									if(ChocaMuroX(y4, fantasma3)==1){
											teclaf3=4;
										}else{teclaf3=2;}
									}
								else{teclaf3=1;}
							}
							else{
								tiempofuera=fantasma3.MoverArribaf(bitcomidaespecial,bitcomidaespecialadicional);
								double y=fantasma3.PostXMoverDerecha();
								if(ChocaMuroX(y, fantasma3)==1){
									//	Window.alert("CHOCO ARRIBA");
									double y4=fantasma3.PostXMoverIzquierda();
									if(ChocaMuroX(y4, fantasma3)==1){
										//	Window.alert("CHOCO ARRIBA");
										}else{teclaf3=2;}
									}
								else{teclaf3=1;}
								
							}
						 
					 }
					 
					 if(teclaf3==4){
						 double x1=fantasma3.PostYMoverAbajo();
						 double x1c=fantasma3.getY()-5;
						 ChocaComidaY(x1c, fantasma3);
							if(ChocaMuroY(x1, fantasma3)==1){
								//	Window.alert("CHOCO DERECHA");
								double y=fantasma3.PostXMoverDerecha();
								if(ChocaMuroX(y, fantasma3)==1){
									//	Window.alert("CHOCO ARRIBA");
									double y4=fantasma3.PostXMoverIzquierda();
									if(ChocaMuroX(y4, fantasma3)==1){
											teclaf3=3;
										}else{teclaf3=2;}
									}
								else{teclaf3=1;}
							}
							else{
								tiempofuera=fantasma3.MoverAbajof(bitcomidaespecial,bitcomidaespecialadicional);
								double y=fantasma3.PostXMoverDerecha();
								if(ChocaMuroX(y, fantasma3)==1){
									//	Window.alert("CHOCO ARRIBA");
									double y4=fantasma3.PostXMoverIzquierda();
									if(ChocaMuroX(y4, fantasma3)==1){
										//	Window.alert("CHOCO ARRIBA");
										}else{teclaf3=2;}
									}
								else{teclaf3=1;}
								
							}
					 }
					 
				
					 
					 if(teclaf4==1){
						 
						 double x1=fantasma4.PostXMoverDerecha();
						 double x1c=fantasma4.getX()-5;
						 ChocaComidaX(x1c, fantasma4);
							if(ChocaMuroX(x1, fantasma4)==1){
								//	Window.alert("CHOCO DERECHA");
								double y=fantasma4.PostYMoverArriba();
								if(ChocaMuroY(y, fantasma4)==1){
									//	Window.alert("CHOCO ARRIBA");
									double y4=fantasma4.PostYMoverAbajo();
									if(ChocaMuroY(y4, fantasma4)==1){
											teclaf4=2;
										}else{teclaf4=4;}
									}
								else{teclaf4=3;}
							}
							else{
								tiempofuera=fantasma4.MoverDerechaf(bitcomidaespecial,bitcomidaespecialadicional);
								double y=fantasma4.PostYMoverAbajo();
								if(ChocaMuroY(y, fantasma4)==1){
									//	Window.alert("CHOCO ARRIBA");
									double y4=fantasma4.PostYMoverArriba();
									if(ChocaMuroY(y4, fantasma4)==1){
										//	Window.alert("CHOCO ARRIBA");
										}else{teclaf4=3;}
									}
								else{teclaf4=4;}
								
							}
					 }
					 
					 if(teclaf4==2){
						 
						 double x1=fantasma4.PostXMoverIzquierda();
						 double x1c=fantasma4.getX();
						 ChocaComidaX(x1c, fantasma4);
							if(ChocaMuroX(x1, fantasma4)==1){
								//	Window.alert("CHOCO DERECHA");
								double y=fantasma4.PostYMoverArriba();
								if(ChocaMuroY(y, fantasma4)==1){
									//	Window.alert("CHOCO ARRIBA");
									double y4=fantasma4.PostYMoverAbajo();
									if(ChocaMuroY(y4, fantasma4)==1){
											teclaf4=1;
										}else{teclaf4=4;}
									}
								else{teclaf4=3;}
							}
							else{
								tiempofuera=fantasma4.MoverIzquierdaf(bitcomidaespecial,bitcomidaespecialadicional);
								double y=fantasma4.PostYMoverAbajo();
								if(ChocaMuroY(y, fantasma4)==1){
									//	Window.alert("CHOCO ARRIBA");
									double y4=fantasma4.PostYMoverArriba();
									if(ChocaMuroY(y4, fantasma4)==1){
										//	Window.alert("CHOCO ARRIBA");
										}else{teclaf4=3;}
									}
								else{teclaf4=4;}
								
							}
					 }
					 
					 if(teclaf4==3){
						
						 double x1=fantasma4.PostYMoverArriba();
						 double x1c=fantasma4.getY()+5;
						 ChocaComidaY(x1c, fantasma4);
							if(ChocaMuroY(x1, fantasma4)==1){
								//	Window.alert("CHOCO DERECHA");
								double y=fantasma4.PostXMoverDerecha();
								if(ChocaMuroX(y, fantasma4)==1){
									//	Window.alert("CHOCO ARRIBA");
									double y4=fantasma4.PostXMoverIzquierda();
									if(ChocaMuroX(y4, fantasma4)==1){
										teclaf4=4;
										}else{teclaf4=2;}
									}
								else{teclaf4=1;}
							}
							else{
								tiempofuera=fantasma4.MoverArribaf(bitcomidaespecial,bitcomidaespecialadicional);
								double y=fantasma4.PostXMoverDerecha();
								if(ChocaMuroX(y, fantasma4)==1){
									//	Window.alert("CHOCO ARRIBA");
									double y4=fantasma4.PostXMoverIzquierda();
									if(ChocaMuroX(y4, fantasma4)==1){
										//	Window.alert("CHOCO ARRIBA");
										}else{teclaf4=2;}
									}
								else{teclaf4=1;}
								
							}
						 
					 }
					 
					 if(teclaf4==4){
						 double x1=fantasma4.PostYMoverAbajo();
						 double x1c=fantasma4.getY()-5;
						 ChocaComidaY(x1c, fantasma4);
							if(ChocaMuroY(x1, fantasma4)==1){
								//	Window.alert("CHOCO DERECHA");
								double y=fantasma4.PostXMoverDerecha();
								if(ChocaMuroX(y, fantasma4)==1){
									//	Window.alert("CHOCO ARRIBA");
									double y4=fantasma4.PostXMoverIzquierda();
									if(ChocaMuroX(y4, fantasma4)==1){
										teclaf4=3;
										}else{teclaf4=2;}
									}
								else{teclaf4=1;}
							}
							else{
								tiempofuera=fantasma4.MoverAbajof(bitcomidaespecial,bitcomidaespecialadicional);
								double y=fantasma4.PostXMoverDerecha();
								if(ChocaMuroX(y, fantasma4)==1){
									//	Window.alert("CHOCO ARRIBA");
									double y4=fantasma4.PostXMoverIzquierda();
									if(ChocaMuroX(y4, fantasma4)==1){
										//	Window.alert("CHOCO ARRIBA");
										}else{teclaf4=2;}
									}
								else{teclaf4=1;}
								
							}
					 }
					 
//					 RootPanel.get("mio").clear();
//					 puntuacion();
//					RootPanel.get("mio").add(new HTML(" "+Double.toString(tiempofuera))); 
				}//end function
			};//end class
			t.scheduleRepeating(velF);
	
	
			
		Canvas _canvasNative=canvas.getCanvas(); 
	    _canvasNative.addKeyDownHandler(new KeyDownHandler() {

			@Override
			public void onKeyDown(KeyDownEvent event) {
				// TODO Auto-generated method stub
				if(event.getNativeKeyCode()==KeyCodes.KEY_RIGHT){
	
				if(tecla!=1){
					//simulamos el desplazamiento
				    double x=pacman.PostXMoverDerecha();
				    //double x=pacman.getX();
				    
					if(ChocaMuroX(x, pacman)==1){
						
						//tecla=temp;
						//	Window.alert("CHOCO DERECHA");
						
					}
					else{
						//pacman.MoverDerecha();	
						tecla=1;
						
					}
				}	
			}//end if
					
					
				if(event.getNativeKeyCode()==KeyCodes.KEY_LEFT){

					if(tecla!=2){
					    //simulamos el desplazamiento
					    double x=pacman.PostXMoverIzquierda();
					    
						if(ChocaMuroX(x, pacman)==1){
							//tecla=temp;
							//	Window.alert("CHOCO IZQUIERDA");
							
						}
						else{
							//pacman.MoverIzquierda();
							tecla=2;
						}
		
					}//end if
				}
				
				
				if(event.getNativeKeyCode()==KeyCodes.KEY_UP){
					
					if(tecla!=3){
					//simulamos el desplazamiento
				    double y=pacman.PostYMoverArriba();
				    
					if(ChocaMuroY(y, pacman)==1){
						//tecla=temp;
						//	Window.alert("CHOCO ARRIBA");
						
					}
					else{
						//pacman.MoverArriba();
						tecla=3;
					}

					}//end if
				}
				
				if(event.getNativeKeyCode()==KeyCodes.KEY_DOWN){

					if(tecla!=4){
					//simulamos el desplazamiento
				    double y=pacman.PostYMoverAbajo();
				    
					if(ChocaMuroY(y, pacman)==1){
						//tecla=temp;
						//	Window.alert("CHOCO ABAJO");
						
					}
					else{
						//pacman.MoverAbajo();	
						tecla=4;
					}

					}//end if
				}
			}

		});

	    
	    t1=new Timer(){
	    		
			 public void run()
			{
				 //verificando el tiempo de espera
				 if(tiempofuera==0){
						bitcomidaespecial=0;
						bitcomidaespecialadicional=0;
					}
					
					RootPanel.get("miooooo").clear();
					RootPanel.get("miooooo").add(new HTML("bit1 = "+Double.toString(bitcomidaespecial)+"     bit2 = "+Double.toString(bitcomidaespecialadicional)));
					
				 //RootPanel.get("mio").clear();
				 //RootPanel.get("mio").add(new HTML("derecha: "+Double.toString(pacman.PostXMoverDerecha()-5)));
				 //RootPanel.get("mio").add(new HTML("izquierda: "+Double.toString(pacman.PostXMoverIzquierda()-5)));
				 //RootPanel.get("mio").add(new HTML("arriba: "+Double.toString(pacman.PostYMoverArriba())));
				 //RootPanel.get("mio").add(new HTML("abajo: "+Double.toString(pacman.PostYMoverAbajo())));
				 
				 if (Choque()==1){
					 puntuacion();
					 if(bitcomidaespecial==0 && bitcomidaespecialadicional==0){ //cero es lo normal
						 
					 	double _x2=pacman.getX();
						double _w2=pacman.getW();
						double _y2=pacman.getY();
						double _h2=pacman.getH();
						
						context.clearRect(_x2, _y2, _w2, _h2);
					 	pacman.setX(11);
					    pacman.setY(11);
					    
						double _x1=fantasma.getX();
						double _w1=fantasma.getW();
						double _y1=fantasma.getY();
						double _h1=fantasma.getH();


						// para reubicar el fantasma luego del choque normal
					 	
					    context.clearRect(_x1, _y1, _w1, _h1);
					 	fantasma.setX(351);
					    fantasma.setY(11);
						
					    
					    ArrayList<TMurocomida> murosco=comida.getComida(); 
						
						for(int i=0;i<murosco.size();i++){
							 
							
							double _x11=murosco.get(i).x;
							double _w11=murosco.get(i).w;
							double _y11=murosco.get(i).y;
							double _h11=murosco.get(i).h;
							
							
							//ALGORITMO DE INTERSECCION DE AREAS
							if(InterseccionX(_x11,_w11,_x1,_w1)==1 && InterseccionY(_y11,_h11,_y1,_h1)==1){
									comida.DibujarMurosco2(_x11, _y11, _w11, _h11);
									//RootPanel.get("mio").add(new HTML("1"));
								//break; //salimos del bucle inmediatamente
								
							}//end if
																
						}//end for
						
						double _xf2=fantasma2.getX();
						double _wf2=fantasma2.getW();
						double _yf2=fantasma2.getY();
						double _hf2=fantasma2.getH();
						
						// para reubicar el fantasma luego del choque normal
					 	
						context.clearRect(_xf2, _yf2, _wf2, _hf2);
					    fantasma2.setX(11);
					    fantasma2.setY(416);
					    
						
						for(int i=0;i<murosco.size();i++){
							 
							
							double _x11=murosco.get(i).x;
							double _w11=murosco.get(i).w;
							double _y11=murosco.get(i).y;
							double _h11=murosco.get(i).h;
							
							
							//ALGORITMO DE INTERSECCION DE AREAS
							if(InterseccionX(_x11,_w11,_xf2,_wf2)==1 && InterseccionY(_y11,_h11,_yf2,_hf2)==1){
									comida.DibujarMurosco2(_x11, _y11, _w11, _h11);
									//RootPanel.get("mio").add(new HTML("1"));
								//break; //salimos del bucle inmediatamente
								
							}//end if
																
						}//end for
					 
						double _xf3=fantasma3.getX();
						double _wf3=fantasma3.getW();
						double _yf3=fantasma3.getY();
						double _hf3=fantasma3.getH();
						
						//para reubicar el fantasma3
					    context.clearRect(_xf3, _yf3, _wf3, _hf3);
					    fantasma3.setX(211);
					    fantasma3.setY(261);
						
					    for(int i=0;i<murosco.size();i++){
							 
							
							double _x11=murosco.get(i).x;
							double _w11=murosco.get(i).w;
							double _y11=murosco.get(i).y;
							double _h11=murosco.get(i).h;
							
							
							//ALGORITMO DE INTERSECCION DE AREAS
							if(InterseccionX(_x11,_w11,_xf3,_wf3)==1 && InterseccionY(_y11,_h11,_yf3,_hf3)==1){
									comida.DibujarMurosco2(_x11, _y11, _w11, _h11);
									//RootPanel.get("mio").add(new HTML("1"));
								//break; //salimos del bucle inmediatamente
								
							}//end if
																
						}//end for
					    
					    double _xf4=fantasma4.getX();
						double _wf4=fantasma4.getW();
						double _yf4=fantasma4.getY();
						double _hf4=fantasma4.getH();
						
						//para reubicar el fantasma4
					    context.clearRect(_xf4, _yf4, _wf4, _hf4);
					    fantasma4.setX(161);
					    fantasma4.setY(261);
						
					    
					    for(int i=0;i<murosco.size();i++){
							 
							
							double _x11=murosco.get(i).x;
							double _w11=murosco.get(i).w;
							double _y11=murosco.get(i).y;
							double _h11=murosco.get(i).h;
							
							
							//ALGORITMO DE INTERSECCION DE AREAS
							if(InterseccionX(_x11,_w11,_xf4,_wf4)==1 && InterseccionY(_y11,_h11,_yf4,_hf4)==1){
									comida.DibujarMurosco2(_x11, _y11, _w11, _h11);
									//RootPanel.get("mio").add(new HTML("1"));
								//break; //salimos del bucle inmediatamente
								
							}//end if
																
						}//end for
					  	 
				 }
				 }// fin choque
				 
				 if(tecla==1){
					 double x=pacman.PostXMoverDerecha();
					 double xcp=pacman.getX();
					 double ycp=pacman.getY();
					 ChocaPacmanComidaX(xcp, pacman);
						if(ChocaMuroX(x, pacman)==1){
							//	Window.alert("CHOCO DERECHA");
							
							//para la tranasportacion
							double xcpt=pacman.getX();
							 double ycpt=pacman.getY();
							if (((xcpt>=0 && xcpt<=11) || xcpt>=361) && ycpt==111){
								 pacman.MoverDerecha();
							 }
							 if( xcpt>=401 && ycpt==111){
								 
								 double _x2=pacman.getX();
									double _w2=pacman.getW();
									double _y2=pacman.getY();
									double _h2=pacman.getH();
								    context.clearRect(_x2, _y2, _w2, _h2);
								    
									pacman.setX(0);
								    pacman.setY(111);
								}
							 
							 //fin de la transportacion
						}
						else{
							pacman.MoverDerecha();	
							//temp=1;
						}
				 }
				 
				 if(tecla==2){
					 double x=pacman.PostXMoverIzquierda();
					 double xcp=pacman.getX();
					 double ycp=pacman.getY();
					 ChocaPacmanComidaX(xcp, pacman);
						if(ChocaMuroX(x, pacman)==1){
							//	Window.alert("CHOCO IZQUIERDA");
							//para la transportacion
							 double xcpt=pacman.getX();
							 double ycpt=pacman.getY();
							 if ((xcpt<=10 || (xcpt>=366 && xcpt<=410)) && ycpt==111){
								 pacman.MoverIzquierda();
							 }
							 if( xcpt<=-25 && ycpt==111){
								 
								 double _x2=pacman.getX();
									double _w2=pacman.getW();
									double _y2=pacman.getY();
									double _h2=pacman.getH();
								    context.clearRect(_x2, _y2, _w2, _h2);
								    
									pacman.setX(410);
								    pacman.setY(111);
								}
							 //fin de la transportacion
						}
						else{
							pacman.MoverIzquierda();	
							//temp=2;
						}
				 }
				 if(tecla==3){
					 double y=pacman.PostYMoverArriba();
					 double xcp=pacman.getY();
					 ChocaPacmanComidaY(xcp, pacman);
						if(ChocaMuroY(y, pacman)==1){
								//Window.alert("CHOCO ARRIBA");
						}
						else{
							pacman.MoverArriba();	
							//temp=3;
						}
				 }
				 if(tecla==4){
					 double y=pacman.PostYMoverAbajo();
					 double xcp=pacman.getY();
					 ChocaPacmanComidaY(xcp, pacman);
						if(ChocaMuroY(y, pacman)==1){
							//	Window.alert("CHOCO ABAJO");
						}
						else{
							pacman.MoverAbajo();	
							//temp=4;
						}
				 }
				 
			}//end function
			 
		};//end class
		t1.scheduleRepeating(velP);
    		
	 		
		
	}//end function
	public  Canvas setFocus(boolean b) {
		return canvas.getCanvas();
		
	}
	


	
	
		
}//end class
