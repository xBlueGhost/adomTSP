package main;

import java.io.File;
import glouton.obj.RandomTSP;
import glouton.obj.TSPResult;
import glouton.obj.services.RandomTSP.ReadFile;
import glouton.obj.services.constructHeuristic.NearestNeighborAlgorithm;
import hillclimbing.obj.services.HillClimbing;
import hillclimbing.obj.services.initialization.ConstructiveHeuristicInit;
import hillclimbing.obj.services.initialization.RandomPathInit;
import hillclimbing.obj.services.movement.BestNeighborImproving;
import hillclimbing.obj.services.movement.FirstNeighborImproving;
import hillclimbing.obj.services.neighborhood.Swaping;
import hillclimbing.obj.services.neighborhood.TwoOpt;

public class MainTP2 {

	public static void main(String[] args) {
		File f = new File("randomA100.tsp");
		RandomTSP a = ReadFile.readFile(f);
		
		
		
		
		System.out.println("------------------------------------------------------------");
		System.out.println("Question 2 et 4");
		
		HillClimbing hillClimbingSwapFirstNeighbor = new HillClimbing(new RandomPathInit(), new Swaping(), new FirstNeighborImproving(a), a);
		HillClimbing hillClimbingTwoOptFirstNeighbor = new HillClimbing(new RandomPathInit(), new TwoOpt(), new FirstNeighborImproving(a), a);
		HillClimbing hillClimbingSwapBestNeighbor = new HillClimbing(new RandomPathInit(), new Swaping(), new BestNeighborImproving(a), a);
		HillClimbing hillClimbingTwoOptBestNeighbor = new HillClimbing(new RandomPathInit(), new TwoOpt(), new BestNeighborImproving(a), a);
		
		int[] a1 = new int[] {0,1,2,3,4,5,6,7,8,9};
		int[] a2 = new int[] {9,8,7,6,5,4,3,2,1,0};
		
		
		
		int[] swaping = Swaping.swap(a1, 3, 8);
		int[] twoOpt = TwoOpt.twoOpt(a2, 2, 7);
		
		
		
		for (int i=0; i< swaping.length; i++) {
			System.out.println(swaping[i]);
		}
		
		System.out.println("------------------------------------------------------------");
		
		TSPResult tspResult1 = hillClimbingSwapFirstNeighbor.doAlgo(a1);
		
		for (int i=0; i< tspResult1.getPath().length; i++) {
			System.out.println(tspResult1.getPath()[i]);
		}
		
		System.out.println("------------------------------------------------------------");
		
		TSPResult tspResult12 = hillClimbingSwapBestNeighbor.doAlgo(a1);
		
		for (int i=0; i< tspResult12.getPath().length; i++) {
			System.out.println(tspResult12.getPath()[i]);
		}
		
		System.out.println("------------------------------------------------------------");
		
		
		for (int i=0; i< twoOpt.length; i++) {
			System.out.println(twoOpt[i]);
		}
		
		System.out.println("------------------------------------------------------------");
		
		
		TSPResult tspResult2 = hillClimbingTwoOptFirstNeighbor.doAlgo(a1);
		
		for (int i=0; i< tspResult2.getPath().length; i++) {
			System.out.println(tspResult2.getPath()[i]);
		}
		
		System.out.println("------------------------------------------------------------");
		
		TSPResult tspResult22 = hillClimbingTwoOptBestNeighbor.doAlgo(a1);
		
		for (int i=0; i< tspResult22.getPath().length; i++) {
			System.out.println(tspResult22.getPath()[i]);
		}
		
		
		System.out.println("------------------------------------------------------------");
		

		System.out.println("Question 3");
		
		RandomPathInit randomPathInit = new RandomPathInit();
		int[] randomPath = randomPathInit.initPathAsArray(10);
		
		
		for (int i = 0; i < randomPath.length; i++) {
			System.out.println(randomPath[i]);
		}
		
		System.out.println("------------------------------------------------------------");
		
		ConstructiveHeuristicInit constructiveHeuristicInit = new ConstructiveHeuristicInit(new NearestNeighborAlgorithm(), a);
		int[] randomConstructiveHeuristic = constructiveHeuristicInit.initPathAsArray(10);
		
		for (int i = 0; i < randomConstructiveHeuristic.length; i++) {
			System.out.println(randomConstructiveHeuristic[i]);
		}
		
		
		System.out.println("------------------------------------------------------------");
		
		
		
	}
	
}
