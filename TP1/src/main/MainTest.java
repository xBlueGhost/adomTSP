package main;

import memetic.exception.CrossoverException;
import memetic.obj.services.crossover.OrderBasedCrossover;

public class MainTest {

	public static void main(String[] args) {

		int[] p1 = { 1, 2, 3, 4, 5, 6, 7, 8 };
		int[] p2 = { 7, 2, 1, 4, 3, 8, 5, 6 };

		int[] result;
		try {
			result = new OrderBasedCrossover().doCrossover(2, 6, p1, p2);

			for (int i : result) {
				System.out.println(i);
			}
		} catch (CrossoverException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
