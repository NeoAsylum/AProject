package entities;

import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

import execution.Main;

/**
 * The floor class.
 * 
 * @author AdrianPlaasLink
 *
 */
public class TheFloor {

  /**
   * The shape of the floor.
   */
  private static Rectangle2D rectangle;

  /**
   * Standart constructor.
   */
  public TheFloor() {
    rectangle = new Rectangle(Main.width / 2 - 50, Main.height - 100, 100, 5);

  }

  /**
   * Get the rectangle shape of floor.
   * 
   * @return Rectangle shape.
   */
  public Rectangle2D getRectangle() {
    return rectangle;
  }

  public static void reset() {
    rectangle = new Rectangle(Main.width / 2 - 50, Main.height - 100, 100, 5);
  }

  public static void removeFromScreen() {
    rectangle = new Rectangle((int) Short.MAX_VALUE, Main.height - 100, 5, 5);
  }
}
