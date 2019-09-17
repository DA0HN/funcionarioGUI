package br.com.catho.controller;

import java.net.URL;
import java.util.ResourceBundle;

import br.com.catho.model.service.FuncionarioService;
import br.com.catho.util.ButtonOnAction;
import br.com.catho.view.Alterar;
import br.com.catho.view.Menu;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class AlterarController implements Initializable{
	
	@FXML private Button btCancelar;
	@FXML private Button btAlterar;
	@FXML private TextField textFieldNovoNome;
	@FXML private TextField textFieldNovoCPF;
	@FXML private TextField textFieldNovaFuncao;
	@FXML private TextField textFieldCPFDesejado;
	
	private void changeDataUser() {
		FuncionarioService.alteracao(
				textFieldCPFDesejado.getText(),
				textFieldNovoNome.getText(),
				textFieldNovoCPF.getText(),
				textFieldNovaFuncao.getText());
		
		// Atualiza a lista da View ListarTodos
		ListarTodosController view = new ListarTodosController();
		view.setObservableList(view.atualizaTabela());
		
	}
	
	@FXML void btAlterarOnClicked() {
		changeDataUser();
		closeAlterarStage();
	}
	
	@FXML void btAlterarOnKeyPressed(KeyEvent event) {
		if( ButtonOnAction.hasUserConfirmed(event)) {
			changeDataUser();
			closeAlterarStage();
		}
	}
	
	@FXML void btCancelarOnClicked() {
		closeAlterarStage();
	}
	
	@FXML void btCancelarOnKeyPressed(KeyEvent event) {
		if( ButtonOnAction.hasUserConfirmed(event) )
			closeAlterarStage();
			
	}
	private void closeAlterarStage() {
		Menu main = new Menu();
		main.start(new Stage());
		Alterar.close();
	}
	@Override public void initialize(URL arg0, ResourceBundle arg1) {}

}
