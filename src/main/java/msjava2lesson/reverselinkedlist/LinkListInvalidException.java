package msjava2lesson.reverselinkedlist;

public class LinkListInvalidException extends RuntimeException{

    /**
     * Sets custom message for exception.
     *
     * @param textMessage Message to pass to RuntimeException.
     */
    public LinkListInvalidException(String textMessage){
        super(textMessage);
    }
}
