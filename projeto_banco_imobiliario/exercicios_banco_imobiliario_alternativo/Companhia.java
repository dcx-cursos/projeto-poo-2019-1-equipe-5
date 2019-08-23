package exercicios_banco_imobiliario_alternativo;

public class Companhia implements Negociavel {

	int id;
	String nome;
	int preco;
	int hipoteca;
	int multiplicador;
	Peao proprietario;
	
	public Companhia() {}
	
	public Companhia(int id, String nome, int preco, int hipoteca, int multiplicador) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.hipoteca = hipoteca;
		this.multiplicador = multiplicador;
	}

	
	public int getId() {
		return id;
	}
	
	public int getPreco() {
		return preco;
	}
	
	public int getHipoteca() {
		return hipoteca;
	}
	
	public int getMultiplicador() {
		return multiplicador;
	}
	
	public Peao getProprietario() {
		return proprietario;
	}

	@Override
	public String getNome() {
		return this.nome;
	}

	@Override
	public void setProprietario(Peao peao) {
		this.proprietario = peao;
	}
	
}
