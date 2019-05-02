package BeanNamingDependecy;



import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Husband {

    @Autowired
    private Wife wife;

    @Getter
    public String money;

    @Bean (name = "Husband")
    @DependsOn ({"Wife"})
    public void action() {

        wife.saysmth();
        System.out.println("husband.reply - MAN IN DA HOUSE AND I WANT YOUR " + wife.love + " PLEASE" );
    }

    public void dosmth(){
        init();
        System.out.println("husband.dosmth - GET ME BEER");
    }


    public void init(){
        money = "over nine thousand dollars";
    }
}
