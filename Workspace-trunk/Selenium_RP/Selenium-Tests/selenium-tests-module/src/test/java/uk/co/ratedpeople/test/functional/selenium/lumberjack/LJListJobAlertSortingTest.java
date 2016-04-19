package uk.co.ratedpeople.test.functional.selenium.lumberjack;

import static org.testng.Assert.assertEquals;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpUriRequest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import uk.co.ratedpeople.APIJob;
import uk.co.ratedpeople.HttpRequestCreator;
import uk.co.ratedpeople.HttpRequestExecutor;
import uk.co.ratedpeople.JobSubmitter;
import uk.co.ratedpeople.JobSubmitter.Trade;
import uk.co.ratedpeople.UserRetriever;
import uk.co.ratedpeople.test.functional.selenium.TestScript;

public class LJListJobAlertSortingTest extends TestScript {

	private LumberJack underTest;
	private JobSubmitter jobSubmitter;
	private APIJob first_job_19_6_chimney;
	private APIJob second_job_25_3_plumber;
	private final String POSTCODE = "SW1E 6AU";
	private final String USER = "integration.test@ratedtrades.com";
	private final String PASSWORD = "password";

	private enum SortingCriteria {
		DATE_DESC("date-desc"), DATE_ASC("date-asc"), PRICE_DESC("price-desc"), PRICE_ASC("price-asc");
		private String value;

		private SortingCriteria(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}
	}

	@BeforeClass
	public void beforeClass() throws Exception {
		underTest = new LumberJack(this.context, scriptUtilities);
		jobSubmitter = new JobSubmitter();

		first_job_19_6_chimney = jobSubmitter.submitChimneyBuildingJob(POSTCODE);
		second_job_25_3_plumber = jobSubmitter.submitJob(POSTCODE, Trade.PLUMBER, JobSubmitter.SkillTypeIds.PLUMBER_BATHINSTALL_JOB_TYPE, JobSubmitter.Budget.RANGE_500_1000);
	}

	@AfterClass
	public void afterClass() throws Exception {
		//delete created jobs once the tests have run.
		deleteJobs(USER,PASSWORD, first_job_19_6_chimney.getId(),second_job_25_3_plumber.getId());
	}

	@Test(enabled = true) 
	public void testListJobAlertSortByDateDescTest() throws InterruptedException{
		APIJob[] jobs = new APIJob[]{second_job_25_3_plumber, first_job_19_6_chimney};
		underTest.testListJobAlertSortTest(USER, SortingCriteria.DATE_DESC.getValue(), jobs);
	}

	@Test(enabled = true) 
	public void testListJobAlertSortByDateAscTest() throws InterruptedException {
		APIJob[] jobs = new APIJob[]{first_job_19_6_chimney, second_job_25_3_plumber};
		underTest.testListJobAlertSortTest(USER, SortingCriteria.DATE_ASC.getValue(), jobs);
	}

	@Test(enabled = true) 
	public void testListJobAlertSortByPriceDescTest() throws InterruptedException {
		APIJob[] jobs = new APIJob[]{second_job_25_3_plumber, first_job_19_6_chimney, };
		underTest.testListJobAlertSortTest(USER, SortingCriteria.PRICE_DESC.getValue(), jobs);
	}

	@Test(enabled = true) 
	public void testListJobAlertSortByPriceAscTest() throws InterruptedException {
		APIJob[] jobs = new APIJob[]{first_job_19_6_chimney, second_job_25_3_plumber};
		underTest.testListJobAlertSortTest(USER, SortingCriteria.PRICE_ASC.getValue(), jobs);
	}

	private void deleteJobs(String username, String password, String... jobRefs) throws Exception {
		UserRetriever userRetriever = new UserRetriever();
		int userId = userRetriever.getUserId(username, password);
		HttpRequestCreator requestCreator = new HttpRequestCreator();
		HttpRequestExecutor requestExecutor = new HttpRequestExecutor();
		for(String jobRef: jobRefs){
			String jobUri = "/api/v1/tradesmen/" + userId + "/jobs/available/" + jobRef;
			HttpUriRequest request = requestCreator.createDeleteRequestForUri(jobUri);
			requestCreator.assignDefaultAuthenticationHeader(request, username, password);
			HttpResponse deleteResponse = requestExecutor.execute(request);
			assertEquals(deleteResponse.getStatusLine().getStatusCode(), HttpStatus.SC_OK);
		}
	}

}
