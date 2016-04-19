package uk.co.ratedpeople.test.functional.selenium.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import uk.co.ratedpeople.test.functional.selenium.TestScript;
import uk.co.ratedpeople.test.functional.selenium.functions.SubmitJobAsExistingCustomer;

public class SubmitJobExistingCustomerMicroTest extends TestScript {
	private SubmitJobAsExistingCustomer underTest;
	
	@BeforeClass
	public void beforeClass() throws Exception {
		underTest = new SubmitJobAsExistingCustomer(this.context, scriptUtilities);		
	}

	@Test (enabled=false)
	public void test() {
		underTest.submitJobAsExistingMicro();
	}
}