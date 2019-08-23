package exercicios_banco_imobiliario_alternativo;

import java.util.Random;

public class Dado {

	private int faceSuperior;
	
	/**
	 * M�todo que rola o dado sorteando um n�mero de 1 a 6 e que ao final os soma com a posi��o antiga do jogador. 
	 * @param faceSuperior
	 * @return retorna a face superior de cada dado, ou seja, o valor utilizado para calcular o avan�o do jogador
	 * @author Carlos Eduardo, Alefe e Aisllan
	**/
	public int rolaDado() {
		Random rand = new Random();
		this.faceSuperior = 1 + rand.nextInt(6);
		return this.faceSuperior;
	}
}
