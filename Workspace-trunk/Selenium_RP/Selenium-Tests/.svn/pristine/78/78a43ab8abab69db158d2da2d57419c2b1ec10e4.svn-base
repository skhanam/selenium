package uk.co.ratedpeople.test.functional.selenium.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import uk.co.ratedpeople.test.functional.selenium.TestScript;
import uk.co.ratedpeople.test.functional.selenium.functions.SubmitJobAsNewCustomer;

public class SubmitJobNewCustomerMobileTest extends TestScript {
	private SubmitJobAsNewCustomer underTest;
	private String testUrl;
	
	@BeforeClass
	public void beforeClass() throws Exception {
		underTest = new SubmitJobAsNewCustomer(this.context, scriptUtilities);	
		testUrl = context.getTestUrl();
	}

	
	/*
	 * This test is disabled as we don't have specific mobile link 
	 * after introduction of responsiveness
	 */
	@Test(enabled=false)
	public void test() throws Exception {
		underTest.submitJobNewCustomerMobile(testUrl);
	}
}