package uk.co.ratedpeople;

import java.util.Map;

import org.apache.commons.httpclient.HttpStatus;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.w3c.dom.Document;

/**
 * Class providing functionality to execute a full tradesman sign-up.
 * 
 * @author nigel.rawlins
 */
public class TradesmanSignupExecutor {
	
	private PurchaseOrderXmlCreator purchaseOrderXmlCreator = new PurchaseOrderXmlCreator();
	private ThreeDHelper threeDHelper = new ThreeDHelper();
	private XmlUtils xmlUtils = new XmlUtils();
	private HttpRequestExecutor httpRequestExecutor = new HttpRequestExecutor();
	private HttpRequestCreator httpRequestCreator = new HttpRequestCreator();
	private HttpResponseUtils httpResponseUtils = new HttpResponseUtils();
	
	public void signUpANewTradesman(final TradesmanSignup tradesmanSignup, final String emailAddress, final String postcode) throws Exception {
		
		final HttpResponse businessDetailsResponse = signUpATradesmanFromStartToBusinessDetails(tradesmanSignup, emailAddress, postcode);
		checkResponseAndLogIfIncorrect(HttpStatus.SC_CREATED, businessDetailsResponse);
		
		final HttpResponse screeningResponse = signUpATradesmanFromBusinessDetailsToScreening(tradesmanSignup, emailAddress, postcode);
		checkResponseAndLogIfIncorrect(HttpStatus.SC_OK, screeningResponse);
		
		final HttpResponse postResponse = signUpATradesmanFromScreeningToBilling(tradesmanSignup, emailAddress, postcode);
		checkResponseAndLogIfIncorrect(HttpStatus.SC_CREATED, postResponse);
			
		final Document document = this.httpResponseUtils.documentFromResponseBody(postResponse);
		
		final String purchaseOrderId = xmlUtils.asString(document, "/purchaseorder/purchaseOrderId");
		final String md = xmlUtils.asString(document, "/purchaseorder/threedrequest/md");
		final String acsurl = xmlUtils.asString(document, "/purchaseorder/threedrequest/acsurl");
		final String pareq = xmlUtils.asString(document, "/purchaseorder/threedrequest/pareq");
		
		final Map<String, String> threeDResponseMap = threeDHelper.doSuccessfulThreeDAuthentication(acsurl, md, pareq);
		
		purchaseOrderXmlCreator.makePurchaseOrderXmlWithThreeDResponse(threeDResponseMap);
		
		final ThreeDResponse threeDResponse = TradesmanSignupBuilderHelper.setXMLForThreeDResponse(threeDResponseMap);
		
		signUpATradesmanFromBillingToComplete(tradesmanSignup, emailAddress, postcode, purchaseOrderId, threeDResponse);
	}
	
	private HttpResponse signUpATradesmanFromStartToBusinessDetails(final TradesmanSignup tradesmanSignup, final String emailAddress, final String postcode) throws Exception {
		
		final TradesmanSignup tradesmanSignupAsFarAsBusinessDetails = TradesmanSignupBuilder.build(TradesmanSignupConstants.FORM_TYPE_A, Integer.valueOf(0), TradesmanSignupConstants.TARIFF_REF,
				TradesmanSignupConstants.LANDING_PAGE_URL, TradesmanSignupConstants.LAST_VISITED_URL, TradesmanSignupConstants.STAGE_COMPLETED_1, emailAddress, postcode,
				tradesmanSignup.getPrimaryTradeList(), tradesmanSignup.getTradesmanPersonalDetails(), tradesmanSignup.getTradesmanBusinessDetails(), null, null);
		
		final String xmlForTradesmanSignupAsFarAsBusinessDetails = TradesmanSignupBuilderHelper.getXMLForTradesmanSignup(tradesmanSignupAsFarAsBusinessDetails);
		
		return postRequest(TradesmanSignupConstants.TRADESMAN_SIGNUP_POST_URI, xmlForTradesmanSignupAsFarAsBusinessDetails);
	}
	
	private HttpResponse signUpATradesmanFromBusinessDetailsToScreening(final TradesmanSignup tradesmanSignup, final String emailAddress, final String postcode) throws Exception {
		
		final TradesmanSignup tradesmanSignupAsFarAsScreening = TradesmanSignupBuilder.build(TradesmanSignupConstants.FORM_TYPE_A, Integer.valueOf(0), TradesmanSignupConstants.TARIFF_REF,
				TradesmanSignupConstants.LANDING_PAGE_URL, TradesmanSignupConstants.LAST_VISITED_URL, TradesmanSignupConstants.STAGE_COMPLETED_2, emailAddress, postcode,
				tradesmanSignup.getPrimaryTradeList(), tradesmanSignup.getTradesmanPersonalDetails(), tradesmanSignup.getTradesmanBusinessDetails(),
				tradesmanSignup.getTradesmanScreeningDetails(), null);
		
		final String xmlForTradesmanSignupAsFarAsScreening = TradesmanSignupBuilderHelper.getXMLForTradesmanSignup(tradesmanSignupAsFarAsScreening);
		
		return putRequest(TradesmanSignupConstants.TRADESMAN_SIGNUP_POST_URI, xmlForTradesmanSignupAsFarAsScreening);
	}
	
