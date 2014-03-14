package pck.client;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

public class TCanvas{
	static final int height = 460;
	static final int width = 410;
	
	private Canvas canvas;
	private Context2d context;
	
	//*****PROPIEDADES*****
	public Context2d getContext() {
		return context;
	}
	public Canvas getCanvas() {
		return canvas;
	}
	//*****CONSTRUCTOR*****
	public TCanvas()
	{
		createCanvas();
	}
	
	//*****METODOS*****
	
	private void createCanvas(){
		   
		 canvas = Canvas.createIfSupported();
		  if (canvas == null) {
		        RootPanel.get().add(new Label("Tu Buscador no Soporta HTML5"));
		        return;
		  }
	     canvas.setWidth(width + "px");
	     canvas.setHeight(height + "px");
	     canvas.setCoordinateSpaceWidth(width);
	     canvas.setCoordinateSpaceHeight(height);
	      
	     context = canvas.getContext2d();
	           
	 }//end function

}//end class
