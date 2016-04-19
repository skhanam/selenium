package uk.co.ratedpeople.test.functional.selenium.requestCallBackAndRating;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import uk.co.ratedpeople.test.functional.selenium.TestScript;


public class TmRequestingCallBackTests extends TestScript {
	private CallBackRequest creditReq;

	@BeforeClass
	public void beforeClass() {
	creditReq=new CallBackRequest(this.context, scriptUtilities);
	}
	
	@Test(enabled = true)
	public void requestACallBack() throws Exception {
		creditReq.submitJobAsExistingCustomer();
		creditReq.buyJobasExistingCustomer();
		creditReq.requestCallBackForRPJobRal();
		creditReq.confirmEmailSentToHO();
	}
	
	@Test(enabled = false)
	public void requestACredit() throws Exception {
		creditReq.submitJobAsExistingCustomer();
		creditReq.buyJobasExistingCustomer();
		creditReq.requestCreditBackForRPJobOldRal();
		//creditReq.confirmEmailSentToHO();
	}	
}



