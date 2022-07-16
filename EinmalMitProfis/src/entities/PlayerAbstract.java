package entities;

import java.awt.geom.Rectangle2D;

public abstract class PlayerAbstract implements Person {
	int xcoord;
	int ycoord;
	double xspeed;
	double yspeed;
	int height;
	int width;
	boolean jumped = true;
	Rectangle2D rectangle;
	boolean standing;

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
	 * 
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
