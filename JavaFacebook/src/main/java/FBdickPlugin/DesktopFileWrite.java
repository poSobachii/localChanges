package FBdickPlugin;

import java.io.*;

public class DesktopFileWrite {

    public static void main(String[] args) {

        try {
            File file = new File("/Users/aleksandrs.grisanovs/Desktop/Untitled.txt");
            /*If file gets created then the createNewFile()
             * method would return true or if the file is
             * already present it would return false
             */
            boolean fvar = file.createNewFile();
            if (fvar) {
                System.out.println("File has been created successfully");
            } else {
                System.out.println("File already present at the specified location");
            }
        } catch (IOException e) {
            System.out.println("Exception Occurred:");
            e.printStackTrace();
        }


        // -----------------------------------------------------------------------------------

        try (PrintWriter writer = new PrintWriter("/Users/aleksandrs.grisanovs/Desktop/Untitled.txt", "UTF-8");) {
            writer.println("The first line");
            writer.println("The second line");
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}

