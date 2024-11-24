package msjava2lesson.validparantheses;

public class ParenthesesException  extends RuntimeException{

    /**
     * Default behaviour for exception.
     */
    public ParenthesesException(){
        super("Invalid parentheses input...");
    }

}
