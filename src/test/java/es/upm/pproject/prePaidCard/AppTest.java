package es.upm.pproject.prePaidCard;


import java.util.HashMap;
import es.upm.pproject.prePaidCard.model.*;
import org.junit.jupiter.api.*;

/**
 * Unit test for simple App.
 */
public class AppTest {

  private PrePaidCardManager test;

	@BeforeEach
    public void testApp() {
		test = new PrePaidCardManager();
	}

   /* @Test
	public void test1() {
    	Assertions.assertEquals(test.getCards(), new HashMap<>());
	}
	*/
    
    @Test
    public void test2() {
    	test.buyCard("Alvaro", (long) 1000, "1111");
       	Long amount = Long.valueOf(2000);
       	long id = 0;
    	Assertions.assertThrows(NotEnoughMoneyException.class, () -> {test.payCard(id, "1111", amount);});
       	long idExc = 10;
    	Assertions.assertThrows(CardDoesntExistException.class, () -> {test.payCard(idExc, "1111", amount);});
    	//añadir un assertThrows con ExpiredCardException
    }
	
    @Test
    public void test3() throws CardDoesntExistException, ExpiredCardException, NotEnoughMoneyException, WrongPINException {
    	test.buyCard("Alvaro", (long) 1000, "1111");
    	Long amount = Long.valueOf(100);
    	Long result = Long.valueOf(1100);
    	long id = 0;
    	Assertions.assertEquals(result, test.chargeCard(id, "1111", amount));
    	Assertions.assertThrows(WrongPINException.class, () -> {test.chargeCard(id, "111", amount);});
    	long idExc = 10;
    	Assertions.assertThrows(CardDoesntExistException.class, () -> {test.chargeCard(idExc, "1111", amount);});
    	//añadir un assertThrows con ExpiredCardException
    }  
	
    @Test
    public void test4() throws CardDoesntExistException, WrongPINException {
    	test.buyCard("Alvaro", (long) 1000, "1111");
       	long id = 0;
       	Long result = Long.valueOf(1000);
    	Assertions.assertEquals(result, test.consultBalance(id, "1111"));
    	Assertions.assertThrows(WrongPINException.class, () -> {test.consultBalance(id, "1234");});
    	long idExc = 10;
    	Assertions.assertThrows(CardDoesntExistException.class, () -> {test.consultBalance(idExc, "1111");});
    }
    
    @Test
    public void test5() {
    	test.buyCard("Alvaro", (long) 1000, "1111");
       	Integer amount = 400;
       	long id = 0;
    	Assertions.assertThrows(WrongPINException.class, () -> {test.payCard(id, "1011", amount);});
    	long idExc = 17;
    	Assertions.assertThrows(CardDoesntExistException.class, () -> {test.payCard(idExc, "1011", amount);});
    }
    
    @Test
    public void test6() throws CardDoesntExistException, WrongPINException {
    	test.buyCard("Alvaro", (long) 1000, "1111");
       	long id = 0;
    	Assertions.assertThrows(WrongPINException.class, () -> {test.changePin(id, "5612", "9999");});
    	test.changePin(id, "1111", "9999");
    	Long result = Long.valueOf(1000);
    	Assertions.assertEquals(result, test.consultBalance(id, "9999"));
    	long idExc = 3;
    	Assertions.assertThrows(CardDoesntExistException.class, () -> {test.changePin(idExc, "9999", "1111");});
    }
    
    @Test
    public void test7() throws CardDoesntExistException, WrongPINException, ExpiredCardException, NotEnoughMoneyException {
    	test.buyCard("Alvaro", (long) 1000, "1111");
       	long id = 0;
       	Long amount = Long.valueOf(400);
    	test.payCard(id, "1111", amount);
    	String result = "";
    	test.consultMovements(id, "1111");
    	Assertions.assertThrows(WrongPINException.class, () -> {test.consultMovements(id, "111");});
    	long idExc = 3;
    	Assertions.assertThrows(CardDoesntExistException.class, () -> {test.consultMovements(idExc, "1111");});
    }
}
