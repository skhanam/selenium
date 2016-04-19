package uk.co.ratedpeople;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.w3c.dom.Document;

/**
 * Helper class for submitting and removing bank account details
 * 
 * @author swetha.morthala
 */
public class BankAccountDetailsHelper {

	private HttpRequestCreator requestCreator = new HttpRequestCreator();
	private HttpRequestExecutor requestExecutor = new HttpRequestExecutor();
	private XmlUtils xmlUtils = new XmlUtils();
	HttpResponseUtils httpResponseUtils = new HttpResponseUtils();

	public HttpResponse postBankAccountDetails(Integer tradesmanId, String userName, String password, String xml) throws Exception {
		String uri = "/api/v1/tradesmen/" + tradesmanId + "/bank_account_details";

		HttpPost request = requestCreator.createPostRequestForUri(uri);
		requestCreator.assignDefaultAuthenticationHeader(request, userName, password);
		HttpEntity entity = new StringEntity(xml);
		request.setEntity(entity);

		return requestExecutor.execute(request);

	}

	public HttpResponse deleteBankAccountDetails(Integer tradesmanId, Integer bankAccountDetailsId, String userName, String password) throws Exception {
		String uri = "/api/v1/tradesmen/" + tradesmanId + "/bank_account_details/" + bankAccountDetailsId;

		HttpDelete request = requestCreator.createDeleteRequestForUri(uri);
		requestCreator.assignDefaultAuthenticationHeader(request, userName, password);
		return requestExecutor.execute(request);

	}

	public HttpResponse getBankAccountDetails(Integer tradesmanId, String userName, String password) throws Exception {

		String uri = "/api/v1/tradesmen/" + tradesmanId + "/bank_account_details/";
		HttpGet request = requestCreator.createGetRequestForUri(uri);
		requestCreator.assignDefaultAuthenticationHeader(request, userName, password);

		return requestExecutor.execute(request);
	}

	public String getXmlForPostingBankAccountDetails(String accountName, String accountNumber, String sortCode, String vatNumber, String tradesmanId,
			String termsAndConditions) {

		StringBuilder builder = new StringBuilder();
		builder.append("<bankaccountdetails>");
		builder.append("<accountname>").append(accountName).append("</accountname>");
		builder.append("<accountnumber>").append(accountNumber).append("</accountnumber>");
		builder.append("<sortcode>").append(sortCode).append("</sortcode>");
		if (vatNumber != null) {
			builder.append("<vatnumber>").append(vatNumber).append("</vatnumber>");
		}
		builder.append("<userid>").append(tradesmanId).append("</userid>");
		builder.append("<termsconditions>").append(termsAndConditions).append("</termsconditions>");
		builder.append("</bankaccountdetails>");
		return builder.toString();

	}

	public void createDefaultBankAccountDetailsWithVatNumber(Integer tradesmanId, String userName, String password) throws Exception {
		String xml = getXmlForPostingBankAccountDetails("Test Account", "12345678", "123456", "123456789012", tradesmanId.toString(),
				"Test terms and conditions");
		postBankAccountDetails(tradesmanId, userName, password, xml);
	}

	public void createDefaultBankAccountDetailsWithoutVatNumber(Integer tradesmanId, String userName, String password) throws Exception {
		String xml = getXmlForPostingBankAccountDetails("Test Account", "12345678", "123456", null, tradesmanId.toString(), "Test terms and conditions");
		postBankAccountDetails(tradesmanId, userName, password, xml);
	}

	public boolean doesUserHaveBankAccountDetails(Integer tradesmanId, String userName, String password) throws Exception {
		HttpResponse response = getBankAccountDetails(tradesmanId, userName, password);

		System.out.println("==============" + response.getStatusLine().getStatusCode());

		Document document = httpResponseUtils.documentFromResponseBody(response);

		System.out.println(document.toString());

		if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
			return true;
		} else {
			return false;
		}
	}

	public void deleteFirstAvailableBankAccountDetailsRecord(Integer tradesmanId, String userName, String password) throws Exception {
		HttpResponse response = getBankAccountDetails(tradesmanId, userName, password);

		if (response.getStatusLine().getStatusCode() != HttpStatus.SC_NOT_FOUND) {
			Document document = httpResponseUtils.documentFromResponseBody(response);
			String text = xmlUtils.asString(document, "bankaccountdetailslist/bankaccountdetails[1]/id");
			if (!StringUtils.isEmpty(text)) {
				Integer id = Integer.parseInt(text);
				deleteBankAccountDetails(tradesmanId, id, userName, password);
			}
		}

	}

}
