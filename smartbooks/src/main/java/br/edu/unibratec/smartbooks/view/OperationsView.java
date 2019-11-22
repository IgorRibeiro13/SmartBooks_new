package br.edu.unibratec.smartbooks.view;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.edu.unibratec.smartbooks.controller.BookOperationsFacade;
import br.edu.unibratec.smartbooks.model.Book;
import br.edu.unibratec.smartbooks.util.BookValidationUtil;

public class OperationsView {

	LocalDateTime anoAtual = LocalDateTime.now();

	Scanner scanner = new Scanner(System.in);

	BookOperationsFacade facade = BookOperationsFacade.getInstancia();

	BookValidationUtil bookUtil = new BookValidationUtil();
	
	String titulo = null;
	String autor = null;
	String editora = null;
	String ano = null;
	String url = null;
	String tamanho = null;

	public void menu() {
		String value;
		boolean resultado = false;

		while (!resultado) {
			System.out.println("---------------------");
			System.out.println("O que deseja fazer?");
			System.out.println("---------------------");
			System.out.println("1- Adicionar Livro");
			System.out.println("2- Excluir Livro");
			System.out.println("3- editar livro");
			System.out.println("4- Listar Livros");
			System.out.println("0- Sair");
			System.out.println();
			System.out.print("Digite sua opção: ");
			value = scanner.nextLine();

			boolean validacao = bookUtil.validarMenu(value);

			if (validacao == true) {
				int opcao = Integer.parseInt(value);
				if (opcao >= 0 && opcao <= 4) {
					opcoesMenu(opcao);
					resultado = true;
				} else {
					System.out.println("");
					System.out.println("----------------------------");
					System.out.println("------Número Inválido!------");
					System.out.println("Digite um número entre 0 e 4");
					System.out.println("----------------------------");
					System.out.println("");
				}
			}
		}
	}

	public void opcoesMenu(int opcao) {
		switch (opcao) {
		case 1:
			exibirMenuAdicionar();
			break;
		case 2:
			excluirLivroPeloId();

			break;
		case 3:
			// exibirEdicaoDeLivro();
			// menu();
			break;
		case 4:
			exibirTipoLista();
		case 0:
			sairDoSistema();
			break;
		default:

			break;
		}

	}

	public void exibirMenuAdicionar() {
		String value;
		boolean resultado = false;

		while (!resultado) {
			System.out.println("");
			System.out.println("---------------------------------");
			System.out.println("1- Adicionar Titulo");
			System.out.println("2- Adicionar Autor");
			System.out.println("3- Adicionar Editora");
			System.out.println("4- Adicionar Ano de Publicação");
			System.out.println("5- Adicionar URL");
			System.out.println("6- Adicionar Tamanho do eBook");
			System.out.println("7- Tipo do Livro");
			System.out.println("8- Salvar Livro");
			System.out.println("---------------------------------");
			System.out.println("Qual campo você deseja adicionar?");
			value = scanner.nextLine();

			boolean validacao = bookUtil.validarMenu(value);

			if (validacao == true) {
				int opcaoAdicionar = Integer.parseInt(value);
				if (opcaoAdicionar >= 1 && opcaoAdicionar <= 8) {
					menuAdicionar(opcaoAdicionar);
					resultado = true;
				} else {
					System.out.println("");
					System.out.println("----------------------------");
					System.out.println("------Número Inválido!------");
					System.out.println("Digite um número entre 1 e 8");
					System.out.println("----------------------------");
					System.out.println("");
				}
			}
		}
	}

