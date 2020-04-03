package FBdickPlugin;

import org.apache.commons.exec.util.StringUtils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class FinalFacebookVersionV2 {


    static String workingDir = "/Users/aleksandrs.grisanovs/IdeaProjects/FBdickPlugin/src/main/resources/toPost/";
    static String postedDir = "/Users/aleksandrs.grisanovs/IdeaProjects/FBdickPlugin/src/main/resources/posted/";

    static List<String> names;
    static WebDriver driver;
    static String pictureToPost;
    static String textToPost;

    public static void main(String[] args) {
        timer("programm started: ");
        names = checkFolder();
        if (!names.isEmpty()) {
            launchChrome();
            connectToFacebook();
            while (!names.isEmpty()) {
                pictureToPost = getPic();
                textToPost = getText();
                printPic();
                deletePic();
                getSleep();

            }
            System.out.println("Jobs done !");
            closeChrome();
        } else {
            System.out.println("Sorry there is no pictures to post !");
        }
    }

    static List<String> checkFolder() {
        List<String> list = new LinkedList<>();
        File directory = new File(workingDir);
        File[] fList = directory.listFiles();
        for (File file : fList) {
            if (file.isFile()) {
                list.add(file.getName());
            } else if (file.isDirectory()) {
                System.out.println("YES PLEASE ?");
            }
        }
        return list;
    }


    public static void launchChrome() {
        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--headless");
        File path = new File("/usr/local/bin/chromedriver");
        ChromeDriverService.Builder service = new ChromeDriverService.Builder();
        service.usingDriverExecutable(path);
        service.usingPort(7890);
        driver = new ChromeDriver(service.build(), ops);
        timer("Chrome launched: ");
    }

    public static void closeChrome() {
        driver.close();
        driver.quit();
    }

    private static void connectToFacebook() {
        driver.get("https://mbasic.facebook.com");
        driver.findElement(By.name("email")).sendKeys("--your login--");
        WebElement element = driver.findElement(By.name("pass"));
        element.sendKeys("--your password--");
        element.submit();
        timer("Facebook logged in: ");

    }

    public static void printPic() {
        driver.get("https://mbasic.facebook.com");
        driver.findElement(By.name("view_photo")).click();
        driver.findElement(By.name("file1")).sendKeys(pictureToPost);
        driver.findElement(By.name("add_photo_done")).click();
        driver.findElement(By.name("xc_message")).sendKeys(textToPost);
        driver.findElement(By.name("view_post")).click();
        timer("Picture successfully posted at: ");
    }


    private static String getPic() {
        String currPos = workingDir + names.get(0);
        timer((currPos + ": Picture taken: "));
        return currPos;

    }

    public static String getText() {
        String filename = names.get(0);
        String parts[] = StringUtils.split(filename, ".");
        String[] tags = parts[0].split("_");
        String text = "<3";
        for (int i = 0; i < tags.length; i++) {
            text += " #" + tags[i];
        }
        timer(text + ": text taken: ");
        return text;
    }

    private static void deletePic() {
        String toDelete = workingDir + names.get(0);
        File file = new File(pictureToPost);
        try {
            FileUtils.copyFileToDirectory(file, new File(postedDir));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Files.deleteIfExists(Paths.get(toDelete));
        } catch (IOException e) {
            e.printStackTrace();
        }
        names.remove(0);
        timer("pic moved, list 0 removed ?: ");
    }

//    private static void waitForTheMoment() {
//
//        try {
//            for (int i = 0; i < 550; i++) {
//                Thread.sleep(100);
//            }
//        } catch (InterruptedException ex) {
//            System.out.println("error: " + ex);
//        }
//    }

    private static void getSleep() {
        if (!names.isEmpty()) {
            Random r = new Random();
            int test = r.nextInt(30) + 30;
            long sleepTime = test * 60 * 10;
//            long sleepTime = 50;
            String sleepin = "Begin sleeping for : " + test +" minutes in:";
            timer(sleepin);
            try {
                for (int i = 0; i < sleepTime; i++) {
                    Thread.sleep(100);
                }
            } catch (InterruptedException ex) {
                System.out.println("error: " + ex);
            }

        }
    }

    private static void timer(String text){
        long duration2 = System.currentTimeMillis();
        DateFormat simple2 = new SimpleDateFormat("HH:mm:ss:SSS");
        Date result2 = new Date(duration2);
        System.out.println(text + simple2.format(result2));

    }

}
