package br.com.bytebank.banco.DAO;

import java.math.BigDecimal;

import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;

public class CC implements Instace {
	private Instace proximo;
	
	@Override
	public Conta instance(String typeAccount, int agencia, int numero, BigDecimal saldo) {
		if(typeAccount.compareToIgnoreCase("CC") == 0)
			return new ContaCorrente(agencia, numero, saldo.doubleValue());
		return proximo.instance(typeAccount, agencia, numero, saldo);
	}

	@Override
	public void setProximo(Instace proximo) {
		this.proximo = proximo;
	}
}
