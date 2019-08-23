package exercicios_banco_imobiliario_alternativo;

public enum Peao {

	PRETO(1), BRANCO(2), VERMELHO(3), VERDE(4), AZUL(5), AMARELO(6), LARANJA(7), ROSA(8);
	private final int cor;
	
	Peao(int corEscolhida) {
		cor = corEscolhida;
	}
	
	public int getCor() {
		return cor;
	}
	
	public static void listaCores() {
		System.out.println(
				"1. [" + Peao.PRETO + "] " +
				"2. [" + Peao.BRANCO + "] " +
				"3. [" + Peao.VERMELHO + "] " +
				"4. [" + Peao.VERDE + "] " +
				"5. [" + Peao.AZUL + "] " +
				"6. [" + Peao.AMARELO + "] " +
				"7. [" + Peao.LARANJA + "] " +
				"8. [" + Peao.ROSA + "]"
				);
	}
	
}
