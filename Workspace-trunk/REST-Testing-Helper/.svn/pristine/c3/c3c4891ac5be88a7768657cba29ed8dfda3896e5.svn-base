package uk.co.ratedpeople;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.w3c.dom.Document;

/**
 * Utilities for {@link HttpResponse} Objects
 * 
 * @author colin.bradley
 */
public class HttpResponseUtils {
	private static final Logger LOGGER = Logger.getLogger(HttpResponseUtils.class.getName());
	private XmlUtils xmlUtils;

	public HttpResponseUtils() {
		this.xmlUtils = new XmlUtils();
	}

	public Document documentFromResponseBody(HttpResponse response) {
		try {
			final String responseBody = new ResponseContentUnwrapper().unwrapContentAsString(response);
			return this.xmlUtils.getDocument(responseBody);
		} catch (Exception exception) {
			throw new RuntimeException("Exception occurred", exception);
		}
	}
	
	public String getBodyContentasString(HttpResponse response) {
		try {
			final String responseBody = new ResponseContentUnwrapper().unwrapContentAsString(response);
			return responseBody;
		} catch (Exception exception) {
			throw new RuntimeException("Exception occurred", exception);
		}
	}

	public Document documentFromEncryptedResponseBody(final HttpResponse response, final String encryptionKey) throws Exception {
		final String responseBody = new ResponseContentUnwrapper().unwrapContentAsString(response);
		final String decryptedData = decryptUsing(responseBody, encryptionKey);
		return this.xmlUtils.getDocument(decryptedData);
	}

	private String decryptUsing(final String responseBody, final String encryptionKey) throws Exception {
		final String decryptedData = AESEncryption.decrypt(responseBody, encryptionKey);
		return decryptedData;
	}

	/**
	 * Logs info about the given {@link HttpResponse} if the status code is not the expected value.
	 * 
	 * @param response
	 *            the {@link HttpResponse} to log if its status is not the expected value.
	 * @param expectedStatus
	 *            the HTTP Status value to expect.
	 */
	public void logResponseIfNotExpectedStatus(final HttpResponse response, final int expectedStatus) {
		if (response.getStatusLine().getStatusCode() != expectedStatus) {
			LOGGER.log(Level.WARNING, "Response status is NOT " + expectedStatus + " response=" + response);
			logResponse(response, Level.WARNING);
		}
	}

	/**
	 * Logs info about the {@link HttpResponse} to the {@link Logger}, using the Log Level {@link Level#INFO}. <br>
	 * <br>
	 * <b>NOTE: This consumes the Response Entity and closes the InputStream - don't call this when you want to get the Response data afterwards.</b>
	 * 
	 * @param response
	 *            the {@link HttpResponse} to log
	 */
	public void logResponse(final HttpResponse response) {
		logResponse(response, Level.INFO);
	}

	/**
	 * Logs info about the {@link HttpResponse} to the {@link Logger}, using the given Log {@link Level}. <br>
	 * <br>
	 * <b>NOTE: This consumes the Response Entity and closes the InputStream - don't call this when you want to get the Response data afterwards.</b>
	 * 
	 * @param response
	 *            the {@link HttpResponse} to log
	 * @param logLevel
	 *            the {@link Level} to log at
	 */
	public void logResponse(final HttpResponse response, Level logLevel) {
		final Header contentType = response.getLastHeader("content-type");
		LOGGER.log(logLevel, "Response: content-type: " + contentType);
		final String responseBody = new ResponseContentUnwrapper().unwrapContentAsString(response);
		LOGGER.log(logLevel, "Response: body: " + responseBody);
	}

}
