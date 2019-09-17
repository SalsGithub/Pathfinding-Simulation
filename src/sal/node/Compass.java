package sal.node;

/**
 * 
 * @author Sal
 * Represents a compass.
 */
public enum Compass {
	NORTH(-1, 0), 
	NORTH_EAST(-1, 1), 
	EAST(0, 1), 
	SOUTH_EAST(1, 1), 
	SOUTH(1, 0), 
	SOUTH_WEST(1, -1), 
	WEST(0, -1), 
	NORTH_WEST(-1, -1);
	
	/**
	 * The x difference to add to a given location to achieve that direction.
	 */
	private int xDifference;
	
	/**
	 * The y difference to add to a given location to achieve that direction.
	 */
	private int yDifference;
	
	/**
	 * Constructs a compass.
	 * @param xDifference
	 * @param yDifference
	 */
	Compass(int xDifference, int yDifference) {
		this.xDifference = xDifference;
		this.yDifference = yDifference;
	}
	
	/**
	 * Get the x difference.
	 * @return
	 */
	public int getXDifference() {
		return xDifference;
	}
	
	/**
	 * Get the y difference.
	 * @return
	 */
	public int getYDifference() {
		return yDifference;
	}
}
