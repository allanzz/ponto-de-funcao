package br.com.allan.pontodefuncao.classes.TiposFuncoes;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.allan.pontodefuncao.classes.Projeto;
import br.com.allan.pontodefuncao.classes.TipoComplexidade;
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo", length = 3, discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("")
public class Funcao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String descricao;
	String responsavel;
	private int rlr_alr;
	private int der;
	private String tipoDeFuncao;
	protected String tipoDeContagem;
	public String getTipoDeContagem() {
		return tipoDeContagem;
	}
	public void setTipoDeContagem(String tipoDeContagem) {
		this.tipoDeContagem = tipoDeContagem;
	}
	public double getPontosDeFuncao() {
		return pontosDeFuncao;
	}
	@Column(insertable=false, updatable=false)
    private String tipo;
	protected double pontosDeFuncao;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "projeto_id")
	Projeto projeto;
	public Funcao(Projeto projeto) {
		super();
		this.projeto = projeto;
	}
	public Funcao(){}
	public int getRlr_alr() {
		return rlr_alr;
	}
	public void setRlr_alr(int rlr_alr) {
		this.rlr_alr = rlr_alr;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
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
	public int getRlr() {
		return rlr_alr;
	}
	public void setRlr(int rlr) {
		this.rlr_alr = rlr;
	}
	public int getDer() {
		return der;
	}
	public void setDer(int der) {
		this.der = der;
	}
	public Projeto getProjeto() {
		return projeto;
	}
	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}
	public String getResponsavel() {
		return responsavel;
	}
	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}
	public String getTipoDeFuncao() {
		return tipoDeFuncao;
	}
	public void setTipoDeFuncao(String tipoDeFuncao) {
		this.tipoDeFuncao = tipoDeFuncao;
	}
	public TipoComplexidade calcularComplexidade() {
		return null;
	}
	public double calcularPontosDeFuncao() {
		return 0.00;
	}

}
