package br.com.validadorfluente.versaofinal;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

public abstract class Validacao<T> {

  private List<ErroValidacaoException> errosValidacao;
  protected T atributo;
  protected String nomeAtributo;

  public Validacao() {
    this.errosValidacao = new LinkedList<>();
  }
  
  protected Validacao<T> executarValidacao(final Predicate<T> predicado, final T objeto, final String mensagemCasoHajaErroValidacao) {
    try {

      if (!predicado.test(objeto)) {
        final ErroValidacaoException excecao = new ErroValidacaoException(mensagemCasoHajaErroValidacao);
        this.errosValidacao.add(excecao);
      }
    } catch (Exception excecao) {
      // TODO: logar esta exceção com SLF4J
      System.out.println("[WARN] => erro ao executar predicado.");
      excecao.printStackTrace();
    }

    return this;
  }

  public List<ErroValidacaoException> getErrosValidacao() {
    return errosValidacao;
  }
  
  public Validacao<T> queNaoDeveSerNulo() {
    return queNaoDeveSerNulo(String.format("%s é de preenchimento obrigatório.", nomeAtributo));
  }

  public Validacao<T> queNaoDeveSerNulo(final String mensagemErro) {
    return this.executarValidacao(s -> s != null, atributo, mensagemErro);
  }
}
