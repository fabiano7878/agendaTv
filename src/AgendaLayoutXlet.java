import java.io.IOException;

import com.sun.dtv.lwuit.Button;
import com.sun.dtv.lwuit.Form;
import com.sun.dtv.lwuit.Image;
import com.sun.dtv.lwuit.Label;
import com.sun.dtv.lwuit.layouts.BorderLayout;
import com.sun.dtv.lwuit.plaf.Style;


public class AgendaLayoutXlet {
	
	public void telaPrincipal(){
	final Form f = new Form();
	
	BorderLayout layout = new BorderLayout();
	
	//GridLayout layout = new GridLayout(1,3);
	
	f.setLayout(layout);
	 Style formStyle = f.getStyle();
	 formStyle.setBgTransparency(255);
	Button btn = new Button("submit");
	Label l1 = new Label("Titulo");
	Label l2 = new Label("Funcoes");
	Label l3 = new Label("Funcoes");
	Label l4 = new Label();
	
	
	 Image image;
	try {
		image = Image.createImage("image/BG.png");
		l4.setIcon(image);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	
	
	
//	Component[] comps = {l1};
//	for(int cmpIdx = 0;cmpIdx<comps.length;cmpIdx++) {
//		Component cmp = comps[cmpIdx];
//		f.addComponent(cmp);
//	}
	
	f.addComponent(BorderLayout.CENTER, l4);
	//f.addComponent(BorderLayout.EAST, l2);
	//f.addComponent(BorderLayout.WEST, l3);
	//f.addComponent(BorderLayout.NORTH, l1);
	//f.addComponent(BorderLayout.SOUTH, btn);
	
	f.show();
	
	}
}
