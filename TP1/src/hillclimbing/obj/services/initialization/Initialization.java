package hillclimbing.obj.services.initialization;

import java.util.List;

public interface Initialization {

	public int[] initPathAsArray(int init);
	
	public List<Integer> initPathAsList(int init);
	
}
