package myapp.twitter.secuirty.web.exception;

public class AccessDeniedException extends RuntimeException {

    public AccessDeniedException(String message){
        super(message);
    }
}
