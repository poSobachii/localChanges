package x022.SwingTests;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class TriangleButton extends JButton {
    private Shape triangle = createTriangle();

    public void paintBorder( Graphics g ) {
        ((Graphics2D)g).draw(triangle);
    }
    public void paintComponent( Graphics g ) {
        ((Graphics2D)g).fill(triangle);
    }
    public Dimension getPreferredSize() {
        return new Dimension(200,100);
    }
    public boolean contains(int x, int y) {
        return triangle.contains(x, y);
    }

    private Shape createTriangle() {
        Polygon p = new Polygon();
        p.addPoint( 0  , 100 );
        p.addPoint( 100 , 0   );
        p.addPoint( 200 ,100  );
        return p;
    }
}

public class TriangleButon {

    public static void main( String ... args ) {
        JFrame frame = new JFrame();
        frame.setSize(600, 400);
        final JButton b =  new TriangleButton();
        b.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Click!");
            }
        });
        frame.add( new JPanel(){{add(b);}} );
        frame.setVisible(true);

    }
}