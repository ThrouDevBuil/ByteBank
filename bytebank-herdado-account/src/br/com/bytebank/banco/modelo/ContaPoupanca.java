package br.com.bytebank.banco.modelo;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;

public class ContaPoupanca extends Conta {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ContaPoupanca(int agencia, int numero, double saldo) {
		super(agencia, numero, saldo);
	}
	
	public ContaPoupanca(int agencia, int numero) {
		super(agencia, numero);
	}

	@Override
	public void deposita(double valor) {
		super.saldo += valor;	
	}
	
	@Override
	public String typeAccount() throws UnsupportedEncodingException {
		return new String("CP".getBytes("UTF-8"), "UTF-8");
	}

	@Override
	public String toString() {
		return super.toString() + "\nTipo da conta: Conta Poupan�a\n";
	}
}
