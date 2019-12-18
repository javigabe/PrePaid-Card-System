package es.upm.pproject.prePaidCard;

public interface PrePaidCardInterface {
	
	public User createUser(String name, String surname);
	
    public boolean buyCard(User user, int balance, String pin);
    
    public int chargeCard(User user, long idNumber, String pin, int amount);
    
    public int payCard(User user, long idNumber, String pin, int amount);
    
    public int changePin(User user, long idNumber, String oldPin, String newPin);
	
}
