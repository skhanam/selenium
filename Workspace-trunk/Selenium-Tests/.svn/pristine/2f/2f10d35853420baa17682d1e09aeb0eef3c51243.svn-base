package uk.co.ratedpeople.test.functional.selenium.tests;

//Something wrong with that haven't had time to fix 

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import uk.co.ratedpeople.test.functional.selenium.TestScript;
import uk.co.ratedpeople.test.functional.selenium.functions.CreditRequest;

public class CreditRequestTest extends TestScript {
private CreditRequest underTest;
	
	@BeforeClass
	public void beforeClass() throws Exception {
		underTest = new CreditRequest(this.context, scriptUtilities);		
	}

	
	/*
	 * This test is disabled as we don't have specific mobile link 
	 * after introduction of responsiveness
	 */
	@Test(enabled=false)
	public void approveCreditRequestTest() throws Exception {

		underTest.creditRequest();
	}
}
