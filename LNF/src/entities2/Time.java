package entities2;

import java.util.ArrayList;

import entities.Calculo;
import entities.Goleiro;
import entities.Jogador;
import entities.JogadorDeLinha;
import entities.Treinador;

public class Time implements Calculo{

	private String nome;
	private int anoFundacao;
	private Treinador treinador;
	private ArrayList<Jogador> equipe;
	
	public Time(String nome, int anoFundacao, Treinador treinador) {
		this.nome = nome;
		this.anoFundacao = anoFundacao;
		this.treinador = treinador;
		equipe = new ArrayList<Jogador>();
	}

	public ArrayList<Jogador> getEquipe() {
		return equipe;
	}

	public void setEquipe(ArrayList<Jogador> equipe) {
		this.equipe = equipe;
	}

	public String getNome() {
		return nome;
	}

	public int getAnoFundacao() {
		return anoFundacao;
	}

	public Treinador getTreinador() {
		return treinador;
	}
	
	public int gols() {
		int som = 0;
		for(int i=0;i<equipe.size();i++) {
			if (equipe.get(i) instanceof JogadorDeLinha) {
				JogadorDeLinha j = (JogadorDeLinha) equipe.get(i);
				som += j.getGols();
			}
		}
		return som;
	}
	
	public int assistencias() {
		int som = 0;
		for(int i=0;i<equipe.size();i++) {
			if(equipe.get(i) instanceof JogadorDeLinha) {
				JogadorDeLinha j = (JogadorDeLinha) equipe.get(i);
				som += j.getAssistencias();
			}
		}
		return som;
	}
	
	public int defesas() {
		int som = 0;
		for(int i=0;i<equipe.size();i++) {
			if(equipe.get(i) instanceof Goleiro) {
				Goleiro g = (Goleiro) equipe.get(i);
				som += g.getDefesas();
			}
		}
		return som;
	}
	
	public int golSofridos() {
		int som = 0;
		for(int i=0;i<equipe.size();i++) {
			if(equipe.get(i) instanceof Goleiro) {
				Goleiro g = (Goleiro) equipe.get(i);
				som += g.getGolSofridos();
			}
		}
		return som;
	}
	
	public int brasileiros() {
		int som = 0;
		
		if(treinador.getPaisOrigem().equals("Brasil") || treinador.getPaisOrigem().equals("brasil")) {
			som = 1;
		}
		
		for (int i=0;i<equipe.size();i++) {
			Jogador j = equipe.get(i);
			if(j.getPaisOrigem().equals("Brasil") || j.getPaisOrigem().equals("brasil")) {
				som++;
			}
		}
		return som;
	}
	
	public int estrangeiros() {
		int total = equipe.size() + 1;
		int br = brasileiros();
		int gringo = total - br;
		return gringo;
	}

	@Override
	public int Idade(int anoAtual) {
		int idade = anoAtual - anoFundacao;
		return idade;
	}
	
	public double mediaIdades(int anoAtual) {
		
		int som = 0;
		int cont = 0;
		
		for(int i=0;i<equipe.size();i++) {
			
			Jogador jgd = equipe.get(i);
			som += jgd.Idade(anoAtual);
			
			cont++;
		}
		
		double media = (double)som/(double)cont;
		
		return media;
		
	}
	
	public void mostra(int anoAtual) {
		
		System.out.println(nome + ", " + Idade(anoAtual) + " anos.");
		System.out.println();
		
		Treinador tecnico = treinador;
		System.out.println("Treinador: " + tecnico.getNome() + ", " + tecnico.Idade(anoAtual) + " anos, " + tecnico.getPaisOrigem() + ", " + tecnico.getAnosNoCargo() + " anos no cargo.");
		System.out.println();
		
		System.out.println("Jogadores:");
		System.out.println();
		
		ArrayList<Jogador> jgds = equipe;
		
		for(int i=0;i<jgds.size();i++) {
			
			Jogador jgd = jgds.get(i);
			
			if (jgd instanceof Goleiro) {
				
				Goleiro gol = (Goleiro) jgd;
				System.out.printf("%d. %s, %d anos, %s, goleiro, %s, %.2f DPP, %.2f GSPP\n", (i+1), gol.getNome(), gol.Idade(anoAtual), gol.getPaisOrigem(), gol.getPeDominante(), gol.DPP(), gol.GSPP());
			}
			else if (jgd instanceof JogadorDeLinha) {
				JogadorDeLinha j = (JogadorDeLinha) jgd;
				System.out.printf("%d. %s, %d anos, %s, %s, %s, %.2f GPP, %.2f APP\n", (i+1), j.getNome(), j.Idade(anoAtual), j.getPaisOrigem(), j.getPosicao(), j.getPeDominante(), j.GPP(), j.APP());
			}
			
		}
		
		System.out.println();
		System.out.println("Dados gerais do " + nome + ":");
		System.out.println();
		
		System.out.println("Gols totais: " + gols());
		System.out.println("Assistências totais: " + assistencias());
		System.out.println("Defesas totais: " + defesas());
		System.out.println("Gols sofridos totais: " + golSofridos());
		System.out.println("Número de brasileiros: " + brasileiros());
		System.out.println("Número de estrangeiros: " + estrangeiros());
		System.out.printf("Média de idade dos jogadores: %.2f anos.\n", mediaIdades(anoAtual));
		System.out.println();
	}

}
