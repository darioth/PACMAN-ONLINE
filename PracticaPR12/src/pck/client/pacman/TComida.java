package pck.client.pacman;

import java.util.ArrayList;

import pck.client.TCanvas;

import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.dom.client.ImageElement;
import com.google.gwt.user.client.ui.Image;

public class TComida {
			public class TMurocomida {
				
				public double x,y;
				public double w,h;
				
				public TMurocomida(double _x,double _y,double _w, double _h){
					x=_x;
					y=_y;
					w=_w;
					h=_h;
				}
			
			}//end class inner
			
	ArrayList<TMurocomida> murosco;
	private TCanvas canvas;
	private Context2d context;
	private Image img;
	private Image imgEspecial;
	
	//*************PROPIEDADES
	public ArrayList<TMurocomida> getComida() {
		return murosco;
	}
	//*************CONSTRUCTOR
	public TComida(TCanvas _canvas){
		
		   canvas=_canvas;
		   context=canvas.getContext();
		   img=new Image("recPacman/Comida.jpg");
		   imgEspecial=new Image("recPacman/comidaespecial.jpg");
		   
		   //bordes
		   murosco=new ArrayList<TMurocomida>();
		   
		   //fila 1
		   //murosco.add(new TMurocomida(20,25, 10,10 ));
		   //murosco.add(new TMurocomida(40,25, 10,10 ));
		   murosco.add(new TMurocomida(60,25, 10,10 ));
		   murosco.add(new TMurocomida(80,25, 10,10 ));
		   murosco.add(new TMurocomida(100,25, 10,10 ));
		   murosco.add(new TMurocomida(120,25, 10,10 ));
		   murosco.add(new TMurocomida(140,25, 10,10 ));
		   murosco.add(new TMurocomida(160,25, 10,10 ));
		   murosco.add(new TMurocomida(180,25, 10,10 ));
		   //murosco.add(new TMurocomida(200,25, 10,10 ));
		   //murosco.add(new TMurocomida(220,25, 10,10 ));
		   murosco.add(new TMurocomida(240,25, 10,10 ));
		   murosco.add(new TMurocomida(260,25, 10,10 ));
		   murosco.add(new TMurocomida(280,25, 10,10 ));
		   murosco.add(new TMurocomida(300,25, 10,10 ));
		   murosco.add(new TMurocomida(320,25, 10,10 ));
		   murosco.add(new TMurocomida(340,25, 10,10 ));
		   //murosco.add(new TMurocomida(360,25, 10,10 ));
		   //murosco.add(new TMurocomida(380,25, 10,10 ));
		   
		   
		   //fila2
		   murosco.add(new TMurocomida(20,75, 10,10 ));
		   murosco.add(new TMurocomida(40,75, 10,10 ));
		   murosco.add(new TMurocomida(60,75, 10,10 ));
		   murosco.add(new TMurocomida(80,75, 10,10 ));
		   murosco.add(new TMurocomida(120,75, 10,10 ));
		   murosco.add(new TMurocomida(140,75, 10,10 ));
		   murosco.add(new TMurocomida(160,75, 10,10 ));
		   murosco.add(new TMurocomida(180,75, 10,10 ));
		   murosco.add(new TMurocomida(220,75, 10,10 ));
		   murosco.add(new TMurocomida(240,75, 10,10 ));
		   murosco.add(new TMurocomida(260,75, 10,10 ));
		   murosco.add(new TMurocomida(280,75, 10,10 ));
		   murosco.add(new TMurocomida(320,75, 10,10 ));
		   murosco.add(new TMurocomida(340,75, 10,10 ));
		   murosco.add(new TMurocomida(360,75, 10,10 ));
		   murosco.add(new TMurocomida(380,75, 10,10 ));
		   
		 //fila 3
		   murosco.add(new TMurocomida(30,125, 10,10 ));
		   murosco.add(new TMurocomida(70,125, 10,10 ));
		   murosco.add(new TMurocomida(90,125, 10,10 ));
		   murosco.add(new TMurocomida(110,125, 10,10 ));
		   murosco.add(new TMurocomida(130,125, 10,10 ));
		   murosco.add(new TMurocomida(170,125, 10,10 ));
		   murosco.add(new TMurocomida(190,125, 10,10 ));
		   murosco.add(new TMurocomida(210,125, 10,10 ));
		   murosco.add(new TMurocomida(230,125, 10,10 ));
		   murosco.add(new TMurocomida(270,125, 10,10 ));
		   murosco.add(new TMurocomida(290,125, 10,10 ));
		   murosco.add(new TMurocomida(310,125, 10,10 ));
		   murosco.add(new TMurocomida(330,125, 10,10 ));
		   murosco.add(new TMurocomida(370,125, 10,10 ));
		   
		   //fila4
		   murosco.add(new TMurocomida(30,175, 10,10 ));
		   murosco.add(new TMurocomida(70,175, 10,10 ));
		   murosco.add(new TMurocomida(90,175, 10,10 ));
		   murosco.add(new TMurocomida(110,175, 10,10 ));
		   murosco.add(new TMurocomida(130,175, 10,10 ));
		   murosco.add(new TMurocomida(150,175, 10,10 ));
		   murosco.add(new TMurocomida(170,175, 10,10 ));
		   murosco.add(new TMurocomida(230,175, 10,10 ));
		   murosco.add(new TMurocomida(250,175, 10,10 ));
		   murosco.add(new TMurocomida(270,175, 10,10 ));
		   murosco.add(new TMurocomida(290,175, 10,10 ));
		   murosco.add(new TMurocomida(310,175, 10,10 ));
		   murosco.add(new TMurocomida(330,175, 10,10 ));
		   murosco.add(new TMurocomida(370,175, 10,10 ));
		   
		   //fila5
		   murosco.add(new TMurocomida(20,225, 10,10 ));
		   murosco.add(new TMurocomida(40,225, 10,10 ));
		   murosco.add(new TMurocomida(60,225, 10,10 ));
		   murosco.add(new TMurocomida(80,225, 10,10 ));
		   murosco.add(new TMurocomida(120,225, 10,10 ));
		   //murosco.add(new TMurocomida(140,225, 10,10 ));
		   //murosco.add(new TMurocomida(160,225, 10,10 ));
		   /*
		   murosco.add(new TMurocomida(180,225, 10,10 ));
		   murosco.add(new TMurocomida(200,225, 10,10 ));
		   murosco.add(new TMurocomida(220,225, 10,10 ));
		   */
		   //murosco.add(new TMurocomida(240,225, 10,10 ));
		   //murosco.add(new TMurocomida(260,225, 10,10 ));
		   murosco.add(new TMurocomida(280,225, 10,10 ));
		   murosco.add(new TMurocomida(320,225, 10,10 ));
		   murosco.add(new TMurocomida(340,225, 10,10 ));
		   murosco.add(new TMurocomida(360,225, 10,10 ));
		   murosco.add(new TMurocomida(380,225, 10,10 ));
		   
		 //fila6
		   murosco.add(new TMurocomida(30,275, 10,10 ));
		   murosco.add(new TMurocomida(70,275, 10,10 ));
		   murosco.add(new TMurocomida(90,275, 10,10 ));
		   murosco.add(new TMurocomida(110,275, 10,10 ));
		   murosco.add(new TMurocomida(130,275, 10,10 ));
		   murosco.add(new TMurocomida(150,275, 10,10 ));
		   //murosco.add(new TMurocomida(170,275, 10,10 ));
		   //murosco.add(new TMurocomida(230,275, 10,10 ));
		   murosco.add(new TMurocomida(250,275, 10,10 ));
		   murosco.add(new TMurocomida(270,275, 10,10 ));
		   murosco.add(new TMurocomida(290,275, 10,10 ));
		   murosco.add(new TMurocomida(310,275, 10,10 ));
		   murosco.add(new TMurocomida(330,275, 10,10 ));
		   murosco.add(new TMurocomida(370,275, 10,10 ));
		   
		   //fila7
		   murosco.add(new TMurocomida(30,325, 10,10 ));
		   murosco.add(new TMurocomida(70,325, 10,10 ));
		   murosco.add(new TMurocomida(90,325, 10,10 ));
		   murosco.add(new TMurocomida(110,325, 10,10 ));
		   murosco.add(new TMurocomida(130,325, 10,10 ));
		   murosco.add(new TMurocomida(170,325, 10,10 ));
		   murosco.add(new TMurocomida(190,325, 10,10 ));
		   murosco.add(new TMurocomida(210,325, 10,10 ));
		   murosco.add(new TMurocomida(230,325, 10,10 ));
		   murosco.add(new TMurocomida(270,325, 10,10 ));
		   murosco.add(new TMurocomida(290,325, 10,10 ));
		   murosco.add(new TMurocomida(310,325, 10,10 ));
		   murosco.add(new TMurocomida(330,325, 10,10 ));
		   murosco.add(new TMurocomida(370,325, 10,10 ));

		 //fila8
		   murosco.add(new TMurocomida(20,375, 10,10 ));
		   murosco.add(new TMurocomida(40,375, 10,10 ));
		   murosco.add(new TMurocomida(60,375, 10,10 ));
		   murosco.add(new TMurocomida(80,375, 10,10 ));
		   murosco.add(new TMurocomida(120,375, 10,10 ));
		   murosco.add(new TMurocomida(140,375, 10,10 ));
		   murosco.add(new TMurocomida(160,375, 10,10 ));
		   murosco.add(new TMurocomida(180,375, 10,10 ));
		   murosco.add(new TMurocomida(220,375, 10,10 ));
		   murosco.add(new TMurocomida(240,375, 10,10 ));
		   murosco.add(new TMurocomida(260,375, 10,10 ));
		   murosco.add(new TMurocomida(280,375, 10,10 ));
		   murosco.add(new TMurocomida(320,375, 10,10 ));
		   murosco.add(new TMurocomida(340,375, 10,10 ));
		   murosco.add(new TMurocomida(360,375, 10,10 ));
		   murosco.add(new TMurocomida(380,375, 10,10 ));
		   
		 //fila 9
		   //murosco.add(new TMurocomida(20,25, 10,10 ));
		   //murosco.add(new TMurocomida(40,25, 10,10 ));
		   murosco.add(new TMurocomida(60,425, 10,10 ));
		   murosco.add(new TMurocomida(80,425, 10,10 ));
		   murosco.add(new TMurocomida(100,425, 10,10 ));
		   murosco.add(new TMurocomida(120,425, 10,10 ));
		   murosco.add(new TMurocomida(140,425, 10,10 ));
		   murosco.add(new TMurocomida(160,425, 10,10 ));
		   murosco.add(new TMurocomida(180,425, 10,10 ));
		   //murosco.add(new TMurocomida(200,425, 10,10 ));
		   //murosco.add(new TMurocomida(220,425, 10,10 ));
		   murosco.add(new TMurocomida(240,425, 10,10 ));
		   murosco.add(new TMurocomida(260,425, 10,10 ));
		   murosco.add(new TMurocomida(280,425, 10,10 ));
		   murosco.add(new TMurocomida(300,425, 10,10 ));
		   murosco.add(new TMurocomida(320,425, 10,10 ));
		   murosco.add(new TMurocomida(340,425, 10,10 ));
		   //murosco.add(new TMurocomida(360,25, 10,10 ));
		   //murosco.add(new TMurocomida(380,25, 10,10 ));
		   
		   murosco.add(new TMurocomida(210,20, 18,18 )); //comida especial
		   murosco.add(new TMurocomida(210,425, 18,18 )); //comida especial
		   
		   
		   
	}//end function
	//**************METODOS PUBLICOS
	public void DibujarMurosco(){
		for(int i=0;i<murosco.size();i++)
		{
			if ((murosco.get(i).x==210 && murosco.get(i).y==20) ||(murosco.get(i).x==210 && murosco.get(i).y==425)){
				DrawMuroEspecial(murosco.get(i).x, murosco.get(i).y, murosco.get(i).w, murosco.get(i).h);
			}else{
			DrawMuro(murosco.get(i).x, murosco.get(i).y, murosco.get(i).w, murosco.get(i).h);
			}
		}
		
	}//end function
	
	public void DibujarMurosco2(double x,double y,double w,double h){
		
		
		context.beginPath();
		ImageElement imageElement = ImageElement.as(img.getElement());
		context.drawImage(imageElement, x, y,w,h);
		context.closePath();
		
		//esto es para el redibujado de la comida especial cuando el fantasma lo choca
				for(int i=0;i<murosco.size();i++)
				{
					if ((murosco.get(i).x==210 && murosco.get(i).y==20) ||(murosco.get(i).x==210 && murosco.get(i).y==425)){
						DrawMuroEspecial(murosco.get(i).x, murosco.get(i).y, murosco.get(i).w, murosco.get(i).h);
					}
				}
				
		
		
	}//end function
	
	//****************METODOS PRIVADOS
	private void DrawMuro(double x,double y,double w,double h){
		
		context.beginPath();
		ImageElement imageElement = ImageElement.as(img.getElement());
		context.drawImage(imageElement, x, y,w,h);
		context.closePath();
	}//end functions
	
private void DrawMuroEspecial(double x,double y,double w,double h){
		
		context.beginPath();
		ImageElement imageElement = ImageElement.as(imgEspecial.getElement());
		context.drawImage(imageElement, x, y,w,h);
		context.closePath();
	}//end functions

}//end class
