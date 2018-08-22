package br.com.validadorfluente.novo2;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.Test;

public class ValidadorDominioTest {

	@Test
	public void deveTestar() {
	  final String nome = "Luiz";
	  final String sobrenome = null;
	  final Integer idade = 32;
	  
	  final DominioInvalidoException excecao = assertThrows(DominioInvalidoException.class,
	                                                       () -> ValidadorDominio.paraDominio(getClass())
	                                                                             .comValidacoes(DeTexto.paraAtributo(nome, "Nome")
	                                                                                                   .queNaoDeveSerNulo()
	                                                                                                   .queNaoDeveSerVazio()
	                                                                                                   .sempre())
	                                                                             .comValidacoes(DeTexto.paraAtributo(sobrenome, "Sobrenome")
	                                                                                                   .queNaoDeveSerNulo()
	                                                                                                   .queNaoDeveSerVazio()
	                                                                                                   .somenteSe(i -> i != null, idade))
	                                                                             .validar());
	  
	  List<String> mensagens = excecao.getMensagens();
    assertThat("Deve ter 3 erros de validação (todos campos nulos).", mensagens.size(), equalTo(1));
	}
}
