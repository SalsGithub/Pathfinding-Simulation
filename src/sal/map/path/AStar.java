package sal.map.path;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

import sal.node.Node;
import sal.node.NodeLocator;

/**
 * 
 * @author Sal
 * Represents the astar pathfinding algorithm.
 * Finds a path from a given start location to a given end location.
 * Returns a list of all the nodes (in order) to get from the start to the end.
 */
public class AStar implements PathFinder {

	/**
	 * A hashset of nodes which have not been evaluated yet.
	 */
	private Set<Node> openNodes = new HashSet<>();

	/**
	 * A hashset of nodes that have been evaluated already.
	 */
	private Set<Node> closedNodes = new HashSet<>();

	@Override
	public Deque<Node> findPath(Node start, Node end) {
		this.openNodes.add(start);
		Node currentNode = null;
		while (!openNodes.isEmpty()) {
			currentNode = this.getLowestFCost();
			if (currentNode.equals(end)) {
				return this.constructPath(end);
			}
			this.openNodes.remove(currentNode);
			this.closedNodes.add(currentNode);
			ArrayList<Node> surroundings = NodeLocator.getSurroundings(currentNode);
			for (Node neighbourNode : surroundings) {
				if (neighbourNode.isBlocked())
					continue;
				if (!this.isNodeEvaluated(neighbourNode)) {
					if (!this.isOpenNode(neighbourNode)) {
						neighbourNode.setParent(currentNode);
						this.setGCost(currentNode, neighbourNode);
						this.setHeuristicCost(neighbourNode, end);
						this.openNodes.add(neighbourNode);
					} else {
						if (neighbourNode.getGCost() < currentNode.getGCost()) {
							this.setGCost(currentNode, neighbourNode);
							currentNode = neighbourNode;
						}
					}
				}
			}
		}
		return null;
	}
	
	/**
	 * Constructs the path to the end node.
	 * This goes from the end node, back to the start node.
	 * This basically looks at the parents which are set (using the costs) and works its way back to the start node.
	 * @param endNode - the end node.
	 * @return - the queue of paths.
	 */
	private Deque<Node> constructPath(Node endNode) {
		Deque<Node> path = new ArrayDeque<>();
		Node temporaryNode = endNode;
		while (temporaryNode.hasParentNode()) {
			path.add(temporaryNode);
			temporaryNode = temporaryNode.getParent();
		}
		return path;
	}
	
	/**
	 * If a node has been evaluated or not.
	 * @param node - the node.
	 * @return true if the node is evaluated, false otherwise.
	 */
	private boolean isNodeEvaluated(Node node) {
		return this.closedNodes.contains(node);
	}

	/**
	 * If a node is open or not.
	 * @param node - the node.
	 * @return true if the node is open, false otherwise.
	 */
	private boolean isOpenNode(Node node) {
		return this.openNodes.contains(node);
	}
	
	/**
	 * Sets the g cost (the movement cost)
	 * @param startNode - the start node.
	 * @param neighbourNode - the neighbour node.
	 */
	private void setGCost(Node startNode, Node neighbourNode) {
		neighbourNode.setGCost(neighbourNode.getLocation().distance(startNode.getLocation()));
	}
	
	/**
	 * Set the heuristic cost of a node.
	 * Uses the AStar heuristic to assign the h cost for a given node from the end (goal) node.
	 * @param node - the start node.
	 * @param end - the end node.
	 */
	private void setHeuristicCost(Node node, Node end) {
		node.setHCost(getHeuristic(node, end));
	}
	
	/**
	 * Get the heuristic cost between two nodes.
	 * @param start - the start node.
	 * @param end - the end node.
	 * @return - the heuristic cost.
	 */
	private final int getHeuristic(Node start, Node end) {
		int differenceX = start.getX() - end.getX();
		int differenceY = start.getY() - end.getY(); 
		return Math.abs(differenceX) + Math.abs(differenceY);
	}
	
	/**
	 * Returns the node with the lowest f cost in the set of open nodes.
	 * @return - the cheapest f cost node.
	 */
	private Node getLowestFCost() {
		Node temporaryNode = null;
		for (Node openNode : openNodes) {
			if (temporaryNode == null)
				temporaryNode = openNode;
			else {
				if (temporaryNode.getFCost() > openNode.getFCost())
					temporaryNode = openNode;
			}
		}
		return temporaryNode;
	}
}
