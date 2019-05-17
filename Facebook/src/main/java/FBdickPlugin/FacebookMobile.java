package FBdickPlugin;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.util.Scanner;

public class FacebookMobile {

    public static void main(String[] args) throws InterruptedException {

        Scanner scan = new Scanner(System.in);
        ChromeOptions ops = new ChromeOptions();

        File path = new File("/usr/local/bin/chromedriver");

        ChromeDriverService.Builder service = new ChromeDriverService.Builder();
        service.usingDriverExecutable(path);
        service.usingAnyFreePort();
        service.usingPort(7890);


        WebDriver driver = new ChromeDriver(service.build(), ops);
        String test = "/Users/aleksandrs.grisanovs/IdeaProjects/AccentureBootcamp/Facebook/src/main/resources/posted/love_dogs.png";

        driver.get("https://m.facebook.com");
        driver.findElement(By.name("email")).sendKeys("--login--");
        WebElement element = driver.findElement(By.name("pass"));
        element.sendKeys("--pass--");
        element.submit();
        driver.get("--target--");
        driver.findElement(By.cssSelector("div[class*='_4g34 _195r _5wc_ _55st']")).click();
        driver.findElement(By.cssSelector("textarea[class*='_5whq input composerInput']")).click();
        WebElement currentElement = driver.switchTo().activeElement();
        currentElement.sendKeys(Keys.TAB);
        WebElement currentElement2 = driver.switchTo().activeElement();
        currentElement2.click();


        try {

        } catch (WebDriverException e) {
            System.out.println("Exception occured: " + e);
            System.out.println("Exiting !");
        }


        System.out.println("waiting:");
        scan.nextLine();
        driver.quit();
    }
}

//<textarea class="_5whq input composerInput" aria-label="Напишите что-нибудь..."
//        rows="1" data-store="{&quot;defaultvalue&quot;:&quot;&quot;}" name="status" placeholder="Напишите что-нибудь..." id="u_u_1r" data-sigil="m-textarea-input composer-textarea" data-autoid="autoid_61" style=""></textarea>
