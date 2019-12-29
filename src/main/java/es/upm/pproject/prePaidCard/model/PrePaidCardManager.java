package es.upm.pproject.prePaidCard.model;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
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
import java.util.logging.Level;
import java.util.logging.Logger;


public class PrePaidCardManager implements PrePaidCardInterface {

    private long cardNumber = 0;
    private HashMap<Long, Card> cards = new HashMap<>();

    private final static Logger LOGGER = Logger.getLogger("Card");

	public PrePaidCardManager() {
		try {
			readJsonFromFile();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
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

		Card card = cards.get(idNumber);
		return card.charge(pin, amount);
    }

    // method pay with a card
    public Long payCard(Long idNumber, String pin, long amount) throws CardDoesntExistException, ExpiredCardException, NotEnoughMoneyException, WrongPINException {
  		if (!cards.containsKey(idNumber)) {
  			throw new CardDoesntExistException();
  		}

		Card card = cards.get(idNumber);
		return card.pay(pin, amount);

    }

    // method to change the pin of a card
    public void changePin(Long idNumber, String oldPin, String newPin) throws CardDoesntExistException, WrongPINException {    //change to boolean?
  		if (!cards.containsKey(idNumber)) {
  			throw new CardDoesntExistException();
  		}

  		Card card = cards.get(idNumber);
  		card.changePin(oldPin, newPin);
    }

    // method to consult the movements of the current session for a card
    public String consultMovements(Long idNumber, String pin) throws CardDoesntExistException, WrongPINException {
  		if (!cards.containsKey(idNumber)) {
  			throw new CardDoesntExistException();
  		}

  		Card card = cards.get(idNumber);
  		return card.consultMovements(pin);

  	}

    // method to consult the balance of a card
  	public Long consultBalance(Long idNumber, String pin) throws CardDoesntExistException, WrongPINException {
  		if (!cards.containsKey(idNumber)) {
  			throw new CardDoesntExistException();
  		}

  		Card card = cards.get(idNumber);
  		return card.consultBalance(pin);
  	}
  	
  	public HashMap<Long, Card> getCards() {
  		return cards;
  	}


	private void readJsonFromFile() throws IOException {
		//JSON parser object to parse read file
		JSONParser jsonParser = new JSONParser();
		String filePath = new File("").getAbsolutePath().concat("/.data.json");

		System.out.println(filePath);

		File file = new File(filePath);
		if (!file.exists()) {
			file.createNewFile();
		}

		try (FileReader reader = new FileReader(filePath))
		{
			//Read JSON file
			Object obj = jsonParser.parse(reader);
			JSONArray jsonfile = (JSONArray) obj;
			parseCards(jsonfile);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (java.text.ParseException e) {
			e.printStackTrace();
		}
	}

	private void parseCards(JSONArray cards) throws java.text.ParseException {
		for (Object cardObj : cards) {
			JSONObject card = (JSONObject) cardObj;
			Long cardNumber = (Long) card.get("number");
			String owner = (String) card.get("owner");
			String pin = (String) card.get("pin");
			Long balance = (Long) card.get("balance");
			String date = (String) card.get("expDate");
			Date expirationDate = new SimpleDateFormat("dd/MM/yyyy").parse(date);

			Card storedCard = new Card(cardNumber, balance, pin, owner, expirationDate);
			this.cards.put(cardNumber, storedCard);
		}
	}
}
