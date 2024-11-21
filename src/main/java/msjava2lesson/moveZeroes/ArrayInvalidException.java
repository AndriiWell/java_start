package msjava2lesson.moveZeroes;

/**
 * Exception for conditions of the task 3.
 */
public class ArrayInvalidException extends RuntimeException{

    /**
     * Default behaviour for exception.
     */
    public ArrayInvalidException()
    {
        super("Invalid array provided...");
    }

    /**
     * Sets custom message for exception.
     *
     * @param text_message Message to pass to RuntimeException.
     */
    public ArrayInvalidException(String text_message)
    {
        super(text_message);
    }
}
