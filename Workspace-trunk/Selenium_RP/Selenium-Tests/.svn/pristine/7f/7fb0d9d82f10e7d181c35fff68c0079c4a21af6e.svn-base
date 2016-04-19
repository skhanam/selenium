package uk.co.ratedpeople.test.functional.selenium.tmmobile;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.util.HashMap;
import java.util.List;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import uk.co.ratedpeople.IntegrationTestUsers;
import uk.co.ratedpeople.test.functional.selenium.TestScript;
import uk.co.ratedpeople.test.functional.selenium.tmmobile.functions.CreateInvoiceFromScratch;
import uk.co.ratedpeople.test.functional.selenium.tmmobile.functions.TestFunctions;
import uk.co.ratedpeople.test.functional.selenium.tmmobile.functions.TestFunctionsInvoices;

public class ManageInvoicesTest extends TestScript {

	private static final String TM_WITH_NO_INVOICES = "integration.test.tm.mobile.no.invoices@ratedpeople.com";
	/*
	 * NOTES:
	 * 
	 * Valid values for payment request status are: UNPAID, PAID, DELETED, REFUNDED
	 * 
	 * Valid values for payment method are: CASH, BANK_TRANSFER, CHEQUE
	 */
	private WebDriver driver;
	private TestFunctions testFunctions;
	private TestFunctionsInvoices testFunctionsInvoices;
	private CreateInvoiceFromScratch createInvoiceFromScratch;
	private Login tmLogin;

	@BeforeMethod
	public void setUp() {

		driver = context.driver;
		boolean vat = false;
		testFunctions = new TestFunctions(driver);
		testFunctionsInvoices = new TestFunctionsInvoices();
		createInvoiceFromScratch = new CreateInvoiceFromScratch(context, vat);
		tmLogin = new Login(context);
	}

	@Test(enabled = false)
	public void testRaiseInvoiceAndPreviewWithoutVAtNumberAndEmail() throws Exception {

		boolean vat = false;
		HashMap<String, String> hm = new HashMap<String, String>();

		hm = createInvoiceFromScratch.createInvoiceFromScratch(Login.INVOICE_TRADESMAN, Login.TRADESMAN_PASSWORD, vat);
		assertEquals(driver.findElement(By.id("link-preview-invoice")).getText(), "Preview invoice");
		driver.findElement(By.id("link-preview-invoice")).click();

		assertEquals(driver.findElement(By.id("header-h1")).getText().trim(), "Invoice Preview");

		// Ensure account details are correct and check VAT number doesn't exist
		assertEquals(hm.get("ac_name")+", Sort Code: " + hm.get("sc1") + hm.get("sc2") + hm.get("sc3") + ", Account Number: " + hm.get("ac_num"),
				driver.findElement(By.xpath("//div[5]/p[3]")).getText());
		assertEquals(driver.findElement(By.id("vat-amount")).getText(), "VAT £0.00");

		emailInvoiceFromPreviewPage();

		testFunctionsInvoices.deleteAllInvoicesForJob(hm.get("job_ref"), Login.INVOICE_TRADESMAN, Login.TRADESMAN_PASSWORD);
	}

	@Test(enabled = false)
	public void testRaiseInvoiceAndPreviewWithVAtNumberAndEmail() throws Exception {

		boolean vat = true;
		HashMap<String, String> hm = new HashMap<String, String>();

		hm = createInvoiceFromScratch.createInvoiceFromScratch(Login.INVOICE_TRADESMAN, Login.TRADESMAN_PASSWORD, vat);
		assertEquals(driver.findElement(By.id("link-preview-invoice")).getText(), "Preview invoice");
		driver.findElement(By.id("link-preview-invoice")).click();

		assertEquals(driver.findElement(By.id("header-h1")).getText().trim(), "Invoice Preview");

		// check VAT number exist - there is a bug on preview page that doesn't show vat number. Test needs to assert it after bug fix

		assertEquals(hm.get("ac_name")+", Sort Code: " + hm.get("sc1") + hm.get("sc2") + hm.get("sc3") + ", Account Number: " + hm.get("ac_num"),
				driver.findElement(By.xpath("//div[5]/p[3]")).getText());
		assertEquals(driver.findElement(By.id("vat-amount")).getText().contains("VAT £0.00"), false);

		emailInvoiceFromPreviewPage();

		//testFunctionsInvoices.deleteAllInvoicesForJob(hm.get("job_ref"), Login.INVOICE_TRADESMAN, Login.TRADESMAN_PASSWORD);
	}

