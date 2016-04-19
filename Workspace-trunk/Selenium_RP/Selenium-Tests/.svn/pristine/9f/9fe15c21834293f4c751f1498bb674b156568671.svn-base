package uk.co.ratedpeople.test.functional.selenium.tmmobile.requestCallBackAndRating;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import uk.co.ratedpeople.test.functional.selenium.TestScript;


public class RequestACallBacktmmobileTest extends TestScript {
	private RequestALeadtmmobile creditReqtmmobile;

	@BeforeClass
	public void beforeClass() {
		creditReqtmmobile=new RequestALeadtmmobile(this.context, scriptUtilities);
	}
	
	@Test(enabled = true)
	public void requestACallBacktmmobile() throws Exception {
		creditReqtmmobile.requestCallBackForRPJob();
		//creditReqtmmobile.confirmEmailSentToHo();
	}	
	
	@Test(enabled = false)
	public void requestACreditBacktmmobile() throws Exception {
		creditReqtmmobile.requestACreditBackForRPJobOldRal();
	}
}