package module1pack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModuleOneService  {

    @Autowired
    SomeInterface someInterface;

    @Autowired
    SomeOtherInterface someOtherInreface;

    public void doStuff(){
        someInterface.printSmth();
        someOtherInreface.doSmthElse();
    }
}
