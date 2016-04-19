package uk.co.ratedpeople.test.functional.selenium.tmmobile;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import uk.co.ratedpeople.test.functional.selenium.TestScript;
import uk.co.ratedpeople.test.functional.selenium.tmmobile.functions.TestFunctions;

/**
 * @author craig.marcus
 */
public class ManageJobAlertsTest extends TestScript {

	private Login tmLogin;
	private WebDriver driver;
	private TestFunctions testFunctions;

	private static String tmWithNoAlertsUsername = "103943-18-Feb-2014-@ratedtrades.com";
	private static String tmWithNoAlertsPassword = "password";

	@BeforeMethod
	public void setUp() {
		driver = context.driver;
		testFunctions = new TestFunctions(driver);
		tmLogin = new Login(context);
	}

	@Test(enabled = true)
	public void testTradesmanHasNoJobAlerts() {

		tmLogin.login(tmWithNoAlertsUsername, tmWithNoAlertsPassword);
		assertNotNull(driver.findElement(By.id("no-alerts-div")));
	}

	@Test(enabled = true)
	public void testDeleteJobAlert() throws Exception {

		String jobRef = 
				 testFunctions.addGardeningRPAlert();
		
		tmLogin.login();
		// click on delete button, this is typically a swype event in IOS
		// for testing we will trigger the reveal of this button directly.
		
		assertNotNull(driver.findElement(By.cssSelector("a[data-job='" + jobRef + "']")));
		testFunctions.executeJavascriptOnPage("$(\"[data-job='" + jobRef + "'] li.delete\").show();");
		Thread.sleep(2000);
		// delete and wait for element to be removed
		driver.findElement(By.cssSelector("a[data-job='" + jobRef + "'] li.delete")).click();
		Thread.sleep(2000);

		// reload page
		driver.findElement(By.id("nav-toggle")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("nav-job-alerts")).click();
		Thread.sleep(1000);

		// ensure that this alert in not found
		List<WebElement> jobAlertList = driver.findElements(By.cssSelector("a[data-job='" + jobRef + "']"));
		assertEquals(jobAlertList.size(), 0);
	}

	@Test(enabled = true)
	public void testViewJobAlertsGoogleMap() throws Exception {

		testFunctions.addGardeningRPAlert();
		tmLogin.login();
		// wait for map to load
		driver.findElement(By.id("header-link-map")).click();
		Thread.sleep(10000);
		// check for dynamically added zoom buttons
		assertNotNull(driver.findElement(By.cssSelector("#gmap div[title='Zoom in']")));
		assertNotNull(driver.findElement(By.cssSelector("#gmap div[title='Zoom out']")));
		assertNotNull(driver.findElement(By.linkText("Terms of Use")));
	}

	@Test(enabled = false)
	public void testHomeownerImagesShowingOnJobAlert() {

	}

	@Test(enabled = true) 
	public void testFourthBuyAttemptBlockedGracefully() throws Exception {

		String jobRef = testFunctions.addGardeningRPAlert();

		Thread.sleep(6000);

		tmLogin.login();

		// check 1st to buy for new job
		testFunctions.clickOnJob(jobRef);
		assertEquals(driver.findElement(By.id("job-purchase-count")).getText(), "Be 1st to buy!");

		// buy for 1st time and return
		testFunctions.tradesmanBuysJob(jobRef, TestFunctions.TP_INTEGRATION_TEST_TM_MOBILE_1, TestFunctions.TP_INTEGRATION_TEST_TM_MOBILE_PASSWORD);
		
		
		driver.findElement(By.id("header-inner-back")).click();
		Thread.sleep(8000);
		testFunctions.clickOnJob(jobRef);
		assertEquals(driver.findElement(By.id("job-purchase-count")).getText(), "Be 2nd to buy.");
		// buy for 2nd time and return
		Thread.sleep(2000);
		testFunctions.tradesmanBuysJob(jobRef, TestFunctions.TP_INTEGRATION_TEST_TM_MOBILE_5, TestFunctions.TP_INTEGRATION_TEST_TM_MOBILE_PASSWORD);

		driver.findElement(By.id("header-inner-back")).click();
		testFunctions.clickOnJob(jobRef);
		assertEquals(driver.findElement(By.id("job-purchase-count")).getText(), "Be 3rd to buy.");
		// buy for 3rd time
		Thread.sleep(2000);
		testFunctions.tradesmanBuysJob(jobRef, TestFunctions.TP_INTEGRATION_TEST_TM_MOBILE_6, TestFunctions.TP_INTEGRATION_TEST_TM_MOBILE_PASSWORD);

		Thread.sleep(2000);

		// hit buy button
		driver.findElement(By.id("link-buy-job")).click();
		// check that unable to buy h2 and cancel button is displayed

		Thread.sleep(5000);

		WebElement overlayHeaderElement = driver.findElement(By.cssSelector("div.overlay-container h2"));
		assertNotNull(overlayHeaderElement);
		assertEquals(overlayHeaderElement.getText().trim(), "Job No Longer Available");

		// hit cancel
		WebElement cancelLink = driver.findElement(By.partialLinkText("Cancel"));
		assertNotNull(cancelLink);
		cancelLink.click();

		// reload page - https://tm.preprod/job-alerts/296284 (Cannot navigate back)
		driver.get(tmLogin.getRootURL() + "/job-alerts/" + jobRef);

		// check that buy button is not displayed
		List<WebElement> buyButtonList = driver.findElements(By.id("link-buy-job"));
		assertEquals(buyButtonList.size(), 0, "There should not be any buy button on the job page");

		//once FE fix the bug TRADE-859, uncomment the code
		// check that 'Job cannot be bought notification' is displayed instead of X to buy.
		WebElement jobPurchaseCountElement = driver.findElement(By.id("job-purchase-count"));
		assertEquals(jobPurchaseCountElement.getText().trim(), "This job is no longer available for purchase.",
				"The purchase copunt element should have text saying that the job is no longer available.");
	}
}