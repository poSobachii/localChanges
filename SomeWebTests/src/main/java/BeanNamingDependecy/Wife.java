package BeanNamingDependecy;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan("BeanNamingDependecy")
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Wife {

    @Autowired
    private Husband husbandS;

    @Getter
    public String love;

    @Bean (name = "Wife")
    public void action() {
        init();
        husbandS.dosmth();
        System.out.println("wife.reply - I need your " + husbandS.money.toUpperCase());

    }

    public void saysmth() {

        System.out.println("wife.saysmth - btw im corny");
    }

    public void init() {
        love = "erotic massage";
    }
}