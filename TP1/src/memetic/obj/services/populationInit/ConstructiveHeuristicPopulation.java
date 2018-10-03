package memetic.obj.services.populationInit;

import java.util.ArrayList;
import java.util.List;

import hillclimbing.obj.services.initialization.ConstructiveHeuristicInit;
import memetic.exception.PopulationInitializationException;
import utils.Method;

public class ConstructiveHeuristicPopulation implements PopulationInitialization {

	private ConstructiveHeuristicInit init;
	
	public ConstructiveHeuristicPopulation(ConstructiveHeuristicInit init) {
		super();
		this.init = init;
	}

	@Override
	public List<int[]> initPopulation(int sizePop, int sizePath) throws PopulationInitializationException {
		List<int[]> result = new ArrayList<>();
		if(sizePop>init.getrTSP().getDimension()) {
			throw new PopulationInitializationException("Population size cannot be over RandomTSP dimension.");
		} else {
			for (int i = 0; i < sizePop; i++) {
				int rand = Method.getRandomNumberInRange(0, sizePop-1);
				int[] tmp = init.initPathAsArray(rand);
				if(!result.contains(tmp)) {
					result.add(tmp);
				} else {
					i--;
				}
			}
		}
		return result;
	}

}
