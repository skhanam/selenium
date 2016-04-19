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



public class BuyaLeadExistingCardTest extends TestScript{
	private BuyaLead underTest;
	private static final String TM_ACC_BALANCE = "£0.00 ";
	private static final String TM_FREE_BALANCE = "£30.00 ";
	private static final String TM_FREESPL_BALANCE = "£7.00 ";
	
	@SuppressWarnings("unused")
	private SpecializedScreenRecorder screenRecorder;
	
	@BeforeClass(alwaysRun = true)
	public void beforeClass() throws Exception {
		underTest = new BuyaLead(this.context, scriptUtilities);
//		underTest.startRecording();
	}

	//barry.barry
	@Test(groups={"sanity"},enabled = true)
	public void buyaLeadWithCreditCardTest() throws Exception {
		underTest.loginTMapp(BuyaLeadXpathLocators.dataLookup.get("TMUNAME"),BuyaLeadXpathLocators.dataLookup.get("TMPWD") );
		Thread.sleep(3000);
		context.driver.navigate().back();
		underTest.loginTMapp(BuyaLeadXpathLocators.dataLookup.get("TMUNAME"),BuyaLeadXpathLocators.dataLookup.get("TMPWD") );
		Thread.sleep(3000);
//		underTest.pmdPopup();
		Thread.sleep(2000);
		underTest.tmBuyJobwithexistingcard(TM_ACC_BALANCE,5);
		underTest.loginadmin(BuyaLeadXpathLocators.dataLookup.get("SUNAME"),BuyaLeadXpathLocators.dataLookup.get("SUPWD"));
		Thread.sleep(2000);
		underTest.supporttm(BuyaLeadXpathLocators.dataLookup.get("TMUNAME"));
		underTest.jBilling(BuyaLeadXpathLocators.xpathLookup.get("GOTOJOBREF"),BuyaLeadXpathLocators.dataLookup.get("JOBREFERENCE"));

		
	}
		
	@Test(groups={"sanity"},enabled = false)
	public void buyaLeadAddingNewCard() throws Exception{
		underTest.loginTMapp(BuyaLeadXpathLocators.dataLookup.get("TMUNAME"),BuyaLeadXpathLocators.dataLookup.get("TMPWD") );
		Thread.sleep(3000);
		context.driver.navigate().back();
		underTest.loginTMapp(BuyaLeadXpathLocators.dataLookup.get("TMUNAME"),BuyaLeadXpathLocators.dataLookup.get("TMPWD") );
		Thread.sleep(3000);
////		underTest.pmdPopup();
		Thread.sleep(3000);
		underTest.tmBuyJobwithNewCard(TM_ACC_BALANCE);
		underTest.loginadmin(BuyaLeadXpathLocators.dataLookup.get("SUNAME"),BuyaLeadXpathLocators.dataLookup.get("SUPWD"));
		Thread.sleep(2000);
		underTest.supporttm(BuyaLeadXpathLocators.dataLookup.get("TMUNAME"));
		underTest.jBilling(BuyaLeadXpathLocators.xpathLookup.get("GOTOJOBREF"),BuyaLeadXpathLocators.dataLookup.get("JOBREFERENCE"));

	}
	
	/// log in to Support 
	
