package uk.co.ratedpeople.test.functional.selenium.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import uk.co.ratedpeople.test.functional.selenium.TestScript;
import uk.co.ratedpeople.test.functional.selenium.functions.BuyJob;

public class BuyLeadNewCardTest extends TestScript {
	private BuyJob underTest;

	@BeforeClass
	public void beforeClass() {
		underTest = new BuyJob(this.context, scriptUtilities);		
	}

	@Test(enabled=true)
	public void buyLeadNewCard() throws Exception {
		underTest.buyLeadNewCard("sangitmtestuser@ratedtrades.com");
	}
}
