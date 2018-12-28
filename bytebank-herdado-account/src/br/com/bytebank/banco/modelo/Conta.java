package br.com.bytebank.banco.modelo;

import java.io.UnsupportedEncodingException;
import java.util.Locale;

/**
 * Classe representa a moldura de uma conta
 * 
 * @author Elvis de Sousa
 * @version 0.1
 */

/*
	- Uma classe � uma abstra��o do objeto
	- Uma especifica��o de um tipo, definindo atributos e comportamentos.
	- Um objeto � uma inst�ncia de uma classe onde podemos definir valores para seus atributos.
  	  (Em programa��o orientada a objetos,
   	  chama-se inst�ncia de uma classe, um objeto cujo comportamento e estado s�o
   	  definidos pela classe. "Inst�ncia" �, neste caso, um anglicismo,
   	  significando "caso" ou "exemplo" (em ingl�s instance).
   	  As inst�ncias de uma classe compartilham o mesmo conjunto de atributos,
   	  embora sejam diferentes quanto ao conte�do desses atributos.
   	  Inst�ncia � a concretiza��o de uma classe. Em termos intuitivos,
   	  uma classe � como um "molde" que gera inst�ncias de um certo tipo;
   	  um objeto � algo que existe fisicamente e que foi "moldado" na classe.
   	  Assim, em programa��o orientada a objetos, a palavra "instanciar" significa criar.
   	  Quando falamos em "instanciar um objeto", criamos fisicamente uma
   	  representa��o concreta da classe.
 - 	  Para criar uma inst�ncia precisamos usar a palavra chave new
*/

//Para ordernar uma lista � preciso definir um crit�rio de ordena��o
//Pela interface Comparator
//Pela interface Comparable (ordem natural)
//Comparable para definir a ordem natural dos elementos!
//A interface Comparable exige uma implementa��o do m�todo compareTo. 
public abstract class Conta implements Comparable<Conta>, java.io.Serializable {
	
	 //Atributos - Propriedades - Campos = Eles s�o as caracter�sticas que especificam uma classe

	/*
    Os atributos possui um significado para objetos tem um comportamento diferente.
    Quando acionamos a palavra-chave new e o Java instancia o objeto, todo os campos s�o zerados.
    */

    /*
      Estes atributos s�o vis�veis apenas nesta classe.
      Atributos n�o podem ser acessados pelo usu�rio
      Trabalhasse com o objeto atrav�s dos seus m�todos, que far�o as modifica��es nos atributos.
      Atributos s�o encapsulados e tratados atrav�s dos m�todos.
      Quando atributos privados s�o declarados eles n�o podem ser nem lidos,
      nem modificados por nenhuma outra classe al�m da pr�pria
      classe que os criou, eles est�o encapsulados(escondidos).
      Encapsulando os atributos o sistema est� protegido
      A implementa��o interna pode ser modificada sem afetar nenhum c�digo fora da  pr�pria classe
      Chamasse tamb�m de interface com o usu�rio.
    */
	
    /**
	 * 
	 */
	
	//Atributo imut�vel - Depois de inserir um valor
    //na sua cria��o ele n�o � mais alterado

    //O java inicia o construtor se ele n�o for construido.
    //Construtor - � uma rotina de inicializa��o, s� � executado apenas uma vez
    //no momento em que ele � criado.
    //Ele recebe par�metros para que o objeto seja instanciado, ele restringe a cria��o.
	
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
        
    	if(titular == null)
    		throw new NullPointerException("Titular inexistente!!");
  
    	this.titular = titular;
    }

    public Cliente getTitular(){
        return this.titular;
    }

    public static int getTotal(){
        return Conta.total;
    }
    
	public abstract String typeAccount() throws UnsupportedEncodingException;

    @Override
    public String toString() {
    	return String.format(new Locale("pt", "BR"),
    			"Nome do cliente - %s%nAg�ncia: %04d%nN�mero: %04d"
    			+ "%nSaldo dispon�vel - R$%08.2f", titular.getNome(), 
    			this.agencia, this.numero, this.saldo);
    }
    
    //Ordem Natural
    //� a ordem definida pelo pr�prio elemento da lista.
    //Definindo um crit�rio de ordena��o pr�prio atrav�s da interface comparable 
    @Override
    public int compareTo(Conta c) {
    	return Double.compare(this.saldo, c.saldo);
    }
    
    @Override
    public boolean equals(Object o) {
    	if(o == null)
    		throw new NullPointerException("Conta n�o foi cadastrada!");
    	
    	if(!(o instanceof Conta))
    		return false;
    	
    	Conta c = (Conta)o;
    	return ((Integer.compare(this.numero, c.numero) == 0) && Integer.compare(this.agencia, c.agencia) == 0);
    }
}