package memetic.obj.services.populationInit;

import java.util.List;

import memetic.exception.PopulationInitializationException;

public interface PopulationInitialization {

	public List<int[]> initPopulation(int sizePop, int sizePath) throws PopulationInitializationException;
	
}
