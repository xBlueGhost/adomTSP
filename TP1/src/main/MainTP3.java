package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import glouton.exception.RandomTSPException;
import glouton.obj.RandomTSP;
import glouton.obj.TSPResult;
import glouton.obj.services.RandomTSP.ReadFile;
import glouton.obj.services.constructHeuristic.NearestNeighborAlgorithm;
import hillclimbing.obj.services.HillClimbing;
import hillclimbing.obj.services.initialization.ConstructiveHeuristicInit;
import hillclimbing.obj.services.movement.FirstNeighborImproving;
import hillclimbing.obj.services.neighborhood.Swaping;
import memetic.obj.services.BasicAlgorithm;
import memetic.obj.services.MemeticAlgorithm;
import memetic.obj.services.crossover.OrderBasedCrossover;
import memetic.obj.services.populationInit.ConstructiveHeuristicPopulation;
import memetic.obj.services.populationInit.PopulationInitialization;
import memetic.obj.services.populationInit.RandomPopulation;

public class MainTP3 {

	public static void main(String[] args) {
		try {
			PrintStream o = new PrintStream(new File("MainTP3.txt"));
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

		PopulationInitialization piR = new RandomPopulation();
		PopulationInitialization piA = new ConstructiveHeuristicPopulation(
				new ConstructiveHeuristicInit(new NearestNeighborAlgorithm(), a));
		PopulationInitialization piB = new ConstructiveHeuristicPopulation(
				new ConstructiveHeuristicInit(new NearestNeighborAlgorithm(), b));
		PopulationInitialization piC = new ConstructiveHeuristicPopulation(
				new ConstructiveHeuristicInit(new NearestNeighborAlgorithm(), c));
		PopulationInitialization piD = new ConstructiveHeuristicPopulation(
				new ConstructiveHeuristicInit(new NearestNeighborAlgorithm(), d));
		PopulationInitialization piE = new ConstructiveHeuristicPopulation(
				new ConstructiveHeuristicInit(new NearestNeighborAlgorithm(), e));
		PopulationInitialization piF = new ConstructiveHeuristicPopulation(
				new ConstructiveHeuristicInit(new NearestNeighborAlgorithm(), f));

		OrderBasedCrossover obc = new OrderBasedCrossover();
		BasicAlgorithm baAr = new BasicAlgorithm(piR, obc, a);
		BasicAlgorithm baAch = new BasicAlgorithm(piA, obc, a);
		BasicAlgorithm baBr = new BasicAlgorithm(piR, obc, b);
		BasicAlgorithm baBch = new BasicAlgorithm(piB, obc, b);
		BasicAlgorithm baCr = new BasicAlgorithm(piR, obc, c);
		BasicAlgorithm baCch = new BasicAlgorithm(piC, obc, c);
		BasicAlgorithm baDr = new BasicAlgorithm(piR, obc, d);
		BasicAlgorithm baDch = new BasicAlgorithm(piD, obc, d);
		BasicAlgorithm baEr = new BasicAlgorithm(piR, obc, e);
		BasicAlgorithm baEch = new BasicAlgorithm(piE, obc, e);
		BasicAlgorithm baFr = new BasicAlgorithm(piR, obc, f);
		BasicAlgorithm baFch = new BasicAlgorithm(piF, obc, f);

		System.out.println("------------------------------------------------------------");
		System.out.println("Question 2");
		System.out.println("------------------------------------------------------------");

		try {
			System.out.println("randomA100.tsp : ");
			TSPResult rA1 = baAr.doAlgo(100);
			System.out.println("- RANDOM_POPULATION : " + rA1.getCost());
			TSPResult rA2 = baAch.doAlgo(100);
			System.out.println("- CONSTRUCTIVEHEURISTIC_POPULATION : " + rA2.getCost());
			
			System.out.println("randomB100.tsp : ");
			TSPResult rB1 = baBr.doAlgo(100);
			System.out.println("- RANDOM_POPULATION : " + rB1.getCost());
			TSPResult rB2 = baBch.doAlgo(100);
			System.out.println("- CONSTRUCTIVEHEURISTIC_POPULATION : " + rB2.getCost());
			
			System.out.println("randomC100.tsp : ");
			TSPResult rC1 = baCr.doAlgo(100);
			System.out.println("- RANDOM_POPULATION : " + rC1.getCost());
			TSPResult rC2 = baCch.doAlgo(100);
			System.out.println("- CONSTRUCTIVEHEURISTIC_POPULATION : " + rC2.getCost());
			
			System.out.println("randomD100.tsp : ");
			TSPResult rD1 = baDr.doAlgo(100);
			System.out.println("- RANDOM_POPULATION : " + rD1.getCost());
			TSPResult rD2 = baDch.doAlgo(100);
			System.out.println("- CONSTRUCTIVEHEURISTIC_POPULATION : " + rD2.getCost());
			
			System.out.println("randomE100.tsp : ");
			TSPResult rE1 = baEr.doAlgo(100);
			System.out.println("- RANDOM_POPULATION : " + rE1.getCost());
			TSPResult rE2 = baEch.doAlgo(100);
			System.out.println("- CONSTRUCTIVEHEURISTIC_POPULATION : " + rE2.getCost());
			
			System.out.println("randomF100.tsp : ");
			TSPResult rF1 = baFr.doAlgo(100);
			System.out.println("- RANDOM_POPULATION : " + rF1.getCost());
			TSPResult rF2 = baFch.doAlgo(100);
			System.out.println("- CONSTRUCTIVEHEURISTIC_POPULATION : " + rF2.getCost());
		} catch (RandomTSPException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		
		System.out.println("------------------------------------------------------------");
		System.out.println("Question 3");
		System.out.println("------------------------------------------------------------");
		try {
			cross(5, 10, a, baAch, obc);
			cross(20, 30, a, baAch, obc);
			cross(30, 55, a, baAch, obc);
			cross(25, 75, a, baAch, obc);
			cross(0, 99, a, baAch, obc);
			
			cross(5, 10, b, baBch, obc);
			cross(20, 30, b, baBch, obc);
			cross(30, 55, b, baBch, obc);
			cross(25, 75, b, baBch, obc);
			cross(0, 99, b, baBch, obc);
			
			cross(5, 10, c, baCch, obc);
			cross(20, 30, c, baCch, obc);
			cross(30, 55, c, baCch, obc);
			cross(25, 75, c, baCch, obc);
			cross(0, 99, c, baCch, obc);
			
			cross(5, 10, d, baDch, obc);
			cross(20, 30, d, baDch, obc);
			cross(30, 55, d, baDch, obc);
			cross(25, 75, d, baDch, obc);
			cross(0, 99, d, baDch, obc);
			
			cross(5, 10, e, baEch, obc);
			cross(20, 30, e, baEch, obc);
			cross(30, 55, e, baEch, obc);
			cross(25, 75, e, baEch, obc);
			cross(0, 99, e, baEch, obc);
			
			cross(5, 10, f, baFch, obc);
			cross(20, 30, f, baFch, obc);
			cross(30, 55, f, baFch, obc);
			cross(25, 75, f, baFch, obc);
			cross(0, 99, f, baFch, obc);
		} catch (RandomTSPException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		System.out.println("------------------------------------------------------------");
		System.out.println("Question 5");
		System.out.println("------------------------------------------------------------");
		
		obc.setIndex1(20);
		obc.setIndex2(30);
		
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
		
		MemeticAlgorithm maA = new MemeticAlgorithm(piA, obc, a, hcASwapFirstCH);
		MemeticAlgorithm maB = new MemeticAlgorithm(piB, obc, b, hcBSwapFirstCH);
		MemeticAlgorithm maC = new MemeticAlgorithm(piC, obc, c, hcCSwapFirstCH);
		MemeticAlgorithm maD = new MemeticAlgorithm(piD, obc, d, hcDSwapFirstCH);
		MemeticAlgorithm maE = new MemeticAlgorithm(piE, obc, e, hcESwapFirstCH);
		MemeticAlgorithm maF = new MemeticAlgorithm(piF, obc, f, hcFSwapFirstCH);
		
		
		try {
			System.out.println("randomA100.tsp : ");
			TSPResult rmA1 = maA.doAlgo(100);
			System.out.println("- MEMETIC : " + rmA1.getCost());
			System.out.println("randomB100.tsp : ");
			TSPResult rmB1 = maB.doAlgo(100);
			System.out.println("- MEMETIC : " + rmB1.getCost());
			System.out.println("randomC100.tsp : ");
			TSPResult rmC1 = maC.doAlgo(100);
			System.out.println("- MEMETIC : " + rmC1.getCost());
			System.out.println("randomD100.tsp : ");
			TSPResult rmD1 = maD.doAlgo(100);
			System.out.println("- MEMETIC : " + rmD1.getCost());
			System.out.println("randomE100.tsp : ");
			TSPResult rmE1 = maE.doAlgo(100);
			System.out.println("- MEMETIC : " + rmE1.getCost());
			System.out.println("randomF100.tsp : ");
			TSPResult rmF1 = maF.doAlgo(100);
			System.out.println("- MEMETIC : " + rmF1.getCost());
		} catch (RandomTSPException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}

	private static void cross(int index1, int index2, RandomTSP tsp, BasicAlgorithm ba, OrderBasedCrossover obc) throws RandomTSPException {
		obc.setIndex1(index1);
		obc.setIndex2(index2);
		System.out.println(tsp.getFileName()+" : ");
		TSPResult r = ba.doAlgo(100);
		System.out.println("- CROSSOVER "+index1+"-"+index2+" : " + r.getCost());
	}
}
