package br.com.bytebank.banco.modelo;

public class SaldoInsuficienteException extends IllegalStateException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SaldoInsuficienteException(String msg) {
		super(msg);
	}

}
