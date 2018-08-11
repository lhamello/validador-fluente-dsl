package br.com.validadorfluente.novo3;

public class ValidacaoAtributoTamanhoMaximo extends Validacao {

  private final short limiar;

  public ValidacaoAtributoTamanhoMaximo(final Object atributo, final String nomeAtributo, final short limiar) {
    super(atributo, nomeAtributo);
    this.limiar = limiar;
  }

  @Override
  public void executar() {
    if (atributo != null && (atributo instanceof String)) {
      final String atributoParaValidar = (String) atributo;

      if (!atributoParaValidar.isEmpty()) {

        if (atributoParaValidar.length() > limiar) {
          throw new ErroValidacaoException(String.format("%s deve ter no máximo %s caracter(es).", nomeAtributo, limiar));
        }
      }
    }
  }
}
