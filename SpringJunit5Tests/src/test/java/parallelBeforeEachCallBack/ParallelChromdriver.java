package parallelBeforeEachCallBack;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

//@Execution(ExecutionMode.CONCURRENT)
public class ParallelChromdriver extends MainParalleler{



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

    @Test
    public void tstSix() throws InterruptedException {
        driver = initDriver();
        driver.get("http://www.google.com");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("horse");
        searchBox.submit();
        Thread.sleep(1000);

    }

    @Test
    public void tstSeven() throws InterruptedException {
        driver = initDriver();
        driver.get("http://www.google.com");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("horse");
        searchBox.submit();
        Thread.sleep(1000);

    }

    @Test
    public void tstEight() throws InterruptedException {
        driver = initDriver();
        driver.get("http://www.google.com");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("horse");
        searchBox.submit();
        Thread.sleep(1000);

    }

    @Test
    public void tstNine() throws InterruptedException {
        driver = initDriver();
        driver.get("http://www.google.com");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("horse");
        searchBox.submit();
        Thread.sleep(1000);

    }

    @Test
    public void tstTen() throws InterruptedException {
        driver = initDriver();
        driver.get("http://www.google.com");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("horse");
        searchBox.submit();
        Thread.sleep(1000);

    }

    @Test
    public void tstEleven() throws InterruptedException {
        driver = initDriver();
        driver.get("http://www.google.com");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("horse");
        searchBox.submit();
        Thread.sleep(1000);

    }

    @Test
    public void tstTwelve() throws InterruptedException {
        driver = initDriver();
        driver.get("http://www.google.com");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("horse");
        searchBox.submit();
        Thread.sleep(1000);

    }

    @Test
    public void tstThirteen() throws InterruptedException {
        driver = initDriver();
        driver.get("http://www.google.com");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("horse");
        searchBox.submit();
        Thread.sleep(1000);

    }

    @Test
    public void tstFourteen() throws InterruptedException {
        driver = initDriver();
        driver.get("http://www.google.com");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("horse");
        searchBox.submit();
        Thread.sleep(1000);

    }

    @Test
    public void tstFifteen() throws InterruptedException {
        driver = initDriver();
        driver.get("http://www.google.com");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("horse");
        searchBox.submit();
        Thread.sleep(1000);

    }

    @Test
    public void tstSixteen() throws InterruptedException {
        driver = initDriver();
        driver.get("http://www.google.com");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("horse");
        searchBox.submit();
        Thread.sleep(1000);

    }

    @Test
    public void tstSeventeen() throws InterruptedException {
        driver = initDriver();
        driver.get("http://www.google.com");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("horse");
        searchBox.submit();
        Thread.sleep(1000);

    }

    @Test
    public void tstEighteen() throws InterruptedException {
        driver = initDriver();
        driver.get("http://www.google.com");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("horse");
        searchBox.submit();
        Thread.sleep(1000);

    }

    @Test
    public void tstNineteen() throws InterruptedException {
        driver = initDriver();
        driver.get("http://www.google.com");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("horse");
        searchBox.submit();
        Thread.sleep(1000);

    }

    @Test
    public void tstTenteen() throws InterruptedException {
        driver = initDriver();
        driver.get("http://www.google.com");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("horse");
        searchBox.submit();
        Thread.sleep(1000);

    }

}


