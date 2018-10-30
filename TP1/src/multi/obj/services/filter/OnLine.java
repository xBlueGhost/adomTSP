package multi.obj.services.filter;

import java.util.ArrayList;
import java.util.List;

import multi.obj.Point;

public class OnLine {

	private List<Point> archive;

	public OnLine() {
		super();
		this.archive = new ArrayList<>();
	}

	public List<Point> doStrategy(Point in) {
		ArrayList<Point> toRemove = new ArrayList<Point>();
		boolean toAdd;

		toAdd = false;

		for (Point best : archive) {

			// Dominance
			if (in.getX() <= best.getX() && in.getY() <= best.getY()) {
				toRemove.add(best);
				toAdd = true;
			}

			// est Dominé
			if (in.getX() >= best.getX() && in.getY() >= best.getY()) {
				toAdd = false;
				break;
			}

			// Dominant sur un seul critère
			if (in.getX() < best.getX() || in.getY() < best.getY()) {
				toAdd = true;
			}
		}

		archive.removeAll(toRemove);

		if (archive.isEmpty() || toAdd) {
			archive.add(in);
		}

		return archive;
	}

}
