package br.com.bytebank.banco.DAO;

import java.math.BigDecimal;

import br.com.bytebank.banco.modelo.Conta;

public class Instanciador {
	
	private Instace contaCorrente;
	private Instace contaPoupanca;
	private Instace notExists;

	public Instanciador() {
		contaCorrente = new CC();
		contaPoupanca = new CP();
		notExists = new NotExists();
	}
	
	public Conta instaciar(String typeAccount, int agencia, int numero, BigDecimal saldo) {
		contaCorrente.setProximo(contaPoupanca);
		contaPoupanca.setProximo(notExists);
		return contaCorrente.instance(typeAccount, agencia, numero, saldo);
	}
}
