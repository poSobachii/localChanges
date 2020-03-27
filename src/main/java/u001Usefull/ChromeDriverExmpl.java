package u001Usefull;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class ChromeDriverExmpl {
    static WebDriver driver;
    static WebDriver driver2;


    public static void main(String[] args) throws IOException, InterruptedException {

        for (int i = 0; i < 2; i++) {
            FirefoxOptions options = new FirefoxOptions();
            if (i == 0) {
                driver = new ChromeDriver();
                System.out.println("driver 1 created");

            } else {
                driver2 = new ChromeDriver();
                System.out.println("driver 2 created");
            }
        }
//        ChromeOptions ops = new ChromeOptions();
//        ops.addArguments("--headless");
//        int port = 7896;

//        File path = new File("/usr/local/bin/chromedriver");
//
//        ChromeDriverService.Builder service = new ChromeDriverService.Builder();
////        service.usingDriverExecutable(path);
//        if (port == 0) {
//            service.usingAnyFreePort();
//        } else {
//            service.usingPort(port);
////        }

//        caps.setCapability(ChromeOptions.CAPABILITY, ops);
//        caps.setCapability(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, service.build());
//        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");


//            WebDriver driver = new ChromeDriver(service.build(), ops);

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("auth-form")));

        driver.get("http://www.google.com/xhtml");
        //        Thread.sleep(1000);  // Let the user actually see something!
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("sheep");
        searchBox.submit();
//        Thread.sleep(1000);  // Let the user actually see something!

        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File("/Users/aleksandrs.grisanovs/Desktop/screenshot.png"));
        driver.close();
//        driver.quit();
    }
}

