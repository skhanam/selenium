package uk.co.ratedpeople;

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
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;

import uk.co.ratedpeople.APIAccessConstants;
import uk.co.ratedpeople.HeaderHelper;
import uk.co.ratedpeople.HttpRequestCreator;
import uk.co.ratedpeople.HttpRequestExecutor;



public class SmsAlertPackPurchaseOrderSubmitter {

	private static final Logger LOGGER = Logger.getLogger(SmsAlertPackPurchaseOrderSubmitter.class.getName());
	
	private static final String PURCHASE_ORDER_WITH_NO_CREDIT_CARD_DETAILS = "<purchaseorder></purchaseorder>";
	
	private HeaderHelper headerHelper = new HeaderHelper();
	private HttpRequestCreator requestCreator = new HttpRequestCreator();
	private HttpRequestExecutor requestExecutor = new HttpRequestExecutor();
	
	public HttpResponse postPurchaseOrderWithoutCard(String username, String password, int userid) throws Exception {
		System.out.println("About to PostPurchaseOrder");
	    HttpPost request = createPurchaseOrderPostRequest(username, password, userid);
	    HttpEntity entity = new StringEntity(PURCHASE_ORDER_WITH_NO_CREDIT_CARD_DETAILS);
	    request.setEntity(entity);
		HttpResponse response = requestExecutor.execute(request);
		return response;
	}
	
	private HttpPost createPurchaseOrderPostRequest(String username,
			String password, int userid)
			throws InvalidKeyException, MalformedURLException,
			SignatureException, UnsupportedEncodingException,
			NoSuchAlgorithmException, ParseException {
		final String postCertificateUri = "/api/v1/tradesmen/" + userid
				+ "/sms_alerts/purchase_orders";
		LOGGER.log(Level.INFO, "postPurchaseOrder URI={0}", postCertificateUri);
		HttpPost request = requestCreator
				.createPostRequestForUri(postCertificateUri);

		String authnHeader = headerHelper.createAuthnHeader(username, password);
		request.setHeader(APIAccessConstants.AUTHENTICATION_HEADER_NAME,
				authnHeader);
		return request;
	}
}
