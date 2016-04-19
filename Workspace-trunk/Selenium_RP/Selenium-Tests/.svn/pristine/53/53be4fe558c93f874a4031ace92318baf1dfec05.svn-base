package uk.co.ratedpeople.test.functional.selenium.tests;

//CreateTradesmanMK3
//1. Create new Tradesman
//2. Activate
//3. Test Suspend and re-activate
//4. Buy job with existing card
//07.03.2012 - Works well on preprod and Dev3 (Aleksandr)

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import uk.co.ratedpeople.UniqueEmailAddressGenerator;
import uk.co.ratedpeople.test.functional.selenium.TestScript;
import uk.co.ratedpeople.test.functional.selenium.functions.CreateTradesman;

public class CreateTradesmanMK3Test extends TestScript {
	private CreateTradesman underTest;
	public String uniqueEmailAccountName;
	
	@BeforeClass
	public void beforeClass() throws Exception {
		underTest = new CreateTradesman(this.context, scriptUtilities);		
	}

	@Test (enabled=false)
	public void createJBillingTradesmanTest() throws Exception {
		uniqueEmailAccountName = new UniqueEmailAddressGenerator().generateUniqueEmailAddress();
		underTest.createNewTradesmanMK3(uniqueEmailAccountName);
		//underTest.buyJobFreeBalance();
				
	}
}
