package main;

import java.io.File;

import glouton.exception.RandomTSPException;
import glouton.obj.RandomTSP;
import glouton.obj.TSPResult;
import glouton.obj.services.RandomTSP.DisplayEdgeWeightSection;
import glouton.obj.services.RandomTSP.Evaluate;
import glouton.obj.services.RandomTSP.ReadFile;
import glouton.obj.services.constructHeuristic.NearestNeighborAlgorithm;
import hillclimbing.obj.services.HillClimbing;
import hillclimbing.obj.services.initialization.ConstructiveHeuristicInit;
import hillclimbing.obj.services.initialization.RandomPathInit;
import hillclimbing.obj.services.neighborhood.Swaping;
import hillclimbing.obj.services.neighborhood.TwoOpt;

public class MainTP2 {

	public static void main(String[] args) {
		File f = new File("randomA100.tsp");
		RandomTSP a = ReadFile.readFile(f);
		
		//HillClimbing hillClimbing = new HillClimbing(new RandomPathInit(), );
		
		
		System.out.println("------------------------------------------------------------");
		System.out.println("Question 2");
		
		int[] a1 = new int[] {0,1,2,3,4,5,6,7,8,9};
		int[] a2 = new int[] {9,8,7,6,5,4,3,2,1,0};
		
		
		
		int[] swaping = Swaping.swap(a1, 3, 8);
		int[] twoOpt = TwoOpt.twoOpt(a2, 2, 7);
		
		for (int i=0; i< swaping.length; i++) {
			System.out.println(swaping[i]);
		}
		
		System.out.println("------------------------------------------------------------");
		
		
		for (int i=0; i< twoOpt.length; i++) {
			System.out.println(twoOpt[i]);
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
		
	}
	
}
