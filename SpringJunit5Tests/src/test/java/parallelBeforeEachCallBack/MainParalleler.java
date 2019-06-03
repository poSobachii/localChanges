package parallelBeforeEachCallBack;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import parallelBeforeEachCallBackSTRING.BeforeTestsString;

import java.util.concurrent.TimeUnit;


//@ExtendWith({BeforeTests.class, AfterTests.class})
@ExtendWith(BeforeTestsString.class)
public class MainParalleler {

    protected ChromeDriver driver;
    static int count = 1;
    private static boolean started = false;

    public ChromeDriver initDriver() {
        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--headless");
        ChromeDriverService.Builder service = new ChromeDriverService.Builder();
        service.usingAnyFreePort();
        ChromeDriver driverX = new ChromeDriver(service.build(), ops);
        driverX.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        return driverX;
    }

//    @BeforeAll
//    public static void beforeALl() {
//        System.out.println("BEFORE INITIALISATION");
//        if (!started) {
//            System.out.println("STARTED TRIGGERED");
//            started = true;
//            System.out.println("BEFORE NUMBER OF COUNT " + count);
//            count++;
//        }
//    }

    @AfterAll
    public static void afterALl() {
        System.out.println("THE FINAL COUNT IS: " + count);
    }

    @BeforeEach
    void before() {
        System.out.println("test started ---------------------------------------------------------------------------> ");
    }


    @AfterEach
    void waitin() {
        driver.quit();
        System.out.println("<--------------------------------------------------------------------------- test ended ");
    }

}
