package parallelBeforeEachCallBackSTRING;

import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class AfterTestsString extends MainParalleler implements AfterAllCallback {


    @Override
    public void afterAll(ExtensionContext context) throws Exception {
        System.out.println("THE FINAL COUNT IS : " + count);
    }
}
