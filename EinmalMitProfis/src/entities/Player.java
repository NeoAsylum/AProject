package entities;

import java.awt.Polygon;

public class Player implements Person {
	private int xcoord;
	private int ycoord;
	private int xspeed;
	private int yspeed;
	private Polygon polygon;

	public Player() {
		xcoord = 0;
		ycoord = 0;
		xspeed = 1;
		yspeed = 1;
		polygon = new Polygon();
		polygon.addPoint(xcoord, ycoord);
		polygon.addPoint(xcoord + 15, ycoord);
		polygon.addPoint(xcoord + 15, ycoord + 30);
		polygon.addPoint(xcoord, ycoord + 30);
	}

	@Override
	public int getXSpeed() {

		return xspeed;
	}

	@Override
	public int getYSpeed() {

		return yspeed;
	}

	@Override
	public int getXCoord() {

		return xcoord;
	}

	@Override
	public int getYCoord() {

		return ycoord;
	}

	public void move(boolean a, boolean s, boolean d, boolean w) {
		if (a) {
			xcoord -= xspeed;
			polygon.translate(-xspeed, 0);
		}
		if (d) {
			xcoord += xspeed;
			polygon.translate(xspeed, 0);

		}
		if (w) {
			ycoord -= yspeed;
			polygon.translate(0, -yspeed);

		}
		if (s) {
			polygon.translate(0, yspeed);

			ycoord += yspeed;
		}
	}

	public Polygon getPolygon() {
		return polygon;
	}
}
