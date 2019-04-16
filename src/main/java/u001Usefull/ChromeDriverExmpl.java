package u001Usefull;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;

public class ChromeDriverExmpl {

    public static void main(String[] args) throws IOException {

        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--headless");
        int port = 0;

        File path = new File("/usr/local/bin/chromedriver");

        ChromeDriverService.Builder service = new ChromeDriverService.Builder();
        service.usingDriverExecutable(path);
        if (port == 0) {
            service.usingAnyFreePort();
        } else {
            service.usingPort(port);
        }

//        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");

        WebDriver driver = new ChromeDriver(service.build(), ops);

        driver.get("http://www.google.com/xhtml");
        //        Thread.sleep(1000);  // Let the user actually see something!
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("horse");
        searchBox.submit();
//        Thread.sleep(1000);  // Let the user actually see something!

        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File("/Users/aleksandrs.grisanovs/Desktop/screenshot.png"));
        driver.close();
        driver.quit();
    }
}
