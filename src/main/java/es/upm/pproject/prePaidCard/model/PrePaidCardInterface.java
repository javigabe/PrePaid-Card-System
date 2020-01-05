package es.upm.pproject.prePaidCard.model;

import java.util.HashMap;

public interface PrePaidCardInterface {
	
    public long buyCard(String owner, long balance, String pin) throws WrongPINException;

    public void chargeCard(Long idNumber, String pin, long amount) throws CardDoesntExistException, ExpiredCardException, WrongPINException;

    public void payCard(Long idNumber, String pin, long amount) throws CardDoesntExistException, ExpiredCardException, NotEnoughMoneyException, WrongPINException;

    public void changePin(Long idNumber, String oldPin, String newPin) throws CardDoesntExistException, WrongPINException;

    public String consultMovements(Long idNumber, String pin) throws CardDoesntExistException, WrongPINException;

    public Long consultBalance(Long idNumber, String pin) throws CardDoesntExistException, WrongPINException;

    public HashMap<Long, Card> getCards();
}
