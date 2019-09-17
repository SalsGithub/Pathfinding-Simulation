package sal.map.path;

import java.util.Deque;

import sal.node.Node;

/**
 * @author Sal
 * Represents the pathfinder interface.
 * Every pathfinder will inherit this class as they will be path finders.
 */
public interface PathFinder {

	/**
	 * Finds the path from the start node to the end node.
	 * Returns a list of nodes to get from the start location to the end location.
	 * @param start - the start node.
	 * @param end - the end node.
	 */
	public Deque<Node> findPath(Node start, Node end);
}
