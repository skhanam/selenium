/**
 * 
 */
package uk.co.ratedpeople.test.functional.selenium.featureposting;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import uk.co.ratedpeople.test.functional.selenium.TestScript;
import uk.co.ratedpeople.test.functional.selenium.newjobforms.generic.PostingJobviaGenericJobForm;
import uk.co.ratedpeople.test.functional.selenium.updatejob.UpdateExistingJob;
/**
 * @author shobha.rani
 *
 */
public class UpdateExistingjobTest extends TestScript {

	private PostingJobviaGenericJobForm newJobPost;
	private UpdateFeatureJob underTest;	
	private static final String DESCRIPTION = "This is a long description for the job, and hopefully this will suffice.";
	private static final String NEW_BUDGET_RANGE = "RANGE_500_1000";
	private static final String NEW_BUDGET_TEXT = "Under £1,000";

	@BeforeClass
	public void beforeClass() throws Exception {
		
		
		newJobPost = new PostingJobviaGenericJobForm(context, scriptUtilities);
		underTest = new UpdateFeatureJob(context, scriptUtilities);
		
	}

	@Test(enabled=true)
	public void verifyFeaturepostbuttonpresent() throws Exception {
		String userName = underTest.getUserName();
		String password = underTest.getPassword();
		newJobPost.postingJobviaNewGenericJobformDotCom(userName, underTest.getPostcode(), "31", "flooring", DESCRIPTION);
		//underTest.postingJobviaNewGenericJobformDotCom(userName, underTest.getPostcode(), "31", "flooring", DESCRIPTION);
		Thread.sleep(5000);
		underTest.loginToHomeownersApp(userName, password);
	    underTest.goToJobPage();
		underTest.Featurebuttonspresent();
}
	@Test(enabled=true)
	public void verifyFreepostUpdatecommstest() throws Exception {
		String userName = underTest.getUserName();
		String password = underTest.getPassword();
		newJobPost.postingJobviaNewGenericJobformDotCom(userName, underTest.getPostcode(), "31", "flooring", DESCRIPTION);
		Thread.sleep(5000);
		underTest.loginToHomeownersApp(userName, password);
		underTest.goToJobPage();
		underTest.freepostjobcomms();
			
		
	}
	
	@Test(enabled=true)
	public void verifyFeaturepostUpdatecommstest() throws Exception {
		String userName = underTest.getUserName();
		String password = underTest.getPassword();
		newJobPost.postingJobviaNewGenericJobformDotCom(userName, underTest.getPostcode(), "31", "flooring", DESCRIPTION);
		Thread.sleep(5000);
		underTest.loginToHomeownersApp(userName, password);
		underTest.goToJobPage();
		underTest.Featurepostjobcomms();
		//underTest.verifyCCAHOFeaturepostedjobs();
		underTest.tmTPWebLogin();
	}
	
	@Test(enabled=true)		
    public void verifycancelandFeatureposttest() throws Exception {
		String userName = underTest.getUserName();
		String password = underTest.getPassword();
		newJobPost.postingJobviaNewGenericJobformDotCom(userName, underTest.getPostcode(), "31", "flooring", DESCRIPTION);
		Thread.sleep(5000);
		underTest.loginToHomeownersApp(userName, password);
		underTest.goToJobPage();
    	
    	underTest.FeaturepostCancelandUpgradejob();
    	//underTest.tmTPWebLogin();
    	
    }
		
    			
		
    
	
	}

