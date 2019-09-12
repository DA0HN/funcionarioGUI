package br.com.catho.model.entities;

public class Funcionario {
	
	private String nome;
	private String cpf;
	private String funcao;
	
	private final int matricula;
	private static int numeroDeFuncionarios = 1;
	
	public Funcionario(){
		matricula = numeroDeFuncionarios++;
	}
	
	public Funcionario(String nome, String cpf, String funcao) {
		this.nome = nome;
		this.cpf = cpf;
		this.funcao = funcao;
		matricula = numeroDeFuncionarios++;
		
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
	public int getMatricula() {
		return matricula;
	}
	public static int getNumeroDeFuncionarios() {
		return numeroDeFuncionarios;
	}
	@Override public String toString() {
		return  "[ Nome: " + nome +
				", cpf: " + cpf +
				", função: " + funcao +
				", matricula: " + matricula +
				" ]";
		
	}
}
