package entities;

public abstract class Jogador extends Pessoa implements Scout{

	protected String peDominante;
	protected int partidas;
	
	public Jogador(String nome, int anoNascimento, String paisOrigem, String peDominante, int partidas) {
		super(nome, anoNascimento, paisOrigem);
		this.peDominante = peDominante;
		this.partidas = partidas;
	}

	public int getPartidas() {
		return partidas;
	}

	public String getPeDominante() {
		return peDominante;
	}

}
