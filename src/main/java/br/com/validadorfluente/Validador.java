package br.com.validadorfluente;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class Validador {

	private List<MensagemValidacao> mensagens;

	private Validador() {
		this.mensagens = new ArrayList<>();
	}

	public static Validador instance() {
		return new Validador();
	}

	public Validador naoNulo(final Object object, final String mensagem) {
		if (object == null) {
			this.mensagens.add(MensagemValidacao.instance(mensagem));
		}
		return this;
	}

	public Validador naoNuloENaoVazio(final String valor, final String mensagem) {
		if (StringUtils.isBlank(valor)) {
			this.mensagens.add(MensagemValidacao.instance(mensagem));
		}
		return this;
	}

	public Validador comTamanhoIgualA(final String valor, final int tamanhoEsperado, final String mensagem) {
		if (valor == null) {
			return this;
		}

		if (valor.length() != tamanhoEsperado) {
			this.mensagens.add(MensagemValidacao.instance(mensagem));
		}
		return this;
	}

	public Validador comTamanhoMenorOuIgualQue(final String valor, final int tamanhoMaximo, final String mensagem) {
		if (valor == null) {
			return this;
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