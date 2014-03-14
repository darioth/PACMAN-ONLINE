package pck.client.pacman;

import pck.client.TCanvas;

import com.google.gwt.canvas.dom.client.Context2d;

import com.google.gwt.dom.client.ImageElement;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.RootPanel;

public class TPacman {
	
	private Context2d context;
	private TCanvas canvas;
	
	private Timer t;
	private double x,y;
	private double w,h;
	

	public void setX(double x) {
		this.x = x;
	}
	public void setY(double y) {
		this.y = y;
	}
	
	public void setW(double w) {
		this.w = w;
	}
	public void setH(double h) {
		this.h = h;
	}
	
    private int desplazamiento;
    
	private enum Movimiento{IZQUIERDA,DERECHA,ARRIBA,ABAJO}
	private Movimiento movimiento;
	private int estado;    //0 boca cerrada 1 boca abierta
	
	private enum Movimientof{IZQUIERDAF,DERECHAF,ARRIBAF,ABAJOF}  //variable para dibujar el fantas
	private Movimientof movimientof;  ////variable para dibujar el fantas

	private Image imgAbiertoDown;
	private Image imgCerradoDown;
	private Image imgAbiertoUp;
	private Image imgCerradoUp;
	private Image imgAbiertoLeft;
	private Image imgCerradoLeft;
	private Image imgAbiertoRight;
	private Image imgCerradoRight;
	private Image imgfantasma;
	private Image imgfantasmadebil;
	private int tiempoespera;
	private int tiempoesperaadicional;
	private Image imgfantasmaintermedio;
	private int timpolimitespera;  
	private int efectoultimossegundos; 
	
	
	
	//PROPIEDADES
	public double getX(){
		return x;
	}
	public double getY(){
		return y;
	}
	public double getW(){
		return w;
	}
	public double getH(){
		return h;
	}
	public int getDesplazamiento(){
		return desplazamiento;
	}
	//*****CONSTRUCTOR*****
	public TPacman(TCanvas _canvas){
		
		canvas=_canvas;
		context=canvas.getContext();
		
		x=11;  
        y=361;
        //w=37; //ancho
        w=35;
        h=35;
        //h=38; //altura
        desplazamiento=5; //deplazamiento en cada movimiento
        
		estado=0;
		tiempoespera=0;
		timpolimitespera=250;
		tiempoesperaadicional=0;
		efectoultimossegundos=0;
	    
		
		
	    
		imgAbiertoDown=new Image("recPacman/imgabiertodown.jpg");
		imgCerradoDown = new Image("recPacman/imgcerradodown.jpg");
		imgAbiertoUp = new Image("recPacman/imgabiertoup.jpg");
		imgCerradoUp = new Image("recPacman/imgcerradoup.jpg");
		imgAbiertoLeft = new Image("recPacman/imgabiertoleft.jpg");
		imgCerradoLeft = new Image("recPacman/imgcerradoleft.jpg");
		imgAbiertoRight = new Image("recPacman/imgabierto.jpg");
		imgCerradoRight = new Image("recPacman/imgcerrado.jpg");
		imgfantasma=new Image("recPacman/marciano.png");
		imgfantasmadebil=new Image("recPacman/fantasmadebil.jpg");
		imgfantasmaintermedio=new Image("recPacman/intermedio.jpg");
		
		
		
		
		
		
		//metodo para dibujar el pacman abierto-cerrado
	    t=new Timer(){
			
			 public void run()
			{
				 if(movimiento==Movimiento.ABAJO){
				    	
				    	switch(estado){
					    case 0:
						    	PacmanCerradoDown();	
					    	
					    	estado=1;
					    	break;
					    case 1:
					    		PacmanAbiertoDown();	
					    	
					    	estado=0;
					    	break;
					    }	
				    	
				    }//end if
				 if(movimiento==Movimiento.ARRIBA){
				    	
				    	switch(estado){
					    case 0:
						    	PacmanCerradoUp();	
					    	
					    	estado=1;
					    	break;
					    case 1:
					    		PacmanAbiertoUp();	
					    	
					    	estado=0;
					    	break;
					    }	
				    	
				    }//end if
				 if(movimiento==Movimiento.DERECHA){
			    	
			    	switch(estado){
				    case 0:
					    	PacmanCerradoRight();	
				    	
				    	estado=1;
				    	break;
				    case 1:
				    		PacmanAbiertoRigth();	
				    	
				    	estado=0;
				    	break;
				    }	
			    	
			    }//end if
			    if(movimiento==Movimiento.IZQUIERDA){
			    	
			    	switch(estado){
				    case 0:
					    	PacmanCerradoLeft();	
				    	
				    	estado=1;
				    	break;
				    case 1:
				    		PacmanAbiertoLeft();	
				    	
				    	estado=0;
				    	break;
				    }	
			    	
			    }//end if
			    
			}//end function
		};//end class
		t.scheduleRepeating(200);
		
		//movimiento fantasma
		/*
		t=new Timer(){
			
			 public void run()
			{
				 if(movimientof==Movimientof.ABAJOF){
				    	
					 imagenfantasma();	
				    	
				    }//end if
				 if(movimientof==Movimientof.ARRIBAF){
				    	
					 imagenfantasma();	
				    	
				    }//end if
				 if(movimientof==Movimientof.DERECHAF){
			    	
					 imagenfantasma();	
			    	
			    }//end if
			    if(movimientof==Movimientof.IZQUIERDAF){
			    	
			    	imagenfantasma();	
			    	
			    }//end if
			    
			}//end function
		};//end class
		t.scheduleRepeating(200);
		
		*/
		//fin movimiento fantasma
		
		
	}//end function
	
