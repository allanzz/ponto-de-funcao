package br.com.allan.pontodefuncao.classes.TiposFuncoes;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import br.com.allan.pontodefuncao.classes.Projeto;
import br.com.allan.pontodefuncao.classes.TipoComplexidade;

@Entity
@DiscriminatorValue(value = "AIE")
public class ArquivoInterfaceExterna extends Funcao {
	
	TipoComplexidade tipoComplexidade=null;	
	public ArquivoInterfaceExterna(Projeto projeto) {
		this.projeto = projeto;
	}
	public ArquivoInterfaceExterna() {}
	@Override
	public TipoComplexidade CalcularComplexidade() {		
		this.tipoComplexidade = verificaFaixaRLR()==1&&verificarFaixaDer()==1?TipoComplexidade.SIMPLES:tipoComplexidade;
		this.tipoComplexidade = verificaFaixaRLR()==1&&verificarFaixaDer()==2?TipoComplexidade.SIMPLES:tipoComplexidade;
		this.tipoComplexidade = verificaFaixaRLR()==1&&verificarFaixaDer()==3?TipoComplexidade.MEDIA:tipoComplexidade;
		this.tipoComplexidade = verificaFaixaRLR()==2&&verificarFaixaDer()==1?TipoComplexidade.SIMPLES:tipoComplexidade;
		this.tipoComplexidade = verificaFaixaRLR()==2&&verificarFaixaDer()==2?TipoComplexidade.MEDIA:tipoComplexidade;
		this.tipoComplexidade = verificaFaixaRLR()==2&&verificarFaixaDer()==3?TipoComplexidade.COMPLEXA:tipoComplexidade;
		this.tipoComplexidade = verificaFaixaRLR()==3&&verificarFaixaDer()==1?TipoComplexidade.MEDIA:tipoComplexidade;
		this.tipoComplexidade = verificaFaixaRLR()==3&&verificarFaixaDer()==2?TipoComplexidade.COMPLEXA:tipoComplexidade;
		this.tipoComplexidade = verificaFaixaRLR()==3&&verificarFaixaDer()==3?TipoComplexidade.COMPLEXA:tipoComplexidade;
		return this.tipoComplexidade;
		
	}
	public double calcularPontosDeFuncao() {
		this.pontosDeFuncao=tipoComplexidade==TipoComplexidade.SIMPLES?5:this.pontosDeFuncao;
		this.pontosDeFuncao=tipoComplexidade==TipoComplexidade.MEDIA?7:this.pontosDeFuncao;
		this.pontosDeFuncao=tipoComplexidade==TipoComplexidade.COMPLEXA?10:this.pontosDeFuncao;
		return this.pontosDeFuncao;
	}	
	public int verificaFaixaRLR() {
		if(this.getRlr()>=2&&this.getRlr()<=5) {
			return 2;
		}
		if(this.getRlr()>=51) {
			return 3;
		}
		return 1;
	}
	public int verificarFaixaDer() {
		if(this.getDer()>=1&&this.getDer()<=19) {
			return 1;
		}
		if(this.getDer()>=20&&this.getDer()<=50) {
			return 2 ;
		}
		if(this.getDer()>=51) {
			return 3 ;
		}
		return 0;
	}

}
