package memetic.obj.services.mutation;

import hillclimbing.obj.services.neighborhood.Swaping;
import utils.Method;

public class SwapMutation implements Mutation {

	@Override
	public int[] doMutation(int[] path) {
		int index1 = 0, index2 = 0;
		while(index1 == index2) {
			index1 = Method.getRandomNumberInRange(0, path.length-1);
			index2 = Method.getRandomNumberInRange(0, path.length-1);
		}
		return Swaping.swap(path, index1, index2);
	}
	
}
