package a111_spring;

public class XmlHelloWorld {
    private String message;

    public void setMessage(String message){
        this.message  = message;
    }

    void someRandomMethod(){
        System.out.println("Your Message : " + message);
    }

    public XmlHelloWorld() {
    }

    public XmlHelloWorld(String message) {
        this.message = message;
    }

    public XmlHelloWorld(String message, String anothermessage){
        this.message = message;
        System.out.println("we have constructed bean with: " + anothermessage);
    }

}
