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
public class NewtmSinupFreeTrailFromPartnerSiteTest extends TestScript{
	
	private NewtmSignUpFreeTrailFromPartnersSite underTest;
		
	@BeforeClass
	public void beforeClass(){
		underTest = new NewtmSignUpFreeTrailFromPartnersSite (this.context, scriptUtilities);
				
	}
	
	@Test(enabled=false)
	public void newTMSignUpTest() throws Exception {
		String uniqueEmailAccountName = new UniqueEmailAddressGenerator().generateUniqueEmailAddress();
		underTest.testbusinessdetails(uniqueEmailAccountName);
		underTest.testScreeningdetails(uniqueEmailAccountName);
		underTest.confirmWelcomeEmailSentToTM(uniqueEmailAccountName);
		
	}

}
