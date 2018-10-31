package glouton.obj;

/**
 * A java object containing a path and his cost. Used by algorithm to save the
 * result.
 * 
 * @author dessenne
 *
 */
public class TSPResult {

	private int[] path;
	private Integer cost;

	public TSPResult(int[] path, Integer cost) {
		super();
		this.path = path;
		this.cost = cost;
	}

	public int[] getPath() {
		return path;
	}

	public Integer getCost() {
		return cost;
	}
}
