package com.projeto_banco_imobiliario_testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.projeto_banco_imobiliario.Jogo;
import com.projeto_banco_imobiliario.NumeroJogadoresException;

class JogoTest {
	
	Jogo jogo;

	@BeforeEach
	void setUp() throws Exception {
		jogo = new Jogo();
	}
	
	@Test(expected=NumeroJogadoresException.class)
	void testCriarJogo() {
		jogo.criarJogo();
		assertEquals(2, );
	}
	
	@Test
	void testJogar() {
		fail("Not yet implemented");
	}

	@Test
	void testGetJogadores() {
		fail("Not yet implemented");
	}

}
