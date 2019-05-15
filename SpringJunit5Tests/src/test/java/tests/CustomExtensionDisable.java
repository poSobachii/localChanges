package tests;

import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ExecutionCondition;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class CustomExtensionDisable implements ExecutionCondition {

    @Target({ ElementType.TYPE, ElementType.METHOD })
    @Retention(RetentionPolicy.RUNTIME)
    @ExtendWith(CustomExtensionDisable.class)
    public @interface ThisMethodNameForAnnotaion {
    }


    @Override
    public ConditionEvaluationResult evaluateExecutionCondition(ExtensionContext context) {
        if(false) {
            return ConditionEvaluationResult.enabled("This not happens");
        } else
        return ConditionEvaluationResult.disabled("I dont like this test");
    }
}
