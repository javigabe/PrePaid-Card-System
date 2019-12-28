package es.upm.pproject.prePaidCard.model;

public interface PrePaidCardInterface {
	
    public void buyCard(String owner, Long balance, String pin);

    public Long chargeCard(Long idNumber, String pin, Integer amount) throws CardDoesntExistException, ExpiredCardException, WrongPINException;

    public Long payCard(Long idNumber, String pin, Integer amount) throws CardDoesntExistException, ExpiredCardException, NotEnoughMoneyException, WrongPINException;

    public void changePin(Long idNumber, String oldPin, String newPin) throws CardDoesntExistException, WrongPINException;

    public String consultMovements(Long idNumber, String pin) throws CardDoesntExistException, WrongPINException;

    public Long consultBalance(Long idNumber, String pin) throws CardDoesntExistException, WrongPINException;
}
