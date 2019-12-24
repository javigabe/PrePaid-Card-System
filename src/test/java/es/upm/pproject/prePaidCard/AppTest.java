package es.upm.pproject.prePaidCard;


import java.util.HashMap;

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

    @Test
	public void test1() {
    	Assertions.assertEquals(new HashMap<>(), test.getCards());
	}
    
    @Test
    public void test2() throws CardDoesntExistException, ExpiredCardException, NotEnoughMoneyException, WrongPINException {
    	test.buyCard("Alvaro", 1000, "1111");
    	Integer amount = 100;
    	Integer result = 900;
    	long id = 0;
    	Assertions.assertEquals(result, test.payCard(id, "1111", amount));
	}  
	
    @Test
    public void test3() throws CardDoesntExistException, ExpiredCardException, NotEnoughMoneyException, WrongPINException {
    	test.buyCard("Alvaro", 1000, "1111");
    	Integer amount = 100;
    	Integer result = 1100;
    	long id = 0;
    	Assertions.assertEquals(result, test.chargeCard(id, "1111", amount));
	}  
	
    @Test
    public void test4() {
       	Integer amount = 1000;
       	long id = 10;
    	Assertions.assertThrows(CardDoesntExistException.class, () -> {test.payCard(id, "1111", amount);});
    }
    
    @Test
    public void test5() {
    	test.buyCard("Alvaro", 1000, "1111");
       	Integer amount = 2000;
       	long id = 0;
    	Assertions.assertThrows(NotEnoughMoneyException.class, () -> {test.payCard(id, "1111", amount);});
    }
    
    @Test
    public void test6() {
    	test.buyCard("Alvaro", 1000, "1111");
       	Integer amount = 400;
       	long id = 0;
    	Assertions.assertThrows(WrongPINException.class, () -> {test.payCard(id, "1011", amount);});
    }
    
    @Test
    public void test7() {
    	test.buyCard("Alvaro", 1000, "1111");
       	Integer amount = 400;
       	long id = 0;
    	Assertions.assertThrows(WrongPINException.class, () -> {test.payCard(id, "1011", amount);});
    }
}
