package es.upm.pproject.prePaidCard;

import java.util.ArrayList;
import java.util.Date;

public class Card {

	private long IDnumber;
	private int balance;
	private int pin;													//in the user?
	private ArrayList<Event> events;
	private Date expirationDate;
	
	//constructor
	public Card(long IDnumber, int balance, int pin) {
		this.IDnumber = IDnumber;
		this.balance = balance;
		this.pin = pin;											//add hash function
		events = new ArrayList<Event>();
		expirationDate = new Date();							//Today´s date
		expirationDate.setYear(expirationDate.getYear()+1);		//Plus one year
	}
		
	//method to consult the balances
	public int consultBalance (int pin) {
		
		if (this.pin == pin) {
			return balance;
		}
		return -1;												//incorrect pin
	}
		
	
	//method to charge some amount of money
	public int charge (int pin, int amount) {
		if (this.pin == pin) {	
			Date today = new Date();
			if (today.before(expirationDate)) {
				balance = balance + amount;
				events.add(new Event(today,amount));
				return balance;
			}
			return -2;											//expired card
		}
		return -1;												//incorrect pin
	}
	
	//method to pay some amount of money
	public int pay (int pin, int amount) {
		if (this.pin == pin) {
			Date today = new Date();
			if (today.before(expirationDate)) {
				if (balance >= amount) {	
					balance = balance - amount;
					events.add(new Event(today,-amount));
					return balance;
				}
				return -3;										//not enough money
			}
			return -2;											//expired card
		}
		return -1;												//incorrect pin
	}
	
	//method to change the pin
	public int changePin (int oldPin, int newPin) {
		if (pin == oldPin) {
			pin = newPin;
			return 0;
		}
		return -1;												//incorrect pin
	}
	
	//method to consult the movements
	public String consultMovements(int pin) {
		if (this.pin == pin) {
			String print = "";
			for (int i = 0; i < events.size(); i++) {
				print += events.get(i).print();
			}
			return print;
		}
		return "Incorrect pin";									//incorrect pin
	}
	
	//get idNumber
	public long getId() {
		return IDnumber;
	}
}
