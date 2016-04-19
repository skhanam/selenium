/**
 * 
 */
package uk.co.ratedpeople.test.functional.selenium.newtmsignup;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import uk.co.ratedpeople.UniqueEmailAddressGenerator;
import uk.co.ratedpeople.test.functional.selenium.TestScript;


/**
 * @author shobha.rani
 *
 */
public class NewtmsinuphappyscenarioTest extends TestScript{
	
	private NewtmSignUphappyscenario underTest;
	private NewTradesmanSignUp underTMTest;
	
	@BeforeClass
	public void beforeClass(){
		underTest = new NewtmSignUphappyscenario (this.context, scriptUtilities);
		underTMTest = new NewTradesmanSignUp (this.context, scriptUtilities);
		
	}
	
	@Test(enabled=false)
	public void newTMSignUpTest() {
		String uniqueEmailAccountName = new UniqueEmailAddressGenerator().generateUniqueEmailAddress();
		underTest.testbusinessdetails(uniqueEmailAccountName);
		underTest.testScreeningdetails(uniqueEmailAccountName,"SO30 0PY");
		underTMTest.createTMbillingDetails(); 
		underTest.editJobLeadSettings(uniqueEmailAccountName);
		
	}

}
