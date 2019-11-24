package br.edu.unibratec.smartbooks.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import br.edu.unibratec.smartbooks.interfaces.Operations;
import br.edu.unibratec.smartbooks.model.Book;

public class BookDAO implements Operations<Book> {

	private List<Book> alunos = new ArrayList<Book>();

	private SessionFactory sessionFactory;

	public BookDAO() {
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}

	@Override
	public String inserir(Book livro) {
		
		Session connection = sessionFactory.openSession();
		connection.beginTransaction();

		connection.save(livro);
		connection.getTransaction().commit();
		connection.close();
		
		return "Cadastrado com sucesso!";

	}

	@Override
	public String deletar(int id) {

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Book livro = session.load(Book.class, id);
		session.delete(livro);

		session.getTransaction().commit();
		session.close();
		return "Deletado com sucesso!";
		
	}

	@Override
	public String atualizar(Book livro) {
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.saveOrUpdate(livro);

		session.getTransaction().commit();
		session.close();
		return "Editado com sucesso!";
	}

	@Override
	public List<Book> listarTodos() {

		List<Book> result = new ArrayList<Book>();
		Session session = sessionFactory.openSession();
		result = session.createQuery("from Book").list();
		session.close();
		return result;
	}

	@Override
	public List<Book> listarPeloId(int id) {

		List<Book> result = new ArrayList<Book>();
		Session session = sessionFactory.openSession();
		result = session.createQuery("from Book where Id = " + id).list();
		session.close();
		return result;

	}

	@Override
	public List<Book> listarPeloTitulo(String titulo) {

		List<Book> result = new ArrayList<Book>();
		Session session = sessionFactory.openSession();
		result = session.createQuery("from Book where Titulo LIKE '%" + titulo + "%'").list();
		session.close();
		return result;

	}

	@Override
	public List<Book> listarPeloAutor(String autor) {
		List<Book> result = new ArrayList<Book>();
		Session session = sessionFactory.openSession();
		result = session.createQuery("from Book where Autor LIKE '%" + autor + "%'").list();
		session.close();
		return result;
	}

	@Override
	public List<Book> listarPelaEditora(String editora) {
		List<Book> result = new ArrayList<Book>();
		Session session = sessionFactory.openSession();
		result = session.createQuery("from Book where Editora LIKE '%" + editora + "%'").list();
		session.close();
		return result;
	}

	@Override
	public List<Book> listarPeloAno(String ano) {
		List<Book> result = new ArrayList<Book>();
		Session session = sessionFactory.openSession();
		result = session.createQuery("from Book where Ano LIKE '%" + ano + "%'").list();
		session.close();
		return result;
	}

}

