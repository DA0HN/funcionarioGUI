package br.com.catho.application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Cadastro extends Application {

	private static Stage stage;
	
	@Override public void start(Stage stage) {
		try {
			Parent parent = FXMLLoader.load(getClass().getResource("../view/Cadastro.fxml"));
			Scene scene = new Scene(parent);
			stage.setTitle("Cadastro");
			stage.setResizable(false);
			stage.setScene(scene);
			setStage(stage);
			stage.show();
		}
		catch(IOException e) {
			e.getMessage();
		}
	}
	public static void close() {
		Cadastro.getStage().close();
	}
	public static Stage getStage() {
		return Cadastro.stage;
	}
	public static void setStage(Stage stage) {
		Cadastro.stage = stage;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
