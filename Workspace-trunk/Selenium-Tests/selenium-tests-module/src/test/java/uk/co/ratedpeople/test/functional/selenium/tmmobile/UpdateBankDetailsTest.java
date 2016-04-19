package uk.co.ratedpeople.test.functional.selenium.tmmobile;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import uk.co.ratedpeople.test.functional.selenium.TestScript;
import uk.co.ratedpeople.test.functional.selenium.tmmobile.functions.TestFunctions;

/**
 * 
 * @author olivier.renard
 * 
 */
public class UpdateBankDetailsTest extends TestScript {

	private Login tmLogin;
	private WebDriver driver;
	private TestFunctions testFunctions;

	@BeforeMethod
	public void setUp() throws Exception {
		driver = context.driver;
		testFunctions = new TestFunctions(driver);
		tmLogin = new Login(context);

		testFunctions.deleteBankAccountDetailsIfPresent(Login.TRADESMAN, Login.TRADESMAN_PASSWORD);
		loginAndClickOnAccountDetailsAndBankDetailsInNav();
	}

	@Test(enabled = false)
	public void setUpBankDetailsWhenNoneExists() throws Exception {

		assertEquals(driver.findElement(By.id("header-h1")).getText().trim(), "Invoice Setup");

		driver.findElement(By.id("link-continue")).click();
		Thread.sleep(1000);

		assertEquals(driver.findElement(By.id("header-h1")).getText().trim(), "Edit Bank Details");

		driver.findElement(By.id("BankDetails_accountName")).clear();
		driver.findElement(By.id("BankDetails_accountName")).sendKeys("Test Account");

		driver.findElement(By.id("BankDetails_sortCode1")).clear();
		driver.findElement(By.id("BankDetails_sortCode1")).sendKeys("12");

		driver.findElement(By.id("BankDetails_sortCode2")).clear();
		driver.findElement(By.id("BankDetails_sortCode2")).sendKeys("34");

		driver.findElement(By.id("BankDetails_sortCode3")).clear();
		driver.findElement(By.id("BankDetails_sortCode3")).sendKeys("56");

		driver.findElement(By.id("BankDetails_accountNumber")).clear();
		driver.findElement(By.id("BankDetails_accountNumber")).sendKeys("12345678");

		driver.findElement(By.id("BankDetails_vatNumber")).clear();
		driver.findElement(By.id("BankDetails_vatNumber")).sendKeys("123456789012");

		driver.findElement(By.id("BankDetails_termsAndConditions")).clear();
		driver.findElement(By.id("BankDetails_termsAndConditions")).sendKeys("Terms and Conditions");

		assertEquals(driver.findElement(By.id("btn-save")).getText(), "Save");
		driver.findElement(By.id("btn-save")).click();

		assertEquals(driver.findElement(By.id("header-h1")).getText(), "Bank Details");
	}

	@Test(enabled = false)
	public void cancelDeleteBankDetails() throws Exception {

		assertEquals(driver.findElement(By.id("header-h1")).getText(), "Bank Details");

		driver.findElement(By.id("link-edit-details")).click();
		Thread.sleep(1000);

		assertEquals(driver.findElement(By.id("header-h1")).getText().trim(), "Edit Bank Details");

		driver.findElement(By.id("link-cancel")).click();
		Thread.sleep(1000);

		assertEquals(driver.findElement(By.id("header-h1")).getText(), "Bank Details");
	}

	@Test(enabled = false)
	public void declineDeleteBankDetails() throws Exception {

		assertEquals(driver.findElement(By.id("header-h1")).getText(), "Bank Details");

		driver.findElement(By.id("btn-delete-details")).click();
		Thread.sleep(1000);

		assertEquals(driver.findElement(By.id("link-no")).getText().trim(), "No");

		driver.findElement(By.id("link-no")).click();
		Thread.sleep(1000);

		assertEquals(driver.findElement(By.id("header-h1")).getText(), "Bank Details");
	}

