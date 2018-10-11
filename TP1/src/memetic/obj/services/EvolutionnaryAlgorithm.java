package memetic.obj.services;

import java.util.List;

import glouton.exception.RandomTSPException;
import glouton.obj.RandomTSP;
import glouton.obj.TSPResult;
import glouton.obj.services.RandomTSP.Evaluate;
import memetic.exception.CrossoverException;
import memetic.exception.PopulationInitializationException;
import memetic.obj.services.crossover.Crossover;
import memetic.obj.services.populationInit.PopulationInitialization;
import utils.Method;

public abstract class EvolutionnaryAlgorithm {

	protected PopulationInitialization popInit;
	protected Crossover crossover;
	protected RandomTSP rTSP;
	
	public EvolutionnaryAlgorithm(PopulationInitialization popInit, Crossover crossover, RandomTSP rTSP) {
		super();
		this.popInit = popInit;
		this.crossover = crossover;
		this.rTSP = rTSP;
	}
	
	protected abstract TSPResult template(int[] path) throws RandomTSPException;
	
	public TSPResult doAlgo(int sizePop) throws RandomTSPException {
		try {
			int noNewGeneration = 25;
			int currentNoNewGeneration = 0;
			// init population
			List<int[]> population = popInit.initPopulation(sizePop, rTSP.getDimension());

			int i = 0;
			while (i <= 1000 || noNewGeneration == currentNoNewGeneration) {
				// choose p1 p2
				int[][] ps = bestParents(population);
				int[] p1 = ps[0];
				int[] p2 = ps[1];

				// create e
				int rand1 = 0, rand2 = 0;
				while (rand1 == rand2 || rand1 >= rand2) {
					rand1 = Method.getRandomNumberInRange(0, rTSP.getDimension()-1);
					rand2 = Method.getRandomNumberInRange(0, rTSP.getDimension()-1);
				}
				int[] e = crossover.doCrossover(rand1, rand2, p1, p2);

				// hillClimbing to e
				TSPResult result = template(e);

				// insert e in population
				population.add(result.getPath());

				// evaluate
				int cost = 0;
				int[] path = null;
				for (int[] is : population) {
					int tmp = Evaluate.eval(rTSP, is);
					if (cost == 0 || cost < tmp) {
						cost = tmp;
						path = is;
					}
				}
				if(cost == result.getCost()) {
					currentNoNewGeneration++;
					population.remove(result.getPath());
				} else {
					currentNoNewGeneration = 0;
					population.remove(path);
				}
				i++;
			}
			// evaluate
			int cost = 0;
			int[] path = null;
			for (int[] is : population) {
				int tmp = Evaluate.eval(rTSP, is);
				if (cost == 0 || cost > tmp) {
					cost = tmp;
					path = is;
				}
			}
			return new TSPResult(path, cost);
		} catch (PopulationInitializationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CrossoverException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	protected int[][] bestParents(List<int[]> population) throws RandomTSPException {
		int[] p1 = null;
		int[] p2 = null;
		int tmp1 = 0;
		int tmp2 = 0;
		for (int[] is : population) {
			tmp2 = Evaluate.eval(rTSP, is);
			if (tmp1 == 0 || tmp1 < tmp2) {
				tmp1 = tmp2;
				p1 = is;
			}
		}
		tmp1 = 0;
		tmp2 = 0;
		for (int[] is : population) {
			tmp2 = Evaluate.eval(rTSP, is);
			if ((tmp1 == 0 || tmp1 < tmp2) && !is.equals(p1)) {
				tmp1 = tmp2;
				p2 = is;
			}
		}
		return new int[][] { p1, p2 };
	}
}
