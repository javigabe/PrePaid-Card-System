package es.upm.pproject.prePaidCard.model;

public class CardDoesntExistException extends Exception {
    private static final long serialVersionUID = 8531163982483150242L;
    public CardDoesntExistException() {
        super("The card doesn't exist");
    }
}
