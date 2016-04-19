package uk.co.ratedpeople.test.functional.selenium.tp;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import uk.co.ratedpeople.test.functional.selenium.TestScript;
import uk.co.ratedpeople.test.functional.selenium.tp.functions.PurchaseJobWithExistingCard;

public class ViewPurchasedJob extends TestScript {

	private PurchaseJobWithExistingCard purchaseJob;

	@BeforeClass
	public void beforeClass() throws IOException {
		purchaseJob = new PurchaseJobWithExistingCard(this.context, scriptUtilities);		
	}

	@Test(enabled=false)
	public void testViewPurchasedJob() throws Exception {
		purchaseJob.purchaseJobWithExistingCard();
		scriptUtilities.click(By.linkText("Purchased Jobs"));
		scriptUtilities.click(By.linkText("View details"));
	}
}