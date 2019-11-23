package br.edu.unibratec.smartbooks.util;

import java.time.LocalDateTime;

public class BookValidationUtil {
	

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

	


	public static boolean validarAno(int ano) {
		return false;
//		try {
//			int numero = Integer.parseInt(ano);
//			if (numero > 0 && numero <= anoAtual.getYear) {
//				livro.setTitulo(ano);
//				System.out.println("");
//				System.out.println("Ano adicionado com sucesso!");
//				System.out.println("");
//				resultado = true;
//				exibirMenuAdicionar();
//			} else {
//				System.out.println("");
//				System.out.println("O ano digitado é inválido!");
//				System.out.println("Digite um ano entre 0 e " + anoAtual.getYear());
//				System.out.println("");
//
//			}
//
//		} catch (Exception e) {
//			System.out.println("------------------");
//			System.out.println("Caractere inválido");
//			System.out.println("------------------");
//
//		}
	}

}
