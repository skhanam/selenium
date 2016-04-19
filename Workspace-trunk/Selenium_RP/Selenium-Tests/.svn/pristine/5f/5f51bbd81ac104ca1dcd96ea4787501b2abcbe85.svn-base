package uk.co.ratedpeople.test.functional.selenium.tmmobile;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import uk.co.ratedpeople.test.functional.selenium.TestScript;
import uk.co.ratedpeople.test.functional.selenium.tmmobile.functions.TestFunctions;

/**
 * 
 * @author craig.marcus
 * 
 */
public class DynamicLoadingTest extends TestScript {

	private Login tmLogin;
	private WebDriver driver;
	private TestFunctions testFunctions;

	private final int jobsPerPage = 10;
	private final int invoicesPerPage = 20;

	@BeforeMethod
	public void setUp() throws Exception {
		driver = context.driver;
		testFunctions = new TestFunctions(driver);
		tmLogin = new Login(context);

		// login and click on nav
		tmLogin.login();
		driver.findElement(By.id("nav-toggle")).click();
		Thread.sleep(1000);
	}

	@Test(enabled = true)
	public void testViewMorePurchasedJobs() throws Exception {

		driver.findElement(By.id("nav-jobs")).click();
		assertEquals(driver.findElement(By.id("header-h1")).getText(), "Jobs");

		// pagination functions where list items > 10
		// todo - count jobs on record for tradesman and only add where necessary
		// workaround - assuming only 1 page top up count to 11
		List<WebElement> jobList = driver.findElements(By.cssSelector("a[data-job]"));
		for (int i = 1; i <= ((jobsPerPage + 1) - jobList.size()); i++) {
			testFunctions.homeOwnerSubmitsJobAndTradesmanBuysIt(Login.TRADESMAN, Login.TRADESMAN_PASSWORD);
		}

		// simulate scroll dow
		testFunctions.scrollToId("link-load-more");
		Thread.sleep(8000);
		jobList = driver.findElements(By.cssSelector("a[data-job]"));
		if (jobList.size() < (jobsPerPage + 1)) {
			fail("scrolling test failed");
		}
	}

	@Test(enabled = false)
	public void testViewMoreInvoicesTest() throws Exception {

		testFunctions.homeOwnerSubmitsJobAndTradesmanBuysIt(Login.TRADESMAN, Login.TRADESMAN_PASSWORD);
	}

	@Test(enabled = false)
	public void testViewMoreInvoices() throws Exception {

		driver.findElement(By.id("nav-invoices")).click();
		assertEquals(driver.findElement(By.id("header-h1")).getText(), "Invoices");

		List<WebElement> invoiceList = driver.findElements(By.cssSelector("a[id^='N']"));
		for (int i = 1; i <= ((invoicesPerPage + 1) - invoiceList.size()); i++) {
			// todo add invoices
			testFunctions.homeOwnerSubmitsJobAndTradesmanBuysIt(Login.TRADESMAN, Login.TRADESMAN_PASSWORD);
		}

		// simulate scroll down
		testFunctions.scrollToId("link-load-more");
        Thread.sleep(5000);
		invoiceList = driver.findElements(By.cssSelector("a[data-job]"));
		if (invoiceList.size() < (invoicesPerPage + 1)) {
			fail("scrolling test failed");
		}
	}

}
