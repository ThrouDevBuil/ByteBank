package br.com.bytebank.banco.DAO;

import java.math.BigDecimal;
import java.util.NoSuchElementException;

import br.com.bytebank.banco.modelo.Conta;

public class NotExists implements Instace {

	@Override
	public Conta instance(String typeAccount, int agencia, int numero, BigDecimal saldo) {
		throw new NoSuchElementException("N�o existe mais um chain!");
	}

	@Override
	public void setProximo(Instace proximo) {
		//N�o existe pr�ximo!!
	}
}
