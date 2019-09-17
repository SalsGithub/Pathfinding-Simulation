package sal;

import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import sal.frame.ExternalFrame;
import sal.frame.FrameBuilder;
import sal.frame.InternalFrame;
import sal.frame.SettingsFrame;
import sal.map.GridLayout;

/**
 * @author Sal
 * The launcher for the pathfinding gui.
 */ 
public class Launcher {

	/**
	 * The main frame to access all frames.
	 */
	public static MainFrame mainFrame;
	
	/**
	 * The main method to launch the pathfinding gui.
	 * @param args - the arguments.
	 */
	public static void main(String[] args) {
		System.out.println("Launching pathfinder program...");
		launchSettings();
	}
	
	/**
	 * Launches the settings frame.
	 */
	public static void launchSettings() {
		System.out.println("Launching the pathfinder settings...");
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				System.out.println("Displaying the settings...");
				SettingsFrame settingsFrame = new SettingsFrame();
				settingsFrame.display();
			}
		});
	}
	
	/**
	 * Launches a pathfinder with a given gridlayout.
	 * @param gridLayout - the gridlayout to use.
	 */
	public static void launchPathfinder(GridLayout gridLayout) {
		System.out.println("Launching the pathfinder gui...");
		final int value = gridLayout.getValue();
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				FrameBuilder frameBuilder = new FrameBuilder();
				frameBuilder.setFrameName("Pathfinding GUI");
				frameBuilder.setRows((byte) value);
				frameBuilder.setColumns((byte) value);
				InternalFrame internalFrame = new InternalFrame(frameBuilder);
				ExternalFrame externalFrame = null;
				try {
					externalFrame = new ExternalFrame(frameBuilder, internalFrame);
				} catch (IOException e) {
					e.printStackTrace();
				}
				if (externalFrame == null) {
					System.out.println("External frame could not be created.");
					System.exit(0);
					return;
				}
				mainFrame = new MainFrame(externalFrame, internalFrame);
				System.out.println("Displaying the pathfinder...");
				mainFrame.getExternalFrame().display();
			}
		});
	}
	
	/**
	 * Get the main frame.
	 * @return - the main frame of the UI.
	 */
	public static MainFrame getMainFrame() {
		return mainFrame;
	}
	
	/**
	 * Displays an error message.
	 * @param title - the title.
	 * @param message - the message.
	 */
	public static void displayErrorMessage(String title, String message) {
		JOptionPane.showMessageDialog(null, message, title, JOptionPane.ERROR_MESSAGE);
	}
}
