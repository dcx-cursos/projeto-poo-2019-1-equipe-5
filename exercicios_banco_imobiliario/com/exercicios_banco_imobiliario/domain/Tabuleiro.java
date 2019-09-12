package com.exercicios_banco_imobiliario.domain;

import java.util.List;
import java.util.Stack;

public class Tabuleiro {

	PilhaDeCarta pilhaDeCartas = new PilhaDeCarta();
	
	private List<Carta> cartas = pilhaDeCartas.getCartas();
	private Stack<Carta> cartasSorteReves = pilhaDeCartas.getCartasSorteReves();
	
	public List<Carta> getCartas() {
		return cartas;
	}

	public Stack<Carta> getCartasSorteReves() {
		return cartasSorteReves;
	}
	
}
