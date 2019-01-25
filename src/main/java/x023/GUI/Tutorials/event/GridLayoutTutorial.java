package x023.GUI.Tutorials.event;

import javax.swing.*;
import java.awt.*;

public class GridLayoutTutorial {
	JFrame frame = new JFrame("GridLayout demo");
	JPanel panel = new JPanel();
	JPanel panel2 = new JPanel();
	JButton btn1 = new JButton("First");
	JButton btn2 = new JButton("Second");
	JButton btn3 = new JButton("Third");
	JButton btn4 = new JButton("Fourth");
	JButton btn5 = new JButton("Fifth");
	JButton btn6 = new JButton("Sixth");
	JButton btn7 = new JButton("Seventh");
	JButton btn8 = new JButton("Eight");
	JButton btn9 = new JButton("Ninth");

	public GridLayoutTutorial() {
		panel.setLayout(new BorderLayout());
//		panel.add(btn1, BorderLayout.EAST);
//		panel.add(btn2, BorderLayout.WEST);
		panel.add(btn3, BorderLayout.CENTER);


		panel2.setBackground(Color.red);
		panel2.setLayout(new GridLayout(5 ,2 , 0, 0));
		// try to delete some buttons yo
		panel2.add(btn4);
		panel2.add(btn5);
		panel2.add(btn6);
		panel2.add(btn7);
		panel2.add(btn8);
		panel2.add(btn9);

		panel.add(panel2, BorderLayout.SOUTH);
		//btn1.setPreferredSize(new Dimension(100,100));
		
		frame.add(panel);
		
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.pack();
		//frame.setSize(200,200);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new GridLayoutTutorial();
			}
		});
	}

}
