package es.upm.pproject.prePaidCard;

public interface PrePaidCardInterface {
	
	public User createUser(String name, String surname);
	
    public boolean buyCard(User user, int balance, int pin);
    
    public int chargeCard(User user, long idNumber, int pin, int amount);
    
    public int payCard(User user, long idNumber, int pin, int amount);
    
    public int changePin(User user, long idNumber, int oldPin, int newPin);
	
}
