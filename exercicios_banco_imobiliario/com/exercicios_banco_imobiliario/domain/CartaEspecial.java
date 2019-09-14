package com.exercicios_banco_imobiliario.domain;

public class CartaEspecial extends Carta {
	
	private int id;
	private String nome;
	
	public CartaEspecial(int id, String nome) {
		this.id = id;
		this.nome = nome;
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

}
