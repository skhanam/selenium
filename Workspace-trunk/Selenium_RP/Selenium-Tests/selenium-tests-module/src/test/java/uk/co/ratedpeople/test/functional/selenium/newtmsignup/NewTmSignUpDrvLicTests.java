package uk.co.ratedpeople.test.functional.selenium.newtmsignup;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import uk.co.ratedpeople.UniqueEmailAddressGenerator;
import uk.co.ratedpeople.test.functional.selenium.TestScript;

public class NewTmSignUpDrvLicTests extends TestScript{

	private NewTradesmanSignUp underTest;
	
	@BeforeClass
	public void beforeClass(){
		underTest = new NewTradesmanSignUp (this.context, scriptUtilities);
		
	}
@Test(enabled=false)
public void newTMSignUpDrivingLicTest() {
	String uniqueEmailAccountName = new UniqueEmailAddressGenerator().generateUniqueEmailAddress();
	underTest.newTmSignUpDrivingLicense(uniqueEmailAccountName);
	underTest.changePhoneAndPostcodeTPAPP(uniqueEmailAccountName);
	}

}
