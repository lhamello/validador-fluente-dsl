package br.com.validadorfluente;
import java.util.ArrayList;
import java.util.List;

public abstract class Validacao {

	private List<String> mensagens;

	public Validacao() {
		this.mensagens = new ArrayList<>();
	}

	protected final void adicionarMensagem(String mensagem) {
		this.mensagens.add(mensagem);
	}

	protected final List<String> getMensagens() {
		return this.mensagens;
	}


}