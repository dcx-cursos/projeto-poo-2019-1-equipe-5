package com.exercicios_banco_imobiliario_alternativo;

import java.util.ArrayList;
import java.util.List;

public class Tabuleiro {

	private List<TituloDePropriedade> titulosDePropriedades = new ArrayList<>();
	private List<CartaSorteReves> cartasSorteReves = new ArrayList<>();
	private List<Companhia> cartasCompanhias = new ArrayList<>();
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
	
/*	
	public void criarCartasPropriedades() {
		
		TituloDePropriedade c1 = new TituloDePropriedade(1, "Leblon", 100, 6, 30, 90, 270, 400, 500, 50, 50);
		TituloDePropriedade c2 = new TituloDePropriedade(3, "Av. Presidente Vargas", 60, 2, 10, 30, 90, 160, 250, 30, 50);
		TituloDePropriedade c3 = new TituloDePropriedade(4, "Av. Nossa Senhora de Copacabana", 60, 2, 10, 30, 90, 160, 250, 30, 50);
		TituloDePropriedade c4 = new TituloDePropriedade(6, "Av. Brigadeiro Faria Lima", 240, 20, 100, 300, 750, 925, 1100, 120, 150);
		TituloDePropriedade c5 = new TituloDePropriedade(8, "Av. Rebouças", 220, 18, 90, 250, 700, 875, 1050, 110, 150);
		TituloDePropriedade c6 = new TituloDePropriedade(9, "Av. 9 de Julho", 220, 18, 90, 250, 700, 875, 1050, 110, 150);
		TituloDePropriedade c7 = new TituloDePropriedade(11, "Av. Europa", 200, 16, 80, 220, 600, 800, 1000, 100, 100);
		TituloDePropriedade c8 = new TituloDePropriedade(13, "Rua Augusta", 180, 14, 70, 200, 550, 750, 950, 90, 100);
		TituloDePropriedade c9 = new TituloDePropriedade(14, "Av. Pacaembu", 180, 14, 70, 200, 550, 750, 950, 90, 100);
		TituloDePropriedade c10 = new TituloDePropriedade(17, "Interlagos", 350, 35, 175, 500, 1100, 1300, 1500, 175, 200);
		TituloDePropriedade c11 = new TituloDePropriedade(19, "Morumbi", 400, 50, 200, 600, 1400, 1700, 2000, 200, 200);
		TituloDePropriedade c12 = new TituloDePropriedade(21, "Flamengo", 120, 8, 40, 100, 300, 450, 600, 60, 50);
		TituloDePropriedade c13 = new TituloDePropriedade(23, "Botafogo", 100, 6, 30, 90, 270, 400, 500, 50, 50);
		TituloDePropriedade c14 = new TituloDePropriedade(26, "Av. Brasil", 160, 12, 60, 180, 500, 700, 900, 80, 100);
		TituloDePropriedade c15 = new TituloDePropriedade(28, "Av. Paulista", 140, 10, 50, 150, 450, 625, 750, 70, 100);
		TituloDePropriedade c16 = new TituloDePropriedade(29, "Jardim Europa", 140, 12, 60, 180, 500, 700, 900, 80, 100);
		TituloDePropriedade c17 = new TituloDePropriedade(31, "Copacabana", 260, 22, 110, 330, 800, 975, 1150, 130, 150);
		TituloDePropriedade c18 = new TituloDePropriedade(33, "Av. Vieira Souto", 320, 28, 150, 450, 1000, 1200, 1400, 160, 200);
		TituloDePropriedade c19 = new TituloDePropriedade(34, "Av. Atlântica", 300, 26, 130, 390, 900, 1100, 1275, 150, 200);
		TituloDePropriedade c20 = new TituloDePropriedade(36, "Ipanema", 300, 26, 130, 390, 900, 1100, 1275, 150, 200);
		TituloDePropriedade c21 = new TituloDePropriedade(38, "Jardim Paulista", 280, 24, 120, 360, 850, 1025, 1200, 140, 150);
		TituloDePropriedade c22 = new TituloDePropriedade(39, "Brooklin", 260, 22, 110, 330, 800, 975, 1150, 130, 150);
		
		this.titulosDePropriedades.add(c1);
		this.titulosDePropriedades.add(c2);
		this.titulosDePropriedades.add(c3);
		this.titulosDePropriedades.add(c4);
		this.titulosDePropriedades.add(c5);
		this.titulosDePropriedades.add(c6);
		this.titulosDePropriedades.add(c7);
		this.titulosDePropriedades.add(c8);
		this.titulosDePropriedades.add(c9);
		this.titulosDePropriedades.add(c10);
		this.titulosDePropriedades.add(c11);
		this.titulosDePropriedades.add(c12);
		this.titulosDePropriedades.add(c13);
		this.titulosDePropriedades.add(c14);
		this.titulosDePropriedades.add(c15);
		this.titulosDePropriedades.add(c16);
		this.titulosDePropriedades.add(c17);
		this.titulosDePropriedades.add(c18);
		this.titulosDePropriedades.add(c19);
		this.titulosDePropriedades.add(c20);
		this.titulosDePropriedades.add(c21);
		this.titulosDePropriedades.add(c22);
		
	}
	
	public void criaCartasSorteReves() {
		
		CartaSorteReves c1 = new CartaSorteReves(1, "Sua empresa foi multada por poluir demais", 200);
		CartaSorteReves c2 = new CartaSorteReves(2, "O dia do seu casamento chegou, receba os presentes.", 50);
		CartaSorteReves c3 = new CartaSorteReves(3, "Reformou sua casa", 50);
		CartaSorteReves c4 = new CartaSorteReves(4, "Seu livro será publicado por uma grande editora", 50);
		CartaSorteReves c5 = new CartaSorteReves(5, "Utilize este cartão para se livrar da prisão", 0);
		CartaSorteReves c6 = new CartaSorteReves(6, "Vá para a prisão", 0);
		CartaSorteReves c7 = new CartaSorteReves(7, "Vá até o início", 200);
		CartaSorteReves c8 = new CartaSorteReves(8, "Suas ações na bolsa de valores estão em alta", 100);
		CartaSorteReves c9 = new CartaSorteReves(9, "Você vai começar um curso de MBA e ganhou um bom desconto para", 20);
		CartaSorteReves c10 = new CartaSorteReves(10, "Férias com a familia pague", 20);
		CartaSorteReves c11 = new CartaSorteReves(11, "Recebeu o prêmio de profissional do ano e ganhou um carro", 10);
		CartaSorteReves c12 = new CartaSorteReves(12, "Jogue os dados novamente", 0);
		CartaSorteReves c13 = new CartaSorteReves(13, "Sua empresa irá patrocinar uma expedição a Antártida", 50);
		CartaSorteReves c14 = new CartaSorteReves(14, "Vendeu a parte de sua empresa para um investidor", 75);
		CartaSorteReves c15 = new CartaSorteReves(15, "Apostou no cavalo azarão e ganhou", 100);
		CartaSorteReves c16 = new CartaSorteReves(16, "A falta de chuva prejudicou a colheita", 45);
		CartaSorteReves c17 = new CartaSorteReves(17, "Recebeu uma herança inesperada", 75);
		CartaSorteReves c18 = new CartaSorteReves(18, "Seu filho decidiu fazer intercâmbio", 20);
		CartaSorteReves c19 = new CartaSorteReves(19, "Sua casa será desapropriada para a construção de um metro e ganhará uma gorda indenização", 60);
		CartaSorteReves c20 = new CartaSorteReves(20, "Venceu licitação para grande obra", 150);
		CartaSorteReves c21 = new CartaSorteReves(21, "Seu iate afundou, mas você tinha seguro!", 25);
		CartaSorteReves c22 = new CartaSorteReves(22, "Seus funcionários entraram em greve", 30);
		CartaSorteReves c23 = new CartaSorteReves(23, "Comprou obra de arte falsificada", 22);
		CartaSorteReves c24 = new CartaSorteReves(24, "Sorte se tirou o número par da soma dos dados e revés caso contrário", 100);
		CartaSorteReves c25 = new CartaSorteReves(25, "Seu jatinho precisa de manutenção", 9);
		CartaSorteReves c26 = new CartaSorteReves(26, "Renovou a frota de carros da sua empresa", 100);
		CartaSorteReves c27 = new CartaSorteReves(27, "Ganhou sozinho na loteria", 80);
		CartaSorteReves c28 = new CartaSorteReves(28, "Atualizou os computadores da sua empresa", 30);
		CartaSorteReves c29 = new CartaSorteReves(29, "Um navio afundou com suas mercadorias (não tinha seguro)", 40);
		CartaSorteReves c30 = new CartaSorteReves(30, "Produção de leite de suas fazendas ficou abaixo da expectativa", 60);
		CartaSorteReves c31 = new CartaSorteReves(31, "Tirou primeiro lugar no torneio de golfe receba", 100);
		
		this.cartasSorteReves.add(c1);
		this.cartasSorteReves.add(c2);
		this.cartasSorteReves.add(c3);
		this.cartasSorteReves.add(c4);
		this.cartasSorteReves.add(c5);
		this.cartasSorteReves.add(c6);
		this.cartasSorteReves.add(c7);
		this.cartasSorteReves.add(c8);
		this.cartasSorteReves.add(c9);
		this.cartasSorteReves.add(c10);
		this.cartasSorteReves.add(c11);
		this.cartasSorteReves.add(c12);
		this.cartasSorteReves.add(c13);
		this.cartasSorteReves.add(c14);
		this.cartasSorteReves.add(c15);
		this.cartasSorteReves.add(c16);
		this.cartasSorteReves.add(c17);
		this.cartasSorteReves.add(c18);
		this.cartasSorteReves.add(c19);
		this.cartasSorteReves.add(c20);
		this.cartasSorteReves.add(c21);
		this.cartasSorteReves.add(c22);
		this.cartasSorteReves.add(c23);
		this.cartasSorteReves.add(c24);
		this.cartasSorteReves.add(c25);
		this.cartasSorteReves.add(c26);
		this.cartasSorteReves.add(c27);
		this.cartasSorteReves.add(c28);
		this.cartasSorteReves.add(c29);
		this.cartasSorteReves.add(c30);
		this.cartasSorteReves.add(c31);
		
	}
	
	public void criaCartasCompanhias() {
		
		Companhia c1 = new Companhia(5, "Companhia Ferroviária", 200, 100, 50);
		Companhia c2 = new Companhia(7, "Companhia de Viação", 200, 100, 50);
		Companhia c3 = new Companhia(15, "Companhia de Táxi", 150, 75, 40);
		Companhia c4 = new Companhia(25, "Companhia de Navegação", 150, 75, 40);
		Companhia c5 = new Companhia(32, "Companhia de Aviação", 200, 100, 50);
		Companhia c6 = new Companhia(35, "Companhia de Táxi Aéreo", 200, 100, 50);
		
		this.cartasCompanhias.add(c1);
		this.cartasCompanhias.add(c2);
		this.cartasCompanhias.add(c3);
		this.cartasCompanhias.add(c4);
		this.cartasCompanhias.add(c5);
		this.cartasCompanhias.add(c6);
	}
	*/
}
