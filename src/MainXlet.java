

import java.io.IOException;

import javax.microedition.xlet.Xlet;
import javax.microedition.xlet.XletContext;
import javax.microedition.xlet.XletStateChangeException;

public class MainXlet implements Xlet {

	public void destroyXlet(boolean arg0) throws XletStateChangeException {
	}

	public void initXlet(XletContext arg0) throws XletStateChangeException {
	}

	public void pauseXlet() {
	}

	public void startXlet() throws XletStateChangeException {
		
		AgendaLayoutXlet agenda = new AgendaLayoutXlet();
		
		agenda.telaPrincipal();
		
	}
	
	

}
