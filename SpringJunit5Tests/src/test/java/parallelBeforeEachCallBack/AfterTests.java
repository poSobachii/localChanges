package parallelBeforeEachCallBack;

import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class AfterTests extends MainParalleler implements AfterAllCallback {


    @Override
    public void afterAll(ExtensionContext context) throws Exception {
        System.out.println("THE FINAL COUNT IS : " + count);
    }
}
