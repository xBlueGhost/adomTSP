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
		File f1 = new File("randomA100.tsp");
		RandomTSP a = ReadFile.readFile(f1);
		File f2 = new File("randomB100.tsp");
		RandomTSP b = ReadFile.readFile(f2);
		try {
			Point p = MultiEval.Eval(path, a, b);
			System.out.println("RandomA/RandomB with random path.");
			System.out.println(p);
		} catch (RandomTSPException e) {
			e.printStackTrace();
		}
	}
	
}
