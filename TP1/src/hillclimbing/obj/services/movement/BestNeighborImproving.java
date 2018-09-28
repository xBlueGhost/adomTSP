package hillclimbing.obj.services.movement;

import java.util.List;

import glouton.exception.RandomTSPException;
import glouton.obj.RandomTSP;
import glouton.obj.TSPResult;
import glouton.obj.services.RandomTSP.Evaluate;

public class BestNeighborImproving extends Move {
	
	public BestNeighborImproving(RandomTSP rTSP) {
		super(rTSP);
	}

	@Override
	public TSPResult doMove(List<int[]> paths) {
		int[] initPath = paths.get(0);
		int initCost = 0;
		int cost = -1;
		int[] resultPath = null;
		try {
			initCost = Evaluate.eval(getrTSP(), initPath);
			for (int[] path : paths) {
				int tmpCost = Evaluate.eval(getrTSP(), path);
				if(initCost < tmpCost && tmpCost > cost) {
					cost = tmpCost;
					resultPath = path;
				}
			}
		} catch (RandomTSPException e) {
			e.printStackTrace();
			return null;
		}
		return new TSPResult(resultPath, cost);
	}

}
