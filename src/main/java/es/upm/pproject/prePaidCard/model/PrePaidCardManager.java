package es.upm.pproject.prePaidCard.model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.File;
import java.util.Iterator;
import java.util.logging.Logger;
import java.util.logging.Level;


public class PrePaidCardManager implements PrePaidCardInterface {

    private long cardNumber = 0;
    private HashMap<Long, Card> cards = new HashMap<>();
	private final static Logger LOGGER = Logger.getLogger("Card");


	public PrePaidCardManager() {
		readJsonFromFile();
		/*Iterator it = cards.keySet().iterator();
		while (it.hasNext()) {
			Long id = (Long) it.next();
			Card card = cards.get(id);
			System.out.println(card.events);
		}
		*/

    }

    public static void main(String [] args) {
		PrePaidCardManager pre = new PrePaidCardManager();
	}


    // method to register a new card for a user
    public void buyCard(String owner, long balance, String pin) throws WrongPINException {
		if (pin.length() != 4) {
			throw new WrongPINException();
		}

		Date expirationDate = new Date();
		expirationDate.setYear(expirationDate.getYear()+1);
		Card card = new Card(cardNumber, balance, pin, owner, expirationDate);
		cards.put(cardNumber, card);
		storeCard(cardNumber, owner, balance, pin, expirationDate);
		cardNumber++;
    }

    // method to charge money in a card
    public void chargeCard(Long idNumber, String pin, long amount) throws CardDoesntExistException, ExpiredCardException, WrongPINException {
    	if (!cards.containsKey(idNumber)) {
    		throw new CardDoesntExistException();
		}

		Date date = new Date();
		cards.get(idNumber).charge(pin, amount, date);
		changeStoredBalance(idNumber, amount);
		addStoredEvent(idNumber, date, amount);
    }

    // method pay with a card
    public void payCard(Long idNumber, String pin, long amount) throws CardDoesntExistException, ExpiredCardException, NotEnoughMoneyException, WrongPINException {
  		if (!cards.containsKey(idNumber)) {
  			throw new CardDoesntExistException();
  		}

  		Date date = new Date();
		cards.get(idNumber).pay(pin, amount, date);
		changeStoredBalance(idNumber, -amount);
		addStoredEvent(idNumber, date, -amount);
	}

    // method to change the pin of a card
    public void changePin(Long idNumber, String oldPin, String newPin) throws CardDoesntExistException, WrongPINException {
  		if (!cards.containsKey(idNumber)) {
  			throw new CardDoesntExistException();
  		}

  		if (newPin.length() != 4) {
  			throw new WrongPINException();
		}

		cards.get(idNumber).changePin(oldPin, newPin);
  		changeStoredPIN(idNumber, newPin);
    }

    // method to consult the movements of the current session for a card
    public String consultMovements(Long idNumber, String pin) throws CardDoesntExistException, WrongPINException {
  		if (!cards.containsKey(idNumber)) {
  			throw new CardDoesntExistException();
  		}

  		return cards.get(idNumber).consultMovements(pin);
  	}

    // method to consult the balance of a card
  	public Long consultBalance(Long idNumber, String pin) throws CardDoesntExistException, WrongPINException {
  		if (!cards.containsKey(idNumber)) {
  			throw new CardDoesntExistException();
  		}

  		return cards.get(idNumber).consultBalance(pin);
  	}
  	
  	public HashMap<Long, Card> getCards() {
  		return cards;
  	}


  	private String getFilePath() {
		// Path were our storage file is
		String filePath = new File("").getAbsolutePath().concat("/.data.json");

		File file = new File(filePath);
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return filePath;
	}

