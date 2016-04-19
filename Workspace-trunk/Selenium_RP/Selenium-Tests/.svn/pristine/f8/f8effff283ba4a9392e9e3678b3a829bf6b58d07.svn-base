package uk.co.ratedpeople.test.functional.selenium.updatejob;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import uk.co.ratedpeople.test.functional.selenium.TestScript;
import uk.co.ratedpeople.test.functional.selenium.newjobforms.generic.PostingJobviaGenericJobForm;

/**
 * @author olivier.renard
 * 
 *         This test is for checking the expected functionality of updating existing job
 */

public class UpdateExistingJobContactDetailsTest extends TestScript {

	private PostingJobviaGenericJobForm newJobPost;
	private UpdateExistingJob updateJob;
	private static final String DESCRIPTION = "This is a long description for the job, and hopefully this will suffice.";
	private static final String NEW_POSTCODE = "SW1E 6AU";

	@BeforeClass
	public void beforeClass() throws Exception {
		newJobPost = new PostingJobviaGenericJobForm(context, scriptUtilities);
		updateJob = new UpdateExistingJob(this.context, scriptUtilities);
	}

	@Test
	public void updateExistingUnsoldJobLead() throws Exception {
		String userName = updateJob.getUserName();
		String password = updateJob.getPassword();
		newJobPost.postingJobviaNewGenericJobformDotCom(userName, updateJob.getPostcode(), "31", "flooring", DESCRIPTION);
		Thread.sleep(5000);
		updateJob.loginToHomeownersApp(userName, password);
		String jobPageUrl = updateJob.goToJobPage();
		updateJob.clickUpdateJob();
		UpdatedJobDetails ujd = updateJob.updatePostcode(jobPageUrl, NEW_POSTCODE);
		assertTrue(ujd.getNewDescription().startsWith("*PRIORITY LEAD* Updated details [and contact info]: " + DESCRIPTION));
		assertEquals(ujd.getNewPostcode(), NEW_POSTCODE);
	}
}
