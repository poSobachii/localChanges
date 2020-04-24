package module3Pack;

import module1pack.SomeOtherInterface;
import org.springframework.stereotype.Service;

@Service
public class ModuleThreeClass implements SomeOtherInterface {

    @Override
    public void doSmthElse() {
        System.out.println("implementations from module 3 worked");
    }
}
