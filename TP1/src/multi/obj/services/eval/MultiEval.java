package multi.obj.services.eval;

import glouton.exception.RandomTSPException;
import glouton.obj.RandomTSP;
import glouton.obj.services.RandomTSP.Evaluate;
import multi.obj.Point;

public class MultiEval {

	public static Point Eval(int[] path, RandomTSP a, RandomTSP b) throws RandomTSPException {
		return new Point(Evaluate.eval(a, path), Evaluate.eval(b, path));
	}
	
}
