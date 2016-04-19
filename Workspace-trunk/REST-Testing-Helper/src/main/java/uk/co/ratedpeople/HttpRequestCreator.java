package uk.co.ratedpeople;

import static uk.co.ratedpeople.APIAccessConstants.AUTHENTICATION_HEADER_NAME;
import static uk.co.ratedpeople.APIAccessConstants.AUTHORIZATION_HEADER_NAME;
import static uk.co.ratedpeople.APIAccessConstants.RP_DATE_HEADER_NAME;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.http.HttpRequest;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;

public class HttpRequestCreator {

	private static final Logger LOGGER = Logger.getLogger(HttpRequestCreator.class.getName());

	private TestContext testContext;

	public HttpRequestCreator(TestContext testContext) {
		this.testContext = testContext;
	}

	public HttpRequestCreator() {
		try {
			testContext = TestContext.getDefault();
		} catch (IOException io) {
			throw new IllegalStateException("Issue constructing HttpRequestCreator with default test context", io);
		}
	}

	public HttpGet createGetRequestForUri(String uri) throws MalformedURLException, InvalidKeyException, SignatureException,
					UnsupportedEncodingException, NoSuchAlgorithmException, ParseException {
		LOGGER.info("about to GET request: {host: '" + getTestHttpsUrl() + "', uri: '" + uri + "' }");
		final URL url = new URL(this.getTestHttpsUrl() + uri);
		HttpGet request = new HttpGet(url.toString());
		assignDefaultAuthorizationHeaderForGet(request);
		return request;
	}

	public HttpGet createGetRequestForUri(String uri, String accessKey, String accessKeyId) throws MalformedURLException, InvalidKeyException,
					SignatureException, UnsupportedEncodingException, NoSuchAlgorithmException, ParseException {
		LOGGER.info("about to GET request: {host: '" + getTestHttpsUrl() + "', uri: '" + uri + "' }");
		final URL url = new URL(this.getTestHttpsUrl() + uri);
		HttpGet request = new HttpGet(url.toString());
		assignCustomAuthorizationHeaderForGet(request, accessKey, accessKeyId);
		return request;
	}

	public HttpPost createPostRequestForUri(String uri) throws MalformedURLException, InvalidKeyException, SignatureException,
					UnsupportedEncodingException, NoSuchAlgorithmException, ParseException {
		LOGGER.info("about to POST request to: {host: '" + getTestHttpsUrl() + "', uri: '" + uri + "' }");
		URL url = new URL(getTestHttpsUrl() + uri);
		HttpPost request = new HttpPost(url.toString());
		assignDefaultAuthorizationHeaderForPost(request, HeaderHelper.APPLICATION_XML_CONTENT_TYPE);
		return request;
	}
	
	

	public HttpPost createMultipartPostRequestForUri(String uri) throws MalformedURLException, InvalidKeyException, SignatureException,
					UnsupportedEncodingException, NoSuchAlgorithmException, ParseException {
		LOGGER.info("about to POST request to: {host: '" + getTestHttpsUrl() + "', uri: '" + uri + "' }");
		URL url = new URL(getTestHttpsUrl() + uri);
		// Use a URL like following if you want to send the post to netcat/nc
		// for debugging
		// URL url = new URL("http://devbox10.uk.ratedpeople:9999/" + uri);
		HttpPost request = new HttpPost(url.toString());
		assignDefaultAuthorizationHeaderForPost(request, HeaderHelper.APPLICATION_XML_CONTENT_TYPE);
		return request;
	}

	public HttpPut createMultipartPutRequestForUri(String uri) throws MalformedURLException, InvalidKeyException, SignatureException,
					UnsupportedEncodingException, NoSuchAlgorithmException, ParseException {
		LOGGER.info("about to PUT request to: {host: '" + getTestHttpsUrl() + "', uri: '" + uri + "' }");
		URL url = new URL(getTestHttpsUrl() + uri);
		HttpPut request = new HttpPut(url.toString());
		assignDefaultAuthorizationHeaderForPut(request);
		return request;
	}

