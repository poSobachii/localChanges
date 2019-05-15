package tests;

import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class CustomRule implements AfterEachCallback, BeforeEachCallback {


    @Override
    public void afterEach(ExtensionContext context) throws Exception {
        System.out.println("<<<<<<<<<<<<TEST ENDED<<<<<<<<<<<<");

    }

    @Override
    public void beforeEach(ExtensionContext context) throws Exception {
        System.out.println(">>>>>>>>>>>>>>TEST STARTED>>>>>>>>>>>>>>");

    }
}
