package uk.co.ratedpeople.test.functional.selenium.tmmobile;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import uk.co.ratedpeople.test.functional.selenium.TestScript;
import uk.co.ratedpeople.test.functional.selenium.tmmobile.functions.TestFunctions;

public class RequestRatingTest extends TestScript {

	private Login tmLogin;
	private WebDriver driver;
	private TestFunctions testFunctions;
	private String jobRef;

	@BeforeMethod
	public void setUp() throws Exception {
		driver = context.driver;
		testFunctions = new TestFunctions(driver);
		tmLogin = new Login(context);
	}

	@Test(enabled = false)
	public void testRequestRatingAfterInvoiceGenForRPJob() throws Exception {

	}

	@Test(enabled = false)
	public void requestRatingButCancelBySelectingAnotherJob() throws Exception {

		jobRef = testFunctions.homeOwnerSubmitsJobAndTradesmanBuysIt(Login.TRADESMAN, Login.TRADESMAN_PASSWORD);
		tmLogin.login();
		driver.findElement(By.id("nav-toggle")).click();
		Thread.sleep(1000);

		// commence request rating
		driver.findElement(By.id("nav-request-rating")).click();
		Thread.sleep(1000);

		assertEquals(driver.findElement(By.id("header-h1")).getText(), "Select a Job");

		assertEquals(driver.findElement(By.id("header-h1")).getText(), "Request a Rating");

		driver.findElement(By.partialLinkText("Change job")).click();

		assertEquals(driver.findElement(By.id("header-h1")).getText(), "Select a Job");
	}

	@Test(enabled = true)
	public void requestRatingSuccessForRPJob() throws Exception {

		jobRef = testFunctions.homeOwnerSubmitsJobAndTradesmanBuysIt(Login.TRADESMAN, Login.TRADESMAN_PASSWORD);
		tmLogin.login();
		driver.findElement(By.id("nav-toggle")).click();
		Thread.sleep(1000);

		driver.findElement(By.id("nav-jobs")).click();
		Thread.sleep(1000);

		testFunctions.clickOnJob(jobRef);

		assertEquals(driver.findElement(By.id("header-h1")).getText(), "Customer Details");
		driver.findElement(By.id("link-request-rating")).click();

		WebElement durationField = driver.findElement(By.id("AdditionalJobDetails_duration"));
		durationField.clear();
		durationField.sendKeys("5");

		WebElement priceField = driver.findElement(By.id("AdditionalJobDetails_price"));
		priceField.clear();
		priceField.sendKeys("1000.50");

		driver.findElement(By.id("btn-send")).click();
		Thread.sleep(5000);

		assertEquals(driver.findElement(By.id("header-h1")).getText(), "Rating Requested");

		// go back into job and check that rating requested
		driver.findElement(By.id("nav-toggle")).click();
		Thread.sleep(1000);

		driver.findElement(By.id("nav-jobs")).click();
		Thread.sleep(1000);

		testFunctions.clickOnJob(jobRef);
		driver.findElement(By.id("rating-requested-p"));
	}

	@Test(enabled = false)
	public void testRequestRatingAndReceiveRatingForRPJob() {

	}

	@Test(enabled = false)
	public void testNoJobsForTradesmanRequestRatingDisplayed() {

	}

	@Test(enabled = false)
	public void testRequestRatingThenMakeCreditRequest() {

	}

	@Test(enabled = false)
	public void testTMLeavesFeedbackAgainstHORating() {

	}

}
