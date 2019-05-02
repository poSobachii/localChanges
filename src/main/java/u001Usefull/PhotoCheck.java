package u001Usefull;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PhotoCheck {

    public static void main(String[] args) {
//        copyFolder();
//        copyOneFile();
//        deleteFile();

    }

//    File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//        FileUtils.copyFile(screenshot, new File("/Users/aleksandrs.grisanovs/Desktop/screenshot.png"));


    public static void copyOneFile() {
        File test = new File("/Users/aleksandrs.grisanovs/IdeaProjects/FBdickPlugin/src/main/resources/photos/text_test_yo.png");
        try {
            FileUtils.copyFileToDirectory(test, new File("/Users/aleksandrs.grisanovs/IdeaProjects/FBdickPlugin/src/main/resources/destPhotos"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void copyFolder() {
        File source = new File("/Users/aleksandrs.grisanovs/IdeaProjects/FBdickPlugin/src/main/resources/photos");
        File dest = new File("/Users/aleksandrs.grisanovs/IdeaProjects/FBdickPlugin/src/main/resources/destPhotos");
        try {
            FileUtils.copyDirectory(source, dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void deleteFile(){

        try {
            Files.deleteIfExists(Paths.get("/Users/aleksandrs.grisanovs/IdeaProjects/FBdickPlugin/src/main/resources/destPhotos/text_test_yo.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Files.deleteIfExists(Paths.get("/Users/aleksandrs.grisanovs/IdeaProjects/FBdickPlugin/src/main/resources/destPhotos/text_test_na_na_na.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void listFilesAndFolders(String directoryName){
        File directory = new File(directoryName);
        //get all the files from a directory
        File[] fList = directory.listFiles();
        for (File file : fList){
            System.out.println(file.getName());
        }
    }
    /**
     * List all the files under a directory
     * @param directoryName to be listed
     */
    public void listFiles(String directoryName){
        File directory = new File(directoryName);
        //get all the files from a directory
        File[] fList = directory.listFiles();
        for (File file : fList){
            if (file.isFile()){
                System.out.println(file.getName());
            }
        }
    }
    /**
     * List all the folder under a directory
     * @param directoryName to be listed
     */
    public void listFolders(String directoryName){
        File directory = new File(directoryName);
        //get all the files from a directory
        File[] fList = directory.listFiles();
        for (File file : fList){
            if (file.isDirectory()){
                System.out.println(file.getName());
            }
        }
    }
    /**
     * List all files from a directory and its subdirectories
     * @param directoryName to be listed
     */
    public void listFilesAndFilesSubDirectories(String directoryName){
        File directory = new File(directoryName);
        //get all the files from a directory
        File[] fList = directory.listFiles();
        for (File file : fList){
            if (file.isFile()){
                System.out.println(file.getAbsolutePath());
            } else if (file.isDirectory()){
                listFilesAndFilesSubDirectories(file.getAbsolutePath());
            }
        }
    }
}
