package es.upm.pproject.prePaidCard;

public interface PrePaidCardInterface {
	
	public User createUser(String name, String surname);
	
    public boolean buyCard(User user, int balance, String pin) throws UserDoesntExistException;
    
    public int chargeCard(User user, long idNumber, String pin, int amount) throws CardDoesntExistException, UserDoesntExistException;
    
    public int payCard(User user, long idNumber, String pin, int amount) throws UserDoesntExistException, CardDoesntExistException;
    
    public int changePin(User user, long idNumber, String oldPin, String newPin) throws UserDoesntExistException, CardDoesntExistException;
	
}
