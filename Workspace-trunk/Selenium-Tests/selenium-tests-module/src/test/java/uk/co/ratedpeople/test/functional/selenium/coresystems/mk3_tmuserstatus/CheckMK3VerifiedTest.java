package uk.co.ratedpeople.test.functional.selenium.coresystems.mk3_tmuserstatus;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import uk.co.ratedpeople.UniqueEmailAddressGenerator;
import uk.co.ratedpeople.test.functional.selenium.TestScript;
import uk.co.ratedpeople.test.functional.selenium.newtmsignup.NewTradesmanSignUp;

/**
 * @author sangeetha.kumar
 * This test is used to check the USER STATUS is NOT VERIFIED on MK3 
 */

    public class CheckMK3VerifiedTest extends TestScript {
    private NewTradesmanSignUp underTest;
	public String uniqueEmailAccountName;
	private CheckStatus checkVerifiedBtn;
	
		
	@BeforeClass
	public void beforeClass() throws Exception {
		underTest = new NewTradesmanSignUp(this.context, scriptUtilities);
		checkVerifiedBtn = new CheckStatus(this.context);	
	}

	@Test(enabled=false)
    public void CreateNewTmTest() throws Exception {
		uniqueEmailAccountName = new UniqueEmailAddressGenerator().generateUniqueEmailAddress();
		underTest.newTmSignUpDrivingLicense(uniqueEmailAccountName);
		} 
	
	@Test(enabled=true)
    public void VerifiedTMOnMk3Test() throws Exception {
//		String tradesman = uniqueEmailAccountName;
		String tradesman =CheckUserXpathlocators.dataLookup.get("EMAIL1");	
		checkVerifiedBtn.checkIsVerified(CheckUserXpathlocators.dataLookup.get("EMAIL"),CheckUserXpathlocators.dataLookup.get("PASSWORD"),tradesman);	
	} 
	
}