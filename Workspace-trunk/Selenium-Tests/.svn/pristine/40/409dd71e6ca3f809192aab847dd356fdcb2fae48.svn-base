/**
 * 
 */
package uk.co.ratedpeople.test.functional.selenium.core.regression;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import uk.co.ratedpeople.test.functional.selenium.TestScript;

/**
 * @author shabana.khanam
 *
 */
public class UnBlackListaTMTest extends TestScript{
	private BuyaLead underTest;

	@BeforeClass(alwaysRun = true)
	public void beforeClass() throws Exception {
		underTest = new BuyaLead(this.context, scriptUtilities);
//		underTest.startRecording();
	}

	//tm.two@ratedtrades.com - blacklisted user
	@Test(groups={"sanity"},enabled = true)
	public void BlacklistandUnblacklistTMTest() throws Exception {
		underTest.loginadmin(BuyaLeadXpathLocators.dataLookup.get("SUNAME"),BuyaLeadXpathLocators.dataLookup.get("SUPWD"));
		Thread.sleep(2000);
		underTest.supporttm(BuyaLeadXpathLocators.dataLookup.get("TMBLACKLISTEDUNAME"),"Blacklisted","Active",BuyaLeadXpathLocators.xpathLookup.get("UNBLACKLIST"),BuyaLeadXpathLocators.xpathLookup.get("BLACKLIST"));
//		underTest.stopRecording();
	}
	
	//tm.three@ratedtrades.com - Suspended - blacklist - unblacklist - Suspend 
	@Test(groups={"sanity"},enabled = true)
	public void BlackListSuspendedTMTest() throws Exception {
		underTest.loginadmin(BuyaLeadXpathLocators.dataLookup.get("SUNAME"),BuyaLeadXpathLocators.dataLookup.get("SUPWD"));
		Thread.sleep(2000);
		underTest.supporttm(BuyaLeadXpathLocators.dataLookup.get("TMSUSPENDEDUNAME"),"Suspended","Blacklisted",BuyaLeadXpathLocators.xpathLookup.get("BLACKLIST"),BuyaLeadXpathLocators.xpathLookup.get("UNBLACKLIST"));
//		underTest.stopRecording();
	}
}
