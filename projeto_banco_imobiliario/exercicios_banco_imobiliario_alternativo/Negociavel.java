package exercicios_banco_imobiliario_alternativo;

public interface Negociavel {

	public int getId();
	public String getNome();
	public int getPreco();
	public int getHipoteca();
	public void setProprietario(Peao peao);
	public Peao getProprietario();
}
