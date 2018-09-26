package hillclimbing.obj.services.initialization;

import java.util.ArrayList;

import glouton.exception.ConstructiveHeuristicsAlgorithmException;
import glouton.obj.RandomTSP;
import glouton.obj.services.RandomTSP.ConstructiveHeuristicsAlgorithm;
import utils.Method;

public class Initialization {
	
	public ArrayList<Integer> createRandomPathList(int size) {
		ArrayList<Integer> cycleTmp = new ArrayList<>();
		ArrayList<Integer> cycleAleatoire = new ArrayList<>();
		
		for (int i = 1; i <= size; i++) {
			cycleTmp.add(i);
		}

		while (cycleTmp.size() != 0) {
			int x=0;
	        x=(int)( Math.random()*cycleTmp.size());
	        cycleAleatoire.add(cycleTmp.get(x));
	        cycleTmp.remove(x);
		}
		return cycleAleatoire;
	}
	
	public int[] createRandomPathArray(int size) {
		int[] path = new int[size];
		for (int i = 0; i < path.length; i++) {
			path[i] = i;
		}
		Method.shuffleArray(path);
		return path;
	}
	
//	public ArrayList<Integer> heuristiqueConstructive(Integer villeDepart, int[][] matrice) {
//		ArrayList<Integer> chemin = new ArrayList<Integer>();
//		return chemin;
//	}
	
	public int[] constructiveHeuristics(ConstructiveHeuristicsAlgorithm cha, RandomTSP rTSP, int beginAt) {
		try {
			return cha.doAlgorithm(rTSP, beginAt).getPath();
		} catch (ConstructiveHeuristicsAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}

}
