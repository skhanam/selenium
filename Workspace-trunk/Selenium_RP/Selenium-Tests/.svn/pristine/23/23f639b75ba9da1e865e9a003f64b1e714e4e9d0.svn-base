package uk.co.ratedpeople.test.functional.selenium.lumberjack;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import uk.co.ratedpeople.test.functional.selenium.TestScript;


/**
 * 
 * @author ruhulla.mohammad
 */
public class LJBuyLeadWithAccountBalanceTest extends TestScript {

	private LumberJack BuyLead;

	@BeforeClass
	public void beforeClass() {
		BuyLead = new LumberJack(context, scriptUtilities);
	
	}

	@Test(enabled = true) 
	public void BuyJobFromFullDetailsPageWithAccountBalanceTest() throws Exception {
		BuyLead.testBuyJobFromFullDetailsWithAccBalance("integration.test@ratedtrades.com");
		
	}
	
	@Test(enabled = false) 
	public void QuickBuyJobFromLeadListPageWithAccountBalanceTest() throws Exception {
		BuyLead.testQuickBuyWithAccBalance("integration.test@ratedtrades.com");
		
	}
	
}