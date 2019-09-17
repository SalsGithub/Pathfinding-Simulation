package sal;

import sal.frame.ExternalFrame;
import sal.frame.InternalFrame;

/**
 * @author Sal 
 * The class which holds all the frames.
 * Used to reference any frame at any point.
 */
public class MainFrame {

	/**
	 * The external frame.
	 */
	private ExternalFrame externalFrame;
	
	/**
	 * The internal frame.
	 */
	private InternalFrame internalFrame;

	/**
	 * Construct the main frame.
	 */
	public MainFrame(ExternalFrame externalFrame, InternalFrame internalFrame) {
		this.externalFrame = externalFrame;
		this.internalFrame = internalFrame;
	}
	
	/**
	 * Get the external frame.	
	 * @return
	 */
	public ExternalFrame getExternalFrame() {
		return externalFrame;
	}
	
	/**
	 * Get the internal frame.
	 * @return
	 */
	public InternalFrame getInternalFrame() {
		return internalFrame;
	}
}
