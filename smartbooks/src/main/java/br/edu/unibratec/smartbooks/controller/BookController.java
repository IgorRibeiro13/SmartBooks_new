package br.edu.unibratec.smartbooks.controller;

import java.util.List;

import br.edu.unibratec.smartbooks.dao.BookDAO;
import br.edu.unibratec.smartbooks.interfaces.Operations;
import br.edu.unibratec.smartbooks.model.Book;

public class BookController implements Operations<Book> {

	private BookDAO dao;

	public BookController() {
		dao = new BookDAO();
	}

	@Override
	public void inserir(Book livro) {
		dao.inserir(livro);
	}

	@Override
	public void deletar(int id) {
		dao.deletar(id);
	}

	@Override
	public void atualizar(Book livro) {
		dao.atualizar(livro);
	}

	@Override
	public List<Book> listarTodos() {
		return dao.listarTodos();
	}

	@Override
	public List<Book> listarPeloId(int id) {
		return dao.listarPeloId(id);
	}

	@Override
	public List<Book> listarPeloTitulo(String titulo) {
		return dao.listarPeloTitulo(titulo);
	}

	@Override
	public List<Book> listarPeloAutor(String autor) {
		return dao.listarPeloAutor(autor);
	}

	@Override
	public List<Book> listarPelaEditora(Book editora) {
		return dao.listarPelaEditora(editora);
	}

	@Override
	public List<Book> listarPeloAno(Book ano) {
		return dao.listarPeloAno(ano);
	}

	
	
}
