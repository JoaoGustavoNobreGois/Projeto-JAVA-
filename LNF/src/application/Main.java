package application;

import entities.*;

import entities2.*;
import arquivo.*;
import exception.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.Locale;
import java.util.Scanner;

import java.util.ArrayList;

import java.util.InputMismatchException;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, IOException, EscolhaInvalidaException, AindaNaoExisteException {

		Locale.setDefault(Locale.US);
		Scanner s = new Scanner(System.in);
		
		try {
			ArrayList<Time> times = new ArrayList<Time>();

			System.out.print("Informe o ano atual: ");
			int anoAtual = s.nextInt();
			if(anoAtual < 1934) {
				s.close();
				throw new AindaNaoExisteException("O futsal surgiu em 1934.");
			}
			System.out.println();

			System.out.println("[1] Entrada por console.");
			System.out.println("[2] Entrada por arquivo.");
			System.out.print("Escolha: ");
			int escolha = s.nextInt();
			if(escolha != 1 && escolha != 2) {
				s.close();
				throw new EscolhaInvalidaException("Escolha inválida");
			}

			if (escolha == 1) {

				System.out.print("Informe o número de times: ");
				int numTimes = s.nextInt();
				System.out.println();

				for (int i = 0; i < numTimes; i++) {

					System.out.println("Dados do " + (i + 1) + "º time:");
					System.out.println();

					System.out.print("Nome: ");
					String nomeTime = s.next();
					System.out.print("Ano de fundação: ");
					int anoTime = s.nextInt();
					System.out.println();

					System.out.print("Nome do treinador: ");
					String nomeTreinador = s.next();
					System.out.print("Ano de nascimento do treinador: ");
					int anoTreinador = s.nextInt();
					System.out.print("País de origem do treinador: ");
					String paisTreinador = s.next();
					System.out.print("Tempo no cargo(anos): ");
					double tempoTreinador = s.nextDouble();
					System.out.println();

					Treinador treinador = new Treinador(nomeTreinador, anoTreinador, paisTreinador, tempoTreinador);

					System.out.print("Informe o número de jogadores: ");
					int numJogadores = s.nextInt();
					System.out.println();

					ArrayList<Jogador> jogadores = new ArrayList<Jogador>();

					for (int j = 0; j < numJogadores; j++) {

						System.out.print("Posição do " + (j + 1) + "º jogador: ");
						String posicaoJ = s.next();

						if (posicaoJ.equals("Goleiro") || posicaoJ.equals("goleiro")) {

							System.out.print("Nome do " + (j + 1) + "º jogador: ");
							String nomeJ = s.next();
							System.out.print("Ano de nascimento do " + (j + 1) + "º jogador: ");
							int anoJ = s.nextInt();
							System.out.print("País de origem do " + (j + 1) + "º jogador: ");
							String paisJ = s.next();
							System.out.print("Pé dominante do " + (j + 1) + "º jogador(destro, canhoto, ambidestro): ");
							String peJ = s.next();
							System.out.print("Número de partidas do " + (j + 1) + "º jogador pelo time: ");
							int partidasJ = s.nextInt();
							System.out.print("Número de defesas do " + (j + 1) + "º jogador pelo time: ");
							int defesasJ = s.nextInt();
							System.out.print("Número de gols sofridos do " + (j + 1) + "º jogador pelo time: ");
							int golSofridosJ = s.nextInt();
							System.out.println();

							Jogador gol = new Goleiro(nomeJ, anoJ, paisJ, peJ, partidasJ, defesasJ, golSofridosJ);

							jogadores.add(gol);

						} else if (posicaoJ.equals("Fixo") || posicaoJ.equals("fixo") || posicaoJ.equals("Ala")
								|| posicaoJ.equals("ala") || posicaoJ.equals("Pivô") || posicaoJ.equals("pivô")
								|| posicaoJ.equals("Pivo") || posicaoJ.equals("pivo")) {

							System.out.print("Nome do " + (j + 1) + "º jogador: ");
							String nomeJ = s.next();
							System.out.println("Ano de nascimento do" + (j + 1) + "º jogador: ");
							int anoJ = s.nextInt();
							System.out.println("País de origem do " + (j + 1) + "º jogador: ");
							String paisJ = s.next();
							System.out.print("Pé dominante do " + (j + 1) + "º jogador(destro, canhoto, ambidestro):");
							String peJ = s.next();
							System.out.print("Número de partidas do " + (j + 1) + "º jogador pelo time: ");
							int partidasJ = s.nextInt();
							System.out.print("Número de gols do " + (j + 1) + "º jogador pelo time: ");
							int golsJ = s.nextInt();
							System.out.print("Número de assistências do " + (j + 1) + "º jogador pelo time: ");
							int assistenciasJ = s.nextInt();
							System.out.println();

							Jogador jgd = new JogadorDeLinha(nomeJ, anoJ, paisJ, peJ, partidasJ, posicaoJ, golsJ,
									assistenciasJ);

							jogadores.add(jgd);

						}
					}

					Time time = new Time(nomeTime, anoTime, treinador);
					time.setEquipe(jogadores);

					times.add(time);

				}

			} 
			else if (escolha == 2) {

				String nome = "C:\\Users\\jggno\\Downloads\\LNF\\LNF\\src\\Entrada.txt";

				Leitor l = new Leitor();
				l.efetuarLeitura(nome);

				times = l.getTimes();

			}

			System.out.println("[1] Saída por console.");
			System.out.println("[2] Saída por arquivo.");
			int escolhaSaida = s.nextInt();
			if(escolhaSaida != 1 && escolhaSaida != 2) {
				s.close();
				throw new EscolhaInvalidaException("Escolha inválida");
			}

			if (escolhaSaida == 1) {

				for (int k = 0; k < times.size(); k++) {
					System.out.println("#TIME " + (k + 1));
					Time clube = times.get(k);
					clube.mostra(anoAtual);
				}

			}
			else if(escolhaSaida == 2) {
				
				Escrita e = new Escrita(times);
				
				String nome = "Saida.txt";
				
				e.efetuaEscrita(nome, anoAtual);
			}
			
			s.close();
			
		}
		catch(InputMismatchException e) {
			System.out.println("Informação inválida.");
		}
		catch(EscolhaInvalidaException e) {
			System.out.println("Escolha inválida.");
		}
		catch(AindaNaoExisteException e) {
			System.out.println("O futsal surgiu em 1934.");
		}

	}

}
