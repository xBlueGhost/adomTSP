package main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import glouton.exception.RandomTSPException;
import glouton.obj.RandomTSP;
import glouton.obj.services.RandomTSP.ReadFile;
import multi.obj.Point;
import optimtsp.obj.services.approach.ScalarApproach;

public class MainTP5 {
	
	public static void main(String[] args) {
//		try {
//			PrintStream o = new PrintStream(new File("MainTP5.txt"));
//			System.setOut(o);
//		} catch (FileNotFoundException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		
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
			doScalar(a, 'A', b, 'B');
			doScalar(c, 'C', d, 'D');
			doScalar(e, 'E', f, 'F');
		} catch (RandomTSPException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	private static void doScalar(RandomTSP a, Character ca, RandomTSP b, Character cb) throws RandomTSPException {

		List<Point> rps = ScalarApproach.doApproach(a, b);

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