	@Test(enabled = false)
	public void testRaiseInvoiceAndViewWithoutVAtNumber() throws Exception {

		boolean vat = false;
		HashMap<String, String> hm = new HashMap<String, String>();

		// Create Invoice from a blank state containing no bank details and existing invoices
		hm = createInvoiceFromScratch.createInvoiceFromScratch(Login.INVOICE_TRADESMAN, Login.TRADESMAN_PASSWORD, vat);

		// check that we are on the final page

		emailInvoice();

		navigateToNavAndClickOnInvoice();

		driver.findElement(By.xpath("//*[@class='job container bordered cf']")).click();

		assertEquals(driver.findElement(By.id("header-h1")).getText().contains("UNPAID"), true);
		assertEquals(driver.findElement(By.id("vat-amount")).getText(), "VAT £0.00");

		testFunctionsInvoices.deleteAllInvoicesForJob(hm.get("job_ref"), Login.INVOICE_TRADESMAN, Login.TRADESMAN_PASSWORD);
	}

	@Test(enabled = false)
	public void testRaiseInvoiceAndViewWithVAtNumber() throws Exception {

		boolean vat = true;
		HashMap<String, String> hm = new HashMap<String, String>();

		// Create Invoice from a blank state containing no bank details and existing invoices
		hm = createInvoiceFromScratch.createInvoiceFromScratch(Login.INVOICE_TRADESMAN, Login.TRADESMAN_PASSWORD, vat);

		// check that we are on the final page

		emailInvoice();

		navigateToNavAndClickOnInvoice();

		driver.findElement(By.xpath("//*[@class='job container bordered cf']")).click();

		assertEquals(driver.findElement(By.id("header-h1")).getText().contains("UNPAID"), true);
		assertEquals(driver.findElement(By.id("vat-amount")).getText().contains("VAT £0.00"), false);

		testFunctionsInvoices.deleteAllInvoicesForJob(hm.get("job_ref"), Login.INVOICE_TRADESMAN, Login.TRADESMAN_PASSWORD);
	}

	@Test(enabled = false)
	public void testRaiseInvoiceAndSetStatusToPaid() throws Exception {

		boolean vat = true;
		HashMap<String, String> hm = new HashMap<String, String>();

		// Create Invoice from a blank state containing no bank details and existing invoices
		hm = createInvoiceFromScratch.createInvoiceFromScratch(Login.INVOICE_TRADESMAN, Login.TRADESMAN_PASSWORD, vat);

		// check that we are on the final page

		// Send invoice
		emailInvoice();

		// navigate back to invoice

		navigateToNavAndClickOnInvoice();

		// Click on the job
		driver.findElement(By.xpath("//*[@class='job container bordered cf']")).click();

		// Assert invoice status is unpaid
		assertTrue(driver.findElement(By.id("header-h1")).getText().contains("UNPAID"));

		// Change the status from unpaid to paid
		driver.findElement(By.id("link-change-status")).click();

		// click on the Paid button
		driver.findElement(By.id("btn-status-update-paid")).click();

		assertTrue(driver.findElement(By.id("header-h1")).getText().contains(" PAID"));

		testFunctionsInvoices.deleteAllInvoicesForJob(hm.get("job_ref"), Login.INVOICE_TRADESMAN, Login.TRADESMAN_PASSWORD);
	}

