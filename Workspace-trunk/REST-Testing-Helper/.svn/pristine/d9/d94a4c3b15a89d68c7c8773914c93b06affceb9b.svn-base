package uk.co.ratedpeople;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import uk.co.ratedpeople.HttpRequestCreator;
import uk.co.ratedpeople.HttpRequestExecutor;
import uk.co.ratedpeople.HttpResponseUtils;
import uk.co.ratedpeople.JobListRetriever;
import uk.co.ratedpeople.UserRetriever;
import uk.co.ratedpeople.XmlDocumentUtils;
import uk.co.ratedpeople.XmlUtils;

/**
 * Helper class for submitting Payment Requests in functional tests.
 */
public class PaymentRequestSubmitter {

	private HttpRequestCreator requestCreator;
	private HttpRequestExecutor executor;
	private UserRetriever userRetriever;
	private XmlUtils xmlUtils;
	private HttpResponseUtils httpResponseUtils;
	private XmlDocumentUtils xmlDocUtils;

	public PaymentRequestSubmitter() {
		requestCreator = new HttpRequestCreator();
		executor = new HttpRequestExecutor();
		userRetriever = new UserRetriever();
		xmlUtils = new XmlUtils();
		httpResponseUtils = new HttpResponseUtils();
		xmlDocUtils = new XmlDocumentUtils();
	}

	/**
	 * @deprecated Instead of this method use postPaymentRequest method that accepts a jobRef also. Otherwise, the test may create payment request for either an
	 *             RP / NRP job at random. Behaviour of tests should be reproducible.
	 */
	@Deprecated
	public HttpResponse postPaymentRequest(String userName, String password, Double netAmount, Double vatAmount, String description,
			String paymentRequestStatus, String... paymentMethods) throws Exception {

		Integer userId = userRetriever.getUserId(userName, password);

		String jobRef = getJobRef(userId, userName, password);

		return postPaymentRequest(userName, password, userId, jobRef, netAmount, vatAmount, description, paymentRequestStatus, paymentMethods);
	}

	public HttpResponse postPaymentRequest(String userName, String password, String jobRef, Double netAmount, Double vatAmount, String description,
			String paymentRequestStatus, String... paymentMethods) throws Exception {

		Integer userId = userRetriever.getUserId(userName, password);

		return postPaymentRequest(userName, password, userId, jobRef, netAmount, vatAmount, description, paymentRequestStatus, paymentMethods);
	}

	public HttpResponse postPaymentRequest(String userName, String password, int userId, String jobRef, Double netAmount, Double vatAmount, String description,
			String paymentRequestStatus, String... paymentMethods) throws Exception {
		String PAYMENT_REQUEST_XML = buildPaymentRequestXML(userId, jobRef, netAmount, vatAmount, description, paymentRequestStatus, paymentMethods);

		HttpResponse postResponse = postToPaymentRequest(userId, jobRef, userName, password, PAYMENT_REQUEST_XML);

		return postResponse;
	}

	public HttpResponse postToPaymentRequest(Integer userId, String jobReference, String username, String password, String paymentRequestXml) throws Exception {

		final String postPaymentRequestUri = "/api/v1/tradesmen/" + userId + "/jobs/" + jobReference + "/payment_requests";
		HttpPost request = requestCreator.createPostRequestForUri(postPaymentRequestUri);
		requestCreator.assignDefaultAuthenticationHeader(request, username, password);
		HttpEntity entity = new StringEntity(paymentRequestXml);
		request.setEntity(entity);
		return executor.execute(request);
	}

	public String buildPaymentRequestXML(Integer userId, String jobRef, Double netAmount, Double vatAmount, String description, String paymentRequestStatus,
			String... paymentMethods) {

		String paymentMethodList = "";
		for (String paymentMethod : paymentMethods) {
			paymentMethodList += "<paymentmethodoption><code>" + paymentMethod + "</code></paymentmethodoption>";
		}
		// @formatter:off
		String PAYMENT_REQUEST_XML = "<paymentrequest>" + "<netamount>" + netAmount + "</netamount>" + "<vatamount>" + vatAmount + "</vatamount>"
				+ "<description>" + description + "</description>" + "<paymentrequeststatus>" + "<code>" + paymentRequestStatus + "</code>"
				+ "</paymentrequeststatus>" + "<paymentmethods>" + paymentMethodList + "</paymentmethods>" + "<userid>" + userId + "</userid>"
				+ "<jobreference>" + jobRef + "</jobreference>" + "</paymentrequest>";
		// @formatter:on
		System.out.println(PAYMENT_REQUEST_XML);
		return PAYMENT_REQUEST_XML;
	}

