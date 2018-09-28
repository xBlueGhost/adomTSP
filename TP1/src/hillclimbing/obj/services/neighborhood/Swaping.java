package hillclimbing.obj.services.neighborhood;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import utils.Method;

public class Swaping implements Neighborhood{

	@Override
	public List<int[]> getNeighborhood(int[] path) {
			ArrayList<int[]> neighbors = new ArrayList<>();
			for (int i = 0; i < path.length-1; i++) {
				for (int j = i+1; j < path.length; j++) {
					neighbors.add(swap(path, i, j));
				}
			}
			return neighbors;
	}
	
	public static ArrayList<ArrayList<Integer>> swap(ArrayList<Integer> cities) {
		ArrayList<ArrayList<Integer>> voisinage = new ArrayList<ArrayList<Integer>>();
		int i = 1;
		int j;

		while (i < cities.size()) {
			j = i + 1;
			while (j < cities.size()) {
				ArrayList<Integer> cycleModifier = new ArrayList<Integer>(cities);
				Collections.swap(cycleModifier, i, j);
				voisinage.add(cycleModifier);
				j++;
			}
			i++;
		}
		return voisinage;
	}

	public static int[] swap(int[] path, int first, int second) {
		int tmp = 0;
		int[] newPath = Method.copy(path);
		tmp = newPath[first];
		newPath[first] = newPath[second];
		newPath[second] = tmp;
		return newPath;
	}

}