	@Test(groups={"sanity"},enabled = false)
	public void testLogintoSupport() throws Exception{
		underTest.loginadmin(BuyaLeadXpathLocators.dataLookup.get("SUNAME"),BuyaLeadXpathLocators.dataLookup.get("SUPWD"));
		Thread.sleep(2000);
		underTest.supporttm(BuyaLeadXpathLocators.xpathLookup.get("TMWITHBALANCEUNAME"));
		underTest.jBilling(BuyaLeadXpathLocators.xpathLookup.get("GOTOJOBREF"),BuyaLeadXpathLocators.dataLookup.get("JOBREFERENCE"));

	}
	
	
	// andrew.andrew
	@Test(groups={"sanity"},enabled = true)
	public void buyaLeadwithFreeBalanceAndExistingCardTest() throws Exception{
		underTest.loginTMapp(BuyaLeadXpathLocators.dataLookup.get("TMWITHFREEUNAME"),BuyaLeadXpathLocators.dataLookup.get("TMPWD") );
		Thread.sleep(3000);
		context.driver.navigate().back();
		underTest.loginTMapp(BuyaLeadXpathLocators.dataLookup.get("TMWITHFREEUNAME"),BuyaLeadXpathLocators.dataLookup.get("TMPWD") );
		Thread.sleep(3000);
//		underTest.pmdPopup();
		Thread.sleep(3000);
		underTest.tmBuyJobwithexistingcard(TM_FREE_BALANCE,2);
//		underTest.tmBuyJobwithexistingcard(TM_FREE_BALANCE);
		underTest.loginadmin(BuyaLeadXpathLocators.dataLookup.get("SUNAME"),BuyaLeadXpathLocators.dataLookup.get("SUPWD"));
		Thread.sleep(2000);
		underTest.supporttm(BuyaLeadXpathLocators.dataLookup.get("TMWITHFREEUNAME"));
		underTest.jBilling(BuyaLeadXpathLocators.xpathLookup.get("GOTOJOBREF"), BuyaLeadXpathLocators.dataLookup.get("JOBREFERENCE"));

	}
	
	
		// dan.dan
		@Test(groups={"sanity"},enabled = true)
		public void buyaLeadwithSpecialCreditTest() throws Exception{
			underTest.loginTMapp(BuyaLeadXpathLocators.dataLookup.get("TMWITHSPLCREDITUNAME"),BuyaLeadXpathLocators.dataLookup.get("TMPWD") );
			Thread.sleep(3000);
			context.driver.navigate().back();
			underTest.loginTMapp(BuyaLeadXpathLocators.dataLookup.get("TMWITHSPLCREDITUNAME"),BuyaLeadXpathLocators.dataLookup.get("TMPWD") );
			Thread.sleep(3000);
//			underTest.pmdPopup();
			Thread.sleep(3000);
			underTest.tmBuyJobwithexistingcard(BuyaLeadXpathLocators.dataLookup.get("SPLCREDITBALANCE"),4);
			underTest.loginadmin(BuyaLeadXpathLocators.dataLookup.get("SUNAME"),BuyaLeadXpathLocators.dataLookup.get("SUPWD"));
			Thread.sleep(2000);
			underTest.supporttm(BuyaLeadXpathLocators.dataLookup.get("TMWITHSPLCREDITUNAME"));
			underTest.jBilling(BuyaLeadXpathLocators.xpathLookup.get("GOTOJOBREFREEBALSPLCREDIT"),BuyaLeadXpathLocators.dataLookup.get("JOBREFERENCE"));
//			underTest.stopRecording();
		}
	
	
		
	//  chris.chris 
	@Test(groups={"sanity"},enabled = true)
	public void buyaLeadwithFreeBalanceSpecialCreditTest() throws Exception{
		underTest.loginTMapp(BuyaLeadXpathLocators.dataLookup.get("TMWITHBALANCEUNAME"),BuyaLeadXpathLocators.dataLookup.get("TMPWD") );
		Thread.sleep(3000);
		context.driver.navigate().back();
		underTest.loginTMapp(BuyaLeadXpathLocators.dataLookup.get("TMWITHBALANCEUNAME"),BuyaLeadXpathLocators.dataLookup.get("TMPWD") );
		Thread.sleep(3000);
//		underTest.pmdPopup();
		Thread.sleep(3000);
		underTest.tmBuyJobwithexistingcard(TM_FREESPL_BALANCE,3);
		underTest.loginadmin(BuyaLeadXpathLocators.dataLookup.get("SUNAME"),BuyaLeadXpathLocators.dataLookup.get("SUPWD"));
		Thread.sleep(2000);
		underTest.supporttm(BuyaLeadXpathLocators.dataLookup.get("TMWITHBALANCEUNAME"));
		underTest.jBilling((BuyaLeadXpathLocators.xpathLookup.get("GOTOJOBREFSPLCREDIT")),BuyaLeadXpathLocators.dataLookup.get("JOBREFERENCE"));

	}
	
}
