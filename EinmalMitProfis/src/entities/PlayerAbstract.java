package entities;

import java.awt.geom.Rectangle2D;

public abstract class PlayerAbstract extends MovingObjectAbstract implements MovingObject {
	boolean jumped = true;
	boolean standing;

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

}
