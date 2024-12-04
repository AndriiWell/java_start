package lessonfour.hometask.exception;

/**
 * Exception relates to the business flow, so uses more generic name.
 */
public class ValidationException extends RuntimeException {
    public ValidationException(String message) {
        super(message);
    }
}
