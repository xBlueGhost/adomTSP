package memetic.obj.services.crossing;

import java.util.ArrayList;
import java.util.List;

public class OrderBasedCrossover {

	public static int[] crossing(int index1, int index2, int[] p1, int[] p2) {

		if (p1.length != p2.length) {
			// TODO error
		}
		if (index1 >= index2) {
			// TODO error
		}
		if(index1 < 0 || index1 >= p1.length) {
			// TODO error
		}
		if(index2 < 0 || index2 >= p1.length) {
			// TODO error
		}
		
		int[] result = new int[p1.length];
		for (int i : result) {
			result[i] = -1;
		}

		List<Integer> segment = new ArrayList<>();

		for (int i = index1; i <= index2; i++) {
			segment.add(p1[i]);
		}

		int indexSegment = 0;
		for (int k = index1; k <= index2; k++) {
			result[k] = segment.get(indexSegment);
			indexSegment++;
		}
		
		int i = 0;
		int j = 0;
		while (i < p2.length) {
			if(!segment.contains(p2[i])){
				
			}
			i++;
		}

		return result;
	}

}
