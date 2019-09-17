package br.com.catho.application;

import br.com.catho.view.Menu;
import javafx.application.Application;
import javafx.stage.Stage;

public class MainApplication extends Application{

	@Override public void start(Stage stage) {
		Menu menu = new Menu();
		menu.start(stage);
	}
	public static void main(String[] args) {
		launch(args);
	}
}
