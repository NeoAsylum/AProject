package entities;

/**
 * Interface for a person.
 * 
 * @author AdrianPlaasLink
 *
 */
public interface MovingObject {

	/**
	 * Getter x-speed.
	 * 
	 * @return
	 */
	public double getXSpeed();

	/**
	 * Getter y-speed.
	 * 
	 * @return
	 */
	public double getYSpeed();

	/**
	 * Getter x-coordinates.
	 * 
	 * @return xcoordinates.
	 */
	public double getXCoord();

	/**
	 * Getter y-coordinates.
	 * 
	 * @return ycoordinates.
	 */
	public double getYCoord();


}
