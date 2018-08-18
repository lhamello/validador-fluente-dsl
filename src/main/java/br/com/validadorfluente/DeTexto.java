package br.com.validadorfluente;

public class DeTexto extends Validacao {

	private String atributo;

	private DeTexto() {
	}

	private DeTexto(String atributo) {
		this.atributo = atributo;
	}

	public static DeTexto paraAtributo(String atributo) {
		return new DeTexto(atributo);
	}

	public DeTexto queNaoDeveSerNulo(String mensagem) {
		if (this.atributo == null) {
			super.adicionarMensagem(mensagem);
		}
		return this;
	}

	public DeTexto queDeveTerTamanhoIgualA(int tamanhoEsperado, String mensagem) {
		if (this.atributo == null) {
			return this;
		}
		if (this.atributo.length() != tamanhoEsperado) {
			super.adicionarMensagem(mensagem);
		}
		return this;
	}

}