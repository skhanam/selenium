package uk.co.ratedpeople.test.functional.selenium.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import uk.co.ratedpeople.test.functional.selenium.TestScript;
import uk.co.ratedpeople.test.functional.selenium.functions.BuyJob;

public class BuyLeadExistingCardTest extends TestScript {
	private BuyJob underTest;

	@BeforeClass
	public void beforeClass() {
		underTest = new BuyJob(this.context, scriptUtilities);		
	}

	@Test (enabled=true)
	public void buyLeadExistingCardTest() throws Exception {
		underTest.buyLeadExistingCardNoBalance("sangitmtestuser@ratedtrades.com");

	}
}
