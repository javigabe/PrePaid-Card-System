package es.upm.pproject.prePaidCard;


import java.time.Instant;
import java.time.ZoneId;
import java.util.HashMap;
import es.upm.pproject.prePaidCard.model.*;
import org.junit.jupiter.api.*;
import java.time.Clock;
import java.time.ZoneOffset;

/**
 * Unit test for simple App.
 */
public class AppTest {

  private PrePaidCardManager test;

	@BeforeEach
    public void testApp() {
		test = new PrePaidCardManager(false);
	}

    @Test
	public void test1() {
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
<<<<<<< HEAD
    	Assertions.assertThrows(WrongPINException.class, () -> {test.consultBalance(id, "1234");});
       	long idExc = Long.valueOf(1000000);
||||||| merged common ancestors
    	Assertions.assertThrows(WrongPINException.class, () -> {test.consultBalance(id, "1234");});
    	long idExc = 10000000;
=======
		Assertions.assertThrows(WrongPINException.class, () -> {test.buyCard("jesus", (long) 1000, "11111");});
		Assertions.assertThrows(WrongPINException.class, () -> {test.consultBalance(id, "1234");});
    	long idExc = 10000000;
>>>>>>> Added bool to manager construct
    	Assertions.assertThrows(CardDoesntExistException.class, () -> {test.consultBalance(idExc, "1111");});
    }

    @Test
    public void test5() throws WrongPINException {
		long id = test.buyCard("Alvaro", (long) 1000, "1111");
       	Integer amount = 400;
    	Assertions.assertThrows(WrongPINException.class, () -> {test.payCard(id, "1011", amount);});
<<<<<<< HEAD
       	long idExc = Long.valueOf(1000000);
||||||| merged common ancestors
    	long idExc = 10000000;
=======
		Assertions.assertThrows(WrongPINException.class, () -> {test.changePin(id, "1111", "11111");});

		long idExc = 10000000;
>>>>>>> Added bool to manager construct
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
}
