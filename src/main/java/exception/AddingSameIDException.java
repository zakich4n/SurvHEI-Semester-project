package exception;

public class AddingSameIDException extends RuntimeException {
    public AddingSameIDException() {
    }

    public AddingSameIDException(String message) {
        super(message);
    }


}
