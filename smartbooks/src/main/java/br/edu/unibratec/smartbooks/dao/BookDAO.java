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
	public void inserir(Book livro) {

		Session connection = sessionFactory.openSession();
		connection.beginTransaction();

		connection.save(livro);
		connection.getTransaction().commit();
		connection.close();
		System.out.println("incluido com sucesso.");
	}

	@Override
	public void deletar(int id) {

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Book livro = session.load(Book.class, id);
		session.delete(livro);

		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void atualizar(Book livro) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.saveOrUpdate(livro);

		session.getTransaction().commit();
		session.close();
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

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Book livro = session.get(Book.class, id);

		session.getTransaction().commit();
		session.close();

		return livro;
	}

	@Override
	public List<Book> listarPeloTitulo(Book titulo) {

		List<Book> result = new ArrayList<Book>();
		Session session = sessionFactory.openSession();
		result = session.createQuery("from Book where Titulo LIKE '%" + titulo + "%'").list();
		session.close();
		return result;

	}

	@Override
	public List<Book> listarPeloAutor(Book autor) {
		List<Book> result = new ArrayList<Book>();
		Session session = sessionFactory.openSession();
		result = session.createQuery("from Book where Autor LIKE '%" + autor + "%'").list();
		session.close();
		return result;
	}

	@Override
	public List<Book> listarPelaEditora(Book editora) {
		List<Book> result = new ArrayList<Book>();
		Session session = sessionFactory.openSession();
		result = session.createQuery("from Book where Editora LIKE '%" + editora + "%'").list();
		session.close();
		return result;
	}

	@Override
	public List<Book> listarPeloAno(Book ano) {
		List<Book> result = new ArrayList<Book>();
		Session session = sessionFactory.openSession();
		result = session.createQuery("from Book where Ano LIKE '%" + ano + "%'").list();
		session.close();
		return result;
	}

//	anch

}
