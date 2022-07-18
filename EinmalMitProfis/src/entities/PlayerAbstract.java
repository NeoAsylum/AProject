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
  public double getXSpeed() {

    return xspeed;
  }

  /**
   * Getter for y-speed.
   */
  @Override
  public double getYSpeed() {
    return yspeed;
  }

  /**
   * Getter for xcoord.
   */
  @Override
  public double getXCoord() {
    return xcoord;
  }

  /**
   * Getter for ycoord.
   */
  @Override
  public double getYCoord() {

    return ycoord;
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
