package br.com.catho.view;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ListarTodos extends Application{

	private static Stage stage;
	
	@Override public void start(Stage stage) {
		try {
			Parent parent = FXMLLoader.load(getClass().getResource("../fxml/ListarTodos.fxml"));
			Scene scene = new Scene(parent);
			stage.setScene(scene);
			stage.setTitle("Listar Todos Funcionarios");
			stage.setResizable(false);
			setStage(stage);
			stage.show();
		}
		catch(IOException e) {
			e.getMessage();
		}
		
	}
	
	public static void setStage(Stage stage) {
		ListarTodos.stage = stage;
	}
	public static Stage getStage() {
		return ListarTodos.stage;
	}
	public static void close() {
		ListarTodos.getStage().close();
	}
}