	@Test(enabled = false)
	public void testRaiseInvoiceAndSetStatusToUnpaid() throws Exception {

		boolean vat = true;
		HashMap<String, String> hm = new HashMap<String, String>();

		// Create Invoice from a blank state containing no bank details and existing invoices
		hm = createInvoiceFromScratch.createInvoiceFromScratch(Login.INVOICE_TRADESMAN, Login.TRADESMAN_PASSWORD, vat);

		// check that we are on the final page

		// Send invoice
		emailInvoice();

		// navigate back to invoice

		navigateToNavAndClickOnInvoice();

		// Click on the job
		driver.findElement(By.xpath("//*[@class='job container bordered cf']")).click();

		// Assert invoice status is unpaid
		assertTrue(driver.findElement(By.id("header-h1")).getText().contains("UNPAID"));

		// Change the status from unpaid to paid
		driver.findElement(By.id("link-change-status")).click();

		// click on the Paid button
		driver.findElement(By.id("btn-status-update-paid")).click();

		assertTrue(driver.findElement(By.id("header-h1")).getText().contains(" PAID"));

		// Change the status from paid to unpaid
		driver.findElement(By.id("link-change-status")).click();

		// click on the Unpaid button
		driver.findElement(By.id("btn-status-update-unpaid")).click();

		// set the invoice to Paid
		assertTrue(driver.findElement(By.id("header-h1")).getText().contains("UNPAID"));

		testFunctionsInvoices.deleteAllInvoicesForJob(hm.get("job_ref"), Login.INVOICE_TRADESMAN, Login.TRADESMAN_PASSWORD);
	}

	@Test(enabled = false)
	public void testRaiseInvoiceAndSetStatusToSameStatus() throws Exception {

		boolean vat = true;
		HashMap<String, String> hm = new HashMap<String, String>();

		// Create Invoice from a blank state containing no bank details and existing invoices
		hm = createInvoiceFromScratch.createInvoiceFromScratch(Login.INVOICE_TRADESMAN, Login.TRADESMAN_PASSWORD, vat);

		// check that we are on the final page

		// Send invoice
		emailInvoice();

		// navigate back to invoice

		navigateToNavAndClickOnInvoice();

		// Click on the job
		driver.findElement(By.xpath("//*[@class='job container bordered cf']")).click();

		// Assert invoice status is unpaid
		assertTrue(driver.findElement(By.id("header-h1")).getText().contains("UNPAID"));

		// Change the status from unpaid to paid
		driver.findElement(By.id("link-change-status")).click();

		// click on the Unpaid button
		driver.findElement(By.id("btn-status-update-unpaid")).click();

		assertTrue(driver.findElement(By.id("header-h1")).getText().contains("UNPAID"));

		testFunctionsInvoices.deleteAllInvoicesForJob(hm.get("job_ref"), Login.INVOICE_TRADESMAN, Login.TRADESMAN_PASSWORD);
	}

	@Test(enabled = false)
	public void testCreateAnInvoiceLinkPresentOnListOfInvoicesPageWhenAtLeastOneInvoiceExistsInList() throws Exception {

		boolean vat = false;
		HashMap<String, String> hm = new HashMap<String, String>();

		// Create Invoice from a blank state containing no bank details and existing invoices
		hm = createInvoiceFromScratch.createInvoiceFromScratch(Login.INVOICE_TRADESMAN, Login.TRADESMAN_PASSWORD, vat);

		// check that we are on the final page

		emailInvoice();

		navigateToNavAndClickOnInvoice();

		WebElement createInvoiceLink = driver.findElement(By.id("header-link-new"));

		assertNotNull(createInvoiceLink);
		assertTrue(createInvoiceLink.getText().trim().equals("Create an Invoice"));

		testFunctionsInvoices.deleteAllInvoicesForJob(hm.get("job_ref"), Login.INVOICE_TRADESMAN, Login.TRADESMAN_PASSWORD);
	}

