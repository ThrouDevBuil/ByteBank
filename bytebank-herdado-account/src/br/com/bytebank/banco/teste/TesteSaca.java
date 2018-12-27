package br.com.bytebank.banco.teste;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import br.com.bytebank.banco.DAO.BancoDAO;
import br.com.bytebank.banco.modelo.Cliente;
import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;
import br.com.bytebank.banco.modelo.ContaPoupanca;

public class TesteSaca {

	public static void main(String[] args) throws IOException {
//		PrintStream saida = System.out;
//		
//		Conta conta = new ContaCorrente(123, 321);
//		
//		try {
//			conta.deposita(200.0);
//			conta.saca(210.0);
//		} catch(SaldoInsuficienteException ex) {
//			saida.println("Ex: " + ex.getMessage());
//		}
//		saida.println(conta.getSaldo());
	
		Conta cc = new ContaCorrente(123, 432);
		cc.deposita(600000);
		Cliente cli1 = new Cliente("Elvis", "860.898.535-77", "Developer");
		cc.setTitular(cli1);
		
		ContaPoupanca cp = new ContaPoupanca(321,543);
		cp.deposita(3_000.4);
		Cliente cli2 = new Cliente("Daniel", "3214325646", "Dev");
		cp.setTitular(cli2);
		
		Conta cc2 = new ContaCorrente(2323, 3213);
		cc2.deposita(9000);
		Cliente cli3 = new Cliente("Bruno", "3424535464", "Programador");
		cc2.setTitular(cli3);
		
		List<? extends Conta> contas = Arrays.asList(cc, cp, cc2);
//		contas.addAll(Arrays.asList(cc, cp, cc2));
		System.out.println(contas);
		BancoDAO dao = new BancoDAO();
		
//		Conta cc = dao.getConta(new ContaCorrente(123, 432));
//		
//		if(cc != null)
//			System.out.println(cc);
		dao.setContas(contas);
//		
//		
	}
}
