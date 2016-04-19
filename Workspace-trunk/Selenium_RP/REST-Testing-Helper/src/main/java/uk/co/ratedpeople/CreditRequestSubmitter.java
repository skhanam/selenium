package uk.co.ratedpeople;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;

import uk.co.ratedpeople.APIAccessConstants;
import uk.co.ratedpeople.HeaderHelper;
import uk.co.ratedpeople.HttpRequestCreator;
import uk.co.ratedpeople.HttpRequestExecutor;

public class CreditRequestSubmitter {

	private static final Logger LOGGER = Logger.getLogger(CreditRequestSubmitter.class.getName());
	
	private HeaderHelper headerHelper;
	private final HttpRequestCreator requestCreator;
	private final HttpRequestExecutor requestExecutor;

	public CreditRequestSubmitter() {
		requestCreator = new HttpRequestCreator();
		requestExecutor = new HttpRequestExecutor();
		headerHelper = new HeaderHelper();
	}

	public HttpResponse postCreditRequestForJob(String username, String password, int userid, String jobReference, String creditRequestXml) throws Exception {
		LOGGER.log(Level.INFO, "About to Credit Request for jobRef: " + jobReference);
		HttpPost request = createPostCreditRequestForJob(username, password, userid, jobReference);
		setAuthenticationHeader(request, username, password);
		HttpEntity entity = new StringEntity(creditRequestXml);
	    request.setEntity(entity);		
		HttpResponse response = requestExecutor.execute(request);
		return response;
	}

	private HttpPost createPostCreditRequestForJob(String username,	String password, int userid, String jobReference) throws Exception {
		final String postCreditRequestUri = "/api/v1/tradesmen/" + userid + "/jobs/" + jobReference + "/credit_request";
		LOGGER.log(Level.INFO, "postCreditRequest URI={0}", postCreditRequestUri);
		HttpPost request = requestCreator.createPostRequestForUri(postCreditRequestUri);
		return request;
	}

	private void setAuthenticationHeader(HttpPost request, String username,	String password) throws Exception {
		String authnHeader = headerHelper.createAuthnHeader(username, password);
		request.setHeader(APIAccessConstants.AUTHENTICATION_HEADER_NAME, authnHeader);
	}
}
