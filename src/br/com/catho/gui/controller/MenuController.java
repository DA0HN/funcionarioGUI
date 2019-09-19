package br.com.catho.gui.controller;

import java.net.URL;
import java.util.ResourceBundle;

import br.com.catho.gui.view.Menu;
import br.com.catho.gui.view.ViewFactory;
import br.com.catho.util.ButtonOnAction;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
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
		
		ViewFactory.createAlterar().start( new Stage() );
		Menu.close();
	}
	
	@FXML void btCadastroOnClicked(MouseEvent event) {	
		ViewFactory.createCadastro().start(new Stage());
		Menu.close();
		
	}
	
	@FXML void btExcluirOnClicked(MouseEvent event) {
		ViewFactory.createExcluir().start(new Stage());
		Menu.close();
	}
	
	@FXML void btListarTodosOnClicked(MouseEvent event) {
		ViewFactory.createListar().start(new Stage());
		//MainProgram.close();
	}
	
	@FXML void btNumeroDeFuncionariosOnClicked(MouseEvent event) {
		
	}
	
	@FXML void btSairOnClicked(MouseEvent event) {
		Menu.close();
	}
	
	@FXML void btAlterarOnKeyPressed(KeyEvent event) {
		if( ButtonOnAction.hasUserConfirmed(event) ) {
			ViewFactory.createAlterar().start( new Stage() );
		}
	}
	
	@FXML void btCadastroOnKeyPressed(KeyEvent event) { 
		if( ButtonOnAction.hasUserConfirmed(event) ) {
			ViewFactory.createCadastro().start( new Stage() );
		}
	}
	
	@FXML void btExcluirOnKeyPressed(KeyEvent event) {
		if( ButtonOnAction.hasUserConfirmed(event) ) {
			ViewFactory.createExcluir().start( new Stage() );
		}
	}
	
	@FXML void btListarTodosOnKeyPressed(KeyEvent event) {
		if( ButtonOnAction.hasUserConfirmed(event) ) {
			ViewFactory.createListar().start(new Stage());
		}
		//MainProgram.close();
	}
	
	@FXML void btSairOnKeyPressed(KeyEvent event) {
		if( ButtonOnAction.hasUserConfirmed(event) ) {
			Menu.close();
		}
	}
	
}
