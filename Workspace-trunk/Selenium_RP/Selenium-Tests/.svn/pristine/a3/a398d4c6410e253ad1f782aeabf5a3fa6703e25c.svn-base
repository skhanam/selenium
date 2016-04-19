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

public class UpdateExistingCategoryTest extends TestScript {

	private static final String SKILL_TYPE_NAME = "Laminate Flooring";
	private PostingJobviaGenericJobForm newJobPost;
	private UpdateExistingJob updateJob;
	private static final String DESCRIPTION = "This is a long description for the job, and hopefully this will suffice.";

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
		UpdatedJobDetails ujd = updateJob.updateSkillTypeId(jobPageUrl, "32", SKILL_TYPE_NAME);
		assertTrue(ujd.getNewDescription().startsWith("*PRIORITY LEAD* Updated details [and category]: " + DESCRIPTION));
		assertEquals(ujd.getNewCategory(), SKILL_TYPE_NAME);
	}
}
