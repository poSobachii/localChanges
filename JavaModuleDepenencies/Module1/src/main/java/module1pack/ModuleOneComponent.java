package module1pack;

import org.springframework.stereotype.Component;

@Component
public class ModuleOneComponent  implements SomeInterface{
    @Override
    public void printSmth() {
        System.out.println("interface from module 1 worked");
    }
}
