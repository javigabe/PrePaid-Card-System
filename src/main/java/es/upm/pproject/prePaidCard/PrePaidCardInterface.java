package es.upm.pproject.prePaidCard;

public interface PrePaidCardInterface {
	
	//public User createUser(String name, String surname);
    //public void signIn(Long cardNumber, String pin) throws WrongPINException;
	
    public void buyCard(String owner, Integer balance, String pin);

    public Integer chargeCard(Long idNumber, String pin, Integer amount) throws CardDoesntExistException, ExpiredCardException, WrongPINException;

    public Integer payCard(Long idNumber, String pin, Integer amount) throws CardDoesntExistException, ExpiredCardException, NotEnoughMoneyException, WrongPINException;

    public void changePin(Long idNumber, String oldPin, String newPin) throws CardDoesntExistException, WrongPINException;

    public String consultMovements(Long idNumber, String pin) throws CardDoesntExistException, WrongPINException;

    public Integer consultBalance(Long idNumber, String pin) throws CardDoesntExistException, WrongPINException;
}