	public HttpPut createPutRequestForUri(String uri) throws MalformedURLException, InvalidKeyException, SignatureException,
					UnsupportedEncodingException, NoSuchAlgorithmException, ParseException {
		LOGGER.info("about to PUT request to: {host: '" + getTestHttpsUrl() + "', uri: '" + uri + "' }");
		URL url = new URL(getTestHttpsUrl() + uri);
		HttpPut request = new HttpPut(url.toString());
		assignDefaultAuthorizationHeaderForPut(request);
		return request;
	}

	public HttpPut createPutRequestForSupportUri(String uri) throws MalformedURLException, InvalidKeyException, SignatureException, UnsupportedEncodingException, NoSuchAlgorithmException, ParseException {
		LOGGER.info("about to PUT request to: {host: '" + getSupportUrl() + "', uri: '" + uri + "' }");
		URL url = new URL(getSupportUrl() + uri);
		HttpPut request =  new HttpPut(url.toString());
		assignDefaultAuthorizationHeaderForPut(request);
		return request;
	}

	public HttpDelete createDeleteRequestForUri(String uri) throws MalformedURLException, InvalidKeyException, SignatureException,
					UnsupportedEncodingException, NoSuchAlgorithmException, ParseException {
		LOGGER.info("about to DELETE request to: {host: '" + getTestHttpsUrl() + "', uri: '" + uri + "' }");
		URL url = new URL(getTestHttpsUrl() + uri);
		HttpDelete request = new HttpDelete(url.toString());
		assignDefaultAuthorizationHeaderForDelete(request);
		return request;
	}

	/**
	 * 
	 * @param request
	 * @throws ParseException
	 * @throws InvalidKeyException
	 * @throws SignatureException
	 * @throws UnsupportedEncodingException
	 * @throws NoSuchAlgorithmException
	 */
	public void assignDefaultAuthorizationHeaderForGet(HttpUriRequest request) throws ParseException, InvalidKeyException, SignatureException,
					UnsupportedEncodingException, NoSuchAlgorithmException {
		Date date = getDefaultDateForHeaders();
		String header = new HeaderHelper().createGetAuthzHeader(request.getURI().getPath(), date);
		request.setHeader(AUTHORIZATION_HEADER_NAME, header);
		request.setHeader(RP_DATE_HEADER_NAME, date.toString());
	}
	
	public HttpPut createPutRequestForapp1Uri(String uri) throws MalformedURLException, InvalidKeyException, SignatureException, UnsupportedEncodingException, NoSuchAlgorithmException, ParseException {
		LOGGER.info("about to PUT request to: {host: '" + getTestapp1Url() + "', uri: '" + uri + "' }");
		URL url = new URL(getTestapp1Url() + uri);
		HttpPut request =  new HttpPut(url.toString());
		assignDefaultAuthorizationHeaderForPut(request);
		return request;
	}
	
	public HttpPut createPutRequestForapp2Uri(String uri) throws MalformedURLException, InvalidKeyException, SignatureException, UnsupportedEncodingException, NoSuchAlgorithmException, ParseException {
		LOGGER.info("about to PUT request to: {host: '" + getTestapp2Url() + "', uri: '" + uri + "' }");
		URL url = new URL(getTestapp2Url() + uri);
		HttpPut request =  new HttpPut(url.toString());
		assignDefaultAuthorizationHeaderForPut(request);
		return request;
	}

	public void assignCustomAuthorizationHeaderForGet(HttpUriRequest request, String accessKey, String accessKeyId) throws ParseException,
					InvalidKeyException, SignatureException, UnsupportedEncodingException, NoSuchAlgorithmException {
		Date date = getDefaultDateForHeaders();
		String header = new HeaderHelper().createGetAuthzHeader(request.getURI().getPath(), date, accessKey, accessKeyId);
		request.setHeader(AUTHORIZATION_HEADER_NAME, header);
		request.setHeader(RP_DATE_HEADER_NAME, date.toString());
	}

