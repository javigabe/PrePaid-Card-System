package es.upm.pproject.prePaidCard;


import java.util.ArrayList;
import java.util.HashMap;

public class PrePaidCardManager implements PrePaidCardInterface {

    HashMap<User, ArrayList<Card>> mapa = new HashMap<>();
    long cardNumber = 0;
    

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
    public boolean buyCard(User user, int balance, String pin) {
    	if(mapa.containsKey(user)) {
    		Card newCard = new Card(cardNumber,balance,pin);
    		mapa.get(user).add(newCard);
    		cardNumber++;
    		return true;
    	}
    	return false;
    }
    
    //method to charge a card
    public int chargeCard(User user, long idNumber, String pin, int amount) {
    	if(mapa.containsKey(user)) {
    		ArrayList<Card> cards = mapa.get(user);
    		for (int i = 0; i<cards.size(); i++) {
    			if (cards.get(i).getId() == idNumber) {
    				return cards.get(i).charge(pin, amount);
    			}
    		}
    		return -4;								//the card is not registered
    	}
    	return -3;									//the user is not registered
    }
    
    //method to pay with a card
    public int payCard(User user, long idNumber, String pin, int amount) {
    	if(mapa.containsKey(user)) {
    		ArrayList<Card> cards = mapa.get(user);
    		for (int i = 0; i<cards.size(); i++) {
    			if (cards.get(i).getId() == idNumber) {
    				return cards.get(i).pay(pin, amount);
    			}
    		}
    		return -4;								//the card is not registered
    	}
    	return -3;									//the user is not registered
    }
    
    //method to change the pin
    public int changePin(User user, long idNumber, String oldPin, String newPin) {
    	if(mapa.containsKey(user)) {
    		ArrayList<Card> cards = mapa.get(user);
    		for (int i = 0; i<cards.size(); i++) {
    			if (cards.get(i).getId() == idNumber) {
    				return cards.get(i).changePin(oldPin, newPin);
    			}
    		}
    		return -4;								//the card is not registered
    	}
    	return -3;									//the user is not registered
    }
}
