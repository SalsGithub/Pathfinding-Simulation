package sal.frame;

import java.awt.BorderLayout;
import java.io.IOException;

import javax.swing.JFrame;

import sal.Variables;

/**
 * 
 * @author Sal
 * Represents the external frame.
 */
public class ExternalFrame {

	/**
	 * The main frame.
	 */
	private JFrame mainFrame;
	
	/**
	 * The menu frame.
	 */
	private MenuFrame menuFrame;
	
	/**
	 * The key frame.
	 */
	private KeyFrame keyFrame;
	
	/**
	 * Construct the main frame.
	 * @param frameBuilder - the frame builder.
	 * @param internalFrame - the internal frame.
	 * @throws IOException
	 */
	public ExternalFrame(FrameBuilder frameBuilder, InternalFrame internalFrame) throws IOException {
		this.mainFrame = new JFrame(frameBuilder.getFrameName());
		this.mainFrame.setIconImage(Variables.FRAME_ICON.getImage());
		this.menuFrame = new MenuFrame();
		this.keyFrame = new KeyFrame();
		this.mainFrame.add(menuFrame.getMenuPanel(), BorderLayout.NORTH);
		this.mainFrame.add(internalFrame.getPanel(), BorderLayout.CENTER);
		this.mainFrame.add(keyFrame.getKeyPanel(), BorderLayout.WEST);
		this.mainFrame.setSize(1000, 600);
		this.mainFrame.setResizable(false);
	}
	
	/**
	 * Display the main frame.
	 */
	public void display() {
		this.mainFrame.pack();
		this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.mainFrame.setLocationRelativeTo(null);
		this.mainFrame.setVisible(true);
	}
	
	/**
	 * Get the menu frame.
	 * @return - the menu frame.
	 */
	public MenuFrame getMenuFrame() {
		return menuFrame;
	}
	
	/**
	 * Get the key frame.
	 * @return - the key frame.
	 */ 
	public KeyFrame getKeyFrame() {
		return keyFrame;
	}
}
