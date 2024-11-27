package lessonthree.streamapi;

public class Grade {
    /**
     * Name of the subject.
     */
    private String subject;

    /**
     * Score obtained in the subject.
     */
    private double source;

    public Grade(String subject, double source) {
        this.subject = subject;
        this.source = source;
    }

    public double getSource() {
        return source;
    }

    public String getSubject() {
        return subject;
    }
}
