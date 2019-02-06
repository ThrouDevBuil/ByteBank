package br.com.bytebank.banco.teste;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import br.com.bytebank.banco.DAO.BankDAO;
import br.com.bytebank.banco.DAO.ClienteDAO;
import br.com.bytebank.banco.modelo.Cliente;
import br.com.bytebank.banco.modelo.Connect;
import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;
import br.com.bytebank.banco.modelo.ContaPoupanca;

public class TestePersistencia {

	public static void main(String[] args) throws IOException, ClassNotFoundException {

//		List<Conta> contas = new ArrayList<>();

		Conta cc = new ContaCorrente(123, 6785);
		cc.setTitular(new Cliente("Bruno Almeida", "231.765.234-65", "Empreendedor"));
		cc.deposita(22000.00);
		cc.getTitular().setId(7);
		
		Conta cp = new ContaPoupanca(321, 4355);
		cp.setTitular(new Cliente("Flávio Augusto", "456.098.765-08", "Empreendedor"));
		cp.deposita(1000000.00);
		cp.getTitular().setId(8);
		
		Conta cc1 = new ContaCorrente(4567, 8975);
		cc1.setTitular(new Cliente("Chico", "987.764.432-12", "Policial Federal"));
		cc1.deposita(12000.0);
		cc1.getTitular().setId(9);
		List<Conta> contas = new LinkedList<>();
		contas.addAll(Arrays.asList(cc, cp, cc1));
		
		try (Connection con = Connect.getConnection()) {
//			ClienteDAO cliDAO = new ClienteDAO(con);
//			cliDAO.insert(cc.getTitular());
//			cliDAO.insert(cp.getTitular());
//			cliDAO.insert(cc1.getTitular());
			BankDAO bankDAO = new BankDAO(con);
//			bankDAO.insert(contas);
//			bankDAO.insert(cc1);
//			bankDAO.insert(cp);
//			for(Conta c : bankDAO.listar())
//				System.out.println(c);
//			bankDAO.delete(2);
//			cc1 = bankDAO.buscar(123, 432);
//			System.out.println(cc1);
			for(Conta c : bankDAO.buscaAgencia(123))
				System.out.println(c);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		//
//		BancoDAO dao = new BancoDAO();
//		dao.setConta(cc);
//		dao.setConta(cp);
//		dao.setConta(cc1);
//		BancoDAO dao = new BancoDAO();

//		contas.forEach(conta -> {
//			System.out.println(conta);
////		});
//
//		Conta cc = new ContaCorrente(123,321);
//		cc.setTitular(new Cliente("Elvis de Sousa", "860.898.535-77", "Developer"));
//		cc.deposita(600000.0);
//		
//		Conta cp = new ContaPoupanca(123,321);
//		cp.setTitular(new Cliente("Danilo", "456786543", "Mecânico"));
//		cp.deposita(6000.0);
//		
//		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("contas.bin"), false));
//		List<Conta> contas = new ArrayList<>();
//		
//		contas.addAll(Arrays.asList(cc, cp));
//		
//		oos.writeObject(contas);
//		
//		oos.close();

//		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("contas.bin"), true));
//		oos.writeObject(new String("Ç".getBytes(), "UTF-8"));
//		oos.close();
//		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("contas.bin")));
//		List<? extends Conta> contas;

//		if ((contas = cast(ois)) != null)
//			System.out.println(contas + "\n " + contas.size());
//		ois.close();
	}
}
