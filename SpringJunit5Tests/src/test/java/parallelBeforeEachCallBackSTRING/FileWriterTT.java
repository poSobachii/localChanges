package parallelBeforeEachCallBackSTRING;

import java.io.*;

public class FileWriterTT {

    static String path = "/Users/aleksandrs.grisanovs/IdeaProjects/AccentureBootcamp/SpringJunit5Tests/src/test/resources/untitled.txt";

    protected static void printOne() {
        System.out.println("printOne");
        try {
            BufferedWriter out = new BufferedWriter( new FileWriter(path, true));
            out.newLine();
            out.write("BeforeAllCallback extension called");
            out.close();
        } catch (IOException e){
            e.printStackTrace();
        }

    }

    protected static void printTwo()  {
        System.out.println("printTwo");
        try {
            BufferedWriter out = new BufferedWriter( new FileWriter(path, true));
            out.newLine();
            out.write("RefreshTokenCalled");
            out.close();
        } catch (IOException e){
            e.printStackTrace();
        }


    }

    protected static void printThree() {
        System.out.println("printThree");
        try {
            BufferedWriter out = new BufferedWriter( new FileWriter(path, true));
            out.newLine();
            out.write("Chromedriver 3650 called444:");
            out.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

}
