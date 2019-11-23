package br.edu.unibratec.smartbooks.interfaces;

import java.util.List;

public interface Operations<Book> {
	

		public String inserir(Book livro);

		public String deletar(int id);

		public String atualizar(Book livro);

		public List<Book> listarTodos();

		public List<Book> listarPeloId(int id);
		
		public List<Book> listarPeloTitulo(String titulo);
		
		public List<Book> listarPeloAutor(String autor);
		
		public List<Book> listarPelaEditora(String editora);
		
		public List<Book> listarPeloAno(String ano);

}
