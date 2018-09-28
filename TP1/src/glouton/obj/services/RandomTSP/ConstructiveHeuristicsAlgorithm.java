package glouton.obj.services.RandomTSP;

import glouton.exception.ConstructiveHeuristicsAlgorithmException;
import glouton.obj.RandomTSP;
import glouton.obj.TSPResult;

public interface ConstructiveHeuristicsAlgorithm {

	public abstract TSPResult doAlgorithm(RandomTSP rTSP, int beginAt)
			throws ConstructiveHeuristicsAlgorithmException;
	
}