	private HttpResponse signUpATradesmanFromScreeningToBilling(final TradesmanSignup tradesmanSignup, final String emailAddress, final String postcode) throws Exception {
		
		final TradesmanSignup tradesmanSignupAsFarAsBilling = TradesmanSignupBuilder.build(TradesmanSignupConstants.FORM_TYPE_A, Integer.valueOf(0), TradesmanSignupConstants.TARIFF_REF,
				TradesmanSignupConstants.LANDING_PAGE_URL, TradesmanSignupConstants.LAST_VISITED_URL, TradesmanSignupConstants.STAGE_COMPLETED_3, emailAddress, postcode,
				tradesmanSignup.getPrimaryTradeList(), tradesmanSignup.getTradesmanPersonalDetails(), tradesmanSignup.getTradesmanBusinessDetails(),
				tradesmanSignup.getTradesmanScreeningDetails(), tradesmanSignup.getTradesmanBillingDetails());
		
		final String xmlForTradesmanSignupAsFarAsBilling = TradesmanSignupBuilderHelper.getXMLForTradesmanSignup(tradesmanSignupAsFarAsBilling);
		
		HttpResponse response = putRequest(TradesmanSignupConstants.TRADESMAN_SIGNUP_POST_URI, xmlForTradesmanSignupAsFarAsBilling);
		
		response = postRequest(TradesmanSignupConstants.TRADESMAN_SIGNUP_PLAN_URI, xmlForTradesmanSignupAsFarAsBilling);
		
		return response;
	}
	
	private void checkResponseAndLogIfIncorrect(final int expectedCode, HttpResponse response) {
		if (response.getStatusLine().getStatusCode() != expectedCode) {
			httpResponseUtils.logResponse(response);
			throw new IllegalStateException("Status was " + response.getStatusLine().getStatusCode());
		}
	}
	
	private void signUpATradesmanFromBillingToComplete(final TradesmanSignup tradesmanSignup, final String emailAddress, final String postcode,
			final String purchaseOrderId, final ThreeDResponse threeDResponse) throws Exception {
		
		final TradesmanSignup completedTradesmanSignup = TradesmanSignupBuilder.build(TradesmanSignupConstants.FORM_TYPE_A, Integer.valueOf(0), TradesmanSignupConstants.TARIFF_REF,
				TradesmanSignupConstants.LANDING_PAGE_URL, TradesmanSignupConstants.LAST_VISITED_URL, TradesmanSignupConstants.STAGE_COMPLETED_4, emailAddress, postcode,
				tradesmanSignup.getPrimaryTradeList(), tradesmanSignup.getTradesmanPersonalDetails(), tradesmanSignup.getTradesmanBusinessDetails(),
				tradesmanSignup.getTradesmanScreeningDetails(), tradesmanSignup.getTradesmanBillingDetails());
		
		completedTradesmanSignup.getTradesmanBillingDetails().setPurchaseOrderId(purchaseOrderId);
		completedTradesmanSignup.getTradesmanBillingDetails().setThreeDResponse(threeDResponse);
		
		final String xmlForCompletedTradesmanSignup = TradesmanSignupBuilderHelper.getXMLForTradesmanSignup(completedTradesmanSignup);
		
		HttpResponse putResponse = putRequest(TradesmanSignupConstants.TRADESMAN_SIGNUP_POST_URI, xmlForCompletedTradesmanSignup);
		checkResponseAndLogIfIncorrect(HttpStatus.SC_OK, putResponse);
	}
	
	private HttpResponse postRequest(String uri, String xml) throws Exception {
		
		HttpEntity httpEntity = new StringEntity(xml);
		
		HttpPost httpPost = httpRequestCreator.createPostRequestForUri(uri);
		httpPost.setEntity(httpEntity);
		
		return httpRequestExecutor.execute(httpPost);
	}
	
	private HttpResponse putRequest(String uri, String xml) throws Exception {
		
		HttpEntity httpEntity = new StringEntity(xml);
		
		HttpPut httpPut = httpRequestCreator.createPutRequestForUri(uri);
		httpPut.setEntity(httpEntity);
		
		return httpRequestExecutor.execute(httpPut);
	}
}