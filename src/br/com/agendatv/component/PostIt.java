package br.com.agendatv.component;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import br.com.agendatv.bean.Tarefa;

import com.sun.dtv.lwuit.Container;
import com.sun.dtv.lwuit.Font;
import com.sun.dtv.lwuit.Form;
import com.sun.dtv.lwuit.Image;
import com.sun.dtv.lwuit.Label;
import com.sun.dtv.lwuit.events.ActionEvent;
import com.sun.dtv.lwuit.events.ActionListener;
import com.sun.dtv.lwuit.geom.Dimension;
import com.sun.dtv.lwuit.layouts.BoxLayout;
import com.sun.dtv.lwuit.layouts.FlowLayout;
import com.sun.dtv.ui.event.RemoteControlEvent;


public class PostIt extends Form {
	
	public PostIt(String titulo, List tarefas){
		
		this.setLayout(new FlowLayout(CENTER));
		this.getStyle().setBgTransparency(0);
		
		Container container = new Container();
		container.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
		
		try {
			Image image = Image.createImage("image/panel.png");
			container.getStyle().setBgImage(image);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		container.setPreferredSize(new Dimension(550,550));
		DateFormat df = new SimpleDateFormat("HH:mm");
		Font font = Font.createSystemFont(Font.FACE_PROPORTIONAL, Font.STYLE_BOLD, Font.SIZE_LARGE);
		Label label = new Label(titulo);
		label.getStyle().setFont(font);
		label.getStyle().setBgTransparency(0);
		container.addComponent(label);
		for (int i = 0; i < tarefas.size(); i++) {
			Tarefa tarefa = (Tarefa) tarefas.get(i);
			DetalhePostIt detalhe = new DetalhePostIt(tarefa.getDescricao(),df.format(tarefa.getHorario()),tarefa.getLocal());
			container.addComponent(detalhe);
		}
		
		this.addComponent(container);
	
		addKeyListener(RemoteControlEvent.VK_COLORED_KEY_0, new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				new AgendaLayoutXlet();
			}
		});
	}
	
}
