package entities;

import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

public class Player implements Person {
	private int xcoord;
	private int ycoord;
	private double xspeed;
	private double yspeed;
	private int height;
	private int width;
	private boolean jumped = true;
	private Rectangle2D rectangle;

	public Player() {
		xcoord = 20;
		ycoord = 20;
		xspeed = 1;
		yspeed = 1;
		width = 15;
		height = 30;
		rectangle = new Rectangle(xcoord, ycoord, width, height);

	}

	@Override
	public int getXSpeed() {

		return (int)xspeed;
	}

	@Override
	public int getYSpeed() {

		return (int)yspeed;
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

		}
		if (d) {
			xcoord += xspeed;
		}
		if (w) {
			if(yspeed==0&&!jumped) {
				jumped=true;
				yspeed=-5;
			}
		}
		if (s) {
			yspeed += 1;
		}
		ycoord += yspeed;
		if(yspeed<5) {
			yspeed+=0.1;

		}
		rectangle = new Rectangle(xcoord, ycoord, 15, 30);
		System.out.println("Xcood: "+xcoord+", Ycoord" + ycoord);
	}

	public Rectangle2D getRectangle() {
		return rectangle;
	}

	public void setYCoord(int temp) {
		ycoord = temp;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public void resetYSpeed() {
		jumped=false;
		yspeed = 0;
	}

}
