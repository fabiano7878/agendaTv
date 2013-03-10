package br.com.agendatv.bean;

import java.util.Date;

public class Tarefa {

	private String descricao;
	private String local;
	private Date horario;
	
	// TODO: Atributo de foto
	
	public Tarefa(String descricao, Date horario) {
		this.descricao = descricao;
		this.horario = horario;
	}
	
	public Tarefa(String descricao, String local, Date horario) {
		this.descricao = descricao;
		this.local = local;
		this.horario = horario;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		return result;
	}
	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tarefa other = (Tarefa) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		return true;
	}
	
	public boolean isTarefaValida() {
		return !(this.getDescricao() == null || this.getHorario() == null);
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public Date getHorario() {
		return horario;
	}
	public void setHorario(Date horario) {
		this.horario = horario;
	}

	public String toString() {
		return "Tarefa [descricao=" + descricao + ", horario=" + horario
				+ ", local=" + local + "]";
	}
}