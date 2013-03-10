package br.com.agendatv.component;

import com.sun.dtv.lwuit.Container;
import com.sun.dtv.lwuit.Font;
import com.sun.dtv.lwuit.Label;
import com.sun.dtv.lwuit.layouts.BoxLayout;

public class DetalhePostIt extends Container {

	public DetalhePostIt(String descricao, String horario, String local) {
		this.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
		Font fontDescricao = Font.createSystemFont(Font.FACE_PROPORTIONAL, Font.STYLE_ITALIC, Font.SIZE_MEDIUM);
		Font fontHorario = Font.createSystemFont(Font.FACE_PROPORTIONAL, Font.STYLE_PLAIN, Font.SIZE_SMALL);
		Label label1 = new Label(descricao);
		label1.getStyle().setBgTransparency(0);
		label1.getStyle().setFont(fontDescricao);
		this.addComponent(label1);
		Label label2 = new Label("\t"+horario);
		label2.getStyle().setBgTransparency(0);
		label2.getStyle().setFont(fontHorario);
		this.addComponent(label2);
		Label label3 = new Label(local);
		label3.getStyle().setBgTransparency(0);
		label3.getStyle().setFont(fontHorario);
		this.addComponent(label3);
	}
}
