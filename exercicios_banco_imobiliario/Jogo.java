package com.exercicios_banco_imobiliario_alternativo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Classe para objeto do tipo jogo, onde estão contidos, valores e métodos para o mesmo.
 * @author Carlos Eduardo, Alefe e Aisllan
 */

public class Jogo {

	private int numeroDeJogadores;
	private Tabuleiro tabuleiro = new Tabuleiro();
	//private int valoresDuplicados;
	int contadorDeRodadas = 0;
	private List<Jogador> jogadores = new ArrayList<Jogador>();
	private List<Integer> titulosVendidos = new ArrayList<>();
	

	Scanner scan = new Scanner(System.in);

	/**
	 * Método encarregado de criar um novo jogo, cadastrando de 2 a 8 jogagdores. E que laçará uma Exception caso o número de jogadores for menor que
	 * 2 ou maior que 8.
	 * @param num - Número de jogadores
	 * @throws NumeroJogadoresInsuficienteException Número de jogadores insuficiente
	 * @throws NumeroJogadoresExcedenteException Número de jogadores excedeu limite
	 */
	
	public void criaJogo(int num) throws NumeroJogadoresInsuficienteException, NumeroJogadoresExcedenteException {

		if (num < 2)
			throw new NumeroJogadoresInsuficienteException(
					"Número de jogadores insuficiente. O jogo deve ter de 2 a 8 jogadores!");
		else if (num > 8)
			throw new NumeroJogadoresExcedenteException(
					"Número de jogadores excedente. O jogo deve ter de 2 a 8 jogadores!");
		else {
			this.numeroDeJogadores = num;
			List<Integer> coresEscolhidas = new ArrayList<>();

			for (int i = 0; i < numeroDeJogadores; i++) {

				System.out.print("Digite o nome do jogador " + (i + 1) + ": \n");
				String nome = scan.nextLine();

				System.out.println("Escolha o número correspondente a cor do peão de acordo com as cores dispoíveis:");
				Peao.listaCores();

				int cor = Integer.parseInt(scan.nextLine());
				boolean escolhida = false;

				while (!escolhida) {
					if (coresEscolhidas.contains(cor)) {
						System.out.println("Cor já escolhida. Escolha outra cor!");
						cor = Integer.parseInt(scan.nextLine());
					} else if (cor < 1 || cor > 8) {
						System.out.println("Cor inexistente. Escolha outra cor!");
						cor = Integer.parseInt(scan.nextLine());
					} else {
						coresEscolhidas.add(cor);
						Peao peao = escolhePeao(cor);
						Jogador jogador = new Jogador(nome, peao);
						this.jogadores.add(jogador);
						escolhida = true;
					}
				}

			}

			tabuleiro.criaCartas();
			System.out.println("\n*** O BANCO IMOBILIÁRIO VAI COMEÇAR, APROVEITE! ***\n");
		}
	}

	/**
	 * Método em que o jogador pode realizar ações, como, jogar os dados e avançar pelo tabuleiro, comprar propriedades, sair do jogo e consultar o seu status.  
	 */
	
