package br.com.bytebank.banco.DAO;

import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaPoupanca;

public class CP implements Instace {

	private Instace proximo;

	public Conta instance(String typeAccount, int agencia, int numero) {
		if(typeAccount.compareToIgnoreCase("CP") == 0) 
			return new ContaPoupanca(agencia, numero);
		return proximo.instance(typeAccount, agencia, numero);
	}

	@Override
	public void setProximo(Instace proximo) {
		this.proximo = proximo;
	}
}