	public void assignDefaultAuthorizationHeaderForPost(HttpUriRequest request, String contentType) throws ParseException, InvalidKeyException,
					SignatureException, UnsupportedEncodingException, NoSuchAlgorithmException {
		Date date = getDefaultDateForHeaders();
		String header = new HeaderHelper().createPostAuthzHeader(request.getURI().getPath(), contentType, date);
		request.setHeader(AUTHORIZATION_HEADER_NAME, header);
		request.setHeader("Content-Type", contentType);
		request.setHeader(RP_DATE_HEADER_NAME, date.toString());
	}

	public void assignDefaultAuthorizationHeaderForMultipartPost(HttpUriRequest request) throws ParseException, InvalidKeyException,
					SignatureException, UnsupportedEncodingException, NoSuchAlgorithmException {
		Date date = getDefaultDateForHeaders();
		String header = new HeaderHelper().createPostAuthzHeader(request.getURI().getPath(), HeaderHelper.MULTIPART_CONTENT_TYPE, date);
		// Do not add content-type header to multipart request as that should be
		// done by multipart entity class
		// because it needs to set boundary parameter as part of the content
		// type header value.
		request.setHeader(AUTHORIZATION_HEADER_NAME, header);
		request.setHeader(RP_DATE_HEADER_NAME, date.toString());
	}

	public void assignDefaultAuthorizationHeaderForPut(HttpUriRequest request) throws ParseException, InvalidKeyException, SignatureException,
					UnsupportedEncodingException, NoSuchAlgorithmException {
		Date date = getDefaultDateForHeaders();
		String header = new HeaderHelper().createPutAuthzHeader(request.getURI().getPath(), date);
		request.setHeader(AUTHORIZATION_HEADER_NAME, header);
		request.setHeader("Content-Type", "application/xml");
		request.setHeader(RP_DATE_HEADER_NAME, date.toString());
	}

	public void assignDefaultAuthorizationHeaderForDelete(HttpUriRequest request) throws ParseException, InvalidKeyException, SignatureException,
					UnsupportedEncodingException, NoSuchAlgorithmException {
		Date date = getDefaultDateForHeaders();
		String header = new HeaderHelper().createDeleteAuthzHeader(request.getURI().getPath(), date);
		request.setHeader(AUTHORIZATION_HEADER_NAME, header);
		request.setHeader(RP_DATE_HEADER_NAME, date.toString());
	}

	public void assignDefaultAuthenticationHeader(HttpRequest request, String username, String password) throws InvalidKeyException,
					SignatureException {
		AuthenticationHeaderGenerator authenticationGenerator = new AuthenticationHeaderGenerator();
		String userAuthHeader = authenticationGenerator.getAuthenticationHeader(username, DigestUtils.md5Hex(password), testContext.getAccessKeyId(),
				testContext.getAccessKey());
		request.setHeader(AUTHENTICATION_HEADER_NAME, userAuthHeader);
	}

	public void assignDefaultAuthenticationHeaderFromHashedPassword(HttpRequest request, String username, String hashedPassword)
					throws InvalidKeyException, SignatureException {
		AuthenticationHeaderGenerator authenticationGenerator = new AuthenticationHeaderGenerator();
		String userAuthHeader = authenticationGenerator.getAuthenticationHeader(username, hashedPassword, testContext.getAccessKeyId(), testContext.getAccessKey());
		request.setHeader(AUTHENTICATION_HEADER_NAME, userAuthHeader);
	}

	private Date getDefaultDateForHeaders() throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd hh:mm");
		return formatter.parse("2010/01/20 18:25");
	}

	protected String getTestUrl() {
		return testContext.getTestUrl();
	}

	protected String getTestHttpsUrl() {
		return testContext.getTestHttpsUrl();
	}

	public TestContext getTestContext() {
		return testContext;
	}

	protected String getSupportUrl() {
		return testContext.getSupportUrl();
	}

	protected String getTestapp1Url() {
		return testContext.getTestapp1Url();
	}
	protected String getTestapp2Url() {
		return testContext.getTestapp2Url();
	}

}
