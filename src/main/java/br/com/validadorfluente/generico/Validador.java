package br.com.validadorfluente.generico;

import java.util.LinkedList;
import java.util.List;

public class Validador<T> {

  @SuppressWarnings("unused")
  private final String                 nomeCampoValidado;

  private final T                      campo;

  private List<ErroValidacaoException> errosValidacao;

  private Validador(final String nomeCampoValidado, T campo) {
    this.nomeCampoValidado = nomeCampoValidado;
    this.campo = campo;
    this.errosValidacao = new LinkedList<>();
  }

  public static <T> Validador<T> paraCampo(final String nomeCampoValidado, T campo) {
    return new Validador<T>(nomeCampoValidado, campo);
  }

  @SuppressWarnings({ "unchecked", "hiding" })
  public <T> Validador<T> queNaoDeveSerNulo() {
    if (campo == null) {
      errosValidacao.add(new ErroValidacaoException(String.format("O campo %s é de preenchimento obrigatório.", "")));
    }

    return (Validador<T>) this;
  }

  @SuppressWarnings({ "unchecked", "hiding" })
  public <T> Validador<T> queNaoDeveEstarEmBranco() {
    final String campoString = (String) campo;

    if (campoString.trim().isEmpty()) {
      errosValidacao.add(new ErroValidacaoException(String.format("O campo %s não pode ficar em branco.", "")));
    }

    return (Validador<T>) this;
  }
  
  @SuppressWarnings({ "unchecked", "hiding" })
  public <T> Validador<T> queDeveTerValorMaiorQue(final Number limiar, Class<T> clazz) {
    Class<T> numero = (Class<T>) campo;
    
    if (campo == null) {
      errosValidacao.add(new ErroValidacaoException(String.format("O campo %s é de preenchimento obrigatório.", "")));
    }

    return (Validador<T>) this;
  }
  
  public List<ErroValidacaoException> validar() {
    return errosValidacao;
  }
}
