package uk.co.ratedpeople.test.functional.selenium.mail;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import uk.co.ratedpeople.test.functional.selenium.TestScript;
import uk.co.ratedpeople.test.functional.selenium.functions.BuyJob;
import uk.co.ratedpeople.test.functional.selenium.functions.SubmitJobAsExistingCustomer;

public class ConfirmEmailSentExistingHoExistingTmTest extends TestScript {
	private SubmitJobAsExistingCustomer submitJobEHo;
	private BuyJob buyJob;
	private ConfirmEmailSentWithExistingHoExistingTm checkEmail;

	@BeforeClass
	public void beforeClass() throws Exception {
		submitJobEHo = new SubmitJobAsExistingCustomer(this.context, scriptUtilities);
		buyJob = new BuyJob(this.context, scriptUtilities);
		checkEmail = new ConfirmEmailSentWithExistingHoExistingTm(this.context, scriptUtilities);
	}

	@Test
	public void checkEmailSentEHoToETMTest() throws Exception {
		submitJobEHo.submitJobAsExistingCustomer();
		buyJob.buyLeadExistingCardNoBalance("sangitmtestuser@ratedtrades.com");
		checkEmail.confirmTMEmailSentWithExistingHo();
	}
}