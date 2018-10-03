package memetic.obj.services.crossover;

import memetic.exception.CrossoverException;

public interface Crossover {

	public int[] doCrossover(int index1, int index2, int[] p1, int[] p2) throws CrossoverException;
	
}
