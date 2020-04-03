package FBdickPlugin;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class PictureTest {

    public static void main(String[] args) throws Exception
    {
        new PictureTest();
    }

    public PictureTest() throws Exception
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                JFrame editorFrame = new JFrame("Image Demo");
                editorFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                editorFrame.setSize(600, 600);

                BufferedImage image = null;
                try
                {
                    image = ImageIO.read(new File("/Users/aleksandrs.grisanovs/IdeaProjects/AccentureBootcamp/FBdickPlugin/src/main/resources/photos/text_test_na_na_na.png"));
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                    System.exit(1);
                }
                BufferedImage ret = new BufferedImage(1000,600,BufferedImage.TYPE_INT_RGB);
                ret.getGraphics().drawImage(image,0,0,1000,600,null);
                ImageIcon imageIcon = new ImageIcon(ret);
                JLabel jLabel = new JLabel();
                jLabel.setIcon(imageIcon);
                editorFrame.getContentPane().add(jLabel);

                editorFrame.pack();                           // fullscreen
//                editorFrame.setLocationRelativeTo(null);     // postion on the screen
                editorFrame.setVisible(true);
            }
        });
    }
}