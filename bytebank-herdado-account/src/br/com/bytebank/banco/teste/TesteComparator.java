package br.com.bytebank.banco.teste;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import br.com.bytebank.banco.modelo.Cliente;
import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;
import br.com.bytebank.banco.modelo.ContaPoupanca;

public class TesteComparator {

	public static void main(String[] args) {
		
		Conta cc1 = new ContaCorrente(22, 33-02);
        Cliente clienteCC1 = new Cliente();
        clienteCC1.setNome("Nico");
        cc1.setTitular(clienteCC1);
        cc1.deposita(333.0);

        Conta cc2 = new ContaPoupanca(22, 44-01);
        Cliente clienteCC2 = new Cliente();
        clienteCC2.setNome("Guilherme");
        cc2.setTitular(clienteCC2);
        cc2.deposita(444.0);

        Conta cc3 = new ContaCorrente(22, 11-12);
        Cliente clienteCC3 = new Cliente();
        clienteCC3.setNome("Paulo");
        cc3.setTitular(clienteCC3);
        cc3.deposita(111.0);

        Conta cc4 = new ContaPoupanca(22, 22-02);
        Cliente clienteCC4 = new Cliente();
        clienteCC4.setNome("Ana");
        cc4.setTitular(clienteCC4);
        cc4.deposita(222.0);


        List<Conta> lista = new ArrayList<>();
        lista.addAll(Arrays.asList(cc1, cc2, cc3, cc4));

/*        for (Conta conta : lista) {
                System.out.println(conta);
        }
*/		//Uma lista é uma coleção que permite elementos duplicados 
        //e mantém uma ordenação específica entre os elementos.
        List<String> strings = new ArrayList<>();
        strings.add("e");
        strings.add("l");
        strings.add("v");
        strings.add("i");
        strings.add("s");
        
        for(String string : strings) {
        	System.out.println(string);
        }
        
        //Function Object - Um objeto que criamos para encapsular uma função ou método.
        //As classes anônimas facilitam um pouco a criação desses objetos.
        //NumeroDaContaComparator comparator = new NumeroDaContaComparator();
        System.out.println("\n----------");
        
        //lista.sort(new TitularDaContaComparator());
        Collections.rotate(strings, -1);
        for(String string : strings) {
        	System.out.println(string);
        }
        
        
        //Ordena da forma natural
        //lista.sort(null);
        
        /*Comparator<Conta> comp = new Comparator<Conta>() {Classe anônima que implementa a interface comparator
        	
        	@Override
        	public int compare(Conta c1, Conta c2) {
        		return Integer.compare(c1.getNumero(), c2.getNumero());
        	}
        };*/
        
        //Classe Anônima
        //Criando um objeto baseado na interface comparator, chamando o construtor
        /*lista.sort(new Comparator<Conta>() {
    		
    		@Override
    		public int compare(Conta c1, Conta c2) {
    			return Integer.compare(c1.getNumero(), c2.getNumero());
    		}
    	});*/
        
        //Sintaxe Lambda
        Comparator<Conta> comp = (Conta c1, Conta c2) -> {
        	return c1.getTitular().getNome().compareTo(c2.getTitular().getNome());
        };
        
        /*Uma função lambda é uma função sem declaração, isto é, não é necessário colocar um nome, 
         * um tipo de retorno e o modificador de acesso. 
         * A ideia é que o método seja declarado no mesmo lugar em que será usado. 
         * As funções lambda em Java tem a sintaxe definida como (argumento) -> (corpo),
         * Função anônima
         * () - Lista de argumentos (obrigatório)
         * -> - Indica que estamos utilizando uma expressão lambda
         */
        //O corpo não precisa ser definido com chaves nem precisa utilizar o return 
        //quando só existe uma instrução para ser executada
        //Dois argumentos do tipo conta
//        lista.sort( (c1, c2) -> Integer.compare(c1.getNumero(), c2.getNumero()) );//Corpo
        
        //Uma interface funcional tem apenas um método abstrato.
        //Um método abstrato que também for um método público na classe Object não será contado como esse método.
        //Uma interface funcional pode ter métodos padrão e métodos estáticos.
        
        /*lista.sort( (Conta c1, Conta c2) -> {
        	return Integer.compare(c1.getNumero(), c2.getNumero());
        });*/
        //Definindo os parâmetros de entrada
        //Após a seta (sintaxe de uma lambda) tem o código associado a entrada
        
        
        Iterator<? extends Conta> it = lista.iterator();
        
        System.out.println("\nIterator\n");
        while(it.hasNext()) {
        	System.out.println(it.next());
        }
        
        
        
        
        /*System.out.println("----------------");
        
        //O comparator é um parâmetro do método sort da lista e da classe Collections.
        Collections.sort(lista, new TitularDaContaComparator());
        Collections.sort(lista);
        System.out.println("----------------");
        Collections.reverse(lista);
        for(Conta conta : lista) {
        	System.out.println(conta);
        }
        System.out.println("----------------");
        Collections.shuffle(lista);
        for(Conta conta : lista) {
        	System.out.println(conta);
        }
*/        
/*        for (Conta conta : lista) {
			System.out.println(conta);
		}*/
	}
}

/*class TitularDaContaComparator implements Comparator<Conta> {

	@Override
	public int compare(Conta c1, Conta c2) {
		return c1.getTitular().getNome().compareTo(c2.getTitular().getNome());
	}
	
}*/

//class NumeroDaContaComparator implements Comparator<Conta> {
//
//@Override
//public int compare(Conta c1, Conta c2) {
//return Integer.compare(c1.getNumero(), c2.getNumero());
//		return c1.getNumero() - c2.getNumero(); 
/*
 * if(c1.getNumero() < c2.getNumero()) { return -1; } if(c1.getNumero() >
 * c2.getNumero()) { return 1; } return 0;
 */