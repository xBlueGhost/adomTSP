package memetic.obj.services;

import glouton.exception.RandomTSPException;
import glouton.obj.RandomTSP;
import glouton.obj.TSPResult;
import glouton.obj.services.RandomTSP.Evaluate;
import memetic.obj.services.crossover.Crossover;
import memetic.obj.services.mutation.Mutation;
import memetic.obj.services.mutation.SwapMutation;
import memetic.obj.services.populationInit.PopulationInitialization;

public class BasicAlgorithm extends EvolutionnaryAlgorithm {

	public BasicAlgorithm(PopulationInitialization popInit, Crossover crossover, RandomTSP rTSP) {
		super(popInit, crossover, rTSP);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected TSPResult template(int[] path) throws RandomTSPException {
		Mutation mutation = new SwapMutation();
		int[] result = mutation.doMutation(path);
		return new TSPResult(result, Evaluate.eval(rTSP, path));
	}

}
