package br.com.validadorfluente.versaofinal;

public class Textual extends Validacao<String> {

  public Textual(final String atributo, final String nomeAtributo) {
    super.atributo = atributo;
    super.nomeAtributo = nomeAtributo;
  }

  public static Textual paraAtributo(final String atributo, final String nomeAtributo) {
    return new Textual(atributo, nomeAtributo);
  }

  public Textual queDeveTerTamanhoMaximo(final int limiar) {
    return queDeveTerTamanhoMaximo(String.format("%s deve ter no máximo %s caracter(es).", nomeAtributo, limiar), limiar);
  }

  public Textual queDeveTerTamanhoMaximo(final String mensagemErro, final int limiar) {
    return (Textual) super.executarValidacao(s -> ((String) s).length() <= limiar, atributo, mensagemErro);
  }

  public Textual queNaoDeveFicarEmBranco() {
    return queNaoDeveFicarEmBranco(String.format("%s é de preenchimento obrigatório.", nomeAtributo));
  }

  public Textual queNaoDeveFicarEmBranco(final String mensagemErro) {
    return (Textual) super.executarValidacao(s -> !((String) s).trim().isEmpty(), atributo, mensagemErro);
  }
  
  public Textual queNaoDeveSerNulo() {
    return queNaoDeveSerNulo(String.format("%s é de preenchimento obrigatório.", nomeAtributo));
  }

  public Textual queNaoDeveSerNulo(final String mensagemErro) {
    return (Textual) super.executarValidacao(s -> s != null, atributo, mensagemErro);
  }
}
