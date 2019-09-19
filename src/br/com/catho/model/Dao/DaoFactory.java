package br.com.catho.model.Dao;

import br.com.catho.database.Database;
import br.com.catho.model.Dao.implementacao.FuncionarioDatabase;

public class DaoFactory {
	// TODO: Implementar instanciação das entidades do projeto
	
	public static FuncionarioDatabase createFuncionarioDao() {
		return new FuncionarioDatabase( Database.getConnection() );
	}
	
	
}
