package br.com.validadorfluente;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

import br.com.validadorfluente.novo3.ValidadorFluente;

public class ValidadorDominio<T> {

  protected List<Validacao> validacoes;
  @SuppressWarnings("unused")
  private Class dominio;

  protected ValidadorDominio(Class dominio) {
    this.dominio = dominio;
    this.validacoes = new ArrayList<>();
  }

  public void validar() {
    List<String> mensagens = new LinkedList<>();
    for (Validacao validacao : validacoes) {
      mensagens.addAll(validacao.getMensagens());
    }

    if (!mensagens.isEmpty()) {
      throw new DominioInvalidoException(dominio, mensagens);
    }
  }

  public static ValidadorDominio paraDominio(Class dominio) {
    return new ValidadorDominio(dominio);
  }

  public final ValidadorDominio comValidacoes(Validacao validacao) {
    this.validacoes.add(validacao);
    return this;
  }

  public ValidadorDominio<T> validarSomenteSe(Predicate<T> predicado, T objeto) {
//    this.validacaoDeveSerAplicada = predicado.test(objeto);
//    return this.aplicarValicaoAtributo();
    return this;
  }
}