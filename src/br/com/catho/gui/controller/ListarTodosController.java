package br.com.catho.gui.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import br.com.catho.gui.exceptions.GUIException;
import br.com.catho.gui.listeners.DataChangeListener;
import br.com.catho.model.entities.Funcionario;
import br.com.catho.model.repository.DaoFactory;
import br.com.catho.model.service.FuncionarioService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class ListarTodosController implements Initializable, DataChangeListener {
	
	@FXML private TableView<Funcionario> tableFuncionario;
	@FXML private TableColumn<Funcionario, String> colNome;
	@FXML private TableColumn<Funcionario, String> colCPF;
	@FXML private TableColumn<Funcionario, String> colFuncao;
	@FXML private Button btAtualizar;
	private FuncionarioService service = DaoFactory.createFuncionarioDao();
	private ObservableList<Funcionario> observableList; 

    @FXML void btAtualizarOnClicked(MouseEvent event) {
    	try {
			
			onDataChanged();
			
		}
    	catch (NullPointerException e ) {
			throw new GUIException( e.getMessage() );
		}
    }
	
	
	@Override public void initialize(URL arg0, ResourceBundle arg1) { 
		CadastroController controller = new CadastroController();
		controller.subscribeDataChangeListener(this);
		initializeTableView();
	}
	
	public void initializeTableView() {
		// TODO: implementar padrao observable para correcao do bug de interacao com a classe AlterarController 
		
		colNome.setCellValueFactory(new PropertyValueFactory<>("nome") );
		colCPF.setCellValueFactory(new PropertyValueFactory<>("cpf") );
		colFuncao.setCellValueFactory(new PropertyValueFactory<>("funcao") );
		
		atualizaTabela();
	}
	
	
	
	public void atualizaTabela(){
		List<Funcionario> list = service.findAll();
		observableList = FXCollections.observableArrayList(list);
		tableFuncionario.setItems(observableList);
		
	}


	@Override public void onDataChanged() {
		atualizaTabela();
	}
}
