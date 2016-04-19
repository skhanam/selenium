/**
 * 
 */
package uk.co.ratedpeople.test.functional.selenium.featureposting;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import uk.co.ratedpeople.test.functional.selenium.TestScript;
import uk.co.ratedpeople.test.functional.selenium.newjobforms.generic.PostingJobviaGenericJobForm;

/**
 * @author shobha.rani
 *
 */
public class CcaHOTMtest extends TestScript {
	private PostingJobviaGenericJobForm newJobPost;
	private UpdateFeatureJob underTest;
	
	@BeforeClass
	public void beforeClass() throws Exception {
		
		
		newJobPost = new PostingJobviaGenericJobForm(context, scriptUtilities);
		underTest = new UpdateFeatureJob(context, scriptUtilities);
		
	}
	
	 @Test(enabled=false)		
	    public void verifyCCAHoFeatureposttest() throws Exception {
	    	
	    	underTest.verifyCCAHOFeaturepostedjobs();
	    	
	    }

}
