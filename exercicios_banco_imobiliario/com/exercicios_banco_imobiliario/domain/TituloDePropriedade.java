package com.exercicios_banco_imobiliario.domain;

import com.exercicios_banco_imobiliario.enums.Peao;

public class TituloDePropriedade extends Carta implements Negociavel {

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
	private int construcao = 0; //0. Sem casa, 1. Uma casa, 2. Duas casas, 3. três casas, 4. Quatro casas, 5. Hotel
	private boolean lotacao = false;
	
	public TituloDePropriedade(int id, String nome, int preco, int aluguelSemCasa, int aluguelUmaCasa,
			int aluguelDuasCasas, int aluguelTresCasas, int aluguelQuatroCasas, int aluguelHotel, int hipoteca,
			int precoDaCasa, String tipo) {
		super(id, nome);
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

	public int obterValorAluguel() {

		switch (construcao) {

		case 0:
			return getAluguelSemCasa();
		case 1:
			return getAluguelUmaCasa();
		case 2:
			return getAluguelDuasCasas();
		case 3:
			return getAluguelTresCasas();
		case 4:
			return getAluguelQuatroCasas();
		case 5:
			return getAluguelHotel();

		}

		return 0;
	}

	public int getConstrucao() {
		return this.construcao;
	}
	
	public void setConstrucao(int construcao) {
		this.construcao = construcao;
	}

	public boolean isLotacao() {
		return lotacao;
	}

	public void setLotacao(boolean lotacao) {
		this.lotacao = lotacao;
	}

}
