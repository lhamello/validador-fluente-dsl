package br.com.validadorfluente;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidadorTest {
	
	@Test
	public void deveValidarSeUmObjetoStringEstaNulo() {
		String alvoTeste = null;
		List<MensagemValidacao> validacoesRecebidas = Validador
													 .instance()
													 .naoNulo(alvoTeste, "Informe um valor para o atributo")
													 .validar();
		assertEquals(1, validacoesRecebidas.size());
		assertEquals("Informe um valor para o atributo", validacoesRecebidas.get(0).getMensagem());
	}
	
	@Test
	public void deveValidarSeUmObjetoStringTemTamanhoEsperado() {
		String alvoTeste = "TESTE";
		List<MensagemValidacao> validacoesRecebidas = Validador
													 .instance()
													 .comTamanhoMenorOuIgualQue(alvoTeste, 5, StringUtils.EMPTY)
													 .validar();
		assertTrue(validacoesRecebidas.isEmpty(), "Lista deveria estar vazia");
	}
	
	@Test
	public void deveValidarSeUmObjetoStringTemTamanhoEsperadoENaoNulo() {
		String alvoTeste = "TESTE";
		List<MensagemValidacao> validacoesRecebidas = Validador
													 .instance()
													 .naoNulo(alvoTeste, StringUtils.EMPTY)
													 .comTamanhoMenorOuIgualQue(alvoTeste, 5, StringUtils.EMPTY)
													 .validar();
		assertTrue(validacoesRecebidas.isEmpty(), "Lista deveria estar vazia");
	}
	
	@Test
	@DisplayName("validar se um objeto string � maior que o esperado")
	public void deveValidarSeUmObjetoStringMaiorQueEsperadoENaoNulo() {
		String alvoTeste = "TESTE DE UM TEXTO MAIOR QUE O ESPERADO";
		List<MensagemValidacao> validacoesRecebidas = Validador
													 .instance()
													 .naoNulo(alvoTeste, StringUtils.EMPTY)
													 .comTamanhoMenorOuIgualQue(alvoTeste, 10, "É permitido no máximo 10 caracteres.")
													 .validar();
		assertEquals(1, validacoesRecebidas.size());
		assertEquals("É permitido no máximo 10 caracteres.", validacoesRecebidas.get(0).getMensagem());
	}
	
}