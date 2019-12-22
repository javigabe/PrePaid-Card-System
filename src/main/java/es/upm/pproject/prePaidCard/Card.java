package es.upm.pproject.prePaidCard;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.security.MessageDigest;
import java.io.*;

public class Card {

	private Long IDnumber;
	Integer balance;
	private String pin;													//in the user?
	private ArrayList<Event> events;
	private Date expirationDate;
	private String owner;
	
	//constructor
	public Card(Long IDnumber, Integer balance, String pin, String owner) {
		this.IDnumber = IDnumber;
		this.balance = balance;
		this.pin = cipher(pin);									// hash function
		this.owner = owner;
		events = new ArrayList<>();
		expirationDate = new Date();							//Today´s date
		expirationDate.setYear(expirationDate.getYear()+1);		//Plus one year
	}
		
	//method to consult the balances
	public Integer consultBalance (String pin) throws WrongPINException {
		
		if (!checkPin(pin)) {
			throw new WrongPINException();												//incorrect pin
		}
		else {
			return balance;
		}
	}
		
	
	//method to charge some amount of money
	public Integer charge (String pin, Integer amount) throws ExpiredCardException, WrongPINException {
		if (!checkPin(pin)) {
			throw new WrongPINException();		// wrong pin
		}
		else {
			Date today = new Date();
			if (today.before(expirationDate)) {
				balance = balance + amount;
				events.add(new Event(today,amount));
				return balance;
			}
			else {
				throw new ExpiredCardException();  // the card has expired
			}
		}
	}
	
	//method to pay some amount of money
	public Integer pay (String pin, Integer amount) throws WrongPINException, NotEnoughMoneyException, ExpiredCardException {
		if (!checkPin(pin)) {
			throw new WrongPINException();
		}
		else {
			Date today = new Date();
			if (today.before(expirationDate)) {
				if (balance >= amount) {
					balance = balance - amount;
					events.add(new Event(today,-amount));
					return balance;
				}
				else throw new NotEnoughMoneyException(); 		// not enough money
			}
			else throw new ExpiredCardException();			// the card has expired
		}
	}
	
	//method to change the pin
	public void changePin (String oldPin, String newPin) throws WrongPINException {
		if (!checkPin(oldPin)) {
			throw new WrongPINException();
		}
		else {
			this.pin = newPin;
		}
	}
	
	//method to consult the movements
	public String consultMovements(String pin) throws WrongPINException {
		if (!checkPin(pin)) {
			throw new WrongPINException();
		}
		else {
			String movements = "";
			for (int i = 0; i < events.size(); i++) {
				movements += events.get(i).print();
			}
			return movements;
		}
	}
	
	//get idNumber
	public Long getId() { return IDnumber; }


	private boolean checkPin(String pin) {
		return pin.equals(cipher(this.pin));
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
