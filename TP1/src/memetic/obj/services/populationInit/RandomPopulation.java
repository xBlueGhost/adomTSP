package memetic.obj.services.populationInit;

import java.util.ArrayList;
import java.util.List;

import hillclimbing.obj.services.initialization.RandomPathInit;

public class RandomPopulation implements PopulationInitialization{

	@Override
	public List<int[]> initPopulation(int sizePop, int sizePath){
		RandomPathInit rpi = new RandomPathInit();
		List<int[]> result = new ArrayList<>();
		for (int i = 0; i < sizePop; i++) {
			int[] tmp = rpi.initPathAsArray(sizePath);
			if(!result.contains(tmp)) {
				result.add(tmp);
			} else {
				i--;
			}
		}
		return result;
	}
	
}
