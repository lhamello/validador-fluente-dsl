package br.com.validadorfluente.versaofinal.teste;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import br.com.validadorfluente.versaofinal.DominioInvalidoException;
import br.com.validadorfluente.versaofinal.ErroValidacaoException;

public class PessoaTest {

	@Test
	public void deveCriarUmaPessoaValida() {
	  final String nome = "Luiz";
	  final Short idade = 32;
	  
		final Pessoa pessoa = new Pessoa(nome, idade);
		
		assertAll("Verificando a criação do objeto...",
        () -> assertThat("Verificando atribuição do nome.", pessoa.getNome(), equalTo("Luiz")));  
	}
	
	@Test
	public void naoDeveCriarPessoaComNomeNulo() {
	  final String nome = null;
	  final Short idade = 32;
	  
	  final DominioInvalidoException excecao = assertThrows(DominioInvalidoException.class, () -> new Pessoa(nome, idade));
	  assertThat("Erro de validação na construção do domínio Pessoa.", excecao.getMessage(), equalTo("Falha na construção do domínio: br.com.validadorfluente.versaofinal.teste.Pessoa."));
	  
	  final int numeroErrosValidacao = 1;
    assertThat("Deve ter somente 1 erro de validação (nome nulo).", excecao.getErrosValidacao().size(), equalTo(numeroErrosValidacao));
    
    final ErroValidacaoException erroValidacao = excecao.getErrosValidacao().get(0);
    assertThat("Mensagem de validação para abreviatura nula.", erroValidacao.getMessage(), equalTo("Nome é de preenchimento obrigatório."));
	}
	
	@Test
  public void naoDeveCriarPessoaComNomeVazio() {
    final String nome = "";
    final Short idade = 32;
    
    final DominioInvalidoException excecao = assertThrows(DominioInvalidoException.class, () -> new Pessoa(nome, idade));
    assertThat("Erro de validação na construção do domínio Pessoa.", excecao.getMessage(), equalTo("Falha na construção do domínio: br.com.validadorfluente.versaofinal.teste.Pessoa."));
    
    final int numeroErrosValidacao = 1;
    assertThat("Deve ter somente 1 erro de validação (nome nulo).", excecao.getErrosValidacao().size(), equalTo(numeroErrosValidacao));
    
    final ErroValidacaoException erroValidacao = excecao.getErrosValidacao().get(0);
    assertThat("Mensagem de validação para abreviatura nula.", erroValidacao.getMessage(), equalTo("Nome é de preenchimento obrigatório."));
  }
	
	@Test
	public void naoDeveCriarPessoaComNomeEmBranco() {
    final String nome = "    ";
    final Short idade = 32;
    
    final DominioInvalidoException excecao = assertThrows(DominioInvalidoException.class, () -> new Pessoa(nome, idade));
    assertThat("Erro de validação na construção do domínio Pessoa.", excecao.getMessage(), equalTo("Falha na construção do domínio: br.com.validadorfluente.versaofinal.teste.Pessoa."));
    
    final int numeroErrosValidacao = 1;
    assertThat("Deve ter somente 1 erro de validação (nome nulo).", excecao.getErrosValidacao().size(), equalTo(numeroErrosValidacao));
    
    final ErroValidacaoException erroValidacao = excecao.getErrosValidacao().get(0);
    assertThat("Mensagem de validação para abreviatura nula.", erroValidacao.getMessage(), equalTo("Nome é de preenchimento obrigatório."));
  }
}
