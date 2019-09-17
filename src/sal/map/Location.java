package sal.map;

import java.util.Objects;

import sal.node.Compass;

/**
 * @author Sal
 * Represents a location on the frame.
 * Contains two values, x for the x coordinate (also row), y for the y coordinate (also column).
 */
public class Location {

	/**
	 * The x coordinate.
	 */
	private byte x;
	
	/**
	 * The y coordinate.
	 */
	private byte y;
	
	/**
	 * Constructs a location.
	 * @param x
	 * @param y
	 */
	public Location(byte x, byte y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Creates a location.
	 * @param x
	 * @param y
	 * @return
	 */
	public static Location create(int x, int y) {
		return new Location((byte) x, (byte) y);
	}
	
	/**
	 * Get the x coordinate.
	 * @return - the x coordinate.
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * Get the y coordinate.
	 * @return - the y coordinate.
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * Shifts a location with a given x and y difference.
	 * @param xDifference - the x difference.
	 * @param yDifference - the y difference.
	 * @return
	 */
	public Location shift(Compass compass) {
		return create(x + compass.getXDifference(), y + compass.getYDifference());
	}
	
	/**
	 * Calculates the distance between this location and another.
	 * @param other - the other location.
	 * @return - the distance betweeen them.
	 */
	public int distance(Location other) {
		int xDifference = x - other.x;
		int yDifference = y - other.y;
		return (int) Math.sqrt(Math.pow(xDifference, 2) + Math.pow(yDifference, 2));
	}
	
	@Override
	public int hashCode() {
		return Objects.hashCode(this);
	}
	
	@Override
	public boolean equals(Object other) {
		if (other instanceof Location) {
			Location otherLocation = (Location) other;
			if (otherLocation.getX() == this.getX() && otherLocation.getY() == this.getY())
				return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
}