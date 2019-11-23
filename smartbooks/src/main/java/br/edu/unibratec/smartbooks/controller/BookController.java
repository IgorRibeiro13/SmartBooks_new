package br.edu.unibratec.smartbooks.controller;

import java.time.LocalDateTime;
import java.util.List;

import br.edu.unibratec.smartbooks.dao.BookDAO;
import br.edu.unibratec.smartbooks.interfaces.Operations;
import br.edu.unibratec.smartbooks.model.Book;

public class BookController implements Operations<Book> {

	LocalDateTime anoAtual = LocalDateTime.now();

	private BookDAO dao;

	public BookController() {
		dao = new BookDAO();
	}

	@Override
	public String inserir(Book livro) {

		String message = validarCampos(livro);
		if (message.equalsIgnoreCase("sucesso")) {
			return dao.inserir(livro);
		} else {
			return message;
		}


	}

	private String validarCampos(Book livro) {
		String message = "sucesso";

		if (livro.getAno().isEmpty() && livro.getAutor().isEmpty() && livro.getEditora().isEmpty()
				&& livro.getTamanho().isEmpty() && livro.getTipo().isEmpty() && livro.getTitulo().isEmpty()
				&& livro.getUrl().isEmpty()) {
			return "favor preencher ao menos um campo";
		}

		if (!livro.getAno().isEmpty()) {
			try {
				int ano = Integer.parseInt(livro.getAno());

				if (ano < 0 || ano > anoAtual.getYear()) {
					message = "Digite um ano entre 0 e " + anoAtual.getYear();
				}
			} catch (Exception e) {
				return "Digite um ano entre 0 e " + anoAtual.getYear();
			}
		}

		if (!livro.getAutor().isEmpty() && livro.getAutor().trim().length() < 3) {
			return "nome do autor inválido!";
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

<<<<<<< Updated upstream
	
	
=======
>>>>>>> Stashed changes
}
