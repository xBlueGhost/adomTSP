package hillclimbing.obj.services;

import java.util.List;

import glouton.exception.RandomTSPException;
import glouton.obj.RandomTSP;
import glouton.obj.TSPResult;
import glouton.obj.services.RandomTSP.Evaluate;
import hillclimbing.obj.services.initialization.Initialization;
import hillclimbing.obj.services.movement.Move;
import hillclimbing.obj.services.neighborhood.Neighborhood;

public class HillClimbing {

	private Initialization initialization;
	private Neighborhood neighborhood;
	private Move move;
	private RandomTSP rTSP;
	
	public HillClimbing(Initialization initialization, Neighborhood neighborhood, Move move, RandomTSP rTSP) {
		super();
		this.initialization = initialization;
		this.neighborhood = neighborhood;
		this.move = move;
		this.rTSP = rTSP;
	}
	
	public TSPResult doAlgo(int init) {
		int[] initPath = initialization.initPathAsArray(init);
		TSPResult initResult = null;
		try {
			initResult = new TSPResult(initPath, Evaluate.eval(rTSP, initPath));
		} catch (RandomTSPException e) {
			e.printStackTrace();
			return null;
		}
		List<int[]> neighbor;
		while(true) {
			neighbor = neighborhood.getNeighborhood(initResult.getPath());
			TSPResult result = move.doMove(neighbor);
			if (result.getCost() < initResult.getCost()) {
				break;
			} else {
				initResult = result;
			}
		}
		return initResult;
	}
	
}
