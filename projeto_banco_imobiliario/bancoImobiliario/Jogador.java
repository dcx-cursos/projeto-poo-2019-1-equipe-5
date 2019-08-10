package bancoImobiliario;

import java.util.Arrays;
import java.util.List;

/**
 * Classe Jogador, que tem como atributos o nome de um jogador, a cor do peão, o seu dinheiro e sua posição no tabuleiro. Além de fornecer
 * opções que podem ser realizadas durante o jogo.
 * @author Aisllan
 *
 */
public class Jogador implements Status {

	private String nome;
	private String peao;
	private int dinheiro;
	private int posicaoAtual;
	private List<String> opcoes;
/**
 * Construtor da Classe Jogador, que passa como parâmetro o nome e o peao.
 * Que iniciará o jogo com o jogador com saldo de R$ 1.500,00 na posição 0 do tabuleiro.
 *  
 * @param nome Nome do jogador
 * @param peao Cor do peão
 * @author Aisllan
 */
	public Jogador(String nome, String peao) {
		this.nome = nome;
		this.peao = peao;
		this.dinheiro = 1500;
		this.posicaoAtual = 0;
		this.opcoes = Arrays.asList("Jogar", "Sair");
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
	
	public String getPeao() {
		return peao;
	}
	
	public int getDinheiro() {
		return dinheiro;
	}
	
	public void setDinheiro(int dinheiro) {
		this.dinheiro = dinheiro;
	}
	
	public int getPosicaoAtual() {
		return posicaoAtual;
	}
	
	public void setPosicaoAtual(int posicao) {
		this.posicaoAtual = posicao;
	}

	
	public String getOpcoes() {
		String op = "";
		for (String o : opcoes) {
			op += o + " ";
		}
		return op.trim();
	}

	public void setOpcoes(List<String> opcoes) {
		this.opcoes = opcoes;
	}

	/**
	 * Fornece o Status do jogador, inidicado o seu nome, cor do peão, sua posiçao atual, saldo monetário e titulos de propriedades adquiridos.
	 * @author Aisllan
	 */
	public void obterStatus() {
		
		System.out.println("***STATUS***");
		System.out.println("Jogador: " + this.getNome());
		System.out.println("Cor do peï¿½o: " + this.getPeao());
		System.out.println("Posiï¿½ï¿½o atual: " + this.getPosicaoAtual());
		System.out.println("Dinheiro: " + this.getDinheiro());
		System.out.println("Tï¿½tulos: ");//Implementar lista de tï¿½tulos aqui!
		
	}
	
}