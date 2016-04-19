package uk.co.ratedpeople.test.functional.selenium.tp;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import uk.co.ratedpeople.test.functional.selenium.TestScript;
import uk.co.ratedpeople.test.functional.selenium.tp.functions.PurchaseJobWithExistingCard;

public class PurchaseJobWithExistingCardTest extends TestScript {
	
	private PurchaseJobWithExistingCard purchaseJob;
	
	@BeforeClass
	public void beforeClass() throws IOException {
		purchaseJob = new PurchaseJobWithExistingCard(this.context, scriptUtilities);		
	}
	
	@Test
	public void testPurchaseJobWithExistingCard() throws Exception {
		purchaseJob.purchaseJobWithExistingCard();
	}
	
}