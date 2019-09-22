package com.exercicios_banco_imobiliario.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

import com.exercicios_banco_imobiliario.enums.Peao;
import com.exercicios_banco_imobiliario.exceptions.CorDePeaoRepetidaException;
import com.exercicios_banco_imobiliario.exceptions.CorInexistenteExpcetion;
import com.exercicios_banco_imobiliario.exceptions.DinheiroInsuficienteException;
import com.exercicios_banco_imobiliario.exceptions.NumeroJogadoresExcedenteException;
import com.exercicios_banco_imobiliario.exceptions.NumeroJogadoresInsuficienteException;

/**
 * Classe para objeto do tipo jogo, onde estão contidos, valores e métodos para
 * o mesmo.
 * 
 * @author Carlos Eduardo, Alefe, Aisllan e Artur
 */

public class Jogo {

	private int numeroDeJogadores;
	private Tabuleiro tabuleiro = new Tabuleiro();
	private PilhaDeCarta pilha = new PilhaDeCarta();
	private List<Jogador> jogadores = new ArrayList<Jogador>();
	private List<Peao> coresExistentes = Arrays.asList(Peao.values());
	private List<Peao> coresIndisponiveis = new ArrayList<>();
	private List<Integer> titulosVendidos = new ArrayList<>();
	private List<Carta> cartas;
	private Stack<Carta> cartasSorteReves;
	private CartaSorteReves saidaLivreDaPrisao;
	int contadorDeRodadas = 0;
	
	Scanner scan = new Scanner(System.in);

	/**
	 * Método encarregado de criar um novo jogo, cadastrando de 2 a 8 jogagdores. E
	 * que laçará uma Exception caso o número de jogadores for menor que 2 ou maior
	 * que 8.
	 * 
	 * @param num - Número de jogadores
	 * @throws NumeroJogadoresInsuficienteException Número de jogadores insuficiente
	 * @throws NumeroJogadoresExcedenteException    Número de jogadores excedeu
	 *                                              limite
	 * @author Carlos Eduardo, Alefe, Aisllan e Artur                                             
	 */

	public void criaJogadores(int num) throws NumeroJogadoresInsuficienteException, NumeroJogadoresExcedenteException {

		if (num < 2)
			throw new NumeroJogadoresInsuficienteException(
					"Número de jogadores insuficiente. O jogo deve ter de 2 a 8 jogadores!");
		else if (num > 8)
			throw new NumeroJogadoresExcedenteException(
					"Número de jogadores excedente. O jogo deve ter de 2 a 8 jogadores!");
		else {
			this.numeroDeJogadores = num;
		}
	}

	public void escolherPeao(Peao cor, String nome) throws CorDePeaoRepetidaException, CorInexistenteExpcetion {
				
		if (coresIndisponiveis.contains(cor)) {
			throw new CorDePeaoRepetidaException("Cor já escolhida. Escolha outra cor!");
		} else if (!coresExistentes.contains(cor)) {
			throw new CorInexistenteExpcetion("Cor inexistente. Escolha outra cor dentre as opções!");
		} else {
			coresIndisponiveis.add(cor);
			Jogador jogador = new Jogador(nome, cor);
			this.jogadores.add(jogador);
		}
	}

	public void criaCartasDoJogo() {
		pilha.criaPilhaDeCartas();
		pilha.criaPilhaDeCartasSorteReves();
		cartas = pilha.getCartas();
		cartasSorteReves = pilha.getCartasSorteReves();
	}
	
	/**
	 * Método utilizado para calcular o avanço de cada jogador a cada rodada
	 * 
	 * @param posicaoAntiga
	 * @param dado1
	 * @param dado2
	 * @return retorna o posicaoAposJogada de avanço
	 * @author @author Carlos Eduardo, Alefe, Aisllan e Artur
	 **/

	public int anda(int posicaoAntiga, int dado1, int dado2) {
		int posicaoAposJogada = 0;
		posicaoAposJogada = (posicaoAntiga + dado1 + dado2) % 40;
		return tabuleiro.getPosicoesNoTabuleiro()[posicaoAposJogada];
	}

	/**
	 * Método que realiza a negociação de compra de título de propriedade
	 * 
	 * @param titulo
	 * @param jogadorDaVez
	 * @author @author Carlos Eduardo, Alefe, Aisllan e Artur
	 **/

	public void negociaTituloDePropriedade(TituloDePropriedade titulo, Jogador jogadorDaVez) throws DinheiroInsuficienteException {
		
		if (jogadorDaVez.getDinheiro() < titulo.getPreco()) throw new DinheiroInsuficienteException("Você não tem dinheiro suficiente!");
		else {
			jogadorDaVez.adicionaTitulos(titulo);
			this.titulosVendidos.add(jogadorDaVez.getPosicaoAtual());
			jogadorDaVez.setDinheiro(jogadorDaVez.getDinheiro() - titulo.getPreco());
		} 
	}
	/**
	 * Método que verifica se determinada Propriedade ou Companhia possui um proprietário
	 * 
	 * @param jogadorDaVez
	 * @return Retorna verdadeiro caso Propriedade ou Companhia tenha um proprietário, ou falso se Propriedade ou Companhia não tenha um proprietário
	 * @author @author Carlos Eduardo, Alefe, Aisllan e Artur
	 */
	public Peao verificaProprietarioTitulo(TituloDePropriedade titulo ) {
		return titulo.getProprietario();
	}
	
