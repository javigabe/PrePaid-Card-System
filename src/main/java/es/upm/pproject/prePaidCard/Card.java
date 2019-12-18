package es.upm.pproject.prePaidCard;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.security.MessageDigest;
import java.io.*;

public class Card {

	private long IDnumber;
	private int balance;
	private String pin;													//in the user?
	private ArrayList<Event> events;
	private Date expirationDate;
	
	//constructor
	public Card(long IDnumber, int balance, String pin) {
		this.IDnumber = IDnumber;
		this.balance = balance;
		this.pin = cipher(pin);								// hash function
		events = new ArrayList<Event>();
		expirationDate = new Date();							//Today´s date
		expirationDate.setYear(expirationDate.getYear()+1);		//Plus one year
	}
		
	//method to consult the balances
	public int consultBalance (String pin) {
		
		if (this.pin.equals(cipher(pin))) {
			return balance;
		}
		return -1;												//incorrect pin
	}
		
	
	//method to charge some amount of money
	public int charge (String pin, int amount) {
		if (this.pin.equals(cipher(pin))) {
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
	public int pay (String pin, int amount) {
		if (this.pin.equals(cipher(pin))) {
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
	public int changePin (String oldPin, String newPin) {
		if (this.pin.equals(cipher(oldPin))) {
			this.pin = cipher(newPin);
			return 0;
		}
		return -1;												//incorrect pin
	}
	
	//method to consult the movements
	public String consultMovements(String pin) {
		if (this.pin.equals(pin)) {
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

	private String cipher(String passwordToHash)
	{
		String generatedPassword = null;
		try {
			// Create MessageDigest instance for MD5
			MessageDigest md = MessageDigest.getInstance("MD5");
			//Add password bytes to digest
			md.update(passwordToHash.getBytes());
			//Get the hash's bytes
			byte[] bytes = md.digest();
			//This bytes[] has bytes in decimal format;
			//Convert it to hexadecimal format
			StringBuilder sb = new StringBuilder();
			for(int i=0; i< bytes.length ;i++)
			{
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			//Get complete hashed password in hex format
			generatedPassword = sb.toString();
			return generatedPassword;
		}
		catch (NoSuchAlgorithmException e)
		{
			e.printStackTrace();
			return null;
		}
	}
}
