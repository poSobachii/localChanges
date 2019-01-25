package x023.GUI.Tutorials.event;

import javax.swing.*;

public class JFrameTutorial {

	public static void main(String[] args) {
		JFrame frame = new JFrame("JFrame demo");
		JPanelTutorial panel = new JPanelTutorial();
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(320,240);
		frame.setVisible(true);
	}
}
