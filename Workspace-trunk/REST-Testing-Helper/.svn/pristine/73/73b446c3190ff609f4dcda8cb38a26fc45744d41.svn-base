package uk.co.ratedpeople;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.text.ParseException;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.w3c.dom.Document;

public class HttpClientTest {
	private static final Logger LOGGER = Logger.getLogger(HttpClientTest.class.getName());
	
	protected HttpRequestCreator requestCreator;
	private HttpRequestExecutor requestExecutor;
	protected TestContext testContext;

	/**
	 * Beware! Protected - used by some subclasses!
	 */
	protected XmlUtils xmlUtils;

	protected HttpResponseUtils httpResponseUtils;
	protected XmlDocumentUtils xmlDocUtils;

	private static final Date IGNORE_TEST_UNTIL = new GregorianCalendar(2013, 5, 15).getTime();

	public HttpClientTest() {		
		this.requestExecutor = new HttpRequestExecutor();
		this.xmlUtils = new XmlUtils();
		this.httpResponseUtils = new HttpResponseUtils();
		this.xmlDocUtils = new XmlDocumentUtils();
	}

	protected String getTestUrl() {
		return testContext.getTestUrl();
	}

	protected String getTestHttpsUrl() {
		return testContext.getTestHttpsUrl();
	}
	
	protected String getTestHostName() {
		return testContext.getTestHostName();
	}

	protected HttpClient getHttpClient() {
		return new DefaultHttpClient();
	}
	
	protected HttpGet createGetRequestForUri(String uri) throws MalformedURLException, InvalidKeyException, SignatureException, UnsupportedEncodingException, NoSuchAlgorithmException, ParseException {
		return requestCreator.createGetRequestForUri(uri);		
	}
	
	protected HttpGet createGetRequestForUri(String uri, String accessKey, String accessKeyId) throws MalformedURLException, InvalidKeyException, SignatureException, UnsupportedEncodingException, NoSuchAlgorithmException, ParseException {
		return requestCreator.createGetRequestForUri(uri, accessKey, accessKeyId);		
	}
	
	protected HttpPost createPostRequestForUri(String uri) throws MalformedURLException, InvalidKeyException, SignatureException, UnsupportedEncodingException, NoSuchAlgorithmException, ParseException {
		return requestCreator.createPostRequestForUri(uri);
	}
	
	protected HttpDelete createDeleteRequestForUri(String uri) throws MalformedURLException, InvalidKeyException, SignatureException, UnsupportedEncodingException, NoSuchAlgorithmException, ParseException {
		return requestCreator.createDeleteRequestForUri(uri);
	}
	
	protected HttpPut createPutRequestForUri(String uri) throws MalformedURLException, InvalidKeyException, SignatureException, UnsupportedEncodingException, NoSuchAlgorithmException, ParseException {
		return requestCreator.createPutRequestForUri(uri);
	}
	
	protected HttpResponse execute(HttpUriRequest request) throws ClientProtocolException, IOException {
		return requestExecutor.execute(request);
	}
	
	protected Document documentFromResponseBody(HttpResponse response) throws Exception {
		final Document doc = this.httpResponseUtils.documentFromResponseBody(response);
		return doc;
	}
	
	protected Document documentFromEncryptedResponseBody(HttpResponse response,String encryptionKey) throws Exception {
		final Document doc = this.httpResponseUtils.documentFromEncryptedResponseBody(response, encryptionKey);
		return doc;
	}

	protected void assertErrorPresent(final Document doc, String errorCodeName) throws Exception {
		this.xmlDocUtils.assertErrorPresent(doc, errorCodeName);
	}
	
    protected String formatDocument(final Document document) {
    	final String formatted = this.xmlDocUtils.formatDocument(document);
    	return formatted;
    }

