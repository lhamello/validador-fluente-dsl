package br.com.validadorfluente.versaofinal;

import java.util.List;

public class DominioInvalidoException extends RuntimeException {

  private static final long serialVersionUID = 1L;
  private final List<ErroValidacaoException> errosValidacao;

  public DominioInvalidoException(final Class<?> dominio, final List<ErroValidacaoException> errosValidacao) {
    super(String.format("Falha na construção do domínio: %s.", dominio.getName()));
    this.errosValidacao = errosValidacao;
  }

  public List<ErroValidacaoException> getErrosValidacao() {
    return errosValidacao;
  }
}