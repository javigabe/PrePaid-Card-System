package es.upm.pproject.prePaidCard.model;


import java.util.HashMap;


public class PrePaidCardManager implements PrePaidCardInterface {

    private long cardNumber = 0;
    private HashMap<Long, Card> cards = new HashMap<>();


    public PrePaidCardManager() {

    }


    // method to register a new card for a user
    public void buyCard(String owner, Integer balance, String pin) {   //change to boolean?
		  Card card = new Card(cardNumber, balance, pin, owner);
		  cards.put(cardNumber, card);
		  cardNumber++;
    }

    // method to charge money in a card
    public Integer chargeCard(Long idNumber, String pin, Integer amount) throws CardDoesntExistException, ExpiredCardException, WrongPINException {
    	if (!cards.containsKey(idNumber)) {
    		throw new CardDoesntExistException();
		}

		Card card = cards.get(idNumber);
		return card.charge(pin, amount);

    }

    // method pay with a card
    public Integer payCard(Long idNumber, String pin, Integer amount) throws CardDoesntExistException, ExpiredCardException, NotEnoughMoneyException, WrongPINException {
  		if (!cards.containsKey(idNumber)) {
  			throw new CardDoesntExistException();
  		}

		Card card = cards.get(idNumber);
		return card.pay(pin, amount);

    }

    // method to cahnge the pin of a card
    public void changePin(Long idNumber, String oldPin, String newPin) throws CardDoesntExistException, WrongPINException {    //change to boolean?
  		if (!cards.containsKey(idNumber)) {
  			throw new CardDoesntExistException();
  		}

  		Card card = cards.get(idNumber);
  		card.changePin(oldPin, newPin);
    }

    // method to consult the movements of the current session for a card
    public String consultMovements(Long idNumber, String pin) throws CardDoesntExistException, WrongPINException {
  		if (!cards.containsKey(idNumber)) {
  			throw new CardDoesntExistException();
  		}

  		Card card = cards.get(idNumber);
  		return card.consultMovements(pin);

  	}

    // method to consult the balance of a card
  	public Integer consultBalance(Long idNumber, String pin) throws CardDoesntExistException, WrongPINException {
  		if (!cards.containsKey(idNumber)) {
  			throw new CardDoesntExistException();
  		}

  		Card card = cards.get(idNumber);
  		return card.consultBalance(pin);
  	}
  	
  	public HashMap<Long, Card> getCards() {
  		return cards;
  	}
}
