package br.com.catho.gui.exceptions;

public class GUIException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	GUIException(String mensagem){
		super(mensagem);
	}
	
}
