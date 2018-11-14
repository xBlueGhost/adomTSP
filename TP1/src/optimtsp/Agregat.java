package optimtsp;

import glouton.exception.RandomTSPException;
import glouton.obj.RandomTSP;
import glouton.obj.TSPResult;
import glouton.obj.services.RandomTSP.Evaluate;
import glouton.obj.services.constructHeuristic.NearestNeighborAlgorithm;
import hillclimbing.obj.services.HillClimbing;
import hillclimbing.obj.services.initialization.ConstructiveHeuristicInit;
import hillclimbing.obj.services.movement.FirstNeighborImproving;
import hillclimbing.obj.services.neighborhood.Swaping;
import memetic.obj.services.MemeticAlgorithm;
import memetic.obj.services.crossover.OrderBasedCrossover;
import memetic.obj.services.populationInit.ConstructiveHeuristicPopulation;
import memetic.obj.services.populationInit.PopulationInitialization;
import multi.obj.MultiTSP;
import multi.obj.Point;

public class Agregat {

	public static Point agreg(RandomTSP a, RandomTSP b, MultiTSP c) throws RandomTSPException {
		PopulationInitialization piA = new ConstructiveHeuristicPopulation(
				new ConstructiveHeuristicInit(new NearestNeighborAlgorithm(), a));
		OrderBasedCrossover obc = new OrderBasedCrossover();
		HillClimbing hcASwapFirstCH = new HillClimbing(
				new ConstructiveHeuristicInit(new NearestNeighborAlgorithm(), a), new Swaping(),
				new FirstNeighborImproving(a), a);
		MemeticAlgorithm maA = new MemeticAlgorithm(piA, obc, a, hcASwapFirstCH);
		TSPResult result = maA.doAlgo(100);
		return new Point(Evaluate.eval(a, result.getPath()), Evaluate.eval(b, result.getPath()));
	}
	
	public static MultiTSP agregTSP(float x, float y, RandomTSP a, RandomTSP b) {
		float[][] agregat = new float[a.getDimension()][b.getDimension()];
		for (int i = 0; i < agregat.length; i++) {
			for (int j = 0; j < agregat.length; j++) {
				agregat[i][j] = a.getEdgeWeightSection()[i][j]*x + b.getEdgeWeightSection()[i][j]*y;
			}
		}
		return new MultiTSP(a.getFileName()+b.getFileName(), a.getDimension(), agregat);
	}
	
}
