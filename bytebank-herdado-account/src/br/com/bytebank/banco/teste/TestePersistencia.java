package br.com.bytebank.banco.teste;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.bytebank.banco.modelo.Conta;

public class TestePersistencia {
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		
//		List<Conta> contas = new ArrayList<>();
		
//		Conta cc = new ContaCorrente(123,432);
//		cc.setTitular(new Cliente("Elvis", "860.898.535-77", "Developer"));
//		cc.deposita(600000.89);
//		
//		Conta cp = new ContaPoupanca(321, 123);
//		cp.setTitular(new Cliente("Daniel Messias", "943564657", "Dev"));
//		cp.deposita(3000.00);
//		
//		Conta cc1 = new ContaCorrente(3232, 3213);
//		cc1.setTitular(new Cliente("Bruno", "45678976543", "Mecanico"));
//		cc1.deposita(9000.43);
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
		
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("contas.bin"), true));
		oos.writeObject(new String("Ç".getBytes(), "UTF-8"));
		oos.close();
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("contas.bin")));
		List<? extends Conta> contas;
		
		if( (contas = cast(ois)) != null)
			System.out.println(contas + "\n "+
					contas.size());
		ois.close();
	}

	@SuppressWarnings("unchecked")
	private static ArrayList<? extends Conta> cast(ObjectInputStream ois) throws IOException, ClassNotFoundException {
		if(ois != null)
			return (ArrayList<? extends Conta>) ois.readObject();
		return null;
	}
}
