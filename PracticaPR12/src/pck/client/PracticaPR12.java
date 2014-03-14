package pck.client;

import pck.client.pacman.TPrincipalPacman;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.RootPanel;


public class PracticaPR12 implements EntryPoint {

	public void onModuleLoad() {		
	
		/////////////////////////////
		 TCanvas canvas=new TCanvas();
		    TFrmInicio _frm=new TFrmInicio();
		    RootPanel.get("inicio").add(_frm);			
			_frm.Ejecutar();
		////////////
		
		
	    ////////////////
		
	}//END FUNCTION
	
}//END CLASS
