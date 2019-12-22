package es.upm.pproject.prePaidCard;


import java.util.ArrayList;
import java.util.HashMap;


public class PrePaidCardManager implements PrePaidCardInterface {

    long cardNumber = 0;

    HashMap<Long, Card> cards = new HashMap<>();
    Card activeCard = null;
    

    public PrePaidCardManager() {   	
    	
    }

    /*public void signIn(Long cardNumber, String pin) throws WrongPINException {
    	if (cards.containsKey(cardNumber)) {
			Card card = cards.get(cardNumber);
			if (card.pin.equals(pin)) {
				activeCard = card;
			}
			else {
				throw new WrongPINException();
			}
		}
    	else {
    		// Que queremos hacer si al hacer sign in la tarjeta no existe ??
    		//Card card = new Card(cardNumber, 0, PIN, owner);
		}
	}
	*/
    
    //method to register a new card for a user
    public void buyCard(String owner, Integer balance, String pin) {
		Card card = new Card(cardNumber, balance, pin, owner);
		cards.put(cardNumber, card);
		activeCard = card;
		cardNumber++;
    }
    
    //method to charge a card
    public Integer chargeCard(Long idNumber, String pin, Integer amount) throws CardDoesntExistException, ExpiredCardException, WrongPINException {
    	if (!cards.containsKey(idNumber)) {
    		throw new CardDoesntExistException();
		}
		else {
    		Card card = cards.get(idNumber);
    		card.charge(pin, amount);
    		return amount;
		}
    }
    
    //method to pay with a card
    public Integer payCard(Long idNumber, String pin, Integer amount) throws CardDoesntExistException, ExpiredCardException, NotEnoughMoneyException, WrongPINException {
		if (!cards.containsKey(idNumber)) {
			throw new CardDoesntExistException();
		}
		else {
			Card card = cards.get(idNumber);
			card.pay(pin, amount);
			return amount;
		}
    }
    
    //method to change the pin
    public void changePin(Long idNumber, String oldPin, String newPin) throws CardDoesntExistException, WrongPINException {
		if (!cards.containsKey(idNumber)) {
			throw new CardDoesntExistException();
		}
		else {
			Card card = cards.get(idNumber);
			card.changePin(oldPin, newPin);
		}
    }
}
