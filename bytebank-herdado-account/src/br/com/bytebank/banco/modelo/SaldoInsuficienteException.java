package br.com.bytebank.banco.modelo;

public class SaldoInsuficienteException extends IllegalStateException {
	
	public SaldoInsuficienteException(String msg) {
		super(msg);
	}

}
