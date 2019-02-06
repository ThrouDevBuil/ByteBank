package br.com.bytebank.banco.modelo;

import java.io.UnsupportedEncodingException;
import java.util.Locale;

/**
 * Classe representa a moldura de uma conta
 * 
 * @author Elvis de Sousa
 * @version 0.1
 */

//Para ordernar uma lista é preciso definir um critério de ordenação
//Pela interface Comparator
//Pela interface Comparable (ordem natural)
//Comparable para definir a ordem natural dos elementos!
//A interface Comparable exige uma implementação do método compareTo. 
public abstract class Conta implements Comparable<Conta>, java.io.Serializable {

	// Atributos - Propriedades - Campos = Eles são as características que
	// especificam uma classe

	/*
	 * Os atributos possui um significado para objetos tem um comportamento
	 * diferente. Quando acionamos a palavra-chave new e o Java instancia o objeto,
	 * todo os campos são zerados.
	 */

	/**
	 * 
	 */

	// Atributo imutável - Depois de inserir um valor
	// na sua criação ele não é mais alterado

	// O java inicia o construtor se ele não for construido.
	// Construtor - É uma rotina de inicialização, só é executado apenas uma vez
	// no momento em que ele é criado.
	// Ele recebe parâmetros para que o objeto seja instanciado, ele restringe a
	// criação.
	private static final long serialVersionUID = 1L;
	protected double saldo;
	private Integer id;
	private int agencia;
	private int numero;
	private transient Cliente titular;
	private static int total = 0;

	// Default:
	// <<package private>> (visível na classe e em qualquer outro membro do mesmo
	// pacote,
	// podendo ser chamado de default)

	// Protected:
	// Protected (visível na classe e em qualquer outro membro do mesmo pacote e
	// para qualquer filho)

	// Private:
	// (Visível apenas na classe)

	// Public:
	// public (visível em qualquer pacote)
	
	public Conta(int agencia, int numero, double saldo, Integer id) {
		this.saldo = saldo;
		this.id = id;
		this.agencia = agencia;
		this.numero = numero;
	}

	public Conta(int agencia, int numero, double saldo) {
		this.agencia = agencia;
		this.numero = numero;
		this.saldo = saldo;
	}
	

	public Conta(int agencia, int numero) {
		Conta.total++;
		this.agencia = agencia;
		this.numero = numero;
	}

	/**
	 * 
	 * @param valor
	 * @throws SaldoInsuficienteException
	 */
	public abstract void deposita(double valor) throws SaldoInsuficienteException;

	/**
	 * 
	 * @param valor
	 * @throws SaldoInsuficienteException
	 */
	public void saca(double valor) throws SaldoInsuficienteException {

		if (this.saldo < valor)
			throw new SaldoInsuficienteException("Saldo: " + this.saldo + ", Valor: " + valor);
		this.saldo -= valor;
	}

	/**
	 * Método para efetuar a transferência entre objetos do tipo conta
	 * 
	 * @param valor   - Valor que será transferido da conta
	 * @param destino - Conta que receberá o saldo transferido
	 * @throws SaldoInsuficienteException, NullPointerException
	 * @author elvis
	 */
	public void transfere(double valor, Conta destino) throws SaldoInsuficienteException, NullPointerException {
		this.saca(valor);
		if (destino == null)
			throw new NullPointerException("Conta de destino inexistente!");
		destino.deposita(valor);
	}

	public double getSaldo() {
		return this.saldo;
	}

	public int getNumero() {
		return numero;
	}

	public Integer getId() {
		return id;
	}

	public void setNumero(int numero) {
		if (numero < 0)
			throw new IllegalArgumentException("Campo vázio!");
		this.numero = numero;
	}

	public int getAgencia() {
		return this.agencia;
	}

	public void setAgencia(int agencia) {
		if (agencia < 0)
			throw new IllegalArgumentException("Campo vázio!");
		this.agencia = agencia;
	}

	public void setTitular(Cliente titular) throws NullPointerException {

		if (titular == null)
			throw new NullPointerException("Titular inexistente!!");

		this.titular = titular;
	}

	public Cliente getTitular() {
		return this.titular;
	}

	public static int getTotal() {
		return Conta.total;
	}

	public abstract String typeAccount() throws UnsupportedEncodingException;

	@Override
	public String toString() {
		return String.format(new Locale("pt", "BR"),
				"Nome do cliente - %s%nAgência: %04d%nNúmero: %04d" + "%nSaldo disponível - R$%08.2f",
				titular.getNome(), this.agencia, this.numero, this.saldo);
	}

	// Ordem Natural
	// É a ordem definida pelo próprio elemento da lista.
	// Definindo um critério de ordenação próprio através da interface comparable
	@Override
	public int compareTo(Conta c) {
		return Double.compare(this.saldo, c.saldo);
	}

	@Override
	public boolean equals(Object o) throws NullPointerException, IllegalStateException {
		if (o == null)
			throw new NullPointerException("Conta não foi cadastrada!");

		if (!(o instanceof Conta))
			throw new IllegalStateException("O objeto cadastrado não é uma conta!");

		Conta c = (Conta) o;
		return Integer.compare(numero, c.numero) == 0 && Integer.compare(agencia, c.agencia) == 0;
	}

	public void setId(int id) {
		this.id = id;
	}
}