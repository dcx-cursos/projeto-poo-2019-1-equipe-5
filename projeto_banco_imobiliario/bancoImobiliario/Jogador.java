package bancoImobiliario;

import java.util.Arrays;
import java.util.List;

public class Jogador implements Status {

	private String nome;
	private String peao;
	private int dinheiro;
	private int posicaoAtual;
	private List<String> opcoes;

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

	@Override
	public void obterStatus() {
		
		System.out.println("***STATUS***");
		System.out.println("Jogador: " + this.getNome());
		System.out.println("Cor do pe�o: " + this.getPeao());
		System.out.println("Posi��o atual: " + this.getPosicaoAtual());
		System.out.println("Dinheiro: " + this.getDinheiro());
		System.out.println("T�tulos: ");//Implementar lista de t�tulos aqui!
		
	}
	
}