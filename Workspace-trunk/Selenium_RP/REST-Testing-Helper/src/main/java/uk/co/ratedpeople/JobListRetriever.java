package uk.co.ratedpeople;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.text.ParseException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpUriRequest;

import uk.co.ratedpeople.HttpRequestCreator;
import uk.co.ratedpeople.HttpRequestExecutor;

public class JobListRetriever {

	private HttpRequestCreator requestCreator = new HttpRequestCreator();
	private HttpRequestExecutor requestExecutor = new HttpRequestExecutor();
	
	public HttpResponse getPurchasedJobList(int tradesmanUserId, String userName, String password, int numberOfItems, String includeParams, String excludeParams) throws InvalidKeyException, SignatureException, NoSuchAlgorithmException, ParseException, ClientProtocolException, IOException { 
		String uri = "/api/v1/tradesmen/"+ tradesmanUserId + "/jobs/purchased?start_index=1&number_of_items=" + numberOfItems;
		if (includeParams != null) {
			uri += "&include_only=" + includeParams;
		}
		if (excludeParams != null) {
			uri += "&exclude=" + excludeParams;
		}
		
		HttpUriRequest request = requestCreator.createGetRequestForUri(uri);
		requestCreator.assignDefaultAuthenticationHeader(request, userName, password);
		
		long start = System.currentTimeMillis();
		HttpResponse response = requestExecutor.execute(request);
		long end = System.currentTimeMillis();
		System.out.println("GET list took " + (end-start) + " ms");
		return response;
	}
}
