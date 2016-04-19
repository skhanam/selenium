package uk.co.ratedpeople.test.functional.selenium.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import uk.co.ratedpeople.UniqueEmailAddressGenerator;
import uk.co.ratedpeople.test.functional.selenium.TestScript;
import uk.co.ratedpeople.test.functional.selenium.functions.CreateTradesman;

public class CreateTradesmanMK3VerifiedTest extends TestScript {
	private CreateTradesman underTest;
	public String uniqueEmailAccountName;
	@BeforeClass
	public void beforeClass() throws Exception {
		underTest = new CreateTradesman(this.context, scriptUtilities);		
	}

	@Test(enabled=false)  // GB Group times out
	public void createTradesmanTestMK2() throws Exception {
		uniqueEmailAccountName = new UniqueEmailAddressGenerator().generateUniqueEmailAddress();
		underTest.createNewTradesmanMK3Verified(uniqueEmailAccountName); 
		//underTest.buyJobFreeLead(uniqueEmailAccountName); 
		
	}

}


