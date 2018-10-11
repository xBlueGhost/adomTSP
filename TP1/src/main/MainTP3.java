package main;

import java.io.File;

import glouton.exception.RandomTSPException;
import glouton.obj.RandomTSP;
import glouton.obj.TSPResult;
import glouton.obj.services.RandomTSP.ReadFile;
import glouton.obj.services.constructHeuristic.NearestNeighborAlgorithm;
import hillclimbing.obj.services.initialization.ConstructiveHeuristicInit;
import memetic.obj.services.BasicAlgorithm;
import memetic.obj.services.crossover.OrderBasedCrossover;
import memetic.obj.services.populationInit.ConstructiveHeuristicPopulation;
import memetic.obj.services.populationInit.PopulationInitialization;
import memetic.obj.services.populationInit.RandomPopulation;

public class MainTP3 {

	public static void main(String[] args) {
		// Question 2
		RandomTSP tspA = ReadFile.readFile(new File("randomA100.tsp"));
//		BestNeighborImproving bni = new BestNeighborImproving(tspA);
//		RandomPathInit rpi = new RandomPathInit();
//		Swaping sw = new Swaping();
//		HillClimbing hc = new HillClimbing(rpi, sw, bni, tspA);

		PopulationInitialization pi1 = new RandomPopulation();
		PopulationInitialization pi2 = new ConstructiveHeuristicPopulation(
				new ConstructiveHeuristicInit(new NearestNeighborAlgorithm(), tspA));
		OrderBasedCrossover obc = new OrderBasedCrossover();
		BasicAlgorithm ba1 = new BasicAlgorithm(pi1, obc, tspA);
		BasicAlgorithm ba2 = new BasicAlgorithm(pi2, obc, tspA);
		System.out.println("TP2 : Question 2");
		try {
			TSPResult r1 = ba1.doAlgo(100);
			System.out.println("With RandomPopulation : ");
			System.out.println("Cost="+r1.getCost());
			TSPResult r2 = ba2.doAlgo(100);
			System.out.println("With ConstructiveHeuristicPopulation : ");
			System.out.println("Cost="+r2.getCost());
		} catch (RandomTSPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
