package br.com.validadorfluente.novo3;

import java.util.List;

public interface Validacao {

  List<ErroValidacaoException> executar(final Object atributo, final String nomeAtributo);

}
