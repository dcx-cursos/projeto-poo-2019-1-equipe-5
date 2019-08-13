package com.exercicios_banco_imobiliario_alternativo;

import java.util.ArrayList;
import java.util.List;

public class Tabuleiro {

	private List<Object> cartas = new ArrayList<>();
	
	public List<Object> getCartas(){
		return this.cartas;
	}
	
	public void criaCartas() {
			
		TituloDePropriedade carta1 = new TituloDePropriedade(1, "Leblon", 100, 6, 30, 90, 270, 400, 500, 50, 50, "roxo");
		cartas.add(carta1);
		CartaEspecial carta2 = new CartaEspecial(2, "Sorte ou Reves");
		cartas.add(carta2);
		TituloDePropriedade carta3 = new TituloDePropriedade(3, "Av. Presidente Vargas", 60, 2, 10, 30, 90, 160, 250, 30, 50, "roxo");
		cartas.add(carta3);
		TituloDePropriedade carta4 = new TituloDePropriedade(4, "Av. Nossa Senhora de Copacabana", 60, 2, 10, 30, 90, 160, 250, 30, 50, "roxo");
		cartas.add(carta4);
		Companhia carta5 = new Companhia(5, "Companhia Ferroviária", 200, 100, 50);
		cartas.add(carta5);
		TituloDePropriedade carta6 = new TituloDePropriedade(6, "Av. Brigadeiro Faria Lima", 240, 20, 100, 300, 750, 925, 1100, 120, 150, "azul");
		cartas.add(carta6);
		Companhia carta7 = new Companhia(7, "Companhia de Viaçăo", 200, 100, 50);
		cartas.add(carta7);
		TituloDePropriedade carta8 = new TituloDePropriedade(8, "Av. Rebouças", 220, 18, 90, 250, 700, 875, 1050, 110, 150, "azul");
		cartas.add(carta8);
		TituloDePropriedade carta9 = new TituloDePropriedade(9, "Av. 9 de Julho", 220, 18, 90, 250, 700, 875, 1050, 110, 150, "azul");
		cartas.add(carta9);
		String casa10 = "Prisăo (visitante)";
		cartas.add(casa10);
		TituloDePropriedade carta11 = new TituloDePropriedade(11, "Av. Europa", 200, 16, 80, 220, 600, 800, 1000, 100, 100, "roxo");
		cartas.add(carta11);
		CartaEspecial casa12 = new CartaEspecial(12, "Sorte ou Reves");
		cartas.add(casa12);
		TituloDePropriedade carta13 = new TituloDePropriedade(13, "Rua Augusta", 180, 14, 70, 200, 550, 750, 950, 90, 100, "roxo");
		cartas.add(carta13);
		TituloDePropriedade carta14 = new TituloDePropriedade(14, "Av. Pacaembu", 180, 14, 70, 200, 550, 750, 950, 90, 100, "roxo");
		cartas.add(carta14);
		Companhia carta15 = new Companhia(15, "Companhia de Táxi", 150, 75, 40);
		cartas.add(carta15);
		CartaEspecial carta16 = new CartaEspecial(16, "Sorte ou Reves");
		cartas.add(carta16);
		TituloDePropriedade carta17 = new TituloDePropriedade(17, "Interlagos", 350, 35, 175, 500, 1100, 1300, 1500, 175, 200, "laranja");
		cartas.add(carta17);
		CartaEspecial carta18 = new CartaEspecial(18, "Lucros e Dividendos");
		cartas.add(carta18);
		TituloDePropriedade carta19 = new TituloDePropriedade(19, "Morumbi", 400, 50, 200, 600, 1400, 1700, 2000, 200, 200, "laranja");
		cartas.add(carta19);
		CartaEspecial carta20 = new CartaEspecial(20, "Parada Livre");
		cartas.add(carta20);
		TituloDePropriedade carta21 = new TituloDePropriedade(21, "Flamengo", 120, 8, 40, 100, 300, 450, 600, 60, 50, "vermelho");
		cartas.add(carta21);
		CartaEspecial carta22 = new CartaEspecial(22, "Sorte ou Reves");
		cartas.add(carta22);
		TituloDePropriedade carta23 = new TituloDePropriedade(23, "Botafogo", 100, 6, 30, 90, 270, 400, 500, 50, 50, "vermelho");
		cartas.add(carta23);
		CartaEspecial carta24 = new CartaEspecial(24, "Imposto de Renda");
		cartas.add(carta24);
		Companhia carta25 = new Companhia(25, "Companhia de Navegaçăo", 150, 75, 40);
		cartas.add(carta25);
		TituloDePropriedade carta26 = new TituloDePropriedade(26, "Av. Brasil", 160, 12, 60, 180, 500, 700, 900, 80, 100, "amarelo");
		cartas.add(carta26);
		CartaEspecial carta27 = new CartaEspecial(27, "Sorte ou Reves");
		cartas.add(carta27);
		TituloDePropriedade carta28 = new TituloDePropriedade(28, "Av. Paulista", 140, 10, 50, 150, 450, 625, 750, 70, 100, "amarelo");
		cartas.add(carta28);
		TituloDePropriedade carta29 = new TituloDePropriedade(29, "Jardim Europa", 140, 12, 60, 180, 500, 700, 900, 80, 100, "amarelo");
		cartas.add(carta29);
		CartaEspecial carta30 = new CartaEspecial(30, "Vá para a Prisăo");
		cartas.add(carta30);
		TituloDePropriedade carta31 = new TituloDePropriedade(31, "Copacabana", 260, 22, 110, 330, 800, 975, 1150, 130, 150, "verde");
		cartas.add(carta31);
		Companhia carta32 = new Companhia(32, "Companhia de Aviaçăo", 200, 100, 50);
		cartas.add(carta32);
		TituloDePropriedade carta33 = new TituloDePropriedade(33, "Av. Vieira Souto", 320, 28, 150, 450, 1000, 1200, 1400, 160, 200, "verde");
		cartas.add(carta33);
		TituloDePropriedade carta34 = new TituloDePropriedade(34, "Av. Atlântica", 300, 26, 130, 390, 900, 1100, 1275, 150, 200, "verde");
		cartas.add(carta34);
		Companhia carta35 = new Companhia(35, "Companhia de Táxi Aéreo", 200, 100, 50);
		cartas.add(carta35);
		TituloDePropriedade carta36 = new TituloDePropriedade(36, "Ipanema", 300, 26, 130, 390, 900, 1100, 1275, 150, 200, "verde");
		cartas.add(carta36);
		CartaEspecial carta37 = new CartaEspecial(37, "Sorte ou Reves");
		cartas.add(carta37);
		TituloDePropriedade carta38 = new TituloDePropriedade(38, "Jardim Paulista", 280, 24, 120, 360, 850, 1025, 1200, 140, 150, "azul escuro");
		cartas.add(carta38);
		TituloDePropriedade carta39 = new TituloDePropriedade(39, "Brooklin", 260, 22, 110, 330, 800, 975, 1150, 130, 150, "azul escuro");
		cartas.add(carta39);
		CartaEspecial carta40 = new CartaEspecial(40, "Ponto de Partida");
		cartas.add(carta40);
	}
	
}
