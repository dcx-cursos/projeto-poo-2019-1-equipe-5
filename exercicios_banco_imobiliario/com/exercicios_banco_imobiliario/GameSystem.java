package com.exercicios_banco_imobiliario;

import java.util.Scanner;

import com.exercicios_banco_imobiliario.domain.CartaEspecial;
import com.exercicios_banco_imobiliario.domain.CartaSorteReves;
import com.exercicios_banco_imobiliario.domain.Companhia;
import com.exercicios_banco_imobiliario.domain.Dado;
import com.exercicios_banco_imobiliario.domain.Jogador;
import com.exercicios_banco_imobiliario.domain.Jogo;
import com.exercicios_banco_imobiliario.domain.Tabuleiro;
import com.exercicios_banco_imobiliario.domain.TituloDePropriedade;
import com.exercicios_banco_imobiliario.enums.Peao;
import com.exercicios_banco_imobiliario.exceptions.CorDePeaoRepetidaException;
import com.exercicios_banco_imobiliario.exceptions.CorInexistenteExpcetion;
import com.exercicios_banco_imobiliario.exceptions.DinheiroInsuficienteException;
import com.exercicios_banco_imobiliario.exceptions.NumeroJogadoresExcedenteException;
import com.exercicios_banco_imobiliario.exceptions.NumeroJogadoresInsuficienteException;

public class GameSystem {

