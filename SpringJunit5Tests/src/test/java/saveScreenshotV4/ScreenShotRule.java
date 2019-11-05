package saveScreenshotV4;

import org.apache.commons.io.FileUtils;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

class ScreenShotRule extends TestWatcher {

    private WebDriver webDriver;

    public ScreenShotRule(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Override
    protected void failed(Throwable e, Description description) {
        System.out.println("yoyoyoyo");
        try {
            File screenshot = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshot, new File("/Users/aleksandrs.grisanovs/Desktop/screenshot.png"));
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }

    @Override
    protected void finished(Description description) {
        webDriver.quit();
    }
}
