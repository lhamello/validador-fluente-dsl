package br.com.validadorfluente.versaofinal;

public class Textual extends Validacao<String> {

  public Textual(final String atributo, final String nomeAtributo) {
    super.atributo = atributo;
    super.nomeAtributo = nomeAtributo;
  }

  public static Validacao<String> paraAtributo(final String atributo, final String nomeAtributo) {
    return new Textual(atributo, nomeAtributo);
  }

  public Validacao<String> queDeveTerTamanhoMaximo(final int limiar) {
    return queDeveTerTamanhoMaximo(String.format("%s deve ter no máximo %s caracter(es).", nomeAtributo, limiar), limiar);
  }

  public Validacao<String> queDeveTerTamanhoMaximo(final String mensagemErro, final int limiar) {
    return (Textual) super.executarValidacao(s -> ((String) s).length() <= limiar, atributo, mensagemErro);
  }

  public Validacao<String> queNaoDeveFicarEmBranco() {
    return queNaoDeveFicarEmBranco(String.format("%s é de preenchimento obrigatório.", nomeAtributo));
  }

  public Validacao<String> queNaoDeveFicarEmBranco(final String mensagemErro) {
    return (Textual) super.executarValidacao(s -> !((String) s).trim().isEmpty(), atributo, mensagemErro);
  }
}
