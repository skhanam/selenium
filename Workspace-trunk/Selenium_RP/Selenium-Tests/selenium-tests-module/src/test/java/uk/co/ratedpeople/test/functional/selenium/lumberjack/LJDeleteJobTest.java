package uk.co.ratedpeople.test.functional.selenium.lumberjack;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import uk.co.ratedpeople.test.functional.selenium.TestScript;


/**
 * 
 * @author ruhulla.mohammad
 */
public class LJDeleteJobTest extends TestScript {

	private LumberJack DeleteJob;
	private final String USER = "integration.test@ratedtrades.com";
	final String DELETE_REASON_OTHER = "reason_7"; //other
	private final String POSTCODE = "SW1E 6AU";

	@BeforeClass
	public void beforeClass() throws Exception {
		DeleteJob = new LumberJack(context, scriptUtilities);
	}

	@Test(enabled = true) 
	public void DeleteJobFromLeadListPage() throws Exception {
		DeleteJob.testDeleteJobFromLeadListPage(USER, DELETE_REASON_OTHER, POSTCODE);
	}

	@Test(enabled = true) 
	public void DeleteJobFromFullDetailsPage() throws Exception {
		DeleteJob.testDeleteJobFromFullDetailsPage(USER, DELETE_REASON_OTHER, POSTCODE);
	}

}