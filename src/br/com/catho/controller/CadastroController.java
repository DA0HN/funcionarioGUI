package br.com.catho.controller;

import java.net.URL;
import java.util.ResourceBundle;

import br.com.catho.application.Cadastro;
import br.com.catho.application.MainProgram;
import br.com.catho.model.FuncionarioCRUD;
import br.com.catho.util.ButtonOnAction;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class CadastroController implements Initializable{

	@FXML private TextField textFieldNome;
	@FXML private TextField textFieldCPF;
	@FXML private TextField textFieldFuncao;
	@FXML private Button btSair;
	@FXML private Button btCadastrar;
	
	
	private void getUserData() {
		try {
			String nome = textFieldNome.getText();
			String CPF = textFieldCPF.getText();
			String funcao = textFieldFuncao.getText();
			
			System.out.println(FuncionarioCRUD.cadastro(nome, CPF, funcao).toString());
			
		}catch(Exception e) {
			e.getMessage();
		}
	}
	
	@FXML void btCadastrarOnClicked(MouseEvent event) {
		getUserData();
	}
	
	@FXML void btCadastrarOnKeyPressed(KeyEvent event) {
		if( ButtonOnAction.hasUserConfirmed(event) ) {
			getUserData();
		}
	}
	
	@FXML void btSairOnClicked() {
		closeCadastroStage();
	}
	
	@FXML void btSairOnKeyPressed(KeyEvent event) {
		if( ButtonOnAction.hasUserConfirmed(event) ) {
			closeCadastroStage();
		}
	}
	
	private void closeCadastroStage() {
		MainProgram main = new MainProgram();
		main.start(new Stage());
		Cadastro.close();
	}
	
	@Override public void initialize(URL arg0, ResourceBundle arg1) {}
	
	
}
