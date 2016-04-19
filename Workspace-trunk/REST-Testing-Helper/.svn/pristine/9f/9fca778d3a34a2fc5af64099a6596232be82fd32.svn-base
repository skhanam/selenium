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

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;

public class JobPurchaseOrderSubmitter {

	private static final Logger LOGGER = Logger.getLogger(JobPurchaseOrderSubmitter.class.getName());

	private static final String PURCHASE_ORDER_WITH_NO_CREDIT_CARD_DETAILS = "<purchaseorder></purchaseorder>";

	private HeaderHelper headerHelper = new HeaderHelper();
	private final HttpRequestCreator requestCreator;
	private final HttpRequestExecutor requestExecutor;

	public JobPurchaseOrderSubmitter() {
		requestCreator = new HttpRequestCreator();
		requestExecutor = new HttpRequestExecutor();
	}

	public HttpResponse postPurchaseOrderWithoutCard(String username, String password, int userid, String jobReference) throws Exception {
		System.out.println("About to PostPurchaseOrder");
	    HttpPost request = createPurchaseOrderPostRequest(username, password, userid, jobReference);
	    HttpEntity entity = new StringEntity(PURCHASE_ORDER_WITH_NO_CREDIT_CARD_DETAILS);
	    request.setEntity(entity);
		HttpResponse response = requestExecutor.execute(request);
		
		int statusCode = response.getStatusLine().getStatusCode();
		LOGGER.log(Level.INFO, "Post purchase order without card. Response Status Code = {0}", statusCode);

		return response;
	}

	public HttpResponse postPurchaseOrderV1WithoutCard(String username, String password, int userid, String jobReference)
			throws Exception {
		final String me = "JobPurchaseOrderSubmitter.postPurchaseOrderWithOutCard";
		System.out.println(me + " doing with user=" + userid + " and jobref=" + jobReference);
		HttpPost request = createPurchaseOrderV1PostRequest(username, password, userid, jobReference);
		HttpEntity entity = new StringEntity(PURCHASE_ORDER_WITH_NO_CREDIT_CARD_DETAILS);
		request.setEntity(entity);
		HttpResponse response = requestExecutor.execute(request);

		int statusCode = response.getStatusLine().getStatusCode();
		LOGGER.log(Level.INFO, "Post purchase order without card. Response Status Code = {0}", statusCode);
		System.out.println(me + "result is " + statusCode);
		return response;
	}

	private HttpPost createPurchaseOrderV1PostRequest(String username, String password, int userid, String jobReference)
			throws InvalidKeyException, MalformedURLException,
			SignatureException, UnsupportedEncodingException,
			NoSuchAlgorithmException, ParseException {
		final String postCertificateUri = "/api/v1/tradesmen/" + userid + "/jobs/" + jobReference + "/purchase_orders";
		LOGGER.log(Level.INFO, "postPurchaseOrder URI={0}", postCertificateUri);
		HttpPost request = requestCreator.createPostRequestForUri(postCertificateUri);

		String authnHeader = headerHelper.createAuthnHeader(username, password);
		request.setHeader(APIAccessConstants.AUTHENTICATION_HEADER_NAME, authnHeader);
		return request;
	}

	public HttpResponse postPurchaseOrderV1WithCard(String username, String password, int userid, String jobReference, String cardDetailsXml)
			throws InvalidKeyException, SignatureException, NoSuchAlgorithmException, ParseException, ClientProtocolException, IOException {
		HttpPost request = createPurchaseOrderV1PostRequest(username, password, userid, jobReference);
		HttpEntity entity = new StringEntity(cardDetailsXml);
		request.setEntity(entity);
		HttpResponse response = requestExecutor.execute(request);
		return response;
	}

	public HttpResponse postPurchaseOrderV2WithoutCard(String username, String password, int userid, String jobReference)
			throws Exception {
		final String me = "JobPurchaseOrderSubmitter.postPurchaseOrderWithOutCard";
		System.out.println(me + " doing with user=" + userid + " and jobref=" + jobReference);
		HttpPost request = createPurchaseOrderV2PostRequest(username, password, userid, jobReference);
		HttpEntity entity = new StringEntity(PURCHASE_ORDER_WITH_NO_CREDIT_CARD_DETAILS);
		request.setEntity(entity);
		HttpResponse response = requestExecutor.execute(request);

		int statusCode = response.getStatusLine().getStatusCode();
		LOGGER.log(Level.INFO, "Post purchase order without card. Response Status Code = {0}", statusCode);
		System.out.println(me + "result is " + statusCode);
		return response;
	}

	private HttpPost createPurchaseOrderV2PostRequest(String username, String password, int userid, String jobReference)
			throws InvalidKeyException, MalformedURLException,
			SignatureException, UnsupportedEncodingException,
			NoSuchAlgorithmException, ParseException {
		final String postCertificateUri = "/api/v2/tradesmen/" + userid + "/jobs/" + jobReference + "/purchase_orders";
		LOGGER.log(Level.INFO, "postPurchaseOrder URI={0}", postCertificateUri);
		HttpPost request = requestCreator.createPostRequestForUri(postCertificateUri);

		String authnHeader = headerHelper.createAuthnHeader(username, password);
		request.setHeader(APIAccessConstants.AUTHENTICATION_HEADER_NAME, authnHeader);
		return request;
	}

	public HttpResponse postPurchaseOrderWithCard(String username, String password, int userid, String jobReference, String cardDetailsXml)
			throws InvalidKeyException, SignatureException, NoSuchAlgorithmException, ParseException, ClientProtocolException, IOException {
		HttpPost request = createPurchaseOrderPostRequest(username, password, userid, jobReference);
		HttpEntity entity = new StringEntity(cardDetailsXml);
		request.setEntity(entity);
		HttpResponse response = requestExecutor.execute(request);
		return response;
	}

	private HttpPost createPurchaseOrderPostRequest(String username, String password, int userid, String jobReference) throws InvalidKeyException,
			MalformedURLException, SignatureException, UnsupportedEncodingException, NoSuchAlgorithmException, ParseException {
		final String postCertificateUri = "/api/v1/tradesmen/" + userid + "/jobs/" + jobReference + "/purchase_orders";
		LOGGER.log(Level.INFO, "postPurchaseOrder URI={0}", postCertificateUri);
		HttpPost request = requestCreator.createPostRequestForUri(postCertificateUri);

		String authnHeader = headerHelper.createAuthnHeader(username, password);
		request.setHeader(APIAccessConstants.AUTHENTICATION_HEADER_NAME, authnHeader);
		return request;
	}

	public HttpResponse putPurchaseOrderWithThreeDResponse(String username, String password, String uri, String purchaseOrderXml) throws InvalidKeyException,
			SignatureException, NoSuchAlgorithmException, ClientProtocolException, IOException, ParseException {
		LOGGER.log(Level.INFO, "putPurchaseOrder URI={0}", uri);
		HttpPut request = new HttpPut(uri);
		HttpEntity entity = new StringEntity(purchaseOrderXml);
		request.setEntity(entity);
		HttpRequestCreator creator = new HttpRequestCreator();
		creator.assignDefaultAuthorizationHeaderForPut(request);

		String authnHeader = headerHelper.createAuthnHeader(username, password);
		request.setHeader(APIAccessConstants.AUTHENTICATION_HEADER_NAME, authnHeader);
		HttpResponse response = requestExecutor.execute(request);
		return response;
	}

}
