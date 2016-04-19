/**
 * 
 */
package uk.co.ratedpeople.test.functional.selenium.newtmsignup;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import uk.co.ratedpeople.UniqueEmailAddressGenerator;
import uk.co.ratedpeople.test.functional.selenium.TestScript;


/**
 * @author ruhulla.mohammad
 *
 */
public class NewtmSinupJan2014OfferTest extends TestScript{
	
	private NewtmSignUpJan2014Offer underTest;
		
	@BeforeClass
	public void beforeClass(){
		underTest = new NewtmSignUpJan2014Offer (this.context, scriptUtilities);
				
	}
	
	@Test(enabled=false)
	public void newTMSignUpTest() throws Exception {
		String uniqueEmailAccountName = new UniqueEmailAddressGenerator().generateUniqueEmailAddress();
		underTest.testbusinessdetails(uniqueEmailAccountName);
		underTest.testScreeningdetails(uniqueEmailAccountName);
		underTest.editJobLeadSettings();
	}

}
