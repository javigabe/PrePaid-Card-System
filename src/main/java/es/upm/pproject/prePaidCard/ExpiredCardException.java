package es.upm.pproject.prePaidCard;

public class ExpiredCardException extends Exception {
    private static final long serialVersionUID = 8531163982483150242L;
    public ExpiredCardException() {
        super("The card has expired");
    }
}
