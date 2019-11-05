package ymlTest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties ("ignore") // no prefix, root level.
public class GlobalProperties {


    @Value("${thread-pool:msg_not_found}")
    private int threadPool;

    @Value("${email:msg_not_found}")
    private String email;

    @Value("${message}")
    private String message;

    @Value("${typeMistake:this_will_appear}")
    private String someWrongMessage;

    private String email2;

    @Value("${arrayOfStrings}")
    private String[] arrayOfString;

    @Value("${stringList}")
    private List<String> listOfString;



    public int getThreadPool() {
        return threadPool;
    }

    public void setThreadPool(int threadPool) {
        this.threadPool = threadPool;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSomeWrongMessage() {
        return someWrongMessage;
    }

    public void setSomeWrongMessage(String someWrongMessage) {
        this.someWrongMessage = someWrongMessage;
    }

    public void setEmail2(String email2) {
        this.email2 = email2;
    }

    public String getEmail2() {
        return email2;
    }

    public void setArrayOfString(String[] arrayOfString) {
        this.arrayOfString = arrayOfString;
    }

    public String[] getArrayOfString() {
        return arrayOfString;
    }

    public List<String> getListOfString() {
        return listOfString;
    }
}
