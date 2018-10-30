package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

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
import utils.Method;

public class MainTP2 {

	public static void main(String[] args) {
		try {
			PrintStream o = new PrintStream(new File("MainTP2.txt"));
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
		System.out.println("Question 2");

		// HILLCLIMBING randomA
		HillClimbing hcASwapFirst = new HillClimbing(new RandomPathInit(), new Swaping(), new FirstNeighborImproving(a),
				a);
		HillClimbing hcATwoOptFirst = new HillClimbing(new RandomPathInit(), new TwoOpt(),
				new FirstNeighborImproving(a), a);
		HillClimbing hcASwapBest = new HillClimbing(new RandomPathInit(), new Swaping(), new BestNeighborImproving(a),
				a);
		HillClimbing hcATwoOptBest = new HillClimbing(new RandomPathInit(), new TwoOpt(), new BestNeighborImproving(a),
				a);

		// HILLCLIMBING randomB
		HillClimbing hcBSwapFirst = new HillClimbing(new RandomPathInit(), new Swaping(), new FirstNeighborImproving(b),
				b);
		HillClimbing hcBTwoOptFirst = new HillClimbing(new RandomPathInit(), new TwoOpt(),
				new FirstNeighborImproving(b), b);
		HillClimbing hcBSwapBest = new HillClimbing(new RandomPathInit(), new Swaping(), new BestNeighborImproving(b),
				b);
		HillClimbing hcBTwoOptBest = new HillClimbing(new RandomPathInit(), new TwoOpt(), new BestNeighborImproving(b),
				b);

		// HILLCLIMBING randomC
		HillClimbing hcCSwapFirst = new HillClimbing(new RandomPathInit(), new Swaping(), new FirstNeighborImproving(c),
				c);
		HillClimbing hcCTwoOptFirst = new HillClimbing(new RandomPathInit(), new TwoOpt(),
				new FirstNeighborImproving(c), c);
		HillClimbing hcCSwapBest = new HillClimbing(new RandomPathInit(), new Swaping(), new BestNeighborImproving(c),
				c);
		HillClimbing hcCTwoOptBest = new HillClimbing(new RandomPathInit(), new TwoOpt(), new BestNeighborImproving(c),
				c);

		// HILLCLIMBING randomD
		HillClimbing hcDSwapFirst = new HillClimbing(new RandomPathInit(), new Swaping(), new FirstNeighborImproving(d),
				d);
		HillClimbing hcDTwoOptFirst = new HillClimbing(new RandomPathInit(), new TwoOpt(),
				new FirstNeighborImproving(d), d);
		HillClimbing hcDSwapBest = new HillClimbing(new RandomPathInit(), new Swaping(), new BestNeighborImproving(d),
				d);
		HillClimbing hcDTwoOptBest = new HillClimbing(new RandomPathInit(), new TwoOpt(), new BestNeighborImproving(d),
				d);

		// HILLCLIMBING randomE
		HillClimbing hcESwapFirst = new HillClimbing(new RandomPathInit(), new Swaping(), new FirstNeighborImproving(e),
				e);
		HillClimbing hcETwoOptFirst = new HillClimbing(new RandomPathInit(), new TwoOpt(),
				new FirstNeighborImproving(e), e);
		HillClimbing hcESwapBest = new HillClimbing(new RandomPathInit(), new Swaping(), new BestNeighborImproving(e),
				e);
		HillClimbing hcETwoOptBest = new HillClimbing(new RandomPathInit(), new TwoOpt(), new BestNeighborImproving(e),
				e);

		// HILLCLIMBING randomF
		HillClimbing hcFSwapFirst = new HillClimbing(new RandomPathInit(), new Swaping(), new FirstNeighborImproving(f),
				f);
		HillClimbing hcFTwoOptFirst = new HillClimbing(new RandomPathInit(), new TwoOpt(),
				new FirstNeighborImproving(f), f);
		HillClimbing hcFSwapBest = new HillClimbing(new RandomPathInit(), new Swaping(), new BestNeighborImproving(f),
				f);
		HillClimbing hcFTwoOptBest = new HillClimbing(new RandomPathInit(), new TwoOpt(), new BestNeighborImproving(f),
				f);

		int[] path = new int[100];
		for (int i = 0; i < path.length; i++) {
			path[i] = i;
		}
		Method.shuffleArray(path);

		System.out.println("------------------------------------------------------------");

		TSPResult res1A = hcASwapFirst.doAlgo(path);
		TSPResult res2A = hcATwoOptFirst.doAlgo(path);
		TSPResult res1B = hcBSwapFirst.doAlgo(path);
		TSPResult res2B = hcBTwoOptFirst.doAlgo(path);
		TSPResult res1C = hcCSwapFirst.doAlgo(path);
		TSPResult res2C = hcCTwoOptFirst.doAlgo(path);
		TSPResult res1D = hcDSwapFirst.doAlgo(path);
		TSPResult res2D = hcDTwoOptFirst.doAlgo(path);
		TSPResult res1E = hcESwapFirst.doAlgo(path);
		TSPResult res2E = hcETwoOptFirst.doAlgo(path);
		TSPResult res1F = hcFSwapFirst.doAlgo(path);
		TSPResult res2F = hcFTwoOptFirst.doAlgo(path);
		System.out.println("randomA100.tsp : ");
		System.out.println("- SWAP : " + res1A.getCost());
		System.out.println("- TWOOPT : " + res2A.getCost());
		System.out.println("randomB100.tsp : ");
		System.out.println("- SWAP : " + res1B.getCost());
		System.out.println("- TWOOPT : " + res2B.getCost());
		System.out.println("randomC100.tsp : ");
		System.out.println("- SWAP : " + res1C.getCost());
		System.out.println("- TWOOPT : " + res2C.getCost());
		System.out.println("randomD100.tsp : ");
		System.out.println("- SWAP : " + res1D.getCost());
		System.out.println("- TWOOPT : " + res2D.getCost());
		System.out.println("randomE100.tsp : ");
		System.out.println("- SWAP : " + res1E.getCost());
		System.out.println("- TWOOPT : " + res2E.getCost());
		System.out.println("randomF100.tsp : ");
		System.out.println("- SWAP : " + res1F.getCost());
		System.out.println("- TWOOPT : " + res2F.getCost());

		System.out.println("------------------------------------------------------------");
		System.out.println("Question 3");
		System.out.println("------------------------------------------------------------");

		HillClimbing hcASwapFirstCH = new HillClimbing(
				new ConstructiveHeuristicInit(new NearestNeighborAlgorithm(), a), new Swaping(),
				new FirstNeighborImproving(a), a);
		HillClimbing hcBSwapFirstCH = new HillClimbing(
				new ConstructiveHeuristicInit(new NearestNeighborAlgorithm(), b), new Swaping(),
				new FirstNeighborImproving(b), b);
		HillClimbing hcCSwapFirstCH = new HillClimbing(
				new ConstructiveHeuristicInit(new NearestNeighborAlgorithm(), c), new Swaping(),
				new FirstNeighborImproving(c), c);
		HillClimbing hcDSwapFirstCH = new HillClimbing(
				new ConstructiveHeuristicInit(new NearestNeighborAlgorithm(), d), new Swaping(),
				new FirstNeighborImproving(d), d);
		HillClimbing hcESwapFirstCH = new HillClimbing(
				new ConstructiveHeuristicInit(new NearestNeighborAlgorithm(), e), new Swaping(),
				new FirstNeighborImproving(e), e);
		HillClimbing hcFSwapFirstCH = new HillClimbing(
				new ConstructiveHeuristicInit(new NearestNeighborAlgorithm(), f), new Swaping(),
				new FirstNeighborImproving(f), f);
		TSPResult res3A = hcASwapFirstCH.doAlgo(50);
		TSPResult res3B = hcBSwapFirstCH.doAlgo(50);
		TSPResult res3C = hcCSwapFirstCH.doAlgo(50);
		TSPResult res3D = hcDSwapFirstCH.doAlgo(50);
		TSPResult res3E = hcESwapFirstCH.doAlgo(50);
		TSPResult res3F = hcFSwapFirstCH.doAlgo(50);
		System.out.println("randomA100.tsp : ");
		System.out.println("- RANDOM : "+ res1A.getCost());
		System.out.println("- CONSTRUCTIVE-HEURISTIC(50) : "+ res3A.getCost());
		System.out.println("randomB100.tsp : ");
		System.out.println("- RANDOM : "+ res1B.getCost());
		System.out.println("- CONSTRUCTIVE-HEURISTIC(50) : "+ res3B.getCost());
		System.out.println("randomC100.tsp : ");
		System.out.println("- RANDOM : "+ res1C.getCost());
		System.out.println("- CONSTRUCTIVE-HEURISTIC(50) : "+ res3C.getCost());
		System.out.println("randomD100.tsp : ");
		System.out.println("- RANDOM : "+ res1D.getCost());
		System.out.println("- CONSTRUCTIVE-HEURISTIC(50) : "+ res3D.getCost());
		System.out.println("randomE100.tsp : ");
		System.out.println("- RANDOM : "+ res1E.getCost());
		System.out.println("- CONSTRUCTIVE-HEURISTIC(50) : "+ res3E.getCost());
		System.out.println("randomF100.tsp : ");
		System.out.println("- RANDOM : "+ res1F.getCost());
		System.out.println("- CONSTRUCTIVE-HEURISTIC(50) : "+ res3F.getCost());
		
		System.out.println("------------------------------------------------------------");
		System.out.println("Question 4");
		System.out.println("------------------------------------------------------------");
		
		TSPResult res4A = hcATwoOptBest.doAlgo(path);
		TSPResult res4B = hcBTwoOptBest.doAlgo(path);
		TSPResult res4C = hcCTwoOptBest.doAlgo(path);
		TSPResult res4D = hcDTwoOptBest.doAlgo(path);
		TSPResult res4E = hcETwoOptBest.doAlgo(path);
		TSPResult res4F = hcFTwoOptBest.doAlgo(path);
		
		System.out.println("randomA100.tsp : ");
		System.out.println("- FIRST : "+ res2A.getCost());
		System.out.println("- BEST : "+ res4A.getCost());
		System.out.println("randomB100.tsp : ");
		System.out.println("- FIRST : "+ res2B.getCost());
		System.out.println("- BEST : "+ res4B.getCost());
		System.out.println("randomC100.tsp : ");
		System.out.println("- FIRST : "+ res2C.getCost());
		System.out.println("- BEST : "+ res4C.getCost());
		System.out.println("randomD100.tsp : ");
		System.out.println("- FIRST : "+ res2D.getCost());
		System.out.println("- BEST : "+ res4D.getCost());
		System.out.println("randomE100.tsp : ");
		System.out.println("- FIRST : "+ res2E.getCost());
		System.out.println("- BEST : "+ res4E.getCost());
		System.out.println("randomF100.tsp : ");
		System.out.println("- FIRST : "+ res2F.getCost());
		System.out.println("- BEST : "+ res4F.getCost());

	}

}
