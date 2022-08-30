package br.com.allan.pontodefuncao.classes.TiposFuncoes;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import br.com.allan.pontodefuncao.classes.Projeto;
import br.com.allan.pontodefuncao.classes.TipoComplexidade;

@Entity
@DiscriminatorValue(value = "EE")
public class EntradaExterna extends Funcao{
	public EntradaExterna(Projeto projeto) {
		this.projeto =  projeto;	
	}
	public EntradaExterna() {}
	TipoComplexidade tipo=null;
	@Override
	public TipoComplexidade CalcularComplexidade() {		
		tipo = verificaFaixaRLR()==1&&verificarFaixaDer()==1?TipoComplexidade.SIMPLES:tipo;
		tipo = verificaFaixaRLR()==1&&verificarFaixaDer()==2?TipoComplexidade.SIMPLES:tipo;
		tipo = verificaFaixaRLR()==1&&verificarFaixaDer()==3?TipoComplexidade.MEDIA:tipo;
		tipo = verificaFaixaRLR()==2&&verificarFaixaDer()==1?TipoComplexidade.SIMPLES:tipo;
		tipo = verificaFaixaRLR()==2&&verificarFaixaDer()==2?TipoComplexidade.MEDIA:tipo;
		tipo = verificaFaixaRLR()==2&&verificarFaixaDer()==3?TipoComplexidade.COMPLEXA:tipo;
		tipo = verificaFaixaRLR()==3&&verificarFaixaDer()==1?TipoComplexidade.MEDIA:tipo;
		tipo = verificaFaixaRLR()==3&&verificarFaixaDer()==2?TipoComplexidade.COMPLEXA:tipo;
		tipo = verificaFaixaRLR()==3&&verificarFaixaDer()==3?TipoComplexidade.COMPLEXA:tipo;
		return tipo;		
	}
	public double calculaPontosDeFuncao() {
		this.pontosDeFuncao=tipo==TipoComplexidade.SIMPLES?3:this.pontosDeFuncao;
		this.pontosDeFuncao=tipo==TipoComplexidade.MEDIA?4:this.pontosDeFuncao;
		this.pontosDeFuncao=tipo==TipoComplexidade.COMPLEXA?6:this.pontosDeFuncao;
		return this.pontosDeFuncao;
		
	}
	public int verificaFaixaRLR() {
		if(this.getRlr()==0||this.getRlr()==1) {
			return 1;
		}
		if(this.getRlr()==2) {
			return 2;
		}
		if(this.getRlr()>=3) {
			return 3;
		}
		return 0;
	}
	public int verificarFaixaDer() {
		if(this.getDer()>=1&&this.getDer()<=4) {
			return 1;
		}
		if(this.getDer()>=5&&this.getDer()<=15) {
			return 2 ;
		}
		if(this.getDer()>=16) {
			return 3 ;
		}
		return 0;
	}

}
