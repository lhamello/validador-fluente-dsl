package br.com.validadorfluente;

import java.util.ArrayList;
import java.util.List;

public class Validador {

	private List<MensagemValidacao> mensagens;

	private Validador() {
		this.mensagens = new ArrayList<>();
	}

	public static Validador instance() {
		return new Validador();
	}

	protected Validador naoNulo(final Object object, final String mensagem) {
		if (object == null) {
			this.mensagens.add(MensagemValidacao.instance(mensagem));
		}
		return this;
	}

	protected Validador comTamanhoMenorOuIgualQue(final String valor, final int tamanhoMaximo, final String mensagem) {
		if (valor == null) {
			throw new NullPointerException("Informe um valor para validar o tamanho esperado.");
		}

		if (valor.length() > tamanhoMaximo) {
			this.mensagens.add(MensagemValidacao.instance(mensagem));
		}
		return this;
	}

	public List<MensagemValidacao> validar() {
		return mensagens;
	}

}