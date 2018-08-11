package br.com.validadorfluente.novo3;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

public class ValidadorFluente<T> {

  @SuppressWarnings("rawtypes")
  private Class classe;
  private Object atributo;
  private String nomeAtributo;
  private Boolean validacaoDeveSerAplicada;
  private List<Validacao> validacoesAtributo;
  private List<ErroValidacaoException> errosValidacao;

  @SuppressWarnings("rawtypes")
  private ValidadorFluente(final Class classe) {
    this.classe = classe;
    this.errosValidacao = new LinkedList<>();
  }

  @SuppressWarnings({ "rawtypes", "unchecked" })
  public static <T> ValidadorFluente<T> paraClasseDeDominio(final Class classe) {
    return new ValidadorFluente(classe);
  }

  public ValidadorFluente<T> queContemAtributo(final Object atributo, final String nomeAtributo) {
    this.atributo = atributo;
    this.nomeAtributo = nomeAtributo;
    this.validacoesAtributo = new LinkedList<>();
    return this;
  }

  public ValidadorFluente<T> queNaoDeveSerNulo() {
    final Validacao validacao = new ValidacaoAtributoNaoNulo(atributo, nomeAtributo);
    this.validacoesAtributo.add(validacao);
    return this;
  }

  public ValidadorFluente<T> queNaoDeveSerVazio() {
    final Validacao validacao = new ValidacaoAtributoNaoVazio(atributo, nomeAtributo);
    this.validacoesAtributo.add(validacao);
    return this;
  }

  public ValidadorFluente<T> queDeveTerTamanhoIgualA(final short tamanho) {
    final Validacao validacao = new ValidacaoAtributoTamanhoExato(atributo, nomeAtributo, tamanho);
    this.validacoesAtributo.add(validacao);
    return this;
  }

  public ValidadorFluente<T> queDeveTerTamanhoMenorOuIgualQue(final short tamanho) {
    final Validacao validacao = new ValidacaoAtributoTamanhoMaximo(atributo, nomeAtributo, tamanho);
    this.validacoesAtributo.add(validacao);
    return this;
  }

  public ValidadorFluente<T> validar() {
    this.validacaoDeveSerAplicada = true;
    return this.aplicarValicaoAtributo();
  }

  public ValidadorFluente<T> validarSomenteSe(Predicate<T> predicado, T objeto) {
    this.validacaoDeveSerAplicada = predicado.test(objeto);
    return this.aplicarValicaoAtributo();
  }

  private ValidadorFluente<T> aplicarValicaoAtributo() {
    if (validacaoDeveSerAplicada) {

      for (final Validacao validacao : validacoesAtributo) {
        
        try {
          validacao.executar();
        } catch (ErroValidacaoException excecao) {
          this.errosValidacao.add(excecao);
        }
      }
    }

    return this;
  }

  public void contruirDominio() {
    if (!errosValidacao.isEmpty()) {
      throw new DominioException(classe, errosValidacao);
    }
  }
}
