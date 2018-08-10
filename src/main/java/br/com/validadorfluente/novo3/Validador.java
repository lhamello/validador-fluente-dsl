package br.com.validadorfluente.novo3;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;


public class Validador<T> {

  @SuppressWarnings("rawtypes")
  private Class                        classe;
  private Object                       atributo;
  private String                       nomeAtributo;
  private Boolean                      validacaoDeveSerAplicada;
  private List<Validacao>              validacoesAtributo;
  private List<ErroValidacaoException> errosValidacao;

  @SuppressWarnings("rawtypes")
  private Validador(final Class classe) {
    this.classe = classe;
    this.errosValidacao = new LinkedList<>();
  }

  @SuppressWarnings({ "rawtypes", "unchecked" })
  public static <T> Validador<T> paraClasseDominio(final Class classe) {
    return new Validador(classe);
  }

  public Validador<T> queContemAtributo(final Object atributo, final String nomeAtributo) {
    this.atributo = atributo;
    this.nomeAtributo = nomeAtributo;
    this.validacoesAtributo = new LinkedList<>();
    return this;
  }

  public Validador<T> queNaoDeveSerNulo() {
    final Validacao validacao = new ValidacaoObjetoNaoNulo();
    this.validacoesAtributo.add(validacao);
    return this;
  }

  public Validador<T> queNaoDeveSerVazio() {
    final Validacao validacao = new ValidacaoAtributoNaoVazio();
    this.validacoesAtributo.add(validacao);
    return this;
  }

  public Validador<T> queDeveTerTamanhoIgualA(final int tamanho) {
    final Validacao validacao = new ValidacaoTamanhoAtributoIgualLimiar(tamanho);
    this.validacoesAtributo.add(validacao);
    return this;
  }

  public Validador<T> queDeveTerTamanhoMenorOuIgualQue(final int tamanho) {
    final Validacao validacao = new ValidacaoTamanhoMaximoAtributo(tamanho);
    this.validacoesAtributo.add(validacao);
    return this;
  }
  
  public Validador<T> sempre() {
    this.validacaoDeveSerAplicada = true;
    return this.aplicarValicaoAtributo();
  }

  public Validador<T> somenteSe(Predicate<T> predicado, T objeto) {
    this.validacaoDeveSerAplicada = predicado.test(objeto);
    return this.aplicarValicaoAtributo();
  }

  private Validador<T> aplicarValicaoAtributo() {
    if (validacaoDeveSerAplicada) {

      for (final Validacao validacao : validacoesAtributo) {
        final List<ErroValidacaoException> errosNestaValidacao = validacao.executar(atributo, nomeAtributo);
        this.errosValidacao.addAll(errosNestaValidacao);
      }
    }

    return this;
  }
  
  public void validarConstrucao() {
    if (!errosValidacao.isEmpty()) {
      throw new DominioException(classe, errosValidacao);
    }
  }
}
