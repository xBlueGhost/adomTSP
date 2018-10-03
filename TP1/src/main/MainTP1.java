package main;

import java.io.File;
import java.util.Arrays;

import glouton.exception.ConstructiveHeuristicsAlgorithmException;
import glouton.exception.RandomTSPException;
import glouton.obj.RandomTSP;
import glouton.obj.TSPResult;
import glouton.obj.services.RandomTSP.DisplayEdgeWeightSection;
import glouton.obj.services.RandomTSP.Evaluate;
import utils.Method;
import glouton.obj.services.RandomTSP.ReadFile;
import glouton.obj.services.constructHeuristic.NearestNeighborAlgorithm;

public class MainTP1 {

	/**
	 * Best result <br>
	 * randomA100 = 10659 <br>
	 * randomB100 = 9234 <br>
	 * randomC100 = 9529 <br>
	 * randomD100 = 9108 <br>
	 * randomE100 = 8899 <br>
	 * randomF100 = 8989
	 */
	public static void main(String[] args) {
		File f = new File("randomA100.tsp");
		System.out.println("------------------------------------------------------------");
		System.out.println("Question 2.1");
		RandomTSP a = ReadFile.readFile(f);
		DisplayEdgeWeightSection.displayEdgeWeightSection(a);
		System.out.println("------------------------------------------------------------");
		int[] a1 = new int[] {0,1,2,3,4,5,6,7,8,9};
		int[] a2 = new int[] {9,8,7,6,5,4,3,2,1,0};

		System.out.println("------------------------------------------------------------");
		System.out.println("Question 2.2");
		try {
			System.out.println("Evaluation a1 = " + Evaluate.eval(a, a1));
			System.out.println("Evaluation a2 = " + Evaluate.eval(a, a2));
		} catch (RandomTSPException e) {
			e.printStackTrace();
		}
		System.out.println("------------------------------------------------------------");

		System.out.println("------------------------------------------------------------");
		System.out.println("Question 2.3");
		System.out.println("Best result for randomA100 is 10659.");
		try {
			System.out.println("Random evaluation 1 randomA100 = " + Evaluate.randomEval(a));
			System.out.println("Random evaluation 2 randomA100 = " + Evaluate.randomEval(a));
			System.out.println("Random evaluation 3 randomA100 = " + Evaluate.randomEval(a));
		} catch (RandomTSPException e) {
			e.printStackTrace();
		}
		System.out.println("------------------------------------------------------------");

		System.out.println("------------------------------------------------------------");
		System.out.println("Question 3.1");
		NearestNeighborAlgorithm nna = new NearestNeighborAlgorithm();
		try {
			TSPResult res1 = nna.doAlgorithm(a, 0);
			System.out.println("NearestNeighborAlgo file:randomA100.tsp beginAt:0");
			System.out.println("Path = " + Arrays.toString(res1.getPath()));
			System.out.println("Cost = " + res1.getCost());
			TSPResult res2 = nna.doAlgorithm(a, 10);
			System.out.println("NearestNeighborAlgo file:randomA100.tsp beginAt:10");
			System.out.println("Path = " + Arrays.toString(res2.getPath()));
			System.out.println("Cost = " + res2.getCost());
			TSPResult res3 = nna.doAlgorithm(a, 50);
			System.out.println("NearestNeighborAlgo file:randomA100.tsp beginAt:50");
			System.out.println("Path = " + Arrays.toString(res3.getPath()));
			System.out.println("Cost = " + res3.getCost());
			TSPResult res4 = nna.doAlgorithm(a, 75);
			System.out.println("NearestNeighborAlgo file:randomA100.tsp beginAt:75");
			System.out.println("Path = " + Arrays.toString(res4.getPath()));
			System.out.println("Cost = " + res4.getCost());
			int rand = Method.getRandomNumberInRange(0, 99);
			TSPResult res5 = nna.doAlgorithm(a, rand);
			System.out.println("NearestNeighborAlgo file:randomA100.tsp beginAt:" + rand);
			System.out.println("Path = " + Arrays.toString(res5.getPath()));
			System.out.println("Cost = " + res5.getCost());
		} catch (ConstructiveHeuristicsAlgorithmException e) {
			e.printStackTrace();
		}

		System.out.println("------------------------------------------------------------");
		
		System.out.println("Question TD2 - 2");

		
	}

}
