package uk.co.ratedpeople.test.functional.selenium.tmmobile.requestCallBackAndRating;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import uk.co.ratedpeople.test.functional.selenium.TestScript;


public class RequestARatingtmmobileTest extends TestScript {
	private RequestALeadtmmobile creditReqtmmobile;

	@BeforeClass
	public void beforeClass() {
		creditReqtmmobile=new RequestALeadtmmobile(this.context, scriptUtilities);
	}
	
	@Test(enabled = true)
	public void requestARatingtmmobile() throws Exception {
		creditReqtmmobile.requestRatingForRPJob();
		//creditReqtmmobile.confirmEmailSentToHo();
	}	


}
