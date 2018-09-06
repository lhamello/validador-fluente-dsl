package br.com.validadorfluente.versaofinal;

public class ErroValidacaoException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public ErroValidacaoException(final String mensagemErro) {
    super(mensagemErro);
  }
}
