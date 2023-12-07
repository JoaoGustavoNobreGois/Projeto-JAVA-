package arquivo;

import entities.*;
import entities2.*;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Leitor {

	private ArrayList<Time> times;

	public Leitor() {
		times = new ArrayList<Time>();
	}

	public void efetuarLeitura(String filename) throws FileNotFoundException {

		File f = new File(filename);

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(f);

		while (sc.hasNextLine()) {

			String nomeTime = sc.next();
			int anoTime = sc.nextInt();

			String nomeTreinador = sc.next();
			int anoTreinador = sc.nextInt();
			String paisTreinador = sc.next();
			double tempoTreinador = sc.nextDouble();
			
			Treinador treinador = new Treinador(nomeTreinador, anoTreinador, paisTreinador, tempoTreinador);

			ArrayList<Jogador> jogadores = new ArrayList<Jogador>();

			int numJogadores = sc.nextInt();

			for (int i = 0; i < numJogadores; i++) {

				String posicao = sc.next();

				if (posicao.equals("Goleiro") || posicao.equals("goleiro")) {

					String nomeJ = sc.next();
					int anoJ = sc.nextInt();
					String paisJ = sc.next();
					String peJ = sc.next();
					int partidasJ = sc.nextInt();
					int defesasJ = sc.nextInt();
					int golSofridosJ = sc.nextInt();

					Jogador gol = new Goleiro(nomeJ, anoJ, paisJ, peJ, partidasJ, defesasJ, golSofridosJ);

					jogadores.add(gol);
					

				} else if (posicao.equals("Fixo") || posicao.equals("fixo") || posicao.equals("Ala")
						|| posicao.equals("ala") || posicao.equals("Pivo") || posicao.equals("pivo")
						|| posicao.equals("Pivô") || posicao.equals("pivô")) {

					String nomeJ = sc.next();
					int anoJ = sc.nextInt();
					String paisJ = sc.next();
					String peJ = sc.next();
					int partidasJ = sc.nextInt();
					int golsJ = sc.nextInt();
					int assistenciasJ = sc.nextInt();

					Jogador jgd = new JogadorDeLinha(nomeJ, anoJ, paisJ, peJ, partidasJ, posicao, golsJ, assistenciasJ);

					jogadores.add(jgd);
					

				}
				
				
			}
			
			Time time = new Time(nomeTime, anoTime, treinador);
			time.setEquipe(jogadores);
			
			times.add(time);

		}
		
		sc.close();
		
	}

	public ArrayList<Time> getTimes() {
		return times;
	}

}
	
