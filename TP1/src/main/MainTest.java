package main;

import java.util.Arrays;

import memetic.obj.services.crossing.OrderBasedCrossover;

public class MainTest {

	public static void main(String[] args) {
		

		int[] p1 = {1,2,3,4,5,6,7,8};
		int[] p2 = {7,2,1,4,3,8,5,6};
		
		int[] result = OrderBasedCrossover.crossing(2,6, p1, p2);
		
		for (int i : result) {
			System.out.println(i);
		}
		
		System.out.println("Resultat : "+ Arrays.asList(result));
		
	}
	
}
