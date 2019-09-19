package sal.node;

import sal.map.Location;

/**
 * 
 * @author Sal
 * Represents a node.
 * A node has a location (x, y).
 * It has a f cost, g cost and h cost.
 * All costs are usually used for neighbouring nodes.
 */
public class Node {

	/**
	 * The g cost.
	 * This is the distance of the start node, to any other given node.
	 */
	private int gCost;
	
	/**
	 * The h cost, known as the heuristic cost.
	 * This assigns a cost from a start node to the end node using the heuristic based on the pathfinder algorithm used.
	 */
	private int hCost;
	
	/**
	 * The location of the node.
	 */
	private Location location;

	/**
	 * If this node is a blocked node.
	 */
	private boolean blocked;
	
	/**
	 * If the node is a path.
	 */
	private boolean path;
	
	/**
	 * The parent node of this node.
	 * This is the node that this node will be compared to.
	 */
	private Node parent;
	
	/**
	 * Construct the node.
	 * @param location - the location.
	 */
	public Node(Location location) {
		this.location = location;
	}

	/**
	 * Get the G cost.
	 * @return - the g cost.
	 */
	public int getGCost() {
		return gCost;
	}
	
	/**
	 * Get the H cost.
	 * @return - the h cost.
	 */
	public int getHCost() {
		return hCost;
	}
	
	/**
	 * Get the F cost.
	 * @return - the full cost.
	 */
	public int getFCost() {
		return (getGCost() + getHCost());
	}
	
	/**
	 * Set the g cost.
	 * @param gCost - the g cost.
	 */
	public void setGCost(int gCost) {
		this.gCost = gCost;
	}
	
	/**
	 * Set the h cost.
	 * @param hCost - the h cost.
	 */
	public void setHCost(int hCost) {
		this.hCost = hCost;
	}
	
	/**
	 * Get the location.
	 * @return - the location.
	 */
	public Location getLocation() {
		return location;
	}
	
	/**
	 * Get the x coordinate.
	 * @return - the x coordinate.
	 */
	public int getX() {
		return location.getX();
	}
	
	/**
	 * Get the y coordinate.
	 * @return - the y coordinate.
	 */
	public int getY() {
		return location.getY();
	}
	
	/**
	 * Check if this node is blocked.
	 * @return true if this node is blocked, false otherwise.
	 */
	public boolean isBlocked() {
		return blocked;
	}

	/**
	 * Set if this node is blocked.
	 * @param blocked - if the node is blocked.
	 */
	public void setBlocked(boolean blocked) {
		this.blocked = blocked;
	}
	
	/**
	 * If the node is a path.
	 * @return true if the node is a path node, false otherwise.
	 */
	public boolean isPathNode() {
		return path;
	}
	
	/**
	 * Set if this node is a path node.
	 * @param path - if the node is a path node.
	 */
	public void setPathNode(boolean path) {
		this.path = path;
	}
	
	/**
	 * Get the parent node.
	 * @return - the parent.
	 */
	public Node getParent() {
		return parent;
	}
	
	/**
	 * If this node has a parent node.
	 * @return true if the node has a parent, false otherwise.
	 */
	public boolean hasParentNode() {
		return parent != null;
	}
	
	/**
	 * Set the parent node.
	 * @param parent - the parent node.
	 */
	public void setParent(Node parent) {
		this.parent = parent;
	}

	@Override
	public String toString() {
		boolean hasParent = hasParentNode();
		return location.toString() + ", blocked = " + blocked + ", parent = " + (hasParent ? parent.toString() : "none.");
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (blocked ? 1231 : 1237);
		result = prime * result + gCost;
		result = prime * result + hCost;
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((parent == null) ? 0 : parent.hashCode());
		result = prime * result + (path ? 1231 : 1237);
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
		Node other = (Node) obj;
		if (blocked != other.blocked) {
			return false;
		}
		if (gCost != other.gCost) {
			return false;
		}
		if (hCost != other.hCost) {
			return false;
		}
		if (location == null) {
			if (other.location != null) {
				return false;
			}
		} else if (!location.equals(other.location)) {
			return false;
		}
		if (parent == null) {
			if (other.parent != null) {
				return false;
			}
		} else if (!parent.equals(other.parent)) {
			return false;
		}
		if (path != other.path) {
			return false;
		}
		return true;
	}
}