	public Peao verificaProprietarioCompanhia(Companhia companhia ) {
		return companhia.getProprietario();
	}
	
	/**
	 * Método que realiza a negociação de compra de Companhias
	 * 
	 * @param titulo
	 * @param jogadorDaVez
	 * @author Carlos Eduardo, Alefe, Aisllan e Artur
	 **/

	public void negociaCompanhia(Companhia companhia, Jogador jogadorDaVez) throws DinheiroInsuficienteException {
		if (jogadorDaVez.getDinheiro() < companhia.getPreco()) throw new DinheiroInsuficienteException("Você não tem dinheiro suficiente!");
		else {
			jogadorDaVez.adicionaCompanhia(companhia);
			this.titulosVendidos.add(jogadorDaVez.getPosicaoAtual());
			jogadorDaVez.setDinheiro(jogadorDaVez.getDinheiro() - companhia.getPreco());
		} 
	}
	
	/**
	 * Método responsável por realizar o pagamento do aluguel da Companhia
	 * 
	 * @param companhia
	 * @param jogadorDaVez
	 * @param d1
	 * @param d2
	 * 
	 * @author @author Carlos Eduardo, Alefe, Aisllan e Artur
	 */
	public int pagaAluguelDaCompanhia(Companhia companhia, Jogador jogadorDaVez, Jogador proprietario, int somatorioDados) {
		
		int valor = companhia.getMultiplicador() * somatorioDados;
		
		if (jogadorDaVez.getDinheiro() >= valor) {
			jogadorDaVez.setDinheiro(jogadorDaVez.getDinheiro() - valor);
			proprietario.setDinheiro(proprietario.getDinheiro() + valor);
		}
		return valor;
	}
	
	public int pagaAluguelDoTitulo(TituloDePropriedade titulo, Jogador jogadorDaVez, Jogador j) {

		int aluguel = titulo.obterValorAluguel();
					
		if (jogadorDaVez.getDinheiro() >= aluguel) {
			j.setDinheiro(j.getDinheiro() + aluguel);
			jogadorDaVez.setDinheiro(jogadorDaVez.getDinheiro() - aluguel);
		}
		return aluguel;
	}
	
	public List<Carta> embaralhar(){
		Collections.shuffle(cartasSorteReves);
		return cartasSorteReves;

}
	public Carta retiraUmaCartaSorteReves(){
		CartaSorteReves card = (CartaSorteReves)cartasSorteReves.pop();
		
		if(card.getId() != 5) cartasSorteReves.add(0, card);
		return card;
	  
	}
	
	public String listarCoresDisponiveis() {
		String p = "";
		for (Peao peao : Peao.values()) {
			if (!this.getCoresIndisponiveis().contains(peao)) p += "[" + peao + "]";
		}
		return p;
	}
	
	public String mensagem(Jogador j, int d1, int d2) {
		return "O jogador " + j.getNome() + "(" + j.getPeao() + ") tirou " + d1 + ", " + d2
				+ " e o peão avançou para a casa " + j.getPosicaoAtual();
	}

	public Carta retiraCartaDaPilha(int posicao) {
		return pilha.getCartas().get(posicao);
	}

	public List<Jogador> getJogadores() {
		return jogadores;
	}
	
	public List<Peao> getCoresIndisponiveis(){
		return coresIndisponiveis;
	}

	public void setNumeroDeJogadores(int numeroDeJogadores) {
		this.numeroDeJogadores = numeroDeJogadores;
	}
	
	public int getNumeroDeJogadores() {
		return numeroDeJogadores;
	}

	public List<Carta> getCartas() {
		return cartas;
	}

	public Stack<Carta> getCartasSorteReves() {
		return cartasSorteReves;
	}

	public PilhaDeCarta getPilha() {
		return pilha;
	}

	public CartaSorteReves getSaidaLivreDaPrisao() {
		return saidaLivreDaPrisao;
	}

	public void setSaidaLivreDaPrisao(CartaSorteReves saidaLivreDaPrisao) {
		this.saidaLivreDaPrisao = saidaLivreDaPrisao;
	}

	public int verificaQuantidadeDoMesmoTipo(TituloDePropriedade t) {
		if (t.getTipo().equals("laranja") || t.getTipo().equals("vermelhoForte") || t.getTipo().equals("azulEscuro")) return 2;
		if (t.getTipo().equals("verde")) return 4;
		return 3;
	}

}
