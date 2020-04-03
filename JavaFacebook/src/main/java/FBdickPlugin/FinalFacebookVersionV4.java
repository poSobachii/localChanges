package FBdickPlugin;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class FinalFacebookVersionV4 {

    public static void main(String[] args) throws InterruptedException {

        Scanner scan = new Scanner(System.in);
        FirefoxOptions opt = new FirefoxOptions();
//        opt.setHeadless(true);

        ChromeDriverService.Builder service = new ChromeDriverService.Builder();
        service.usingPort(3650);

//        WebDriver driver = new ChromeDriver(service.build());
        WebDriver driver = new FirefoxDriver(opt);

//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
        driver.findElement(By.name("email")).sendKeys("--");
        WebElement element = driver.findElement(By.name("pass"));
        element.sendKeys("--");
        element.submit();
        Thread.sleep(2000);

//        for (int i = 0; i < 2; i++) {
//
//            if (i == 0) {
//                driver.get("--target url--");
//            } else {
//                driver.get("--target url--");
//            }
        driver.get("--");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("div[class*='_3ixn']")).click();
        driver.findElement(By.cssSelector("div[class*='_1mf _1mj']")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("div[data-testid*='photo-video-button']")).click();
        Thread.sleep(2000);

        driver.findElement(By.cssSelector("input[type*='file']")).sendKeys("/Users/aleksandrs.grisanovs/IdeaProjects/AccentureBootcamp/Facebook/src/main/resources/toPost/macro_photo_serious.png");
        WebElement currentElement2 = driver.switchTo().activeElement();
        currentElement2.sendKeys("test");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("button[class*='_271k _271l _271m _1qjd _7tvm _7tv2 _7tv4 _p']")).click();
        Thread.sleep(1000);

        driver.findElement(By.cssSelector("div[class*='_54nq _57di _558b _2n_z']")).click();
        Thread.sleep(1000);

        for (int i = 0; i < 9; i++) {
            Thread.sleep(1);
            driver.findElement(By.cssSelector("input[class*='_3smp']")).sendKeys(Keys.BACK_SPACE);
        }
        driver.findElement(By.cssSelector("input[class*='_3smp']")).sendKeys("20.06.2019");

        driver.findElement(By.cssSelector("input[class*='_4nx5']")).sendKeys("22");
        Thread.sleep(1000);

        driver.findElement(By.cssSelector("div[class*='_4nxe _4nww _5pw0']")).click();
        Thread.sleep(1000);

        WebElement curr = driver.switchTo().activeElement();
        curr.sendKeys("30");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("button[class*='layerConfirm _4jy0 _4jy3 _4jy1 _51sy selected _42ft']")).click();




        /* FOR CHROMEDRIVER */
//        try {
//            driver.findElement(By.cssSelector("input[class*='_n _5f0v']")).sendKeys("/Users/aleksandrs.grisanovs/IdeaProjects/AccentureBootcamp/Facebook/src/main/resources/toPost/love_dogs.png");
//
//        } catch (WebDriverException e) {
//            System.out.println("Exception occured2: " + e);
//            System.out.println("Exiting !");
//        }

        try {
            Thread.sleep(1000);
            driver.findElement(By.cssSelector("button[class*='_1mf7 _69g1 _4jy0 _4jy3 _4jy1 _51sy selected _42ft']")).click();
        } catch (WebDriverException e) {
            System.out.println("Exception occured #1: " + e);
        }

        try {
            Thread.sleep(1000);
            driver.findElement(By.cssSelector("button[class*='_1mf7 _4jy0 _4jy3 _4jy1 _51sy selected _42ft']")).click();
        } catch (WebDriverException e) {
            System.out.println("Exception occured #2: " + e);
        }
//        }

        driver.get("https://www.google.lv");
        System.out.println("waiting:");
        scan.nextLine();
        driver.quit();
    }
}









