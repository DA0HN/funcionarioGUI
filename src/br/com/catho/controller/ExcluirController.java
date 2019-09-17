package br.com.catho.controller;

import br.com.catho.model.service.FuncionarioService;
import br.com.catho.util.ButtonOnAction;
import br.com.catho.view.Excluir;
import br.com.catho.view.Menu;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class ExcluirController {

	@FXML private Button btExcluir;
	@FXML private Button btCancelar;	
	@FXML private TextField textFieldCPF;
	
	private void closeExcluirStage() {
		Menu main = new Menu();
		main.start(new Stage());
		Excluir.close();
	}
	
	private void removeUserData() {
		String cpf = textFieldCPF.getText();
		FuncionarioService.exclusao(cpf);
	}
	
	@FXML void btCancelarOnClicked() {
		closeExcluirStage();
	}
	
	@FXML void btCancelarOnKeyPressed(KeyEvent event) {
		if( ButtonOnAction.hasUserConfirmed(event) ) {
			closeExcluirStage();
		}
	}
	
	@FXML void btExcluirOnClicked() {
		removeUserData();
		closeExcluirStage();
	}
	
	@FXML void btExcluirOnKeyPressed(KeyEvent event) {
		if( ButtonOnAction.hasUserConfirmed(event)) {
			removeUserData();
			closeExcluirStage();
		}
	}
	
	@FXML void textFieldCPFOnKeyPressed(KeyEvent event) {
		if( ButtonOnAction.hasEnterPressed(event)) {
			removeUserData();
			closeExcluirStage();
		}
	}


}

