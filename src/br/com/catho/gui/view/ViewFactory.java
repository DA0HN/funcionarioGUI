package br.com.catho.gui.view;

public class ViewFactory {
	
	public static Menu createMenu() {
		return new Menu();
	}
	
	public static Cadastro createCadastro() {
		return new Cadastro();
	}
	
	public static Alterar createAlterar() {
		return new Alterar();
	}
	
	public static ListarTodos createListar() {
		return new ListarTodos();
	}
	
	public static Excluir createExcluir() {
		return new Excluir();
	}
}
