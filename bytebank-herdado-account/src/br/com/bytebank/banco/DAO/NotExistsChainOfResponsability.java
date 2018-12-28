package br.com.bytebank.banco.DAO;

import java.util.NoSuchElementException;

public class NotExistsChainOfResponsability extends NoSuchElementException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NotExistsChainOfResponsability(String s) {
		super(s);
	}
}
