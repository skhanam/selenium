package uk.co.ratedpeople.test.functional.selenium.mail;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import uk.co.ratedpeople.test.functional.selenium.TestScript;
import uk.co.ratedpeople.test.functional.selenium.functions.BuyJob;
import uk.co.ratedpeople.test.functional.selenium.functions.SubmitJobAsNewCustomer;

public class ConfirmEmailSentNewHoExistingTmTest extends TestScript {
	private SubmitJobAsNewCustomer submitJobNho;
	private BuyJob buyJob;
	private ConfirmEmailSentForNewHoExistingTm checkEmail;

	@BeforeClass
	public void beforeClass() throws Exception {
		submitJobNho = new SubmitJobAsNewCustomer(this.context, scriptUtilities);
		buyJob = new BuyJob(context, scriptUtilities);
		checkEmail = new ConfirmEmailSentForNewHoExistingTm(this.context, scriptUtilities);
	}

	@Test
	public void checkEmailSentNewHoToExistingTMTest() throws Exception {
		submitJobNho.submitJobAsNewCustomerCheckMail();
		buyJob.buyLeadExistingCardNoBalance("sangitmtestuser@ratedtrades.com");
		checkEmail.confirmTmEmailNewHoExistingTm();
	}
}