	@Test(enabled = false)
	public void testCreateAnInvoiceLinkNotPresentOnListOfInvoicesPageWhenNoInvoiceExistsInList() throws Exception {

		final String tmUserName = TM_WITH_NO_INVOICES;
		final String tmPassword = Login.TRADESMAN_PASSWORD;

		tmLogin.login(tmUserName, tmPassword);

		navigateToNavAndClickOnInvoice();

		// the list should be empty
		List<WebElement> createInvoiceLinksList = driver.findElements(By.id("header-link-new"));

		assertNotNull(createInvoiceLinksList);
		assertEquals(createInvoiceLinksList.size(), 0);
	}

	@Test(enabled = true)
	public void testDeleteInvoiceRP() throws Exception {

		// Create first Invoice
		testPostInvoiceForJob();
		Thread.sleep(3000);
		// Go to invoices on screen
		loginAndClickOnInvoiceInNav(Login.INVOICE_TRADESMAN, Login.TRADESMAN_PASSWORD);
		Thread.sleep(3000);
		// Click on the job
		driver.findElement(By.xpath("//*[@class='job container bordered cf']")).click();
		Thread.sleep(3000);
		// Delete the invoice
		driver.findElement(By.id("btn-delete-invoice")).click();
		Thread.sleep(3000);
		driver.findElement(By.partialLinkText("Delete Invoice")).click();
		Thread.sleep(3000);
		//selenium implicit wait
				WebDriverWait wait = new WebDriverWait(driver, 10);
		
		// Assert customer details page is loaded (i.e if deletion succeeds)
		wait.until(ExpectedConditions.textToBePresentInElement(By.id("header-h1"), "Customer Details"));
		assertTrue(driver.findElement(By.id("link-create-invoice")).isDisplayed());

	}

	@Test(enabled = true)
	public void testDeleteInvoiceNonRP() throws Exception {

		testPostInvoiceForNrpJob();
		Thread.sleep(3000);
		// Go to invoices on screen
		loginAndClickOnInvoiceInNav(Login.INVOICE_TRADESMAN, Login.TRADESMAN_PASSWORD);
		Thread.sleep(3000);
		// Click on the job
		driver.findElement(By.xpath("//*[@class='job container bordered cf']")).click();
		Thread.sleep(3000);
		// Delete the job
		driver.findElement(By.id("btn-delete-invoice")).click();
		Thread.sleep(3000);
		driver.findElement(By.partialLinkText("Delete Invoice")).click();

		Thread.sleep(4000);
		driver.navigate().refresh();
		// Assert customer details page is loaded (i.e if deletion succeeds)
		assertEquals(driver.findElement(By.id("header-h1")).getText(), "Customer Details");
		assertTrue(driver.findElement(By.id("link-create-invoice")).isDisplayed());
	}

	/*
	 * The tests below simply test the REST API and ensure it works properly.
	 * 
	 * They do not test the TM mobile web app as such.
	 */
	@Test(enabled = false)
	public void testPostInvoiceForJob() throws Exception {

		final String tradesmanUsername = IntegrationTestUsers.TP_INVOICE_TEST;
		final String tradesmanPassword = IntegrationTestUsers.TP_PASSWORD;

		String jobRef = testFunctions.addGardeningRPAlert();

		testFunctions.createDefaultBankAccountDetailsWithoutVatNumber(tradesmanUsername, tradesmanPassword);

		testFunctions.tradesmanBuysJob(jobRef, tradesmanUsername, tradesmanPassword);

		HttpResponse response = testFunctionsInvoices.createInvoiceForJob(jobRef, tradesmanUsername, tradesmanPassword, 1000.00, 15.00, "description",
				"UNPAID", "CASH");

		assertEquals(response.getStatusLine().getStatusCode(), HttpStatus.SC_CREATED);
	}

