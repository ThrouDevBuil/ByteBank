package br.com.bytebank.banco.teste;

import br.com.bytebank.banco.modelo.CalculadorDeImposto;
import br.com.bytebank.banco.modelo.ContaCorrente;
import br.com.bytebank.banco.modelo.SaldoInsuficienteException;
import br.com.bytebank.banco.modelo.SeguroDeVida;

public class TesteTributaveis {

	public static void main(String[] args) throws SaldoInsuficienteException {
		
		//Qualificadores
		//O FQN (Fully Qualified Name) é nome completo da classe, 
		//composto pelo nome do pacote e o nome da classe.
		//FQN = Nome Pacote . Nome Simples da Classe. 
		//Esse nome completo da classe que contém o nome de seu diretório é conhecido como 
		//Fully Qualified Name - FQN (br.com.bytebank.banco.modelo.ContaCorrente)
		//Regra de nomenclatura - NOME_DO_SITE_AO_CONTRARIO.NOME_DO_PROJETO
		//br.com.nomedaempresa.nomedoprojeto.subpacote
		//Os pacotes só possuem letras minúsculas
		//Por organização e pela convenção adotada, precisamos seguir o domínio da empresa.
		
		//Após importar um pacote não há necessidade
		//de utilizar o qualificador para instanciar um objeto.
		//Um pacote pode conter nenhum ou mais subpacotes e/ou classes dentro dele.
		//Simple Name 
		ContaCorrente cc = new ContaCorrente(222, 333);
		cc.deposita(100.0);
		
		SeguroDeVida seguro = new SeguroDeVida();
		
		CalculadorDeImposto calc = new CalculadorDeImposto();
		calc.registra(cc);
		calc.registra(seguro);
		
		System.out.println(calc.getTotalImposto());

	}
}
