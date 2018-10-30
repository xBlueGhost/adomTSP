package memetic.obj.services.crossover;

import memetic.exception.CrossoverException;

public abstract class Crossover {

	private Integer index1;
	private Integer index2;
	
	public abstract int[] doCrossover(int index1, int index2, int[] p1, int[] p2) throws CrossoverException;

	public Integer getIndex1() {
		return index1;
	}

	public void setIndex1(int index1) {
		this.index1 = index1;
	}

	public Integer getIndex2() {
		return index2;
	}

	public void setIndex2(int index2) {
		this.index2 = index2;
	}
	
}
