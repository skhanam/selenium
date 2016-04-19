package uk.co.ratedpeople.test.functional.selenium.newtmsignup;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import uk.co.ratedpeople.UniqueEmailAddressGenerator;
import uk.co.ratedpeople.test.functional.selenium.TestScript;

public class NewTmSignUpIntlPassTests extends TestScript{
	private NewTradesmanSignUp underTest;
	
	
	@BeforeClass
	public void beforeClass(){
		underTest = new NewTradesmanSignUp (this.context, scriptUtilities);
		
	}

@Test(enabled=false)
public void newTMSignUpIntPassportTest() {
	String uniqueEmailAccountName = new UniqueEmailAddressGenerator().generateUniqueEmailAddress();
	underTest.newTmSignUpIntPassport(uniqueEmailAccountName);
	underTest.changePhoneAndPostcodeTPAPP(uniqueEmailAccountName);
	
	}

}
