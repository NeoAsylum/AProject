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
	boolean standing;

	/**
	 * Standart constructor.
	 */
	public Player() {
		xcoord = 20;
		ycoord = 20;
		xspeed = 1;
		yspeed = 1;
		width = 15;
		height = 30;
		rectangle = new Rectangle(xcoord, ycoord, width, height);
		standing = false;
	}

	/**
	 * Getter for x-speed.
	 */
	@Override
	public int getXSpeed() {

		return (int) xspeed;
	}

	/**
	 * Getter for y-speed.
	 */
	@Override
	public int getYSpeed() {

		return (int) yspeed;
	}

	/**
	 * Getter for xcoord.
	 */
	@Override
	public int getXCoord() {

		return xcoord;
	}

	/**
	 * Getter for ycoord.
	 */
	@Override
	public int getYCoord() {

		return ycoord;
	}

	/**
	 * Method moves player based on boolean input.
	 */
	public void move(boolean a, boolean s, boolean d, boolean w) {
		if (a) {
			xcoord -= xspeed;
		}
		if (d) {
			xcoord += xspeed;
		}
		// If speed is zero and the player has touched the floor it can jump.
		if (w) {
			if (yspeed == 0 && !jumped) {
				jumped = true;
				yspeed = -5;
			}
		}
		// Speed up player fall cus of physics.
		if (s) {
			yspeed += 1;
		}
		// yspeed is added.
		ycoord += yspeed;
		// Player speeds up to allowed speedlimit. (about 400 km/h for a human body)
		if (yspeed < 5) {
			// Gravity
			yspeed += 0.1;

		}
		rectangle = new Rectangle(xcoord, ycoord, 15, 30);
		System.out.println("Xcood: " + xcoord + ", Ycoord" + ycoord);
		// standing has to be set to true each frame for it to be valid.
		standing = false;
	}

	/**
	 * Return the rectangle of his body.
	 * 
	 * @return Returns the rectangle.
	 */
	public Rectangle2D getRectangle() {
		return rectangle;
	}

	/**
	 * Set the ycoord.
	 * 
	 * @param temp The future ycoord.
	 */
	public void setYCoord(int temp) {
		ycoord = temp;
	}

	/**
	 * Get the width.
	 * 
	 * @return Player width.
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Get the height.
	 * @return Player height.
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Reset the player speed.
	 */
	public void resetYSpeed() {
		standing = true;
		yspeed = 0;
	}

}