	//***** METODOS PRIVADOS*****
	private void PacmanAbiertoDown(){
		
		context.beginPath();
		
		ImageElement imageElement = ImageElement.as(imgAbiertoDown.getElement());
		context.drawImage(imageElement, x, y,w,h);
		context.closePath();
		
	} //end function
	private void PacmanCerradoDown(){
		context.beginPath();
		ImageElement imageElement = ImageElement.as(imgCerradoDown.getElement());
		context.drawImage(imageElement, x, y,w,h);
		context.closePath();
		
	}//end functtion
	private void PacmanAbiertoUp(){
		
		context.beginPath();
		ImageElement imageElement = ImageElement.as(imgAbiertoUp.getElement());
		context.drawImage(imageElement, x, y,w,h);
		context.closePath();
		
	} //end function
	private void PacmanCerradoUp(){
		context.beginPath();
		ImageElement imageElement = ImageElement.as(imgCerradoUp.getElement());
		context.drawImage(imageElement, x, y,w,h);
		context.closePath();
		
	}//end functtion
	private void PacmanAbiertoLeft(){
		
		context.beginPath();
		ImageElement imageElement = ImageElement.as(imgAbiertoLeft.getElement());
		context.drawImage(imageElement, x, y,w,h);
		context.closePath();
		
	} //end function
	private void PacmanCerradoLeft(){
		context.beginPath();
		ImageElement imageElement = ImageElement.as(imgCerradoLeft.getElement());
		context.drawImage(imageElement, x, y,w,h);
		context.closePath();
		
	}//end functtion
	private void PacmanAbiertoRigth(){
		
		context.beginPath();
		ImageElement imageElement = ImageElement.as(imgAbiertoRight.getElement());
		context.drawImage(imageElement, x, y,w,h);
		context.closePath();
		
	} //end function
	private void PacmanCerradoRight(){
		context.beginPath();
		ImageElement imageElement = ImageElement.as(imgCerradoRight.getElement());
		context.drawImage(imageElement, x, y,w,h);
		context.closePath();
	}//end functtion
		
		//imagen del fantasma
		private void imagenfantasma(){
			context.beginPath();
			ImageElement imageElement = ImageElement.as(imgfantasma.getElement());
			context.drawImage(imageElement, x, y,w,h);
			context.closePath();
			
		}//end functtion
		
		private void imagenfantasmadebil(){
			context.beginPath();
			ImageElement imageElement = ImageElement.as(imgfantasmadebil.getElement());
			context.drawImage(imageElement, x, y,w,h);
			context.closePath();
			
		}//end functtion
		
		private void imagenfantasmaintermedio(){
			context.beginPath();
			ImageElement imageElement = ImageElement.as(imgfantasmaintermedio.getElement());
			context.drawImage(imageElement, x, y,w,h);
			context.closePath();
			
		}//end functtion
		
		
		
	
	private void BorrarPacman(){
		context.clearRect(x, y, w,h);
	}
	
