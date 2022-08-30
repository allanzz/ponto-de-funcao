package br.com.allan.pontodefuncao.classes.TiposFuncoes;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import br.com.allan.pontodefuncao.classes.Projeto;
import br.com.allan.pontodefuncao.classes.TipoComplexidade;
@Entity
@DiscriminatorValue(value = "ALI")
public class ArquivoLogicoInterno extends Funcao {
	
	TipoComplexidade tipo=null;
	public ArquivoLogicoInterno(Projeto projeto) {
		this.projeto=projeto;	
	}
	public ArquivoLogicoInterno() {	}
	
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
	public double calcularPontosDeFuncao() {
		double pontosDeFunção=0;
		pontosDeFunção=tipo==TipoComplexidade.SIMPLES?7:pontosDeFunção;
		pontosDeFunção=tipo==TipoComplexidade.MEDIA?10:pontosDeFunção;
		pontosDeFunção=tipo==TipoComplexidade.COMPLEXA?15:pontosDeFunção;
		return pontosDeFunção;
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
