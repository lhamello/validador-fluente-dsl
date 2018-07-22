package br.com.validadorfluente;

public class MensagemValidacao {

	private String atributo;

	private String mensagem;

	private MensagemValidacao(String mensagem) {
		this(null, mensagem);
	}

	private MensagemValidacao(String atributo, String mensagem) {
		this.atributo = atributo;
		this.mensagem = mensagem;
	}

	public static MensagemValidacao instance(String atributo, String mensagem) {
		return new MensagemValidacao(atributo, mensagem);
	}

	public static MensagemValidacao instance(String mensagem) {
		return new MensagemValidacao(mensagem);
	}

	public String getAtributo() {
		return atributo;
	}

	public String getMensagem() {
		return mensagem;
	}

	@Override
	public String toString() {
		return mensagem;
	}
}