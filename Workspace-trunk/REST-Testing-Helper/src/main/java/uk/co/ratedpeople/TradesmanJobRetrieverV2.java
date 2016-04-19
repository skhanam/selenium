package uk.co.ratedpeople;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpUriRequest;

import uk.co.ratedpeople.HttpRequestCreator;
import uk.co.ratedpeople.HttpRequestExecutor;

public class TradesmanJobRetrieverV2 {

	private static final Logger LOGGER = Logger.getLogger(TradesmanJobRetrieverV2.class.getName());
		

	private HttpRequestCreator requestCreator = new HttpRequestCreator();
	private HttpRequestExecutor requestExecutor = new HttpRequestExecutor();
	
	private String getJobUri(int userid, String jobRef){
		return "/api/v2/tradesmen/" + userid + "/jobs/" + jobRef;
	}
	
	private String getAvailableJobListURI(int userid, int startIndex, int numberOfItems) {
		return "/api/v2/tradesmen/" + userid + "/jobs/available?start_index=" + startIndex + "&numberOfItems=" + numberOfItems;
	}
	
	private String getPurchasedJobListURI(int userid, int startIndex, int numberOfItems) {
		return "/api/v2/tradesmen/" + userid + "/jobs/purchased?start_index=" + startIndex + "&numberOfItems=" + numberOfItems;
	}
	
	/**
	 * Get a single job
	 * @param username Username of logged in user
	 * @param password Password of logged in user
	 * @param userid Id of user whose view of the job should be returned
	 * @param jobRef Reference number of job
	 * @return Response from server
	 * @throws Exception
	 */
	public HttpResponse getJob(String username, String password, int userid, String jobRef) throws Exception {
		final String getJobURI = getJobUri(userid, jobRef);
		LOGGER.log(Level.INFO, "GetJobDetailsUri={0}", getJobURI);
		HttpUriRequest request = requestCreator.createGetRequestForUri(getJobURI);
		requestCreator.assignDefaultAuthenticationHeader(request, username, password);
		
		HttpResponse resp = requestExecutor.execute(request);
		
		int statusCode = resp.getStatusLine().getStatusCode();
		LOGGER.log(Level.INFO, "Job retrieved. Response Status Code = {0}", statusCode);
		
		return resp;
	}
	
	
	/**
	 * Get a list of available jobs for a tradesman ordered by submitted date
	 * @param username Username of logged in user
	 * @param password Password of logged in user
	 * @param userid Id of user whose view of the job should be returned
	 * @param startIndex Start of list (the start of the list is index 1)
	 * @param numberOfJobs Number of jobs to retrieve
	 * @return
	 * @throws ParseException 
	 * @throws NoSuchAlgorithmException 
	 * @throws SignatureException 
	 * @throws InvalidKeyException 
	 * @throws IOException 
	 * @throws ClientProtocolException 
	 */
	public HttpResponse getAvailableJobs(String username, String password, int userid, int startIndex, int numberOfJobs) throws InvalidKeyException, SignatureException, NoSuchAlgorithmException, ParseException, ClientProtocolException, IOException {
		HttpUriRequest request = requestCreator.createGetRequestForUri(getAvailableJobListURI(userid, startIndex, numberOfJobs));
		requestCreator.assignDefaultAuthenticationHeader(request, username, password);
		
		HttpResponse resp = requestExecutor.execute(request);
		
		int statusCode = resp.getStatusLine().getStatusCode();
		LOGGER.log(Level.INFO, "Available jobs retrieved. Response Status Code = {0}", statusCode);
		
		return resp;
	}
	
	/**
	 * Get a list of purchasedjobs for a tradesman ordered by submitted date
	 * @param username Username of logged in user
	 * @param password Password of logged in user
	 * @param userid Id of user whose view of the job should be returned
	 * @param startIndex Start of list (the start of the list is index 1)
	 * @param numberOfJobs Number of jobs to retrieve
	 * @return
	 * @throws ParseException 
	 * @throws NoSuchAlgorithmException 
	 * @throws SignatureException 
	 * @throws InvalidKeyException 
	 * @throws IOException 
	 * @throws ClientProtocolException 
	 */
	public HttpResponse getPurchasedJobs(String username, String password, int userid, int startIndex, int numberOfJobs) throws InvalidKeyException, SignatureException, NoSuchAlgorithmException, ParseException, ClientProtocolException, IOException {
		HttpUriRequest request = requestCreator.createGetRequestForUri(getPurchasedJobListURI(userid, startIndex, numberOfJobs));
		requestCreator.assignDefaultAuthenticationHeader(request, username, password);
		
		HttpResponse resp = requestExecutor.execute(request);
		
		int statusCode = resp.getStatusLine().getStatusCode();
		LOGGER.log(Level.INFO, "Purchased jobs retrieved. Response Status Code = {0}", statusCode);
		
		return resp;
	}
}