	public static void main(String[] args) {

		Jogo jogo = new Jogo();
		Tabuleiro tabuleiro = new Tabuleiro();
		Scanner scan = new Scanner(System.in);
		int numeroDeJogadores = -1;
		int contadorDeRodadas = 0;

		// Escolher número de jogadores
		while (numeroDeJogadores < 2 || numeroDeJogadores > 8) {
			try {
				System.out.print("Digite o número de jogadores de 2 a 8: ");
				numeroDeJogadores = Integer.parseInt(scan.nextLine());
				jogo.criaJogadores(numeroDeJogadores);
			} catch (NumberFormatException e) {
				System.err.println(e.getMessage());
			} catch (NumeroJogadoresInsuficienteException | NumeroJogadoresExcedenteException e) {
				System.err.println(e.getMessage());
			}
		}

		for (int i = 0; i < numeroDeJogadores; i++) {

			boolean peaoEscolhido = false;
			System.out.println("\nDigite o nome do jogador " + (i + 1) + ":");
			String nome = scan.nextLine();

			while (!peaoEscolhido) {
				System.out.println("\nEscolha a cor do peão de acordo com as cores dispoíveis:");
				System.out.println(jogo.listarCoresDisponiveis());
				String cor = scan.nextLine();
				Peao peao = Peao.setPeao(cor.toUpperCase());

				try {
					jogo.escolherPeao(peao, nome);
					peaoEscolhido = true;
					jogo.getCoresIndisponiveis().add(peao);
				} catch (CorDePeaoRepetidaException e) {
					System.err.println(e.getMessage());
				} catch (CorInexistenteExpcetion e) {
					System.err.println(e.getMessage());
				}
			}
		}

		jogo.criaCartasDoJogo();
		System.out.println("\n*** O BANCO IMOBILIÁRIO VAI COMEÇAR, APROVEITE! ***\n");

		while (jogo.getNumeroDeJogadores() > 1) {
			contadorDeRodadas++;
			System.out.println("\n===== RODADA " + contadorDeRodadas + " =====\n");

			for (int i = 0; i < jogo.getJogadores().size(); i++) {
				Jogador jogadorDaVez = jogo.getJogadores().get(i);
				boolean estaPreso = jogadorDaVez.getEstaNaPrisao();

				if (contadorDeRodadas == 2 && !jogadorDaVez.getOpcoes().contains("status"))
					jogadorDaVez.adicionaOpcoes("status");
				if (estaPreso && !jogadorDaVez.getOpcoes().contains("status"))
					jogadorDaVez.adicionaOpcoes("pagar");

				System.out.println(
						"A vez é do jogador(a) " + jogadorDaVez.getNome() + "(" + jogadorDaVez.getPeao() + ")");

				String opcao = "";
				while (true) {
					System.out.println("Comandos disponíveis: " + jogadorDaVez.imprimeOpcoes());
					System.out.println("Digite o comando desejado:");
					opcao = opcao.replaceAll(opcao, scan.nextLine());

					if (jogadorDaVez.getOpcoes().contains(opcao.toLowerCase()))
						break;
					else
						System.out.println("Opção inválida!");
				}
				
				boolean monopolio = false;
				int quantidadeDoMesmoTipo;
				
				if (jogo.getPilha().getIndiciesTitulosDePropriedade().contains(jogadorDaVez.getPosicaoAtual())) {
				
					TituloDePropriedade t = (TituloDePropriedade) jogo.getPilha().getCartas()
							.get(jogadorDaVez.getPosicaoAtual());
					
					monopolio = jogadorDaVez.verificarMonopolio(jogadorDaVez, t);
					quantidadeDoMesmoTipo = jogo.verificaQuantidadeDoMesmoTipo(t);
					if (monopolio) jogadorDaVez.getOpcoes().add("construir");
					if(jogadorDaVez.verificaLotacao(t.getTipo(), quantidadeDoMesmoTipo)) jogadorDaVez.getOpcoes().remove("construir");
				
				}
				//implementar código para tirar a opção quando não puder mais construir.


				switch (opcao.toLowerCase()) {

				case "jogar":
					
					int d1 = Dado.rolaDado();
					int d2 = Dado.rolaDado();
					int posicaoAposJogada = jogo.anda(jogadorDaVez.getPosicaoAtual(), d1, d2);
					jogadorDaVez.setPosicaoAtual(tabuleiro.getPosicoesNoTabuleiro()[posicaoAposJogada]);

					if (jogo.getPilha().getIndicesDeCartasEspeciais().contains(posicaoAposJogada)) {
						CartaEspecial carta = (CartaEspecial) jogo.getPilha().getCartas().get(posicaoAposJogada);

						System.out.println(jogo.mensagem(jogadorDaVez, d1, d2) + " - " + carta.getNome());

						if (posicaoAposJogada == 18) {
							System.out.println("Receba 200");
							jogadorDaVez.setDinheiro(jogadorDaVez.getDinheiro() + 200);
						} else if (posicaoAposJogada == 24) {
							System.out.println("Pague 200");
							jogadorDaVez.setDinheiro(jogadorDaVez.getDinheiro() - 200);
						} else if (posicaoAposJogada == 30) {
							jogadorDaVez.setPosicaoAtual(10); // Jogador enviado para a prisão
							jogadorDaVez.setPreso(true);
							jogadorDaVez.adicionaOpcoes("pagar");
							System.out.println("Você foi enviado para prisão!");
						}

					} else if (jogo.getPilha().getIndicesDeCartasSorteReves().contains(posicaoAposJogada)) {

						CartaSorteReves carta = (CartaSorteReves) jogo.retiraUmaCartaSorteReves();
						System.out
								.println(jogo.mensagem(jogadorDaVez, d1, d2) + " - Sorte ou Revés\n" + carta.getNome());

						if (carta.getId() == 12) {
							d1 = Dado.rolaDado();
							d2 = Dado.rolaDado();
							jogadorDaVez.setPosicaoAtual(jogo.anda(jogadorDaVez.getPosicaoAtual(), d1, d2));
							i--;

						} else if (carta.getId() == 2) {
							for (Jogador j : jogo.getJogadores()) {
								if (!j.equals(jogadorDaVez)) {
									j.setDinheiro(j.getDinheiro() - 100);
								}
							}
							jogadorDaVez.setDinheiro(jogadorDaVez.getDinheiro() + (jogo.getNumeroDeJogadores() * 100));

						} else if (carta.getId() == 5) {
							boolean cartaLivreDaPrisaoLivre = true;

							for (Jogador j : jogo.getJogadores()) {
								if (j.isSaidaLivre())
									cartaLivreDaPrisaoLivre = false;
							}

							if (cartaLivreDaPrisaoLivre) {
								jogo.setSaidaLivreDaPrisao(carta);
								jogadorDaVez.setSaidaLivre(true);
							}
						} else if (carta.getId() == 6) {
							jogadorDaVez.setPreso(true);

						} else {

							if (carta.getId() == 24 && (d1 + d2) % 2 == 1)
								carta.setSorte(false);

							// Demais cartas
							if (carta.getSorte() == true) {
								System.out.println("- O banco lhe pagou $" + carta.getValor());
								jogadorDaVez.setDinheiro(jogadorDaVez.getDinheiro() + carta.getValor());
							} else if (carta.getSorte() == false) {
								jogadorDaVez.setDinheiro(jogadorDaVez.getDinheiro() - carta.getValor());
								System.out.println("O jogador " + jogadorDaVez.getNome() + "(" + jogadorDaVez.getPeao()
										+ ") perdeu 100 na conta");
							}
						} // fim do if

						System.out.println("\nPressione qualquer tecla para continuar...");
						scan.nextLine();

					} // fim do if

					// Titulos De Propriedade
					else if (jogo.getPilha().getIndiciesTitulosDePropriedade().contains(posicaoAposJogada)) {

						TituloDePropriedade titulo = (TituloDePropriedade) jogo.getPilha().getCartas()
								.get(posicaoAposJogada);

						System.out.println(jogo.mensagem(jogadorDaVez, d1, d2) + " - " + titulo.getNome());

						// Verifica se a propriedade tem um prorietario
						if (jogo.verificaProprietarioTitulo(titulo) == null) {

							System.out.println("O título da propriedade " + titulo.getNome() + " está disponível por "
									+ titulo.getPreco());
							System.out.println("Você possui " + jogadorDaVez.getDinheiro());

							if (jogadorDaVez.getDinheiro() >= titulo.getPreco()) {

								System.out.println("Você deseja comprar " + titulo.getNome() + " (sim/não)?");
								String compra = scan.nextLine();

								if (compra.toLowerCase().equals("sim"))

									try {
										jogo.negociaTituloDePropriedade(titulo, jogadorDaVez);
										titulo.setProprietario(jogadorDaVez.getPeao());
										System.out.println(
												"Parabéns! Você comprou a propriedade: " + titulo.getNome() + "\n");
									} catch (DinheiroInsuficienteException e) {
										System.out.println(e.getMessage());
									}

								// Propriedade indisponivel
							} else {
								System.out.println("Você não possui dinheiro suficiente para pagar o aluguel!");
							}
						} else {

							if (jogadorDaVez.getPeao().equals(titulo.getProprietario())) {
								System.out
										.println("Você parou numa propriedade pertencente a você. O jogo continua...");
							} else {
								for (Jogador j : jogo.getJogadores()) {
									if (j.getPeao().equals(titulo.getProprietario())) {
										System.out.println(titulo.getNome() + " pertence a " + j.getNome() + "("
												+ j.getPeao() + ")");
										System.out.println("Você pagou R$ "
												+ jogo.pagaAluguelDoTitulo(titulo, jogadorDaVez, j) + " de aluguel!\n");
										break;
									}
								}
							}
						}
					}

					// Companhias
					if (jogo.getPilha().getIndicesCompanhias().contains(posicaoAposJogada)) {

						Companhia companhia = (Companhia) jogo.getPilha().getCartas().get(posicaoAposJogada);
						System.out.println(jogo.mensagem(jogadorDaVez, d1, d2) + " - " + companhia.getNome());

						if (jogo.verificaProprietarioCompanhia(companhia) == null) {
							System.out.println(
									"A " + companhia.getNome() + " está disponível por " + companhia.getPreco());
							System.out.println("Você possui " + jogadorDaVez.getDinheiro());

							if (jogadorDaVez.getDinheiro() >= companhia.getPreco()) {
								System.out.println("Você deseja comprar " + companhia.getNome() + " (sim/não)?");
								String compra = scan.nextLine();

								if (compra.toLowerCase().equals("sim")) {
									try {
										jogo.negociaCompanhia(companhia, jogadorDaVez);
										companhia.setProprietario(jogadorDaVez.getPeao());
										System.out
												.println("Parabéns! Você comprou a companhia: " + companhia.getNome());
									} catch (DinheiroInsuficienteException e) {
										System.out.println(e.getMessage());
									}
								}

							} else {
								System.out.println("Voçê não possui Dinheiro suficiente!");
							}

						} else {

							if (jogadorDaVez.getPeao().equals(companhia.getProprietario())) {
								System.out.println("Você parou numa Companhia pertencente a você. O jogo continua...");
							} else {
								for (Jogador j : jogo.getJogadores()) {
									if (j.getPeao().equals(companhia.getProprietario())) {
										System.out.println(companhia.getNome() + " pertence a " + j.getNome() + "("
												+ j.getPeao() + ")");
										System.out.println("Você pagou R$ "
												+ jogo.pagaAluguelDaCompanhia(companhia, jogadorDaVez, j, (d1 + d2))
												+ "\n");
										break;
									}
								}
							}

						}
					}

					break;
					
				case "construir":
					
					//...
					break;
					
				case "sair":

					System.out.println("Você realmente quer sair do jogo (sim/não)?");
					String escolha = scan.nextLine();
					boolean escolhido = false;

					do {

						if (escolha.toLowerCase().equals("sim")) {
							numeroDeJogadores--;
							jogo.getJogadores().remove(i--);
							escolhido = true;

							if (numeroDeJogadores < 2) {
								System.out.println(
										"Número de jogadores insuficiente para continuar o jogo.\nJogo encerrado!");
								System.exit(0);
							}

						} else if (escolha.toLowerCase().equals("não")) {
							System.out.println("Segue o jogo...");
							i--;
							escolhido = true;
						} else {
							System.out.println("Opção inválida! Escolha sim ou não:");
							escolha = escolha.replaceAll(escolha, scan.nextLine());
						}

					} while (!escolhido);

					break;

				case "status":

					System.out.println(jogadorDaVez.status());
					i--;

					break;

				}// fim do switch
			} // fim do for
		} // fim do while

		scan.close();
	}// fim do main

}// fim da classe GameSystem
