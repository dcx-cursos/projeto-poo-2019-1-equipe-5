package com.projeto_banco_imobiliario;

import java.util.Scanner;

public class GameSystem {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		Jogo jogo = new Jogo();
		
		try {
			jogo.criarJogo();
		} catch (NumeroJogadoresException e) {
			System.out.println(e.getMessage());
		}
		
		jogo.iniciarJogo();
	}

}