	public String getJobRef(int userId, String userName, String password) throws Exception {
		String JOB_DETAILS_JOBREF_XPATH = null;

		JOB_DETAILS_JOBREF_XPATH = "/jobdetailswrapper/jobdetails/jobref";

		JobListRetriever jobListRetriever = new JobListRetriever();

		HttpResponse response = jobListRetriever.getPurchasedJobList(userId, userName, password, 1, null, null);
		Document doc = this.httpResponseUtils.documentFromResponseBody(response);
		System.out.println(xmlDocUtils.formatDocument(doc));

		String jobRef = xmlUtils.asString(doc, JOB_DETAILS_JOBREF_XPATH);

		return jobRef;
	}

	public HttpResponse deleteResponse(String username, String password, Integer userId, String jobRef, String paymentRequestCreated) throws Exception {
		final String deletePaymentRequestUri = "/api/v1/tradesmen/" + userId + "/jobs/" + jobRef + "/payment_requests/" + paymentRequestCreated;
		HttpDelete request = requestCreator.createDeleteRequestForUri(deletePaymentRequestUri);
		requestCreator.assignDefaultAuthenticationHeader(request, username, password);
		return executor.execute(request);
	}

	public HttpResponse getPaymentRequestsForJob(final String username, final String password, final Integer userId, final String jobRef) throws Exception {
		final String getPaymentRequestsForJobUri = "/api/v1/tradesmen/" + userId + "/jobs/" + jobRef + "/payment_requests";
		HttpGet request = requestCreator.createGetRequestForUri(getPaymentRequestsForJobUri);
		requestCreator.assignDefaultAuthenticationHeader(request, username, password);
		return executor.execute(request);
	}

	public List<String> getPaymentRequestRefsListForJob(final String username, final String password, final Integer userId, final String jobRef) throws Exception {
		final String getPaymentRequestsForJobUri = "/api/v1/tradesmen/" + userId + "/jobs/" + jobRef + "/payment_requests";
		HttpGet request = requestCreator.createGetRequestForUri(getPaymentRequestsForJobUri);
		requestCreator.assignDefaultAuthenticationHeader(request, username, password);
		HttpResponse getResponse = executor.execute(request);

		final Document getResponseDocument = this.httpResponseUtils.documentFromResponseBody(getResponse);
		System.out.println(formatDocument(getResponseDocument));
		List<String> paymentRequestRefs = new ArrayList<String>();
		paymentRequestRefs = this.getListOfPaymentRequests(getResponseDocument);
		return paymentRequestRefs;
	}

	private String formatDocument(final Document document) {
		final String formatted = this.xmlDocUtils.formatDocument(document);
		return formatted;
	}

	private List<String> getListOfPaymentRequests(final Document document) throws Exception {

		List<String> paymentRequestRefs = new ArrayList<String>();
		System.out.println(xmlUtils.getXml(document));
		NodeList nodeList = document.getElementsByTagName("paymentrequest");
		int numberNodes = nodeList.getLength();
		for (int i = 0; i < numberNodes; i++) {
			Node currentNode = nodeList.item(i);
			NodeList children = currentNode.getChildNodes();
			int numberChildren = children.getLength();
			for (int j = 0; j < numberChildren; j++) {
				Node currentChild = children.item(j);
				if ("id".equals(currentChild.getNodeName())) {
					String paymentRequestRef = currentChild.getTextContent();
					paymentRequestRefs.add(paymentRequestRef);
					break;
				}
			}
			System.out.println(currentNode.getTextContent());
		}
		return paymentRequestRefs;
	}
}