	public void iniciaJogo() {
		
		while (this.numeroDeJogadores > 1) {
			contadorDeRodadas++;
			System.out.println("\n===== RODADA " + contadorDeRodadas + " =====\n");
			
			for (int i = 0; i < this.jogadores.size(); i++) {
				Jogador jogadorDaVez = jogadores.get(i);
				if (contadorDeRodadas == 2 && !jogadorDaVez.getOpcoes().contains("status")) jogadorDaVez.adicionaOpcoes("status");
				System.out.println("A vez é do jogador " + jogadorDaVez.getNome() + "(" + jogadorDaVez.getPeao() + ")");
				System.out.println("Comandos disponíveis: " + jogadorDaVez.imprimeOpcoes());
				System.out.println("Digite o comando desejado:");
				
				String opcao = scan.nextLine();

				while (!jogadorDaVez.getOpcoes().contains(opcao.toLowerCase())) {
					System.out.println("Opção inválida!");
					opcao = opcao.replaceAll(opcao, scan.nextLine());
				}

				switch (opcao.toLowerCase()) {

				case "jogar":

					Dado dado1 = new Dado();
					Dado dado2 = new Dado();
					int d1 = dado1.rolaDado();
					int d2 = dado2.rolaDado();
					int movimento = anda(jogadorDaVez.getPosicaoAtual(), d1, d2);
					
					jogadorDaVez.setPosicaoAtual(movimento);

					//Objetos para comparação
					TituloDePropriedade titulo = new TituloDePropriedade();
					Companhia companhia = new Companhia();
					CartaSorteReves sorteReves = new CartaSorteReves();
					CartaEspecial cartaEspecial = new CartaEspecial();
					
					if (tabuleiro.getCartas().get(movimento).getClass().equals(titulo.getClass())) {
						
						titulo = (TituloDePropriedade)tabuleiro.getCartas().get(jogadorDaVez.getPosicaoAtual());
						
						System.out.println("O jogador " + jogadorDaVez.getNome() + "(" + jogadorDaVez.getPeao()
						+ ") tirou " + d1 + ", " + d2 + " e o peão avançou para a casa " + movimento
						+ " - " + ((TituloDePropriedade) tabuleiro.getCartas().get(movimento)).getNome());
						
						if (!titulosVendidos.contains(jogadorDaVez.getPosicaoAtual())) {
							System.out.println("O título da propriedade " + titulo.getNome() + " está disponível por " + titulo.getPreco());
							System.out.println("Você possui " + jogadorDaVez.getDinheiro());
							negociaTituloDePropriedade(titulo, jogadorDaVez);
						} else {
							System.out.println("O título da propriedade " + titulo.getNome() + " não está disponível para compra!");//Alterar posteriormente
						}
												
					} else if (tabuleiro.getCartas().get(movimento).getClass().equals(companhia.getClass())) {
						System.out.println("O jogador " + jogadorDaVez.getNome() + "(" + jogadorDaVez.getPeao()
						+ ") tirou " + d1 + ", " + d2 + " e o peão avançou para a casa " + movimento
						+ " - " + ((Companhia) tabuleiro.getCartas().get(movimento)).getNome());
					} else if (tabuleiro.getCartas().get(movimento).getClass().equals(sorteReves.getClass())) {
						System.out.println("O jogador " + jogadorDaVez.getNome() + "(" + jogadorDaVez.getPeao()
						+ ") tirou " + d1 + ", " + d2 + " e o peão avançou para a casa " + movimento
						+ " - " + ((CartaSorteReves) tabuleiro.getCartas().get(movimento)).getDescricao());
					} else if (tabuleiro.getCartas().get(movimento).getClass().equals(cartaEspecial.getClass())) {
						System.out.println("O jogador " + jogadorDaVez.getNome() + "(" + jogadorDaVez.getPeao()
						+ ") tirou " + d1 + ", " + d2 + " e o peão avançou para a casa " + movimento
						+ " - " + ((CartaEspecial) tabuleiro.getCartas().get(movimento)).getNome());
					}
					
					break;
					
				case "sair":
					
					System.out.println("Você realmente quer sair do jogo (sim/não)?");
					String escolha = scan.nextLine();
					boolean escolhido = false;
					
					do {
						
						if (escolha.toLowerCase().equals("sim")) {
							this.numeroDeJogadores--;
							jogadores.remove(i--);
							escolhido = true;
							
							if (this.numeroDeJogadores < 2) {
								System.out.println("Número de jogadores insuficiente para continuar o jogo.\nJogo encerrado!");
							}
							
						} else if (escolha.toLowerCase().equals("não")){
							System.out.println("Segue o jogo...");
							escolhido = true;
						} else {
							System.out.println("Opção inválida! Escolha sim ou não:");
							escolha = escolha.replaceAll(escolha, scan.nextLine());
						}
						
					} while(!escolhido);
					
					break;
					
				case "status":
					
					System.out.println(jogadorDaVez.status());
					i--;
					
					break;

				}// fim do switch
			} // fim do for
		} // fim do while
	}

	/**
	 * Método utilizado para calcular o avanço de cada jogador a cada rodada
	 * @param posicaoAntiga
	 * @param dado1
	 * @param dado2
	 * @return retorna o movimento de avanço
	 * @author Carlos Eduardo, Alefe e Aisllan
	 **/
	
	public int anda(int posicaoAntiga, int dado1, int dado2) {
		int movimento = 0;
		movimento = (posicaoAntiga + dado1 + dado2) % 40;
		return movimento;
	}
	
	/**
	 * Método para escolher a cor do peão
	 * @param cor
	 * @return retorna a cor do peão de cada jogador
	 * @author Carlos Eduardo, Alefe e Aisllan
	 **/

	public Peao escolhePeao(int cor) {
		Peao peao = null;
		switch (cor) {
		case 1:
			peao = Peao.PRETO;
			break;
		case 2:
			peao = Peao.BRANCO;
			break;
		case 3:
			peao = Peao.VERMELHO;
			break;
		case 4:
			peao = Peao.VERDE;
			break;
		case 5:
			peao = Peao.AZUL;
			break;
		case 6:
			peao = Peao.AMARELO;
			break;
		case 7:
			peao = Peao.LARANJA;
			break;
		case 8:
			peao = Peao.ROSA;
			break;
		}
		return peao;
	}
	
	/**
	 * Método que realiza a negociação de compra de título de propriedade
	 * @param titulo
	 * @param jogadorDaVez
	 * @author Carlos Eduardo, Alefe e Aisllan
	 **/
	
	public void negociaTituloDePropriedade(TituloDePropriedade titulo, Jogador jogadorDaVez) {
		
		if (jogadorDaVez.getDinheiro() >= titulo.getPreco()) {
			System.out.println("Você deseja comprar " + titulo.getNome() + " (sim/não)?");
			String compra = scan.nextLine();
		
			if (compra.toLowerCase().equals("sim")) {
				jogadorDaVez.adicionaTitulos(jogadorDaVez.getPosicaoAtual());
				this.titulosVendidos.add(jogadorDaVez.getPosicaoAtual());
				jogadorDaVez.setDinheiro(jogadorDaVez.getDinheiro() - titulo.getPreco());
				System.out.println("Parabéns! Você comprou a propriedade: " + titulo.getNome());
			} else if (compra.toLowerCase().equals("não")) {
				System.out.println("O jogo continua...");
			}

		}
	}
	
}
