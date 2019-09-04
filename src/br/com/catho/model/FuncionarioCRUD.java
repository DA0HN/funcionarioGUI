package br.com.catho.model;

import java.util.ArrayList;
import java.util.List;

public class FuncionarioCRUD {
	
	private static List<Funcionario> funcionarios = new ArrayList<>();
	
	public static int getLengthFuncionarios() {
		return funcionarios.size();
	}
	
	public static List<Funcionario> getFuncionarios() {
		return FuncionarioCRUD.funcionarios;
	}
	public static void setFuncionarios(List<Funcionario> listaAtualizada) {
		FuncionarioCRUD.funcionarios = listaAtualizada;
	}
	private static boolean cpfJaExistente(String CPF) {
		for(Funcionario f : funcionarios) {
			if( f != null ) {
				if( CPF.equals(f.getCpf()) )
					return true;
			}
		}
		return false;
	}
	
	public static Funcionario cadastro(String nome, String cpf, String funcao) {
		if( !cpfJaExistente(cpf) ) {
			Funcionario f = new Funcionario(
					nome,
					cpf,
					funcao);
			funcionarios.add(f);
			return f;
		}
		else {				
			System.out.println("CPF ja foi inserido! ");
			return null;
		}
	}
	
	public static void alteracao( String cpf, String novoNome, String novoCPF, String novaFuncao) {
		for( Funcionario f : funcionarios ) {
			if( f.getCpf().equals(cpf) ) {
				System.out.println("Funcionario: "+ f.toString());
				if( !novoCPF.isBlank() || !novoCPF.isEmpty()) {
					f.setCpf(novoCPF);
				}
				if( !novoNome.isBlank() || !novoCPF.isEmpty()) {
					f.setNome(novoNome);	
				}
				if( !novaFuncao.isBlank() || !novaFuncao.isEmpty()) {
					f.setFuncao(novaFuncao);
				}
				System.out.println("Foi alterado para: \n"+ f.toString());
				FuncionarioCRUD.setFuncionarios(funcionarios);
				return;
			}
		}
		System.out.println("Funcionario não encontrado");
		return;
	}
	
	public static void exclusao(String cpf) {
		for( Funcionario f : funcionarios ) {
			if( f.getCpf().equals(cpf) ) {
				System.out.println("Funcionario removido: " + f.toString());
				funcionarios.remove(f);
				return;
			}
		}
	}
}
