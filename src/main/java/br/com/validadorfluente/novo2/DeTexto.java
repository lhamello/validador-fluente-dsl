package br.com.validadorfluente.novo2;

final class DeTexto extends Validacao<Object> {

	private String atributo;

	public DeTexto(final String atributo, final String nomeAtributo) {
		this.atributo = atributo;
		super.nomeAtributo = nomeAtributo;
	}

	public static DeTexto paraAtributo(final String atributo, final String nomeAtributo) {
		return new DeTexto(atributo, nomeAtributo);
	}

	public DeTexto queDeveTerTamanho(final int limiar) {
		return queNaoDeveSerVazio(String.format("%s deve ter %s caracter(es).", nomeAtributo, limiar));
	}

	public DeTexto queDeveTerTamanho(final String mensagemErro, final int limiar) {
		return (DeTexto) super.executarValidacao(s -> ((String) s).length() == limiar, atributo, mensagemErro);
	}
	
	public DeTexto queDeveTerTamanhoMaximo(final int limiar) {
		return queNaoDeveSerVazio(String.format("%s deve ter no máximo %s caracter(es).", nomeAtributo, limiar));
	}

	public DeTexto queDeveTerTamanhoMaximo(final String mensagemErro, final int limiar) {
		return (DeTexto) super.executarValidacao(s -> ((String) s).length() <= limiar, atributo, mensagemErro);
	}
	
	public DeTexto queNaoDeveSerNulo() {
		return queNaoDeveSerNulo(String.format("%s é de preenchimento obrigatório.", nomeAtributo));
	}

	public DeTexto queNaoDeveSerNulo(final String mensagemErro) {
		return (DeTexto) super.executarValidacao(s -> s != null, atributo, mensagemErro);
	}
	
	public DeTexto queNaoDeveSerVazio() {
		return queNaoDeveSerVazio(String.format("%s não pode ficar em branco.", nomeAtributo));
	}

	public DeTexto queNaoDeveSerVazio(final String mensagemErro) {
		return (DeTexto) super.executarValidacao(s -> !((String) s).trim().isEmpty(), atributo, mensagemErro);
	}
}
