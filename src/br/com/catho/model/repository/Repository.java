package br.com.catho.model.repository;

public enum Repository {
	SAVE("INSERT INTO funcionario (nome,cpf,funcao) VALUES (?,?,?)"),
	UPDATE("UPDATE funcionario SET nome=?, cpf=?, funcao=? WHERE id=?"),
	DELETE_BY_ID("DELETE FROM funcionario WHERE id = ?"),
	DELETE_BY_CPF("DELETE FROM funcionario WHERE cpf = ?"),
	FIND_BY_ID("SELECT * FROM funcionario WHERE funcionario.id = ?"),
	FIND_BY_CPF("SELECT * FROM funcionario WHERE funcionario.cpf = ?"),
	FIND_ALL("SELECT * FROM funcionario");
	
	private String value;
	
	Repository(String value){
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
}
