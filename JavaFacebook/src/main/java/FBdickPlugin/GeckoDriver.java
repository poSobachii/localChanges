package FBdickPlugin;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class GeckoDriver {

    public static void main(String[] args){
        //if you're going to use more than one OS, you should make this switchable based on OS.
        Path path = FileSystems.getDefault().getPath("/Users/aleksandrs.grisanovs/IdeaProjects/AccentureBootcamp/Facebook/src/main/resources/geckodriver");
        System.setProperty("webdriver.gecko.driver",path.toString());
        WebDriver driver = new FirefoxDriver();
        //from here down is just a working example...
        driver.get("http://www.google.com");
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("Cheese!");
        element.submit();
        System.out.println("Page title is: " + driver.getTitle());
        driver.quit();
    }
}