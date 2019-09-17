package sal.frame;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;

import sal.Variables;
import sal.frame.handler.MenuFrameHandler;

/**
 * 
 * @author Sal
 * The menu frame.
 * Holds the menu buttons etc.
 */
public class MenuFrame {
	
	/**
	 * The menu panel.
	 */
	private JPanel menuPanel;
	
	/**
	 * The buttons.
	 */
	private JButton[] buttons;
	
	/**
	 * Construct the menu frame.
	 */
	public MenuFrame() {
		this.menuPanel = new JPanel();
		this.menuPanel.setForeground(Color.white);
		this.menuPanel.setBackground(Color.white);
		this.buttons = new JButton[8];
		JButton selectStartNode = new JButton("Set Start Node");
		selectStartNode.setBackground(Color.GREEN);
		selectStartNode.setOpaque(true);
		JButton selectDestination = new JButton("Set End Node");
		selectDestination.setBackground(new Color(33, 100, 209));
		selectDestination.setForeground(Color.white);
		selectDestination.setOpaque(true);
		JButton addBlocks = new JButton("Add Blocks");
		addBlocks.setBackground(Color.red);
		addBlocks.setForeground(Color.white);
		addBlocks.setOpaque(true);
		JButton removeBlocks = new JButton("Remove Block");
		removeBlocks.setBackground(Color.white);
		removeBlocks.setOpaque(true);
		JButton clearBlocks = new JButton("Clear Blocks");
		clearBlocks.setBackground(Color.white);
		clearBlocks.setOpaque(true);
		JButton findPath = new JButton("Find Path");
		findPath.setBackground(Color.yellow);
		findPath.setOpaque(true);
		JButton clearPath = new JButton("Clear Path");
		clearPath.setBackground(Color.white);
		clearPath.setEnabled(false);
		clearPath.setOpaque(true);
		JButton keyDisplay = new JButton(Variables.DISPLAY_KEY ? "Hide Key" : "Show Key");
		keyDisplay.setBackground(new Color(32, 196, 250));  
		keyDisplay.setForeground(Color.white);
		keyDisplay.setOpaque(true);
		this.menuPanel.add(selectStartNode);
		this.menuPanel.add(selectDestination);
		this.menuPanel.add(addBlocks);
		this.menuPanel.add(removeBlocks);
		this.menuPanel.add(clearBlocks);
		this.menuPanel.add(findPath);
		this.menuPanel.add(clearPath);
		this.menuPanel.add(keyDisplay);
		this.buttons[0] = selectStartNode;
		this.buttons[1] = selectDestination;
		this.buttons[2] = addBlocks;
		this.buttons[3] = removeBlocks;
		this.buttons[4] = clearBlocks;
		this.buttons[5] = findPath;
		this.buttons[6] = clearPath;
		this.buttons[7] = keyDisplay;
		Variables.MENU_FRAME_BUTTON_COUNT = buttons.length;
		for (JButton button : buttons) {
			button.setFont(new Font("Lucida Fax", Font.BOLD, 11));
			button.setFocusable(false);
			button.addActionListener(new MenuFrameHandler(this));
		}
	}
	
	/**
	 * Get the buttons.
	 * @return - the buttons.
	 */
	public JButton[] getButtons() {
		return buttons;
	}
	
	/**
	 * Get a button using the row.
	 * @param row - the row.
	 * @return - the button.
	 */
	public JButton getButton(byte row) {
		return buttons[row];
	}
	
	/**
	 * Get the menu panel.
	 * @return - the jpanel.
	 */
	public JPanel getMenuPanel() {
		return menuPanel;
	}
}
