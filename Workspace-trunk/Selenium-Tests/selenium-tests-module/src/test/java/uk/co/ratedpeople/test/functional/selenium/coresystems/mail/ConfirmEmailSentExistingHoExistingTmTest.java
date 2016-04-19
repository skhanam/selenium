package uk.co.ratedpeople.test.functional.selenium.coresystems.mail;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import uk.co.ratedpeople.test.functional.selenium.TestScript;

/**
 * @author sangeetha.kumar
 * 
 * This test is used to check the end to end scenario of Tm receiving the purchased jobs e-mails  
 */

public class ConfirmEmailSentExistingHoExistingTmTest extends TestScript {
	
	private ConfirmEmailSentWithExistingHoExistingTm checkEmail;

	@BeforeClass
	public void beforeClass() throws Exception {
		checkEmail = new ConfirmEmailSentWithExistingHoExistingTm(this.context, scriptUtilities);
	}

	@Test
	public void checkEmailSentEHoToETMTest() throws Exception {
		for (int i=0;i<1;i++) {
		checkEmail.submitJobAsExistingCustomer();}
		checkEmail.buyLeadExistingCardNoBalance();
		checkEmail.confirmTMEmailSentWithExistingHo();
	}
}