package saveScreenshotV5;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

import static saveScreenshotV5.FailingTests.driverV5;

public class TestResultLoggerExtension implements TestWatcher {

    @Override
    public void testDisabled(ExtensionContext extensionContext, Optional<String> optional) {

    }

    @Override
    public void testSuccessful(ExtensionContext extensionContext) {

    }

    @Override
    public void testAborted(ExtensionContext extensionContext, Throwable throwable) {

    }

    @Override
    public void testFailed(ExtensionContext extensionContext, Throwable throwable) {
        System.out.println("yoyoyoyo");
        try {
            File screenshot = ((TakesScreenshot) driverV5).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshot, new File("/Users/aleksandrs.grisanovs/Desktop/screenshot.png"));
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }

}