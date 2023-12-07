package entities;

public class JogadorDeLinha extends Jogador {

	private String posicao;
	private int gols;
	private int assistencias;
	
	public JogadorDeLinha(String nome, int anoNascimento, String paisOrigem, String peDominante,int partidas, String posicao, int gols, int assistencias) {
		super(nome, anoNascimento, paisOrigem, peDominante, partidas);
		this.posicao = posicao;
		this.gols = gols;
		this.assistencias = assistencias;
	}

	public String getPosicao() {
		return posicao;
	}

	public int getGols() {
		return gols;
	}

	public int getAssistencias() {
		return assistencias;
	}

	@Override
	public int Idade(int anoAtual) {
		int idade = anoAtual - anoNascimento;
		return idade;
	}

	@Override
	public double GPP() {
		double gpp = (double)gols / (double)partidas;
		return gpp;
	}

	@Override
	public double APP() {
		double app = (double)assistencias / (double)partidas;
		return app;
	}

	@Override
	public double DPP() {
		return 0;
	}

	@Override
	public double GSPP() {
		return 0;
	}
	
}
