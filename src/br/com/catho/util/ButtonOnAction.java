package br.com.catho.util;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class ButtonOnAction {


	public static boolean hasUserConfirmed(KeyEvent event) {
		return (ButtonOnAction.hasEnterPressed(event) || ButtonOnAction.hasSpacePressed(event) );
	}
	
	public static boolean hasEnterPressed(KeyEvent event) {
		return (event.getCode() == KeyCode.SPACE);
	}
	public static boolean hasSpacePressed(KeyEvent event) {
		return (event.getCode() == KeyCode.ENTER);
	}
}
