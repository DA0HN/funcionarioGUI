package br.com.catho.view;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Alterar extends Application{

	private static Stage stage;
	
	@Override public void start(Stage stage) {
		try {
			Parent parent = FXMLLoader.load(getClass().getResource("../fxml/Alterar.fxml"));
			Scene scene = new Scene(parent);
			stage.setScene(scene);
			stage.setTitle("Alterar");
			stage.setResizable(false);
			setStage(stage);
			stage.show();
		}
		catch(IOException e) {
			e.getMessage();
		}
	}
	
	public static Stage getStage() {
		return Alterar.stage;
	}
	public static void setStage(Stage stage) {
		Alterar.stage = stage;
	}
	public static void close() {
		Alterar.getStage().close();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
