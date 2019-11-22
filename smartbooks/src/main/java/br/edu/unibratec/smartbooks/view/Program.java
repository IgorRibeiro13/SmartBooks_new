package br.edu.unibratec.smartbooks.view;

import br.edu.unibratec.smartbooks.controller.BookOperationsFacade;
import br.edu.unibratec.smartbooks.model.Book;
import br.edu.unibratec.smartbooks.util.BookValidationUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Program {

	public static void main(String[] args) {
		
		OperationsView app = new OperationsView();
		
		app.menu();

//		Scanner scanner = new Scanner(System.in);
//		
//		BookValidationUtil bookUtil = new BookValidationUtil();
//
//		OperationsView program = new OperationsView();
//
//		String opcao;
//
//			System.out.println("---------------------");
//			System.out.println("O que deseja fazer?");
//			System.out.println("---------------------");
//			System.out.println("1- Adicionar Livro");
//			System.out.println("2- Excluir Livro");
//			System.out.println("3- editar livro");
//			System.out.println("4- Listar Livros");
//			System.out.println("0- Sair");
//			System.out.println();
//			System.out.print("Digite sua opção: ");
//			opcao = scanner.nextLine();
//			
//			int opcaoDigitada = bookUtil.validarInt(opcao);
//			
//		
//			if (opcaoDigitada >= 0 && opcaoDigitada <= 4) {
//				
//				System.out.println("entrei");
//				
//				program.opcoesMenu(opcaoDigitada);
//			} else {
//				
//				System.out.println("----------------------------");
//				System.out.println("------Número Inválido!------");
//				System.out.println("Digite um número entre 0 e 4");
//				System.out.println("----------------------------");
//				
//			}
//
//			
//
//
//		SessionFactory c = new Configuration().configure().buildSessionFactory();
//		
//		Book foo = new Book();
//		foo.setAno("2019");
//		foo.setAutor("igor");
//		foo.setEditora("teste");
//		foo.setTamanho("100 mbps");
//		foo.setTipo("eBook");
//		foo.setTitulo("a cabana");
//		foo.setUrl(null);
//		
//		
//		Session conn = c.openSession();
//		conn.beginTransaction();
//		
//		conn.save(foo);
//		
//		conn.getTransaction().commit();
//		conn.close();
//		
//		System.out.println("hello word");
//		
//		List<Book> result = new ArrayList<Book>();
//		Session session = c.openSession();
//		result = session.createQuery("from Book where Titulo LIKE '%cabana%'").list();
//		session.close();
//		
//		System.out.println("livros");
//		System.out.println(result);
//			 for (Book livro : result) {
//					System.out.println("");
//					System.out.println("Titulo: " + livro.getTitulo());
//					System.out.println("Autor: " + livro.getAutor());
//					System.out.println("Editora: " + livro.getEditora());
//					System.out.println("Ano: " + livro.getAno());
//					System.out.println("Tipo: " + livro.getTipo());
//					System.out.println("URL: " + livro.getUrl());
//					System.out.println("Tamanho: " + livro.getTamanho());
//			
//		}

		
		
	}

}
