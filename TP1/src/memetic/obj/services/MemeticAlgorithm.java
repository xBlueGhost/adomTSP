package memetic.obj.services;

import glouton.obj.RandomTSP;
import glouton.obj.TSPResult;
import hillclimbing.obj.services.HillClimbing;
import memetic.obj.services.crossover.Crossover;
import memetic.obj.services.populationInit.PopulationInitialization;

public class MemeticAlgorithm extends EvolutionnaryAlgorithm {

	private HillClimbing hillClimbing;
	
	public MemeticAlgorithm(PopulationInitialization popInit, Crossover crossover, RandomTSP rTSP, HillClimbing hillClimbing) {
		super(popInit, crossover, rTSP);
		if(rTSP.equals(hillClimbing.getrTSP())) {
			this.hillClimbing = hillClimbing;
		} else {
			throw new IllegalArgumentException("RandomTSP of MemeticAlgorithm need to be the same of the RandomTSP of HillClimbing.");
		}
	}

	@Override
	protected TSPResult template(int[] path) {
		return hillClimbing.doAlgo(path);
	}

}
