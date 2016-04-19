package uk.co.ratedpeople.test.functional.httpclient.support;

import static org.testng.Assert.assertEquals;

import java.util.Date;

import org.apache.http.HttpResponse;
import org.testng.Assert;

import uk.co.ratedpeople.HttpClientTest;

/**
 * Toolkit for HTTP Interactions
 * 
 * @author colin.bradley
 */
public class HttpResponseAssertions extends HttpClientTest{
	public void assertResponseAndStatusNotNull(final HttpResponse response) {
		Assert.assertNotNull(response, "Response is null!");
		Assert.assertNotNull(response.getStatusLine(), "Response.statusLine is null!");
		Assert.assertNotNull(response.getStatusLine().getStatusCode(), "Response had no statusCode in it's Status Line!");
	}

	public void assertStatusEquals(final HttpResponse response, final int expectedCode) {
		final String customMsgSuffix = "";
		assertStatusEquals(response, expectedCode, customMsgSuffix);
	}

	/**
	 * Allows you to specify a custom message suffix for the Assertion failure message, after what will be displayed anyway by this Class.
	 * 
	 * @param response
	 * @param expectedCode
	 * @param customMsgSuffix
	 */
	public void assertStatusEquals(final HttpResponse response, final int expectedCode, final String customMsgSuffix) {
		this.assertResponseAndStatusNotNull(response);
		logResponseIfNotExpectedStatus(response, expectedCode);
		final String timestamp = getTimestampForLog();
		assertEquals(response.getStatusLine().getStatusCode(), expectedCode, "[@ " + timestamp + " ] Status didn't match [Thread: "
				+ Thread.currentThread().getId() + "] : " + customMsgSuffix);
	}

	private String getTimestampForLog() {
		final Date now = new Date();
		final String timestamp = now.toString();
		return timestamp;
	}

}
