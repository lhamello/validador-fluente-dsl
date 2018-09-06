package br.com.validadorfluente.versaofinal.teste;

import br.com.validadorfluente.versaofinal.Numerica;
import br.com.validadorfluente.versaofinal.Textual;
import br.com.validadorfluente.versaofinal.ValidadorFluente;

public class Pessoa {

  private final String nome;
  private final Short idade;
  
  public Pessoa(final String nome, final Short idade) {
    this.nome = nome;
    this.idade = idade;
    this.validar();
  }
  
  private void validar() {
    ValidadorFluente.paraDominio(this.getClass())
                    .comValidacoes(Textual.paraAtributo(nome, "Nome")
                                          .queNaoDeveSerNulo()
                                          .queNaoDeveFicarEmBranco()
                                          .queDeveTerTamanhoMaximo(60))
                    .comValidacoes(Numerica.paraAtributo(nome, "Nome"))
                    .validar();
  }

  public String getNome() {
    return nome;
  }
}
