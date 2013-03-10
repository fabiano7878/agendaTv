package br.com.agendatv.component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.sun.dtv.lwuit.Button;
import com.sun.dtv.lwuit.Component;
import com.sun.dtv.lwuit.Font;
import com.sun.dtv.lwuit.Image;
import com.sun.dtv.lwuit.events.ActionEvent;
import com.sun.dtv.lwuit.events.ActionListener;
import com.sun.dtv.lwuit.events.FocusListener;
import com.sun.dtv.lwuit.geom.Dimension;
import com.sun.dtv.lwuit.plaf.Border;


public class BotaoPostIt extends Button {
	private Image normal, alt;
	private String titulo;
	private List tarefas = new ArrayList();
	
	public BotaoPostIt(String title, List tasks){
		super(title);
		titulo = title;
		tarefas = tasks;
		try {
			if (tasks.size() > 0) {
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
		this.setPreferredSize(new Dimension(179,179));
		this.getStyle().setBgTransparency(0);
		this.addFocusListener(new FocusListener() {
			
			public void focusLost(Component c) {
				c.getStyle().setBgImage(normal);
			}
			
			public void focusGained(Component c) {
				c.getStyle().setBgImage(alt);
			}
		});
		this.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				PostIt postIt = new PostIt(titulo, tarefas);
				postIt.show();
			}
		});
	}

}
