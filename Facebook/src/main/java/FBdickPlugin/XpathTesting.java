package FBdickPlugin;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.util.Scanner;

public class XpathTesting {


    public static void main(String[] args) throws InterruptedException {

        Scanner scan = new Scanner(System.in);
        ChromeOptions ops = new ChromeOptions();

        File path = new File("/usr/local/bin/chromedriver");

        ChromeDriverService.Builder service = new ChromeDriverService.Builder();
        service.usingDriverExecutable(path);
        service.usingAnyFreePort();
        service.usingPort(7890);


        WebDriver driver = new ChromeDriver(service.build(), ops);

//         driver.get("http://book.theautomatedtester.co.uk/");
//         driver.findElement(By.cssSelector("a[href*='ter1']")).click();
//         driver.findElement(By.xpath(".//a[contains(@href,'ter1')]")).click();
        /* Find me any 'a' elements, that have the href attribute, and that attribute contains 'ter1' == /chapter1*/


//        driver.get("http://newtours.demoaut.com/");
//        driver.findElement(By.cssSelector("input[name*='userName']")).click();
//        WebElement currentElement = driver.switchTo().activeElement();
//        currentElement.sendKeys("test");

        driver.get("http://www.facebook.com");
        driver.findElement(By.name("email")).sendKeys("--yourlogin--");
        WebElement element = driver.findElement(By.name("pass"));
        element.sendKeys("--yourpass--");
        element.submit();
        driver.get("--target--");
        driver.findElement(By.cssSelector("div[class*='_3ixn']")).click();
        driver.findElement(By.cssSelector("div[class*='_1mf _1mj']")).click();

        WebElement currentElement = driver.switchTo().activeElement();
        currentElement.sendKeys("test");


        System.out.println("waiting:");
        scan.nextLine();
        driver.quit();
    }
}

