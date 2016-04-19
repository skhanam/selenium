package uk.co.ratedpeople.test.functional.selenium.fake.postcode;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import uk.co.ratedpeople.test.functional.selenium.TestScript;

public class PurchaseJobViewFakePostCode extends TestScript {
	private PurchaseJob purchaseJob;

	@BeforeClass
	public void beforeClass() throws IOException {
		purchaseJob = new PurchaseJob(this.context, scriptUtilities);
	}

	@Test(enabled=false) 
	public void testPurchaseAJobInAFakePostCode() throws IOException {
		purchaseJob.purchaseJobWithinAFakePostCode();
	}

}
