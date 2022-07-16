package entities;

/**
 * Interface for a person.
 * 
 * @author AdrianPlaasLink
 *
 */
public interface Person {

	/**
	 * Getter x-speed.
	 * 
	 * @return
	 */
	public int getXSpeed();

	/**
	 * Getter y-speed.
	 * 
	 * @return
	 */
	public int getYSpeed();

	/**
	 * Getter x-coordinates.
	 * 
	 * @return xcoordinates.
	 */
	public int getXCoord();

	/**
	 * Getter y-coordinates.
	 * 
	 * @return ycoordinates.
	 */
	public int getYCoord();

	/**
	 * Method to change x and y coordinates.
	 */
	public void move(boolean a, boolean s, boolean d, boolean w);

}
