package x022.SwingTests;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ListenToMe extends JFrame implements KeyListener {

    public static void main(String[] args) {
        JFrame f1 = new JFrame();
        f1.setSize(600, 600);
        f1.setVisible(true);
        f1.addKeyListener(new KeyListener() {
                public void keyTyped(KeyEvent e) {
                    if(e.getKeyCode()== KeyEvent.VK_RIGHT) {
                        System.out.println("right"); }
                    if(e.getKeyCode()== KeyEvent.VK_LEFT) {
                        System.out.println("left"); }
                    if(e.getKeyCode()== KeyEvent.VK_DOWN) {
                        System.out.println("down"); }
                    if(e.getKeyCode()== KeyEvent.VK_UP) {
                        System.out.println("up"); }
                }

                public void keyPressed(KeyEvent e) {
                    if(e.getKeyCode()== KeyEvent.VK_RIGHT) {
                        System.out.println("right"); }
                    if(e.getKeyCode()== KeyEvent.VK_LEFT) {
                        System.out.println("left"); }
                    if(e.getKeyCode()== KeyEvent.VK_DOWN) {
                        System.out.println("down"); }
                    if(e.getKeyCode()== KeyEvent.VK_UP) {
                        System.out.println("up"); }
                }

                public void keyReleased(KeyEvent e) {
                    if(e.getKeyCode()== KeyEvent.VK_RIGHT) {
                        System.out.println("right"); }
                    else if(e.getKeyCode()== KeyEvent.VK_LEFT) {
                        System.out.println("left"); }
                    else if(e.getKeyCode()== KeyEvent.VK_DOWN) {
                        System.out.println("down"); }
                    else if(e.getKeyCode()== KeyEvent.VK_UP) {
                        System.out.println("up"); }
                }
            });
        }







        public void keyTyped(KeyEvent e) {

        }

        public void keyPressed(KeyEvent e) {

        }

        public void keyReleased(KeyEvent e) {

        }

}
