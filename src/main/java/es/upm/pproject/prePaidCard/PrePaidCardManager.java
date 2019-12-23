package es.upm.pproject.prePaidCard;


import java.util.HashMap;


public class PrePaidCardManager implements PrePaidCardInterface {

    private long cardNumber = 0;
    private HashMap<Long, Card> cards = new HashMap<>();


    public PrePaidCardManager() {   	
    	
    }

    
    // method to register a new card for a user
    public void buyCard(String owner, Integer balance, String pin) {
		Card card = new Card(cardNumber, balance, pin, owner);
		cards.put(cardNumber, card);
		cardNumber++;
    }
    
    public Integer chargeCard(Long idNumber, String pin, Integer amount) throws CardDoesntExistException, ExpiredCardException, WrongPINException {
    	if (!cards.containsKey(idNumber)) {
    		throw new CardDoesntExistException();
		}

		Card card = cards.get(idNumber);
		card.charge(pin, amount);
		return amount;

    }
    
    public Integer payCard(Long idNumber, String pin, Integer amount) throws CardDoesntExistException, ExpiredCardException, NotEnoughMoneyException, WrongPINException {
		if (!cards.containsKey(idNumber)) {
			throw new CardDoesntExistException();
		}

		Card card = cards.get(idNumber);
		card.pay(pin, amount);
		return amount;
    }
    
    public void changePin(Long idNumber, String oldPin, String newPin) throws CardDoesntExistException, WrongPINException {
		if (!cards.containsKey(idNumber)) {
			throw new CardDoesntExistException();
		}

		Card card = cards.get(idNumber);
		card.changePin(oldPin, newPin);
    }

    public String consultMovements(Long idNumber, String pin) throws CardDoesntExistException, WrongPINException {
		if (!cards.containsKey(idNumber)) {
			throw new CardDoesntExistException();
		}

		Card card = cards.get(idNumber);
		return card.consultMovements(pin);

	}

	public Integer consultBalance(Long idNumber, String pin) throws CardDoesntExistException, WrongPINException {
		if (!cards.containsKey(idNumber)) {
			throw new CardDoesntExistException();
		}

		Card card = cards.get(idNumber);
		return card.consultBalance(pin);
	}
}
