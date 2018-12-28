package br.com.bytebank.banco.DAO;

import br.com.bytebank.banco.modelo.Conta;

public interface Instace {
//			Design Patterns:
//	Padrões de projeto trata de técnicas de modelagem para resolver um problema comum na área de desenvolvimento de software, 
//  facilitando e melhorando a comunicação entre os desenvolvedores.
//	Apresentam soluções a problemas que, dentro de um determinado contexto, surgem com maior frequência. 
//	Para o desenvolvedor de sistemas os padrões de projeto são mecanismos significantes, 
//	pois tais padrões já foram aprimorados, testados e utilizados com base nas experiências de outros desenvolvedores de sistemas
//	Um grande problema pode ser decomposto em problemas menores. Assim, podem-se encontrar algumas similaridades com problemas 
//	resolvidos anteriormente e aplicar os padrões para obter as soluções desses problemas menores.	
//  Em suma, um design pattern descreve uma solução geral para um problema de design que ocorre com 
//	frequência na área de desenvolvimento de software. 	
		
//	Um padrão possui alguns elementos relevantes, são eles:  
//		a) Nome do Projeto: nome de referência (uma ou duas palavras) que descreve um problema, solução ou consequência de um projeto; 
//		b) Problema: descrição de um problema a ser resolvido através de algoritmos, estruturas de classe ou objetos, 
//		que tem soluções inflexíveis e que precisam ser analisados para obtenção de uma resposta; 
//		c) Solução: define os elementos que fazem parte do padrão de projeto, seus relacionamentos, comportamentos e responsabilidades; 
//		d) Consequências: O padrão também trata da estrutura, da dinâmica, das consequências negativas e positivas da aplicação. 
//		Além de oferecer outras opções que complementem para compensar algumas desvantagens e vantagens. 
//		Nem sempre é necessário usar padrão para resolver um determinado contexto; 
//		e) Reuso e Herança: uma das principais características na programação orientada a objetos é a utilização da herança, 
//		através dela que o reuso tem aumentado o potencial dos métodos de programação orientado a objetos e também dos 
//		padrões de projetos, pois foi graças a sua utilização que este conceito tem conquistado grandes desenvolvedores.
	
//	Um catálogo dos padrões de projeto foi feito por quatro projetistas (conhecidos como “Gang of Four”  - GoF) 
//	com base no paradigma de orientação a objetos, cujos padrões (vinte e três padrões coletados):
//			1 - Os Padrões de Criação abstraem o processo de instanciação. Torna um sistema independente de como seus objetos são criados, 
//			compostos e representados. Enquanto uma criação de classe através da herança varia a instancia, a criação de objeto delega 
//			a instancia para outro objeto.
	
//			2 - Nos Padrões Estruturais é feita a descrição da elaboração, associação e a organização entre objetos e classes/interfaces. 
//			Tem a possibilidade de relacionar objetos em estruturas mais complexas, 
//			ou definir como as classes são compostas ou herdadas a partir de outras. 
	
//			3 - Nos Padrões Comportamentais, definem o processo de comunicação entre objetos e classes.	
	
	
	//Chain of Responsibility
	Conta instance(String typeAccount, int agencia, int numero);
	void setProximo(Instace proximo);
}
