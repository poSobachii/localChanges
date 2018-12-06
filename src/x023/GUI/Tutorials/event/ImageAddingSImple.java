package x023.GUI.Tutorials.event;

import javax.swing.*;


public class ImageAddingSImple {
    public static void main(String args[]) {
        JFrame frame = new JFrame("DefaultButton");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton button2 = new JButton(new ImageIcon("src/upwards.png"));
        frame.add(button2);
        frame.setSize(300, 200);
        frame.setVisible(true);
    }
}