	@Test(enabled = false)
	public void testPostInvoiceForNrpJob() throws Exception {

		final String tradesmanUsername = IntegrationTestUsers.TP_INVOICE_TEST;
		final String tradesmanPassword = IntegrationTestUsers.TP_PASSWORD;

		testFunctions.createDefaultBankAccountDetailsWithoutVatNumber(tradesmanUsername, tradesmanPassword);

		String nrpJobRef = getJobIdRef(testFunctions.postNrpJob(tradesmanUsername, tradesmanPassword));

		HttpResponse response = testFunctionsInvoices.createInvoiceForJob(nrpJobRef, tradesmanUsername, tradesmanPassword, 1000.00, 15.00, "description",
				"UNPAID", "CASH");

		assertEquals(response.getStatusLine().getStatusCode(), HttpStatus.SC_CREATED);
	}

	@Test(enabled = false)
	public void testPost3InvoicesForJobAndRetrieveThemAll() throws Exception {

		final String tradesmanUsername = TestFunctions.TP_INTEGRATION_TEST_TM_MOBILE_2;
		final String tradesmanPassword = TestFunctions.TP_INTEGRATION_TEST_TM_MOBILE_PASSWORD;

		String jobRef = testFunctions.addGardeningRPAlert();

		testFunctions.createDefaultBankAccountDetailsWithoutVatNumber(tradesmanUsername, tradesmanPassword);

		testFunctions.tradesmanBuysJob(jobRef, tradesmanUsername, tradesmanPassword);

		HttpResponse response1 = testFunctionsInvoices.createInvoiceForJob(jobRef, tradesmanUsername, tradesmanPassword, 1000.00, 15.00, "description",
				"UNPAID", "CASH");
		assertEquals(response1.getStatusLine().getStatusCode(), HttpStatus.SC_CREATED);
		HttpResponse response2 = testFunctionsInvoices.createInvoiceForJob(jobRef, tradesmanUsername, tradesmanPassword, 1000.00, 15.00, "description",
				"UNPAID", "CASH");
		assertEquals(response2.getStatusLine().getStatusCode(), HttpStatus.SC_CREATED);
		HttpResponse response3 = testFunctionsInvoices.createInvoiceForJob(jobRef, tradesmanUsername, tradesmanPassword, 1000.00, 15.00, "description",
				"UNPAID", "CASH");
		assertEquals(response3.getStatusLine().getStatusCode(), HttpStatus.SC_CREATED);

		List<String> invoiceRefs = testFunctionsInvoices.getAllInvoiceRefsForJob(jobRef, tradesmanUsername, tradesmanPassword);
		assertNotNull(invoiceRefs);
		assertEquals(invoiceRefs.size(), 3);
	}

	@Test(enabled = false)
	public void testPostInvoiceForJobAndDeleteIt() throws Exception {

		final String tradesmanUsername = TestFunctions.TP_INTEGRATION_TEST_TM_MOBILE_1;
		final String tradesmanPassword = TestFunctions.TP_INTEGRATION_TEST_TM_MOBILE_PASSWORD;

		String jobRef = testFunctions.addGardeningRPAlert();

		testFunctions.createDefaultBankAccountDetailsWithoutVatNumber(tradesmanUsername, tradesmanPassword);

		testFunctions.tradesmanBuysJob(jobRef, tradesmanUsername, tradesmanPassword);

		String invoiceRef = testFunctionsInvoices.createInvoiceForJobAndReturnInvoiceRef(jobRef, tradesmanUsername, tradesmanPassword, 1000.00, 15.00,
				"description", "UNPAID", "CASH");

		assertNotNull(invoiceRef);

		HttpResponse deleteResponse = testFunctionsInvoices.deleteInvoiceForJob(jobRef, invoiceRef, tradesmanUsername, tradesmanPassword);

		assertEquals(deleteResponse.getStatusLine().getStatusCode(), HttpStatus.SC_OK);
	}

