package FBdickPlugin;


import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Clipboard;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;

public class TestClipboard extends Application{

    public static void onStart() {
        launch();

    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        Image imagee = new Image(new FileInputStream("/Users/aleksandrs.grisanovs/IdeaProjects/AccentureBootcamp/Facebook/src/main/resources/posted/macro_photo_serious.png"));

        final Clipboard clipboard = Clipboard.getSystemClipboard();
        final ClipboardContent content = new ClipboardContent();
        content.putImage(imagee);
        clipboard.setContent(content);
        System.out.println("DONE !");
        Platform.exit();
    }
}


class forTest {

    public static void main(String[] args) {
//        TestClipboard yo = new TestClipboard();
//        yo.onStart();
        TestClipboard.onStart();
    }
}
