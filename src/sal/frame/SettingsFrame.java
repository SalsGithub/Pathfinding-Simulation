package sal.frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.LayoutStyle.ComponentPlacement;

import sal.Launcher;
import sal.Variables;
import sal.map.GridLayout;

/**
 * 
 * @author Sal
 * Represents the settings frame.
 */
public class SettingsFrame {

	/**
	 * The main frame.
	 */
	private JFrame mainFrame;
	
	/**
	 * The default grid layout is a ten by ten grid.
	 */
	private GridLayout gridLayout = GridLayout.TEN_BY_TEN;

	/**
	 * Create the application.
	 */
	public SettingsFrame() {
		buildSettingsFrame();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void buildSettingsFrame() {
		this.mainFrame = new JFrame("Settings");
		this.mainFrame.setIconImage(Variables.SETTINGS_ICON.getImage());
		this.mainFrame.getContentPane().setBackground(Color.WHITE);
		this.mainFrame.setBounds(100, 100, 236, 270);
		JCheckBox printToConsole = new JCheckBox("Print to console");
		printToConsole.setFocusable(false);
		printToConsole.setBackground(Color.WHITE);
		printToConsole.setSelected(true);
		printToConsole.setFont(new Font("Lucida Fax", Font.PLAIN, 11));
		printToConsole.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JCheckBox box = (JCheckBox) e.getSource();
				Variables.PRINT_TO_CONSOLE = box.isSelected();
			}
		});
		JCheckBox displayNodeLocations = new JCheckBox("Display node locations");
		displayNodeLocations.setFocusable(false);
		displayNodeLocations.setBackground(Color.WHITE);
		displayNodeLocations.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JCheckBox box = (JCheckBox) e.getSource();
				Variables.DISPLAY_COORDINATES = box.isSelected();
			}
		});
		displayNodeLocations.setFont(new Font("Lucida Fax", Font.PLAIN, 11));
		JButton confirm = new JButton("Confirm\r\n");
		confirm.setActionCommand("confirm");
		confirm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String actionCommand = e.getActionCommand();
				destroy();
				if (actionCommand.equalsIgnoreCase("confirm"))
					Launcher.launchPathfinder(gridLayout);
			}
		});
		confirm.setFont(new Font("Lucida Fax", Font.PLAIN, 11));
		String[] grids = {"10x10", "20x20", "30x30", "40x40", "50x50", "100x100"};
		JComboBox<String> gridOptions = new JComboBox<String>(grids);
		gridOptions.setEditable(false);
		gridOptions.setSelectedIndex(0);
		gridOptions.addActionListener(new ActionListener() {
			@SuppressWarnings("unchecked")
			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox<String> box = (JComboBox<String>) e.getSource();
				String selected = (String) box.getSelectedItem();
				gridLayout = GridLayout.findByPhrase(selected);
			}
		});
		String[] algorithms = {"AStar", "Dijkstra's"};
		JComboBox<String> algorithmOptions = new JComboBox<String>(algorithms);
		algorithmOptions.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//JComboBox<String> box = (JComboBox<String>) e.getSource();
				//String selected = (String) box.getSelectedItem();
			}
		});
		JLabel gridLayoutLabel = new JLabel("Grid:");
		gridLayoutLabel.setFont(new Font("Lucida Fax", Font.PLAIN, 13));
		JLabel algorithmLabel = new JLabel("Algorithm:");
		algorithmLabel.setFont(new Font("Lucida Fax", Font.PLAIN, 13));
		JSeparator separator = new JSeparator();
		GroupLayout groupLayout = new GroupLayout(mainFrame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(separator, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(displayNodeLocations)
								.addComponent(printToConsole)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(algorithmLabel)
										.addComponent(gridLayoutLabel, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
									.addGap(18)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(gridOptions, 0, 122, Short.MAX_VALUE)
										.addComponent(algorithmOptions, 0, 122, Short.MAX_VALUE))))
							.addContainerGap())
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(confirm)
							.addGap(76))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(21)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(gridOptions, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(gridLayoutLabel))
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(algorithmOptions, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(algorithmLabel))
					.addGap(38)
					.addComponent(printToConsole)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(displayNodeLocations)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE)
					.addGap(5)
					.addComponent(confirm)
					.addContainerGap())
		);
		mainFrame.getContentPane().setLayout(groupLayout);
	}
	
	/**
	 * Display the settings frame.
	 */
	public void display() {
		this.mainFrame.pack();
		this.mainFrame.setLocationRelativeTo(null);
		this.mainFrame.setVisible(true);
		this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		System.out.println("Settings frame displayed.");
	}
	
	/**
	 * Destroy the settings frame.
	 */
	public void destroy() {
		this.mainFrame.dispose();
	}
}
