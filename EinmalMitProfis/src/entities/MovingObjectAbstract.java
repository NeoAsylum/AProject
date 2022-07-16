package entities;

import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

public abstract class MovingObjectAbstract implements MovingObject {
  int xcoord;
  int ycoord;
  double xspeed;
  double yspeed;
  int height;
  int width;
  Rectangle2D rectangle;

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
}
