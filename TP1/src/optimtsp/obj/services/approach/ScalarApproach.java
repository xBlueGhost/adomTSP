package optimtsp.obj.services.approach;

import java.util.ArrayList;
import java.util.List;

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
import multi.obj.Point;
import multi.obj.services.filter.OffLine;

public class ScalarApproach {

	public static List<Point> doApproach(RandomTSP a, RandomTSP b) throws RandomTSPException {
		List<Point> ps = new ArrayList<>();
		float ax = 0f;
		float by = 1f;
		for (int i = 0; i < 100; i++) {
			RandomTSP m = agregTSP(ax, by, a, b);
			PopulationInitialization piA = new ConstructiveHeuristicPopulation(
					new ConstructiveHeuristicInit(new NearestNeighborAlgorithm(), m));
			OrderBasedCrossover obc = new OrderBasedCrossover();
			HillClimbing hcASwapFirstCH = new HillClimbing(
					new ConstructiveHeuristicInit(new NearestNeighborAlgorithm(), m), new Swaping(),
					new FirstNeighborImproving(m), m);
			MemeticAlgorithm maA = new MemeticAlgorithm(piA, obc, m, hcASwapFirstCH);
			TSPResult result = maA.doAlgo(100);
				ps.add(new Point(Evaluate.eval(a, result.getPath()), Evaluate.eval(b, result.getPath())));
			ax = ax+0.01f;
			by = by-0.01f;
		}
		OffLine off = new OffLine();
		return off.doStrategy(ps);
	}
	
	private static RandomTSP agregTSP(float x, float y, RandomTSP a, RandomTSP b) {
		int[][] agregat = new int[a.getDimension()][b.getDimension()];
		for (int i = 0; i < agregat.length; i++) {
			for (int j = 0; j < agregat.length; j++) {
				agregat[i][j] = (int) (a.getEdgeWeightSection()[i][j]*x + b.getEdgeWeightSection()[i][j]*y);
			}
		}
		RandomTSP m = new RandomTSP("", "", 100, 100, "", 100, "", "");
		m.setEdgeWeightSection(agregat);
		return m;
	}
	
}
