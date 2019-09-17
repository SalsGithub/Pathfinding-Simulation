package sal;

import javax.swing.ImageIcon;

import sal.node.Node;

/**
 * @author Sal
 * Holds dynamic & static variables that can be changed.
 */
public class Variables {
	
	/**
	 * The normal frame icon.
	 */
	public static final ImageIcon FRAME_ICON = new ImageIcon("./data/images/FrameIcon.png");
	
	/**
	 * The settings icon.
	 */
	public static final ImageIcon SETTINGS_ICON = new ImageIcon("./data/images/SettingsIcon.png");
	
	/**
	 * If we are to allow diagonal movement.
	 */
	public static boolean ALLOW_DIAGONAL_MOVEMENT = true;
	
	/**
	 * If each node that is selected is to be printed out.
	 */
	public static boolean PRINT_TO_CONSOLE = true;
	
	/**
	 * If each node should have their coordinates displayed on it or not.
	 */
	public static boolean DISPLAY_COORDINATES = false;
	
	/**
	 * If the key should be displayed or not.
	 */
	public static boolean DISPLAY_KEY = true;
	
	/**
	 * The start node (to be determined by user).
	 */
	public static Node START_NODE = null;
	
	/**
	 * The end node (to be determined by user).
	 */
	public static Node END_NODE = null;
	
	/**
	 * If the user is placing the starting node.
	 */
	public static boolean PLACING_START_NODE = false;
	
	/**
	 * If the user is placing the destination node.
	 */
	public static boolean PLACING_DESTINATION_NODE = false;
	
	/**
	 * If the user is adding blocks (nodes that can not be moved over).
	 */
	public static boolean ADDING_BLOCKS = false;
	
	/**
	 * If the user is removing blocks (removed nodes that were blocked).
	 */
	public static boolean REMOVING_BLOCKS = false;
	
	/**
	 * The button count on the menu frame.
	 */
	public static int MENU_FRAME_BUTTON_COUNT = 0;
}
