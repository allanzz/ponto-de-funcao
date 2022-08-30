package br.com.allan.pontodefuncao.classes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;

import br.com.allan.pontodefuncao.classes.TiposFuncoes.Funcao;
@Entity
public class Projeto {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String descricao;
	private String responsavel;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dataInicio;
	String tipoProjeto;
	String tipoContagem;
	private String artefato;
	private String comentarios;
	
	@OneToMany(mappedBy = "projeto" ,cascade=CascadeType.ALL)
   	private List<Funcao> funcoes;
	
	public Projeto() {
		funcoes=new ArrayList<>();
	}
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
	public String getResponsavel() {
		return responsavel;
	}
	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}
	public String getTipoProjeto() {
		return tipoProjeto;
	}
	public void setTipoProjeto(String tipoProjeto) {
		this.tipoProjeto = tipoProjeto;
	}
	public String getTipoContagem() {
		return tipoContagem;
	}
	public void setTipoContagem(String tipoContagem) {
		this.tipoContagem = tipoContagem;
	}
	public String getArtefato() {
		return artefato;
	}
	public void setArtefato(String artefato) {
		this.artefato = artefato;
	}
	public String getComentarios() {
		return comentarios;
	}
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
	public List<Funcao> getFuncoes() {
		return funcoes;
	}
	public void setFuncoes(List<Funcao> funcoes) {
		this.funcoes = funcoes;
	}
	public Date getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	public List<Funcao> getTarefas() {
		return funcoes;
	}
	public void setTarefas(List<Funcao> funcoes) {
		this.funcoes = funcoes;
	}	
	@Override
	public String toString() {
		return "Projeto [id=" + id + ", descricao=" + descricao + ", responsavel=" + responsavel + ", dataInicio="
				+ dataInicio + ", funcoes=" +funcoes + "]";
	}
	public void adicionarFuncao(Funcao funcao) {
		this.funcoes.add(funcao);		
	}

}
