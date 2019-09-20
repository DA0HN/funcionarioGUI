package br.com.catho.model.repository;

import br.com.catho.database.Database;
import br.com.catho.model.service.FuncionarioService;

public class DaoFactory {
	// TODO: Implementar instancia��o das entidades do projeto
	
	public static FuncionarioService createFuncionarioDao() {
		return new FuncionarioService( Database.getConnection() );
	}
	
	
}
