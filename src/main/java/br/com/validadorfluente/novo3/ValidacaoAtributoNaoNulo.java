package br.com.validadorfluente.novo3;

class ValidacaoAtributoNaoNulo extends Validacao {

  public ValidacaoAtributoNaoNulo(final Object atributo, final String nomeAtributo) {
    super(atributo, nomeAtributo);
  }

  @Override
  public void executar() {
    if (atributo == null) {
      throw new ErroValidacaoException(String.format("%s é de preenchimento obrigatório.", nomeAtributo));
    }
  }
}
