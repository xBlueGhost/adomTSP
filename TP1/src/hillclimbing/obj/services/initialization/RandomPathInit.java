package hillclimbing.obj.services.initialization;

import java.util.ArrayList;
import java.util.List;
import utils.Method;

public class RandomPathInit implements Initialization {

	@Override
	public int[] initPathAsArray(int init) {
		int[] path = new int[init];
		for (int i = 0; i < path.length; i++) {
			path[i] = i;
		}
		Method.shuffleArray(path);
		return path;
	}

	@Override
	public List<Integer> initPathAsList(int init) {
		ArrayList<Integer> cycleTmp = new ArrayList<>();
		ArrayList<Integer> cycleAleatoire = new ArrayList<>();
		
		for (int i = 1; i <= init; i++) {
			cycleTmp.add(i);
		}

		while (cycleTmp.size() != 0) {
			int x=0;
	        x=(int)( Math.random()*cycleTmp.size());
	        cycleAleatoire.add(cycleTmp.get(x));
	        cycleTmp.remove(x);
		}
		return cycleAleatoire;
	}

}
