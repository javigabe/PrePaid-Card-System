package es.upm.pproject.prePaidCard;

public interface PrePaidCardInterface {
	
	public void createUser(String name, String surname);
	
	public boolean buyCard(User user, Card card);
	
}