	private void menuAdicionar(int opcoesAdicionar) {
		Book livro = new Book();
		

		switch (opcoesAdicionar) {
		case 1:
			System.out.print("Digite o titulo do livro:");
			titulo = scanner.nextLine();
			System.out.println("");
			System.out.println("Titulo adicionado com sucesso!");
			System.out.println("");
			exibirMenuAdicionar();

			break;
		case 2:
			System.out.print("Digite o nome do Autor: ");
			autor = scanner.nextLine();
			System.out.println("");
			System.out.println("Autor adicionado com sucesso!");
			System.out.println("");
			exibirMenuAdicionar();

			break;
		case 3:
			System.out.print("Digite o nome da Editora: ");
			editora = scanner.nextLine();
			System.out.println("");
			System.out.println("Editora adicionada com sucesso!");
			System.out.println("");
			exibirMenuAdicionar();

			break;
		case 4:
			System.out.println("");
			System.out.print("Digite o ano de publicação: ");
			ano = scanner.nextLine();
			System.out.println("");
			System.out.println("Ano adicionada com sucesso!");
			System.out.println("");
			exibirMenuAdicionar();

			break;
		case 5:
			System.out.print("Informe o URL: ");
			url = scanner.nextLine();
			System.out.println("");
			System.out.println("URL adicionada com sucesso!");
			System.out.println("");
			exibirMenuAdicionar();

			break;
		case 6:
			System.out.print("Informe o tamanho do livro em MB: ");
			tamanho = scanner.nextLine();
			System.out.println("");
			System.out.println("tamanho adicionada com sucesso!");
			System.out.println("");
			exibirMenuAdicionar();

			break;
		case 7:
			System.out.println("Digite o tipo do livro: ");
			System.out.println("------------------------");
			System.out.println("1- Livro Fisico");
			System.out.println("2- eBook");
			System.out.println("------------------------");
			exibirMenuAdicionar();

			break;
		case 8:
			livro.setTitulo(titulo);
			livro.setAutor(autor);
			livro.setEditora(editora);
			livro.setAno(ano);
			livro.setUrl(url);
			livro.setTamanho(tamanho);
			facade.cadastrarLivro(livro);
			menu();
			break;
		default:
			break;
		}

	}

	private void excluirLivroPeloId() {

		String id;
		System.out.println("");
		System.out.println("Qual titulo do livro deseja Excluir?");
		System.out.println("");
		id = scanner.nextLine();

	}

	private void exibirTipoLista() {
		boolean resultado = false;
		String value;
		int opcao = 0;

		while (!resultado) {
			System.out.println();
			System.out.println("--------------------------------------");
			System.out.println("1- Listar todos os livros");
			System.out.println("2- Listar Livros a partir de um Id");
			System.out.println("3- Listar livros a partir de um titulo");
			System.out.println("4- Listar Livros a partir de autor");
			System.out.println("5- Listar Livros a partir de uma editora");
			System.out.println("6- Listar Livros a partir do ano");
			System.out.print("Como você deseja listar:");
			value = scanner.nextLine();

			boolean validacao = bookUtil.validarMenu(value);

			if (validacao == true) {
				opcao = Integer.parseInt(value);
				if (opcao >= 1 && opcao <= 6) {
					resultado = true;
				} else {
					System.out.println("");
					System.out.println("----------------------------");
					System.out.println("------Número Inválido!------");
					System.out.println("Digite um número entre 1 e 6");
					System.out.println("----------------------------");
					System.out.println("");
				}
			}
		}

		List<Book> livros = new ArrayList<Book>();
		switch (opcao) {
		case 1:
			livros = facade.pesquisarLivros();

			break;
		case 2:
			System.out.println("");
			System.out.print("Digite o ID do livro");

//			livros = facade.pesquisarLivroPeloId(id);
			break;
		case 3:
			System.out.println("");
			System.out.print("Digite o titulo do livro");
			String titulo = scanner.nextLine();
			livros = facade.pesquisarLivroPeloTitulo(titulo);
			break;
		case 4:
			System.out.println("");
			System.out.print("Digite o autor do livro");
			String autor = scanner.nextLine();
			livros = facade.pesquisarLivroPeloAutor(autor);
			break;
		case 5:
			System.out.println("");
			System.out.print("Digite o autor do livro");
			String editora = scanner.nextLine();
			livros = facade.pesquisarLivroPeloAutor(editora);
			break;
		case 6:
//			listarPeloAno();

		default:
			System.out.println("opção inválida! ");
			break;
		}
		for (Book livro : livros) {
			System.out.println("");
			System.out.println("Titulo: " + livro.getTitulo());
			System.out.println("Autor: " + livro.getAutor());
			System.out.println("Editora: " + livro.getEditora());
			System.out.println("Ano: " + livro.getAno());
			System.out.println("Tipo: " + livro.getTipo());
			System.out.println("URL: " + livro.getUrl());
			System.out.println("Tamanho: " + livro.getTamanho());
		}

	}

	private void sairDoSistema() {
		System.out.println("------------------");
		System.out.println("Sistema Encerrado!");
		System.out.println("------------------");
		System.exit(0);
	}

}
