package uk.co.ratedpeople.test.functional.selenium.coresystems.mk3_callback;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import uk.co.ratedpeople.test.functional.selenium.TestScript;

/**
 * @author sangeetha.kumar
 * 
 */

public class CallBackTest extends TestScript {
	private CallBack underTest;
	
	// this method is set to false during debug mode
	@Override
	protected boolean shouldCloseSeleniumAfterTestsCompleteOrFail() {
		return true;
	}	
	
	@BeforeClass
	public void beforeClass() throws Exception {
		underTest = new CallBack(this.context, scriptUtilities);		
	}
	
	@Test(enabled=true)
    public void postaJobTest() throws Exception {
	underTest.submitTreeSurgeonJob();
	}	
	@Test(enabled=true,dependsOnMethods="postaJobTest")
    public void buyJobTest() throws Exception {
	underTest.buyJob();
	underTest.requestCallBackFromTM();
	}	
	@Test(enabled=true,dependsOnMethods="buyJobTest")
    public void callBackScreenMk3Test() throws Exception {
	underTest.callBackScreenMK3();
	}
	
	@Test(enabled=false,dependsOnMethods="callBackScreenMk3Test")
    public void callBackScreen_creditedJobMk3Test() throws Exception {
	underTest.creditJob();
//	underTest.callBackCreditedJobMK3();
	}
	
}