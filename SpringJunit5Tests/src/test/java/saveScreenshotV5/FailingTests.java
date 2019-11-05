package saveScreenshotV5;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(TestResultLoggerExtension.class)
public class FailingTests {

    public static WebDriver driverV5;

    @BeforeAll
    static void setup() throws MalformedURLException {
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        driverV5 = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub/"), capabilities);
        driverV5.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void someTest() {
        driverV5.get("http://www.google.com");
        String cat = "cat";
        assertEquals("Dog", cat);
    }

}
