package FBdickPlugin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Scanner;

public class FinalFacebookVersion {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
//        while (true) {
        long duration = System.currentTimeMillis();
        DateFormat simple = new SimpleDateFormat("HH:mm:ss:SSS");
        Date result = new Date(duration);
        System.out.println("Process started: " + simple.format(result));

        ChromeOptions ops = new ChromeOptions();
//            ops.addArguments("--headless");
        File path = new File("/usr/local/bin/chromedriver");

        ChromeDriverService.Builder service = new ChromeDriverService.Builder();
        service.usingDriverExecutable(path);
        service.usingPort(3560);

        WebDriver driver = new ChromeDriver(service.build(), ops);
        driver.get("https://mbasic.facebook.com");
        driver.findElement(By.name("email")).sendKeys("--your login--");
        WebElement element = driver.findElement(By.name("pass"));
        element.sendKeys("--your password--");
        System.out.println("wating:");
        element.submit();
        driver.get("https://mbasic.facebook.com/PetsAreAwesome");
        String temp2 = scan.nextLine();
        driver.close();
        driver.quit();

//            driver.get("https://mbasic.facebook.com/profile.php?ref_component=mbasic_home_header&ref_page=%2Fwap%2Fhome.php&refid=7&ref=wizard");
//            driver.findElement(By.name("view_photo")).click();
//            driver.findElement(By.name("file1")).sendKeys("/Users/aleksandrs.grisanovs/IdeaProjects/FBdickPlugin/src/main/resources/photos/text_test_yo.png");
//            driver.findElement(By.name("add_photo_done")).click();
//            driver.findElement(By.name("xc_message")).sendKeys("<3 #test #java #chromedriver #test18000");
//            driver.findElement(By.name("view_post")).click();
//            driver.close();
//            driver.quit();


        long duration2 = System.currentTimeMillis();
        DateFormat simple2 = new SimpleDateFormat("HH:mm:ss:SSS");
        Date result2 = new Date(duration2);
        System.out.println("Pic have been posted: " + simple2.format(result2));


//            try {
//                for (int i = 0; i < 18000; i++) {
//                    Thread.sleep(100);
//                }
//            } catch (InterruptedException ex) {
//                System.out.println("error: " + ex);
//            }
//        }
    }
}
