package x023.GUI.Tutorials.event;

import javax.swing.*;

public class JTextAreaTutorial {
	JFrame frame = new JFrame("JTextArea demo");
	JTextArea textarea = new JTextArea("Hello", 10, 30);
	JScrollPane scrollPane = new JScrollPane(textarea);

	public JTextAreaTutorial() {
		//setEditable();
		//setEnabled();
		//setText(); getText();
		textarea.append(" from JTextArea\n");
		textarea.append(" frge\n");
		frame.add(scrollPane);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new JTextAreaTutorial();
			}
		});
	}

}
