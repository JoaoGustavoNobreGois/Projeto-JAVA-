package arquivo;

import entities.*;
import entities2.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Escrita {

	private ArrayList<Time> times;
	
	public Escrita(ArrayList<Time> times) {
		
		this.times = times;
		
	}
	
	public void efetuaEscrita(String filename, int anoAtual) throws IOException{
		
		File f = new File(filename);
		
		FileWriter fw = new FileWriter(f);
		
		int i = 1;
		
		fw.write("##ANALISE DOS DADOS TIMES DE FUTSAL##\n");
		
		for(Time t : times) {
			
			
			Treinador tec = t.getTreinador();
			fw.write("\n");
			fw.write("#TIME " + i + "\n");
			fw.write(t.getNome() + ", " + t.Idade(anoAtual) + " anos.\n");
			fw.write("\n");
			fw.write("Treinador: " + tec.getNome() + ", " + tec.Idade(anoAtual) + ", " + tec.getPaisOrigem() + ", " + tec.getAnosNoCargo() + " anos no cargo.\n");
			fw.write("\n");
			fw.write("Jogadores:");
			fw.write("\n");
			
			ArrayList <Jogador> jgds = t.getEquipe();
			
			for(int j=0;j<jgds.size();j++) {
				
				
				Jogador jgd = jgds.get(j);
				
				if (jgd instanceof Goleiro) {
					
					Goleiro gol = (Goleiro) jgd;
					
					fw.write((j+1) + ". " + gol.getNome() + ", " + gol.Idade(anoAtual) + " anos, " + gol.getPaisOrigem() + ", goleiro, " + gol.getPeDominante() + ", " + new DecimalFormat("####.##").format(gol.DPP()) + " D/P, " + new DecimalFormat("####.##").format(gol.GSPP()) + " GS/P.\n");
					
				}
				else if (jgd instanceof JogadorDeLinha) {
					
					JogadorDeLinha jog = (JogadorDeLinha) jgd;
					
					fw.write((j+1) + ". " + jog.getNome() + ", " + jog.Idade(anoAtual) + " anos, " + jog.getPaisOrigem() + ", " + jog.getPosicao() + ", " + jog.getPeDominante() + ", " + new DecimalFormat("####.##").format(jog.GPP()) + " G/P, " + new DecimalFormat("####.##").format(jog.APP()) + " A/P.\n");
					
				}
				
			}
			
			fw.write("\n");
			fw.write("Dados gerais do " + t.getNome() + ": \n");
			fw.write("\n");
			
			fw.write("Gols totais: " + t.gols() + "\n");
			fw.write("Assistencias totais: " + t.assistencias() + "\n");
			fw.write("Defesas totais: " + t.defesas() + "\n");
			fw.write("Gols sofridos totais: " + t.golSofridos() + "\n");
			fw.write("Número de brasileiros: " + t.brasileiros() + "\n");
			fw.write("Número de estrangeiros: " + t.estrangeiros() + "\n");
			fw.write("Média de idade dos jogadores: " + new DecimalFormat("##.##").format(t.mediaIdades(anoAtual)) + " anos.\n");
			
			i++;
			
		}
		
		fw.close();
		
	}
}
