package br.unisinos.lab2.TrabGA;

public class Chromosome {

	private int[] genes;
	private int fitness;

	public Chromosome() {
	}

	public Chromosome(int[] genes, int fitness) {
		this.genes = genes;
		this.fitness = fitness;
	}

	public int[] getGenes() {
		return genes;
	}

	public void setGenes(int[] genes) {
		this.genes = genes;
	}

	public int getFitness() {
		return fitness;
	}

	public void setFitness(int fitness) {
		this.fitness = fitness;
	}

	//Sobrescrita do método toString que 
	public String toString() {
		String letra = null;
		String aux = "Short path: " + fitness;
		for (int i = 0; i < genes.length; i++) {
			if (genes[i] == 0) {
				letra = "A";
			} else if (genes[i] == 1) {
				letra = "B";
			} else if (genes[i] == 2) {
				letra = "C";
			} else if (genes[i] == 3) {
				letra = "D";
			} else if (genes[i] == 4) {
				letra = "E";
			} else if (genes[i] == 5) {
				letra = "F";
			} else if (genes[i] == 6) {
				letra = "G";
			} else if (genes[i] == 7) {
				letra = "H";
			} else if (genes[i] == 8) {
				letra = "I";
			} else if (genes[i] == 9) {
				letra = "J";
			} else if (genes[i] == 10) {
				letra = "K";
			} else if (genes[i] == 11) {
				letra = "L";
			} else if (genes[i] == 12) {
				letra = "M";
			} else if (genes[i] == 13) {
				letra = "N";
			} else if (genes[i] == 14) {
				letra = "O";
			} else {
				letra = "P";
			}
			aux = aux + " " + letra + " ";
		}
		return aux;

	}

	// Sobrescrita do método equals, para comparar os genes dos chromosomos.
	public boolean equals(int[] genes) {
		for(int i = 0; i < genes.length; i++){
			if(this.genes[i] != genes[i]){
				return false;
			}
		}
		return true;

	}
}
