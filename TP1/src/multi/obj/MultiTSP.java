package multi.obj;

public class MultiTSP {

	private String name;
	private Integer dimension;
	private float[][] edgeWeightSection;
	
	public MultiTSP(String name, Integer dimension, float[][] edgeWeightSection) {
		super();
		this.name = name;
		this.dimension = dimension;
		this.edgeWeightSection = edgeWeightSection;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getDimension() {
		return dimension;
	}

	public void setDimension(Integer dimension) {
		this.dimension = dimension;
	}

	public float[][] getEdgeWeightSection() {
		return edgeWeightSection;
	}

	public void setEdgeWeightSection(float[][] edgeWeightSection) {
		this.edgeWeightSection = edgeWeightSection;
	}
	
}
