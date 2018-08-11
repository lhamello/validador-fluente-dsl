package br.com.validadorfluente.novo3;

import java.util.List;

public class DominioException extends RuntimeException {

  private static final long serialVersionUID = 1L;
  private final List<ErroValidacaoException> errosValidacao;

  @SuppressWarnings("rawtypes")
  public DominioException(final Class classe, final List<ErroValidacaoException> errosValidacao) {
    super(String.format("Erro na construção do domínio: %s.", classe.getName()));
    this.errosValidacao = errosValidacao;
  }

  public List<ErroValidacaoException> getErrosValidacao() {
    return errosValidacao;
  }
}
