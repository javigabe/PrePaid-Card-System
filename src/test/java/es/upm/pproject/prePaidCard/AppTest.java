package es.upm.pproject.prePaidCard;


import java.util.Date;
import java.util.HashMap;
import es.upm.pproject.prePaidCard.model.*;
import org.junit.jupiter.api.*;

/**
 * Unit test for simple App.
 */
public class AppTest {

  	private PrePaidCardManager test;
  	private Cipher cipherMethod = new Cipher();


	@BeforeEach
    public void testApp() {
		test = new PrePaidCardManager(true);
	}

    @Test
	public void test1() {
		test = new PrePaidCardManager(false);
		Assertions.assertEquals(test.getCards(), new HashMap<>());
	}

    @Test
    public void test2() throws WrongPINException {
    	Assertions.assertThrows(WrongPINException.class, () -> {test.buyCard("Alvaro", (long) 1000, "11111");});
		long id = test.buyCard("Alvaro", (long) 1000, "1111");
       	Long amount = Long.valueOf(2000);
    	Assertions.assertThrows(NotEnoughMoneyException.class, () -> {test.payCard(id, "1111", amount);});
       	long idExc = Long.valueOf(1000000);
    	Assertions.assertThrows(CardDoesntExistException.class, () -> {test.payCard(idExc, "1111", amount);});
	}

    @Test
    public void test3() throws CardDoesntExistException, ExpiredCardException, NotEnoughMoneyException, WrongPINException {
		long id = test.buyCard("Alvaro", (long) 1000, "1111");
    	Long amount = Long.valueOf(100);
    	Long result = Long.valueOf(1100);
		test.chargeCard(id, "1111", amount);
    	Assertions.assertEquals(result, test.consultBalance(id, "1111"));
    	Assertions.assertThrows(WrongPINException.class, () -> {test.chargeCard(id, "111", amount);});
       	long idExc = Long.valueOf(1000000);
    	Assertions.assertThrows(CardDoesntExistException.class, () -> {test.chargeCard(idExc, "1111", amount);});
    	//añadir un assertThrows con ExpiredCardException
    }

    @Test
    public void test4() throws CardDoesntExistException, WrongPINException {
       	long id = test.buyCard("Alvaro", (long) 1000, "1111");
       	Long result = Long.valueOf(1000);
    	Assertions.assertEquals(result, test.consultBalance(id, "1111"));
    	Assertions.assertThrows(WrongPINException.class, () -> {test.consultBalance(id, "1234");});
       	long idExc = Long.valueOf(1000000);
    	Assertions.assertThrows(WrongPINException.class, () -> {test.consultBalance(id, "1234");});
		Assertions.assertThrows(WrongPINException.class, () -> {test.buyCard("jesus", (long) 1000, "11111");});
		Assertions.assertThrows(WrongPINException.class, () -> {test.consultBalance(id, "1234");});
    	Assertions.assertThrows(CardDoesntExistException.class, () -> {test.consultBalance(idExc, "1111");});
    }

    @Test
    public void test5() throws WrongPINException {
		long id = test.buyCard("Alvaro", (long) 1000, "1111");
       	Integer amount = 400;
    	Assertions.assertThrows(WrongPINException.class, () -> {test.payCard(id, "1011", amount);});
       	long idExc = Long.valueOf(1000000);
		Assertions.assertThrows(WrongPINException.class, () -> {test.changePin(id, "1111", "11111");});
    	Assertions.assertThrows(CardDoesntExistException.class, () -> {test.payCard(idExc, "1011", amount);});
    }

    @Test
    public void test6() throws CardDoesntExistException, WrongPINException {
       	long id = test.buyCard("Alvaro", (long) 1000, "1111");
    	Assertions.assertThrows(WrongPINException.class, () -> {test.changePin(id, "1111", "99999");});
    	Assertions.assertThrows(WrongPINException.class, () -> {test.changePin(id, "5612", "9999");});
    	test.changePin(id, "1111", "9999");
    	Long result = Long.valueOf(1000);
    	Assertions.assertEquals(result, test.consultBalance(id, "9999"));
       	long idExc = Long.valueOf(1000000);
    	Assertions.assertThrows(CardDoesntExistException.class, () -> {test.changePin(idExc, "9999", "1111");});
    }

    @Test
    public void test7() throws CardDoesntExistException, WrongPINException, ExpiredCardException, NotEnoughMoneyException {
		long id = test.buyCard("Alvaro", (long) 1000, "1111");
       	Long amount = Long.valueOf(400);
    	test.payCard(id, "1111", amount);
    	test.consultMovements(id, "1111");
    	Assertions.assertThrows(WrongPINException.class, () -> {test.consultMovements(id, "111");});
       	long idExc = Long.valueOf(1000000);
    	Assertions.assertThrows(CardDoesntExistException.class, () -> {test.consultMovements(idExc, "1111");});
    }

    @Test
    public void test8() throws WrongPINException {
	  test = new PrePaidCardManager(false);
      test.buyCard("javi", 200, "1111");

      if (!test.getCards().isEmpty()){
        Card card = test.getCards().get(Long.valueOf(0));
        Assertions.assertEquals(card.getId(),Long.valueOf(0));
        Assertions.assertEquals(card.getOwner(),"javi");
        Assertions.assertEquals(card.getBalance(),Long.valueOf(200));
      }
    }

    @Test
    public void test9() throws WrongPINException, ExpiredCardException, CardDoesntExistException, NotEnoughMoneyException {
		Card card = new Card((long) 0, (long) 200, cipherMethod.cipher("1111"), "date date", new Date());
		Date exDate = new Date();
		exDate.setYear(exDate.getYear() + 2);
		Assertions.assertThrows(ExpiredCardException.class, () -> {card.pay("1111", (long) 10, exDate);});
		Assertions.assertThrows(ExpiredCardException.class, () -> {card.charge("1111", (long) 10, exDate);});
	}
}
