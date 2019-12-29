package es.upm.pproject.prePaidCard.model;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.security.MessageDigest;
import java.io.*;
import java.util.logging.Logger;
import java.util.logging.Level;



public class Card {

	private Long IDnumber;
	private Long balance;
	private String pin;
	ArrayList<Event> events;
	private Date expirationDate;
	private String owner;

	private final static Logger LOGGER = Logger.getLogger("Card");


	public Card(Long IDnumber, Long balance, String pin, String owner, Date expirationDate) {
		this.IDnumber = IDnumber;
		this.balance = balance;
		this.pin = cipher(pin);
		this.owner = owner;
		events = new ArrayList<>();
		this.expirationDate = expirationDate;
	}

	// method to consult the balances
	public Long consultBalance (String pin) throws WrongPINException {
		if (!checkPin(pin)) {
			throw new WrongPINException();						//incorrect pin
		}

		return balance;
	}


	// method to charge some amount of money
	public Long charge (String pin, long amount) throws ExpiredCardException, WrongPINException {
		if (!checkPin(pin)) {
			throw new WrongPINException();		// wrong pin
		}

		Date today = new Date();
		if (!today.before(expirationDate)) {
			throw new ExpiredCardException();
		}

		balance += amount;
		events.add(new Event(today,amount));
		return balance;
	}

	// method to pay some amount of money
	public Long pay (String pin, long amount) throws WrongPINException, NotEnoughMoneyException, ExpiredCardException {
		if (!checkPin(pin)) {
			throw new WrongPINException();
		}

		Date today = new Date();

		if (!today.before(expirationDate)) {
			throw new ExpiredCardException();
		}
		if (balance < amount) {
			throw new NotEnoughMoneyException();
		}

		balance = balance - amount;
		events.add(new Event(today,-amount));
		return balance;
	}

	// method to change the pin
	public void changePin (String oldPin, String newPin) throws WrongPINException {
		if (!checkPin(oldPin)) {
			throw new WrongPINException();
		}

		this.pin = cipher(newPin);
	}

	// method to consult the movements
	public String consultMovements(String pin) throws WrongPINException {
		if (!checkPin(pin)) {
			throw new WrongPINException();
		}

		StringBuilder movements = new StringBuilder();
		for (int i = 0; i < events.size(); i++) {
			movements.append(events.get(i).toString());
		}
		return movements.toString();
	}

	public Long getId() {
		return IDnumber;
	}
	
	public String getOwner() {
		return owner;
	}

	private boolean checkPin(String pin) {
		return this.pin.equals(cipher(pin));
	}


	//hash function
	private String cipher(String passwordToHash) {
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
			return sb.toString();
		}
		catch (NoSuchAlgorithmException e)
		{
			LOGGER.log(Level.SEVERE, "Fallo en cifrado");
			return null;
		}
	}
}
