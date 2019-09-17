package sal.node;

import java.util.ArrayList;
import java.util.Arrays;

import sal.Launcher;
import sal.Variables;
import sal.map.Location;

/**
 * 
 * @author Sal
 * Represents a node locator.
 * Used for locating nodes easily and quickly.
 * Also makes use of the compass for other locations.
 */
public class NodeLocator {

	/**
	 * Gets a node from the tiles on the grid using a location.
	 * @param location - the location.
	 * @return - the node.
	 */
	public static Node getNode(Location location) {
		return Launcher.getMainFrame().getInternalFrame().getNode(location);
	}

	/**
	 * Gets a node from a given location using the compass.
	 * Returns that node from the tiles on the grid.
	 * @param currentNode - the current node.
	 * @param compass - the compass.
	 * @return - the node.
	 */
	public static Node getNode(Location location, Compass compass) {
		Location newLocation = location.shift(compass);
		Node nodeFromTiles = Launcher.getMainFrame().getInternalFrame().getNode(newLocation);
		return nodeFromTiles;
	}

	/**
	 * Returns a list of nodes surrounding a given node.
	 * @param node - the node.
	 * @return - the surrounding nodes.
	 */
	public static ArrayList<Node> getSurroundings(Node node) {
		ArrayList<Node> surroundings = new ArrayList<>();
		Arrays.asList(Compass.values()).forEach(compassDirection -> {
			Node surroundingNode = getNode(node.getLocation(), compassDirection);
			if (surroundingNode != null) {
				if (!Variables.ALLOW_DIAGONAL_MOVEMENT) {
					if (!compassDirection.equals(Compass.NORTH_EAST)
							&& !compassDirection.equals(Compass.SOUTH_EAST)
							&& !compassDirection.equals(Compass.SOUTH_WEST)
							&& !compassDirection.equals(Compass.NORTH_WEST)) {
						surroundings.add(surroundingNode);
					}
				} else 
					surroundings.add(surroundingNode);
			}
		});
		return surroundings;
	}

}
