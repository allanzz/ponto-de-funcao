package br.com.allan.pontodefuncao.classes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CategoriaTarefa {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String descricao;
	private double pontoDeFuncao;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getPontoDeFuncao() {
		return pontoDeFuncao;
	}
	public void setPontoDeFuncao(double pontoDeFuncao) {
		this.pontoDeFuncao = pontoDeFuncao;
	}
	@Override
	public String toString() {
		return "CategoriaTarefa [id=" + id + ", descricao=" + descricao + ", pontoDeFuncao=" + pontoDeFuncao + "]";
	}
}
