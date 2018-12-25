package br.com.bytebank.banco.modelo;

import java.io.UnsupportedEncodingException;

public class ContaPoupanca extends Conta {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ContaPoupanca(int agencia, int numero) {
		super(agencia, numero);
	}

	@Override
	public void deposita(double valor) {
		super.saldo += valor;	
	}

	@Override
	public String toString() {
		return super.toString() + "\nTipo da conta: Conta Poupança\n";
	}

	@Override
	public String typeAccount() throws UnsupportedEncodingException {
		return new String("CP".getBytes(), "UTF-8");
	}
}
