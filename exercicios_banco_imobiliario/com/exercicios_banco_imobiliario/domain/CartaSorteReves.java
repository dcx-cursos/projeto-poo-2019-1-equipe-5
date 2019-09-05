package com.exercicios_banco_imobiliario.domain;

public class CartaSorteReves extends Carta {

	private int valor;
	private boolean sorte;
	
	/**
	 * @param id receive an integer
	 * @param nome get a string name
	 */
	public CartaSorteReves(int id, String nome) {
		super(id, nome);
	}
	
	/**
	 * lucky letter builder or setbacks
	 * @param id receive an integer and set
	 * @param nome get a string name and set
	 * @param valor receive an integer and set
	 * @param sorte receive an integer and set
	 */
	public CartaSorteReves(int id, String nome, int valor, boolean sorte) {
		super(id, nome);
		this.valor = valor;
		this.sorte = sorte;
		
	}
	

	/**
	 * @return
	 */
	public int getValor() {
		return this.valor;
	}
	
	/**
	 * @return
	 */
	public boolean getSorte() {
		return this.sorte;
		
	}
	
}
