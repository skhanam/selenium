package uk.co.ratedpeople.test.functional.selenium.tmmobile;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import uk.co.ratedpeople.test.functional.selenium.TestScript;
import uk.co.ratedpeople.test.functional.selenium.tmmobile.functions.CreateInvoiceFromScratch;
import uk.co.ratedpeople.test.functional.selenium.tmmobile.functions.TestFunctions;
import uk.co.ratedpeople.test.functional.selenium.tmmobile.functions.TestFunctionsInvoices;

/**
 * 
 * @author olivier.renard
 * 
 */
public class CreateInvoiceTest extends TestScript {

	private Login tmLogin;
	private WebDriver driver;
	private TestFunctions testFunctions;
	private TestFunctionsInvoices testFunctionsInvoices;
	private CreateInvoiceFromScratch createInvoiceFromScratch;

	@BeforeMethod
	public void setUp() throws Exception {
		driver = context.driver;
		boolean vat = false;
		testFunctions = new TestFunctions(driver);
		testFunctionsInvoices = new TestFunctionsInvoices();
		createInvoiceFromScratch = new CreateInvoiceFromScratch(context, vat);
		tmLogin = new Login(context);
	}

	@Test(enabled = false)
	public void testNoBankAccountDetailsAndNoInvoicesAndSetUpBankAccountDetailsWithoutVatNumber() throws Exception {

		boolean vat = false;
		HashMap<String, String> hm = new HashMap<String, String>();

		hm = createInvoiceFromScratch.createInvoiceFromScratch(Login.INVOICE_TRADESMAN, Login.TRADESMAN_PASSWORD, vat);

		assertEquals(driver.findElement(By.id("btn-email-invoice")).getText(), "Email");
		driver.findElement(By.id("btn-email-invoice")).click();
		Thread.sleep(1000);

		assertEquals(driver.findElement(By.id("header-h1")).getText().trim(), "Invoice Sent");

		testFunctionsInvoices.deleteAllInvoicesForJob(hm.get("job_ref"), Login.INVOICE_TRADESMAN, Login.TRADESMAN_PASSWORD);
	}

	@Test(enabled = false)
	public void testNoBankAccountDetailsAndSetUpBankAccountDetailsWithVatNumber() throws Exception {

		boolean vat = true;
		HashMap<String, String> hm = new HashMap<String, String>();

		hm = createInvoiceFromScratch.createInvoiceFromScratch(Login.INVOICE_TRADESMAN, Login.TRADESMAN_PASSWORD, vat);

		assertEquals(driver.findElement(By.id("btn-email-invoice")).getText(), "Email");
		driver.findElement(By.id("btn-email-invoice")).click();
		Thread.sleep(1000);

		assertEquals(driver.findElement(By.id("header-h1")).getText().trim(), "Invoice Sent");

		testFunctionsInvoices.deleteAllInvoicesForJob(hm.get("job_ref"), Login.INVOICE_TRADESMAN, Login.TRADESMAN_PASSWORD);
	}

	@Test(enabled = false)
	public void testCreateInvoiceWithBankAccountDetailsWithoutVatNumber() throws Exception {

		String jobRef = testFunctions.homeOwnerSubmitsJobAndTradesmanBuysIt(Login.INVOICE_TRADESMAN, Login.TRADESMAN_PASSWORD);
		
		testFunctions.deleteBankAccountDetailsIfPresent(Login.INVOICE_TRADESMAN, Login.TRADESMAN_PASSWORD);
		
		testFunctions.createDefaultBankAccountDetailsWithoutVatNumber(Login.INVOICE_TRADESMAN, Login.TRADESMAN_PASSWORD);

		loginAndClickOnCreateAnInvoiceInNav(Login.INVOICE_TRADESMAN, Login.TRADESMAN_PASSWORD);

		assertEquals(driver.findElement(By.id("header-h1")).getText(), "Select a Job");

		testFunctions.clickOnJob(jobRef);

		assertEquals(driver.findElement(By.id("header-h1")).getText(), "Create an Invoice");

		driver.findElement(By.id("PaymentRequest_amount")).clear();
		driver.findElement(By.id("PaymentRequest_amount")).sendKeys("1000.00");

		driver.findElement(By.id("PaymentRequest_description")).clear();
		driver.findElement(By.id("PaymentRequest_description")).sendKeys("Please pay me for the work done.");

		driver.findElement(By.id("PaymentRequest_paymentMethods_1")).click();

		driver.findElement(By.id("btn-email-invoice")).click();

		Thread.sleep(1000);

		assertEquals(driver.findElement(By.id("header-h1")).getText().trim(), "Invoice Sent");
		testFunctionsInvoices.deleteAllInvoicesForJob(jobRef, Login.INVOICE_TRADESMAN, Login.TRADESMAN_PASSWORD);
	}

