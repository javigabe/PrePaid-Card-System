package es.upm.pproject.prePaidCard;

public interface PrePaidCardInterface {
	
	public void createUser(String name, String surname);
	
	public void buyCard(User user, Card card);
	
}
