package uk.co.ratedpeople;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpUriRequest;

import uk.co.ratedpeople.APIAccessConstants;
import uk.co.ratedpeople.HeaderHelper;
import uk.co.ratedpeople.HttpRequestCreator;
import uk.co.ratedpeople.HttpRequestExecutor;

public class RatingRequestSubmitter {

	private static final Logger LOGGER = Logger.getLogger(RatingRequestSubmitter.class.getName());
	
	private final HttpRequestCreator requestCreator;
	private final HttpRequestExecutor requestExecutor;
	private HeaderHelper headerHelper;
	
	public RatingRequestSubmitter(){
		requestCreator = new HttpRequestCreator();
		requestExecutor = new HttpRequestExecutor();
		headerHelper = new HeaderHelper();
	}
	
	public HttpResponse createAndPostRatingRequest(String username, String password, int tmUserId, String jobReference) throws Exception {
		final String uri = "/api/v1/tradesmen/"+tmUserId+"/jobs/"+jobReference+"/rating_requests";
		LOGGER.log(Level.INFO, "sumbit Rating Request URI={0}", uri);
		HttpUriRequest request = requestCreator.createPostRequestForUri(uri);
		String authnHeader = headerHelper.createAuthnHeader(username, password);
		request.setHeader(APIAccessConstants.AUTHENTICATION_HEADER_NAME, authnHeader);		
		HttpResponse response = requestExecutor.execute(request);
		return response;
	}
}
