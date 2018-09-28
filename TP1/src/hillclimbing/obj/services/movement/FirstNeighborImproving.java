package hillclimbing.obj.services.movement;

import java.util.List;

import glouton.exception.RandomTSPException;
import glouton.obj.RandomTSP;
import glouton.obj.TSPResult;
import glouton.obj.services.RandomTSP.Evaluate;

public class FirstNeighborImproving extends Move {

	public FirstNeighborImproving(RandomTSP rTSP) {
		super(rTSP);
	}

	@Override
	public TSPResult doMove(List<int[]> paths) {
		int[] initPath = paths.get(0);
		int initCost = 0;
		int cost = -1;
		int i = 1;
		try {
			initCost = Evaluate.eval(getrTSP(), initPath);
			while (initCost >= cost) {
				cost = Evaluate.eval(getrTSP(), paths.get(i));
				i++;
			}
		} catch (RandomTSPException e) {
			e.printStackTrace();
			return null;
		}
		return new TSPResult(paths.get(i-1), cost);
	}

}
