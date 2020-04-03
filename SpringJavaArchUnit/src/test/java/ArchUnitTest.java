import architest.SimpleClass;
import architest.TalkService;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.jupiter.api.Test;

import java.util.logging.Logger;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.fields;

//@RunWith(ArchUnitRunner.class) //only for JUnit 4, not needed with JUnit 5
//@AnalyzeClasses(packages = "architest")
public class ArchUnitTest {


//    // verify that classes whose name name ends with "Service" should be located in a "service" package
//    @ArchTest
//    public static final ArchRule services_are_located_in_service_package_or_any_other_text_here = classes()
//            .that().haveSimpleNameEndingWith("Service")
//            .should().resideInAPackage("..service");
//
//    // verify that logger fields are private, static and final
//    @ArchTest
//    private final ArchRule loggers_should_be_private_static_final = fields()
//            .that().haveRawType(Logger.class)
//            .should().bePrivate()
//            .andShould().beStatic()
//            .andShould().beFinal();

    @Test
    void simpleTest(){
        System.out.println(SimpleClass.calculateSumm(20, 10));
    }
}
