package x023.GUI.Tutorials.event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonEvent {

	JFrame frame = new JFrame("Button event");
	JButton button = new JButton("Click me");

	public ButtonEvent() {
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				button.setBackground(Color.RED);
			}
		});
		frame.add(button);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new ButtonEvent();
			}
		});
	}

}
