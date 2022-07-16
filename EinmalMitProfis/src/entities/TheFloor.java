package entities;

import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

import execution.Main;

/**
 * The floor class.
 * @author AdrianPlaasLink
 *
 */
public class TheFloor {

	/**
	 * The shape of the floor.
	 */
	private Rectangle2D rectangle;

	/**
	 * Standart constructor.
	 */
	public TheFloor() {
		rectangle=new Rectangle(0,Main.height-100,Main.width,100);
		

	}
	
	/**
	 * Get the rectangle shape of floor.
	 * @return Rectangle shape.
	 */
	public Rectangle2D getRectangle() {
		return rectangle;
	}
}
