package myOnlineShop;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TempClass {
    public static int times = 0;
    public static int times2 = 0;

    public static void saySomething(){
        System.out.println("TempClass CLASS is in use via RELOAD - " + times);
        times+=2;
    }

    public static void doSomething(){
        System.out.println("TempClass CLASS is in use via BUTTON - " + times2);
        times2+=2;
    }


    public static void invokeJS(){
        try {
            ScriptEngineManager manager = new ScriptEngineManager();
            ScriptEngine engine = manager.getEngineByName("JavaScript");
            String script1 = (String)"function Uploading() {alert(\"JS worked\");}";
            engine.eval(script1);
            Invocable inv = (Invocable) engine;
            inv.invokeFunction("Uploading");
        }
        catch(Exception e) {
            System.out.println("error: "+ e);
        }
    }
}
