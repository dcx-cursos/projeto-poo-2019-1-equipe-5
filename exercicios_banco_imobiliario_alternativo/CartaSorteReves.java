package com.exercicios_banco_imobiliario_alternativo;

public class CartaSorteReves {

	private int id;
	private String descricao;
	private int valor;
	
	public CartaSorteReves() {}
	
	public CartaSorteReves(int id, String descricao, int valor) {
		this.id = id;
		this.descricao = descricao;
		this.valor = valor;
	}
	
	public void pague() {
		
	}
	
	public void receba() {
		
	}
	
	public String getDescricao() {
		return this.descricao;
	}
	
	public int getValor() {
		return this.valor;
	}
}
