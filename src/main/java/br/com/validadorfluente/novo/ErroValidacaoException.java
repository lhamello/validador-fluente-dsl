package br.com.validadorfluente.novo;

public class ErroValidacaoException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public ErroValidacaoException(final String mensagem) {
    super(mensagem);
  }
}
