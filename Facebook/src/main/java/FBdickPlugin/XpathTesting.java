package FBdickPlugin;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
//        service.usingPort(7890);


        WebDriver driver = new ChromeDriver(service.build(), ops);

//         driver.get("http://book.theautomatedtester.co.uk/");
//         driver.findElement(By.cssSelector("a[href*='ter1']")).click();
//         driver.findElement(By.xpath(".//a[contains(@href,'ter1')]")).click();


//        driver.get("http://newtours.demoaut.com/");
//        driver.findElement(By.cssSelector("input[name*='userName']")).click();

        /* Find me any 'a' elements, that have the href attribute, and that attribute contains 'ter1' == /chapter1*/

        driver.get("http://www.facebook.com");
        driver.findElement(By.name("email")).sendKeys("");
        WebElement element = driver.findElement(By.name("pass"));
        element.sendKeys("");
        element.submit();
        driver.get("");
        driver.findElement(By.cssSelector("div[class*='_3ixn']")).click();
//        driver.findElement(By.cssSelector("div[class*='_1mf _1mj']")).click();
//        WebElement fbel = driver.findElement(By.cssSelector("div[class*='_1mf _1mj']"));
//        fbel.click();
//        fbel.sendKeys("test");
//        driver.findElement(By.cssSelector("div[class*='_1mf _1mj']")).click();
        WebElement fbel = driver.findElement(By.cssSelector("div[class*='_1mf _1mj']"));
        Actions act = new Actions(driver);
        act.click().build().perform();
        act.moveToElement(fbel).click();
        act.moveToElement(fbel).sendKeys("test");







//        driver.findElement(By.cssSelector("div[class*='_1mf _1mj']")).sendKeys("test");
//        driver.findElement(By.cssSelector("div[class*='_1p1v']")).click();

//        driver.findElement(By.cssSelector("span[class*='_5qtp']")).click();
//        driver.findElement(By.cssSelector("div[class*='_1mf _1mj']")).sendKeys("test");


//        driver.findElement(By.cssSelector("div[class*='_1p1v']")).click();
//        driver.findElement(By.cssSelector("a[data-testid*='ellipsis-sprout']")).click();
//        driver.findElement(By.cssSelector("div[data-testid*='photo-video-button']")).click();
//        driver.findElement(By.cssSelector("a[role*='presentation']")).click();
//        driver.findElement(By.cssSelector("input[data-testid*='media-attachment-add-photo']")).submit();
//        Point temp = driver.findElement(By.cssSelector("a[data-testid*='ellipsis-sprout']")).getLocation();
//        System.out.println(temp);
//        driver.findElement(By.cssSelector("br[data-text*='true']")).click();
//        driver.findElement(By.cssSelector("br[data-text*='true']")).sendKeys("test");

//        driver.findElement(By.xpath(".//div[contains(@role,'region')]")).click();


//        WebElement elementT =  driver.findElement(By.cssSelector("a[data-testid*='ellipsis-sprout']"));
//        Actions actions = new Actions(driver);
//        actions.moveByOffset(670,579).click().build().perform();
//        actions.moveToElement(elementT).moveByOffset(670,579).click();
//        driver.findElement(By.cssSelector("div[class*=' _3u13 _3e9r _3u14 _1b3n']")).click();


        System.out.println("waiting:");
        scan.nextLine();
        driver.quit();
    }
}



//<a class="_4-h7 _5qtn fbReactComposerAttachmentSelector_STATUS"
//        role="tab" aria-selected="true" data-tooltip-delay="500" data-tooltip-display="overflow"
//        data-tooltip-content="Create Post" data-hover="tooltip" attachmentid="STATUS"
//        label="Create Post" data-testid="status-attachment-selector" loggingname="status_tab_selector" href="#">
//<span class="_4-fs">
//<span class="_5qtp">Create Post</span>
//<span class="_4-h8"></span></span></a>

//<a data-testid="ellipsis-sprout" role="button" aria-pressed="false" href="#">
//<div uiconfig="[object Object]" class="_m_1 _1gr3" data-tooltip-delay="500">
//<i class="_4a0a img sp_q2mFZxPVxIQ_2x sx_17e889" alt=""></i><div class="_2aha"></div></div></a>

// (670, 579)
// 692, 595

//<input accept="video/*,  video/x-m4v, video/webm, video/x-ms-wmv, video/x-msvideo, video/3gpp, video/flv, " +
//        "video/x-flv, video/mp4, video/quicktime, video/mpeg, video/ogv, .ts, .mkv, image/*, image/heic, image/heif"
//        multiple="" name="composer_photo" data-testid="media-attachment-add-photo" display="inline-block" type="file"
//class="_n _5f0v" id="js_3hb">