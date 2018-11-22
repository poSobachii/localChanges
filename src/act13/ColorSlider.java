package act13;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

// import net.miginfocom.swing.MigLayout;

public class ColorSlider {

    JFrame frame;
    JSlider redSlider, greenSlider, blueSlider;
    JTextArea txtTest;


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ColorSlider window = new ColorSlider();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        });
    }

    public ColorSlider() {
        initialize();
        add_listeners();
    }

    private void initialize() {
        frame = new JFrame();

        frame.setTitle("Color slider");
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // frame.getContentPane().setLayout(new MigLayout("", "[][][grow]", "[][][][][][grow]"));
        frame.setVisible(true);

        txtTest = new JTextArea();
        txtTest.setName("testArea");
        txtTest.setText("Test area");
        txtTest.setBackground(Color.BLACK);


        frame.getContentPane().add(txtTest, "cell 0 3 3 3,grow");

        JLabel lblR = new JLabel("R");
        frame.getContentPane().add(lblR, "cell 1 0");
        JLabel lblG = new JLabel("G");
        frame.getContentPane().add(lblG, "cell 1 1");
        JLabel lblB = new JLabel("B");
        frame.getContentPane().add(lblB, "cell 1 2");

        redSlider = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
        redSlider.setName("redSlider");
        frame.getContentPane().add(redSlider, "cell 2 0");

//		redSlider.addChangeListener(new ChangeListener() {
//
//			@Override
//            public void stateChanged(ChangeEvent e) {
//				int r = redSlider.getValue();
//                System.out.println("red " + r);
//                txtTest.setBackground(new Color ( r , 0 , 0));
//                }
//		});



        greenSlider = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
        greenSlider.setName("greenSlider");
        frame.getContentPane().add(greenSlider, "cell 2 1");

//		greenSlider.addChangeListener(new ChangeListener() {
//            @Override
//            public void stateChanged(ChangeEvent e) {
//                int g = greenSlider.getValue();
//                System.out.println("green " + g);
//                txtTest.setBackground(new Color ( 0 , g , 0));
//            }
//		});


        blueSlider = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
        blueSlider.setName("blueSlider");
        frame.getContentPane().add(blueSlider, "cell 2 2");

// 			pochemu tak "JSlider blueSlider = new JSlider" ne rabotaet ?!?!?!?


//		blueSlider.addChangeListener(new ChangeListener() {
//            @Override
//            public void stateChanged(ChangeEvent e) {
//                int b = blueSlider.getValue();
//                System.out.println("blue " + b);
//                txtTest.setBackground(new Color ( 0 , 0 , b));
//            }
//		});

        txtTest.setBackground(Color.BLACK);

        frame.setVisible(true);

    }

    private void add_listeners() {
        redSlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent event) {
                setBackgroundColor();
            }
        });

        greenSlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent event) {
                setBackgroundColor();
            }
        });

        blueSlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent event) {
                setBackgroundColor();
            }
        });

    }


    private void setBackgroundColor() {
        txtTest.setBackground(new Color(redSlider.getValue(),greenSlider.getValue(),blueSlider.getValue()));
    }

}
