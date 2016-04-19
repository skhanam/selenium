package uk.co.ratedpeople.test.functional.selenium.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import uk.co.ratedpeople.test.functional.selenium.TestScript;
import uk.co.ratedpeople.test.functional.selenium.functions.CreateTradesman;

public class CreateTradesmanFailedVerificationTest extends TestScript {
private CreateTradesman underTest;

	@BeforeClass
	public void beforeClass() throws Exception {
		underTest = new CreateTradesman(this.context, scriptUtilities);		
	}

	@Test(enabled=false)
	public void createTradesmanTest() {
		underTest.createNewTradesmanFailedVerification();
	}
}
