package memetic.obj.services;

import java.util.List;

import hillclimbing.obj.services.HillClimbing;
import memetic.exception.CrossoverException;
import memetic.exception.PopulationInitializationException;
import memetic.obj.services.crossover.Crossover;
import memetic.obj.services.mutation.Mutation;
import memetic.obj.services.populationInit.PopulationInitialization;
import utils.Method;

public class MemeticAlgorithm {

	private PopulationInitialization popInit;
	private Crossover crossover;
	private Mutation mutation;
	
	public MemeticAlgorithm(PopulationInitialization popInit, Crossover crossover, Mutation mutation) {
		super();
		this.popInit = popInit;
		this.crossover = crossover;
		this.mutation = mutation;
	}
	
	public void doAlgo(int sizePop) {
		try {
			//init population
			List<int[]> population = popInit.initPopulation(sizePop, 100 /*//TODO*/);
			
			//choose p1 p2
			int rand1 = 0, rand2 = 0;
			while(rand1==rand2) {
				rand1 = Method.getRandomNumberInRange(0, population.size()-1);
				rand2 = Method.getRandomNumberInRange(0, population.size()-1);
			}
			int[] p1 = population.get(rand1);
			int[] p2 = population.get(rand2);
			
			//create e
			int rand3 = 0, rand4 = 0;
			while(rand3==rand4 || rand3>=rand4) {
				rand3 = Method.getRandomNumberInRange(0, 99 /*//TODO*/);
				rand4 = Method.getRandomNumberInRange(0, 99 /*//TODO*/);
			}
			int[] e = crossover.doCrossover(rand3, rand4, p1, p2);
			//TODO hillClimbing to e
		} catch (PopulationInitializationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CrossoverException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
