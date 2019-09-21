package com.exercicios_banco_imobiliario.domain;

import java.util.Random;

public class Dado {

	private static int faceSuperior;
	
	/**
	 * M�todo que rola o dado sorteando um n�mero de 1 a 6 e que ao final os soma com a posi��o antiga do jogador. 
	 * @param faceSuperior
	 * @return retorna a face superior de cada dado, ou seja, o valor utilizado para calcular o avan�o do jogador
	 * @author Carlos Eduardo, Alefe e Aisllan
	**/
	public static int rolaDado() {
		Random rand = new Random();
		faceSuperior = 1 + rand.nextInt(6);
		return faceSuperior;
	}
}
