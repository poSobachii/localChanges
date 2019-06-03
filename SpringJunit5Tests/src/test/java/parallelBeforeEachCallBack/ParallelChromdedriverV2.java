package parallelBeforeEachCallBack;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class ParallelChromdedriverV2 extends MainParalleler {


    @Test
    public void tstOne() throws InterruptedException {
        driver = initDriver();
        driver.get("http://www.google.com");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("dog");
        searchBox.submit();
        Thread.sleep(1000);

    }

    @Test
    public void tstTwo() throws InterruptedException {
        driver = initDriver();
        driver.get("http://www.google.com");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("cat");
        searchBox.submit();
        Thread.sleep(1000);

    }

    @Test
    public void tstThree() throws InterruptedException {
        driver = initDriver();
        driver.get("http://www.google.com");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("horse");
        searchBox.submit();
        Thread.sleep(1000);

    }

    @Test
    public void tstFour() throws InterruptedException {
        driver = initDriver();
        driver.get("http://www.google.com");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("cow");
        searchBox.submit();
        Thread.sleep(1000);

    }

    @Test
    public void tstFive() throws InterruptedException {
        driver = initDriver();
        driver.get("http://www.google.com");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("horse");
        searchBox.submit();
        Thread.sleep(1000);

    }
}
