package com.exercicios_banco_imobiliario.domain;

import java.util.ArrayList;
import java.util.List;

import com.exercicios_banco_imobiliario.enums.Peao;

public class Jogador {

	private String nome;
	private int dinheiro;
	private int posicaoAtual;
	private Peao peao;
	private boolean preso = false;
	private List<String> opcoes = new ArrayList<>();
	private List<Carta> titulos = new ArrayList<>();
	private int contadorDados = 0;
	boolean saidaLivre = false;
	
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
	
	public boolean isPreso() {
		return preso;
	}

	public void setPreso(boolean preso) {
		this.preso = preso;
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
		String titulos = "";
		for (Carta titulo : this.titulos) {
			titulos += "[" + titulo.getNome() + "]\n";
		}
		return titulos;
	}
	
	public String status() {
		String s = "";
		s += "========== STATUS ==========\n\n" 
				+ "Jogador: " + this.nome.substring(0, 1).toUpperCase().concat(this.nome.substring(1)) + "(" + this.peao + "):\n"
				+ "Posi��o atual: " + this.posicaoAtual + "\n"
				+ "Dinheiro: " + this.dinheiro + "\n"
				+ "T�tulos de propriedade: " + this.getTitulos() + "\n";
		return s;
	}
	
	public void adicionaOpcoes(String op) {
		this.opcoes.add(op);
	}
	
	public void adicionaTitulos(Carta titulo) {
		this.titulos.add(titulo);
	}
	public void adicionaCompanhia(Carta companhia) {
		this.titulos.add(companhia);
	}
	// metodo que mostra a quantidade de dados repetidos 
	
			public int getContadorDados() {
				return this.contadorDados;
			}
			
			// metodo que muda a quantidade do contador
			
			public void setContadorDados(int contadorDados) {
				this.contadorDados = contadorDados;
			}
			
			// metodo que mostra se o jogador está ou não na prisão
			
			public boolean getEstaNaPrisao() {
				return this.preso;
			}
			
			// metodo que muda se o jogador está ou não na prisão
			
			public void setEstaNaPrisao(boolean estaNaPrisao) {
				this.preso = estaNaPrisao;
			}
			
			// metodo que zera opcoes para adcionar as necessárias logo após
			
			public void zeraOpcoes() {
				this.opcoes = new ArrayList<>();
			}

			public boolean getlivre() {
				
				return saidaLivre;
			}
	
}//Fim da Classe
