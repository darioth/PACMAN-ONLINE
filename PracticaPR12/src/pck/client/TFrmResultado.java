package pck.client;

import pck.client.pacman.TPrincipalPacman;


import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.HTML;

import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;

import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Button;


import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;
public class TFrmResultado extends Composite {	

	
	private int index;
	public TFrmResultado() {		
		
	
		AbsolutePanel absolutePanel = new AbsolutePanel();
		initWidget(absolutePanel);
		absolutePanel.setSize("410px", "100px");
		
			
		Label lblAxbyc = new Label("RESULTADOS OBTENIDOS:");
		absolutePanel.add(lblAxbyc, 130, 30);
		lblAxbyc.setSize("346px", "30px");
	
		Button btnLimpiar = new Button("volver a menu");
		btnLimpiar.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				RootPanel.get("inst").remove(index);
				RootPanel.get("mio").clear();	
				RootPanel.get("miooooo").clear();	
				RootPanel.get("m").clear();	
				PracticaPR12 reiniciar=new PracticaPR12();
				reiniciar.onModuleLoad();
			}
		});
		absolutePanel.add(btnLimpiar,180, 60);
		/////////////
		
	}	

	
	
	
}//end class
