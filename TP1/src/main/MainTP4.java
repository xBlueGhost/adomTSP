package main;

import java.io.File;

import glouton.exception.RandomTSPException;
import glouton.obj.RandomTSP;
import glouton.obj.services.RandomTSP.ReadFile;
import multi.obj.Point;
import multi.obj.services.eval.MultiEval;
import utils.Method;

public class MainTP4 {

	public static void main(String[] args) {
		int[] path = new int[100];
		for (int i = 0; i < path.length; i++) {
			path[i] = i;
		}
		Method.shuffleArray(path);
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
		try {
			Point p = MultiEval.Eval(path, a, b);
			System.out.println("RandomA/RandomB with random path.");
			System.out.println(p);
		} catch (RandomTSPException ex) {
			ex.printStackTrace();
		}
	}

}
