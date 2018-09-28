package hillclimbing.obj.services.neighborhood;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import utils.Method;

public class TwoOpt implements Neighborhood{
	
	@Override
	public List<int[]> getNeighborhood(int[] path) {
			ArrayList<int[]> neighbors = new ArrayList<>();
			for (int i = 0; i < path.length-1; i++) {
				for (int j = i+1; j < path.length; j++) {
					neighbors.add(twoOpt(path, i, j));
				}
			}
			return neighbors;
	}
	
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

	public static int[] twoOpt(int[] path, int first, int last){
		int[] newPath = Method.copy(path);
		int j = last;
		for (int i = first; i <= (last-first)/2; i++) {
			newPath = Swaping.swap(newPath, i, j);
			j--;
		}
		return newPath;
	}

}
