package pck.client;



import pck.client.pacman.TPrincipalPacman;
import com.google.gwt.media.client.Audio;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.canvas.dom.client.CssColor;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.i18n.client.NumberFormat;

public class TFrmInicio extends Composite {
	
	

	
	private Audio musicFondo;
	private int index;
	
	public TFrmInicio() {
		
		
	
		AbsolutePanel absolutePanel = new AbsolutePanel();
		initWidget(absolutePanel);
		absolutePanel.setSize("410px", "100px");
		musica();
		musicFondo.play();
	
		Button btnAadir = new Button("iniciar juego");
		btnAadir.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {	
				musicFondo.pause();
				RootPanel.get("inicio").remove(index);//quitamos la tabla1				
			
		
				TCanvas canvas=new TCanvas();
			    TFrmNivel inst=new TFrmNivel(canvas);
				RootPanel.get("inst").add(inst);			
				
			
			
			}
		});
		absolutePanel.add(btnAadir, 180, 20);	
		
		Button btnLimpiar = new Button("instrucciones");
		btnLimpiar.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {			
				musicFondo.pause();
				RootPanel.get("inicio").remove(index);//quitamos la tabla1				
				TCanvas canvas=new TCanvas();
			    TFrmInstrucciones inst=new TFrmInstrucciones();
				RootPanel.get("inst").add(inst);			
			
				//cargamos formulario en salir de la tabla2		
				
			}
		});
		absolutePanel.add(btnLimpiar,180, 60);
	}	
	public void  Ejecutar(){
	
	}//end function
	public void musica(){
		musicFondo=Audio.createIfSupported();
		musicFondo.setSrc("inicio.mp3");
	}
	
	
	
}//end class
