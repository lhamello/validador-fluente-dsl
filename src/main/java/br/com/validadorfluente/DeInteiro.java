package br.com.validadorfluente;

public class DeInteiro extends Validacao {

	private Integer valorEsperado;

	private DeInteiro() {
	}

	private DeInteiro(Integer valorEsperado) {
		this.valorEsperado = valorEsperado;
	}

	public static DeInteiro paraAtributo(Integer atributo) {
		return new DeInteiro(atributo);
	}

	public DeInteiro naoNula(String mensagem) {
		if (this.valorEsperado == null) {
			super.adicionarMensagem(mensagem);
		}
		return this;
	}

	public DeInteiro comValorMenorQue(int valor, String mensagem) {
		if (this.valorEsperado < valor) {
			super.adicionarMensagem(mensagem);
		}
		return this;
	}

}