	@Test(enabled = false)
	public void testPost3InvoicesForJobAndDeleteThemAll() throws Exception {

		final String tradesmanUsername = TestFunctions.TP_INTEGRATION_TEST_TM_MOBILE_2;
		final String tradesmanPassword = TestFunctions.TP_INTEGRATION_TEST_TM_MOBILE_PASSWORD;

		String jobRef = testFunctions.addGardeningRPAlert();

		testFunctions.createDefaultBankAccountDetailsWithoutVatNumber(tradesmanUsername, tradesmanPassword);

		testFunctions.tradesmanBuysJob(jobRef, tradesmanUsername, tradesmanPassword);

		HttpResponse response1 = testFunctionsInvoices.createInvoiceForJob(jobRef, tradesmanUsername, tradesmanPassword, 1000.00, 15.00, "description",
				"UNPAID", "CASH");
		assertEquals(response1.getStatusLine().getStatusCode(), HttpStatus.SC_CREATED);
		HttpResponse response2 = testFunctionsInvoices.createInvoiceForJob(jobRef, tradesmanUsername, tradesmanPassword, 1000.00, 15.00, "description",
				"UNPAID", "CASH");
		assertEquals(response2.getStatusLine().getStatusCode(), HttpStatus.SC_CREATED);
		HttpResponse response3 = testFunctionsInvoices.createInvoiceForJob(jobRef, tradesmanUsername, tradesmanPassword, 1000.00, 15.00, "description",
				"UNPAID", "CASH");
		assertEquals(response3.getStatusLine().getStatusCode(), HttpStatus.SC_CREATED);

		boolean successful = testFunctionsInvoices.deleteAllInvoicesForJob(jobRef, tradesmanUsername, tradesmanPassword);

		assertTrue(successful);
	}

	public void emailInvoice() throws Exception {
		// Click email button
		assertEquals(driver.findElement(By.id("btn-email-invoice")).getText(), "Email");
		driver.findElement(By.id("btn-email-invoice")).click();
		Thread.sleep(1000);
		assertEquals(driver.findElement(By.id("header-h1")).getText().trim(), "Invoice Sent");
	}

	public void emailInvoiceFromPreviewPage() throws Exception {
		// Click email button from preview page
		driver.findElement(By.id("btn-email")).click();
		Thread.sleep(1000);

		assertEquals(driver.findElement(By.id("header-h1")).getText().trim(), "Invoice Sent");
	}

	public void navigateToNavAndClickOnInvoice() throws Exception {
		// open the nav bar
		driver.findElement(By.id("nav-toggle")).click();
		Thread.sleep(1000);

		// commence create invoice
		driver.findElement(By.id("nav-invoices")).click();
	}

	public void loginAndClickOnInvoiceInNav(final String tmUserName, final String tmPassword) throws Exception {
		// perform login and arrive at job details page
		tmLogin.login(tmUserName, tmPassword);

		// open the nav bar
		driver.findElement(By.id("nav-toggle")).click();
		Thread.sleep(1000);

		// commence create invoice
		driver.findElement(By.id("nav-invoices")).click();
	}

	private String getJobIdRef(HttpResponse response) {
		Header locationHeader = response.getFirstHeader("Location");
		String postJobSuccessUri = locationHeader.getValue();
		System.out.println(postJobSuccessUri);
		String idJob = postJobSuccessUri.substring(postJobSuccessUri.lastIndexOf('/') + 1);
		return idJob;
	}

	public void loginAndClickOnCreateAnInvoiceInNav(final String tmUserName, final String tmPassword) throws Exception {
		// perform login and arrive at job details page
		tmLogin.login(tmUserName, tmPassword);

		// open the nav bar
		driver.findElement(By.id("nav-toggle")).click();
		Thread.sleep(1000);

		// commence create invoice
		driver.findElement(By.id("nav-invoices")).click();
		driver.findElement(By.partialLinkText("Create an Invoice")).click();
	}

}
