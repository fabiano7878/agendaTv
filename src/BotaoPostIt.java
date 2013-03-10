import java.io.IOException;
import java.util.Date;

import com.sun.dtv.lwuit.Button;
import com.sun.dtv.lwuit.Command;
import com.sun.dtv.lwuit.Component;
import com.sun.dtv.lwuit.Font;
import com.sun.dtv.lwuit.Graphics;
import com.sun.dtv.lwuit.Image;
import com.sun.dtv.lwuit.events.FocusListener;
import com.sun.dtv.lwuit.geom.Dimension;
import com.sun.dtv.lwuit.plaf.Border;


public class BotaoPostIt extends Button {
	private Image normal, alt;
	public BotaoPostIt(String title, boolean haveTasks){
		super(title);
		try {
			if (haveTasks) {
				normal = Image.createImage("image/postit.png");
				alt = Image.createImage("image/postitAlt.png");
			} else {
				normal = Image.createImage("image/postitNormal.png");
				alt = Image.createImage("image/postitNormalAlt.png");
				this.setEnabled(false);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.getStyle().setBgImage(this.normal);
		this.getStyle().setBorder(new Border());
		Font font = Font.createSystemFont(Font.FACE_PROPORTIONAL, Font.STYLE_BOLD, Font.SIZE_MEDIUM);
		this.setVerticalAlignment(VERTICAL_ALIGN_TOP);
		this.getStyle().setFont(font);
		this.setWidth(200);
		this.setHeight(200);
		this.setPreferredSize(new Dimension(200,200));
		this.getStyle().setBgTransparency(255);
		this.addFocusListener(new FocusListener() {
			
			public void focusLost(Component c) {
				c.getStyle().setBgImage(normal);
			}
			
			public void focusGained(Component c) {
				c.getStyle().setBgImage(alt);
			}
		});
	}

}
