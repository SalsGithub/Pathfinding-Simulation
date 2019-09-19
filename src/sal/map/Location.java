package sal.map;

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
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Location other = (Location) obj;
		if (x != other.x) {
			return false;
		}
		if (y != other.y) {
			return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
}