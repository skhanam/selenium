package uk.co.ratedpeople;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpUriRequest;

import uk.co.ratedpeople.HttpRequestCreator;
import uk.co.ratedpeople.HttpRequestExecutor;


/**
 * Retrieves Ratings
 * 
 * @author colin.bradley
 */
public class RatingRetriever {
	private static class RatingURIs {
		static final String API_VERSION_PREFIX = "/api/v1/";
		static final String HOMEOWNER_RATING_PART = "homeowner/rating/";
		static final String RATING_BASE_URI = API_VERSION_PREFIX + HOMEOWNER_RATING_PART;
		static final String RATING_BY_JOB_BASE_URI = RATING_BASE_URI + "job/";

		RatingURIs() {
		}

		String getUriForRatingWithId(final int ratingId) {
			final String uri = RATING_BASE_URI + ratingId;
			return uri;
		}

		String getUriForRatingsOfJobWithRef(final int jobRef) {
			final String uri = RATING_BY_JOB_BASE_URI + jobRef;
			return uri;
		}

		public String getUriForRatingsOfJobWithRef(final String jobRef) {
			final String uri = RATING_BY_JOB_BASE_URI + jobRef;
			return uri;
		}
	}
	
	private static final Logger LOGGER = Logger.getLogger(RatingRetriever.class.getName());

	private final HttpRequestCreator requestCreator = new HttpRequestCreator();
	private final HttpRequestExecutor requestExectutor = new HttpRequestExecutor();

	private final RatingURIs ratingUris = new RatingURIs();

	public HttpResponse getPublicJobRatingsForJobWithRef(final int jobRef) throws InvalidKeyException, SignatureException, NoSuchAlgorithmException,
			ParseException, ClientProtocolException, IOException {
		final String uri = this.ratingUris.getUriForRatingsOfJobWithRef(jobRef);
		final HttpResponse response = responseForGETtingUri(uri);
		return response;
	}
	
	public HttpResponse getPublicJobRatingsForJobWithRef(final String jobRef) throws InvalidKeyException, MalformedURLException, SignatureException, UnsupportedEncodingException, NoSuchAlgorithmException, ClientProtocolException, ParseException, IOException {
		final String uri = this.ratingUris.getUriForRatingsOfJobWithRef(jobRef);
		final HttpResponse response = responseForGETtingUri(uri);
		return response;
	}

	public HttpResponse getPublicJobRatingWithId(final int ratingId) throws InvalidKeyException, SignatureException, NoSuchAlgorithmException, ParseException,
			ClientProtocolException, IOException {
		final String uri = this.ratingUris.getUriForRatingWithId(ratingId);
		final HttpResponse response = responseForGETtingUri(uri);
		return response;
	}

	HttpResponse responseForGETtingUri(final String uri) throws MalformedURLException, InvalidKeyException, SignatureException, UnsupportedEncodingException,
			NoSuchAlgorithmException, ParseException, ClientProtocolException, IOException {
		LOGGER.log(Level.INFO, "About to GET URI: " + uri);
		final HttpUriRequest request = this.requestCreator.createGetRequestForUri(uri);
		final HttpResponse response = this.requestExectutor.execute(request);
		return response;
	}

}
