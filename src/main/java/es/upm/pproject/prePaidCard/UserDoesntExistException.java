package es.upm.pproject.prePaidCard;

public class UserDoesntExistException extends Exception {
    private static final long serialVersionUID = 8531163982483150242L;
    public UserDoesntExistException() {
        super("The user doesn't exist");
    }
}
