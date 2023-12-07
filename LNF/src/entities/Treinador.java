package entities;

public class Treinador extends Pessoa {

	private double anosNoCargo;
	
	public Treinador(String nome, int anoNascimento, String paisOrigem, double anosNoCargo) {
		super(nome, anoNascimento, paisOrigem);
		this.anosNoCargo = anosNoCargo;
	}

	public double getAnosNoCargo() {
		return anosNoCargo;
	}

	@Override
	public int Idade(int anoAtual) {
		int idade = anoAtual - anoNascimento;
		return idade;
	}

}
