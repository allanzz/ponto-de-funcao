package br.com.allan.pontodefuncao.classes;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
public class Recurso {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String nome;
	private String funcao;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataInicio;
	public Recurso(String nome, String funcao) {
		this.nome = nome;
		this.funcao = funcao;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getFuncao() {
		return funcao;
	}
	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
	public LocalDate getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}
	@Override
	public String toString() {
		return "Recurso [id=" + id + ", nome=" + nome + ", funcao=" + funcao + ", dataInicio=" + dataInicio + "]";
	} 
}
