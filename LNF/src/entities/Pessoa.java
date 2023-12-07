package entities;

public abstract class Pessoa implements Calculo{

	protected String nome;
	protected int anoNascimento;
	protected String paisOrigem;
	
	public Pessoa(String nome, int anoNascimento, String paisOrigem) {
		this.nome = nome;
		this.anoNascimento = anoNascimento;
		this.paisOrigem = paisOrigem;
	}

	public String getNome() {
		return nome;
	}

	public int getAnoNascimento() {
		return anoNascimento;
	}

	public String getPaisOrigem() {
		return paisOrigem;
	}
	
}
