package br.com.catho.model;

import br.edu.ifmt.cba.util.Teclado;

public class Menu {
	
	private static Funcionario[] funcionarios = new Funcionario[10];
	
	public static void main(String[] args) {
		tabelaDeOpcoes();
	}
	
	public static void tabelaDeOpcoes() {
		System.out.println("(1) Cadastro");
		System.out.println("(2) Alteração");
		System.out.println("(3) Exclusão");
		System.out.println("(4) Consulta por Matricula");
		System.out.println("(5) Listar Todos");
		System.out.println("(6) Número total de funcionários");
		System.out.println("(7) Sair");
		
		switch(Teclado.leInt("Insira sua opção: ")) {
		case 1:
			cadastro();
			tabelaDeOpcoes();
			break;
		case 2:
			alteracao();
			tabelaDeOpcoes();
			break;
		case 3:
			exclusao();
			tabelaDeOpcoes();
			break;
		case 4:
			consultaPorMatricula();
			tabelaDeOpcoes();
			break;
		case 5:
			listarTodos();
			tabelaDeOpcoes();
			break;
		case 6:
			System.out.println("Numeros de funcionarios atualmente: "+Funcionario.getNumeroDeFuncionarios());
			tabelaDeOpcoes();
			break;
		case 7:
			break;
		default:
			System.out.println("ERRO");
			tabelaDeOpcoes();
			break;
		}
	}
	private static boolean cpfJaExistente(String CPF) {
		for(int i=0; i<funcionarios.length; i++) {
			if( funcionarios[i] != null ) {
				if( CPF.equals(funcionarios[i].getCpf()) )
					return true;
			}
		}
		return false;
	}
	
	public static void cadastro() {
		String cpf = Teclado.leString("Insira o cpf: ");
		if( !cpfJaExistente(cpf) ) {
			for(int i=0; i<funcionarios.length; i++) {
				if(funcionarios[i] == null ) {
					funcionarios[i] = new Funcionario(
							Teclado.leString("Insira o nome: "),
							cpf,
							Teclado.leString("Insira a função: "));
					return;
				}
			}
			System.out.println("O numero de funcionarios foi excedido!");
		}
		else {
			System.out.println("CPF ja foi inserido! ");
		}
		
		
	}
	public static void alteracao() {
		String cpf = Teclado.leString("Insira a cpf para busca: ");
		
		for(int i=0; i < funcionarios.length; i++ ) {
			if( funcionarios[i] != null & cpf.equals(funcionarios[i].getCpf()) ) {
				String novoNome = Teclado.leString("Insira o novo nome: ");
				String novoCPF = Teclado.leString("Insira o novo cpf: ");
				String novaFuncao = Teclado.leString("insira a nova função: ");
				funcionarios[i].setNome(novoNome);
				funcionarios[i].setCpf(novoCPF);
				funcionarios[i].setFuncao(novaFuncao);
				return;
			}
		}
		System.out.println("Funcionario não encontrado");
	}
	
	public static void exclusao() {
		String cpf = Teclado.leString("Insira o CPF para exclusão: ");
		for(int i=0; i < funcionarios.length; i++ ) {
			if(  funcionarios[i].getCpf().equals(cpf)) {
				System.out.println("Funcionario removido: " + funcionarios[i].toString());
				funcionarios[i] = null;
				return;
			}
		}
	}
	
	public static void consultaPorMatricula() {
		int matricula = Teclado.leInt("Insira a matricula para busca: ");
		for(int i=0; i < funcionarios.length; i++ ) {
			if( matricula == funcionarios[i].getMatricula() ) {
				System.out.println("Funcionario encontrado: "+ funcionarios[i].toString());
				return;
			}
		}
		System.out.println("Funcionario não encontrado");
		
	}
	
	public static void listarTodos() {
		for(int i=0; i < funcionarios.length; i++ ) {
			if( funcionarios[i] != null ) {
				System.out.println(funcionarios[i].toString() );
			}
		}
	}

}
