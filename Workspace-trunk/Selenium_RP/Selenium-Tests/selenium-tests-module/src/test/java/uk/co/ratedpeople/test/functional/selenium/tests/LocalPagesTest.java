package uk.co.ratedpeople.test.functional.selenium.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import uk.co.ratedpeople.test.functional.selenium.TestScript;
import uk.co.ratedpeople.test.functional.selenium.functions.LocalPages;
import uk.co.ratedpeople.test.functional.selenium.functions.SubmitJobAsNewCustomer;

/**
 * This class tests is disabled as the local pages have been modified.
 * You find new tests for local in uk.co.ratedpeople.test.functional.selenium.local;
 * danthalapalli.aravind
 */

public class LocalPagesTest extends TestScript {
	private LocalPages underTest;
	private SubmitJobAsNewCustomer submitJob;
	private String testUrl;
	
	@BeforeClass
	public void beforeClass() throws Exception {
		underTest = new LocalPages(this.context);	
		submitJob = new SubmitJobAsNewCustomer(this.context, scriptUtilities);	
		testUrl = context.getTestUrl();
	}
	
	@Test (enabled=false)
	public void test() throws Exception {
		underTest.localpages();
		submitJob.submitJobAsNewCustomer(testUrl+"/local");
	}
}