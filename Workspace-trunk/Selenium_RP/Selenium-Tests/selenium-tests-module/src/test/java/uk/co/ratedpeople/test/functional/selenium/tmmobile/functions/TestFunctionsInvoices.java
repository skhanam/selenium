package uk.co.ratedpeople.test.functional.selenium.tmmobile.functions;

import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;

import uk.co.ratedpeople.PaymentRequestSubmitter;
import uk.co.ratedpeople.UserRetriever;

/**
 * 
 * @author olivier.renard
 * 
 */
public class TestFunctionsInvoices {

	private PaymentRequestSubmitter paymentRequestSubmitter;
	private UserRetriever userRetriever;

	public TestFunctionsInvoices() {
		paymentRequestSubmitter = new PaymentRequestSubmitter();
		userRetriever = new UserRetriever();
	}

	/**
	 * Creates an invoice/payment request for the given job and returns the HTTP response.
	 * 
	 * @param jobRef
	 * @param tradesmanUsername
	 * @param tradesmanPassword
	 * @param netAmount
	 * @param vatAmount
	 * @param description
	 * @param paymentRequestStatus
	 * @param paymentMethods
	 * @return
	 * @throws Exception
	 */
	public HttpResponse createInvoiceForJob(final String jobRef, final String tradesmanUsername, final String tradesmanPassword, final Double netAmount,
			final Double vatAmount, final String description, final String paymentRequestStatus, final String... paymentMethods) throws Exception {
		Integer userId = userRetriever.getUserId(tradesmanUsername, tradesmanPassword);
		return this.createInvoiceForJob(jobRef, tradesmanUsername, tradesmanPassword, userId, netAmount, vatAmount, description, paymentRequestStatus,
				paymentMethods);
	}

	/**
	 * Creates an invoice/payment request for the given job and returns the HTTP response.
	 * 
	 * @param jobRef
	 * @param tradesmanUsername
	 * @param tradesmanPassword
	 * @param tradesmanUserId
	 * @param netAmount
	 * @param vatAmount
	 * @param description
	 * @param paymentRequestStatus
	 * @param paymentMethods
	 * @return
	 * @throws Exception
	 */
	public HttpResponse createInvoiceForJob(final String jobRef, final String tradesmanUsername, final String tradesmanPassword, final Integer tradesmanUserId,
			final Double netAmount, final Double vatAmount, final String description, final String paymentRequestStatus, final String... paymentMethods)
			throws Exception {
		Integer userId = userRetriever.getUserId(tradesmanUsername, tradesmanPassword);
		String paymentRequestXML = paymentRequestSubmitter.buildPaymentRequestXML(userId, jobRef, netAmount, vatAmount, description, paymentRequestStatus,
				paymentMethods);
		HttpResponse postResponse = paymentRequestSubmitter.postToPaymentRequest(userId, jobRef, tradesmanUsername, tradesmanPassword, paymentRequestXML);
		return postResponse;
	}

	/**
	 * Creates an invoice/payment request for the given job and returns the invoice ref.
	 * 
	 * @param jobRef
	 * @param tradesmanUsername
	 * @param tradesmanPassword
	 * @param netAmount
	 * @param vatAmount
	 * @param description
	 * @param paymentRequestStatus
	 * @param paymentMethods
	 * @return
	 * @throws Exception
	 */
	public String createInvoiceForJobAndReturnInvoiceRef(final String jobRef, final String tradesmanUsername, final String tradesmanPassword,
			final Double netAmount, final Double vatAmount, final String description, final String paymentRequestStatus, final String... paymentMethods)
			throws Exception {
		Integer userId = userRetriever.getUserId(tradesmanUsername, tradesmanPassword);
		return this.createInvoiceForJobAndReturnInvoiceRef(jobRef, tradesmanUsername, tradesmanPassword, userId, netAmount, vatAmount, description,
				paymentRequestStatus, paymentMethods);
	}

	/**
	 * Creates an invoice/payment request for the given job and returns the invoice ref.
	 * 
	 * @param jobRef
	 * @param tradesmanUsername
	 * @param tradesmanPassword
	 * @param tradesmanUserId
	 * @param netAmount
	 * @param vatAmount
	 * @param description
	 * @param paymentRequestStatus
	 * @param paymentMethods
	 * @return
	 * @throws Exception
	 */
	public String createInvoiceForJobAndReturnInvoiceRef(final String jobRef, final String tradesmanUsername, final String tradesmanPassword,
			final Integer tradesmanUserId, final Double netAmount, final Double vatAmount, final String description, final String paymentRequestStatus,
			final String... paymentMethods) throws Exception {
		HttpResponse postResponse = createInvoiceForJob(jobRef, tradesmanUsername, tradesmanPassword, tradesmanUserId, netAmount, vatAmount, description,
				paymentRequestStatus, paymentMethods);
		String invoiceRef = null;
		if (postResponse.getStatusLine().getStatusCode() == HttpStatus.SC_CREATED) {
			invoiceRef = getInvoiceRef(postResponse);
		}
		return invoiceRef;
	}

