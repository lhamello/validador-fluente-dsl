package br.com.validadorfluente.novo2;

import java.util.LinkedList;
import java.util.List;

public class Validador {

  @SuppressWarnings("rawtypes")
  private Class classe;
  private Object campo;
  private String nomeCampo;
  private List<IllegalArgumentException> errosValidacao;

  @SuppressWarnings("rawtypes")
  private Validador(final Class classe) {
    this.classe = classe;
    this.errosValidacao = new LinkedList<>();
  }
  
  @SuppressWarnings("rawtypes")
  public static Validador doDominio(final Class classe) {
    return new Validador(classe);
  }
  
  public Validador paraCampo(final Object campo, final String nomeCampo) {
    this.campo = campo;
    this.nomeCampo = nomeCampo;
    return this;
  }
  
  public Validador queNaoDeveSerNulo() {
    if (campo == null) {
      final IllegalArgumentException excecao = new IllegalArgumentException(String.format("Campo %s é de preenchimento obrigatório.", nomeCampo));
      this.errosValidacao.add(excecao);
    }
    
    return this;
  }
  
  public Validador queNaoDeveSerVazio() {
    if (campo == null || !(campo instanceof String)) {
      return this;
    }
    
    final String campoParaValidar = (String) campo; 
    
    if (campoParaValidar.trim().isEmpty()) {
      final IllegalArgumentException excecao = new IllegalArgumentException(String.format("%s não pode ficar em branco.", nomeCampo));
      this.errosValidacao.add(excecao);
    }
    
    return this;
  }
  
  public Validador queDeveTerTamanhoIgualA(final int tamanho) {
    if (campo == null || !(campo instanceof String)) {
      return this;
    }
    
    final String campoParaValidar = (String) campo; 
    
    if (campoParaValidar.trim().isEmpty()) { 
      return this;
    }
    
    if (campoParaValidar.length() != tamanho) {
      final IllegalArgumentException excecao = new IllegalArgumentException(String.format("%s deve ter 3 letra(s).", nomeCampo));
      this.errosValidacao.add(excecao);
    }
    
    return this;
  }
  
  public Validador queDeveTerTamanhoMenorOuIgualQue(final int tamanhoMaximo) {
    if (campo == null || !(campo instanceof String)) {
      return this;
    }
    
    final String campoParaValidar = (String) campo; 
    
    if (campoParaValidar.trim().isEmpty()) { 
      return this;
    }
    
    if (campoParaValidar.length() > tamanhoMaximo) {
      final IllegalArgumentException excecao = new IllegalArgumentException(String.format("%s deve ter no máximo %s letra(s).", nomeCampo, tamanhoMaximo));
      this.errosValidacao.add(excecao);
    }
    
    return this; 
  }
  
  public void validar() {
    if (!errosValidacao.isEmpty()) {
      throw new DominioException(classe, errosValidacao);
    }
  }
}
