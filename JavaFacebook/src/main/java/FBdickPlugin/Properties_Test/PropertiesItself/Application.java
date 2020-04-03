package FBdickPlugin.Properties_Test.PropertiesItself;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;

@ComponentScan(basePackages = "FBdickPlugin")
class Application {

    @Autowired
    private Environment env;

    @Value("${message1}")
    private String text1;

    @Value("${message2}")
    private String text2;

    public static void main(String[] args) {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Application.class);
        Application app = ctx.getBean(Application.class);
        app.print();
    }


    public void print(){
        System.out.println(text1);
        System.out.println(env.getProperty("message2"));
    }
}
