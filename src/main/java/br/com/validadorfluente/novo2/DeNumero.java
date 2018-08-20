package br.com.validadorfluente.novo2;

final class DeNumero extends Validacao<Object> {

	private Number atributo;

	public DeNumero(final Number atributo, final String nomeAtributo) {
		this.atributo = atributo;
		super.nomeAtributo = nomeAtributo;
	}
}
