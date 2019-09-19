package br.com.catho.gui.view;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Menu extends Application{

	private static Stage stage;
	
	@Override public void start(Stage stage){
		try {
			Parent parent = FXMLLoader.load(getClass().getResource("../fxml/Menu.fxml"));
			Scene scene = new Scene(parent);
			setStage(stage);
			stage.setScene(scene);
			stage.setResizable(false);
			stage.setTitle("Menu");
			stage.show();
			
		}catch(IOException e) {
			System.out.println(e.getMessage()); 
		}
		
	}
	public static Stage getStage() {
		return Menu.stage;
	}
	
	public static void setStage(Stage stage) {
		Menu.stage = stage;
	}
	public static void close() {
		Menu.getStage().close();
	}
}
