package com.exercicios_banco_imobiliario_alternativo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Jogador {

	private String nome;
	private int dinheiro;
	private int posicaoAtual;
	private Peao peao;
	private List<String> opcoes = new ArrayList<>();
	private List<Integer> titulos = new ArrayList<>();
	
	public Jogador(String nome, Peao peao) {
		this.nome = nome;
		this.dinheiro = 1500;
		this.posicaoAtual = 0;
		this.peao = peao;
		this.opcoes.add("jogar");
		this.opcoes.add("sair");
		
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setDinheiro(int dinheiro) {
		this.dinheiro = dinheiro;
	}
	
	public int getDinheiro() {
		return dinheiro;
	}
	
	public void setPosicaoAtual(int posicao) {
		this.posicaoAtual = posicao;
	}
	
	public int getPosicaoAtual() {
		return posicaoAtual;
	}
	
	public Peao getPeao() {
		return peao;
	}
	
	public List<String> getOpcoes() {
		return opcoes;
	}
	
	public String imprimeOpcoes() {
		String s = "";
		for (String op : this.opcoes) {
			s += "[" + op + "]";
		}
		return s;
	}
	
	public String getTitulos() {
		String t = "";
		Tabuleiro tabuleiro = new Tabuleiro();
		tabuleiro.criaCartas();
		for (int titulo : this.titulos) {
			t += "[" + ((TituloDePropriedade)tabuleiro.getCartas().get(titulo)).getNome() + "]";
		}
		return t;
	}
	
	public String status() {
		String s = "";
		s += "========== STATUS ==========\n\n" 
				+ "Jogador: " + this.nome.substring(0, 1).toUpperCase().concat(this.nome.substring(1)) + "(" + this.peao + "):\n"
				+ "Posição atual: " + this.posicaoAtual + "\n"
				+ "Dinheiro: " + this.dinheiro + "\n"
				+ "Títulos de propriedade: " + this.getTitulos() + "\n";
		return s;
	}
	
	public void adicionaOpcoes(String op) {
		this.opcoes.add(op);
	}
	
	public void adicionaTitulos(int titulo) {
		this.titulos.add(titulo);
	}
}
