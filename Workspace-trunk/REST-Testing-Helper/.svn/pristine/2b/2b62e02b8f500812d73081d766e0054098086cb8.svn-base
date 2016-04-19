package uk.co.ratedpeople;

import java.io.IOException;
import java.util.logging.Logger;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;

/**
 * Executes HTTP Requests modeled as given {@link HttpUriRequest} objects.
 *  
 * @author christina.fisher
 */
public class HttpRequestExecutor {
	
	private static final Logger LOGGER = Logger.getLogger(HttpRequestExecutor.class.getName());
	
	/**
	 * Send an HTTP Request
	 * 
	 * @param request The request to be sent
	 * @return The response from the server
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public HttpResponse execute(HttpUriRequest request) throws ClientProtocolException, IOException {
		HttpClient httpClient = new HttpClientBuilderForTest().buildTestClient();
		HttpResponse response = httpClient.execute(request);
		LOGGER.info("Made " + request.getMethod() + " request to " + request.getURI().toString() + " response was " + response.getStatusLine().getStatusCode());
		return response;
	}
}
