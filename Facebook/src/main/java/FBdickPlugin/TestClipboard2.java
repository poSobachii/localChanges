package FBdickPlugin;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TestClipboard2 extends Application {

    private String text;

    public void onStart() throws Exception {
       init();

    }

    public static void onLaunch(){
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println("The text is: " + text);
        Platform.exit();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}

class forTest2 {



    public static void main(String[] args) throws Exception {

        TestClipboard2 TC2 = new TestClipboard2();
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < 5 ; i++) {
            System.out.println("Say smth:");
            TC2.setText(scan.nextLine());
            if ( i == 0) {
                TC2.onLaunch();
            } else {
                TC2.onStart();
            }
        }

    }






}
