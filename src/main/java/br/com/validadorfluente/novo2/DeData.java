package br.com.validadorfluente.novo2;

import java.util.Date;

final class DeData extends Validacao<Object> {

	private Date atributo;

	public DeData(final Date atributo, final String nomeAtributo) {
		this.atributo = atributo;
		super.nomeAtributo = nomeAtributo;
	}
}
