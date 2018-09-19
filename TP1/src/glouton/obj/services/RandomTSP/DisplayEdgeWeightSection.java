package glouton.obj.services.RandomTSP;

import glouton.obj.RandomTSP;

public class DisplayEdgeWeightSection {

	public static void displayEdgeWeightSection(RandomTSP rstp) {
		for (int i = 0; i < rstp.getEdgeWeightSection().length; i++) {
			for (int j = 0; j < rstp.getEdgeWeightSection().length; j++) {
				try {
					System.out.print(rstp.getEdgeWeightSection()[i][j] + "\t");
				} catch (NullPointerException e) {
					System.out.print("X\t");
				}

			}
			System.out.println();
		}
	}
}
