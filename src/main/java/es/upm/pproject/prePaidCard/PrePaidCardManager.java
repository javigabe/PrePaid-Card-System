package es.upm.pproject.prePaidCard;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class PrePaidCardManager implements PrePaidCardInterface {

    HashMap<User, ArrayList<Card>> mapa = new HashMap<>();
    long cardNumber = 0;

    Set<Card> cards = new HashSet<>();
    

    public PrePaidCardManager() {   	
    	
    }

    //method to register a new user in the system
    public User createUser(String name, String surname) {

    	//check if the user is already registered
    	User newUser = new User(name,surname);
    	mapa.put(newUser, new ArrayList<Card>());
    	return newUser;
    }
    
    //method to register a new card for a user
    public boolean buyCard(User user, int balance, String pin) throws UserDoesntExistException {
    	if (!mapa.containsKey(user)) {
    		throw new UserDoesntExistException();
		}
    	else {
    		Card newCard = new Card(cardNumber,balance,pin);
    		mapa.get(user).add(newCard);
    		cardNumber++;
    		return true;
    	}
    }
    
    //method to charge a card
    public int chargeCard(User user, long idNumber, String pin, int amount) throws CardDoesntExistException, UserDoesntExistException {
    	if (!mapa.containsKey(user)) {
    		throw new UserDoesntExistException();
		}

    	else {
    		ArrayList<Card> cards = mapa.get(user);
    		for (int i = 0; i < cards.size(); i++) {
    			if (cards.get(i).getId() == idNumber) {
    				return cards.get(i).charge(pin, amount);
    			}
    		}

    		throw new CardDoesntExistException();								//the card is not registered
    	}
    }
    
    //method to pay with a card
    public int payCard(User user, long idNumber, String pin, int amount) throws UserDoesntExistException, CardDoesntExistException {
    	if (!mapa.containsKey(user)) {
    		throw new UserDoesntExistException();
		}

		else {
    		ArrayList<Card> cards = mapa.get(user);
    		for (int i = 0; i<cards.size(); i++) {
    			if (cards.get(i).getId() == idNumber) {
    				return cards.get(i).pay(pin, amount);
    			}
    		}
    		throw new CardDoesntExistException();								//the card is not registered
    	}
    }
    
    //method to change the pin
    public int changePin(User user, long idNumber, String oldPin, String newPin) throws UserDoesntExistException, CardDoesntExistException {
    	if (!mapa.containsKey(user)) {
    		throw new UserDoesntExistException();
		}

    	else {
    		ArrayList<Card> cards = mapa.get(user);
    		for (int i = 0; i<cards.size(); i++) {
    			if (cards.get(i).getId() == idNumber) {
    				return cards.get(i).changePin(oldPin, newPin);
    			}
    		}
    		throw new CardDoesntExistException();							//the card is not registered
    	}
    }
}