	/**
	 * Deletes an invoice for a given job reference. The invoice must belong the tradesman with the given tradesman user id and must be related to the job with
	 * jobRef.
	 * 
	 * @param jobRef
	 * @param invoiceRef
	 * @param tradesmanUsername
	 * @param tradesmanPassword
	 * @return
	 * @throws Exception
	 */
	public HttpResponse deleteInvoiceForJob(final String jobRef, final String invoiceRef, final String tradesmanUsername, final String tradesmanPassword)
			throws Exception {
		Integer userId = userRetriever.getUserId(tradesmanUsername, tradesmanPassword);
		return this.deleteInvoiceForJob(jobRef, invoiceRef, tradesmanUsername, tradesmanPassword, userId);
	}

	/**
	 * Deletes an invoice for a given job reference. The invoice must belong the tradesman with the given tradesman user id and must be related to the job with
	 * jobRef.
	 * 
	 * @param jobRef
	 * @param invoiceRef
	 * @param tradesmanUsername
	 * @param tradesmanPassword
	 * @param tradesmanUserId
	 * @return
	 * @throws Exception
	 */
	public HttpResponse deleteInvoiceForJob(final String jobRef, final String invoiceRef, final String tradesmanUsername, final String tradesmanPassword,
			final Integer tradesmanUserId) throws Exception {
		HttpResponse deleteResponse = paymentRequestSubmitter.deleteResponse(tradesmanUsername, tradesmanPassword, tradesmanUserId, jobRef, invoiceRef);
		return deleteResponse;
	}

	/**
	 * Deletes all invoices for a given job reference.
	 * 
	 * @param jobRef
	 * @param tradesmanUsername
	 * @param tradesmanPassword
	 * @return true if successful, false otherwise
	 * @throws Exception
	 */
	public boolean deleteAllInvoicesForJob(final String jobRef, final String tradesmanUsername, final String tradesmanPassword) throws Exception {
		Integer userId = userRetriever.getUserId(tradesmanUsername, tradesmanPassword);
		return this.deleteAllInvoicesForJob(jobRef, tradesmanUsername, tradesmanPassword, userId);
	}

	/**
	 * Deletes all invoices for a given job reference.
	 * 
	 * @param jobRef
	 * @param tradesmanUsername
	 * @param tradesmanPassword
	 * @param tradesmanUserId
	 * @return true if successful, false otherwise
	 * @throws Exception
	 */
	public boolean deleteAllInvoicesForJob(final String jobRef, final String tradesmanUsername, final String tradesmanPassword, final Integer tradesmanUserId)
			throws Exception {
		final List<String> invoiceRefs = this.getAllInvoiceRefsForJob(jobRef, tradesmanUsername, tradesmanPassword, tradesmanUserId);
		final int nbrInvoices = invoiceRefs.size();
		for (int i = 0; i < nbrInvoices; i++) {
			String invoiceRef = invoiceRefs.get(i);
			HttpResponse deleteResponse = this.deleteInvoiceForJob(jobRef, invoiceRef, tradesmanUsername, tradesmanPassword, tradesmanUserId);
			if (deleteResponse.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Retrieves all invoices for a given job ref.
	 * 
	 * @param jobRef
	 * @param tradesmanUsername
	 * @param tradesmanPassword
	 * @return
	 * @throws Exception
	 */
	public List<String> getAllInvoiceRefsForJob(final String jobRef, final String tradesmanUsername, final String tradesmanPassword) throws Exception {
		Integer userId = userRetriever.getUserId(tradesmanUsername, tradesmanPassword);
		return this.getAllInvoiceRefsForJob(jobRef, tradesmanUsername, tradesmanPassword, userId);
	}

	/**
	 * Retrieves all invoices for a given job ref.
	 * 
	 * @param jobRef
	 * @param tradesmanUsername
	 * @param tradesmanPassword
	 * @param tradesmanUserId
	 * @return
	 * @throws Exception
	 */
	public List<String> getAllInvoiceRefsForJob(final String jobRef, final String tradesmanUsername, final String tradesmanPassword,
			final Integer tradesmanUserId) throws Exception {
		final List<String> invoiceRefs = paymentRequestSubmitter.getPaymentRequestRefsListForJob(tradesmanUsername, tradesmanPassword, tradesmanUserId, jobRef);
		return invoiceRefs;
	}

	/**
	 * Extract the invoice reference from the HTTP Location header.
	 * 
	 * @param response
	 * @return
	 */
	private String getInvoiceRef(final HttpResponse response) {
		String invoiceRef = null;
		String locationHeader = response.getFirstHeader("Location").getValue();
		invoiceRef = locationHeader.substring(locationHeader.lastIndexOf("/") + 1);
		return invoiceRef;
	}
}
