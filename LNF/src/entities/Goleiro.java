package entities;

public class Goleiro extends Jogador {

	private int defesas;
	private int golSofridos;
	
	public Goleiro(String nome, int anoNascimento, String paisOrigem, String peDominante, int partidas, int defesas, int golSofridos) {
		super(nome, anoNascimento, paisOrigem, peDominante, partidas);
		this.defesas = defesas;
		this.golSofridos = golSofridos;
	}

	public int getDefesas() {
		return defesas;
	}

	public int getGolSofridos() {
		return golSofridos;
	}

	@Override
	public int Idade(int anoAtual) {
		int idade = anoAtual - anoNascimento;
		return idade;
	}

	@Override
	public double GPP() {
		return 0;
	}

	@Override
	public double APP() {
		return 0;
	}

	@Override
	public double DPP() {
		double dpp = (double)defesas / (double)partidas;
		return dpp;
	}

	@Override
	public double GSPP() {
		double gspp = (double)golSofridos / (double)partidas;
		return gspp;
	}

}
