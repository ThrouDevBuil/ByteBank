package br.com.bytebank.banco.modelo;

public class Cliente {

    private String nome;
    private String cpf;
    private String profissao;
    
    public Cliente(String nome, String cpf, String profissao) {
    	if(nome != null && cpf != null && profissao != null) {
    		this.nome = nome;
    		this.cpf = cpf;
    		this.profissao = profissao;
    	}
    }
    
    public Cliente() {}
    
    public Cliente(String nome, String cpf) {
    	if(nome != null)
    		this.nome = nome;
    	
    	if(cpf != null)
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

}
