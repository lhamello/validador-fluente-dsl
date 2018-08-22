package br.com.validadorfluente.novo2;

import java.util.List;

public class Cep {

	private String numero;

	public Cep(String numero) {
		this.numero = numero;
		validarCep();
	}

	public String getNumero() {
		return numero;
	}

	List<String> validarCep() {
		return DeTexto.paraAtributo(numero, "Numero")
					  .queNaoDeveSerNulo()
					  .queDeveTerTamanhoMaximo(8)
					  .getErrosValidacao();
	}

}