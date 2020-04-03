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

public class TestClipboard extends Application {

//    public void onStart() throws Exception {
//       init();
//
//    }

    public static void onLaunch(){
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Scanner scan = new Scanner(System.in);
        String dir = "/Users/aleksandrs.grisanovs/IdeaProjects/AccentureBootcamp/Facebook/src/main/resources/toPost";
        List<String> list = new LinkedList<>();
        File directory = new File(dir);
        File[] fList = directory.listFiles();
        for (File file : fList) {
            if (file.isFile()) {
                list.add(file.getName());
            } else if (file.isDirectory()) {
                System.out.println("YES PLEASE ?");
            }
        }
        for (int i = 0; i <4 ; i++) {
            String currpos = dir + "/" + list.get(i);
            Image imagee = new Image(new FileInputStream(currpos));

            final Clipboard clipboard = Clipboard.getSystemClipboard();
            final ClipboardContent content = new ClipboardContent();
            content.putImage(imagee);
            clipboard.setContent(content);
            System.out.println("DONE !");
        }
        Platform.exit();
    }


    private String getString() {
        String dir = "/Users/aleksandrs.grisanovs/IdeaProjects/AccentureBootcamp/Facebook/src/main/resources/toPost";
        List<String> list = new LinkedList<>();
        File directory = new File(dir);
        File[] fList = directory.listFiles();
        for (File file : fList) {
            if (file.isFile()) {
                list.add(file.getName());
            } else if (file.isDirectory()) {
                System.out.println("YES PLEASE ?");
            }
        }

        return dir + "/" + list.get(0);
    }
}

class forTest {

    public static void main(String[] args) throws Exception {
//        TestClipboard yo = new TestClipboard();
//        yo.onLaunch();
        TestClipboard.onLaunch();
    }
}