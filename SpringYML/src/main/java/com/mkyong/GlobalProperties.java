package com.mkyong;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
//@ConfigurationProperties // no prefix, root level.
public class GlobalProperties {

    //thread-pool , relax binding
//    @Value("${email:msg_not_found}")
//    private String message;

    @Value("${thread-pool:msg_not_found}")
    private int threadPool;

    @Value("${email:msg_not_found}")
    private String email;

    @Value("${message:msg_not_found}")
    private String message;

    @Value("${typeMistake:this_will_appear}")
    private String someWrongMessage;

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
}
