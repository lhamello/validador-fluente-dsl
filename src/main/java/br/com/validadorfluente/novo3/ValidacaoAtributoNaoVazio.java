package br.com.validadorfluente.novo3;

class ValidacaoAtributoNaoVazio extends Validacao {

  public ValidacaoAtributoNaoVazio(final Object atributo, final String nomeAtributo) {
    super(atributo, nomeAtributo);
  }

  @Override
  public void executar() {
    if (atributo != null && atributo instanceof String) {
      final String atributoParaValidar = (String) atributo;

      if (atributoParaValidar.trim().isEmpty()) {
        throw new ErroValidacaoException(String.format("%s não pode ficar em branco.", nomeAtributo));
      }
    }
  }
}