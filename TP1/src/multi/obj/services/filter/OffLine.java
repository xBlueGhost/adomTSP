package multi.obj.services.filter;

import java.util.ArrayList;
import java.util.List;

import multi.obj.Point;

public class OffLine {

	public List<Point> doStrategy(List<Point> in) {
		ArrayList<Point> front = new ArrayList<Point>();
		ArrayList<Point> toRemove = new ArrayList<Point>();
		boolean toAdd;
		
		for (Point p : in) {
			
			toAdd = false;
			
			for (Point best : front) {				
				
				//Dominance
				if (p.getX() <= best.getX() && p.getY() <= best.getY()) {
					toRemove.add(best);
					toAdd = true;
				} 
				
				//est Dominé
				if (p.getX() >= best.getX() && p.getY() >= best.getY()) {
					toAdd = false;
					break;
				} 
				
				//Dominant sur un seul critère
				if(p.getX() < best.getX() || p.getY() < best.getY()) {
						toAdd = true;
				}
			}
			
			front.removeAll(toRemove);
			toRemove = new ArrayList<Point>();
			
			if (front.isEmpty() || toAdd) {
				front.add(p);
			}
		}
		
		return front;
	}

}
