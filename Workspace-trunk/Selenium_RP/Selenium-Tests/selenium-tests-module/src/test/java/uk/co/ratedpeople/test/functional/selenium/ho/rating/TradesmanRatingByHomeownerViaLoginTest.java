package uk.co.ratedpeople.test.functional.selenium.ho.rating;

import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpResponse;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import uk.co.ratedpeople.APIJob;
import uk.co.ratedpeople.JobPurchaseOrderSubmitter;
import uk.co.ratedpeople.JobSubmitter;
import uk.co.ratedpeople.RestDomainXMLBeanUser;
import uk.co.ratedpeople.UserRetriever;
import uk.co.ratedpeople.test.functional.selenium.TestScript;
/**
 * This selenium test is used to test ratings when a homeowner logs in and rates the tradesman.
 * It uses rest calls to generate the proper scenario from where the selenium testing via browser can be done. 
 * @author abhiuday.tomar
 *
 */
public class TradesmanRatingByHomeownerViaLoginTest extends TestScript {

	private static final String HOMEOWNER_USERNAME = "test.homeowner@ratedtrades.com";
	private static final String HOMEOWNER_PASSWORD = "password";
	
	private static final String TRADESMAN_USERNAME = "integration.test@ratedtrades.com";
	private static final String TRADESMAN_PASSWORD = "password";
	
	private static final String TEST_POSTCODE = "HA9 9AR";
	
	private JobSubmitter jobSubmitter;
	private JobPurchaseOrderSubmitter poSubmitter;
	private HomeownerActions homeOwnerActions;
	private UserRetriever userRetriever;
	private RestDomainXMLBeanUser user;
	private APIJob job;
	
	@BeforeClass
	public void beforeClass() throws Exception{
		jobSubmitter = new JobSubmitter();
		poSubmitter = new JobPurchaseOrderSubmitter();
		userRetriever = new UserRetriever();
		homeOwnerActions = new HomeownerActions(this.context);
		user = userRetriever.getUser(HOMEOWNER_USERNAME, HOMEOWNER_PASSWORD);		
	}
	
	@Test (enabled = false)
	public void testPostRating2And5Star() throws Exception{
		job = jobSubmitter.submitMetalWorkerJobForGivenUser(user.getFirstName(), user.getLastName(), HOMEOWNER_USERNAME, HOMEOWNER_PASSWORD, TEST_POSTCODE);
		
		int tradesmanId = userRetriever.getUserId(TRADESMAN_USERNAME, TRADESMAN_PASSWORD);
		HttpResponse httpResponse = poSubmitter.postPurchaseOrderWithoutCard(TRADESMAN_USERNAME, TRADESMAN_PASSWORD, tradesmanId,job.getId());
		
		Assert.assertEquals(httpResponse.getStatusLine().getStatusCode(), HttpServletResponse.SC_CREATED,"Getting wrong response back!");
		
		homeOwnerActions.login(HOMEOWNER_USERNAME, HOMEOWNER_PASSWORD,"/log-in");
		homeOwnerActions.postFirstCommentWithPoorRating(job.getId());
		
		homeOwnerActions.goToArchivedJobs();
		homeOwnerActions.postSecondCommentWithExceptionalRating(job.getId());		
	}
	
}
