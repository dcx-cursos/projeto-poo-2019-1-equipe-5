package com.exercicios_banco_imobiliario.domain;

public class CartaSorteReves extends Carta {

	private int id;
	private String nome;
	private int valor;
	private boolean sorte;
		
	/**
	 * @param id receive an integer
	 * @param nome get a string name
	 */
	public CartaSorteReves(int id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	/**
	 * lucky letter builder or setbacks
	 * @param id receive an integer and set
	 * @param nome get a string name and set
	 * @param valor receive an integer and set
	 * @param sorte receive an integer and set
	 */
	public CartaSorteReves(int id, String nome, int valor, boolean sorte) {
		this.id = id;
		this.nome = nome;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public void setSorte(boolean sorte) {
		this.sorte = sorte;
	}

}
