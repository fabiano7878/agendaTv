import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import br.com.agendatv.bean.Dia;
import br.com.agendatv.bean.Semana;
import br.com.agendatv.bean.Tarefa;
import br.com.agendatv.component.BotaoPostIt;

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
	
	public void telaPrincipal(){
		
		final Form form = new Form();
		form.setLayout(new BorderLayout());
		Style formStyle = form.getStyle();
		formStyle.setBgTransparency(255);
		
		Container container = new Container();
		container.setLayout(new BoxLayout(BoxLayout.X_AXIS));
		
		Semana semana = new Semana();		
		int cont = semana.getDias().size();
		String[] strDiaSemana = new String[7];
		boolean[] temAtividade = new boolean[7];
		DateFormat df = new SimpleDateFormat("EEE, dd MMM");
		for (int i = 0; i < cont; i++) {
			Dia dia = (Dia) semana.getDias().get(i);
			if (i == 0) {
				Date tarefa1 = new Date();
				Tarefa tarefa = new Tarefa("Evento Ginga Hackathon", tarefa1);
				dia.adicionarTafefa(tarefa);
			}
			if (i == 2) {
				Date tarefa2 = new Date();
				Tarefa tarefa = new Tarefa("Testar codigo", tarefa2);
				dia.adicionarTafefa(tarefa);
			}
			if (i == 5) {
				Date tarefa3 = new Date();
				Tarefa tarefa = new Tarefa("Compilar codigo", tarefa3);
				dia.adicionarTafefa(tarefa);
			}
			Calendar cal = Calendar.getInstance();
			cal.setTime(dia.getDia());
			strDiaSemana[i] = df.format(cal.getTime());
			if (dia.getTafefas().size() > 0) {
				temAtividade[i] = true;
			} else {
				temAtividade[i] = false;
			}
		}
		
		btn1 = new BotaoPostIt(strDiaSemana[0], temAtividade[0]);
		btn2 = new BotaoPostIt(strDiaSemana[1], temAtividade[1]);
		btn3 = new BotaoPostIt(strDiaSemana[2], temAtividade[2]);
		btn4 = new BotaoPostIt(strDiaSemana[3], temAtividade[3]);
		btn5 = new BotaoPostIt(strDiaSemana[4], temAtividade[4]);
		btn6 = new BotaoPostIt(strDiaSemana[5], temAtividade[5]);
		btn7 = new BotaoPostIt(strDiaSemana[6], temAtividade[6]);
		
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
