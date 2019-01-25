package x023.GUI.Tutorials.event;

import javax.swing.*;
import java.awt.*;

public class JButtonTutorial {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame();
				JButton button = new JButton("Accept");
				frame.add(button);
				/*
				 * By calling setIcon method you are setting com on JButton by
				 * passing ImageIcon instance
				 */
				button.setIcon(new ImageIcon(getClass().getResource(
                        "com/icon/Accept.png")));
				button.setSize(new Dimension(10, 10));

				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
		});
	}
}
