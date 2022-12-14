package br.com.allan.pontodefuncao.classes.TiposFuncoes;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;

import br.com.allan.pontodefuncao.classes.Deflator;
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
	private String responsavel;
	private Integer rlr_alr=1;
	@Column(nullable = true)
	private Integer der=1;
	private String tipoDeFuncao;
	protected String tipoDeContagem;
	@OneToOne
	@JoinColumn(name = "deflator_id")
	private Deflator deflator;
	@Column(insertable = false, updatable = false)
	private String tipo;
	protected double pontosDeFuncao;
	protected double pontoDeFuncaoImpactado;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "projeto_id")
	Projeto projeto;
	private String status = "pendente";
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dataConclusao;

	public Funcao(Projeto projeto) {
		super();
		this.projeto = projeto;
	}

	public Funcao() {
	}

	public double getPontoDeFuncaoImpactado() {
		return pontoDeFuncaoImpactado;
	}

	private int idDeflator;

	public int getIdDeflator() {
		return idDeflator;
	}

	public void setIdDeflator(int idDeflator) {
		this.idDeflator = idDeflator;
	}

	public Deflator getDeflator() {
		return deflator;
	}

	public void setDeflator(Deflator deflator) {
		this.deflator = deflator;
	}

	public String getTipoDeContagem() {
		return tipoDeContagem;
	}

	public void setTipoDeContagem(String tipoDeContagem) {
		this.tipoDeContagem = tipoDeContagem;
	}

	public double getPontosDeFuncao() {
		return pontosDeFuncao;
	}

	public Integer getRlr_alr() {
		return rlr_alr;
	}

	public void setRlr_alr(Integer rlr_alr) {
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

	public Integer getRlr() {
		return rlr_alr;
	}

	public void setRlr(Integer rlr) {
		this.rlr_alr = rlr;
	}

	public Integer getDer() {
		return der;
	}

	public void setDer(Integer der) {
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public TipoComplexidade calcularComplexidade() {
		return null;
	}

	public double calcularPontosDeFuncao() {
		return 0.00;
	}
	public void calcularPontosDeFuncaoImpactado() {
		pontoDeFuncaoImpactado = this.pontosDeFuncao * this.getDeflator().getValor();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		/*
		 * if (!this.getClass().isAssignableFrom(obj.getClass())) return false;
		 */
		Funcao other = (Funcao) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Funcao [id=" + id + ", descricao=" + descricao + ", responsavel=" + responsavel + ", rlr_alr=" + rlr_alr
				+ ", der=" + der + ", tipoDeFuncao=" + tipoDeFuncao + ", tipoDeContagem=" + tipoDeContagem
				+ ", deflator=" + deflator + ", tipo=" + tipo + ", pontosDeFuncao=" + pontosDeFuncao
				+ ", pontoDeFuncaoImpactado=" + pontoDeFuncaoImpactado + ", projeto=" + projeto.getDescricao() + ", status=" + status
				+ ", idDeflator=" + idDeflator + "]";
	}

	public Date getDataConclusao() {
		return dataConclusao;
	}

	public void setDataConclusao(Date dataConclusao) {
		this.dataConclusao = dataConclusao;
	}
	public String getDataConclusaoFormatada() {
		if(this.dataConclusao!=null) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-d");
		return df.format(this.dataConclusao);
		}else {
			return null;
		}
		
	}
	
	

}
