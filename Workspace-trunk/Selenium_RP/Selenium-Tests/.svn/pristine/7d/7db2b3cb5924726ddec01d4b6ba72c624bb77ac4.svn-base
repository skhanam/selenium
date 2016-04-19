package uk.co.ratedpeople.test.functional.selenium.coresystems.mail;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import uk.co.ratedpeople.test.functional.selenium.TestScript;
import uk.co.ratedpeople.test.functional.selenium.coresystems.mail.ConfirmEmailSentWithExistingHoExistingTm;

/**
 * @author sangeetha.kumar
 * 
 * This test is used to check the end to end scenario of Tm receiving the mails once the job is purchased 
 */

public class ConfirmEmailSentNewHoExistingTmTest extends TestScript {
	private ConfirmEmailSentWithExistingHoExistingTm job;
	private ConfirmEmailSentForNewHoExistingTm checkEmail;

	@BeforeClass
	public void beforeClass() throws Exception {
		job = new ConfirmEmailSentWithExistingHoExistingTm(this.context, scriptUtilities);
		checkEmail = new ConfirmEmailSentForNewHoExistingTm(this.context, scriptUtilities);
	}

	@Test
	public void checkEmailSentNewHoToExistingTMTest() throws Exception {
	
		for (int i=0;i<1;i++) {
		checkEmail.submitJobAsExistingCustomer();}
		job.buyLeadExistingCardNoBalance();
		checkEmail.confirmTmEmailNewHoExistingTm();
	}
}
