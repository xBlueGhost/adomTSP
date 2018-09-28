package hillclimbing.obj.services.movement;

import java.util.List;

import glouton.obj.RandomTSP;
import glouton.obj.TSPResult;

public abstract class Move {

	private RandomTSP rTSP;
	
	public Move(RandomTSP rTSP) {
		this.setrTSP(rTSP);
	}
	
	public abstract TSPResult doMove(List<int[]> paths);

	public RandomTSP getrTSP() {
		return rTSP;
	}

	public void setrTSP(RandomTSP rTSP) {
		this.rTSP = rTSP;
	}
	
}
