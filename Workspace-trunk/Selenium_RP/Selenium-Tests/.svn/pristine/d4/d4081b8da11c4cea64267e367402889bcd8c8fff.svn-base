package uk.co.ratedpeople.test.functional.selenium.updatejob;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import uk.co.ratedpeople.test.functional.selenium.TestScript;
import uk.co.ratedpeople.test.functional.selenium.newjobforms.generic.PostingJobviaGenericJobForm;

/**
 * @author sangeetha.kumar
 * 
 *         This test is for checking the expected functionality of updating existing job
 */

public class UpdateExistingJobDescriptionTest extends TestScript {

	private PostingJobviaGenericJobForm newJobPost;
	private UpdateExistingJob updateJob;
	private static final String DESCRIPTION = "This is a long description for the job, and hopefully this will suffice.";
	private static final String ADDED_DESCRIPTION = " - Text added to description";

	@BeforeClass
	public void beforeClass() throws Exception {
		newJobPost = new PostingJobviaGenericJobForm(context, scriptUtilities);
		updateJob = new UpdateExistingJob(this.context, scriptUtilities);
	}

	@Test
	public void updateFirstNameInExistingUnsoldJobLead() throws Exception {
		String userName = updateJob.getUserName();
		String password = updateJob.getPassword();
		newJobPost.postingJobviaNewGenericJobformDotCom(userName, updateJob.getPostcode(), "31", "flooring", DESCRIPTION);
		Thread.sleep(5000);
		updateJob.loginToHomeownersApp(userName, password);
		String jobPageUrl = updateJob.goToJobPage();
		updateJob.clickUpdateJob();
		String newDescription = updateJob.updateJobDescription(jobPageUrl, ADDED_DESCRIPTION);
//		System.out.println("See the new description"+ newDescription);
//		System.out.println("See the append one description" + DESCRIPTION + ADDED_DESCRIPTION);
		System.out.println(newDescription.startsWith("*PRIORITY LEAD* \n Changed information:description " + DESCRIPTION + ADDED_DESCRIPTION ));
		assertTrue(newDescription.startsWith("*PRIORITY LEAD*" +"\nChanged information:description"));

	}
}
