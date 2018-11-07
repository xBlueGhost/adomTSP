package optimtsp;

import glouton.exception.RandomTSPException;
import glouton.obj.RandomTSP;
import glouton.obj.services.RandomTSP.Evaluate;
import multi.obj.MultiTSP;
import multi.obj.Point;

public class Agregat {

	public static Point agreg(int[] path, float x, float y, RandomTSP a, RandomTSP b) throws RandomTSPException {
		return new Point(Evaluate.eval(a, path)*x, Evaluate.eval(b, path)*y);
	}
	
	public MultiTSP agregTSP(float x, float y, RandomTSP a, RandomTSP b) {
		float[][] agregat = new float[a.getDimension()][b.getDimension()];
		for (int i = 0; i < agregat.length; i++) {
			for (int j = 0; j < agregat.length; j++) {
				agregat[i][j] = a.getEdgeWeightSection()[i][j]*x + b.getEdgeWeightSection()[i][j]*y;
			}
		}
		return new MultiTSP(a.getFileName()+b.getFileName(), a.getDimension(), agregat);
	}
	
}
