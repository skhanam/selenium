/**
 * 
 */
package uk.co.ratedpeople.test.functional.selenium.coresystems.mk3_refreshjbilling;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import uk.co.ratedpeople.UniqueEmailAddressGenerator;
import uk.co.ratedpeople.test.functional.selenium.TestScript;
import uk.co.ratedpeople.test.functional.selenium.newtmsignup.NewTradesmanSignUp;


/**
 * @author shobha.rani
 *
 */
public class RefreshJBillingMK3Test extends TestScript {
	private RefreshJBillinginMK3 underTest;
	private NewTradesmanSignUp undertesttm;
	public String uniqueEmailAccountName;
	private UniqueEmailAddressGenerator uniqueEmailAddressGenerator;

	@BeforeClass
	public void beforeClass() throws Exception {
		underTest = new RefreshJBillinginMK3(this.context,scriptUtilities);	
		undertesttm = new NewTradesmanSignUp (this.context, scriptUtilities);
		uniqueEmailAddressGenerator = new UniqueEmailAddressGenerator();
	}
    
	// Creating TM from MK3 TP-Sign up
	@Test (enabled=false)
	public void createRefreshJBillingTradesmanTest() throws Exception {
		uniqueEmailAccountName = uniqueEmailAddressGenerator.generateUniqueEmailAddress();
		underTest.testCreateNewTradesmanMK3support(uniqueEmailAccountName);
		underTest.testUpdateLuceneSearch(uniqueEmailAccountName);
		underTest.testSuspendAllActivePlans(uniqueEmailAccountName);
		underTest.testReActivateSuspendUser(uniqueEmailAccountName);						
	}
	
	// Creating user from preprod TM SignUp
	@Test(enabled=false)
	public void testRefreshJbillingTMsignupUser() throws Exception{		
		uniqueEmailAccountName = uniqueEmailAddressGenerator.generateUniqueEmailAddress();
		undertesttm.newTmSignUpDrivingLicense(uniqueEmailAccountName);
		underTest.testUpdateLuceneSearch(uniqueEmailAccountName);
		underTest.testSuspendAllActivePlans(uniqueEmailAccountName);
		underTest.testReActivateSuspendUser(uniqueEmailAccountName);			 
	}
}

