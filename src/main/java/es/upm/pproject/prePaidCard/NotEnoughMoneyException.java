package es.upm.pproject.prePaidCard;

public class NotEnoughMoneyException extends Exception {
    private static final long serialVersionUID = 8531163982483150242L;
    public NotEnoughMoneyException() {
        super("The card doesn't have enough money");
    }
}