	private JSONArray getStorage(String filePath) {
		JSONParser jsonParser = new JSONParser();

		try (FileReader reader = new FileReader(filePath)) {
			// If the file doesnt have anything to read return
			if (!reader.ready()) return null;
			return (JSONArray) jsonParser.parse(reader);

		} catch (ParseException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}


	private void readJsonFromFile() {
		// Path were our storage file is
		String filePath = getFilePath();
		try {
			JSONArray storage = getStorage(filePath);
			if (storage == null) return;
			parseCards(getStorage(filePath));
		} catch (java.text.ParseException e) {
			e.printStackTrace();
		}
	}

	private void parseCards(JSONArray cards) throws java.text.ParseException {
		for (Object cardObj : cards) {
			// JSON object contaning the fields of the card
			JSONObject card = (JSONObject) cardObj;

			// We parse all the fields of the card
			Long cardNumber = (Long) card.get("number");
			String owner = (String) card.get("owner");
			String pin = (String) card.get("pin");
			Long balance = (Long) card.get("balance");
			String date = (String) card.get("expDate");
			Date expirationDate = new SimpleDateFormat("dd/MM/yyyy").parse(date);

			Card storedCard = new Card(cardNumber, balance, pin, owner, expirationDate);

			// Parses all the events of the card and stores them in the events array
			JSONArray cardEvents = (JSONArray) card.get("events");
			parseCardEvents(cardEvents, storedCard);

			this.cards.put(cardNumber, storedCard);
		}
	}

	private void parseCardEvents(JSONArray cardEvents, Card card) throws java.text.ParseException {
		for (Object eventObj: cardEvents) {
			JSONObject event = (JSONObject) eventObj;
			String date = (String) event.get("date");
			Date eventDate = new SimpleDateFormat("dd/MM/yyyy").parse(date);
			Long amount = (Long) event.get("amount");
			addEvent(card, eventDate, amount);
		}
	}

	private void addEvent(Card card, Date date, long amount) {
		card.events.add(new Event(date, amount));
	}

	private void storeCard(long number, String owner, long balance, String pin, Date expirationDate) {
		String filePath = getFilePath();

		SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
		String date = DATE_FORMAT.format(expirationDate);

		JSONObject card = new JSONObject();
		card.put("number", number);
		card.put("owner", owner);
		card.put("balance", balance);
		card.put("pin", cipher(pin));
		card.put("expDate", date);
		card.put("events", new JSONArray());

		JSONArray storage = getStorage(filePath);

		try (FileWriter file = new FileWriter(filePath)) {
			storage.add(card);
			file.write(storage.toJSONString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void changeStoredBalance(Long cardNumber, Long amount) {
		String filePath = getFilePath();
		JSONArray storage = getStorage(filePath);

		for (Object cardObj: storage) {
			JSONObject card = (JSONObject) cardObj;
			Long cardID = (Long) card.get("number");
			if (!cardID.equals(cardNumber)) continue;
			Long balance = (Long) card.get("balance");
			card.put("balance", balance + amount);
		}

		try (FileWriter file = new FileWriter(filePath)) {
			file.write(storage.toJSONString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void changeStoredPIN(Long cardNumber, String newPin) {
		String filePath = getFilePath();
		JSONArray storage = getStorage(filePath);

		for (Object cardObj: storage) {
			JSONObject card = (JSONObject) cardObj;
			Long cardID = (Long) card.get("number");
			if (!cardID.equals(cardNumber)) continue;
			card.put("pin", cipher(newPin));
		}

		try (FileWriter file = new FileWriter(filePath)) {
			file.write(storage.toJSONString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void addStoredEvent(Long cardNumber, Date eventDate, Long amount) {
		String filePath = getFilePath();
		JSONArray storage = getStorage(filePath);

		SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
		String date = DATE_FORMAT.format(eventDate);

		JSONObject event = new JSONObject();
		event.put("date", date);
		event.put("amount", amount);

		for (Object cardObj: storage) {
			JSONObject card = (JSONObject) cardObj;
			Long cardID = (Long) card.get("number");
			if (!cardID.equals(cardNumber)) continue;
			JSONArray events = (JSONArray) card.get("events");
			events.add(event);
		}

		try (FileWriter file = new FileWriter(filePath)) {
			file.write(storage.toJSONString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


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
