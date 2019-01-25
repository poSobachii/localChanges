package x022.SwingTests;

import javax.swing.*;
import java.awt.*;

public class ButtonsLeftAndRight {
    private JFrame frame;
    private JPanel pane;
    private JButton button1;
    private JButton button2;
    private JButton button3;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new ButtonsLeftAndRight()::createAndShowGui);
    }

    public void createAndShowGui() {
        frame = new JFrame(getClass().getSimpleName());

        pane = new JPanel();
        pane.setLayout(new BoxLayout(pane, BoxLayout.LINE_AXIS));

        button1 = new JButton("Button1");
        button2 = new JButton("Button2");
        button3 = new JButton("Button3");

        pane.add(button1);
        pane.add(Box.createHorizontalGlue());
        pane.add(button2);
        pane.add(Box.createHorizontalGlue());
        pane.add(button3);

        frame.add(pane, BorderLayout.SOUTH);


        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}