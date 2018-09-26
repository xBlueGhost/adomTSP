package hillclimbing.obj.services.neighborhood;

import java.util.ArrayList;
import java.util.Collections;

import utils.Method;

public class TwoOpt {
	
	public ArrayList<ArrayList<Integer>> twoOpt(ArrayList<Integer> chemin) {
		ArrayList<ArrayList<Integer>> voisinages = new ArrayList<ArrayList<Integer>>();
		int i = 1;
		int j;
		
		while (i < chemin.size()) {
			j = i+1;
			while (j < chemin.size()) {
				ArrayList<Integer> cycleModifier = new ArrayList<Integer>(chemin);
				Collections.reverse(cycleModifier.subList(i, j+1));		
				voisinages.add(cycleModifier);
				j++;		
			}
			i++;
		}
		return voisinages;
	}

	public static int[] twoOpt(int[] path){
		int size = path.length;
		int firstToSwap = 0,lastToSwap = 0;
		while(firstToSwap==lastToSwap || firstToSwap >= lastToSwap) {
			firstToSwap = Method.getRandomNumberInRange(0, size-1);
			lastToSwap = Method.getRandomNumberInRange(0, size-1);
		}
		int[] newPath = Method.copy(path);
		int j = lastToSwap;
		for (int i = firstToSwap; i <= (lastToSwap-firstToSwap)/2; i++) {
			newPath[i] = j;
			j--;
		}
		return newPath;
	}
	
}
