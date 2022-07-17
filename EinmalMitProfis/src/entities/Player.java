package entities;

import java.awt.Rectangle;


/**
 * Player class.
 * 
 * @author AdrianPlaasLink
 *
 */
public class Player extends PlayerAbstract implements MovingObject {

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
	 * Method moves player b ased on boolean input.
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
			if (yspeed == 0 && standing) {
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
		// standing has to be set to true each frame for it to be valid.
		standing = false;
	}

}
