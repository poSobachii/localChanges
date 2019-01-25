package x023.GUI.Tutorials.event;

import javax.swing.*;
import java.awt.*;

public class GridBagLayoutTutorial {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton btn1 = new JButton("One");
	JButton btn2 = new JButton("Two");
	JButton btn3 = new JButton("Three");

	public GridBagLayoutTutorial() {
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(5, 5, 5, 5);

		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(btn1, gbc);

		gbc.gridx = 1;
		gbc.gridy = 0;
		panel.add(btn2, gbc);
		
		gbc.gridwidth = 2;
		gbc.gridx = 0;
		gbc.gridy = 1;
		panel.add(btn3, gbc);
		
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new GridBagLayoutTutorial();
			}
		});
	}

}
