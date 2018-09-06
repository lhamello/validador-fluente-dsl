package br.com.validadorfluente.versaofinal.teste;

import java.security.cert.PKIXRevocationChecker.Option;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import javax.swing.text.MaskFormatter;

class CepRS implements CEP {

  private static final String MASCARA_CEP = "#####-###";
  private static final int TAMANHO_CEP = 8;
  private final Integer valor;
  private final String valorFormatado;
  private Boolean valido;

  public CepRS(final Integer numero) {
    this.valor = numero;
    this.validar();
    this.valorFormatado = this.aplicarMascara(numero);
  }

  private void validar() {
//    if (valor == )
  }

  private String aplicarMascara(final Integer numeroCep) {
    try {
      String cep = String.valueOf(numeroCep);
      cep = this.completarZerosEsquerda(cep);

      final MaskFormatter formatador = new MaskFormatter(MASCARA_CEP);
      formatador.setValueContainsLiteralCharacters(false);

      return formatador.valueToString(cep);
    } catch (ParseException exceco) {
      throw new RuntimeException(String.format("Erro ao aplicar máscara no CEP %s.", numeroCep));
    }
  }

  private String completarZerosEsquerda(final String numeroCep) {
    if (numeroCep.length() == TAMANHO_CEP) {
      return numeroCep;
    } else {
      final String cep = "0" + numeroCep;
      return this.completarZerosEsquerda(cep);
    }
  }

  @Override
  public Integer getValor() {
    return valor;
  }

  @Override
  public String getValorComMascara() {
    return valorFormatado;
  }

  @Override
  public boolean isValido() {
    return valido;
  }
}
