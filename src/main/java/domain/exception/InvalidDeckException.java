package domain.exception;

public class InvalidDeckException extends RuntimeException {
    public InvalidDeckException(String message) {
        super(message);
    }
}
