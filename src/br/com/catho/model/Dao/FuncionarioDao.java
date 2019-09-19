package br.com.catho.model.Dao;

import java.util.List;

import br.com.catho.model.entities.Funcionario;

public interface FuncionarioDao {
	
	void save(Funcionario f);
	void update(Funcionario f);
	void deleteById(Integer id);
	void deleteByCPF(String cpf);
	Funcionario findById(Integer id);
	Funcionario findByCPF(String cpf);
	List<Funcionario> findAll();
}
