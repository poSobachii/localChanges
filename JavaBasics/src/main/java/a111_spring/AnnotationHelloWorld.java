package a111_spring;

public class AnnotationHelloWorld {
    String message;

    void someRandomMethod(){
        if (message == null){
            this.message = "World";
        }
        System.out.println("Hello " + message);
    }

    public AnnotationHelloWorld(){

    }
    public AnnotationHelloWorld(String message){
        this.message = message;
    }
}
