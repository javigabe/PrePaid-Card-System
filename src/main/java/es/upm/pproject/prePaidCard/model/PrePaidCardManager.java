package es.upm.pproject.prePaidCard.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.File;
import java.util.Iterator;


public class PrePaidCardManager implements PrePaidCardInterface {

    private long cardNumber = 0;
    private HashMap<Long, Card> cards = new HashMap<>();


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
    public void buyCard(String owner, long balance, String pin) {
		Date expirationDate = new Date();
		expirationDate.setYear(expirationDate.getYear()+1);
		Card card = new Card(cardNumber, balance, pin, owner, expirationDate);
		cards.put(cardNumber, card);
		cardNumber++;
    }

    // method to charge money in a card
    public Long chargeCard(Long idNumber, String pin, long amount) throws CardDoesntExistException, ExpiredCardException, WrongPINException {
    	if (!cards.containsKey(idNumber)) {
    		throw new CardDoesntExistException();
		}

		return cards.get(idNumber).charge(pin, amount);
    }

    // method pay with a card
    public Long payCard(Long idNumber, String pin, long amount) throws CardDoesntExistException, ExpiredCardException, NotEnoughMoneyException, WrongPINException {
  		if (!cards.containsKey(idNumber)) {
  			throw new CardDoesntExistException();
  		}

		return cards.get(idNumber).pay(pin, amount);
    }

    // method to change the pin of a card
    public void changePin(Long idNumber, String oldPin, String newPin) throws CardDoesntExistException, WrongPINException {
  		if (!cards.containsKey(idNumber)) {
  			throw new CardDoesntExistException();
  		}

		cards.get(idNumber).changePin(oldPin, newPin);
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


  	private JSONArray getStorageFile() throws IOException {
		JSONParser jsonParser = new JSONParser();

		// Path were our storage file is
		String filePath = new File("").getAbsolutePath().concat("/.data.json");

		File file = new File(filePath);
		if (!file.exists()) {
			file.createNewFile();
		}

		try (FileReader reader = new FileReader(filePath)) {
			// If the file doesnt have anything to read return
			if (!reader.ready()) return null;

			//Read JSON file
			Object obj = jsonParser.parse(reader);
			return (JSONArray) obj;
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
		try {
			JSONArray storage = getStorageFile();
			if (storage == null) return;
			parseCards(storage);
		} catch (java.text.ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
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

	private void storeCard() {
		try {
			JSONArray storage = getStorageFile();
			if (storage == null) return;
			parseCards(storage);
		} catch (java.text.ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
