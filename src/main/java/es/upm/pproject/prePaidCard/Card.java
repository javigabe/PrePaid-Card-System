package es.upm.pproject.prePaidCard;

import java.util.Date;

public class Card {

	long IDnumber;
	Date expirationDate;
	int balance;
	int pin;													//in the user?
	
	//constructor
	public Card(long IDnumber, int balance, int pin) {
		
		this.IDnumber = IDnumber;
		this.balance = balance;
		this.pin = pin;											//add hash function
		expirationDate = new Date();							//Today´s date
		expirationDate.setYear(expirationDate.getYear()+1);		//Plus one year
		
	}
	
	
	public int consultBalance (int pin) {
		
		if (this.pin == pin) {
			return balance;
		}
		return -1;
	
	}
	
	//method to charge some amount of money
	public int charge (int pin, int amount) {
		
		if (this.pin == pin) {
			balance = balance + amount;
			return balance;
		}
		return -1;
		
		
	}
	
	//method to pay some amount of money
	public int pay (int pin, int amount) {
		
		if (this.pin == pin) {
			if (balance >= amount) {	
				balance = balance - amount;
				return balance;
			}
		}
		return -1;
	}
	
	//method to change the pin
	public boolean changePin (int oldPin, int newPin) {
		
		if (this.pin == oldPin) {
			this.pin = newPin;
			return true;
		}
		return false;	
		
	}
	
}
