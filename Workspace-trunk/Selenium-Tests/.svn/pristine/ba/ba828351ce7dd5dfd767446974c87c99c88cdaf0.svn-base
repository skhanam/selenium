package uk.co.ratedpeople.test.functional.selenium.tmmobile;

import java.math.BigDecimal;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import uk.co.ratedpeople.test.functional.selenium.TestScript;
import uk.co.ratedpeople.test.functional.selenium.tmmobile.functions.TestFunctionsJBilling;

public class JBillingUserUpdatesTest extends TestScript {

	private WebDriver driver;
	private TestFunctionsJBilling testFunctions;

	@BeforeClass
	public void beforeClass() throws Exception {
		driver = context.driver;
		testFunctions = new TestFunctionsJBilling(driver);
	}

	@Test(enabled = true)
	public void testSetAccountBalance() throws Exception {
		testFunctions.setAccountBalance(this.context, 1084, new BigDecimal("50.0000000000"), new BigDecimal("0.0"), new BigDecimal("0.0"));
	}

	@Test(enabled = true)
	public void testRemoveAllCardsForTradesman() throws Exception {
		testFunctions.removeAllCardsForTradesman(this.context, 1084);
	}

	@Test(enabled = true)
	public void testAddCardForTradesman() throws Exception {
		testFunctions.addCardForTradesman(this.context, 1084, "integration.test.payment.request", "4929 0000 0000 6", "12", 2015, 123);
	}
}
