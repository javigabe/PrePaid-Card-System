package es.upm.pproject.prePaidCard.model;

import java.util.ArrayList;
import java.util.Date;

public class Card {

	private Long idNumber;
	private Long balance;
	private String pin;
	ArrayList<Event> events;
	private Date expirationDate;
	private String owner;
	private Cipher cipherMethod = new Cipher();

	public Card(Long idNumber, Long balance, String pin, String owner, Date expirationDate) {
		this.idNumber = idNumber;
		this.balance = balance;
		this.pin = pin;
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
	public void charge (String pin, long amount, Date date) throws ExpiredCardException, WrongPINException {
		if (!checkPin(pin)) {
			throw new WrongPINException();		// wrong pin
		}

		if (!date.before(expirationDate)) {
			throw new ExpiredCardException();
		}

		balance += amount;
		events.add(new Event(date,amount));
	}

	// method to pay some amount of money
	public void pay (String pin, long amount, Date date) throws WrongPINException, NotEnoughMoneyException, ExpiredCardException {
		if (!checkPin(pin)) {
			throw new WrongPINException();
		}

		if (!date.before(expirationDate)) {
			throw new ExpiredCardException();
		}
		if (balance < amount) {
			throw new NotEnoughMoneyException();
		}

		balance = balance - amount;
		events.add(new Event(date,-amount));
	}

	// method to change the pin
	public void changePin (String oldPin, String newPin) throws WrongPINException {
		if (!checkPin(oldPin)) {
			throw new WrongPINException();
		}

		this.pin = cipherMethod.cipher(newPin);
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
		return idNumber;
	}

	public Long getBalance() {
		return balance;
	}

	public String getOwner() {
		return owner;
	}

	private boolean checkPin(String pin) {
		return this.pin.equals(cipherMethod.cipher(pin));
	}
}
