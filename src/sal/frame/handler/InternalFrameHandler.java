package sal.frame.handler;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import sal.Launcher;
import sal.Variables;
import sal.frame.InternalFrame;
import sal.map.Location;
import sal.node.Node;

/**
 * 
 * @author Sal
 * Represents the internal frame handler.
 * Handles the actions for componenets in the internal frame.
 */
public class InternalFrameHandler implements ActionListener {

	/**
	 * The internal frame to handle.
	 */
	private InternalFrame internalFrame;

	/**
	 * Construct the internal frame handler for an internal frame.
	 * @param internalFrame
	 */
	public InternalFrameHandler(InternalFrame internalFrame) {
		this.internalFrame = internalFrame;
	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		byte rows = internalFrame.getRows();
		byte columns = internalFrame.getColumns();
		for (byte row = 0; row < rows; row++) {
			for (byte column = 0; column < columns; column++) {
				Location selectedLocation = Location.create(row, column);
				JButton selectedButton = internalFrame.getButton(selectedLocation);
				Node selectedNode = internalFrame.getNode(selectedLocation);
				if (selectedButton == actionEvent.getSource()) {
					if (Variables.PLACING_START_NODE) {
						if (Variables.START_NODE != null) {
							internalFrame.colourButton(Variables.START_NODE.getLocation(), Color.BLACK);
							internalFrame.setButtonText(Variables.START_NODE.getLocation(), Variables.DISPLAY_COORDINATES ? 
									Variables.START_NODE.getLocation().toString() : "");
							if (Variables.PRINT_TO_CONSOLE)
								System.out.println("Removed the previous starting node at " + Variables.START_NODE.getLocation() + ".");
						}	
						Variables.START_NODE = selectedNode;
						internalFrame.colourButton(selectedLocation, Color.green);
						internalFrame.setButtonText(selectedLocation, "<html>START" + (Variables.DISPLAY_COORDINATES ?
								"<br>" + selectedLocation.toString() : ""));
						if (Variables.PRINT_TO_CONSOLE)
							System.out.println("Start node selected at " + selectedNode.getLocation().toString() + ".");
						Variables.PLACING_START_NODE = false;
						Launcher.getMainFrame().getExternalFrame().getMenuFrame().getButton((byte) 0).setEnabled(true);
					}
					if (Variables.PLACING_DESTINATION_NODE) {
						if (Variables.END_NODE != null) {
							internalFrame.colourButton(Variables.END_NODE.getLocation(), Color.white);
							internalFrame.getButton(Variables.END_NODE.getLocation()).setForeground(Color.black);
							internalFrame.setButtonText(Variables.END_NODE.getLocation(), Variables.DISPLAY_COORDINATES ? 
									Variables.END_NODE.getLocation().toString() : "");
							if (Variables.PRINT_TO_CONSOLE)
								System.out.println("Removed previous destination node at " + Variables.END_NODE.getLocation().toString() + ".");
						}
						Variables.END_NODE = selectedNode;
						internalFrame.colourButton(Variables.END_NODE.getLocation(), new Color(33, 100, 209));
						internalFrame.getButton(selectedLocation).setForeground(Color.white);
						internalFrame.setButtonText(selectedLocation, "<html>END" + (Variables.DISPLAY_COORDINATES ? 
								"<br>" + selectedLocation.toString() : ""));
						Variables.PLACING_DESTINATION_NODE = false;
						Launcher.getMainFrame().getExternalFrame().getMenuFrame().getButton((byte) 1).setEnabled(true);
					}
					if (Variables.ADDING_BLOCKS) {
						if (Variables.START_NODE != null) {
							if (selectedLocation.equals(Variables.START_NODE.getLocation())) {
								Launcher.displayErrorMessage("Incorrect action.", "Blocks cannot be placed on the start node.");
								return;
							}	
						}
						if (Variables.END_NODE != null) {
							if (selectedLocation.equals(Variables.END_NODE.getLocation())) {
								Launcher.displayErrorMessage("Incorrect action.", "Blocks cannot be placed on the end node.");
								return;
							}
						}
						internalFrame.colourButton(selectedLocation, new Color(206, 18, 18));
						selectedNode.setBlocked(true);
					}
					if (Variables.REMOVING_BLOCKS) {
						if (Variables.START_NODE != null) {
							if (selectedLocation.equals(Variables.START_NODE.getLocation())) {
								Launcher.displayErrorMessage("Irremovalable node.", "The start node can not be removed.");
								return;
							}
						}
						if (Variables.END_NODE != null) {
							if (selectedLocation.equals(Variables.END_NODE.getLocation())) {
								Launcher.displayErrorMessage("Irremovalable node.", "The end node can not be removed.");
								return;
							}	
						}
						internalFrame.colourButton(selectedLocation, Color.WHITE);
						selectedNode.setBlocked(false);
					}
					if (Variables.PRINT_TO_CONSOLE) {
						String location = selectedNode.getLocation().toString();
						if (Variables.ADDING_BLOCKS) 
							System.out.println("The node at " + location + " is now BLOCKED.");
						else
							System.out.println("The node at " + location + " was clicked on.");
					}
				}
			}
		}
	}

}
