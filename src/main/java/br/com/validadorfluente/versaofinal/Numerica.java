package br.com.validadorfluente.versaofinal;

public class Numerica extends Validacao<Number> {

  public Numerica(final Number atributo, final String nomeAtributo) {
    super.atributo = atributo;
    super.nomeAtributo = nomeAtributo;
  }
  
  public static Numerica paraAtributo(final Number atributo, final String nomeAtributo) {
    return new Numerica(atributo, nomeAtributo);
  }
  
  
}
