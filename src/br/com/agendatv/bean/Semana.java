package br.com.agendatv.bean;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Semana {
	
	private static final int QTDE_DIAS_DA_SEMANA = 7;
	
	private List dias;
	
	public Semana() {
		this.dias = new ArrayList();
		
		Calendar hoje = Calendar.getInstance();
		
		this.getDias().add(new Dia(hoje.getTime()));
		
		for (int dia = 0; dia < (QTDE_DIAS_DA_SEMANA - 1); dia++) {
			hoje.add(Calendar.DAY_OF_MONTH, 1);
			Calendar amanha = (Calendar) hoje.clone();
			this.getDias().add(new Dia(amanha.getTime()));
		}
	}

	public List getDias() {
		return dias;
	}

//	public String toString() {
//		
//		StringBuilder sb = new StringBuilder("Semana [dias=");
//		
//		for (int dia = 0, totaldias = dias.size(); dia < totaldias; dia++) {
//			sb.append(dias.get(dia) + "\n");
//		}
//		
//		sb.append("]");
//		
//		return sb.toString();
//	}	
}