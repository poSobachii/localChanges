package x022.SwingTests;

import java.awt.*;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class AL extends Frame implements WindowListener, ActionListener {
    TextField text = new TextField(20);
    Button b;
    private int numClicks = 0;

    public static void main(String[] args) {
        AL myWindow = new AL("My first window");
        myWindow.setSize(350,100);
        myWindow.setVisible(true);
    }

    public AL(String title) {

        super(title);
        setLayout(new FlowLayout());
        addWindowListener(this);
        b = new Button("Click me");
        add(b);
        add(text);
        b.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        numClicks++;
        text.setText("Button Clicked " + numClicks + " times");
        System.out.println("Clicked");
    }

    public void windowClosing(WindowEvent e) {
        dispose();
        System.exit(0);
    }

    public void windowOpened(WindowEvent e) {}
    public void windowActivated(WindowEvent e) {}
    public void windowIconified(WindowEvent e) {}
    public void windowDeiconified(WindowEvent e) {}
    public void windowDeactivated(WindowEvent e) {}
    public void windowClosed(WindowEvent e) {}

}
