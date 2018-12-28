package br.com.bytebank.banco.DAO;

import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;

public class CC implements Instace {
	private Instace proximo;
	
	@Override
	public Conta instance(String typeAccount, int agencia, int numero) {
		if(typeAccount.compareToIgnoreCase("CC") == 0)
			return new ContaCorrente(agencia, numero);
		return proximo.instance(typeAccount, agencia, numero);
	}

	@Override
	public void setProximo(Instace proximo) {
		this.proximo = proximo;
	}
}
