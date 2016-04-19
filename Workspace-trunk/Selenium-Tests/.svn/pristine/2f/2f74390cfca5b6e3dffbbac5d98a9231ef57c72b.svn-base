package uk.co.ratedpeople.test.functional.selenium.ho.mobile;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import uk.co.ratedpeople.test.functional.selenium.TestScript;

public class MobileJobSubmissionTest extends TestScript {
	
	private MobileJobForm mobileJobForm;
	
	@BeforeClass
	public void beforeClass() throws IOException {
		mobileJobForm = new MobileJobForm(this.context);		
	}
	
	@Test(enabled=false)
	public void mobileJobSubmissionTest() throws InterruptedException{
		mobileJobForm.submitJob("/mobile/job/");
	}

}
