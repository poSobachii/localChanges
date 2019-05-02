package x027.fbPatternsSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.util.Scanner;

public class FacebookLaunch {

    public static void main(String[] args) throws InterruptedException {

        //        Thread.sleep(1000);

        Scanner scan = new Scanner(System.in);
        ChromeOptions ops = new ChromeOptions();
//        ops.addArguments("--headless");
//        int port = 0;

        File path = new File("/usr/local/bin/chromedriver");

        ChromeDriverService.Builder service = new ChromeDriverService.Builder();
        service.usingDriverExecutable(path);
        service.usingPort(7890);


        WebDriver driver = new ChromeDriver(service.build(), ops);
//        driver.manage().window().maximize();
//        driver.get("https://www.facebook.com");
        driver.get("https://mbasic.facebook.com");
//        driver.findElement(By.name("email")).sendKeys("--your login--");
        driver.findElement(By.name("email")).sendKeys("--your login--");
//        driver.findElement(By.name("email")).sendKeys("--your login--");
        WebElement element = driver.findElement(By.name("pass"));
//        element.sendKeys("--your password--");
        element.sendKeys("--your password--");
//        element.sendKeys("--your password--");
        element.submit();
        System.out.println("waiting for command:");
        driver.get("https://mbasic.facebook.com/profile.php?ref_component=mbasic_home_header&ref_page=%2Fwap%2Fhome.php&refid=7&ref=wizard");
//        driver.findElement(By.name("view_photo")).click();
//        File fileImage = new File("/Users/aleksandrs.grisanovs/IdeaProjects/FBdickPlugin/src/main/resources/photos/text_test_yo.png");
//        driver.findElement(By.name("file1")).sendKeys(fileImage.getAbsolutePath());
//        driver.findElement(By.name("add_photo_done")).click();
//        driver.findElement(By.name("xc_message")).sendKeys("<3 #test #java #chromedriver");
//        driver.findElement(By.name("view_post")).click();
//        driver.close();
//        driver.quit();
        String temp2 = scan.nextLine();
//        driver.get("https://www.facebook.com/profile.php?id=100026651234684");
        System.out.println("Entered");
//        WebElement element1 = driver.findElement((By.xpath("//textarea[@name='xhpc_message']")));       // www.facebook.com
//        WebElement element1 = driver.findElement((By.name("xhpc_message")));                            // www.facebook.com
        WebElement element1 = driver.findElement(By.name("xc_message"));                                   // www.mbasic.facebook.com
        element1.sendKeys("This is test message with Java Selenium Chromedriver");
        element1.submit();

        driver.findElement(By.name("view_post")).click();
        System.out.println("type smth");









        String temp = scan.nextLine();
        driver.close();
        driver.quit();
    }
}
