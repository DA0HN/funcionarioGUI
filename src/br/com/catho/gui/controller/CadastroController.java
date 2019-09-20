package br.com.catho.gui.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import br.com.catho.database.DatabaseException;
import br.com.catho.gui.exceptions.GUIException;
import br.com.catho.gui.listeners.DataChangeListener;
import br.com.catho.gui.view.Cadastro;
import br.com.catho.gui.view.ViewFactory;
import br.com.catho.model.entities.Funcionario;
import br.com.catho.model.repository.DaoFactory;
import br.com.catho.model.service.FuncionarioService;
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
	
	private List<DataChangeListener> dataChangeListeners = new ArrayList<>();
	
	private void getUserData() {
		try {
			String nome = textFieldNome.getText();
			String CPF = textFieldCPF.getText();
			String funcao = textFieldFuncao.getText();
			
			if(nome.isBlank() || nome.isEmpty() || CPF.isBlank() || CPF.isEmpty() || funcao.isBlank() || funcao.isEmpty() ) {
				throw new IllegalStateException("Os dados inseridos s�o inv�lidos");
			}
			
			//System.out.println(FuncionarioServiceLocal.cadastro(nome, CPF, funcao).toString());
			
			Funcionario funcionario = new Funcionario(nome, CPF, funcao);
			
			FuncionarioService service = DaoFactory.createFuncionarioDao();
			
			service.save(funcionario);
			
			System.out.println(funcionario);
			
			notifyDataChangeListeners();
			
			
		}
		catch(IllegalStateException e ) {
			throw new GUIException(e.getMessage());
		}
	}
	
	// notifica sobre o evento todos que est�o inscritos 
	private void notifyDataChangeListeners() {
		
		try {
			for(DataChangeListener listener  : dataChangeListeners ) {
				listener.onDataChanged();
			}
		} 
		catch (NullPointerException e) {
			throw new GUIException("N�o foi possivel notificar as novas altera��es!");
		}
	}

	public void subscribeDataChangeListener(DataChangeListener listener ) {
		dataChangeListeners.add(listener);
	}
	
	@FXML void btCadastrarOnClicked(MouseEvent event) {
		getUserData();
		closeCadastroStage();
		
	}
	
	@FXML void btCadastrarOnKeyPressed(KeyEvent event) {
		if( ButtonOnAction.hasUserConfirmed(event) ) {
			getUserData();
			closeCadastroStage();
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
		ViewFactory.createMenu().start(new Stage());
		Cadastro.close();
	}
	
	@Override public void initialize(URL arg0, ResourceBundle arg1) {}
	
	
}
