package br.com.catho.view;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Excluir extends Application{

	private static Stage stage;
	
	@Override public void start(Stage stage)  {
		try {
			Parent parent = FXMLLoader.load(getClass().getResource("../fxml/Excluir.fxml"));
			Scene scene = new Scene(parent);
			stage.setScene(scene);
			stage.setTitle("Excluir funcionário");
			stage.setResizable(false);
			setStage(stage);
			stage.show();
		}catch(IOException e) {
			System.out.println(e.getMessage()); 
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public static void close() {
		Excluir.getStage().close();
	}
	
	public static void setStage(Stage stage) {
		Excluir.stage = stage;
	}
	public static Stage getStage() {
		return Excluir.stage;
	}
}
