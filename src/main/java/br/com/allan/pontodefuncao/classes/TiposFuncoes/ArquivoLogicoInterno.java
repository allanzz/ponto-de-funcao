package br.com.allan.pontodefuncao.classes.TiposFuncoes;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import br.com.allan.pontodefuncao.classes.Projeto;
import br.com.allan.pontodefuncao.classes.TipoComplexidade;
@Entity
@DiscriminatorValue(value = "ALI")
public class ArquivoLogicoInterno extends Funcao {
	
	
	public ArquivoLogicoInterno(Projeto projeto) {
		this.projeto=projeto;	
	}
	public ArquivoLogicoInterno() {	}
	
	@Override
	public TipoComplexidade calcularComplexidade() {	
		TipoComplexidade tipocomplexidade=null;
		tipocomplexidade = verificaFaixaRLR()==1&&verificarFaixaDer()==1?TipoComplexidade.SIMPLES:tipocomplexidade;
		tipocomplexidade = verificaFaixaRLR()==1&&verificarFaixaDer()==2?TipoComplexidade.SIMPLES:tipocomplexidade;
		tipocomplexidade = verificaFaixaRLR()==1&&verificarFaixaDer()==3?TipoComplexidade.MEDIA:tipocomplexidade;
		tipocomplexidade = verificaFaixaRLR()==2&&verificarFaixaDer()==1?TipoComplexidade.SIMPLES:tipocomplexidade;
		tipocomplexidade = verificaFaixaRLR()==2&&verificarFaixaDer()==2?TipoComplexidade.MEDIA:tipocomplexidade;
		tipocomplexidade = verificaFaixaRLR()==2&&verificarFaixaDer()==3?TipoComplexidade.COMPLEXA:tipocomplexidade;
		tipocomplexidade = verificaFaixaRLR()==3&&verificarFaixaDer()==1?TipoComplexidade.MEDIA:tipocomplexidade;
		tipocomplexidade = verificaFaixaRLR()==3&&verificarFaixaDer()==2?TipoComplexidade.COMPLEXA:tipocomplexidade;
		tipocomplexidade = verificaFaixaRLR()==3&&verificarFaixaDer()==3?TipoComplexidade.COMPLEXA:tipocomplexidade;
		return tipocomplexidade;
		
	}
	public double calcularPontosDeFuncao() {
		
		this.pontosDeFuncao=calcularComplexidade()==TipoComplexidade.SIMPLES?7:this.pontosDeFuncao;
		this.pontosDeFuncao=calcularComplexidade()==TipoComplexidade.MEDIA?10:this.pontosDeFuncao;
		this.pontosDeFuncao=calcularComplexidade()==TipoComplexidade.COMPLEXA?15:this.pontosDeFuncao;
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
