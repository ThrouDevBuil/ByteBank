package br.com.bytebank.banco.teste;

public class TesteString {
	
	public static void main(String[] args) {
		
		//Objetos da classe String s�o imut�veis. Isso significa que, 
		//uma vez criado, n�o podem ser alterado, 
		//por isso qualquer altera��o cria um novo objeto String.
		String nome = "      Alura      "; //Object literal - Sintaxe literal
		//Objetos da classe String s�o imut�veis, pois n�o pode ser modificado ap�s a sua inicializa��o.
		System.out.println(nome);
		//Retira todos os caracteres de "espa�o"
		//da string
		nome = nome.trim();
		//Qualquer m�todo da classe String devolve uma nova String que representa
		//a altera��o
		//A classe String � uma CharSequence
		//Se for necess�rio concatenar muitos String utilizasse a classe StringBuilder
		
		
		System.out.println(nome.length());
		System.out.println("---------------");
		System.out.println(nome.matches("alura"));
		System.out.println("---------------");
		System.out.println(nome.indexOf("ra"));
		System.out.println(nome);
		
		System.out.println(nome.substring(3));
		
		String vazio = "";
		
		System.out.println(vazio.isEmpty());
		
		//Substitui o caracter "A" por 'a'
		String outro = nome.replace('A', 'a');
		nome = nome.replace("Al", "aL");
		
			
		/*System.out.println();
		 * 
		 * System 
		 * 	- � uma classe, faz parte do pacote java.lang, modificador de visibilidade p�blico (public)
		 * out 
		 *  - � um atributo de tipo abstrato de dado, modificador 
		 *  de visibilidade p�blico, refer�ncia para um objeto, 
		 *  � um atributo da classe e n�o do objeto (static)
		 * println
		 *  - � um m�todo, modificador de visibilidade p�blico, n�o � static, possui sobrecargas,
		 *  n�o joga exce��es do tipo checked
		 *  (Exce��es que s�o verificadas pelo compilador e necessitam de um tratamento ou throws).
		 * */
		System.out.println(nome);
		System.out.println(outro);
		
		System.out.println(outro.contains("ur"));
		
		String texto = "banana,ma��,laranja";
		String[] frutas = texto.split(",");
		
		System.out.println(frutas[0] + "\n" + frutas[1] + "\n" + frutas[2]);
		
//		String outro = nome.replace("A", "a");
//		
//		String outro = nome.toLowerCase();
//		
//		System.out.println(nome);
//	
//		System.out.println(outro);
	}
}
