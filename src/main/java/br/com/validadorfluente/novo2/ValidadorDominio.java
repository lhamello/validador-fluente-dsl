package br.com.validadorfluente.novo2;

import java.util.LinkedList;
import java.util.List;

public class ValidadorDominio {

  private Class<?> dominio;
  private List<Validacao<?>> validacoes;

  private ValidadorDominio(final Class<?> dominio) {
    this.dominio = dominio;
    this.validacoes = new LinkedList<>();
  }

  public static ValidadorDominio paraDominio(final Class<?> dominio) {
    return new ValidadorDominio(dominio);
  }

  public ValidadorDominio comValidacoes(final Validacao<?> validacao) {
    this.validacoes.add(validacao);
    return this;
  }

  public void validar() {
    List<String> errosValidacao = new LinkedList<>();

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
