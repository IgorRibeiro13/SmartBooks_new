package br.edu.unibratec.smartbooks.util;

import java.time.LocalDateTime;

public class BookValidationUtil {

	static LocalDateTime anoAtual = LocalDateTime.now();

	public static boolean validarString(String value) {

		boolean validation = false;
		if (value.equals("") || value.isEmpty() || value == null) {
			validation = false;
		} else {
			validation = true;
		}
		return validation;

	}

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

	public static String validarAno(String ano) {

		try {
			int numero = Integer.parseInt(ano);
			if (numero > 0 && numero <= anoAtual.getYear()) {
				return "Sucesso";
			} else {
				return "Digite um ano entre 0 e " + anoAtual.getYear();

			}

		} catch (Exception e) {

			return "O caractére digitado no ano é inválido, digite apenas números!";

		}
	}

	public static String validarTipo(String tipo) {
		
		
		return null;
	}

}
