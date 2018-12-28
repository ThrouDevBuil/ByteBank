package br.com.bytebank.banco.DAO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import br.com.bytebank.banco.modelo.Cliente;
import br.com.bytebank.banco.modelo.Conta;

public class BancoDAO {
	private List<Conta> contas;
//	Os arquivos Comma-separated values, também conhecido como CSV, são arquivos de texto 
//	de formato regulamentado pelo RFC 4180, que faz uma ordenação de bytes ou um formato de 
//	terminador de linha, separando valores com vírgulas.[1] Ele comumente é usado em softwares offices, 
//	tais como o Microsoft Excel e o LibreOffice Calc.[2][3]
	
	public BancoDAO() {
		contas = new ArrayList<>();
	}
	
	public void setConta(Conta conta) throws IOException {
		writeFile(conta);
	}
	
	private void writeFile(Conta conta) throws UnsupportedEncodingException, FileNotFoundException {
		PrintStream ps = new PrintStream(new FileOutputStream(new File("bytebank.csv"), true), true, "UTF-8");
		
		ps.println(String.format(new Locale("pt", "BR"), "%s,%04d,%04d,%s,%s,%s,%08.2f",
				conta.typeAccount(), conta.getAgencia(), conta.getNumero(), 
				conta.getTitular().getNome(), conta.getTitular().getCpf(), conta.getTitular().getProfissao(),
				conta.getSaldo()));
		ps.close();
	}
	
	public void setContas(List<? extends Conta> contas) throws IOException {
		for(Conta conta : contas)
			writeFile(conta);
	}
	
	public Conta scan(String linha) {
		Scanner scanner = new Scanner(linha);
		
		scanner.useDelimiter(",");
		scanner.useLocale(Locale.US);
		
		String typeAccount = scanner.next();
		int agencia = scanner.nextInt();
		int numero = scanner.nextInt();
		String nomeTitular = scanner.next();
		String cpf = scanner.next();
		String profissao = scanner.next();
		double saldo = scanner.nextDouble();
		
		Conta cc = instanceOfAccount(typeAccount, agencia, numero);
		cc.setTitular(new Cliente(nomeTitular, cpf, profissao));
		cc.deposita(saldo);
		
		scanner.close();
		return cc;
	}
	
	public List<? extends Conta> getContas() throws IOException {
		
		Scanner scan = new Scanner(new FileInputStream(new File("bytebank.csv")));
		
		while(scan.hasNextLine()) {
			String linha = scan.nextLine();
			Conta cc = scan(linha);
			if(!compareAccount(cc))
				contas.add(cc);
		}
		scan.close();
		return (ArrayList<? extends Conta>) contas;
	}
	
	public Conta getConta(Conta c) throws IOException {
		
		Scanner scan = new Scanner(new FileInputStream(new File("bytebank.csv")));
		
		while(scan.hasNextLine()) {
			String linha = scan.nextLine();
			Conta cc = scan(linha);
			if(equalAccount(c, cc)) {
				scan.close();
				return cc;
			}
		}
		scan.close();
		return null;
	}
	
	private boolean equalAccount(Conta c1, Conta c2) {
		return c1.equals(c2);
	}

	private boolean compareAccount(Conta conta) {
		if(contas.size() >= 1) {
			
			for(Conta account : contas) {
				
				if(account.equals(conta)) 
					return true;
			}
		}
		return false;
	}
//	Um padrão de projeto é uma solução elegante para um problema que é recorrente no dia-a-dia do desenvolvedor.
//	Ou seja, por mais que desenvolvamos projetos diferentes, muitos dos problemas se repetem. 
//	Padrões de projeto são soluções elegantes e flexíveis para esses problemas.

//	Design Patterns:
//		Chain of Responsability
	private Conta instanceOfAccount(String typeAccount, int agencia, int numero) {
		return new Instanciador().instaciar(typeAccount, agencia, numero);
	}
}