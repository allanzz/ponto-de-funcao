package br.com.allan.pontodefuncao.classes.TiposFuncoes;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import br.com.allan.pontodefuncao.classes.Projeto;
import br.com.allan.pontodefuncao.classes.TipoComplexidade;

/**
 * Classe para calcular a complexidade e calcular o total de pontos de função de uma Saida Externa
 * @author Allan da Silva
 */

@Entity
@DiscriminatorValue(value = "SE")
public class SaidaExterna extends Funcao {
	
	
	public SaidaExterna(Projeto projeto) {
		this.projeto=projeto;	
	}
	public SaidaExterna() {}
	@Override
	public TipoComplexidade calcularComplexidade() {
		if(this.tipoDeContagem.equals("Detalhada")) {
		TipoComplexidade tipoComplexidade=null;
		tipoComplexidade = verificaFaixaRLR()==1&&verificarFaixaDer()==1?TipoComplexidade.SIMPLES:tipoComplexidade;
		tipoComplexidade = verificaFaixaRLR()==1&&verificarFaixaDer()==2?TipoComplexidade.SIMPLES:tipoComplexidade;
		tipoComplexidade = verificaFaixaRLR()==1&&verificarFaixaDer()==3?TipoComplexidade.MEDIA:tipoComplexidade;
		tipoComplexidade = verificaFaixaRLR()==2&&verificarFaixaDer()==1?TipoComplexidade.SIMPLES:tipoComplexidade;
		tipoComplexidade = verificaFaixaRLR()==2&&verificarFaixaDer()==2?TipoComplexidade.MEDIA:tipoComplexidade;
		tipoComplexidade = verificaFaixaRLR()==2&&verificarFaixaDer()==3?TipoComplexidade.COMPLEXA:tipoComplexidade;
		tipoComplexidade = verificaFaixaRLR()==3&&verificarFaixaDer()==1?TipoComplexidade.MEDIA:tipoComplexidade;
		tipoComplexidade = verificaFaixaRLR()==3&&verificarFaixaDer()==2?TipoComplexidade.COMPLEXA:tipoComplexidade;
		tipoComplexidade = verificaFaixaRLR()==3&&verificarFaixaDer()==3?TipoComplexidade.COMPLEXA:tipoComplexidade;
		return tipoComplexidade;	
		}else {
			return TipoComplexidade.MEDIA;
		}
	}
	public double calcularPontosDeFuncao() {
		this.pontosDeFuncao=calcularComplexidade()==TipoComplexidade.SIMPLES?4:this.pontosDeFuncao;
		this.pontosDeFuncao=calcularComplexidade()==TipoComplexidade.MEDIA?5:this.pontosDeFuncao;
		this.pontosDeFuncao=calcularComplexidade()==TipoComplexidade.COMPLEXA?7:this.pontosDeFuncao;
		calcularPontosDeFuncaoImpactado();
		return this.pontosDeFuncao;
		
	}
	public int verificaFaixaRLR() {
		if(this.getRlr()==0||this.getRlr()==1) {
			return 1;
		}
		if(this.getRlr()==2||this.getRlr()==3) {
			return 2;
		}
		if(this.getRlr()>=4) {
			return 3;
		}
		return 0;
	}
	public int verificarFaixaDer() {
		if(this.getDer()>=1&&this.getDer()<=5) {
			return 1;
		}
		if(this.getDer()>=6&&this.getDer()<=19) {
			return 2 ;
		}
		if(this.getDer()>=20) {
			return 3 ;
		}
		return 0;
	}
	}
