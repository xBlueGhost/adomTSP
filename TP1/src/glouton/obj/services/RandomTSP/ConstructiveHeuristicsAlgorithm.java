package glouton.obj.services.RandomTSP;

import glouton.exception.ConstructiveHeuristicsAlgorithmException;
import glouton.obj.ConstructiveHeuristicsAlgorithmResult;
import glouton.obj.RandomTSP;

public interface ConstructiveHeuristicsAlgorithm {

	public abstract ConstructiveHeuristicsAlgorithmResult doAlgorithm(RandomTSP rTSP, int beginAt)
			throws ConstructiveHeuristicsAlgorithmException;
	
}
