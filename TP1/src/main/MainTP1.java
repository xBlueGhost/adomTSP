package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
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
		try {
			PrintStream o = new PrintStream(new File("MainTP1.txt"));
			System.setOut(o); 
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		
		// GET FILE TSP
		File fa = new File("randomA100.tsp");
		File fb = new File("randomB100.tsp");
		File fc = new File("randomC100.tsp");
		File fd = new File("randomD100.tsp");
		File fe = new File("randomE100.tsp");
		File ff = new File("randomF100.tsp");
		
		RandomTSP a = ReadFile.readFile(fa);
		RandomTSP b = ReadFile.readFile(fb);
		RandomTSP c = ReadFile.readFile(fc);
		RandomTSP d = ReadFile.readFile(fd);
		RandomTSP e = ReadFile.readFile(fe);
		RandomTSP f = ReadFile.readFile(ff);
		
		System.out.println("------------------------------------------------------------");
		System.out.println("Question 2.1");
		System.out.println("------------------------------------------------------------");
		System.out.println("Matrice randomA100.tsp");
		DisplayEdgeWeightSection.displayEdgeWeightSection(a);
		System.out.println("Matrice randomB100.tsp");
		DisplayEdgeWeightSection.displayEdgeWeightSection(b);
		System.out.println("Matrice randomC100.tsp");
		DisplayEdgeWeightSection.displayEdgeWeightSection(c);
		System.out.println("Matrice randomD100.tsp");
		DisplayEdgeWeightSection.displayEdgeWeightSection(d);
		System.out.println("Matrice randomE100.tsp");
		DisplayEdgeWeightSection.displayEdgeWeightSection(e);
		System.out.println("Matrice randomF100.tsp");
		DisplayEdgeWeightSection.displayEdgeWeightSection(f);
		System.out.println("------------------------------------------------------------");
		int[] path1 = new int[] {0,1,2,3,4,5,6,7,8,9};
		int[] path2 = new int[] {9,8,7,6,5,4,3,2,1,0};

		System.out.println("------------------------------------------------------------");
		System.out.println("Question 2.2");
		System.out.println("------------------------------------------------------------");
		try {
			System.out.println("Evaluation A-path1 = " + Evaluate.eval(a, path1));
			System.out.println("Evaluation A-path2 = " + Evaluate.eval(a, path2));
			System.out.println("Evaluation B-path1 = " + Evaluate.eval(b, path1));
			System.out.println("Evaluation B-path2 = " + Evaluate.eval(b, path2));
			System.out.println("Evaluation C-path1 = " + Evaluate.eval(c, path1));
			System.out.println("Evaluation C-path2 = " + Evaluate.eval(c, path2));
			System.out.println("Evaluation D-path1 = " + Evaluate.eval(d, path1));
			System.out.println("Evaluation D-path2 = " + Evaluate.eval(d, path2));
			System.out.println("Evaluation E-path1 = " + Evaluate.eval(e, path1));
			System.out.println("Evaluation E-path2 = " + Evaluate.eval(e, path2));
			System.out.println("Evaluation F-path1 = " + Evaluate.eval(f, path1));
			System.out.println("Evaluation F-path2 = " + Evaluate.eval(f, path2));
		} catch (RandomTSPException ex) {
			ex.printStackTrace();
		}
		System.out.println("------------------------------------------------------------");

		System.out.println("------------------------------------------------------------");
		System.out.println("Question 2.3");
		System.out.println("------------------------------------------------------------");
		System.out.println("Best result for randomA100 is 10659.");
		System.out.println("Best result for randomB100 is 9234.");
		System.out.println("Best result for randomC100 is 9529.");
		System.out.println("Best result for randomD100 is 9108.");
		System.out.println("Best result for randomE100 is 8899.");
		System.out.println("Best result for randomF100 is 8989.");
		try {
			System.out.println("Random evaluation 1 randomA100 = " + Evaluate.randomEval(a));
			System.out.println("Random evaluation 2 randomA100 = " + Evaluate.randomEval(a));
			System.out.println("Random evaluation 3 randomA100 = " + Evaluate.randomEval(a));
			System.out.println("Random evaluation 1 randomB100 = " + Evaluate.randomEval(b));
			System.out.println("Random evaluation 2 randomB100 = " + Evaluate.randomEval(b));
			System.out.println("Random evaluation 3 randomB100 = " + Evaluate.randomEval(b));
			System.out.println("Random evaluation 1 randomC100 = " + Evaluate.randomEval(c));
			System.out.println("Random evaluation 2 randomC100 = " + Evaluate.randomEval(c));
			System.out.println("Random evaluation 3 randomC100 = " + Evaluate.randomEval(c));
			System.out.println("Random evaluation 1 randomD100 = " + Evaluate.randomEval(d));
			System.out.println("Random evaluation 2 randomD100 = " + Evaluate.randomEval(d));
			System.out.println("Random evaluation 3 randomD100 = " + Evaluate.randomEval(d));
			System.out.println("Random evaluation 1 randomE100 = " + Evaluate.randomEval(e));
			System.out.println("Random evaluation 2 randomE100 = " + Evaluate.randomEval(e));
			System.out.println("Random evaluation 3 randomE100 = " + Evaluate.randomEval(e));
			System.out.println("Random evaluation 1 randomF100 = " + Evaluate.randomEval(f));
			System.out.println("Random evaluation 2 randomF100 = " + Evaluate.randomEval(f));
			System.out.println("Random evaluation 3 randomF100 = " + Evaluate.randomEval(f));
		} catch (RandomTSPException ex) {
			ex.printStackTrace();
		}
		System.out.println("------------------------------------------------------------");

		System.out.println("------------------------------------------------------------");
		System.out.println("Question 3.1");
		NearestNeighborAlgorithm nna = new NearestNeighborAlgorithm();
		try {
			int rand = Method.getRandomNumberInRange(0, 99);
			nna(nna, a, rand);
			nna(nna, b, rand);
			nna(nna, c, rand);
			nna(nna, d, rand);
			nna(nna, e, rand);
			nna(nna, f, rand);
			
		} catch (ConstructiveHeuristicsAlgorithmException ex) {
			ex.printStackTrace();
		}

		System.out.println("------------------------------------------------------------");
	}

	private static void nna(NearestNeighborAlgorithm nna, RandomTSP rt, int rand) throws ConstructiveHeuristicsAlgorithmException {
		TSPResult res1 = nna.doAlgorithm(rt, 0);
		System.out.println("NearestNeighborAlgo file:"+rt.getFileName()+" beginAt:0");
		System.out.println("Path = " + Arrays.toString(res1.getPath()));
		System.out.println("Cost = " + res1.getCost());
		TSPResult res2 = nna.doAlgorithm(rt, 10);
		System.out.println("NearestNeighborAlgo file:"+rt.getFileName()+" beginAt:10");
		System.out.println("Path = " + Arrays.toString(res2.getPath()));
		System.out.println("Cost = " + res2.getCost());
		TSPResult res3 = nna.doAlgorithm(rt, 50);
		System.out.println("NearestNeighborAlgo file:"+rt.getFileName()+" beginAt:50");
		System.out.println("Path = " + Arrays.toString(res3.getPath()));
		System.out.println("Cost = " + res3.getCost());
		TSPResult res4 = nna.doAlgorithm(rt, 75);
		System.out.println("NearestNeighborAlgo file:"+rt.getFileName()+" beginAt:75");
		System.out.println("Path = " + Arrays.toString(res4.getPath()));
		System.out.println("Cost = " + res4.getCost());
		TSPResult res5 = nna.doAlgorithm(rt, rand);
		System.out.println("NearestNeighborAlgo file:"+rt.getFileName()+" beginAt:" + rand);
		System.out.println("Path = " + Arrays.toString(res5.getPath()));
		System.out.println("Cost = " + res5.getCost());
	}
	
}
