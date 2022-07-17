package entities;

import java.awt.geom.Rectangle2D;

public abstract class PlayerAbstract extends MovingObjectAbstract implements MovingObject {
	boolean jumped = true;
	boolean standing;
	Rectangle2D feet;

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
	 * Method for moving the player.
	 */
	public abstract void move(boolean a, boolean s, boolean d, boolean w);

	/**
	 * Reset the player speed.
	 */
	public void resetYSpeed() {
		standing = true;
		yspeed = 0;
	}
	
	/**
	 * Getter for feet-rectangle.
	 * @return Feet rectangle.
	 */
	public Rectangle2D getFeet() {
		return feet;
	}

}
