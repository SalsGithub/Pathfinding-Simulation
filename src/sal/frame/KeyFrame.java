package sal.frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;

/**
 * 
 * @author Sal
 * Represents the key frame to display information.
 */
public class KeyFrame {

	/**
	 * The main frame.
	 */
	private JFrame frame;

	/**
	 * The key panel.
	 */
	private JPanel keyPanel;

	/**
	 * Create the application.
	 * @throws IOException 
	 */
	public KeyFrame() throws IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
		this.frame = new JFrame();
		this.frame.setBounds(100, 100, 283, 441);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.keyPanel = new JPanel();
		this.keyPanel.setBackground(Color.white);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(keyPanel, GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
				);
		groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addComponent(keyPanel, GroupLayout.PREFERRED_SIZE, 411, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);
		JLabel keyLabel = new JLabel("Key");
		keyLabel.setFont(new Font("Lucida Fax", Font.PLAIN, 14));
		JSeparator separator = new JSeparator();
		JPanel startNodePanel = new JPanel();
		startNodePanel.setBackground(Color.white);
		BufferedImage startNodeImage = ImageIO.read(new File("./data/images/StartNode.png"));
		startNodePanel.add(new JLabel(new ImageIcon(startNodeImage)));
		JPanel blockedNodePanel = new JPanel();
		blockedNodePanel.setBackground(Color.white);
		BufferedImage blockedNodeImage = ImageIO.read(new File("./data/images/BlockedNode.png"));
		blockedNodePanel.add(new JLabel(new ImageIcon(blockedNodeImage)));
		JPanel endNodePanel = new JPanel();
		endNodePanel.setBackground(Color.white);
		BufferedImage endNodeImage = ImageIO.read(new File("./data/images/EndNode.png"));
		endNodePanel.add(new JLabel(new ImageIcon(endNodeImage)));
		JTextPane instructions = new JTextPane();
		instructions.setBackground(Color.white);
		instructions.setText("1. Set a start node by clicking on the 'Set Start Node' button then clicking on a tile on the grid."
				+ "\r\n2. Repeat the step above but for 'Set End Node'.\r\n\r* To add any obstacles, click on "
				+ "'Add Blocks' then select as many tiles as you wish on the grid.\r\n* To remove any obstacles, "
				+ "click on 'Remove Blocks' then select the obstacles you wish to remove. To remove them all at once, "
				+ "click on the 'Clear Blocks' button.");
		instructions.setEditable(false);
		JLabel endNodeLabel = new JLabel("End Node");
		endNodeLabel.setFont(new Font("Lucida Fax", Font.PLAIN, 14));
		JLabel startNodeLabel = new JLabel("Start Node");
		startNodeLabel.setFont(new Font("Lucida Fax", Font.PLAIN, 14));
		JLabel blockedNodeLabel = new JLabel("Blocked Node");
		blockedNodeLabel.setFont(new Font("Lucida Fax", Font.PLAIN, 14));
		GroupLayout keyPanelLAyout = new GroupLayout(keyPanel);
		keyPanelLAyout.setHorizontalGroup(
				keyPanelLAyout.createParallelGroup(Alignment.LEADING)
				.addGroup(keyPanelLAyout.createSequentialGroup()
						.addGap(107)
						.addComponent(keyLabel)
						.addContainerGap(134, Short.MAX_VALUE))
				.addComponent(separator, GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
				.addGroup(keyPanelLAyout.createSequentialGroup()
						.addGap(21)
						.addGroup(keyPanelLAyout.createParallelGroup(Alignment.TRAILING)
								.addGroup(keyPanelLAyout.createSequentialGroup()
										.addComponent(blockedNodeLabel)
										.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
										.addComponent(blockedNodePanel, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
								.addGroup(keyPanelLAyout.createSequentialGroup()
										.addComponent(startNodeLabel)
										.addPreferredGap(ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
										.addComponent(startNodePanel, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
								.addGroup(keyPanelLAyout.createSequentialGroup()
										.addComponent(endNodeLabel)
										.addPreferredGap(ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
										.addComponent(endNodePanel, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap())
				.addGroup(keyPanelLAyout.createSequentialGroup()
						.addContainerGap()
						.addComponent(instructions, GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
						.addContainerGap())
				);
		keyPanelLAyout.setVerticalGroup(
				keyPanelLAyout.createParallelGroup(Alignment.LEADING)
				.addGroup(keyPanelLAyout.createSequentialGroup()
						.addContainerGap()
						.addComponent(keyLabel)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(separator, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE)
						.addGroup(keyPanelLAyout.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(keyPanelLAyout.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(startNodePanel, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(blockedNodePanel, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(endNodePanel, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
								.addGroup(keyPanelLAyout.createSequentialGroup()
										.addGap(28)
										.addComponent(startNodeLabel)
										.addGap(52)
										.addComponent(blockedNodeLabel)
										.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(endNodeLabel)
										.addGap(16)))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(instructions, GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
						.addContainerGap())
				);
		keyPanel.setLayout(keyPanelLAyout);
		frame.getContentPane().setLayout(groupLayout);
	}

	/**
	 * Get the key panel.
	 * @return - the key panel.
	 */
	public JPanel getKeyPanel() {
		return keyPanel;
	}
}