	/**
	 * Logs info about the given {@link HttpResponse} if the status code is not the expected value.
	 * 
	 * Deprecated - use assertErrorCodeAndStatus or similar instead, which call these. The problem is that if you use both together you get a closed stream error, as logResponse closes it.
	 * 
	 * @param response
	 *            the {@link HttpResponse} to log if its status is not the expected value.
	 * @param expectedStatus
	 *            the HTTP Status value to expect.
	 */
    @Deprecated
	protected void logResponseIfNotExpectedStatus(final HttpResponse response, final int expectedStatus) {
		if (response.getStatusLine().getStatusCode() != expectedStatus) {
			LOGGER.log(Level.WARNING, "Response status is NOT " + expectedStatus + " response=" + response);
			logResponse(response, Level.WARNING);
		}
	}

	/**
	 * Logs info about the {@link HttpResponse} to the {@link Logger}, using the Log Level {@link Level#INFO}.
	 * <br><br>
	 * <b>NOTE: This consumes the Response Entity and closes the InputStream - don't call this when you want to get the Response data afterwards.</b>
	 * 
	 * @param response
	 *            the {@link HttpResponse} to log
	 */
	protected void logResponse(final HttpResponse response) {
		logResponse(response, Level.INFO);
	}

	/**
	 * Logs info about the {@link HttpResponse} to the {@link Logger}, using the given Log {@link Level}.
	 * <br><br>
	 * <b>NOTE: This consumes the Response Entity and closes the InputStream - don't call this when you want to get the Response data afterwards.</b>
	 * 
	 * @param response
	 *            the {@link HttpResponse} to log
	 * @param logLevel
	 *            the {@link Level} to log at
	 */
	protected void logResponse(final HttpResponse response, Level logLevel) {
		final Header contentType = response.getLastHeader("content-type");
		LOGGER.log(logLevel, "Response: content-type: " + contentType);
		try {
			final String responseBody = new ResponseContentUnwrapper().unwrapContentAsString(response);
			LOGGER.log(logLevel, "Response: body: " + responseBody);
		} catch (IllegalStateException illegalStateException) {
			LOGGER.log(Level.WARNING, "IllegalStateException when trying to log response body: probably the response was already read. ");
			final String allHeaders = getAllHeadersAsLoggableString(response);
			LOGGER.log(Level.WARNING, "Here are the headers for it Response we couldn't log the body of: " + allHeaders);
			// otherwise, ignore so test continues.
		}
	}

	private String getAllHeadersAsLoggableString(final HttpResponse response) {
		final StringBuilder strBuilder = new StringBuilder(" {");
		boolean writtenOneAlready = false;
		for (final Header header : response.getAllHeaders()) {
			if (writtenOneAlready) {
				strBuilder.append(",");
			}
			strBuilder.append(" [ '");
			strBuilder.append(header.getName());
			strBuilder.append("' : '");
			strBuilder.append(header.getValue());
			strBuilder.append("' ] ");
			writtenOneAlready = true;
		}
		strBuilder.append(" } ");
		final String allHeaders = strBuilder.toString();
		return allHeaders;
	}

    protected void assignDefaultAuthorizationHeaderForGet(HttpUriRequest request) throws ParseException, InvalidKeyException, SignatureException, UnsupportedEncodingException, NoSuchAlgorithmException {
    	requestCreator.assignDefaultAuthorizationHeaderForGet(request);
    }
    
    protected void assignDefaultAuthorizationHeaderForPost(HttpUriRequest request) throws ParseException, InvalidKeyException, SignatureException, UnsupportedEncodingException, NoSuchAlgorithmException {
    	requestCreator.assignDefaultAuthorizationHeaderForPost(request, HeaderHelper.APPLICATION_XML_CONTENT_TYPE);
    }
    
    protected void assignDefaultAuthenticationHeader(HttpUriRequest request, String username, String password) throws InvalidKeyException, SignatureException {
    	requestCreator.assignDefaultAuthenticationHeader(request, username, password);		
    }
    
    protected void assignDefaultAuthenticationHeaderFromHashedPassword(HttpUriRequest request, String username, String hashedPassword) throws InvalidKeyException, SignatureException {
    	requestCreator.assignDefaultAuthenticationHeaderFromHashedPassword(request, username, hashedPassword);		
    }

	protected TestContext getTestContext() {
		return this.testContext;
	}
	
	protected boolean temporarilyDisabled() {
		
		Date now = new Date();

		return now.before(IGNORE_TEST_UNTIL);

	}
    
}
