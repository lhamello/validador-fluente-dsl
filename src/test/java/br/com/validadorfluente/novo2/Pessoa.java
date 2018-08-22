package br.com.validadorfluente.novo2;

public class Pessoa {

	private String nome;
	
	private Endereco endereco;

	public Pessoa(String nome, Endereco endereco) {
		this.nome = nome;
		this.endereco = endereco;
	}
	
	public String getNome() {
		return nome;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}

	public void validar() {
		ValidadorEntidade.paraDominio(getClass())
						.comValidacoes(endereco.validarEndereco())
						.comValidacoes(endereco.validarEndereco())
						.comValidacoes(DeTexto.paraAtributo(nome, "Nome"));
	}
}