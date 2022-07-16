package entities;

import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

import execution.Main;

public class TheFloor {

	private Rectangle2D rectangle;

	public TheFloor() {
		rectangle=new Rectangle(0,Main.height-100,Main.width,100);
		

	}
	
	public Rectangle2D getRectangle() {
		return rectangle;
	}
}
