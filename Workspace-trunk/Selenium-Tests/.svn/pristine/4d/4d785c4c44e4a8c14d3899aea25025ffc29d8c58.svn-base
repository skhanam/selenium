package uk.co.ratedpeople.test.functional.selenium.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import uk.co.ratedpeople.test.functional.selenium.TestScript;
import uk.co.ratedpeople.test.functional.selenium.functions.CreateTradesman;

public class CreateTradesmanProofOfDrvLicTest extends TestScript {
private CreateTradesman underTest;
	
	@BeforeClass
	public void beforeClass() throws Exception {
		underTest = new CreateTradesman(this.context, scriptUtilities);		
	}

	@Test(enabled=false)	 // conflict in system design (14.11.2012 Aleksandr)
	public void createTradesmanTest() {

		underTest.createNewTradesmanProofOfDrvLic(); // 22.03.2011 Works well in new system (Aleksandr)
	}
}