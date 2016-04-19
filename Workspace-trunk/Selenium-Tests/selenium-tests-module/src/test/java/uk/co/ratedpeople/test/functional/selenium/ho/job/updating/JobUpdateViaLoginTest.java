package uk.co.ratedpeople.test.functional.selenium.ho.job.updating;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import uk.co.ratedpeople.APIJob;
import uk.co.ratedpeople.JobSubmitter;
import uk.co.ratedpeople.RestDomainXMLBeanUser;
import uk.co.ratedpeople.UserRetriever;
import uk.co.ratedpeople.test.functional.selenium.TestScript;

/**
 * This selenium test is used to test job update operation via user logged in 
 * experience/n 
 * @author abhiuday.tomar
 *
 */
public class JobUpdateViaLoginTest extends TestScript {
	private static final String HOMEOWNER_USERNAME = "aleksandr55@ratedtrades.com";
	private static final String HOMEOWNER_PASSWORD = "password";
	
	private static final String TEST_POSTCODE = "HA9 9AR";
	
	private JobSubmitter jobSubmitter;
	private HomeownerJobUpdateActions homeOwnerJobUpdateActions;
	private UserRetriever userRetriever;
	private RestDomainXMLBeanUser user;
	private APIJob job;
	
	@BeforeClass
	public void beforeClass() throws Exception {
		jobSubmitter = new JobSubmitter();
		userRetriever = new UserRetriever();
		homeOwnerJobUpdateActions = new HomeownerJobUpdateActions(this.context);
		user = userRetriever.getUser(HOMEOWNER_USERNAME, HOMEOWNER_PASSWORD);
		
	}
	
	@Test(enabled=true, groups = {"underConstruction"})
	public void testJobUpdateViaLoggin() throws Exception{
		job = jobSubmitter.submitMetalWorkerJobForGivenUser(user.getFirstName(), user.getLastName(), HOMEOWNER_USERNAME, HOMEOWNER_PASSWORD, TEST_POSTCODE);
		//job =jobSubmitter.submitMetalWorkerJobForExistingUser("sw1e 6dr");
		
		
		homeOwnerJobUpdateActions.login(HOMEOWNER_USERNAME, HOMEOWNER_PASSWORD, "/log-in");
		homeOwnerJobUpdateActions.updateJob(job.getId());
		homeOwnerJobUpdateActions.verifyUpdateJob();
		//homeOwnerJobUpdateActions.postJobAndAssertTextWhileUpdatingJob();
	}
}
