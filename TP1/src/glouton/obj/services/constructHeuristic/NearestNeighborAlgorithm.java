package glouton.obj.services.constructHeuristic;

import glouton.exception.ConstructiveHeuristicsAlgorithmException;
import glouton.obj.TSPResult;
import glouton.obj.RandomTSP;

/**
 * Algorithme du plus proche voisin.
 * 
 * @author dessenne
 *
 */

public class NearestNeighborAlgorithm implements ConstructiveHeuristicsAlgorithm {

	/*
	 * Question 3.1 : Développer l’heuristique constructive du plus proche voisin
	 * pour le TSP, en veillant à bien ranger dans des fichiers les solutions
	 * trouvées par vos programmes. Quel est la qualité de cette heuristique par
	 * rapport à une solution aléatoire ? Le choix de la ville initiale a-t-il un
	 * impact sur les résultats obtenus ?
	 */
	public TSPResult doAlgorithm(RandomTSP rTSP, int beginAt) throws ConstructiveHeuristicsAlgorithmException {
		if (beginAt > rTSP.getDimension() - 1) {
			throw new ConstructiveHeuristicsAlgorithmException("beginAt can't be superior to the RandomTSP dimension.");
		}
		int result = 0;
		int finalResult = 0;
		int tmpResult = 0;
		int current = beginAt;
		int tmpPath = -1;
		int indexPath = 1;
		int path[] = new int[rTSP.getDimension()];
		int cities[] = new int[rTSP.getDimension()];

		for (int i = 0; i < cities.length; i++) {
			cities[i] = i;
			path[i] = 0;
		}
		cities[beginAt] = -1;
		path[0] = beginAt;

		while (indexPath != rTSP.getDimension()) {
			for (int i = 0; i < cities.length; i++) {
				if (cities[i] != -1) {
					tmpResult = rTSP.getEdgeWeightSection()[current][cities[i]];
					if (tmpResult <= result || result == 0) {
						result = tmpResult;
						tmpPath = i;
					}
				}
			}
			cities[tmpPath] = -1;
			current = tmpPath;
			path[indexPath] = tmpPath;
			indexPath++;
			finalResult = finalResult + result;
			result = 0;
		}
		return new TSPResult(path, finalResult);
	}
}
