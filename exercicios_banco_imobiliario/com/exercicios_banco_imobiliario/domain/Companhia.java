package com.exercicios_banco_imobiliario.domain;

import com.exercicios_banco_imobiliario.enums.Peao;

public class Companhia extends Carta implements Negociavel {

	private int id;
	private String nome;
	private int preco;
	private int hipoteca;
	private int multiplicador;
	private Peao proprietario;
	
	public Companhia(int id, String nome, int preco, int hipoteca, int multiplicador) {
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.hipoteca = hipoteca;
		this.multiplicador = multiplicador;
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

	public int getPreco() {
		return preco;
	}

	public void setPreco(int preco) {
		this.preco = preco;
	}

	public int getHipoteca() {
		return hipoteca;
	}

	public void setHipoteca(int hipoteca) {
		this.hipoteca = hipoteca;
	}

	public void setMultiplicador(int multiplicador) {
		this.multiplicador = multiplicador;
	}
	
	public int getMultiplicador() {
		return multiplicador;
	}

	@Override
	public void setProprietario(Peao peao) {
		this.proprietario = peao;		
	}

	@Override
	public Peao getProprietario() {
		return this.proprietario;
	}

}
