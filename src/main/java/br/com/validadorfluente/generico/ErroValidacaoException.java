package br.com.validadorfluente.generico;

public class ErroValidacaoException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public ErroValidacaoException(final String mensagem) {
    super(mensagem);
  }
}
