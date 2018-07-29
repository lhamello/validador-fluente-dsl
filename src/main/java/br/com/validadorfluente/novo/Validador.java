package br.com.validadorfluente.novo;

import java.util.LinkedList;
import java.util.List;

public abstract class Validador {

  protected List<ErroValidacaoException> errosDeValidacao;
  protected String nomeDoCampo;
  protected Object campo;

  protected Validador(final Object campo, final String nomeDoCampo) {
    this.campo = campo;
    this.nomeDoCampo = nomeDoCampo;
    this.errosDeValidacao = new LinkedList<>();
  }
}
