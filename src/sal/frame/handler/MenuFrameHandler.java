package sal.frame.handler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Deque;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import sal.Launcher;
import sal.Variables;
import sal.frame.MenuFrame;
import sal.map.Location;
import sal.map.path.AStar;
import sal.map.path.PathFinder;
import sal.node.Node;

/**
 * @author Chousein
 * The menu frame handler.
 * Handles any actions be handled on the menu frame.
 */
public class MenuFrameHandler implements ActionListener {

	/**
	 * The menu frame.
	 */
	private MenuFrame menuFrame;

	/**
	 * Construct the menu frame handler.
	 * @param menuFrame
	 */
	public MenuFrameHandler(MenuFrame menuFrame) {
		this.menuFrame = menuFrame;
	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		for (byte row = 0; row < menuFrame.getButtons().length; row++) {
			JButton selected = menuFrame.getButton(row);
			if (selected == actionEvent.getSource()) {
				if (row == 0) {
					selected.setEnabled(false);
					this.enableButtons(1, 2, 3, 4);
					Variables.ADDING_BLOCKS = false;
					Variables.REMOVING_BLOCKS = false;
					Variables.PLACING_DESTINATION_NODE = false;
					Variables.PLACING_START_NODE = true;
				}
				if (row == 1) {
					selected.setEnabled(false);
					this.enableButtons(0, 2, 3, 4);
					Variables.ADDING_BLOCKS = false;
					Variables.REMOVING_BLOCKS = false;
					Variables.PLACING_START_NODE = false;
					Variables.PLACING_DESTINATION_NODE = true;
				}
				if (row == 2) {
					selected.setEnabled(false);
					this.enableButtons(0, 1, 3, 4);
					Variables.PLACING_DESTINATION_NODE = false;
					Variables.PLACING_START_NODE = false;
					Variables.REMOVING_BLOCKS = false;
					Variables.ADDING_BLOCKS = true;
				}
				if (row == 3) {
					selected.setEnabled(false);
					this.enableButtons(0, 1, 2);
					Variables.ADDING_BLOCKS = false;
					Variables.PLACING_DESTINATION_NODE = false;
					Variables.PLACING_START_NODE = false;
					Variables.REMOVING_BLOCKS = true;
				}
				if (row == 4) {
					Launcher.getMainFrame().getInternalFrame().clearBlockedNodes();
				}
				if (row == 5) {
					if (Variables.START_NODE == null) {
						Launcher.displayErrorMessage("Missing start node.", "A starting node must be selected.");
						return;
					}
					if (Variables.END_NODE == null) {
						Launcher.displayErrorMessage("Missing end node.", "An end node must be selected.");
						return;
					}
					PathFinder pathFinder = new AStar();
					if (Variables.PRINT_TO_CONSOLE)
						System.out.println("Finding path...");
					Deque<Node> path = pathFinder.findPath(Variables.START_NODE, Variables.END_NODE);
					if (path == null) {
						Launcher.displayErrorMessage("No such path.", "There is no path from the start to the end node.");
						return;
					}
					this.enableButtons(0, 1, 2, 3, 6);
					this.disableButtons(0, 1, 2, 3, 4, 5);
					selected.setEnabled(false);
					if (path.isEmpty()) {
						Launcher.displayErrorMessage("Empty path.", "No such path.");
						return;
					}
					for (Node pathNodes : path) {
						if (!pathNodes.equals(Variables.END_NODE)) {
							pathNodes.setPathNode(true);
							BufferedImage pathImage = null;
							try {
								pathImage = ImageIO.read(new File("./data/images/Path.png"));
							} catch (IOException e) {
								e.printStackTrace();
							}
							Launcher.getMainFrame().getInternalFrame().getButton(pathNodes.getLocation()).setText("");
							this.setImage(pathNodes.getLocation(), pathImage);
						}
					}
					path.clear();
					System.out.println("Path displayed.");
				}
				if (row == 6) {
					Launcher.getMainFrame().getInternalFrame().clearPathNodes();
					for (int i = 0; i < Variables.MENU_FRAME_BUTTON_COUNT; i++) 
						this.enableButtons(i);
				}
				if (row == 7) {
					Variables.DISPLAY_KEY = !Variables.DISPLAY_KEY;
					this.editButtonText(row, Variables.DISPLAY_KEY ? "Hide Key" : "Show Key");
					Launcher.getMainFrame().getExternalFrame().getKeyFrame().getKeyPanel().setVisible(Variables.DISPLAY_KEY);
				}
				if (Variables.PRINT_TO_CONSOLE)
					System.out.println("The '"+selected.getText() + "' button was clicked on. Row = " + row + ".");
			}
		}
	}

	/**
	 * A method to enable buttons using the button's index.
	 * @param buttonIndexes - the button indices.
	 */
	private void enableButtons(int...buttonIndexes) {
		for (int indexes : buttonIndexes) 
			menuFrame.getButton((byte) indexes).setEnabled(true);
	}
	
	/**
	 * A method to disable buttons using the button's index.
	 * @param buttonIndexes - the button indices.
	 */
	private void disableButtons(int...buttonIndexes) {
		for (int indexes : buttonIndexes) 
			menuFrame.getButton((byte) indexes).setEnabled(false);
	}

	/**
	 * Edits a button's text.
	 * @param buttonIndex - the button index.
	 * @param text - the text.
	 */
	private void editButtonText(int buttonIndex, String text) {
		menuFrame.getButton((byte) buttonIndex).setText(text);
	}
	
	/**
	 * Sets the image of a button from a given location.
	 * @param location - the location.
	 * @param bufferedImage - the image.
	 */
	private void setImage(Location location, BufferedImage bufferedImage) {
		JButton button = Launcher.getMainFrame().getInternalFrame().getButton(location);
		button.setIcon(new ImageIcon(bufferedImage));
	}
}
