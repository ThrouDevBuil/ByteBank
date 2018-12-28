package br.com.bytebank.banco.DAO;

import br.com.bytebank.banco.modelo.Conta;

public class NotExists implements Instace {

	@Override
	public Conta instance(String typeAccount, int agencia, int numero) {
		throw new NotExistsChainOfResponsability("Não existe mais um chain!");
	}

	@Override
	public void setProximo(Instace proximo) {
		//Não existe próximo!!
	}
}
