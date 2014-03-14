package pck.client;

import pck.client.pacman.TPrincipalPacman;
import com.google.gwt.media.client.Audio;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.AbsolutePanel;

import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;

import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Button;


import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;
public class TFrmInstrucciones extends Composite {	

	
	private Audio musicFondo;
	private int index;
	public TFrmInstrucciones() {
		
		
	
		AbsolutePanel absolutePanel = new AbsolutePanel();
		initWidget(absolutePanel);
		absolutePanel.setSize("410px", "110px");
		
			
		Label op1 = new Label("**Tiene un total de 5 vidas");
		absolutePanel.add(op1, 80, 0);
		op1.setSize("346px", "30px");
		
		Label op2 = new Label("**control del pacman con las direcciones del teclado");
		absolutePanel.add(op2,80, 20);
		op2.setSize("346px", "30px");
		
		Label op3 = new Label("**obtenga la puntuacion mas alta");
		absolutePanel.add(op3, 80, 40);
		op3.setSize("346px", "30px");
		
		Label op4 = new Label("**200 puntos por una comida");
		absolutePanel.add(op4, 80, 60);
		op4.setSize("346px", "30px");
		///musica
		musica();
		musicFondo.play(); 
		Button btnLimpiar = new Button("volver");
		btnLimpiar.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				
				musicFondo.pause();
				RootPanel.get("inst").remove(index);		
				PracticaPR12 reiniciar=new PracticaPR12();
				reiniciar.onModuleLoad();
			}
		});
		absolutePanel.add(btnLimpiar,180, 80);
		/////////////
	
		
	}	

	public void musica(){
		musicFondo=Audio.createIfSupported();
		musicFondo.setSrc("inicio.mp3");
	}
	
	
}//end class
