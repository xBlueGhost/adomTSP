package memetic.obj.services.crossover;

import java.util.ArrayList;
import java.util.List;

import memetic.exception.CrossoverException;

public class OrderBasedCrossover implements Crossover {
	
	private void checkConditions(int index1, int index2, int[] p1, int[] p2) throws CrossoverException {
		if (p1.length != p2.length) {
			throw new CrossoverException("int[] p1 and int[] p2 must be the same size.");
		}
		if (index1 >= index2) {
			throw new CrossoverException("index1 must be < to index2.");
		}
		if(index1 < 0 || index1 >= p1.length) {
			throw new CrossoverException("index1 must be between 0 and p1/p2.length().");
		}
		if(index2 < 0 || index2 >= p1.length) {
			throw new CrossoverException("index2 must be between 0 and p1/p2.length().");
		}
	}

	@Override
	public int[] doCrossover(int index1, int index2, int[] p1, int[] p2) throws CrossoverException {

		checkConditions(index1, index2, p1, p2);
		
		int[] result = new int[p1.length];
		for (int i : result) {
			result[i] = -1;
		}

		List<Integer> segment = new ArrayList<>();
		for (int i = index1; i <= index2; i++) {
			segment.add(p1[i]);
		}

		int indexSegment = 0;
		for (int k = index1; k <= index2; k++) {
			result[k] = segment.get(indexSegment);
			indexSegment++;
		}
		
		int i = 0;
		int j = 0;
		while (i < p2.length) {
			if(!segment.contains(p2[i])){
				if(j == index1) {
					j = index2+1;
				}
				result[j] = p2[i];
				j++;
			}
			i++;
		}

		return result;
	}

}
