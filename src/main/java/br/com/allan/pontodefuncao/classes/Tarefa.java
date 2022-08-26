package br.com.allan.pontodefuncao.classes;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Tarefa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String descricao;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="categoria_id")
	private CategoriaTarefa categoria;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "projeto_id")
	private Projeto projeto;	
	public String getRecursoResponsavel() {
		return recursoResponsavel;
	}
	private String recursoResponsavel;	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setRecursoResponsavel(String recursoResponsavel) {
		this.recursoResponsavel = recursoResponsavel;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public CategoriaTarefa getCategoria() {
		return categoria;
	}
	public void setCategoria(CategoriaTarefa categoria) {
		this.categoria = categoria;
	}
	public Projeto getProjeto() {
		return projeto;
	}
	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}
	@Override
	public String toString() {
		return "Tarefa [id=" + id + ", descricao=" + descricao + ", categoria=" + categoria + "]";
	}
}
