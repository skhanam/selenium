package uk.co.ratedpeople.test.functional.selenium.tmmobile;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import uk.co.ratedpeople.test.functional.selenium.TestScript;

public class LoginToJBillingTest extends TestScript {

	private LoginToJBilling loginToJBilling;

	@BeforeClass
	public void beforeClass() throws Exception {
		loginToJBilling = new LoginToJBilling(this.context);

	}

	@Test(enabled = true)
	public void testLoginToJBilling() throws Exception {
		loginToJBilling.login();
	}
}
