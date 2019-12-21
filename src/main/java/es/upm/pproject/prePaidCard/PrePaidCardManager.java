package es.upm.pproject.prePaidCard;


import java.util.ArrayList;
import java.util.HashMap;


public class PrePaidCardManager implements PrePaidCardInterface {

    HashMap<User, ArrayList<Card>> mapa = new HashMap<>();
    long cardNumber = 0;

    HashMap<Long, Card> cards = new HashMap<>();
    Card activeCard = null;
    

    public PrePaidCardManager() {   	
    	
    }

    public void signIn(Long cardNumber, String pin) throws WrongPINException {
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
    
    //method to register a new card for a user
    public void buyCard(String owner, Integer balance, String pin) {
		Card card = new Card(cardNumber, balance, pin, owner);
		cards.put(cardNumber, card);
		activeCard = card;
		cardNumber++;
    }
    
    //method to charge a card
    public int chargeCard(Long idNumber, String pin, Integer amount) throws CardDoesntExistException {

    }
    
    //method to pay with a card
    public int payCard(Long idNumber, String pin, Integer amount) throws CardDoesntExistException {

    }
    
    //method to change the pin
    public int changePin(Long idNumber, String oldPin, String newPin) throws CardDoesntExistException, WrongPINException {

    }
}
