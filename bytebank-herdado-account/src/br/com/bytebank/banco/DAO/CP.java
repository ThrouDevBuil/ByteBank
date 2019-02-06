package br.com.bytebank.banco.DAO;

import java.math.BigDecimal;

import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaPoupanca;

public class CP implements Instace {

	private Instace proximo;

	public Conta instance(String typeAccount, int agencia, int numero, BigDecimal saldo) {
		if(typeAccount.compareToIgnoreCase("CP") == 0) 
			return new ContaPoupanca(agencia, numero, saldo.doubleValue());
		return proximo.instance(typeAccount, agencia, numero, saldo);
	}

	@Override
	public void setProximo(Instace proximo) {
		this.proximo = proximo;
	}
}
