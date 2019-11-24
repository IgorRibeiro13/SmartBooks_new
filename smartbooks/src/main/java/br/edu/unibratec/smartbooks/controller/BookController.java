package br.edu.unibratec.smartbooks.controller;

import java.time.LocalDateTime;
import java.util.List;

import br.edu.unibratec.smartbooks.dao.BookDAO;
import br.edu.unibratec.smartbooks.interfaces.Operations;
import br.edu.unibratec.smartbooks.model.Book;
import br.edu.unibratec.smartbooks.util.BookValidationUtil;

public class BookController implements Operations<Book> {

	private BookDAO dao;

	public BookController() {
		dao = new BookDAO();
	}

	@Override
	public String inserir(Book livro) {

		String message = validarCampos(livro);
		if (message.equalsIgnoreCase("Sucesso")) {
			return dao.inserir(livro);
		} else {
			return message;
		}

	}

	private String validarCampos(Book livro) {

		String message = "Sucesso";

		if (livro.getAno() == null && livro.getAutor() == null && livro.getEditora() == null
				&& livro.getTamanho() == null && livro.getTipo() == null && livro.getTitulo() == null
				&& livro.getUrl() == null) {
			return "Favor preencher ao menos um campo";

		}
		
		// depois fazer um metodo para concatenar strings e dizer quais campos foram deixados invalidos
		if (livro.getTitulo().trim().length() == 0 || livro.getAno().trim().length() == 0 || livro.getAutor().trim().length() == 0 ||
				livro.getEditora().trim().length() == 0 || livro.getTamanho().trim().length() == 0 || livro.getTipo().trim().length() == 0 ||
				livro.getUrl().trim().length() == 0) {
			
			return "Existêm campos inválidos, favor preencher corretamente";
		}

		if (livro.getAno() != null) {
			message = BookValidationUtil.validarAno(livro.getAno());
			
		}

		if (livro.getAutor() != null && livro.getAutor().trim().length() <= 3) {
			return "Autor inválido!";
		}
		
		if (livro.getTipo() != null) {
			return BookValidationUtil.validarTipo(livro.getTipo());
		}

		return message;
	}
	
	

	@Override
	public String deletar(int id) {
		dao.deletar(id);
		return null;
	}

	@Override
	public String atualizar(Book livro) {
		dao.atualizar(livro);
		return null;
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
	public List<Book> listarPelaEditora(String editora) {
		return dao.listarPelaEditora(editora);
	}

	@Override
	public List<Book> listarPeloAno(String ano) {
		return dao.listarPeloAno(ano);
	}

}
