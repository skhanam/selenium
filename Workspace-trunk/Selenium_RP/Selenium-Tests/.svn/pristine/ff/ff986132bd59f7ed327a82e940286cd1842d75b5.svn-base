package uk.co.ratedpeople.test.functional.selenium.lumberjack;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import uk.co.ratedpeople.test.functional.selenium.TestScript;


/**
 * 
 * @author ruhulla.mohammad
 */
public class LJQuickBuyJobTest extends TestScript {

	private LumberJack BuyJob;

	@BeforeClass
	public void beforeClass() {
		BuyJob = new LumberJack(context, scriptUtilities);
	
	}

	@Test(enabled = false) 
	public void QuickBuyJobWithExistingCardTest() {
		BuyJob.testQuickBuyWithExistingCard("prenovpli@ratedtrades.com");
		
	}
	
	@Test(enabled = false) 
	public void QuickBuyJobWithNewCardTest() {
		BuyJob.testQuickBuyWithNewCard("prenovpli@ratedtrades.com");
		
	}
	
}