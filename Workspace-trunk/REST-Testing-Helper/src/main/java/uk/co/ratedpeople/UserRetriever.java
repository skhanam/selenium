package uk.co.ratedpeople;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;

public class UserRetriever {

	private static final Logger LOGGER = Logger.getLogger(UserRetriever.class.getName());

	private HttpRequestCreator requestCreator = new HttpRequestCreator();
	private HttpRequestExecutor requestExecutor = new HttpRequestExecutor();

	public HttpResponse getUserResponse(String username, String password) throws InvalidKeyException, SignatureException, NoSuchAlgorithmException,
					ClientProtocolException, ParseException, IOException {
		return getUserResponse(username, username, password);
	}

	public HttpResponse getUserResponse(String usernameToLookup, String usernameForLogin, String password) throws InvalidKeyException,
					SignatureException, NoSuchAlgorithmException, ParseException, ClientProtocolException, IOException {
		final String uri = "/api/v1/user/" + usernameToLookup;
		HttpGet request = requestCreator.createGetRequestForUri(uri);
		requestCreator.assignDefaultAuthenticationHeader(request, usernameForLogin, password);
		return requestExecutor.execute(request);
	}

	public RestDomainXMLBeanUser getUser(String username, String password) throws Exception {
		return getUser(username, username, password);
	}

	public RestDomainXMLBeanUser getUser(String usernameToLookup, String usernameForLogin, String password) throws Exception {
		HttpResponse response = getUserResponse(usernameToLookup, usernameForLogin, password);

		int statusCode = response.getStatusLine().getStatusCode();
		LOGGER.log(Level.INFO, "User requested. Response Status Code = {0}", statusCode);
		if (statusCode != HttpServletResponse.SC_OK) {
			final String responseBody = new ResponseContentUnwrapper().unwrapContentAsString(response);
			LOGGER.log(Level.SEVERE, "Response: body: " + responseBody);
			throw new IllegalStateException("Status from user retrieval was " + statusCode + ". See log for error");
		}

		RestDomainXMLBeanUser user = transformResponseToUser(response);
		if(user.getEmail()==null){
			user.setEmail(usernameForLogin);
		}
		if(user.getPassword()==null){
			user.setPassword(password);
		}

		return user;
	}

	public RestDomainXMLBeanUser getUserIfExists(String usernameToLookup, String usernameForLogin, String password) throws Exception {
		HttpResponse response = getUserResponse(usernameToLookup, usernameForLogin, password);

		int statusCode = response.getStatusLine().getStatusCode();
		LOGGER.log(Level.INFO, "User requested. Response Status Code = {0}", statusCode);
		if (statusCode != HttpServletResponse.SC_OK) {
			final String responseBody = new ResponseContentUnwrapper().unwrapContentAsString(response);
			LOGGER.log(Level.SEVERE, "Response: body: " + responseBody);
			return null;
		}
		RestDomainXMLBeanUser user = transformResponseToUser(response);
		return user;
	}

	public int getUserId(String usernameToLookup, String usernameForLogin, String password) throws Exception {
		RestDomainXMLBeanUser user = getUser(usernameToLookup, usernameForLogin, password);
		return Integer.parseInt(user.getId());
	}

	public int getUserId(String username, String password) throws Exception {
		return getUserId(username, username, password);
	}

	private RestDomainXMLBeanUser transformResponseToUser(HttpResponse response) throws JAXBException, IllegalStateException, IOException {
		JAXBContext context = JAXBContext.newInstance(RestDomainXMLBeanUser.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		RestDomainXMLBeanUser user = (RestDomainXMLBeanUser) unmarshaller.unmarshal(response.getEntity().getContent());
		return user;
	}

	public User getFacadeUser(String username, String password) throws Exception {
		return getFacadeUser(username, username, password);
	}

	public User getFacadeUser(String usernameToLookup, String usernameForLogin, String password) throws Exception {
		HttpResponse response = callAPIAndAssertIsOK(usernameToLookup, usernameForLogin, password);
		User user = transformResponseToFacadeUser(response);

		return user;
	}

	private HttpResponse callAPIAndAssertIsOK(String usernameToLookup, String usernameForLogin, String password) throws InvalidKeyException,
					SignatureException, NoSuchAlgorithmException, ParseException, ClientProtocolException, IOException {
		HttpResponse response = getUserResponse(usernameToLookup, usernameForLogin, password);

		int statusCode = response.getStatusLine().getStatusCode();
		LOGGER.log(Level.INFO, "User requested. Response Status Code = {0}", statusCode);
		if (statusCode != HttpServletResponse.SC_OK) {
			final String responseBody = new ResponseContentUnwrapper().unwrapContentAsString(response);
			LOGGER.log(Level.SEVERE, "Response: body: " + responseBody);
		}

		return response;
	}

	private User transformResponseToFacadeUser(HttpResponse response) throws JAXBException, IllegalStateException, IOException {
		JAXBContext context = JAXBContext.newInstance(User.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		User user = (User) unmarshaller.unmarshal(response.getEntity().getContent());
		return user;
	}

}
