package pck.client;



import pck.client.pacman.TPrincipalPacman;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.canvas.dom.client.CssColor;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.i18n.client.NumberFormat;

public class TFrmNivel extends Composite {
	private ListBox lista;

	private String op1,op2,op3;
	private int index;
	public TFrmNivel(TCanvas _canvas) {
		

	
		AbsolutePanel absolutePanel = new AbsolutePanel();
		initWidget(absolutePanel);
		absolutePanel.setSize("374px", "100px");		
		
		Label lblAxbyc = new Label("ELIJA NIVEL:");
		absolutePanel.add(lblAxbyc, 140, 10);
		lblAxbyc.setSize("346px", "30px");
		//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
		
		//xxxxxxxxxxxxxxxxxxxx
		lista = new ListBox();	
		lista.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				if(index!=-1){
					
					index=lista.getSelectedIndex();
				}
				else{
					index=lista.getSelectedIndex();	
				}
			}
		});
		lista.addItem("facil");
		lista.addItem("medio");
		lista.addItem("dificil");
		absolutePanel.add(lista, 100, 50);
		lista.setSize("80px", "30px");
		//xxxxxxxxxxxxx
		Button btnAadir = new Button("aceptar");
		btnAadir.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {			
					if(index==-1)
						Window.alert("seleccione una opcion");
					else
						Escoger();				
			}
		});
		absolutePanel.add(btnAadir, 200,50);
		
		
	}
	public ListBox getLista() {
		return lista;
	}
	public void Escoger() {
	
		
		
		switch(index){
			case 0:
				if(op1!=null){
					Window.alert("no eligio opcion "); 
				}
				else{
					Window.alert("selecciono nivel facil ");
					 RootPanel.get("inst").remove(0);
					TPrincipalPacman _pacman=new TPrincipalPacman(1);
					//cargamos el pacman en el contenedor de la tabla2
					RootPanel.get("nivel1").add(_pacman.getCanvas()); 			
					_pacman.Ejecutar(50,100);		
			
				}			
			break;
			case 1:
				  
				if(op2!=null){
					Window.alert("no eligio opcion "); 
				}
				else{
					Window.alert("selecciono nivel medio ");	
					 RootPanel.get("inst").remove(0);
						TPrincipalPacman _pacman=new TPrincipalPacman(2);
						//cargamos el pacman en el contenedor de la tabla2
						RootPanel.get("nivel2").add(_pacman.getCanvas()); 
						_pacman.Ejecutar(50,75);		
					
				}
				
						
				break;
			case 2:
				  
				if(op3!=null){
					Window.alert("no eligio opcion "); 
				}else{
					Window.alert("selecciono nivel dificil ");	
					 RootPanel.get("inst").remove(0);
						TPrincipalPacman _pacman=new TPrincipalPacman(3);
						//cargamos el pacman en el contenedor de la tabla2
						RootPanel.get("nivel3").add(_pacman.getCanvas()); 
						_pacman.Ejecutar(50,50);		
					
				}
				
						
				break;
	}
	}
	
}//end class

