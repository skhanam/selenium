package uk.co.ratedpeople.test.functional.selenium.newtmmembershipcampaign;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import uk.co.ratedpeople.UniqueEmailAddressGenerator;
import uk.co.ratedpeople.test.functional.selenium.TestScript;

/**
 * @author ruhulla.mohammad
 *
 */

public class PMDOfferForNewTMSignUpVarEWithNewCardTest extends TestScript{
private PMDOfferForNewTMSignUpVarE underTest;
	
	
	@BeforeClass
	public void beforeClass(){
		underTest = new PMDOfferForNewTMSignUpVarE (this.context, scriptUtilities);
		
	}

@Test(enabled=false)
public void newTMSignUpDrivingLicenceTest() throws Exception {
	String uniqueEmailAccountName = new UniqueEmailAddressGenerator().generateUniqueEmailAddress();
	underTest.testbusinessdetails(uniqueEmailAccountName);
	underTest.testDrivingLicenceScreeningdetails(uniqueEmailAccountName);
	underTest.createTMbillingDetails();
	/*underTest.submitJobForPMDRating();
	underTest.buyLeadWithExistingBalanceAndRequestRating(uniqueEmailAccountName);*/
	scriptUtilities.sleep(3000);
	underTest.getPMDOfferForNewTMWithNewCard(uniqueEmailAccountName);
}
}

