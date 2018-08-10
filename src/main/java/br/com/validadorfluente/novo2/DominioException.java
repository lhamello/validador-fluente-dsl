package br.com.validadorfluente.novo2;

import java.util.List;

public class DominioException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  private final List<IllegalArgumentException> errosValidacao;

  @SuppressWarnings("rawtypes")
  public DominioException(final Class classe, final List<IllegalArgumentException> errosValidacao) {
    super(String.format("Erro na construção do domínio: %s.", classe.getName()));
    this.errosValidacao = errosValidacao;
  }

  public List<IllegalArgumentException> getErrosValidacao() {
    return errosValidacao;
  }
}
