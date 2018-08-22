package br.com.validadorfluente.novo2;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

abstract class Validacao<T> {

  private List<String> errosValidacao;
  private boolean aplicarValidacoes;
  protected String nomeAtributo;

  public Validacao() {
    this.errosValidacao = new LinkedList<>();
    this.aplicarValidacoes = true;
  }

  protected Validacao<T> executarValidacao(final Predicate<T> predicado, final T objeto, final String mensagemCasoErroValidacao) {
    try {
      if (!predicado.test(objeto)) {
        this.errosValidacao.add(mensagemCasoErroValidacao);
      }
    } catch (Exception excecao) {
      // TODO: logar esta exceção com SLF4J
      System.out.println("[WARN] => erro ao executar predicado.");
      excecao.printStackTrace();
    }

    return this;
  }

  public Validacao<T> somenteSe(Predicate<T> predicado, T objeto) {
    this.aplicarValidacoes = predicado.test(objeto);
    return this;
  }

  public List<String> getErrosValidacao() {
    return errosValidacao;
  }

  public boolean isAplicarValidacoes() {
    return aplicarValidacoes;
  }
}
