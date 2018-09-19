package glouton.obj.services.RandomTSP;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import glouton.exception.RandomTSPException;
import glouton.obj.RandomTSP;

public class Evaluate {

	/**
	 * Question 2.2 : Développer une fonction d’évaluation, capable de calculer la
	 * valeur à l’objectif f(π) d’une solution (permutation) π passée en paramètre.
	 * 
	 * @param cities (begin with 0)
	 * @return
	 * @throws RandomTSPException
	 */
	public static Integer eval(RandomTSP rTSP, int[] cities) throws RandomTSPException {
		// Check
		for (int i = 0; i < cities.length; i++) {
			int toCheck = cities[i];
			for (int j = 0; j < cities.length; j++) {
				if (toCheck == cities[j] && i != j) {
					throw new RandomTSPException("Invalid parameters : all cities must be unique.");
				}
			}
		}
		// Evaluation
		int result = 0;
		for (int i = 0; i < cities.length; i++) {
			if (i == cities.length - 1) {
				result = result + rTSP.getEdgeWeightSection()[cities[i]][cities[0]];
			} else {
				result = result + rTSP.getEdgeWeightSection()[cities[i]][cities[i + 1]];

			}
		}
		System.out.println(
				"Evaluation for file " + rTSP.getFileName() + " with " + Arrays.toString(cities) + " = " + result);
		return result;
	}

	/**
	 * Question 2.3 : Générer une solution aléatoire (une permutation), et
	 * l’évaluer. Quelle est sa qualité par rapport à la meilleure solution connue ?
	 * 
	 * @param cities (begin with 0)
	 * @return
	 * @throws RandomTSPException
	 */
	public static Integer randomEval(RandomTSP rTSP) throws RandomTSPException {
		int[] cities = new int[rTSP.getDimension()];
		System.out.println("[INFO] : initializing cities...");
		for (int i = 0; i < cities.length; i++) {
			cities[i] = i;
		}
		System.out.println("[INFO] : Cities initialized.");
		System.out.println("[INFO] : Cities length = " + cities.length);
		System.out.println("[INFO] : Cities = " + Arrays.toString(cities));
		System.out.println("[INFO] : Shuffling cities...");
		shuffleArray(cities);
		System.out.println("[INFO] : Cities shuffled.");
		System.out.println("[INFO] : Cities = " + Arrays.toString(cities));
		return eval(rTSP, cities);
	}

	// Implementing Fisher–Yates shuffle
	private static void shuffleArray(int[] ar) {
		// If running on Java 6 or older, use `new Random()` on RHS here
		Random rnd = ThreadLocalRandom.current();
		for (int i = ar.length - 1; i > 0; i--) {
			int index = rnd.nextInt(i + 1);
			// Simple swap
			int a = ar[index];
			ar[index] = ar[i];
			ar[i] = a;
		}
	}

}
