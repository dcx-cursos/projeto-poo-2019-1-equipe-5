package com.exercicios_banco_imobiliario_alternativo_tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.exercicios_banco_imobiliario_alternativo.Jogo;
import com.exercicios_banco_imobiliario_alternativo.NumeroJogadoresExcedenteException;
import com.exercicios_banco_imobiliario_alternativo.NumeroJogadoresInsuficienteException;

class JogoTest {

	Jogo jogo;
	
	@BeforeEach
	void setUp() throws Exception {
		jogo = new Jogo();
	}

	@Test
	void testCriaJogo() throws NumeroJogadoresInsuficienteException, NumeroJogadoresExcedenteException {
		assertThrows(NumeroJogadoresInsuficienteException.class, () -> this.jogo.criaJogo(1));
		assertThrows(NumeroJogadoresExcedenteException.class, () -> this.jogo.criaJogo(9));
	}

}
