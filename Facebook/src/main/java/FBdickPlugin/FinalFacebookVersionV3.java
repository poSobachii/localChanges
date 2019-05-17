package FBdickPlugin;

import javafx.scene.input.ClipboardContent;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.awt.*;
import java.awt.datatransfer.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FinalFacebookVersionV3 {

    public static void main(String[] args) throws InterruptedException {

        Scanner scan = new Scanner(System.in);
//        TestClipboard.onStart();

        WebDriver driver = new FirefoxDriver();
//        WebDriver driver = new ChromeDriver();

        driver.get("http://www.facebook.com");
        driver.findElement(By.name("email")).sendKeys("--your login--");
        WebElement element = driver.findElement(By.name("pass"));
        element.sendKeys("--pass--");
        element.submit();
        Thread.sleep(2000);
        driver.get("--target--");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("div[class*='_3ixn']")).click();
        driver.findElement(By.cssSelector("div[class*='_1mf _1mj']")).click();

        WebElement currentElement = driver.switchTo().activeElement();
        currentElement.sendKeys(Keys.chord(Keys.COMMAND, "v"));
        Thread.sleep(5000);
        WebElement currentElement2 = driver.switchTo().activeElement();
        currentElement2.sendKeys("test");

        driver.findElement(By.cssSelector("button[class*='_271k _271l _271m _1qjd _7tvm _7tv2 _7tv4 _p']")).click();
        driver.findElement(By.cssSelector("div[class*='_54nq _57di _558b _2n_z']")).click();

        /*CHANGE DATE*/

//        Thread.sleep(500);
//        for (int i = 0; i < 7; i++) {
//            Thread.sleep(100);
//            driver.findElement(By.cssSelector("input[class*='_3smp']")).sendKeys(Keys.BACK_SPACE);
//        }
//        driver.findElement(By.cssSelector("input[class*='_3smp']")).sendKeys("2083");

        /*CHANGE TIME*/

//        driver.findElement(By.cssSelector("input[class*='_4nx5']")).sendKeys("23");
//        driver.findElement(By.cssSelector("div[class*='_4nxe _4nww _5pw0']")).click();
//        WebElement curr = driver.switchTo().activeElement();
//        curr.sendKeys("23");


        try {

            driver.findElement(By.cssSelector("button[class*='layerConfirm _4jy0 _4jy3 _4jy1 _51sy selected _42ft']")).click();
            driver.findElement(By.cssSelector("button[class*='_1mf7 _69g1 _4jy0 _4jy3 _4jy1 _51sy selected _42ft']")).click();

        } catch (WebDriverException e) {
            System.out.println("Exception occured: " + e);
            System.out.println("Exiting !");
        }


        System.out.println("waiting:");
        scan.nextLine();
        driver.quit();
    }
}

// <button action="confirm" class="layerConfirm _4jy0 _4jy3 _4jy1 _51sy selected _42ft" role="button" type="submit" value="1">Запланировать</button>
//<button class="_1mf7 _69g1 _4jy0 _4jy3 _4jy1 _51sy selected _42ft" data-testid="react-composer-post-button" type="submit" value="1"><div alt="" class="_3-8_ _2ph- _6q3h"><span class="img _55ym _55yn _55yp" role="progressbar" aria-valuetext="Загрузка..." aria-busy="true" aria-valuemin="0" aria-valuemax="100"></span></div><span class="">Запланировать публикацию</span></button>