	private void BorrarFantasma(){
		context.clearRect(x, y, w,h);
	}
	//***** METODOS PUBLICOS *****
	public void MoverDerecha(){
		movimiento=Movimiento.DERECHA;
		BorrarPacman();
		x=x+desplazamiento;
		PacmanAbiertoRigth();
	}
	public void MoverIzquierda(){
		movimiento=Movimiento.IZQUIERDA;
		BorrarPacman();
		x=x-desplazamiento;
		PacmanAbiertoLeft();
	}
	public void MoverArriba(){
		movimiento=Movimiento.ARRIBA;
		BorrarPacman();
		y=y-desplazamiento;
		PacmanAbiertoUp();
	}
	public void MoverAbajo(){
		movimiento=Movimiento.ABAJO;
		BorrarPacman();
		y=y+desplazamiento;
		PacmanAbiertoDown();
	}
	
	//movimientos del fantasma
	public int MoverDerechaf(int i, int j){
		int t2 = 0; 
		//movimientof=Movimientof.ABAJOF;
		BorrarPacman();
		x=x+desplazamiento;  // verificar si es mas(derecha y abajo) o menos(izquierda y arriba)
		
		if (i==0 && j==0){
		imagenfantasma();
				 }
		else{
			tiempoespera=tiempoespera+1;
			RootPanel.get("m").clear();
			RootPanel.get("m").add(new HTML("tiempo de chance = "+Double.toString(timpolimitespera-tiempoespera)));
			if (tiempoespera<timpolimitespera){
				if(i==1 && j==2){  // si comio otra patilla especial antes de que acabe el tiempo de la pastilla 1
					
					if (tiempoesperaadicional==0){
					tiempoespera=0;}
					
					tiempoesperaadicional=1;
					
				}
			
			//efecto de los ultimos segundos
			if (tiempoespera>(timpolimitespera-50)){
			switch(efectoultimossegundos){
			case 0:
				imagenfantasmaintermedio(); 
				efectoultimossegundos=1;
				break;
			case 1:
				imagenfantasmadebil();
				efectoultimossegundos=0;
				break;
					
			}
			} //end if
			//fin ... efecto de los ultimos segundos
			else{
				imagenfantasmadebil();
			}
			
			
			}
			else{
				imagenfantasmaintermedio();
				t2=tiempoespera();
				tiempoespera=0; //modificacion para aceptar varias pastillas especiales
				tiempoesperaadicional=0;
				}
			}
		
		if(t2==2){
			t2=0;			
		}
		else{
			t2=1;
		}
		
		return t2; //retornamos al TPrincipal pacman 0 si se acabo el tiempo y 1 si no se acabo
		
	}
	
	public int MoverIzquierdaf(int i, int j){
		int t2 = 0; 
		//movimientof=Movimientof.ABAJOF;
		BorrarPacman();
		x=x-desplazamiento;  // verificar si es mas(derecha y abajo) o menos(izquierda y arriba)
		
		if (i==0 && j==0){
		imagenfantasma();
				 }
		else{
			tiempoespera=tiempoespera+1;
			RootPanel.get("m").clear();
			RootPanel.get("m").add(new HTML("tiempo de chance =  "+Double.toString(timpolimitespera-tiempoespera)));
			if (tiempoespera<timpolimitespera){
				if(i==1 && j==2){  // si comio otra patilla especial antes de que acabe el tiempo de la pastilla 1
					
					if (tiempoesperaadicional==0){
					tiempoespera=0;}
					
					tiempoesperaadicional=1;
					
				}
			
			//efecto de los ultimos segundos
			if (tiempoespera>(timpolimitespera-50)){
			switch(efectoultimossegundos){
			case 0:
				imagenfantasmaintermedio(); 
				efectoultimossegundos=1;
				break;
			case 1:
				imagenfantasmadebil();
				efectoultimossegundos=0;
				break;
					
			}
			} //end if
			//fin ... efecto de los ultimos segundos
			else{
				imagenfantasmadebil();
			}
			
			}
			else{
				imagenfantasmaintermedio();
				t2=tiempoespera();
				tiempoespera=0; //modificacion para aceptar varias pastillas especiales
				tiempoesperaadicional=0;
				}
			}
		
		if(t2==2){
			t2=0;			
		}
		else{
			t2=1;
		}
		
		return t2; //retornamos al TPrincipal pacman 0 si se acabo el tiempo y 1 si no se acabo
		
	}
	
