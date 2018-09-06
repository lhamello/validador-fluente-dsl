package br.com.validadorfluente.versaofinal;

import java.util.LinkedList;
import java.util.List;

public class ValidadorFluente {

  private final Class<?> dominio;
  private List<Validacao<?>> validacoes;

  private ValidadorFluente(final Class<?> dominio) {
    this.dominio = dominio;
    this.validacoes = new LinkedList<>();
  }

  public static ValidadorFluente paraDominio(final Class<?> dominio) {
    return new ValidadorFluente(dominio);
  }

  public ValidadorFluente comValidacoes(final Validacao<?> validacao) {
    this.validacoes.add(validacao);
    return this;
  }

  public void validar() {
    List<ErroValidacaoException> errosValidacao = new LinkedList<>();

    for (Validacao<?> validacao : validacoes) {
      errosValidacao.addAll(validacao.getErrosValidacao());
    }

    if (!errosValidacao.isEmpty()) {
      throw new DominioInvalidoException(dominio, errosValidacao);
    }
  }
}
