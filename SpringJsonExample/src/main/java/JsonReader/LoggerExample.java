package JsonReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerExample implements LoggingClass {


public static void printSMTH(){
    loggerv2.debug("this is already form this class - {}", LoggerExample.class.getSimpleName());
    int age = 30 + 20;
}
}
