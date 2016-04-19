package uk.co.ratedpeople.test.functional.selenium.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import uk.co.ratedpeople.UniqueEmailAddressGenerator;
import uk.co.ratedpeople.test.functional.selenium.TestScript;
import uk.co.ratedpeople.test.functional.selenium.functions.CreateTradesman;

public class CreateTradesmanTest extends TestScript {
private CreateTradesman underTest;
public String uniqueEmailAccountName;
	
	@BeforeClass
	public void beforeClass() throws Exception {
		underTest = new CreateTradesman(this.context, scriptUtilities);		
	}

	@Test(enabled=false) 
	public void createTradesmanTest() throws Exception {
		uniqueEmailAccountName = new UniqueEmailAddressGenerator().generateUniqueEmailAddress();
		underTest.createNewTradesman(uniqueEmailAccountName); // 22.03.2011 Works well in new system (Aleksandr)
        underTest.changePhoneAndPostcodeTPAPP(uniqueEmailAccountName);
	}
}
