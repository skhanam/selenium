package uk.co.ratedpeople;

//import static org.testng.Assert.assertEquals;
//import static org.testng.Assert.assertFalse;
//import static org.testng.Assert.assertNull;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.cache.HeaderConstants;

public class HttpHeaderUtils {

	public String getPragmaHeaderValue(HttpResponse response) {
		return getHeaderValue(response, HeaderConstants.PRAGMA);
	}

	public String getCacheControlHeaderValue(HttpResponse response) {
		return getHeaderValue(response, HeaderConstants.CACHE_CONTROL);
	}

	public String getExpiresHeaderValue(HttpResponse response) {
		return getHeaderValue(response, HeaderConstants.EXPIRES);
	}

	private String getHeaderValue(HttpResponse response, String headerName) {
		final Header header = response.getFirstHeader(headerName);
		String value = null;
		if (header != null) {
			value = header.getValue();
		}
		return value;
	}

	public String getLocationHeader(HttpResponse response) {
		return getHeaderValue(response, "Location");
	}

	public String getLocationHeaderExcludingHostname(HttpResponse response) {
		String uriIncludingHostname = getLocationHeader(response);
		Integer index = uriIncludingHostname.indexOf("/api");
		return uriIncludingHostname.substring(index);
	}

	/**
	 * A generic method to extract resource refs or ids from URIs ending in
	 * them, e.g. extract 123 from a URI like /api/v1/tradesmen/555/jobs/123
	 * 
	 * @param locationValue
	 * @return ref value, i.e. substring after last / in given location value
	 */
	public String extractRefFromLocationUriEndingInRef(String locationValue) {
//		assertFalse(StringUtils.isEmpty(locationValue));
		int startIndex = locationValue.lastIndexOf('/') + 1;
		int endIndex = locationValue.length();
		String ref = locationValue.substring(startIndex, endIndex);
		return ref;
	}

	public String extractRefFromLocationUriEndingInRef(HttpResponse response) {
		final String locationValue = getLocationHeader(response);
		return extractRefFromLocationUriEndingInRef(locationValue);
	}

//	public void assertNoStoreHeaderOnly(HttpResponse response) {
//		assertEquals(getCacheControlHeaderValue(response), "no-store");
//		assertNull(getPragmaHeaderValue(response));
//		assertNull(getExpiresHeaderValue(response));
//	}

//	public void assertCachingIsDisabledByAllCachingHeaders(HttpResponse response) {
//		assertEquals(getCacheControlHeaderValue(response), "no-store");
//		assertEquals(getPragmaHeaderValue(response), "No-cache");
//		assertEquals(getExpiresHeaderValue(response), "Thu, 01 Jan 1970 01:00:00 GMT");
//	}

//	public void assertCachingAllowedForOneDay(HttpResponse response) {
//		assertEquals(getCacheControlHeaderValue(response), "max-age=86400");
//		assertNull(getPragmaHeaderValue(response));
//		assertNull(getExpiresHeaderValue(response));
//	}
//
//	public void assertCachingAllowedForGevenTime(HttpResponse response, int timeInSeconds) {
//		assertEquals(getCacheControlHeaderValue(response), "max-age=" + timeInSeconds);
//		assertNull(getPragmaHeaderValue(response));
//		assertNull(getExpiresHeaderValue(response));
//	}

	public void printAllHeaders(HttpResponse response) {
		Header[] headers = response.getAllHeaders();
		for (Header header : headers) {
			System.out.println(header.getName() + ":" + header.getValue());
		}
	}
}
