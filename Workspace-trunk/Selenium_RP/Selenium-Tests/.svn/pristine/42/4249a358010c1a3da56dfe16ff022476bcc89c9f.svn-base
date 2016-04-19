package uk.co.ratedpeople.test.functional.selenium.tmmobile.functions;

import static org.testng.Assert.assertEquals;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import uk.co.ratedpeople.test.functional.SeleniumTestContext;
import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;
import uk.co.ratedpeople.test.functional.selenium.tmmobile.Login;

public class CreateInvoiceFromScratch extends TestScriptUtilities {

	private Login tmLogin;
	private WebDriver driver;
	private TestFunctions testFunctions;

	public CreateInvoiceFromScratch(SeleniumTestContext context, boolean vat) {
		super(context);
		driver = context.driver;
		testFunctions = new TestFunctions(driver);
		tmLogin = new Login(context);
		vat = false;

	}

	public HashMap<String, String> createInvoiceFromScratch(final String tmUserName, final String tmPassword, final boolean vat) throws Exception {

		HashMap<String, String> hm = new HashMap<String, String>();
		hm.put("ac_name", "Alliance & Leicester");
		hm.put("sc1", "02");
		hm.put("sc2", "04");
		hm.put("sc3", "50");
		hm.put("ac_num", "12345678");
		hm.put("vat_num", "123456789012");

		// jobRef = testFunctions.homeOwnerSubmitsJobAndTradesmanBuysIt();
		hm.put("job_ref", testFunctions.homeOwnerSubmitsJobAndTradesmanBuysIt(tmUserName, tmPassword));
		System.out.println("Added RP Job with ref:" + hm.get("job_ref"));
		hm.put("job_ref", testFunctions.homeOwnerSubmitsJobAndTradesmanBuysIt(tmUserName, tmPassword));

		// SQL to check for user's bank account details
		// select * from bank_account_details where user_id = (select id from user where user_name ="integration.test@ratedtrades.com");
		testFunctions.deleteBankAccountDetailsIfPresent(tmUserName, tmPassword);

		loginAndClickOnCreateAnInvoiceInNav(tmUserName, tmPassword);

		assertEquals(driver.findElement(By.id("header-h1")).getText(), "Select a Job");

		// click on the first available job
		testFunctions.clickOnJob(hm.get("job_ref"));

		assertEquals(driver.findElement(By.id("header-h1")).getText(), "Invoice Setup");
		assertEquals(driver.findElement(By.id("link-continue")).getText(), "Continue");
		driver.findElement(By.id("link-continue")).click();

		assertEquals(driver.findElement(By.id("header-h1")).getText().trim(), "Edit Bank Details");

		driver.findElement(By.id("BankDetails_accountName")).clear();
		driver.findElement(By.id("BankDetails_accountName")).sendKeys(hm.get("ac_name"));

		driver.findElement(By.id("BankDetails_sortCode1")).clear();
		driver.findElement(By.id("BankDetails_sortCode1")).sendKeys(hm.get("sc1"));

		driver.findElement(By.id("BankDetails_sortCode2")).clear();
		driver.findElement(By.id("BankDetails_sortCode2")).sendKeys(hm.get("sc2"));

		driver.findElement(By.id("BankDetails_sortCode3")).clear();
		driver.findElement(By.id("BankDetails_sortCode3")).sendKeys(hm.get("sc3"));

		driver.findElement(By.id("BankDetails_accountNumber")).clear();
		driver.findElement(By.id("BankDetails_accountNumber")).sendKeys(hm.get("ac_num"));

		if (vat == true) {
			driver.findElement(By.id("BankDetails_vatNumber")).clear();
			driver.findElement(By.id("BankDetails_vatNumber")).sendKeys(hm.get("vat_num"));
		}

		driver.findElement(By.id("BankDetails_termsAndConditions")).clear();
		driver.findElement(By.id("BankDetails_termsAndConditions")).sendKeys("Terms and Conditions");

		assertEquals(driver.findElement(By.id("btn-save")).getText(), "Save");
		driver.findElement(By.id("btn-save")).click();

		assertEquals(driver.findElement(By.id("header-h1")).getText(), "Create an Invoice");

		driver.findElement(By.id("PaymentRequest_amount")).clear();
		driver.findElement(By.id("PaymentRequest_amount")).sendKeys("1000.00");

		driver.findElement(By.id("PaymentRequest_description")).clear();
		driver.findElement(By.id("PaymentRequest_description")).sendKeys("Please pay me for the work done in time and get £10 discount.");

		driver.findElement(By.id("PaymentRequest_paymentMethods_1")).click();
		

		return hm;
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
