package com.exercicios_banco_imobiliario.domain;

public class Tabuleiro {

	private int[] posicoesNoTabuleiro = new int[39];
	
	public Tabuleiro() {
		for (int i = 0; i < this.posicoesNoTabuleiro.length; i++) {
			this.posicoesNoTabuleiro[i] = i;
		}
	}
	
	public int[] getPosicoesNoTabuleiro() {
		return posicoesNoTabuleiro;
	}
}
