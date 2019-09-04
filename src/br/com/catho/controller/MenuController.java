package br.com.catho.controller;

import java.net.URL;
import java.util.ResourceBundle;

import br.com.catho.application.Alterar;
import br.com.catho.application.Cadastro;
import br.com.catho.application.Excluir;
import br.com.catho.application.ListarTodos;
import br.com.catho.application.MainProgram;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class MenuController implements Initializable{

	@FXML private Button btCadastro;
	@FXML private Button btEcluir;
	@FXML private Button btAlterar;
	@FXML private Button btListarTodos;
	@FXML private Button btNumeroDeFuncionarios;
	@FXML private Button btSair;
	
	@Override public void initialize(URL arg0, ResourceBundle arg1) {}
	
	
	@FXML void btAlterarOnClicked(MouseEvent event) {
		
		Alterar alterar = new Alterar();
		alterar.start( new Stage() );
		MainProgram.close();
	}
	
	@FXML void btCadastroOnClicked(MouseEvent event) {	
		Cadastro cadastro = new Cadastro();
		cadastro.start(new Stage());
		MainProgram.close();
		
	}
	
	@FXML void btExcluirOnClicked(MouseEvent event) {
		Excluir excluir = new Excluir();
		excluir.start(new Stage());
		MainProgram.close();
	}
	
	@FXML void btListarTodosOnClicked(MouseEvent event) {
		ListarTodos listar = new ListarTodos();
		listar.start(new Stage());
		//MainProgram.close();
	}
	
	@FXML void btNumeroDeFuncionariosOnClicked(MouseEvent event) {
		
	}
	
	@FXML void btSairOnClicked(MouseEvent event) {
		MainProgram.close();
	}
	
}
