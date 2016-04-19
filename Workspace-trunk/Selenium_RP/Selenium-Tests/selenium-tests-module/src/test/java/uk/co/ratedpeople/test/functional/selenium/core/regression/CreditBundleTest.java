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
public class CreditBundleTest extends TestScript{
	private BuyaLead underTest;
	private CreditBundles  creditTest;
	
	
	@BeforeClass(alwaysRun = false)
	public void beforeClass() throws Exception {
		underTest = new BuyaLead(this.context,scriptUtilities);
		creditTest = new CreditBundles(this.context,context.getTestUrl(), scriptUtilities);
	}
	
	
	
	@Test(groups={"sanity"},enabled = true)
	public void  awardCreditBundletest() throws Exception{
		underTest.loginadmin(BuyaLeadXpathLocators.dataLookup.get("SUNAME"),BuyaLeadXpathLocators.dataLookup.get("SUPWD"));
		Thread.sleep(2000);
		underTest.supporttmSearch(BuyaLeadXpathLocators.dataLookup.get("TMCREDITBUNDLE"));
		creditTest.awardcreditBundle();
	}
	
	@Test(groups={"sanity"},enabled = true)
	public void  awardCreditBundleForSpecialCreditUsertest() throws Exception{
		underTest.loginadmin(BuyaLeadXpathLocators.dataLookup.get("SUNAME"),BuyaLeadXpathLocators.dataLookup.get("SUPWD"));
		Thread.sleep(2000);
		underTest.supporttmSearch(BuyaLeadXpathLocators.dataLookup.get("TMCREDITBUNDLESPECIALCREDIT"));
		creditTest.awardcreditBundle();
	}
	
	

}
