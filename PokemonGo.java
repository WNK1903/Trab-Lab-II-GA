package br.unisinos.lab2.TrabGA;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.FileReader;

public class PokemonGo implements IPokemonGo {

	private Chromosome[] melhores;
	private Integer[][] matrix;

	public PokemonGo() {
		melhores = new Chromosome[10];
		matrix = new Integer[16][16];

	}

	// Método responsável pela leitura da matriz.
	public void loadMatrix(File file) throws IOException, NumberFormatException {

		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line;
			int i = 0;
			while ((line = br.readLine()) != null && i < 16) {
				String[] cools = line.split(";");
				for (int j = 0; j < 16; j++) {
					matrix[i][j] = Integer.parseInt(cools[j]);
				}
				i++;
			}

		}

	}

	// Método que gera um novo cromossomo.
	public Chromosome generateChromosome() {
		Chromosome c = new Chromosome();
		int[] vet = new int[6];
		vet[0] = 0;
		vet[1] = 1 + (int) (Math.random() * 3);
		vet[2] = 4 + (int) (Math.random() * 4);
		vet[3] = 8 + (int) (Math.random() * 4);
		vet[4] = 12 + (int) (Math.random() * 3);
		vet[5] = 15;

		c.setGenes(vet);

		// Calcula o fitness do chromosomo.
		c.setFitness(distance(c.getGenes()));

		return c;

	}

	// Método que faz a inserção ordenada no array de melhores chromosomos.
	public void insertOrderedChromosome(Chromosome chromosome) {

		for (int i = 0; i < melhores.length; i++) {
			if (melhores[i] == null) {
				melhores[i] = chromosome;
				break;
			}

			if (melhores[i].getFitness() > chromosome.getFitness()) {
				Chromosome c = melhores[i];
				melhores[i] = chromosome;
				chromosome = c;

			}
			
			if (melhores[i].getFitness() == chromosome.getFitness()) {
				if (melhores[i].equals(chromosome.getGenes())) {
					break;
				}
			}
			
		

			

		}
	}

	// Método que calcula a distancia(fitness) do chromosomo.
	public int distance(int[] genes) {
		int a = matrix[genes[0]][genes[1]];
		a += matrix[genes[1]][genes[2]];
		a += matrix[genes[2]][genes[3]];
		a += matrix[genes[3]][genes[4]];
		a += matrix[genes[4]][genes[5]];
		return a;

	}

	// Método que faz 100 iterações e insere ordenadamente no array de melhores
	// chromosomos.
	public void evolve() {
		for (int i = 0; i < 100; i++) {
			insertOrderedChromosome(generateChromosome());
		}
	}

	// Exibe o array de melhores chromosomos.
	public void print() {
		for (int i = 0; i < melhores.length; i++) {
			System.out.println(melhores[i].toString());
		}
	}
}
