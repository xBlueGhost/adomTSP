package glouton.obj;

public class ConstructiveHeuristicsAlgorithmResult {

	private int[] path;
	private Integer cost;

	public ConstructiveHeuristicsAlgorithmResult(int[] path, Integer cost) {
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
