package br.edu.unibratec.smartbooks.interfaces;

import java.util.List;

public interface Operations<Book> {
	

		public void inserir(Book livro);

		public void deletar(int id);

		public void atualizar(Book livro);

		public List<Book> listarTodos();

		public List<Book> listarPeloId(int id);
		
		public List<Book> listarPeloTitulo(String titulo);
		
		public List<Book> listarPeloAutor(String autor);
		
		public List<Book> listarPelaEditora(Book editora);
		
		public List<Book> listarPeloAno(Book ano);

}
