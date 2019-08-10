package bancoImobiliario;

import java.util.Scanner;

/**
 * Classe main do sistema.
 * 
 * @author Aisllan
 */
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
