package a31_exception_handling;

class SomeCustomException extends RuntimeException {

    public SomeCustomException(String message){
        super(message);
    }
}
