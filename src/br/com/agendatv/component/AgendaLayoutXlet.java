package br.com.agendatv.component;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import br.com.agendatv.bean.Dia;
import br.com.agendatv.bean.Semana;
import br.com.agendatv.bean.Tarefa;

import com.sun.dtv.lwuit.Button;
import com.sun.dtv.lwuit.Form;
import com.sun.dtv.lwuit.layouts.BorderLayout;
import com.sun.dtv.lwuit.layouts.BoxLayout;
import com.sun.dtv.lwuit.plaf.Style;
import com.sun.dtv.lwuit.Container;


public class AgendaLayoutXlet {
	
	private Button btn1;
	private Button btn2;
	private Button btn3;
	private Button btn4;
	private Button btn5;
	private Button btn6;
	private Button btn7;
	
	public AgendaLayoutXlet(){
		
		final Form form = new Form();
		form.setLayout(new BorderLayout());
		Style formStyle = form.getStyle();
		formStyle.setBgTransparency(0);
		
		Container container = new Container();
		container.setLayout(new BoxLayout(BoxLayout.X_AXIS));
		
		Semana semana = new Semana();		
		int cont = semana.getDias().size();
		String[] strDiaSemana = new String[7];
		List[] tarefas = new List[7];
		DateFormat df = new SimpleDateFormat("EEE, dd MMM");
		for (int i = 0; i < cont; i++) {
			Dia dia = (Dia) semana.getDias().get(i);
			if (i == 0) {
				Date data1 = new Date();
				Tarefa tarefa = new Tarefa("Evento Ginga Hackathon", data1);
				dia.adicionarTafefa(tarefa);
			}
			if (i == 2) {
				Date data2 = new Date();
				Tarefa tarefa = new Tarefa("Testar codigo", data2);
				dia.adicionarTafefa(tarefa);
				Date data3 = new Date();
				Tarefa tarefa2 = new Tarefa("Compilar codigo", data3);
				dia.adicionarTafefa(tarefa2);
			}
			if (i == 5) {
				Date data4 = new Date();
				Tarefa tarefa = new Tarefa("Implantar projeto", data4);
				dia.adicionarTafefa(tarefa);
			}
			Calendar cal = Calendar.getInstance();
			cal.setTime(dia.getDia());
			strDiaSemana[i] = df.format(cal.getTime());
			tarefas[i] = dia.getTafefas();
			
		}
		
		btn1 = new BotaoPostIt(strDiaSemana[0], tarefas[0]);
		btn2 = new BotaoPostIt(strDiaSemana[1], tarefas[1]);
		btn3 = new BotaoPostIt(strDiaSemana[2], tarefas[2]);
		btn4 = new BotaoPostIt(strDiaSemana[3], tarefas[3]);
		btn5 = new BotaoPostIt(strDiaSemana[4], tarefas[4]);
		btn6 = new BotaoPostIt(strDiaSemana[5], tarefas[5]);
		btn7 = new BotaoPostIt(strDiaSemana[6], tarefas[6]);
		
		container.addComponent(btn1);
		container.addComponent(btn2);
		container.addComponent(btn3);
		container.addComponent(btn4);
		container.addComponent(btn5);
		container.addComponent(btn6);
		container.addComponent(btn7);
		form.addComponent(BorderLayout.SOUTH, container);
		form.show();
	
	}
}