	public int MoverArribaf(int i, int j){
		int t2 = 0; 
		//movimientof=Movimientof.ABAJOF;
		BorrarPacman();
		y=y-desplazamiento;  // verificar si es mas(derecha y abajo) o menos(izquierda y arriba)
		
		if (i==0 && j==0){
		imagenfantasma();
				 }
		else{
			tiempoespera=tiempoespera+1;
			RootPanel.get("m").clear();
			RootPanel.get("m").add(new HTML("tiempo de chance =  "+Double.toString(timpolimitespera-tiempoespera)));
			if (tiempoespera<timpolimitespera){
				if(i==1 && j==2){  // si comio otra patilla especial antes de que acabe el tiempo de la pastilla 1
					
					if (tiempoesperaadicional==0){
					tiempoespera=0;}
					
					tiempoesperaadicional=1;
					
				}
			
			//efecto de los ultimos segundos
			if (tiempoespera>(timpolimitespera-50)){
			switch(efectoultimossegundos){
			case 0:
				imagenfantasmaintermedio(); 
				efectoultimossegundos=1;
				break;
			case 1:
				imagenfantasmadebil();
				efectoultimossegundos=0;
				break;
					
			}
			} //end if
			//fin ... efecto de los ultimos segundos
			else{
				imagenfantasmadebil();
			}
			
			}
			else{
				imagenfantasmaintermedio();
				t2=tiempoespera();
				tiempoespera=0; //modificacion para aceptar varias pastillas especiales
				tiempoesperaadicional=0;
				}
			}
		
		if(t2==2){
			t2=0;			
		}
		else{
			t2=1;
		}
		
		return t2; //retornamos al TPrincipal pacman 0 si se acabo el tiempo y 1 si no se acabo
		
	}
	
	public int MoverAbajof(int i, int j){
		int t2 = 0; 
		//movimientof=Movimientof.ABAJOF;
		BorrarPacman();
		y=y+desplazamiento;  // verificar si es mas(derecha y abajo) o menos(izquierda y arriba)
		
		if (i==0 && j==0){
		imagenfantasma();
				 }
		else{
			tiempoespera=tiempoespera+1;
			RootPanel.get("m").clear();
			RootPanel.get("m").add(new HTML("tiempo de chance =  "+Double.toString(timpolimitespera-tiempoespera)));
			if (tiempoespera<timpolimitespera){
				if(i==1 && j==2){  // si comio otra patilla especial antes de que acabe el tiempo de la pastilla 1
					
					if (tiempoesperaadicional==0){
					tiempoespera=0;}
					
					tiempoesperaadicional=1;
					
				}
			
			
			//efecto de los ultimos segundos
			if (tiempoespera>(timpolimitespera-50)){
			switch(efectoultimossegundos){
			case 0:
				
				imagenfantasmaintermedio(); 
				efectoultimossegundos=1;
				break;
			case 1:
				
				imagenfantasmadebil();
				efectoultimossegundos=0;
				break;
					
			}
			} //end if
			//fin ... efecto de los ultimos segundos
			else{
				imagenfantasmadebil();
			}
			
			}
			else{
				imagenfantasmaintermedio();
				t2=tiempoespera();
				tiempoespera=0; //modificacion para aceptar varias pastillas especiales
				tiempoesperaadicional=0;
				}
			}
		
		if(t2==2){
			t2=0;			
		}
		else{
			t2=1;
		}
		
		return t2; //retornamos al TPrincipal pacman 0 si se acabo el tiempo y 1 si no se acabo
		
	}
	
	//verificar que el tiempo de espera se agoto
	public int tiempoespera(){
		int estado;
		estado=2; // sirve para hacer cambiar el bit a 0 cuando se acabo el tiempo de espera
		return estado;
	}
	
	public double PostXMoverDerecha(){
		return x+desplazamiento;
	}
	public double PostXMoverIzquierda(){
		return x-desplazamiento;
	}
	public double PostYMoverArriba(){
		return y-desplazamiento;
	}
	public double PostYMoverAbajo(){
		return y+desplazamiento;
	}
}//end class