	@Test(enabled = false)
	public void acceptDeleteBankDetails() throws Exception {

		assertEquals(driver.findElement(By.id("header-h1")).getText(), "Bank Details");

		driver.findElement(By.id("btn-delete-details")).click();
		Thread.sleep(1000);

		assertEquals(driver.findElement(By.id("link-yes")).getText().trim(), "Yes");

		driver.findElement(By.id("link-yes")).click();
		Thread.sleep(1000);

		assertEquals(driver.findElement(By.id("header-h1")).getText(), "Invoice Setup");
	}

	@Test(enabled = false)
	public void editBankDetailsSuccess() throws Exception {

		assertEquals(driver.findElement(By.id("header-h1")).getText(), "Bank Details");

		driver.findElement(By.id("link-edit-details")).click();
		Thread.sleep(1000);

		assertEquals(driver.findElement(By.id("header-h1")).getText().trim(), "Edit Bank Details");

		driver.findElement(By.id("BankDetails_termsAndConditions")).clear();
		driver.findElement(By.id("BankDetails_termsAndConditions")).sendKeys("My new terms and conditions");

		assertEquals(driver.findElement(By.id("btn-save")).getText(), "Save");
		driver.findElement(By.id("btn-save")).click();

		assertEquals(driver.findElement(By.id("header-h1")).getText(), "Bank Details");
	}

	@Test(enabled = false)
	public void editBankDetailsSortCodeInvalid() throws Exception {

		assertEquals(driver.findElement(By.id("header-h1")).getText(), "Bank Details");

		driver.findElement(By.id("link-edit-details")).click();
		Thread.sleep(1000);

		assertEquals(driver.findElement(By.id("header-h1")).getText().trim(), "Edit Bank Details");

		driver.findElement(By.id("BankDetails_sortCode3")).clear();
		driver.findElement(By.id("BankDetails_sortCode3")).sendKeys("SC");
		// force validation by clicking on another form element
		driver.findElement(By.id("BankDetails_sortCode2")).click();

		WebElement errorElement = driver.findElement(By.cssSelector("label.error"));
		assertNotNull(errorElement, "The error element should be present");
		assertEquals(errorElement.getText(), "Enter your 6 digit sort number");

		assertEquals(driver.findElement(By.id("btn-save")).getText(), "Save");
		driver.findElement(By.id("btn-save")).click();

		assertEquals(driver.findElement(By.id("header-h1")).getText().trim(), "Edit Bank Details");
	}

	@Test(enabled = false)
	public void editBankDetailsAccountNumberInvalid() throws Exception {

		assertEquals(driver.findElement(By.id("header-h1")).getText(), "Bank Details");

		driver.findElement(By.id("link-edit-details")).click();
		Thread.sleep(1000);

		assertEquals(driver.findElement(By.id("header-h1")).getText().trim(), "Edit Bank Details");

		driver.findElement(By.id("BankDetails_accountNumber")).clear();
		driver.findElement(By.id("BankDetails_accountNumber")).sendKeys("AN");
		// force validation by clicking on another form element
		driver.findElement(By.id("BankDetails_sortCode3")).click();

		WebElement errorElement = driver.findElement(By.cssSelector("label.error"));
		assertNotNull(errorElement, "The error element should be present");
		assertEquals(errorElement.getText(), "Enter your account number");

		assertEquals(driver.findElement(By.id("btn-save")).getText(), "Save");
		driver.findElement(By.id("btn-save")).click();

		assertEquals(driver.findElement(By.id("header-h1")).getText().trim(), "Edit Bank Details");
	}

	private void loginAndClickOnAccountDetailsAndBankDetailsInNav() throws Exception {
		// perform login and arrive at job details page
		tmLogin.login();

		// open the nav bar
		driver.findElement(By.id("nav-toggle")).click();
		Thread.sleep(1000);

		driver.findElement(By.id("nav-account-details")).click();
		Thread.sleep(1000);

		driver.findElement(By.id("link-bank-details")).click();
		Thread.sleep(1000);
	}

}
