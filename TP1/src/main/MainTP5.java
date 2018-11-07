package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import glouton.exception.RandomTSPException;
import glouton.obj.RandomTSP;
import glouton.obj.services.RandomTSP.ReadFile;
import multi.obj.Point;
import multi.obj.services.eval.MultiEval;
import multi.obj.services.filter.OffLine;
import optimtsp.Agregat;
import utils.Method;

public class MainTP5 {
	
	public static void main(String[] args) {
//		try {
//			PrintStream o = new PrintStream(new File("MainTP4.txt"));
//			System.setOut(o);
//		} catch (FileNotFoundException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		
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
		
		System.out.println("------------------------------------------------------------");
		System.out.println("Question 1.1");
		System.out.println("------------------------------------------------------------");
		
		try {
			doScalar(path, a, 0.8f, 'A', b, 0.2f, 'B');
			doScalar(path, c, 0.8f, 'C', d, 0.2f, 'D');
			doScalar(path, e, 0.8f, 'E', f, 0.2f, 'F');
		} catch (RandomTSPException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	private static void doScalar(int[] path, RandomTSP a, float x, Character ca, RandomTSP b, float y, Character cb) throws RandomTSPException {
		List<Point> ps = new ArrayList<>();
		float ax = 0f;
		float by = 1f;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 500; j++) {
				Method.shuffleArray(path);
				ps.add(Agregat.agreg(path, ax, by, a, b));
			}
			ax = ax+0.1f;
			by = by-0.1f;
		}
		OffLine off = new OffLine();
		List<Point> rps = off.doStrategy(ps);

		// WRITE FILE
		System.out.println("Create file "+ca+cb+"ScalarPoints.txt");
		File r = new File(ca.toString()+cb.toString()+"ScalarPoints.txt");
		try {
			FileWriter fileWriter = new FileWriter(r);
			PrintWriter printWriter = new PrintWriter(fileWriter);
			printWriter.print("# "+ca+cb+"ScalarPoints.txt\n");
			printWriter.print("# x\ty\n");
			for (Point point : rps) {
				printWriter.print(point.getX()+"\t"+point.getY()+"\n");
			}
			printWriter.close();
			System.out.println("Exec gnuplot -c script.gnu "+ca+cb+"ScalarPoints");
			Runtime.getRuntime().exec("gnuplot -c script.gnu "+ca+cb+"ScalarPoints");
			System.out.println("Result available in "+ca+cb+"ScalarPoints.png");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
}
