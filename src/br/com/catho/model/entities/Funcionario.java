package br.com.catho.model.entities;

public class Funcionario {
	
	private Integer id;
	private String nome;
	private String cpf;
	private String funcao;
	
	public Funcionario() {}
	
	public Funcionario(String nome, String cpf, String funcao) {
		this.nome = nome;
		this.cpf = cpf;
		this.funcao = funcao;
		
	}
	
	public Funcionario(Integer id, String nome, String cpf, String funcao) {
		this.nome = nome;
		this.cpf = cpf;
		this.funcao = funcao;
		this.id = id;
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
	public String getFuncao() {
		return funcao;
	}
	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
	public int getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Override public String toString() {
		return  "[ Nome: " + nome +
				", cpf: " + cpf +
				", função: " + funcao +
				", Id: " + id +
				" ]";
		
	}
}
