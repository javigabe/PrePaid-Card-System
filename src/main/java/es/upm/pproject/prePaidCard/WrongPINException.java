package es.upm.pproject.prePaidCard;

public class WrongPINException extends Exception {
    private static final long serialVersionUID = 8531163982483150242L;
    public WrongPINException() {
        super("The PIN introduced is wrong");
    }
}