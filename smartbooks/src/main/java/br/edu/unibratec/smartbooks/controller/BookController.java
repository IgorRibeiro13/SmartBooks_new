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
		

		if (livro.getAno() != null) {
			message = BookValidationUtil.validarAno(livro.getAno());
			
		}
		
		if (livro.getTipo() != null) {
			message = BookValidationUtil.validarTipo(livro.getTipo());
			 if (message == "Sucesso" && livro.getTipo() == "1") {
				 livro.setTipo("Fisico");	 
			 }else {
				 livro.setTipo("eBook");
			 }
		}

		if (livro.getAutor() != null && livro.getAutor().trim().length() <= 3) {
			return "Autor inválido!";
		}

		return message;
	}
	
	

	@Override
	public String deletar(int id) {
		return dao.deletar(id);
		
		
		

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
