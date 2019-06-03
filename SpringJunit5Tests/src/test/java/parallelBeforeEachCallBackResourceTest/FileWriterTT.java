package parallelBeforeEachCallBackResourceTest;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterTT {

    static String path = "/Users/aleksandrs.grisanovs/IdeaProjects/AccentureBootcamp/SpringJunit5Tests/src/test/resources/untitled.txt";

    protected static void printOne() {
        System.out.println("printOne");
        try {
            BufferedWriter out = new BufferedWriter( new FileWriter(path, true));
            out.newLine();
            out.write("Class V2 triggered");
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
            out.write("Class V3 triggered");
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
            out.write("Class V4 triggered");
            out.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    protected static void printFour(int i){
        try {
            BufferedWriter out = new BufferedWriter( new FileWriter(path, true));
            out.newLine();
            out.write("countdown trigerred times: " + (5-i));
            out.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

}
