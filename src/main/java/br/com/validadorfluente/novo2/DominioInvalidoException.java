package br.com.validadorfluente.novo2;
import java.util.List;

public class DominioInvalidoException extends RuntimeException {

  private static final long serialVersionUID = 1475734663391760957L;
  
  private final List<String> mensagens;
  
  public DominioInvalidoException(Class dominio, List<String> mensagens) {
    super(String.format("Erro na construção do domínio: %s.", dominio.getSimpleName()));
    this.mensagens = mensagens;
  }

  public List<String> getMensagens() {
    return mensagens;
  }
  
}