package saveScreenshotV4;

import org.apache.commons.io.FileUtils;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import java.io.File;

import javax.swing.JFileChooser;


import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runners.model.Statement;
import org.junit.runner.Description;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import static junit.framework.TestCase.assertEquals;


public class ChromeDriverScreenshot {


    static WebDriver driver;
    static WebDriver driver2;

    @Rule
    public ScreenShotRule screenshotRule = new ScreenShotRule(driver);

    @BeforeClass
    public static void setup() throws MalformedURLException {
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        driver2 = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub/"), capabilities);
        driver2.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void someTest1() throws IOException {
        driver2.get("http://www.google.com");
        String cat = "cat";
        assertEquals("Dog", cat);
    }


    @Rule
    public final TestRule watchman = new TestWatcher() {
        @Override
        public Statement apply(Statement base, Description description) {
            return super.apply(base, description);
        }
        @Override
        protected void failed(Throwable e, Description description) {
            System.out.println("yoyoyoyo");
            try {
                File screenshot = ((TakesScreenshot) driver2).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(screenshot, new File("/Users/aleksandrs.grisanovs/Desktop/" + description.getDisplayName() + ".png"));
            } catch (IOException ioe) {
                throw new RuntimeException(ioe);
            }
        }

        @Override
        protected void finished(Description description) {
            if (driver2 != null)
                driver2.quit();
        }
    };
}

