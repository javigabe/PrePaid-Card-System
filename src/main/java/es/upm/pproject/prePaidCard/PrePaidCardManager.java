package es.upm.pproject.prePaidCard;


import java.util.ArrayList;
import java.util.HashMap;

public class PrePaidCardManager implements PrePaidCardInterface {

    HashMap<User, ArrayList<Card>> mapa = new HashMap<>();

    public PrePaidCardManager() {   	
    	
    }

    public void createUser(String name, String surname) {
    	
    	//check if the user is already registered
    	mapa.put(new User(name,surname), new ArrayList<Card>());
    	
    }
    
    public void buyCard(User user, Card card) {
    	if(mapa.containsKey(user)) {
    		mapa.get(user).add(card);
    	}
    		
    }

}
