package br.com.catho.database;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Database {
	
	private static Connection conexao = null;
	
	private static Properties carregarPropriedades() {
		try (FileInputStream file = new FileInputStream("db.properties")){
			Properties p = new Properties();
			p.load(file);
			return p;
		}
		catch( IOException e) {
			throw new DatabaseException( e.getMessage() );
		}
	}
	
	public static Connection getConnection() {
		
		if( conexao == null ) {
			try {
				Properties p = carregarPropriedades();
				String url = p.getProperty("dburl");
				conexao = DriverManager.getConnection(url, p);
			}
			catch(SQLException e) {
				throw new DatabaseException( e.getMessage() );
			}
		}
		return conexao;
	}
	
	public static void closeConnection() {
		if( conexao != null ) {
			try {
				conexao.close();
			}
			catch( SQLException e ) {
				throw new DatabaseException( e.getMessage() );
			}
		}
	}
	
	public static void closeStatement(Statement st) {
		if( st != null ) {
			try {
				st.close();
			}
			catch( SQLException e) { 
				throw new DatabaseException( e.getMessage() );
			}
		}
	}
	
	public static void closeResultSet(ResultSet rs) {
		if( rs != null ) {
			try {
				rs.close();
			}
			catch( SQLException e) {
				throw new DatabaseException( e.getMessage() );
			}
		}
	}
	
}
