package br.com.validadorfluente.novo2;

import java.util.Collection;

final class DeObjetoComplexo extends Validacao<Object> {

	private Collection<?> atributo;

	public DeObjetoComplexo(final Collection<?> atributo, final String nomeAtributo) {
		this.atributo = atributo;
		super.nomeAtributo = nomeAtributo;
	}
}
