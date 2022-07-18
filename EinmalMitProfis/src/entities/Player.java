package entities;

import java.awt.Rectangle;

import execution.Main;

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
    respawn();
  }

  /**
   * Method moves player b ased on boolean input.
   */
  public void move(boolean a, boolean s, boolean d, boolean w) {
    if (a) {
      xcoord -= xspeed;
      if (xspeed < xMaxSpeed) {
        xspeed += 0.1;
      }
    } else {
      if (d) {
        xcoord += xspeed;
        if (xspeed < xMaxSpeed) {
          xspeed += 0.05;
        }
      } else {
        xspeed = 0;
      }
    }
    // If speed is zero and the player has touched the floor it can jump.
    if (w) {
      if (yspeed >= 0 & standing) {
        jumped = true;
        yspeed = -4;
      }
    }
    // Speed up player fall cus of physics.
    if (s) {
      yspeed += 1;
    }
    // yspeed is added.
    ycoord += yspeed;
    // Player speeds up to allowed speedlimit. (about 400 km/h for a human body)

    rectangle = new Rectangle((int) xcoord, (int) ycoord, width, height);
    feet = new Rectangle((int) xcoord, (int) ycoord + height * 3 / 4, width, height / 4);
    // standing has to be set to true each frame for it to be valid.
    if (yspeed < 5) {
      // Gravity
      yspeed += 0.1;

    }
  }

  public void respawn() {
    xcoord = Main.width / 2 - width / 2;
    ycoord = 20;
    xspeed = 0;
    yspeed = 1;
    width = 15;
    height = 30;
    rectangle = new Rectangle((int) xcoord, (int) ycoord, width, height);
    feet = new Rectangle((int) xcoord, (int) ycoord + height * 3 / 4, width, height);
    standing = false;
  }

}
