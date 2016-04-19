package uk.co.ratedpeople.test.functional.selenium.ho.rating;

import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpResponse;

import uk.co.ratedpeople.APIJob;
import uk.co.ratedpeople.IntegrationTestUsers;
import uk.co.ratedpeople.JobPurchaseOrderSubmitter;
import uk.co.ratedpeople.JobSubmitter;
import uk.co.ratedpeople.RatingRequestSubmitter;
import uk.co.ratedpeople.UserRetriever;

public class SubmitRatingPreReqCompleter {
		
	private UserRetriever userRetriever = new UserRetriever();
	private JobPurchaseOrderSubmitter poSubmitter = new JobPurchaseOrderSubmitter();
	private JobSubmitter jobSubmitter = new JobSubmitter();	
	private RatingRequestSubmitter ratingRequestSubmitter = new RatingRequestSubmitter();
	
	
	public void postPurchaseAndRequestRatingForJob() throws Exception {	
		APIJob jobSubmitted = jobSubmitter.submitJob("Integration", "Homeowner", "test.homeowner@ratedtrades.com", "password", "07712388456", JobSubmitter.Trade.PLUMBER, "18", JobSubmitter.Budget.RANGE_100_250, "SE228JH");
		String jobReference = jobSubmitted.getId();
		int userid = userRetriever.getUserId(IntegrationTestUsers.TP_INTEGRATION_TEST, IntegrationTestUsers.TP_PASSWORD);	
		HttpResponse purchaseResponse =  poSubmitter.postPurchaseOrderWithoutCard(IntegrationTestUsers.TP_INTEGRATION_TEST, IntegrationTestUsers.TP_PASSWORD, userid, jobReference);
		if(purchaseResponse.getStatusLine().getStatusCode() != HttpServletResponse.SC_CREATED) {
			throw new Exception("Error purchasing the job");
		}
		HttpResponse ratingResponse = ratingRequestSubmitter.createAndPostRatingRequest(IntegrationTestUsers.TP_INTEGRATION_TEST, IntegrationTestUsers.TP_PASSWORD, userid, jobReference);
		if(ratingResponse.getStatusLine().getStatusCode() != HttpServletResponse.SC_CREATED) {
			throw new Exception("Error purchasing the job");
		}		
	}	 
	
}
