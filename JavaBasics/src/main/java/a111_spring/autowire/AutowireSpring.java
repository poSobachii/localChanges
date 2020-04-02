package a111_spring.autowire;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutowireSpring {


    public static void main(String... args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AutowireConfiguration.class);
        TalkService talkService = ctx.getBean(TalkService.class);
        talkService.doStuff();
    }
}
