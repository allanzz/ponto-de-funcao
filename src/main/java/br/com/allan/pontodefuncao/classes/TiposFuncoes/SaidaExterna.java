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
			int rlrLinha=verificaFaixaRLR();
			int derColuna = verificarFaixaDer();
			TipoComplexidade[][] tipoComplexidade = new TipoComplexidade[3][3];
			tipoComplexidade[0][0] = TipoComplexidade.SIMPLES;
			tipoComplexidade[0][1] = TipoComplexidade.SIMPLES;
			tipoComplexidade[0][2] = TipoComplexidade.MEDIA;
			tipoComplexidade[1][0] = TipoComplexidade.SIMPLES;
			tipoComplexidade[1][1] = TipoComplexidade.MEDIA;
			tipoComplexidade[1][2] = TipoComplexidade.COMPLEXA;
			tipoComplexidade[2][0] = TipoComplexidade.MEDIA;
			tipoComplexidade[2][2] = TipoComplexidade.COMPLEXA;
			tipoComplexidade[2][2] = TipoComplexidade.COMPLEXA;				
			return tipoComplexidade[rlrLinha][derColuna];		
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
		if(this.getRlr_alr()==2||this.getRlr_alr()==3) {
			return 1;
		}
		if(this.getRlr_alr()>=4) {
			return 2;
		}
		return 0;
	}
	
	public int verificarFaixaDer() {
		if(this.getDer()>=6&&this.getDer()<=19) {
			return 1 ;
		}
		if(this.getDer()>=20) {
			return 2 ;
		}
		return 0;
	}
	}
