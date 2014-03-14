package pck.client.pacman;

import java.util.ArrayList;

import pck.client.TCanvas;

import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.dom.client.ImageElement;
import com.google.gwt.user.client.ui.Image;

public class TLaberintoMuro {
			public class TMuro {
				
				public double x,y;
				public double w,h;
				
				public TMuro(double _x,double _y,double _w, double _h){
					x=_x;
					y=_y;
					w=_w;
					h=_h;
				}
			
			}//end class inner
			
	ArrayList<TMuro> muros;
	private TCanvas canvas;
	private Context2d context;
	private Image img;
	private Image imgtran;
	
	//*************PROPIEDADES
	public ArrayList<TMuro> getMuros() {
		return muros;
	}
	//*************CONSTRUCTOR
	public TLaberintoMuro(TCanvas _canvas){
		
		   canvas=_canvas;
		   context=canvas.getContext();
		   img=new Image("recPacman/roca.jpg");
		   imgtran=new Image("recPacman/transporte.jpg");
		   
		   //bordes
		   muros=new ArrayList<TMuro>();
		   muros.add(new TMuro(0,0, 410,10 ));
		   muros.add(new TMuro(0,450, 410,10));
		   muros.add(new TMuro(0,10,10,100));
		   muros.add(new TMuro(0,110,5,55)); // muro de transporte1
		   muros.add(new TMuro(0,150,10,440));
		   muros.add(new TMuro(400,10,10,100));
		   muros.add(new TMuro(405,110,5,55)); // muro de transporte2
		   muros.add(new TMuro(400,150,10,440));
		   
		   //horizontales prueba
		   muros.add(new TMuro(50,50, 310,10 ));
		   muros.add(new TMuro(50,400, 310,10 ));
		   muros.add(new TMuro(10,100,50,10 ));
		   muros.add(new TMuro(350,100, 50,10 )); 
		   muros.add(new TMuro(10,350,50,10 ));
		   muros.add(new TMuro(350,350, 50,10 ));
		   
		   muros.add(new TMuro(60,150, 50,10 ));
		   muros.add(new TMuro(300,150, 50,10 ));
		   muros.add(new TMuro(150,150, 110,10 ));
		   muros.add(new TMuro(60,300, 50,10 ));
		   muros.add(new TMuro(300,300, 50,10 ));
		   muros.add(new TMuro(150,300, 110,10 ));
		   
		   muros.add(new TMuro(150,200, 110,10 ));
		   muros.add(new TMuro(150,250, 110,10 ));
		  // muros.add(new TMuro(60,250, 50,10 ));
		   
		   
		   //muros.add(new TMuro(41,11,10,100));
		 //verticales prueba
		   muros.add(new TMuro(100,60, 10,50 ));
		   muros.add(new TMuro(200,60, 10,50 ));
		   muros.add(new TMuro(300,60, 10,50 ));
		   muros.add(new TMuro(100,350, 10,50 ));
		   muros.add(new TMuro(200,350, 10,50 ));
		   muros.add(new TMuro(300,350, 10,50 ));
		   
		   muros.add(new TMuro(50,110, 10,100 ));
		   muros.add(new TMuro(350,110, 10,100 ));
		   muros.add(new TMuro(50,250, 10,100 ));
		   muros.add(new TMuro(350,250, 10,100 ));
		   
		   muros.add(new TMuro(150,100, 10,60 ));
		   muros.add(new TMuro(250,100, 10,60 ));
		   muros.add(new TMuro(150,300, 10,60 ));
		   muros.add(new TMuro(250,300, 10,60 ));
		   
		   muros.add(new TMuro(100,200, 10,60 ));
		   muros.add(new TMuro(300,200, 10,60 ));
		   
		   muros.add(new TMuro(200,160, 10,50 ));  
		   muros.add(new TMuro(200,260, 10,50 ));
		   
		   muros.add(new TMuro(150,200, 100,50 ));//muro central
		   muros.add(new TMuro(250,200, 10,50 ));
		   
		   
		
		   
	}//end function
	//**************METODOS PUBLICOS
	public void DibujarMuros(){
		
			for(int i=0;i<muros.size();i++)
			{
				if ((muros.get(i).x==0 && muros.get(i).y ==110) || (muros.get(i).x==405 && muros.get(i).y ==110) ){
					DrawMuroTrans(muros.get(i).x, muros.get(i).y, muros.get(i).w, muros.get(i).h);
				}else{
				DrawMuro(muros.get(i).x, muros.get(i).y, muros.get(i).w, muros.get(i).h);
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
	
private void DrawMuroTrans(double x,double y,double w,double h){
		
		context.beginPath();
		
		ImageElement imageElement = ImageElement.as(imgtran.getElement());
		context.drawImage(imageElement, x, y,w,h);
		context.closePath();
	}//end functions

}//end class
