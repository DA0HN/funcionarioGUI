package br.com.catho.controller;

import java.net.URL;
import java.util.ResourceBundle;

import br.com.catho.model.Funcionario;
import br.com.catho.model.FuncionarioCRUD;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ListarTodosController implements Initializable{
	
	@FXML private TableView<Funcionario> tableFuncionario;
	@FXML private TableColumn<Funcionario, String> colNome;
	@FXML private TableColumn<Funcionario, String> colCPF;
	@FXML private TableColumn<Funcionario, String> colFuncao;
	@FXML private Button btAtualizar;
	private ObservableList<Funcionario> observableList; 

    @FXML void btAtualizarOnClicked() {
    	initTableView();
    }
	
	
	@Override public void initialize(URL arg0, ResourceBundle arg1) { 
		initTableView();
	}
	
	public void initTableView() {
		// TODO: implementar padrao observable para correcao do bug de interacao com a classe AlterarController 
		colNome.setCellValueFactory(new PropertyValueFactory<>("nome") );
		colCPF.setCellValueFactory(new PropertyValueFactory<>("cpf") );
		colFuncao.setCellValueFactory(new PropertyValueFactory<>("funcao") );
		
		setObservableList(atualizaTabela());
		
		tableFuncionario.setItems(observableList);
		
	}
	
	public ObservableList<Funcionario> getObservableList() {
		return observableList;
	}

	public void setObservableList(ObservableList<Funcionario> observableList) {
		this.observableList = observableList;
	}

	public ObservableList<Funcionario> atualizaTabela(){
		return FXCollections.observableArrayList( FuncionarioCRUD.getFuncionarios() );
	}
}
