package br.com.bytebank.banco.modelo;

public class Cliente {
	private String nome;
	private String cpf;
	private String profissao;
	private Integer id;

	public Cliente(String nome, String cpf, String profissao, Integer id) {
		if (nome != null && cpf != null && profissao != null) {
			this.nome = nome;
			this.cpf = cpf;
			this.profissao = profissao;
			this.id = id;
		}
	}

	public Cliente(String nome, String cpf, String profissao) {
		if (nome != null && cpf != null && profissao != null) {
			this.nome = nome;
			this.cpf = cpf;
			this.profissao = profissao;
		}
	}

	public Cliente() {
	}

	public Cliente(String nome, String cpf) {
		if (nome != null)
			this.nome = nome;

		if (cpf != null)
			this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public int getId() {
		return id;
	}

	public void setId(int i) {
		id = i;
	}
	
	@Override
	public String toString() {
		return String.format("Nome do Cliente - %s, CPF - %s, Profissão - %s", nome, cpf, profissao);
	}
}
