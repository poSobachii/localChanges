package parallelBeforeEachCallBackResourceTest;

import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.parallel.ResourceLock;
import parallelBeforeEachCallBack.MainParalleler;

import static org.junit.jupiter.api.parallel.ResourceAccessMode.READ;
import static org.junit.jupiter.api.parallel.ResourceAccessMode.READ_WRITE;


public class BeforeTests implements BeforeAllCallback {

    static FileWriterTT tt = new FileWriterTT();

    @Override
    @ResourceLock(value = "System Properties", mode = READ)
    public void beforeAll(ExtensionContext context) throws Exception {
        System.out.println("STARTING COUNTDOWN !");
        for (int i = 0; i < 5; i++) {
            System.out.println("THE SYSTEM IS BUSY FOR: " + (5-i));
            tt.printFour(i);
            Thread.sleep(1000);
        }
    }
}
