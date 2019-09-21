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
	private List<TituloDePropriedade> titulos = new ArrayList<>();
	private List<Companhia> companhias = new ArrayList<>();
	private int contadorDados = 0;
	private boolean saidaLivre = false;
	private int monopolioVermelhoFraco = 0;
	private int monopolioAzulCeu = 0;
	private int monopolioVioleta = 0;
	private int monopolioLaranja = 0;
	private int monopolioVermelhoForte = 0;
	private int monopolioAmarelo = 0;
	private int monopolioVerde = 0;
	private int monopolioAzulEscuro = 0;

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

	public boolean isSaidaLivre() {
		return saidaLivre;
	}

	public void setSaidaLivre(boolean saidaLivre) {
		this.saidaLivre = saidaLivre;
	}

	public int getMonopolioVermelhoFraco() {
		return monopolioVermelhoFraco;
	}

	public void setMonopolioVermelhoFraco(int monopolioVermelhoFraco) {
		this.monopolioVermelhoFraco = monopolioVermelhoFraco;
	}

	public int getMonopolioAzulCeu() {
		return monopolioAzulCeu;
	}

	public void setMonopolioAzulCeu(int monopolioAzulCeu) {
		this.monopolioAzulCeu = monopolioAzulCeu;
	}

	public int getMonopolioVioleta() {
		return monopolioVioleta;
	}

	public void setMonopolioVioleta(int monopolioVioleta) {
		this.monopolioVioleta = monopolioVioleta;
	}

	public int getMonopolioLaranja() {
		return monopolioLaranja;
	}

	public void setMonopolioLaranja(int monopolioLaranja) {
		this.monopolioLaranja = monopolioLaranja;
	}

	public int getMonopolioVermelhoForte() {
		return monopolioVermelhoForte;
	}

	public void setMonopolioVermelhoForte(int monopolioVermelhoForte) {
		this.monopolioVermelhoForte = monopolioVermelhoForte;
	}

	public int getMonopolioAmarelo() {
		return monopolioAmarelo;
	}

	public void setMonopolioAmarelo(int monopolioAmarelo) {
		this.monopolioAmarelo = monopolioAmarelo;
	}

	public int getMonopolioVerde() {
		return monopolioVerde;
	}

	public void setMonopolioVerde(int monopolioVerde) {
		this.monopolioVerde = monopolioVerde;
	}

	public int getMonopolioAzulEscuro() {
		return monopolioAzulEscuro;
	}

	public void setMonopolioAzulEscuro(int monopolioAzulEscuro) {
		this.monopolioAzulEscuro = monopolioAzulEscuro;
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
		for (TituloDePropriedade titulo : this.titulos) {
			titulos += "[" + titulo.getNome() + "]";
		}
		return titulos;
	}

	public String status() {
		String s = "";
		s += "========== STATUS ==========\n\n" + "Jogador: "
				+ this.nome.substring(0, 1).toUpperCase().concat(this.nome.substring(1)) + "(" + this.peao + "):\n"
				+ "Posi��o atual: " + this.posicaoAtual + "\n" + "Dinheiro: " + this.dinheiro + "\n"
				+ "T�tulos de propriedade: " + this.getTitulos() + "\n"
				+ "Companhias: " + this.getCompanhias() + "\n"
				+ "============================\n";
		return s;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((peao == null) ? 0 : peao.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jogador other = (Jogador) obj;
		if (peao != other.peao)
			return false;
		return true;
	}

	public void adicionaOpcoes(String op) {
		this.opcoes.add(op);
	}

	public void adicionaTitulos(TituloDePropriedade titulo) {
		this.titulos.add(titulo);
	}

	public int getContadorDados() {
		return this.contadorDados;
	}

	public void setContadorDados(int contadorDados) {
		this.contadorDados = contadorDados;
	}

	public boolean getEstaNaPrisao() {
		return this.preso;
	}

	public void setEstaNaPrisao(boolean estaNaPrisao) {
		this.preso = estaNaPrisao;
	}

	public void zeraOpcoes() {
		this.opcoes = new ArrayList<>();
	}

	public boolean getlivre() {
		return saidaLivre;
	}

	public String getCompanhias() {
		String companhia = "";
		for (Companhia c : this.companhias) {
			companhia += "[" + c.getNome() + "]";
		}
		return companhia;
	}

	public void adicionaCompanhia(Companhia companhia) {
		this.companhias.add(companhia);
	}

}// Fim da Classe
