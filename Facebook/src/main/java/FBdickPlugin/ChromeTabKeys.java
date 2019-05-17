package FBdickPlugin;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class ChromeTabKeys {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.google.com");

//        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
//        StringSelection clipboardtext = new StringSelection("cheese");
//        clipboard.setContents(clipboardtext, null);

        WebElement currentElement = driver.findElement(By.name("q"));
        currentElement.sendKeys(Keys.chord(Keys.COMMAND, "v"));
        Thread.sleep(1000);
        currentElement.sendKeys(" please");
        Thread.sleep(1000);
        currentElement.submit();

    }
}
