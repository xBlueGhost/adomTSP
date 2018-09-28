package hillclimbing.obj.services.initialization;

import java.util.List;

import glouton.exception.ConstructiveHeuristicsAlgorithmException;
import glouton.obj.RandomTSP;
import glouton.obj.services.RandomTSP.ConstructiveHeuristicsAlgorithm;

public class ConstructiveHeuristicInit implements Initialization {

	private ConstructiveHeuristicsAlgorithm cha;
	private RandomTSP rTSP;
	
	public ConstructiveHeuristicInit(ConstructiveHeuristicsAlgorithm cha, RandomTSP rTSP) {
		this.cha = cha;
		this.rTSP = rTSP;
	}

	@Override
	public int[] initPathAsArray(int init) {
		try {
			return cha.doAlgorithm(rTSP, init).getPath();
		} catch (ConstructiveHeuristicsAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Integer> initPathAsList(int init) {
//		public ArrayList<Integer> heuristiqueConstructive(Integer villeDepart, int[][] matrice) {
//		ArrayList<Integer> chemin = new ArrayList<Integer>();
//		return chemin;
		// }
		return null;
	}

}
