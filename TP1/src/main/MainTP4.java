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
import multi.obj.services.filter.OnLine;
import utils.Method;

public class MainTP4 {

	public static void main(String[] args) {
		try {
			PrintStream o = new PrintStream(new File("MainTP4.txt"));
			System.setOut(o);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
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
			System.out.println("------------------------------------------------------------");
			System.out.println("Question 2.2");
			System.out.println("------------------------------------------------------------");
			Point pAB = MultiEval.Eval(path, a, b);
			System.out.println("RandomAB : " + pAB);
			Point pCD = MultiEval.Eval(path, c, d);
			System.out.println("RandomCD : " + pCD);
			Point pEF = MultiEval.Eval(path, e, f);
			System.out.println("RandomEF : " + pEF);

			System.out.println("------------------------------------------------------------");
			System.out.println("Question 3.1");
			System.out.println("------------------------------------------------------------");
			
			doOffline(path, a, 'A', b, 'B');
			doOffline(path, c, 'C', d, 'D');
			doOffline(path, e, 'E', f, 'F');
			
			long debut;
			debut = System.currentTimeMillis();
			doOnline(path, a, 'A', b, 'B',10000);
			System.out.println(System.currentTimeMillis()-debut);
			debut = System.currentTimeMillis();
			doOnline(path, c, 'C', d, 'D',100000);
			System.out.println(System.currentTimeMillis()-debut);
			debut = System.currentTimeMillis();
			doOnline(path, e, 'E', f, 'F',1000000);
			System.out.println(System.currentTimeMillis()-debut);

		} catch (RandomTSPException ex) {
			ex.printStackTrace();
		}
	}
	
	private static void doOffline(int[] path, RandomTSP a, Character ca, RandomTSP b, Character cb) throws RandomTSPException {
		List<Point> ps = new ArrayList<>();
		for (int i = 0; i < 500; i++) {
			Method.shuffleArray(path);
			ps.add(MultiEval.Eval(path, a, b));
		}
		OffLine off = new OffLine();
		List<Point> rps = off.doStrategy(ps);

		// WRITE FILE
		System.out.println("Create file "+ca+cb+"PointsOff.txt");
		File r = new File(ca.toString()+cb.toString()+"PointsOff.txt");
		try {
			FileWriter fileWriter = new FileWriter(r);
			PrintWriter printWriter = new PrintWriter(fileWriter);
			printWriter.print("# "+ca+cb+"PointsOff.txt\n");
			printWriter.print("# x\ty\n");
			for (Point point : rps) {
				printWriter.print(point.getX()+"\t"+point.getY()+"\n");
			}
			printWriter.close();
			System.out.println("Exec gnuplot -c script.gnu "+ca+cb+"PointsOff");
			Runtime.getRuntime().exec("gnuplot -c script.gnu "+ca+cb+"PointsOff");
			System.out.println("Result available in "+ca+cb+"PointsOff.png");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	private static void doOnline(int[] path, RandomTSP a, Character ca, RandomTSP b, Character cb, int nb) throws RandomTSPException {
		List<Point> ps = new ArrayList<>();
		for (int i = 0; i < nb; i++) {
			Method.shuffleArray(path);
			ps.add(MultiEval.Eval(path, a, b));
		}
		OnLine on = new OnLine();
		List<Point> rps = new ArrayList<>();
		for (Point point : ps) {
			rps = on.doStrategy(point);
		}

		// WRITE FILE
		System.out.println("Create file "+ca+cb+"PointsOn.txt");
		File r = new File(ca.toString()+cb.toString()+"PointsOn.txt");
		try {
			FileWriter fileWriter = new FileWriter(r);
			PrintWriter printWriter = new PrintWriter(fileWriter);
			printWriter.print("# "+ca+cb+"PointsOn.txt\n");
			printWriter.print("# x\ty\n");
			for (Point point : rps) {
				printWriter.print(point.getX()+"\t"+point.getY()+"\n");
			}
			printWriter.close();
			System.out.println("Exec gnuplot -c script.gnu "+ca+cb+"PointsOn");
			Runtime.getRuntime().exec("gnuplot -c script.gnu "+ca+cb+"PointsOn");
			System.out.println("Result available in "+ca+cb+"PointsOn.png");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
