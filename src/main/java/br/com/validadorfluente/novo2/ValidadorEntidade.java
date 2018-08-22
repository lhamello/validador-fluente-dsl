package br.com.validadorfluente.novo2;

import java.util.LinkedList;
import java.util.List;

public class ValidadorEntidade {

  private Class<?> dominio;
  private List<Validacao<?>> validacoes;
  private List<String> mensagens;
  
  private ValidadorEntidade(final Class<?> dominio) {
    this.dominio = dominio;
    this.validacoes = new LinkedList<>();
    this.mensagens = new LinkedList<>();
  }

  public static ValidadorEntidade paraDominio(final Class<?> dominio) {
    return new ValidadorEntidade(dominio);
  }

  public ValidadorEntidade comValidacoes(final Validacao<?> validacao) {
    this.validacoes.add(validacao);
    return this;
  }

  public ValidadorEntidade comValidacoes(List<String> mensagens) {
	  	this.mensagens = mensagens;
	    return this;
	  }
  
  public void validar() {
    List<String> errosValidacao = new LinkedList<>();
    errosValidacao.addAll(this.mensagens);
    
    for (Validacao<?> validacao : validacoes) {

      if (validacao.isAplicarValidacoes()) {
        errosValidacao.addAll(validacao.getErrosValidacao());
      }
    }

    if (!errosValidacao.isEmpty()) {
      throw new DominioInvalidoException(dominio, errosValidacao);
    }
  }
  
}