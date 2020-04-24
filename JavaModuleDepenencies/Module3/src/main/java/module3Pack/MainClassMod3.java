package module3Pack;


import module1pack.AutowireConfiguration;
import module1pack.ModuleOneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClassMod3 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AutowireConfiguration.class);
        ModuleOneService moduleOneService = ctx.getBean(ModuleOneService.class);
        moduleOneService.doStuff();
    }
}
