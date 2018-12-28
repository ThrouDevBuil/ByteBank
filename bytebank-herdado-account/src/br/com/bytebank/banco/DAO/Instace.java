package br.com.bytebank.banco.DAO;

import br.com.bytebank.banco.modelo.Conta;

public interface Instace {
//			Design Patterns:
//	Padr�es de projeto trata de t�cnicas de modelagem para resolver um problema comum na �rea de desenvolvimento de software, 
//  facilitando e melhorando a comunica��o entre os desenvolvedores.
//	Apresentam solu��es a problemas que, dentro de um determinado contexto, surgem com maior frequ�ncia. 
//	Para o desenvolvedor de sistemas os padr�es de projeto s�o mecanismos significantes, 
//	pois tais padr�es j� foram aprimorados, testados e utilizados com base nas experi�ncias de outros desenvolvedores de sistemas
//	Um grande problema pode ser decomposto em problemas menores. Assim, podem-se encontrar algumas similaridades com problemas 
//	resolvidos anteriormente e aplicar os padr�es para obter as solu��es desses problemas menores.	
//  Em suma, um design pattern descreve uma solu��o geral para um problema de design que ocorre com 
//	frequ�ncia na �rea de desenvolvimento de software. 	
		
//	Um padr�o possui alguns elementos relevantes, s�o eles:  
//		a) Nome do Projeto: nome de refer�ncia (uma ou duas palavras) que descreve um problema, solu��o ou consequ�ncia de um projeto; 
//		b) Problema: descri��o de um problema a ser resolvido atrav�s de algoritmos, estruturas de classe ou objetos, 
//		que tem solu��es inflex�veis e que precisam ser analisados para obten��o de uma resposta; 
//		c) Solu��o: define os elementos que fazem parte do padr�o de projeto, seus relacionamentos, comportamentos e responsabilidades; 
//		d) Consequ�ncias: O padr�o tamb�m trata da estrutura, da din�mica, das consequ�ncias negativas e positivas da aplica��o. 
//		Al�m de oferecer outras op��es que complementem para compensar algumas desvantagens e vantagens. 
//		Nem sempre � necess�rio usar padr�o para resolver um determinado contexto; 
//		e) Reuso e Heran�a: uma das principais caracter�sticas na programa��o orientada a objetos � a utiliza��o da heran�a, 
//		atrav�s dela que o reuso tem aumentado o potencial dos m�todos de programa��o orientado a objetos e tamb�m dos 
//		padr�es de projetos, pois foi gra�as a sua utiliza��o que este conceito tem conquistado grandes desenvolvedores.
	
//	Um cat�logo dos padr�es de projeto foi feito por quatro projetistas (conhecidos como �Gang of Four�  - GoF) 
//	com base no paradigma de orienta��o a objetos, cujos padr�es (vinte e tr�s padr�es coletados):
//			1 - Os Padr�es de Cria��o abstraem o processo de instancia��o. Torna um sistema independente de como seus objetos s�o criados, 
//			compostos e representados. Enquanto uma cria��o de classe atrav�s da heran�a varia a instancia, a cria��o de objeto delega 
//			a instancia para outro objeto.
	
//			2 - Nos Padr�es Estruturais � feita a descri��o da elabora��o, associa��o e a organiza��o entre objetos e classes/interfaces. 
//			Tem a possibilidade de relacionar objetos em estruturas mais complexas, 
//			ou definir como as classes s�o compostas ou herdadas a partir de outras. 
	
//			3 - Nos Padr�es Comportamentais, definem o processo de comunica��o entre objetos e classes.	
	
	
	//Chain of Responsibility
	Conta instance(String typeAccount, int agencia, int numero);
	void setProximo(Instace proximo);
}
