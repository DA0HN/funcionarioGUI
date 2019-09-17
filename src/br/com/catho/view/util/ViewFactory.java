package br.com.catho.view.util;

import br.com.catho.view.Alterar;
import br.com.catho.view.Cadastro;
import br.com.catho.view.Excluir;
import br.com.catho.view.ListarTodos;
import br.com.catho.view.Menu;

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
