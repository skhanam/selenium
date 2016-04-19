package uk.co.ratedpeople.test.functional.selenium.tp;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import uk.co.ratedpeople.test.functional.selenium.TestScript;
import uk.co.ratedpeople.test.functional.selenium.tp.functions.ViewJob;

public class ViewJobTest extends TestScript {

	private ViewJob viewJob;

	@BeforeClass
	public void beforeClass() throws IOException {
		viewJob = new ViewJob(this.context, scriptUtilities);		
	}

	@Test (enabled=true)
	public void testViewJob() throws Exception {
		viewJob.viewJob();
	}
}