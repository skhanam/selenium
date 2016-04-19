package uk.co.ratedpeople.test.functional.selenium.newtmmembershipcampaign;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import uk.co.ratedpeople.UniqueEmailAddressGenerator;
import uk.co.ratedpeople.test.functional.selenium.TestScript;

/**
 * @author ruhulla.mohammad
 *
 */

public class NewTMMembershipCampaignNewCardTest extends TestScript{
private NewtmSignUpForPMDOffer underTest;
	
	
	@BeforeClass
	public void beforeClass(){
		underTest = new NewtmSignUpForPMDOffer (this.context, scriptUtilities);
		
	}

@Test(enabled=false)
public void newTMSignUpDrivingLicenceTest() throws Exception {
	String uniqueEmailAccountName = new UniqueEmailAddressGenerator().generateUniqueEmailAddress();
	underTest.testbusinessdetails(uniqueEmailAccountName);
	underTest.testDrivingLicenceScreeningdetails(uniqueEmailAccountName);
	underTest.createTMbillingDetails();
	underTest.submitJobForPMDRating();
	underTest.buyLeadWithExistingBalanceAndRequestRating();
	underTest.GiveRatingsForTradesman();
	String url = underTest.getMembershipCampaignFromDB();
	underTest.getMembershipCampaignFromDB();
	String tmMobileURL = context.getTestHttpsTMMobileURL();
	String completeMembershipCampaingURL = tmMobileURL+url;
	System.out.println(completeMembershipCampaingURL);
	scriptUtilities.goTo(completeMembershipCampaingURL);
	scriptUtilities.sleep(3000);
	underTest.getTMMembershipCampaignNewCard();
}
}

