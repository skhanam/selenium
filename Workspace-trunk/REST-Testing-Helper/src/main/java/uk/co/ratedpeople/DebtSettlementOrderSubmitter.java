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

/**
 * Helper class to submit a debt settlement order.
 * 
 * @author zsolt
 */
public class DebtSettlementOrderSubmitter {

	private static final Logger LOGGER = Logger.getLogger(DebtSettlementOrderSubmitter.class.getName());

	private static final String API_URI_PREFIX = "/api/";

	private HeaderHelper headerHelper = new HeaderHelper();
	private final HttpRequestCreator requestCreator;
	private final HttpRequestExecutor requestExecutor;

	public DebtSettlementOrderSubmitter() {
		requestCreator = new HttpRequestCreator();
		requestExecutor = new HttpRequestExecutor();
	}

	public HttpResponse postDebtSettlementOrderWithCard(String username, String password, Integer tradesmanUserId, String cardDetailsXml)
					throws InvalidKeyException, SignatureException, NoSuchAlgorithmException, ParseException, ClientProtocolException, IOException {
		HttpPost request = createDebtSettlementOrderPostRequest(username, password, tradesmanUserId);
		HttpEntity entity = new StringEntity(cardDetailsXml);
		request.setEntity(entity);

		HttpResponse response = requestExecutor.execute(request);
		return response;
	}

	public HttpResponse putDebtSettlementOrderWithThreeDResponse(String username, String password, String uri, String debtSettlementOrderXml)
					throws InvalidKeyException, SignatureException, NoSuchAlgorithmException, ClientProtocolException, IOException, ParseException {

		LOGGER.log(Level.INFO, "putDebtSettlementOrder URI={0}", uri);
		HttpPut request = new HttpPut(uri);
		HttpEntity entity = new StringEntity(debtSettlementOrderXml);
		request.setEntity(entity);

		HttpRequestCreator creator = new HttpRequestCreator();
		creator.assignDefaultAuthorizationHeaderForPut(request);

		String authnHeader = headerHelper.createAuthnHeader(username, password);
		request.setHeader(APIAccessConstants.AUTHENTICATION_HEADER_NAME, authnHeader);

		HttpResponse response = requestExecutor.execute(request);
		return response;
	}

	private HttpPost createDebtSettlementOrderPostRequest(String username, String password, Integer tradesmanUserId) throws InvalidKeyException,
					MalformedURLException, SignatureException, UnsupportedEncodingException, NoSuchAlgorithmException, ParseException {

		String debtSettlementPostUri = getDebtSettlementPostUri(tradesmanUserId);

		HttpPost request = requestCreator.createPostRequestForUri(debtSettlementPostUri);

		String authnHeader = headerHelper.createAuthnHeader(username, password);
		request.setHeader(APIAccessConstants.AUTHENTICATION_HEADER_NAME, authnHeader);

		return request;
	}

	private String getDebtSettlementPostUri(Integer tradesmanUserId) {
		String debtSettlementUriPart = String.format(Resources.TRADESMAN_ACCOUNT_DEBT_SETTLEMENT_ORDER.getUri(), tradesmanUserId);
		String debtSettlementPostUri = API_URI_PREFIX + debtSettlementUriPart;
		LOGGER.log(Level.INFO, "postDebtSettlement URI={0}", debtSettlementPostUri);
		return debtSettlementPostUri;
	}
}
