package sal.frame;

/**
 * @author Sal
 * Represents the frame setup.
 * Will support more than one frame to be designed.
 */
public class FrameBuilder {

	/**
	 * The name of the frame.
	 */
	private String frameName;
	
	/**
	 * The rows.
	 */
	private byte rows;
	
	/**
	 * The columns.
	 */
	private byte columns;
	
	/**
	 * Empty constructor.
	 */
	public FrameBuilder() {
		
	}
	
	/**
	 * Set the frame name.
	 * @param frameName - the frame name.
	 */
	public void setFrameName(String frameName) {
		this.frameName = frameName;
	}
	
	/**
	 * Set the rows.
	 * @param rows - the rows.
	 */
	public void setRows(byte rows) {
		this.rows = rows;
	}
	
	/**
	 * Set the columns.
	 * @param columns - the columns.
	 */
	public void setColumns(byte columns) {
		this.columns = columns;
	}
	
	/**
	 * Get the frame name.
	 * @return - the frame name.
	 */
	public String getFrameName() {
		return frameName;
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
}