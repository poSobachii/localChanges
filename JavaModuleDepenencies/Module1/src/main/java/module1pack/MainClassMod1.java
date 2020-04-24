package module1pack;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClassMod1 {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AutowireConfiguration.class);
        ModuleOneService moduleOneService = ctx.getBean(ModuleOneService.class);
        moduleOneService.doStuff();
    }
}
