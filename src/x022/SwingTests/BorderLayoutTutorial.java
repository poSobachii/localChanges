package x022.SwingTests;

import javax.swing.*;
import java.awt.*;


public class BorderLayoutTutorial {

    JFrame frame = new JFrame("BorderLayout demo");
    JButton btn1 = new JButton("NORTH");
    JButton btn2 = new JButton("SOUTH");
    JButton btn3 = new JButton("CENTER");
    JButton btn4 = new JButton("WEST");
    JButton btn5 = new JButton("EAST");
    JPanel frame1 = new JPanel();
    JPanel frame2 = new JPanel();

    public BorderLayoutTutorial() {
        frame.setLayout(new BorderLayout());
        frame.add(btn1, BorderLayout.NORTH);
        frame.add(btn2, BorderLayout.SOUTH);
        frame.add(btn3, BorderLayout.CENTER);
        frame1.add(btn4, BorderLayout.CENTER);
        frame.add(frame1, BorderLayout.WEST);
        frame.add(frame2, BorderLayout.EAST);

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new BorderLayoutTutorial();
            }
        });
    }

}