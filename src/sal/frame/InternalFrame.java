package sal.frame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JPanel;

import sal.Variables;
import sal.frame.handler.InternalFrameHandler;
import sal.map.Location;
import sal.node.Node;

/**
 * @author Sal
 * Constructs the internal frame holding the locations and nodes.
 */
public class InternalFrame {

	/**
	 * The jpanel containing the components.
	 */
	private JPanel panel;

	/**
	 * The buttons.
	 */
	private JButton[][] buttons;

	/**
	 * The hashmap containing the nodes with locations.
	 * The key : The node.
	 * The value : The location of the node.
	 */
	private Map<Node, Location> tiles;

	/**
	 * The rows and columns.
	 */
	private byte rows, columns;

	/**
	 * Construct the internal frame.
	 */
	public InternalFrame(FrameBuilder frameBuilder) {
		this.rows = frameBuilder.getRows();
		this.columns = frameBuilder.getColumns();
		this.panel = new JPanel();
		this.panel.setForeground(Color.white);
		this.panel.setPreferredSize(new Dimension(700, 500));
		this.panel.setLayout(new GridLayout(frameBuilder.getRows(), frameBuilder.getColumns()));
		this.buttons = new JButton[frameBuilder.getRows()][frameBuilder.getColumns()];
		this.tiles = new HashMap<>();
		for (byte row = 0; row < frameBuilder.getRows(); row++) {
			for (byte column = 0; column < frameBuilder.getColumns(); column++) {
				Location location = new Location(row, column);
				Node node = new Node(location);
				registerNode(node);
				JButton button = new JButton();
				button.setMargin(new Insets(0, 0, 0, 0));
				button.setForeground(Color.black);
				button.setBackground(Color.white);
				button.setOpaque(true);
				button.setFont(new Font("TimesRoman", Font.PLAIN, 12));
				if (Variables.DISPLAY_COORDINATES)
					button.setText("<html>(" + node.getLocation().getX() + ", " + node.getLocation().getY() + ")");
				button.addActionListener(new InternalFrameHandler(this));
				this.panel.add(button);
				registerButton(button, location);
			}
		}
	}
	
	/**
	 * Get the tiles.
	 * @return - the tiles.
	 */
	public Map<Node, Location> getTiles() {
		return this.tiles;
	}

	/**
	 * Gets a node using a given location.
	 * @param location - the location.
	 * @return - the node.
	 */
	public Node getNode(Location location) {
		for (Map.Entry<Node, Location> entry : tiles.entrySet()) {
			Node key = entry.getKey();
			Location value = entry.getValue();
			if (location.equals(value)) 
				return key;
		}
		return null;
	}

	/**
	 * Colours a button.
	 * @param location - the location.
	 * @param color - the color.
	 */
	public void colourButton(Location location, Color color) {
		JButton button = getButton(location);
		button.setBackground(color);
		button.setOpaque(true);
	}
	
	/**
	 * Edits the text of a button.
	 * @param location - the location.
	 * @param text - the text.
	 */
	public void setButtonText(Location location, String text) {
		JButton button = getButton(location);
		button.setText(text);
	}

	/**
	 * Get a button using the location.
	 * @param location - the location.
	 * @return - the button.
	 */
	public JButton getButton(Location location) {
		return buttons[location.getX()][location.getY()];
	}

	/**
	 * Registers a node.
	 * @param node - the node.
	 */
	private void registerNode(Node node) {
		this.tiles.put(node, node.getLocation());
	}

	/**
	 * Registers a button. 
	 * @param button - the button.
	 * @param location - the location.
	 */
	private void registerButton(JButton button, Location location) {
		button.setFocusable(false);
		this.buttons[location.getX()][location.getY()] = button;
	}
	
	/**
	 * Clears all the blocked nodes.
	 */
	public void clearBlockedNodes() {
		this.tiles.forEach((node, location) -> {
			if (node.isBlocked()) {
				node.setBlocked(false);
				this.colourButton(node.getLocation(), Color.white);
				
			}
		}); 
		if (Variables.PRINT_TO_CONSOLE)
			System.out.println("Unblocked all blocked nodes.");
	}
	
	/**
	 * Clears all the path nodes.
	 */
	public void clearPathNodes() {
		this.tiles.forEach((node, location) -> {
			if (node.isPathNode()) {
				node.setPathNode(false);
				this.getButton(node.getLocation()).setIcon(null);
				if (Variables.DISPLAY_COORDINATES)
					this.getButton(node.getLocation()).setText(node.getLocation().toString());
			}
		});
		if (Variables.PRINT_TO_CONSOLE)
			System.out.println("Cleared all path nodes.");
	}

	/**
	 * Get the rows.
	 * @return - the rows.
	 */
	public byte getRows() {
		return rows;
	}

	/**
	 * Get the columns.
	 * @return - the columns.
	 */ 
	public byte getColumns() {
		return columns;
	}

	/**
	 * Get the panel.
	 * @return - the panel.
	 */
	public JPanel getPanel() {
		return panel;
	}
}
