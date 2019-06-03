package parallelBeforeEachCallBackSTRING;

import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;


public class BeforeTestsString extends MainParalleler implements BeforeAllCallback {

    private static boolean started = false;

    @Override
    public void beforeAll(ExtensionContext context) throws Exception {
        System.out.println("BEFORE INITIALISATION  100");
        if (!started) {
            System.out.println("STARTED TRIGGERED  1000");
            started = true;
            System.out.println("BEFORE NUMBER OF COUNT " + count);
            count++;
        }
    }
}
