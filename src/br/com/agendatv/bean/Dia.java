package br.com.agendatv.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Dia {
	
	private Date dia;
	
	private List tafefas;
	
	public Dia(Date dia) {
		this.dia = dia;
		this.tafefas = new ArrayList();
	}

	public List getTafefas() {
		return tafefas;
	}

	public boolean adicionarTafefa(Tarefa tarefa) {
		if (tarefa == null) throw new IllegalArgumentException("Tarefa nao pode ser vazia.");
		
		if (tarefa.isTarefaValida()) {
			return this.tafefas.add(tarefa);
		}
		
		return false;
	}
	
	public boolean removerTarefa(Tarefa tarefa) {
		if (tarefa == null) throw new IllegalArgumentException("Tarefa nao pode ser vazia.");
		
		if (tarefa.isTarefaValida()) {
			return this.tafefas.remove(tarefa);
		}
		
		return false;
	}

	public Date getDia() {
		Date other = (Date) dia.clone();		
		return other;
	}
	
	public String toString() {
		return getDia().toString();
	}
}