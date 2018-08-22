package br.com.validadorfluente.novo2;

import java.util.ArrayList;
import java.util.List;

public class Endereco {

	private Cep cep;
	
	private String rua;

	public Endereco(Cep cep, String rua) {
		this.cep = cep;
		this.rua = rua;
	}

	public Cep getCep() {
		return cep;
	}
	
	public String getRua() {
		return rua;
	}
	
	List<String> validarEndereco() {
		List<String> mensagens = new ArrayList<>();
		// validando CEP
		mensagens.addAll(cep.validarCep());
		
		// validando Atributos da classe
		mensagens.addAll(DeTexto.paraAtributo(rua, "Rua")
					  .queNaoDeveSerNulo()
					  .queDeveTerTamanhoMaximo(120)
					  .getErrosValidacao());
		
		return mensagens;
	} 
	
}