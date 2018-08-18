package br.com.validadorfluente;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.Test;

import br.com.validadorfluente.DeInteiro;
import br.com.validadorfluente.DeTexto;
import br.com.validadorfluente.DominioInvalidoException;
import br.com.validadorfluente.ValidadorDominio;

public class ValidadorDominioTest {

	@Test
	public void deveValidarTamanhoDaString() {
		String nome = "Daniel";
		String sobremome = null;
		Integer idade = 10;
		
		final DominioInvalidoException excecao = assertThrows(DominioInvalidoException.class, 
		                                                      () -> ValidadorDominio.paraDominio(getClass())
										                                                            .comValidacoes(DeTexto.paraAtributo(nome).queDeveTerTamanhoIgualA(10, "Tamanho do Nome deve ser de 10 caracteres").queNaoDeveSerNulo("TESTE"))
										                                                            .comValidacoes(DeTexto.paraAtributo(sobremome).queNaoDeveSerNulo("Informe o campo sobrenome"))
										                                                            .comValidacoes(DeInteiro.paraAtributo(idade).comValorMenorQue(18, "Idade não pode ser maior que 10 anos"))
										                                                            .validar());
		
		List<String> mensagens = excecao.getMensagens();
		assertThat("Deve ter 3 erros de validação (todos campos nulos).", mensagens.size(), equalTo(3));
	}
}
