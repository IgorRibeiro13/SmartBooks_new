package br.edu.unibratec.smartbooks.controller;

import java.util.List;

import br.edu.unibratec.smartbooks.model.Book;
import br.edu.unibratec.smartbooks.util.BookValidationUtil;

public class BookOperationsFacade {

	private static BookOperationsFacade instancia;
	private static BookController bookController;

	private BookOperationsFacade() {
	}

	public static BookOperationsFacade getInstancia() {
		if (instancia == null) {
			instancia = new BookOperationsFacade();
			bookController = new BookController();

		}

		return instancia;
	}

	public void cadastrarLivro(Book livro) {
		bookController.inserir(livro);
	}

	public void removerLivro(int id) {
		bookController.deletar(id);
	}

	public void atualizarLivro(Book livro) {
		bookController.atualizar(livro);
	}

	public List<Book> pesquisarLivros() {
		return bookController.listarTodos();
	}

	public List<Book> pesquisarLivroPeloId(int id) {
		return bookController.listarPeloId(id);
	}

	public List<Book> pesquisarLivroPeloTitulo(String titulo) {
		return bookController.listarPeloTitulo(titulo);
	}

	public List<Book> pesquisarLivroPeloAutor(String autor) {
		return bookController.listarPeloAutor(autor);
	}

	public List<Book> pesquisarLivroPelaEditora(Book editora) {
		return bookController.listarPelaEditora(editora);
	}

	public List<Book> pesquisarLivroPeloAno(Book ano) {
		return bookController.listarPeloAno(ano);
	}

}
