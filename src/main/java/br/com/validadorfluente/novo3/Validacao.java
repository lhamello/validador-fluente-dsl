package br.com.validadorfluente.novo3;

abstract class Validacao {

  protected final Object atributo;
  protected final String nomeAtributo;

  public Validacao(final Object atributo, final String nomeAtributo) {
    this.atributo = atributo;
    this.nomeAtributo = nomeAtributo;
  }

  public abstract void executar();

}
