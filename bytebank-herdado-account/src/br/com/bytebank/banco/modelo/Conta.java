package br.com.bytebank.banco.modelo;

import java.io.UnsupportedEncodingException;
import java.util.Locale;

/**
 * Classe representa a moldura de uma conta
 * 
 * @author Elvis de Sousa
 * @version 0.1
 */
//Para ordernar uma lista � preciso definir um crit�rio de ordena��o
//Pela interface Comparator
//Pela interface Comparable (ordem natural)
//Comparable para definir a ordem natural dos elementos!
//A interface Comparable exige uma implementa��o do m�todo compareTo. 
public abstract class Conta implements Comparable<Conta>, java.io.Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected double saldo;
    private int agencia;
    private int numero;
    private transient Cliente titular;
    private static int total = 0;
    //             Default:
    //<<package private>> (vis�vel na classe e em qualquer outro membro do mesmo pacote, 
    //podendo ser chamado de default)
    
    //             Protected:
    //Protected (vis�vel na classe e em qualquer outro membro do mesmo pacote e para qualquer filho)

    //             Private: 
    //(Vis�vel apenas na classe)
    
    //             Public:
    //public (vis�vel em qualquer pacote)
    
    public Conta(int agencia, int numero){
        Conta.total++;
        this.agencia = agencia;
        this.numero = numero;
    }

    public abstract void deposita(double valor) throws SaldoInsuficienteException;
    
    /**
     * 
     * @param valor
     * @throws SaldoInsuficienteException
     */
    public void saca(double valor) throws SaldoInsuficienteException {
    	
        if(this.saldo < valor) {
            throw new SaldoInsuficienteException("Saldo: " + this.saldo + ", Valor: " + valor);
        }
        this.saldo -= valor;       
    }

    /**
     * M�todo para efetuar a transfer�ncia entre objetos do tipo conta
     * @param valor - Valor que ser� transferido da conta
     * @param destino - Conta que receber� o saldo transferido
     * @throws SaldoInsuficienteException, NullPointerException
     * @author elvis
     */
    public void transfere(double valor, Conta destino) throws SaldoInsuficienteException, NullPointerException {
        this.saca(valor);
        if(destino == null) {
        	throw new NullPointerException("Conta de destino inexistente!");
        }
        destino.deposita(valor);
    }

    public double getSaldo(){
        return this.saldo;
    }

    public int getNumero(){
        return this.numero;
    }

    public void setNumero(int numero){
        if(numero <= 0) {
            System.out.println("Nao pode valor menor igual a 0");
            return;
        }
        this.numero = numero << 2;
    }

    public int getAgencia(){
        return this.agencia;
    }

    public void setAgencia(int agencia){
       
    	if(agencia <= 0) {
           System.out.println("Nao pode valor menor igual a 0");
           return;
       }
       this.agencia = agencia;
    }

    public void setTitular(Cliente titular) throws NullPointerException {
        
    	if(titular == null) {
    		throw new NullPointerException("Titular inexistente!!");
    	}
    	this.titular = titular;
    }

    public Cliente getTitular(){
        return this.titular;
    }

    public static int getTotal(){
        return Conta.total;
    }

    @Override
    public String toString() {
    	return String.format(new Locale("pt", "BR"),
    			/*"Nome do cliente - %s*/"%nAg�ncia: %04d%nN�mero: %04d"
    			+ "%nSaldo dispon�vel - R$%08.2f", /*titular.getNome(),*/ 
    			this.agencia, this.numero, this.saldo);
    }
    
    //Ordem Natural
    //� a ordem definida pelo pr�prio elemento da lista.
    //Definindo um crit�rio de ordena��o pr�prio atrav�s da interface comparable 
    @Override
    public int compareTo(Conta c) {
    	return Double.compare(this.saldo, c.saldo);
    }	
    
    public abstract String typeAccount() throws UnsupportedEncodingException;
    
    @Override
    public boolean equals(Object o) {
    	if(o == null)
    		return false;
    	
    	if(!(o instanceof Conta))
    		return false;
    	
    	Conta c = (Conta)o;
    	return ((Integer.compare(this.numero, c.numero) == 0) && Integer.compare(this.agencia, c.agencia) == 0);
    }
}