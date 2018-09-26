package utils;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Method {

	// Implementing Fisher–Yates shuffle
	public static void shuffleArray(int[] ar) {
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
	
	public static int[] copy(int[] toCopy) {
		int[] copy = new int[toCopy.length];
		for (int i = 0; i < copy.length; i++) {
			copy[i] = toCopy[i];	
		}
		return copy;
	}
	
	public static int getRandomNumberInRange(int min, int max) {
		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}
		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}
	
}
