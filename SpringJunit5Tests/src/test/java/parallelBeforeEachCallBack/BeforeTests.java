package parallelBeforeEachCallBack;

import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class BeforeTests extends MainParalleler implements BeforeAllCallback {

    private static boolean started = false;

    @Override
    public void beforeAll(ExtensionContext context) throws Exception {
        if (!started) {
            started = true;
            System.out.println("BEFORE NUMBER OF COUNT " + count);
            count++;
        }
    }
}
