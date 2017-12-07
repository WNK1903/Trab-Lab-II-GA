package br.unisinos.lab2.TrabGA;

import java.io.File;
import java.io.IOException;

public class PokemonGoTest {

	public static void main(String[] args) {

		PokemonGo pk = new PokemonGo();
		try{
			pk.loadMatrix(new File("C:/Users/willi/workspace/Lab2/src/br/unisinos/lab2/TrabGA/matrix.txt"));
		}catch (IOException e) {
			e.printStackTrace();
		} catch (NumberFormatException n) {
			n.printStackTrace();
		}

		pk.evolve();
		pk.print();
	}
}
