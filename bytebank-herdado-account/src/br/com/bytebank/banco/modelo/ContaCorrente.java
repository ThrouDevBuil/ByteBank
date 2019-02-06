package br.com.bytebank.banco.modelo;

import java.io.UnsupportedEncodingException;

//new ContaCorrente()
public class ContaCorrente extends Conta implements Tributavel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ContaCorrente(int agencia, int numero, double saldo) {
		super(agencia, numero, saldo);
	}
	
	public ContaCorrente(int agencia, int numero) {
		super(agencia, numero);
	}
	
	@Override
	public void saca(double valor) throws SaldoInsuficienteException {
		double valorASacar = valor + 0.2;
		super.saca(valorASacar);
	}

	@Override
	public void deposita(double valor) throws SaldoInsuficienteException {
        
		if(valor <= 0) {
			throw new SaldoInsuficienteException("Valor negativo não pode ser depositado");
		}
		super.saldo += valor;
    }

	@Override
	public double getValorImposto() {	
		return super.saldo * 0.01;
	}
	
	@Override
	public String typeAccount() throws UnsupportedEncodingException {
		return new String("CC".getBytes("UTF-8"), "UTF-8");
	}
	
	@Override
	public String toString() {
		return super.toString() + "\nTipo da conta: Conta Corrente\n";
	}
}
