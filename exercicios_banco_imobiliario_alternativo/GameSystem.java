package com.exercicios_banco_imobiliario_alternativo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GameSystem {

	public static void main(String[] args) {

		Jogo jogo = new Jogo();
		Scanner scan = new Scanner(System.in);
		boolean escolhaQuantidade = false;
		boolean criaJogo = false;
		int numeroDeJogadores = -1;

		while (!escolhaQuantidade) {
			System.out.print("Digite o número de jogadores de 2 a 8: ");

			try {
				numeroDeJogadores = Integer.parseInt(scan.nextLine());
				escolhaQuantidade = true;
			} catch (NumberFormatException e) {
				System.err.println(e.getMessage());
				System.out.print("Digite o número de jogadores de 2 a 8: ");
				numeroDeJogadores = Integer.parseInt(scan.nextLine());
			}
		}

		while (!criaJogo) {

			try {
				jogo.criaJogo(numeroDeJogadores);
				criaJogo = true;
			} catch (NumeroJogadoresInsuficienteException e) {
				System.err.println(e.getMessage());
			} catch (NumeroJogadoresExcedenteException e) {
				System.err.println(e.getMessage());
			}
		}
		
		jogo.iniciaJogo();
		
		
	}//fim do main

}//fim da classe GameSystem
