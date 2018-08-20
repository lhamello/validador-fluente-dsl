package br.com.validadorfluente.novo2;

import java.util.Collection;

final class DeColecao extends Validacao<Object> {

	private Collection<?> atributo;

	public DeColecao(final Collection<?> atributo, final String nomeAtributo) {
		this.atributo = atributo;
		super.nomeAtributo = nomeAtributo;
	}
}
