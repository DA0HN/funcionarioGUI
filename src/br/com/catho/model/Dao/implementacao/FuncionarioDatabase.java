package br.com.catho.model.Dao.implementacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.catho.database.Database;
import br.com.catho.database.DatabaseException;
import br.com.catho.model.Dao.FuncionarioDao;
import br.com.catho.model.entities.Funcionario;

public class FuncionarioDatabase implements FuncionarioDao {

	private Connection conexao;
	
	public FuncionarioDatabase(Connection conexao){
		this.conexao = conexao;
	}
	
	@Override public void save(Funcionario f) {
		PreparedStatement st = null;
		try {
			String sql = "INSERT INTO funcionario (nome,cpf,funcao) VALUES (?,?,?)";
			
			st = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			st.setString(1, f.getNome());
			st.setString(2, f.getCpf());
			st.setString(3, f.getFuncao());
			
			var linhas = st.executeUpdate();
			
			
			if( linhas > 0) {
				System.out.println("Linhas alteradas: " + linhas);
				ResultSet rs = st.getGeneratedKeys();
				if( rs.next() ) {
					int id = rs.getInt(1);
					f.setId(id);
				}
				Database.closeResultSet(rs);
			}
			else {
				throw new DatabaseException("Erro ao salvar novo funcionario: Novo funcionario não foi inserido no banco de dados.");
			}
		}
		catch( SQLException e ) {
			throw new DatabaseException( e.getMessage() );
		}
		finally {
			Database.closeStatement(st);
		}
	}

	@Override public void update(Funcionario f) {

	}

	@Override public void deleteById(Integer id) {

	}

	@Override public Funcionario findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM funcionario WHERE funcionario.id = ?"; 
		try {
			
			st = conexao.prepareStatement(sql);
			
			st.setInt(1, id);
			
			rs = st.executeQuery();
			
			if( rs.next() ) {
				Funcionario f = instanciarFuncionario(rs);
				return f;
			}
			else {
				throw new DatabaseException("Erro ao executar FindById(): Não foi encontrando funcionario com esse Id.");
			}
			
		}
		catch( SQLException e) {
			throw new DatabaseException( e.getMessage() );
		}
		finally {
			Database.closeStatement(st);
			Database.closeResultSet(rs);
		}		
	}


	@Override public Funcionario findByCPF(String cpf) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			
			String sql = "SELECT * FROM funcionario WHERE funcionario.cpf = ?";
			st = conexao.prepareStatement(sql);
			
			st.setString(1, cpf);
			
			rs = st.executeQuery();
			
			if( rs.next() ) {
				Funcionario f = instanciarFuncionario(rs);
				
				return f;
			}
			else {
				throw new DatabaseException("Erro ao executar findByCPF(): Não foi encontrado funcionario com esse CPF.");
			}
			
		}
		catch(SQLException e) {
			throw new DatabaseException( e.getMessage() );
		}
		finally {
			Database.closeResultSet(rs);
			Database.closeStatement(st);
		}
	}

	@Override public List<Funcionario> findAll() {
		
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			
			String sql = "SELECT * FROM funcionario";
			
			st = conexao.prepareStatement(sql);
			
			rs = st.executeQuery();
			
			List<Funcionario> list = new ArrayList<Funcionario>();
			
			while( rs.next() ) {
				list.add( instanciarFuncionario(rs) );
			}
			
			return list;
			
		}
		catch( SQLException e) {
			throw new DatabaseException( e.getMessage() );
		}
		finally {
			Database.closeStatement(st);
			Database.closeResultSet(rs);
		}
		
	}
	
	private Funcionario instanciarFuncionario(ResultSet rs) throws SQLException {
		
		var funcionario = new Funcionario();
		
		funcionario.setNome( rs.getString("nome") );
		funcionario.setCpf( rs.getString("cpf"));
		funcionario.setFuncao( rs.getString("funcao") );
		funcionario.setId( rs.getInt("id") );
		
		return funcionario;
	}

}
