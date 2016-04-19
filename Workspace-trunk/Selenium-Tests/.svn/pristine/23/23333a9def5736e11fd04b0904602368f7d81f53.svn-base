package uk.co.ratedpeople.test.functional.selenium.lumberjack;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import uk.co.ratedpeople.test.functional.selenium.TestScript;


/**
 * 
 * @author ruhulla.mohammad
 */
public class LJBuyLeadFromFullDetailsTest extends TestScript {

	private LumberJack BuyJob;

	@BeforeClass
	public void beforeClass() {
		BuyJob = new LumberJack(context, scriptUtilities);
	
	}

	@Test(enabled = false) 
	public void BuyJobFromFullDetailsPageExistingCardTest() throws Exception {
		BuyJob.testBuyLeadFromFullDetailsWithExistingCard("prenovpli@ratedtrades.com");
		
	}
	
	@Test(enabled = true) 
	public void BuyJobFromFullDetailsPageNewCardTest() throws Exception {
		BuyJob.testBuyLeadFromFullDetailsWithNewCard("prenovpli@ratedtrades.com");
		
	}
	
}