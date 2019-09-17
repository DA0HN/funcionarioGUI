package br.com.catho.application;

import br.com.catho.view.util.ViewFactory;
import javafx.application.Application;
import javafx.stage.Stage;

public class MainApplication extends Application{

	@Override public void start(Stage stage) {
		ViewFactory.createMenu().start(new Stage());
	}
	public static void main(String[] args) {
		launch(args);
	}
}
