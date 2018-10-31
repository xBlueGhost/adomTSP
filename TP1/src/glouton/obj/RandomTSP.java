package glouton.obj;

/**
 * A java object for the content of a tsp file.
 * 
 * @author dessenne
 *
 */

public class RandomTSP {

	private String fileName;
	private String name;
	private Integer n;
	private Integer seed;
	private String type;
	private Integer dimension;
	private String edgeWeightType;
	private String edgeWeightFormat;
	private int[][] edgeWeightSection;

	public RandomTSP(String fileName, String name, Integer n, Integer seed, String type, Integer dimension,
			String edgeWeightType, String edgeWeightFormat) {
		super();
		this.fileName = fileName;
		this.name = name;
		this.n = n;
		this.seed = seed;
		this.type = type;
		this.dimension = dimension;
		this.edgeWeightType = edgeWeightType;
		this.edgeWeightFormat = edgeWeightFormat;
		this.edgeWeightSection = new int[dimension][dimension];
	}

	public String getFileName() {
		return fileName;
	}

	public String getName() {
		return name;
	}

	public Integer getN() {
		return n;
	}

	public Integer getSeed() {
		return seed;
	}

	public String getType() {
		return type;
	}

	public Integer getDimension() {
		return dimension;
	}

	public String getEdgeWeightType() {
		return edgeWeightType;
	}

	public String getEdgeWeightFormat() {
		return edgeWeightFormat;
	}

	public int[][] getEdgeWeightSection() {
		return edgeWeightSection;
	}

	public void setEdgeWeightSection(int[][] edgeWeightSection) {
		this.edgeWeightSection = edgeWeightSection;
	}

}
