package uk.co.ratedpeople;


import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;

public class HomeOwnerJobRetriever {
	
	private static final Logger LOGGER = Logger.getLogger(HomeOwnerJobRetriever.class.getName());

	private final HttpRequestCreator requestCreator;
	private final HttpRequestExecutor requestExecutor;

	public HomeOwnerJobRetriever() {
		requestCreator = new HttpRequestCreator();
		requestExecutor = new HttpRequestExecutor();
	}
	
	public HttpResponse getPrivateJobDetails(int homeOwnerId, String jobReference, String username, String password) throws Exception {
		return getPrivateJobDetails(String.valueOf(homeOwnerId), jobReference, username, password);
	}

	/**
	 *  
	 * @param homeOwnerId
	 * @param jobReference
	 * @param username
	 * @param password
	 * @return HomeOwner's private job details v1 resource
	 * @throws Exception
	 */
	public HttpResponse getPrivateJobDetails(String homeOwnerId, String jobReference, String username, String password) throws Exception {
		return getPrivateJobDetailsWithHashedPassword(homeOwnerId, jobReference, username, DigestUtils.md5Hex(password));
	}
	
	/**
	 * 
	 * @param homeOwnerId
	 * @param jobReference
	 * @param username Username of authentication user
	 * @param hashedPassword MD5 Hash of password for authentication user
	 * @return Http Response
	 * @throws Exception
	 */
	public HttpResponse getPrivateJobDetailsWithHashedPassword(String homeOwnerId, String jobReference, String username, String hashedPassword) throws Exception {
		String uri = "/api/v1/homeowner/" + homeOwnerId + "/job/" + jobReference;
		HttpGet get = requestCreator.createGetRequestForUri(uri);
		requestCreator.assignDefaultAuthenticationHeaderFromHashedPassword(get, username, hashedPassword);
		HttpResponse response = requestExecutor.execute(get);
		int statusCode = response.getStatusLine().getStatusCode();
		LOGGER.log(Level.INFO, "Job retrieved. Response Status Code = {0}", statusCode);
		return response;
	}
}
