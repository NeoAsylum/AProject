package entities;

import java.awt.geom.Rectangle2D;

public abstract class PlayerAbstract extends MovingObjectAbstract implements MovingObject {
  boolean jumped = true;
  boolean standing;
  Rectangle2D feet;
  double xMaxSpeed = 1.8;

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
    return (int) xcoord;
  }

  /**
   * Getter for ycoord.
   */
  @Override
  public int getYCoord() {

    return (int) ycoord;
  }

  /**
   * Method for moving the player.
   */
  public abstract void move(boolean a, boolean s, boolean d, boolean w);

  /**
   * Reset the player speed.
   */
  public void resetYSpeed(double yspeed) {
    if (this.yspeed > 0) {
      this.yspeed = yspeed;
    }
    standing = true;
  }

  /**
   * Getter for feet-rectangle.
   * 
   * @return Feet rectangle.
   */
  public Rectangle2D getFeet() {
    return feet;
  }

  public boolean playerStanding() {
    return standing;
  }

  public void setPlayerStanding(boolean standing) {
    this.standing = standing;
  }
}
