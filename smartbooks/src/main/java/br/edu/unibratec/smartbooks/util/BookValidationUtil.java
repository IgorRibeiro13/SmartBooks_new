package br.edu.unibratec.smartbooks.util;

import java.time.LocalDateTime;

import br.edu.unibratec.smartbooks.model.Book;

public class BookValidationUtil {

	static LocalDateTime anoAtual = LocalDateTime.now();

	public static boolean validarMenu(String value) {
		int numero = 0;
		boolean valid = false;
		try {
			numero = Integer.parseInt(value);
			valid = true;

		} catch (Exception e) {
			System.out.println("");
			System.out.println("---------------------");
			System.out.println("---Opção Inválida!---");
			System.out.println("Digite Apenas Números");
			System.out.println("---------------------");
			System.out.println("");
		}
		return valid;

	}

	public static String validarAno(String Ano) {

		try {
			int numero = Integer.parseInt(Ano);

			if (numero > 0 && numero <= anoAtual.getYear()) {
				return "Sucesso";
			} else {
				return "Digite um Ano entre 0 e " + anoAtual.getYear();

			}

		} catch (Exception e) {

			return "O caractére digitado no Ano é inválido, digite apenas números!";

		}
	}

	public static String validarTipo(String tipo) {

		try {
			int numero = Integer.parseInt(tipo);

			if (numero == 1 || numero == 2) {
				return "Sucesso";
			} else {
				return "O tipo do livro é inválido, digite 1 para livro Fisico ou 2 para eBook!";
			}

		} catch (Exception e) {

			return "O caractére digitado no tipo é inválido, digite 1 para livro Fisico ou 2 para eBook!";

		}

	}

	public static String validarDeletar(String id) {

		try {
			int numero = Integer.parseInt(id);
			return "sucesso";
		} catch (Exception e) {

			return "Favor digitar apenas Números";

		}

	}

	public static String validarCamposVazios(Book livro) {
		String message = "Os campos ";
		int contador = 0;

		if (livro.getUrl() != null && livro.getUrl().trim().length() == 0) {
			message = message + "URL, ";
			contador++;
		}

		if (livro.getAutor() != null && livro.getAutor().trim().length() == 0) {
			message = message + "Autor, ";
			contador++;
		}

		if (livro.getEditora() != null && livro.getEditora().trim().length() == 0) {
			message = message + "Editora, ";
			contador++;
		}

		if (livro.getTamanho() != null && livro.getTamanho().trim().length() == 0) {
			message = message + "Tamanho, ";
			contador++;
		}

		if (livro.getTipo() != null && livro.getTipo().trim().length() == 0) {
			message = message + "Tipo, ";
			contador++;
		}

		if (livro.getTitulo() != null && livro.getTitulo().trim().length() == 0) {
			message = message + "Titulo, ";
			contador++;
		}

		if (livro.getAno() != null && livro.getAno().trim().length() == 0) {
			message = message + "Ano, ";
			contador++;
		}

		if (contador == 0) {
			return "sucesso";
		}
		
		message = message + "Estão vazios!";
		return message;

	}

}
