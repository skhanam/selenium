package uk.co.ratedpeople.test.functional.selenium.newtmsignup;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import uk.co.ratedpeople.UniqueEmailAddressGenerator;
import uk.co.ratedpeople.test.functional.selenium.TestScript;

public class NewTmSignUpGBPPassTests extends TestScript{

	private NewTradesmanSignUp underTest;
	
	@BeforeClass
	public void beforeClass(){
		underTest = new NewTradesmanSignUp (this.context, scriptUtilities);
		
	}

@Test(enabled=false)
public void newTMSignUpPassportTest() {
	String uniqueEmailAccountName = new UniqueEmailAddressGenerator().generateUniqueEmailAddress();
	underTest.newTmSignUpGBRPassport(uniqueEmailAccountName);
	//underTest.changePhoneAndPostcodeTPAPP(uniqueEmailAccountName);
}

}
