package br.com.bytebank.banco.teste;

public class TesteString {
	
	public static void main(String[] args) {
		
		//Objetos da classe String são imutáveis. Isso significa que, 
		//uma vez criado, não podem ser alterado, 
		//por isso qualquer alteração cria um novo objeto String.
		String nome = "      Alura      "; //Object literal - Sintaxe literal
		//Objetos da classe String são imutáveis, pois não pode ser modificado após a sua inicialização.
		System.out.println(nome);
		//Retira todos os caracteres de "espaço"
		//da string
		nome = nome.trim();
		//Qualquer método da classe String devolve uma nova String que representa
		//a alteração
		//A classe String é uma CharSequence
		//Se for necessário concatenar muitos String utilizasse a classe StringBuilder
		
		
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
		 * 	- É uma classe, faz parte do pacote java.lang, modificador de visibilidade público (public)
		 * out 
		 *  - É um atributo de tipo abstrato de dado, modificador 
		 *  de visibilidade público, referência para um objeto, 
		 *  é um atributo da classe e não do objeto (static)
		 * println
		 *  - É um método, modificador de visibilidade público, não é static, possui sobrecargas,
		 *  não joga exceções do tipo checked
		 *  (Exceções que são verificadas pelo compilador e necessitam de um tratamento ou throws).
		 * */
		System.out.println(nome);
		System.out.println(outro);
		
		System.out.println(outro.contains("ur"));
		
		String texto = "banana,maçã,laranja";
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
