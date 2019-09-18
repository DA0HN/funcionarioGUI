package br.com.catho.model.Dao.implementacao;

import java.util.List;

import br.com.catho.model.Dao.FuncionarioDao;
import br.com.catho.model.entities.Funcionario;

public class FuncionarioDatabase implements FuncionarioDao {

	@Override
	public void save(Funcionario f) {

	}

	@Override
	public void update(Funcionario f) {

	}

	@Override
	public void deleteById(Integer id) {

	}

	@Override
	public Funcionario findById(Integer id) {
		return null;
	}

	@Override
	public Funcionario findByCPF(String cpf) {
		return null;
	}

	@Override
	public List<Funcionario> findAll() {
		return null;
	}

}
