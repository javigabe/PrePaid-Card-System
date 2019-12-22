package es.upm.pproject.prePaidCard;

public interface PrePaidCardInterface {
	
	//public User createUser(String name, String surname);
    //public void signIn(Long cardNumber, String pin) throws WrongPINException;
	
    public void buyCard(String owner, Integer balance, String pin);
    
    public Integer chargeCard(String owner, Long idNumber, String pin, Integer amount) throws CardDoesntExistException;
    
    public Integer payCard(String owner, Long idNumber, String pin, Integer amount) throws  CardDoesntExistException;
    
    public void changePin(String owner, Long idNumber, String oldPin, String newPin) throws CardDoesntExistException, WrongPINException;
	
}
