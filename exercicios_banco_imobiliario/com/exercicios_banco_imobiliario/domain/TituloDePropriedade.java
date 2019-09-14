package com.exercicios_banco_imobiliario.domain;

import com.exercicios_banco_imobiliario.enums.Peao;

public class TituloDePropriedade extends Carta implements Negociavel {
	
	private int id;
	private String nome;
	private int preco;
	private int aluguelSemCasa;
	private int aluguelUmaCasa;
	private int aluguelDuasCasas;
	private int aluguelTresCasas;
	private int aluguelQuatroCasas;
	private int aluguelHotel;
	private int hipoteca;
	private int precoDaCasa;
	private String tipo;
	private Peao proprietario;
		
	public TituloDePropriedade(int id, String nome, int preco, int aluguelSemCasa, int aluguelUmaCasa,
			int aluguelDuasCasas, int aluguelTresCasas, int aluguelQuatroCasas, int aluguelHotel, int hipoteca,
			int precoDaCasa, String tipo) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.aluguelSemCasa = aluguelSemCasa;
		this.aluguelUmaCasa = aluguelUmaCasa;
		this.aluguelDuasCasas = aluguelDuasCasas;
		this.aluguelTresCasas = aluguelTresCasas;
		this.aluguelQuatroCasas = aluguelQuatroCasas;
		this.aluguelHotel = aluguelHotel;
		this.hipoteca = hipoteca;
		this.precoDaCasa = precoDaCasa;
		this.tipo = tipo;
	}
	

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public int getPreco() {
		return preco;
	}

	public int getAluguelSemCasa() {
		return aluguelSemCasa;
	}

	public int getAluguelUmaCasa() {
		return aluguelUmaCasa;
	}

	public int getAluguelDuasCasas() {
		return aluguelDuasCasas;
	}

	public int getAluguelTresCasas() {
		return aluguelTresCasas;
	}

	public int getAluguelQuatroCasas() {
		return aluguelQuatroCasas;
	}

	public int getAluguelHotel() {
		return aluguelHotel;
	}

	public int getHipoteca() {
		return hipoteca;
	}

	public int getPrecoDaCasa() {
		return precoDaCasa;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public Peao getProprietario() {
		return proprietario;
	}

	@Override
	public void setProprietario(Peao peao) {
		this.proprietario = peao;
	}

}
