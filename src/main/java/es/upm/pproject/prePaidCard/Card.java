package es.upm.pproject.prePaidCard;

import java.util.ArrayList;
import java.util.Date;

public class Card {

	long IDnumber;
	int balance;
	int pin;													//in the user?
	ArrayList<Event> events;
	Date expirationDate;
	
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
		Date today = new Date();
		if (today.before(expirationDate)) {
			if (this.pin == pin) {
				return balance;
			}
			return -2;											//incorrect pin
		}
		return -1;												//expired card
	}
	
	//method to charge some amount of money
	public int charge (int pin, int amount) {
		Date today = new Date();
		if (today.before(expirationDate)) {
			if (this.pin == pin) {
				balance = balance + amount;
				events.add(new Event(today,amount));
				return balance;
			}
			return -2;											//incorrect pin
		}
		return -1;												//expired card
	}
	
	//method to pay some amount of money
	public int pay (int pin, int amount) {
		Date today = new Date();
		if (today.before(expirationDate)) {
			if (this.pin == pin) {
				if (balance >= amount) {	
					balance = balance - amount;
					events.add(new Event(today,-amount));
					return balance;
				}
				return -3;										//not enough money
			}
			return -2;											//incorrect pin
		}
		return -1;												//expired card
	}
	
	//method to change the pin
	public int changePin (int oldPin, int newPin) {
		Date today = new Date();
		if (today.before(expirationDate)) {
			if (pin == oldPin) {
				pin = newPin;
				return 0;
			}
			return -2;											//incorrect pin
		}
		return -1;												//expired card
	}
	
	//method to consult the movements
	public String consultMovements(int pin) {
		Date today = new Date();
		if (today.before(expirationDate)) {
			if (this.pin == pin) {
				return events.toString();
			}
			return "incorrect pin";								//incorrect pin
		}
		return "incorrect card";								//expired card
	}
}
