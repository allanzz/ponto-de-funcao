package br.com.allan.pontodefuncao.classes.TiposFuncoes;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import br.com.allan.pontodefuncao.classes.Projeto;
import br.com.allan.pontodefuncao.classes.TipoComplexidade;

/**
 * Classe para calcular a complexidade e calcular o total de pontos de função de
 * um Arquivo de Interface Externa
 * 
 * @author Allan da Silva
 */

@Entity
@DiscriminatorValue(value = "AIE")
public class ArquivoInterfaceExterna extends Funcao {

	public ArquivoInterfaceExterna(Projeto projeto) {
		this.projeto = projeto;
	}

	public ArquivoInterfaceExterna() {
	}

	@Override
	public TipoComplexidade calcularComplexidade() {
		if (this.tipoDeContagem.equals("Detalhada")) {
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
		} else {
			return TipoComplexidade.SIMPLES;
		}

	}

	public double calcularPontosDeFuncao() {
		this.pontosDeFuncao = calcularComplexidade() == TipoComplexidade.SIMPLES ? 5 : this.pontosDeFuncao;
		this.pontosDeFuncao = calcularComplexidade() == TipoComplexidade.MEDIA ? 7 : this.pontosDeFuncao;
		this.pontosDeFuncao = calcularComplexidade() == TipoComplexidade.COMPLEXA ? 10 : this.pontosDeFuncao;
		calcularPontosDeFuncaoImpactado();
		return this.pontosDeFuncao;
	}

	public void calcularPontosDeFuncaoImpactado() {
		pontoDeFuncaoImpactado = this.pontosDeFuncao * this.getDeflator().getValor();
	}

	public int verificaFaixaRLR() {
		if (this.getRlr_alr() >= 2 && this.getRlr_alr() <= 5) {
			return 1;
		}
		if (this.getRlr_alr() >= 51) {
			return 2;
		}
		return 0;
	}

	public int verificarFaixaDer() {
		if (this.getDer() >= 20 && this.getDer() <= 50) {
			return 1;
		}
		if (this.getDer() >= 51) {
			return 2;
		}
		return 0;
	}

}