	@Test(enabled = false)
	public void testCreateInvoiceWithBankAccountDetailsWithVatNumber() throws Exception {

		String jobRef = testFunctions.homeOwnerSubmitsJobAndTradesmanBuysIt(Login.INVOICE_TRADESMAN, Login.TRADESMAN_PASSWORD);
		
		testFunctions.deleteBankAccountDetailsIfPresent(Login.INVOICE_TRADESMAN, Login.TRADESMAN_PASSWORD);
		
		testFunctions.createDefaultBankAccountDetailsWithVatNumber(Login.INVOICE_TRADESMAN, Login.TRADESMAN_PASSWORD);

		loginAndClickOnCreateAnInvoiceInNav(Login.INVOICE_TRADESMAN, Login.TRADESMAN_PASSWORD);

		assertEquals(driver.findElement(By.id("header-h1")).getText(), "Select a Job");

		testFunctions.clickOnJob(jobRef);
		
		Thread.sleep(1000);

		assertEquals(driver.findElement(By.id("header-h1")).getText(), "Create an Invoice");

		driver.findElement(By.id("PaymentRequest_amount")).clear();
		driver.findElement(By.id("PaymentRequest_amount")).sendKeys("1000.00");

		driver.findElement(By.id("PaymentRequest_vatAmount")).clear();
		driver.findElement(By.id("PaymentRequest_vatAmount")).sendKeys("20");

		driver.findElement(By.id("PaymentRequest_description")).clear();
		driver.findElement(By.id("PaymentRequest_description")).sendKeys("Please pay me for the work done.");

		driver.findElement(By.id("PaymentRequest_paymentMethods_1")).click();

		driver.findElement(By.id("btn-email-invoice")).click();
		Thread.sleep(1000);

		assertEquals(driver.findElement(By.id("header-h1")).getText().trim(), "Invoice Sent");
		testFunctionsInvoices.deleteAllInvoicesForJob(jobRef, Login.INVOICE_TRADESMAN, Login.TRADESMAN_PASSWORD);
	}

	@Test(enabled = false)
	public void testCreateInvoiceWithBankAccountDetailsWithVatNumberForNrpJob() throws Exception {

		testFunctions.deleteBankAccountDetailsIfPresent(Login.INVOICE_TRADESMAN, Login.TRADESMAN_PASSWORD);
		
		testFunctions.createDefaultBankAccountDetailsWithVatNumber(Login.INVOICE_TRADESMAN, Login.TRADESMAN_PASSWORD);

		String nrpJobRef = getJobIdRef(testFunctions.postNrpJob(Login.INVOICE_TRADESMAN, Login.TRADESMAN_PASSWORD));

		loginAndClickOnCreateAnInvoiceInNav(Login.INVOICE_TRADESMAN, Login.TRADESMAN_PASSWORD);

		assertEquals(driver.findElement(By.id("header-h1")).getText(), "Select a Job");

		testFunctions.clickOnJob(nrpJobRef);
		
		Thread.sleep(1000);

		assertEquals(driver.findElement(By.id("header-h1")).getText(), "Create an Invoice");

		driver.findElement(By.id("PaymentRequest_amount")).clear();
		driver.findElement(By.id("PaymentRequest_amount")).sendKeys("1000.00");

		driver.findElement(By.id("PaymentRequest_vatAmount")).clear();
		driver.findElement(By.id("PaymentRequest_vatAmount")).sendKeys("20");

		driver.findElement(By.id("PaymentRequest_description")).clear();
		driver.findElement(By.id("PaymentRequest_description")).sendKeys("Please pay me for the work done.");

		driver.findElement(By.id("PaymentRequest_paymentMethods_1")).click();

		driver.findElement(By.id("btn-email-invoice")).click();
		Thread.sleep(1000);

		assertEquals(driver.findElement(By.id("header-h1")).getText().trim(), "Invoice Sent");
		testFunctionsInvoices.deleteAllInvoicesForJob(nrpJobRef, Login.INVOICE_TRADESMAN, Login.TRADESMAN_PASSWORD);
	}

	@Test(enabled = false)
	public void testInvoiceCreatePreview() throws Exception {

	}

	@Test(enabled = false)
	public void testInvoiceCreateBackNavPrevention() throws Exception {

	}

	@Test(enabled = true)
	public void testCreateInvoiceCancel() throws Exception {

		String jobRef = testFunctions.homeOwnerSubmitsJobAndTradesmanBuysIt(Login.INVOICE_TRADESMAN, Login.TRADESMAN_PASSWORD);
		
		testFunctions.deleteBankAccountDetailsIfPresent(Login.INVOICE_TRADESMAN, Login.TRADESMAN_PASSWORD);

		testFunctions.createDefaultBankAccountDetailsWithoutVatNumber(Login.INVOICE_TRADESMAN, Login.TRADESMAN_PASSWORD);

		loginAndClickOnCreateAnInvoiceInNav(Login.INVOICE_TRADESMAN, Login.TRADESMAN_PASSWORD);

		assertEquals(driver.findElement(By.id("header-h1")).getText(), "Select a Job");

		testFunctions.clickOnJob(jobRef);

		assertEquals(driver.findElement(By.id("header-h1")).getText(), "Create an Invoice");

		driver.findElement(By.partialLinkText("Cancel")).click();

		assertEquals(driver.findElement(By.id("header-h1")).getText(), "Customer Details");
		assertTrue(driver.findElement(By.id("link-create-invoice")).isDisplayed());
	}

	private String getJobIdRef(HttpResponse response) {
		Header locationHeader = response.getFirstHeader("Location");
		String postJobSuccessUri = locationHeader.getValue();
		System.out.println(postJobSuccessUri);
		String idJob = postJobSuccessUri.substring(postJobSuccessUri.lastIndexOf('/') + 1);
		return idJob;
	}

	private void loginAndClickOnCreateAnInvoiceInNav(final String tmUserName, final String tmPassword) throws Exception {
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
