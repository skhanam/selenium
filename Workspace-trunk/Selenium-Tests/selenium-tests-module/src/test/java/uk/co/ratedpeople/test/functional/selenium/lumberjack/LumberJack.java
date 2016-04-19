package uk.co.ratedpeople.test.functional.selenium.lumberjack;

/**
 * 
 * @author ruhulla.mohammed
 * 
 */
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.apache.commons.lang.ArrayUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import uk.co.ratedpeople.APIJob;
import uk.co.ratedpeople.JobSubmitter;
import uk.co.ratedpeople.test.functional.SeleniumTestContext;
import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;
import uk.co.ratedpeople.test.functional.selenium.functions.Login;

public class LumberJack extends TestScriptUtilities {
	private WebDriver driver;
	public TestScriptUtilities scriptUtils;
	private Login login;

	public LumberJack(SeleniumTestContext context, TestScriptUtilities scriptUtils) {
		super(context);
		this.scriptUtils = scriptUtils;
		this.driver = context.driver;
		login = new Login(scriptUtils, context);

	}

	public void scrollToBottomofThePage(WebDriver scrollDriver) throws InterruptedException {
		Thread.sleep(3000);
		((JavascriptExecutor) scrollDriver).executeScript("scrollTo(0,6000)");
	}

	public void baseUrl() {
		String testUrl = context.getTestUrl();
		String testUrlLowercase = testUrl.toLowerCase();
		String lumberJackURL1 = "https://preprod.preprod/account";
		String lumberJackURL2 = "https://tradesmen-paris.uk.ratedpeople/";
		if (testUrlLowercase.indexOf("preprod") != -1) {
			goTo(lumberJackURL1);
		} else {
			// paris and others: use stub
			goTo(lumberJackURL2);
		}
	}

	public void switchToWindow() {
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
	}

	public void paginationTest(String username, final String postcode) throws Exception {
		WebDriverWait wait = new WebDriverWait(context.driver, 30);
		login.loginTP(username, "password");
		WebDriver scrollDriver = context.driver;
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("New lead viewing and sorting features coming soon - click here to try it now!")))
				.click();
		switchToWindow();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LumberJackXpathlocators.xpathLookup.get("WELCOME_POPUP_LJ_WALKTHROUGH")))).click();
		//choose minimum number of jobs per page (currently 5)
		By xpathNumberOfElementsPerPage = By.xpath(LumberJackXpathlocators.xpathLookup.get("MINIMUM_NUMBER_LEADS_PER_PAGE"));
		Integer numberOfElementsPerPage = Integer.valueOf(driver.findElement(xpathNumberOfElementsPerPage).getText());
		wait.until(ExpectedConditions.visibilityOfElementLocated(xpathNumberOfElementsPerPage)).click();

		postJobs(numberOfElementsPerPage*3+1, postcode);

		scrollToBottomofThePage(scrollDriver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("2"))).click();
		Thread.sleep(500);
		scrollToBottomofThePage(scrollDriver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LumberJackXpathlocators.xpathLookup.get("PAGINATION_NEXT_PAGE")))).click();
		Thread.sleep(500);
		scrollToBottomofThePage(scrollDriver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LumberJackXpathlocators.xpathLookup.get("PAGINATION_LAST_PAGE")))).click();
		Thread.sleep(500);
		scrollToBottomofThePage(scrollDriver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LumberJackXpathlocators.xpathLookup.get("PAGINATION_PREVIOUS_PAGE")))).click();
		Thread.sleep(500);
		scrollToBottomofThePage(scrollDriver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LumberJackXpathlocators.xpathLookup.get("PAGINATION_FIRST_PAGE")))).click();
		Thread.sleep(500);
		scrollToBottomofThePage(scrollDriver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("3"))).click();
		Thread.sleep(500);
		scrollToBottomofThePage(scrollDriver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("4"))).click();
		Thread.sleep(500);
		scrollToBottomofThePage(scrollDriver);
	}

	public void testNoOfJobsInThePage1(String username) throws Exception {
		WebDriverWait wait = new WebDriverWait(context.driver, 30);
		WebDriver scrollDriver = context.driver;
		login.loginTP(username, "password");
		// Select no of jobs from webpage page 1
		Thread.sleep(4000);
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("New lead viewing and sorting features coming soon - click here to try it now!")))
				.click();
		switchToWindow();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LumberJackXpathlocators.xpathLookup.get("WELCOME_POPUP_LJ_WALKTHROUGH")))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(LumberJackXpathlocators.xpathLookup.get("LISTOFJOBSINPAGE1"))));
		List<WebElement> numberofjobs = driver.findElement(By.xpath(LumberJackXpathlocators.xpathLookup.get("LISTOFJOBSINPAGE1"))).findElements(
				By.className("box"));
		System.out.print("total no. jobs available on webpage is :");
		System.out.println(numberofjobs.size());
		System.out.println("Text of the jobs available on the webpage :");
		scrollToBottomofThePage(scrollDriver);
		for (int i = 1; i <= 10; i++) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[1]/div/section[3]/div/div[2]/div/div/div[2]/div/div[" + i
					+ "]/div/div[2]/p")));
			String headerText = driver.findElement(By.xpath("html/body/div[1]/div/section[3]/div/div[2]/div/div/div[2]/div/div[" + i + "]/div/div[2]/p"))
					.getText();
			System.out.println(headerText);
			System.out.println("-------------------------------");
		}
	}

	// QuickBuy Test
	public void testQuickBuyWithAccBalance(String username) throws Exception {
		WebDriverWait wait = new WebDriverWait(context.driver, 50);
		/*
		 * Login lumberjackLogin = new Login(context); lumberjackLogin.login();
		 */
		login.loginTP(username, "password");
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("New lead viewing and sorting features coming soon - click here to try it now!")))
				.click();
		switchToWindow();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(LumberJackXpathlocators.xpathLookup.get("LISTOFJOBSINPAGE1"))));
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@data-action='purchase']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LumberJackXpathlocators.xpathLookup.get("CONFIRM_PURCHASE_BOX"))));
		assertEquals(driver.findElement(By.xpath(LumberJackXpathlocators.xpathLookup.get("CONFIRM_PURCHASE_BOX"))).getText(), "Confirm purchase");
		driver.findElement(By.xpath("//button[@data-action='purchase']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LumberJackXpathlocators.xpathLookup.get("CONFIRM_PURCHASE_BOX"))));
		assertEquals(driver.findElement(By.xpath(LumberJackXpathlocators.xpathLookup.get("CONFIRM_PURCHASE_BOX"))).getText(), "Confirm purchase");
		driver.findElement(By.xpath("//button[@data-action='confirm']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LumberJackXpathlocators.xpathLookup.get("THANKYOU_MESSAGE"))));
		assertEquals(driver.findElement(By.xpath(LumberJackXpathlocators.xpathLookup.get("THANKYOU_MESSAGE"))).getText(), "Thank You");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(LumberJackXpathlocators.xpathLookup.get("VIEW_LEAD")))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LumberJackXpathlocators.xpathLookup.get("PURCHASED_JOB_HEADER"))));
		assertEquals(driver.findElement(By.xpath(LumberJackXpathlocators.xpathLookup.get("PURCHASED_JOB_HEADER"))).getText(), "Purchased job");
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Purchased Leads"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(LumberJackXpathlocators.xpathLookup.get("LEADS_PURCHASED_TEXT"))));
	}

	// Buy Job from Full Details
	public void testBuyJobFromFullDetailsWithAccBalance(String username) throws Exception {
		WebDriverWait wait = new WebDriverWait(context.driver, 50);
		login.loginTP(username, "password");
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("New lead viewing and sorting features coming soon - click here to try it now!")))
				.click();
		switchToWindow();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(LumberJackXpathlocators.xpathLookup.get("LISTOFJOBSINPAGE1"))));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LumberJackXpathlocators.xpathLookup.get("VIEW_FULL_DETAILS_FIRST_LEAD")))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LumberJackXpathlocators.xpathLookup.get("JOB_LEAD_DETAILS"))));
		assertEquals(driver.findElement(By.xpath(LumberJackXpathlocators.xpathLookup.get("JOB_LEAD_DETAILS"))).getText(), "Job lead details");
		driver.findElement(By.xpath("//button[@data-action='purchase']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LumberJackXpathlocators.xpathLookup.get("CONFIRM_PURCHASE_BOX"))));
		assertEquals(driver.findElement(By.xpath(LumberJackXpathlocators.xpathLookup.get("CONFIRM_PURCHASE_BOX"))).getText(), "Confirm purchase");
		driver.findElement(By.xpath("//button[@data-action='cancel']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LumberJackXpathlocators.xpathLookup.get("JOB_LEAD_DETAILS"))));
		assertEquals(driver.findElement(By.xpath(LumberJackXpathlocators.xpathLookup.get("JOB_LEAD_DETAILS"))).getText(), "Job lead details");
		driver.findElement(By.xpath("//button[@data-action='purchase']")).click();
		Thread.sleep(2000);
		assertEquals(driver.findElement(By.xpath(LumberJackXpathlocators.xpathLookup.get("CONFIRM_PURCHASE_BOX"))).getText(), "Confirm purchase");
		driver.findElement(By.xpath("//button[@data-action='confirm']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LumberJackXpathlocators.xpathLookup.get("PURCHASED_JOB_HEADER"))));
		assertEquals(driver.findElement(By.xpath(LumberJackXpathlocators.xpathLookup.get("PURCHASED_JOB_HEADER"))).getText(), "Purchased job");
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Purchased Leads"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(LumberJackXpathlocators.xpathLookup.get("LEADS_PURCHASED_TEXT"))));
	}

	public void testQuickBuyWithExistingCard(String username) {
		WebDriverWait wait = new WebDriverWait(context.driver, 60);
		login.loginTP(username, "password");
		// ensure job alerts page load
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("New lead viewing and sorting features coming soon - click here to try it now!")))
				.click();
		switchToWindow();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LumberJackXpathlocators.xpathLookup.get("WELCOME_POPUP_LJ_WALKTHROUGH")))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(LumberJackXpathlocators.xpathLookup.get("LISTOFJOBSINPAGE1"))));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LumberJackXpathlocators.xpathLookup.get("VIEW_FULL_DETAILS_THIRD_LEAD"))));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-action='purchase']")));
		driver.findElement(By.xpath("//button[@data-action='purchase']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LumberJackXpathlocators.xpathLookup.get("CONFIRM_PURCHASE_BOX"))));
		assertEquals(driver.findElement(By.xpath(LumberJackXpathlocators.xpathLookup.get("CONFIRM_PURCHASE_BOX"))).getText(), "Confirm purchase");
		driver.findElement(By.xpath("//button[@data-action='confirm']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LumberJackXpathlocators.xpathLookup.get("THANKYOU_MESSAGE"))));
		assertEquals(driver.findElement(By.xpath(LumberJackXpathlocators.xpathLookup.get("THANKYOU_MESSAGE"))).getText(), "Thank You");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(LumberJackXpathlocators.xpathLookup.get("VIEW_LEAD")))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LumberJackXpathlocators.xpathLookup.get("PURCHASED_JOB_HEADER"))));
		assertEquals(driver.findElement(By.xpath(LumberJackXpathlocators.xpathLookup.get("PURCHASED_JOB_HEADER"))).getText(), "Purchased job");
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Purchased Leads"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(LumberJackXpathlocators.xpathLookup.get("LEADS_PURCHASED_TEXT"))));
	}

	public void testQuickBuyWithNewCard(String username) {
		WebDriverWait wait = new WebDriverWait(context.driver, 50);
		login.loginTP(username, "password");
		// ensure job alerts page load
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("New lead viewing and sorting features coming soon - click here to try it now!")))
				.click();
		switchToWindow();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(LumberJackXpathlocators.xpathLookup.get("LISTOFJOBSINPAGE1"))));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LumberJackXpathlocators.xpathLookup.get("VIEW_FULL_DETAILS_FIRST_LEAD"))));
		driver.findElement(By.xpath("//button[@data-action='purchase']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LumberJackXpathlocators.xpathLookup.get("CONFIRM_PURCHASE_BOX"))));
		driver.findElement(By.xpath("//*[@data-action='change-card']")).click();
		driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Admin Card");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(LumberJackXpathlocators.xpathLookup.get("CREDITCARD_NUMBER")))).sendKeys(
				"5404000000000001");
		scriptUtils.selectDropdown(By.xpath("//html/body/div[1]/div/div/div/div/div/div[2]/div/div/div[2]/div[2]/div/div/form/div/div[4]/div[1]/select"), 3);
		scriptUtils.selectDropdown(By.xpath("//html/body/div[1]/div/div/div/div/div/div[2]/div/div/div[2]/div[2]/div/div/form/div/div[4]/div[2]/select"), 6);
		driver.findElement(By.name("cv2")).sendKeys("123");
		driver.findElement(By.xpath("//button[@data-action='confirm']")).click(); // confirm
																					// purchase
		scriptUtils.sleep(3000);
		driver.findElement(By.name("password")).sendKeys("password");
		scriptUtils.click(By.xpath("//input[@type='submit']"));
		scriptUtils.sleep(11000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LumberJackXpathlocators.xpathLookup.get("PURCHASED_JOB"))));
	}

	public void testBuyLeadFromFullDetailsWithExistingCard(String username) throws Exception {
		WebDriverWait wait = new WebDriverWait(context.driver, 60);
		login.loginTP(username, "password");
		// ensure job alerts page load
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("New lead viewing and sorting features coming soon - click here to try it now!")))
				.click();
		switchToWindow();
		driver.manage().deleteCookieNamed("welcome_1");
		driver.navigate().refresh();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LumberJackXpathlocators.xpathLookup.get("WELCOME_POPUP_LJ_WALKTHROUGH")))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(LumberJackXpathlocators.xpathLookup.get("LISTOFJOBSINPAGE1"))));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LumberJackXpathlocators.xpathLookup.get("VIEW_FULL_DETAILS_FIRST_LEAD")))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LumberJackXpathlocators.xpathLookup.get("JOB_LEAD_DETAILS"))));
		assertEquals(driver.findElement(By.xpath(LumberJackXpathlocators.xpathLookup.get("JOB_LEAD_DETAILS"))).getText(), "Job lead details");
		driver.findElement(By.xpath("//button[@data-action='purchase']")).click(); // Buy
																					// Button
		Thread.sleep(4000);
		assertEquals(driver.findElement(By.xpath(LumberJackXpathlocators.xpathLookup.get("CONFIRM_PURCHASE_TEXT"))).getText(), "Confirm purchase");
		driver.findElement(By.xpath("//button[@data-action='confirm']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LumberJackXpathlocators.xpathLookup.get("PURCHASED_JOB"))));
		Thread.sleep(3000);
	}

	public void testBuyLeadFromFullDetailsWithNewCard(String username) {
		WebDriverWait wait = new WebDriverWait(context.driver, 50);
		login.loginTP(username, "password");
		// ensure job alerts page load
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("New lead viewing and sorting features coming soon - click here to try it now!")))
				.click();
		switchToWindow();
		/*
		 * driver.manage().deleteCookieNamed("welcome_1");
		 * driver.navigate().refresh();
		 * wait.until(ExpectedConditions.visibilityOfElementLocated
		 * (By.xpath(LumberJackXpathlocators
		 * .xpathLookup.get("WELCOME_POPUP_LJ_WALKTHROUGH")))).click();
		 */
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(LumberJackXpathlocators.xpathLookup.get("LISTOFJOBSINPAGE1"))));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LumberJackXpathlocators.xpathLookup.get("VIEW_FULL_DETAILS_FIRST_LEAD")))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LumberJackXpathlocators.xpathLookup.get("JOB_LEAD_DETAILS"))));
		assertEquals(driver.findElement(By.xpath(LumberJackXpathlocators.xpathLookup.get("JOB_LEAD_DETAILS"))).getText(), "Job lead details");
		driver.findElement(By.xpath("//button[@data-action='purchase']")).click(); // Buy
																					// Button
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LumberJackXpathlocators.xpathLookup.get("CONFIRM_PURCHASE_BOX"))));
		assertEquals(driver.findElement(By.xpath(LumberJackXpathlocators.xpathLookup.get("CONFIRM_PURCHASE_BOX"))).getText(), "Confirm purchase");
		driver.findElement(By.xpath("//*[@data-action='change-card']")).click();
		scriptUtils.sleep(2000);
		driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Admin Card");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(LumberJackXpathlocators.xpathLookup.get("CREDITCARD_NUMBER")))).sendKeys(
				"5404000000000001");
		scriptUtils.selectDropdown(By.xpath("(//*[@name='expirydate.month'])"), 3);
		scriptUtils.selectDropdown(By.xpath("(//*[@name='expirydate.year'])"), 6);
		driver.findElement(By.name("cv2")).sendKeys("123");
		driver.findElement(By.xpath("//button[@data-action='confirm']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@name='amount'])")));
		driver.findElement(By.name("password")).sendKeys("password");
		scriptUtils.click(By.xpath("//input[@type='submit']"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LumberJackXpathlocators.xpathLookup.get("PURCHASED_JOB_HEADER"))));
		assertEquals(driver.findElement(By.xpath(LumberJackXpathlocators.xpathLookup.get("PURCHASED_JOB_HEADER"))).getText(), "Purchased job");
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Purchased Leads"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(LumberJackXpathlocators.xpathLookup.get("LEADS_PURCHASED_TEXT"))));
	}

	// Delete Job from Lead List page
	public void testDeleteJobFromLeadListPage(String username, String reasonId, String postcode) throws Exception {
		WebDriverWait wait = new WebDriverWait(context.driver, 50);
		login.loginTP(username, "password");
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("New lead viewing and sorting features coming soon - click here to try it now!")))
				.click();
		switchToWindow();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LumberJackXpathlocators.xpathLookup.get("WELCOME_POPUP_LJ_WALKTHROUGH")))).click();
		postJobs(1, postcode);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(LumberJackXpathlocators.xpathLookup.get("LISTOFJOBSINPAGE1"))));
		Integer leadsAvailableBeforeDelete = getNumberLeadsAvailable();
		// Delete Job Lead
		deleteJob(reasonId);
		Integer leadsAvailableAfterDelete = getNumberLeadsAvailable();
		assertEquals((leadsAvailableBeforeDelete - 1) == leadsAvailableAfterDelete, true);
	}

	// Delete Job from Full Details page
	public void testDeleteJobFromFullDetailsPage(String username, String reasonId, String postcode) throws Exception {
		WebDriverWait wait = new WebDriverWait(context.driver, 50);
		login.loginTP(username, "password");
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("New lead viewing and sorting features coming soon - click here to try it now!")))
				.click();
		switchToWindow();
		scriptUtils.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LumberJackXpathlocators.xpathLookup.get("WELCOME_POPUP_LJ_WALKTHROUGH")))).click();
		postJobs(1, postcode);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(LumberJackXpathlocators.xpathLookup.get("LISTOFJOBSINPAGE1"))));
		Integer leadsAvailableBeforeDelete = getNumberLeadsAvailable();
		// Delete Job Lead
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LumberJackXpathlocators.xpathLookup.get("CLICK_ANYWHERE_ON_JOB")))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LumberJackXpathlocators.xpathLookup.get("JOB_LEAD_DETAILS"))));
		assertEquals(driver.findElement(By.xpath(LumberJackXpathlocators.xpathLookup.get("JOB_LEAD_DETAILS"))).getText(), "Job lead details");
		deleteJob(reasonId);
		Integer leadsAvailableAfterDelete = getNumberLeadsAvailable();
		assertEquals((leadsAvailableBeforeDelete - 1) == leadsAvailableAfterDelete, true);
	}

	public void firstBuy(String username) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 90);
		// baseUrl();
		login.loginTP(username, "password");
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("New lead viewing and sorting features coming soon - click here to try it now!")))
				.click();
		switchToWindow();
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LumberJackXpathlocators.xpathLookup.get("WELCOME_POPUP_LJ_WALKTHROUGH")))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LumberJackXpathlocators.xpathLookup.get("VIEW_FULL_DETAILS_FIRST_LEAD"))));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LumberJackXpathlocators.xpathLookup.get("1st_2nd_3rd_TO_BUY"))));
		assertEquals(driver.findElement(By.xpath(LumberJackXpathlocators.xpathLookup.get("1st_2nd_3rd_TO_BUY"))).getText(), "Be 1st to buy!");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LumberJackXpathlocators.xpathLookup.get("1st_2nd_3rd_TO_BUY")))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@data-action='purchase']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@data-action='confirm']")).click();
		Thread.sleep(3000);
//		driver.findElement(By.xpath(".//*[@id='modal-controls']/div/div")).click();
		Thread.sleep(8000);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LumberJackXpathlocators.xpathLookup.get("PURCHASED_JOB_HEADER"))));
//		assertEquals(driver.findElement(By.xpath(LumberJackXpathlocators.xpathLookup.get("PURCHASED_JOB_HEADER"))).getText(), "Purchased job");
		Thread.sleep(3000);
	}

	public void SecondBuy(String username) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 90);
		login.loginTP(username, "password");
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("New lead viewing and sorting features coming soon - click here to try it now!")))
				.click();
		switchToWindow();
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LumberJackXpathlocators.xpathLookup.get("WELCOME_POPUP_LJ_WALKTHROUGH")))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LumberJackXpathlocators.xpathLookup.get("VIEW_FULL_DETAILS_FIRST_LEAD"))));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LumberJackXpathlocators.xpathLookup.get("1st_2nd_3rd_TO_BUY"))));
		assertEquals(driver.findElement(By.xpath(LumberJackXpathlocators.xpathLookup.get("1st_2nd_3rd_TO_BUY"))).getText(), "Be 2nd to buy");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LumberJackXpathlocators.xpathLookup.get("1st_2nd_3rd_TO_BUY")))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@data-action='purchase']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@data-action='confirm']")).click();
		Thread.sleep(6000);
		driver.findElement(By.xpath(".//*[@id='modal-controls']/div/div")).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LumberJackXpathlocators.xpathLookup.get("PURCHASED_JOB_HEADER"))));
		assertEquals(driver.findElement(By.xpath(LumberJackXpathlocators.xpathLookup.get("PURCHASED_JOB_HEADER"))).getText(), "Purchased job");
		Thread.sleep(3000);
	}

	public void ThirdBuy(String username) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 90);
		login.loginTP(username, "password");
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("New lead viewing and sorting features coming soon - click here to try it now!")))
				.click();
		switchToWindow();
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LumberJackXpathlocators.xpathLookup.get("WELCOME_POPUP_LJ_WALKTHROUGH")))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LumberJackXpathlocators.xpathLookup.get("VIEW_FULL_DETAILS_FIRST_LEAD"))));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LumberJackXpathlocators.xpathLookup.get("1st_2nd_3rd_TO_BUY"))));
		assertEquals(driver.findElement(By.xpath(LumberJackXpathlocators.xpathLookup.get("1st_2nd_3rd_TO_BUY"))).getText(), "Be 3rd to buy");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LumberJackXpathlocators.xpathLookup.get("1st_2nd_3rd_TO_BUY")))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@data-action='purchase']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@data-action='confirm']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='modal-controls']/div/div")).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LumberJackXpathlocators.xpathLookup.get("PURCHASED_JOB_HEADER"))));
		assertEquals(driver.findElement(By.xpath(LumberJackXpathlocators.xpathLookup.get("PURCHASED_JOB_HEADER"))).getText(), "Purchased job");
		Thread.sleep(3000);
		/*
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * LumberJackXpathlocators.xpathLookup.get("PURCHASE_COUNT"))));
		 * driver.findElement
		 * (By.xpath(LumberJackXpathlocators.xpathLookup.get("PURCHASE_COUNT"
		 * ))).equals(3);
		 */
	}

	public void testBuyLeadWithNewCardNegativetest() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		driver = context.driver;
		context.driver.get(context.getTestHttpsTMMobileURL());
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username"))).sendKeys("LJNegativeTest@ratedtrades.com");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).sendKeys("password");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btn_login"))).click();
		Thread.sleep(2000);
		driver.findElement(By.id("nav-toggle")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Try new features")).click();
		Thread.sleep(1000);
		switchToWindow();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(LumberJackXpathlocators.xpathLookup.get("LISTOFJOBSINPAGE1"))));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LumberJackXpathlocators.xpathLookup.get("VIEW_FULL_DETAILS_FIRST_LEAD"))));
		driver.findElement(By.xpath("//button[@data-action='purchase']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LumberJackXpathlocators.xpathLookup.get("CONFIRM_PURCHASE_BOX"))));
		driver.findElement(By.xpath("//button[@data-action='cancel']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LumberJackXpathlocators.xpathLookup.get("VIEW_FULL_DETAILS_FIRST_LEAD"))));
		driver.findElement(By.xpath("//button[@data-action='purchase']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LumberJackXpathlocators.xpathLookup.get("CONFIRM_PURCHASE_BOX"))));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@data-action='confirm']")).click(); // confirm
																					// purchase
		assertEquals(driver.findElement(By.xpath("(//*[@data-errors='name'])")).getText(), "Please enter the name as shown on the card");
		assertEquals(driver.findElement(By.xpath("(//*[@data-errors='cardnumber'])")).getText(), "Please enter a valid card number");
		assertEquals(driver.findElement(By.xpath("(//*[@data-errors='expirydate.month'])")).getText(), "Please enter a valid expiry month");
		assertEquals(driver.findElement(By.xpath("(//*[@data-errors='expirydate.year'])")).getText(), "Please enter a valid expiry year");
		assertEquals(driver.findElement(By.xpath("(//*[@data-errors='cv2'])")).getText(), "Please enter a valid Card Security Code.");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='name']")).sendKeys("XYZ");
		assertEquals(driver.findElement(By.xpath("(//*[@data-errors='name'])")).getText(), "Please enter the name as shown on the card");
		driver.findElement(By.xpath("//input[@name='name']")).clear();
		driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Admin Card");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(LumberJackXpathlocators.xpathLookup.get("CREDITCARD_NUMBER")))).sendKeys("54040000");
		assertEquals(driver.findElement(By.xpath("(//*[@data-errors='cardnumber'])")).getText(), "Please enter a valid card number");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(LumberJackXpathlocators.xpathLookup.get("CREDITCARD_NUMBER")))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(LumberJackXpathlocators.xpathLookup.get("CREDITCARD_NUMBER"))))
				.sendKeys("aaaaaaaaaaaaa");
		assertEquals(driver.findElement(By.xpath("(//*[@data-errors='cardnumber'])")).getText(), "Please enter a valid card number");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(LumberJackXpathlocators.xpathLookup.get("CREDITCARD_NUMBER")))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(LumberJackXpathlocators.xpathLookup.get("CREDITCARD_NUMBER")))).sendKeys(
				"12345678912312345");
		assertEquals(driver.findElement(By.xpath("(//*[@data-errors='cardnumber'])")).getText(), "Please enter a valid card number");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(LumberJackXpathlocators.xpathLookup.get("CREDITCARD_NUMBER")))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(LumberJackXpathlocators.xpathLookup.get("CREDITCARD_NUMBER")))).sendKeys(
				"1234567891231230"); // wrong card number
		scriptUtils.selectDropdown(By.xpath("(//*[@name='expirydate.month'])"), 3);
		scriptUtils.selectDropdown(By.xpath("(//*[@name='expirydate.year'])"), 6);
		driver.findElement(By.name("cv2")).sendKeys("abc");
		assertEquals(driver.findElement(By.xpath("(//*[@data-errors='cv2'])")).getText(), "Please enter a valid Card Security Code.");
		driver.findElement(By.name("cv2")).clear();
		driver.findElement(By.name("cv2")).sendKeys("123456");
		assertEquals(driver.findElement(By.xpath("(//*[@data-errors='cv2'])")).getText(), "Please enter a valid Card Security Code.");
		driver.findElement(By.name("cv2")).clear();
		driver.findElement(By.name("cv2")).sendKeys("123");
		driver.findElement(By.xpath("//button[@data-action='confirm']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LumberJackXpathlocators.xpathLookup.get("CONFIRM_PURCHASE_BOX"))));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LumberJackXpathlocators.xpathLookup.get("ERROR_ADDING_NEW_CARD"))));
		driver.findElement(By.xpath("//*[@data-action='change-card']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(LumberJackXpathlocators.xpathLookup.get("CREDITCARD_NUMBER")))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(LumberJackXpathlocators.xpathLookup.get("CREDITCARD_NUMBER")))).sendKeys(
				"5404000000000001");
		driver.findElement(By.xpath("//button[@data-action='confirm']")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@name='amount'])"))); // wait
																										// for
																										// 3D
																										// secure
		driver.findElement(By.name("password")).sendKeys("WrongPassword");
		scriptUtils.click(By.xpath("//input[@type='submit']"));
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LumberJackXpathlocators.xpathLookup.get("ERROR_ADDING_NEW_CARD"))));
		assertEquals(driver.findElement(By.xpath(LumberJackXpathlocators.xpathLookup.get("ERROR_ADDING_NEW_CARD"))).getText(),
				"3D-Authentication failed. Your card vendor's rules require a successful 3D-authentication.");
	}

	public void testListJobAlertSortTest(String username, String sortCriteria, APIJob[] jobs)
			throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		login.loginTP(username, "password");
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("New lead viewing and sorting features coming soon - click here to try it now!"))).click();
		switchToWindow();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LumberJackXpathlocators.xpathLookup.get("LJ_SORT_COMBO_BOX"))));

		selectLJJobAlertSortCriteria(sortCriteria);
		assertTrue(iterateAndFindJobAlerts(jobs), "Incorrect sorting for '" + sortCriteria + "'");
	}

	public void testListJobAlertFilterSkillsView(String username, String expandSkillsLink, Integer... skills) throws InterruptedException, TimeoutException {
		WebDriverWait wait = loginLJ(username, 5);
		//Click to display all the trades available
		scriptUtils.sleep(100);
		By expandSkills = By.xpath(LumberJackXpathlocators.xpathLookup.get(expandSkillsLink));
		wait.until(ExpectedConditions.visibilityOfElementLocated(expandSkills));
		scriptUtils.clickIfExists(expandSkills);

		//iterate over the all the skills: if cannot find one, an exception is thrown
		for(Integer skill:skills){
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("id('skills["+skill+"]')")));
		}
	}

	public void testListJobAlertFilter(String username, String filterTab, String xPathCriterionJobs1, String xPathCriterionJob2, String xPathCriterion3, APIJob[] jobs1, APIJob[] jobs2) throws InterruptedException {
		WebDriverWait wait = loginLJ(username, 60);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LumberJackXpathlocators.xpathLookup.get("WELCOME_POPUP_LJ_WALKTHROUGH")))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LumberJackXpathlocators.xpathLookup.get(filterTab)))).click();
		//filter by criterion 1
		By filterCriterion1 = By.xpath(LumberJackXpathlocators.xpathLookup.get(xPathCriterionJobs1));
		wait.until(ExpectedConditions.visibilityOfElementLocated(filterCriterion1));
		scriptUtils.clickIfExists(filterCriterion1);
		By submitFilterButton = By.xpath(LumberJackXpathlocators.xpathLookup.get("SUBMIT_FILTER"));
		scriptUtils.clickIfExists(submitFilterButton);
		scriptUtils.sleep(500);

		assertTrue(iterateAndFindJobAlerts(jobs1), "The list of jobs ["+jobs1.toString()+"] cannot be found: filtering by "+ xPathCriterionJobs1 + " is not working correctly.");
		//unselect criterion 1
		scriptUtils.clickIfExists(filterCriterion1);

		//filter by criterion 2
		By filterCriterion2 = By.xpath(LumberJackXpathlocators.xpathLookup.get(xPathCriterionJob2));
		wait.until(ExpectedConditions.visibilityOfElementLocated(filterCriterion2));
		scriptUtils.clickIfExists(filterCriterion2);
		scriptUtils.clickIfExists(submitFilterButton);
		scriptUtils.sleep(500);

		assertTrue(iterateAndFindJobAlerts(jobs2), "The list of jobs ["+jobs2.toString()+"] timing cannot be found: filtering by "+ xPathCriterionJob2 + " is not working correctly.");
		//unselect criterion 2
		scriptUtils.clickIfExists(filterCriterion2);

		//filter by criterion 1 and criterion 2
		scriptUtils.clickIfExists(filterCriterion1);
		scriptUtils.clickIfExists(filterCriterion2);
		scriptUtils.clickIfExists(submitFilterButton);
		scriptUtils.sleep(500);

		APIJob[] jobs1And2 = (APIJob[]) ArrayUtils.addAll(jobs1, jobs2);
		assertTrue(iterateAndFindJobAlerts(jobs1And2), "The list of jobs ["+jobs1And2.toString()+"] cannot be found: filtering by "+ filterCriterion1 + "and " + filterCriterion2+  "is not working correctly.");
		//unselect criterion 1 and criterion 2
		scriptUtils.clickIfExists(filterCriterion1);
		scriptUtils.clickIfExists(filterCriterion2);

		//filter by criterion 3
		By filterCriteria3 = By.xpath(LumberJackXpathlocators.xpathLookup.get(xPathCriterion3));
		wait.until(ExpectedConditions.visibilityOfElementLocated(filterCriteria3));
		scriptUtils.clickIfExists(filterCriteria3);
		scriptUtils.clickIfExists(submitFilterButton);
		scriptUtils.sleep(500);

		assertFalse(iterateAndFindJobAlerts(jobs1And2), "The list of jobs ["+jobs1And2.toString()+"] should not be found: filtering by "+ xPathCriterion3 + " is not working correctly.");
	}

	private WebDriverWait loginLJ(String username, long timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		login.loginTP(username, "password");
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("New lead viewing and sorting features coming soon - click here to try it now!"))).click();
		switchToWindow();
		scriptUtils.sleep(500);
		return wait;
	}

	private void selectLJJobAlertSortCriteria(String htmlElementSortingSelected)
			throws InterruptedException {
		final String htmlClassNameElementForSorting = "sortation_select";
		final String htmlElementNameForSorting = "sortation";
		WebDriverWait waitforSorting = new WebDriverWait(driver, 10);
		By byvalueSorting = By.className(htmlClassNameElementForSorting);
		waitforSorting.until(ExpectedConditions.presenceOfElementLocated(byvalueSorting));

		Thread.sleep(500);

		Select sortingSelect = new Select(driver.findElement(By.name(htmlElementNameForSorting)));
		sortingSelect.selectByValue(htmlElementSortingSelected);
	}

	private void clickNextPaginationPage() throws InterruptedException{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LumberJackXpathlocators.xpathLookup.get("LJ_LEADS_LIST_NEXT_BUTTON")))).click();
		}catch(StaleElementReferenceException e){
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LumberJackXpathlocators.xpathLookup.get("LJ_LEADS_LIST_NEXT_BUTTON")))).click();
		}
	}

	private void deleteJob(String reasonId) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(context.driver, 10);
		// Delete Job Lead
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(LumberJackXpathlocators.xpathLookup.get("DELETE_JOB")))).click();
		//Confirmation window: select a reason
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(reasonId)));
		scriptUtils.clickIfExists(By.id(reasonId));
		By deleteConfirmButton = By.xpath(LumberJackXpathlocators.xpathLookup.get("DELETE_LEAD_CONFIRM_BUTTON"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(deleteConfirmButton));
		scriptUtils.sleep(2000);
		scriptUtils.clickIfExists(deleteConfirmButton);
	}

	/**
	 * This is an utility method and can be removed if we use a dataset with existing jobs.
	 * 
	 * Post chimney jobs if the total number of leads is less than minNumberOfLeads.
	 * 
	 * @param minNumberOfLeads the mininum number of leads in order to test the functionality
	 * @param postcode to be used when posting the chimney job
	 * @throws Exception
	 */
	private boolean postJobs(int minNumberOfLeads, String postcode) throws Exception{
		boolean jobsPosted = false;
		String leadNumberV2String = driver.findElement(By.xpath(LumberJackXpathlocators.xpathLookup.get("LEADS_AVAILABLE_NUMBER"))).getText();
		final int totalNumberOfLeads = Integer.valueOf(leadNumberV2String.replace(",", ""));
		if(totalNumberOfLeads<minNumberOfLeads){
			jobsPosted = true;
			Integer jobsToPost = minNumberOfLeads-totalNumberOfLeads;
			for(int i=0;i<jobsToPost;i++){
				new JobSubmitter().submitChimneyBuildingJob(postcode);
			}
		}
		if(jobsPosted){
			scriptUtils.goTo(context.driver.getCurrentUrl());
		}
		return jobsPosted;
	}

	private Integer getNumberLeadsAvailable() {
		WebDriverWait wait = new WebDriverWait(context.driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LumberJackXpathlocators.xpathLookup.get("LEADS_AVAILABLE_NUMBER"))));
		String leadNumberV2String = driver.findElement(By.xpath(LumberJackXpathlocators.xpathLookup.get("LEADS_AVAILABLE_NUMBER"))).getText();
		leadNumberV2String = leadNumberV2String.replace(",", "");
		Integer leadsAvailableAfterDelete = Integer.valueOf(leadNumberV2String);
		return leadsAvailableAfterDelete;
	}

	/**
	 * Iterates through the job alerts and checks if the jobs passed as argument 
	 * are amount them. Use pagination if necessary.
	 * @param jobs an array of jobs to be searched
	 * @return true if all the jobs passed as argument are found and false otherwise
	 * @throws InterruptedException
	 */
	private boolean iterateAndFindJobAlerts(APIJob[] jobs) throws InterruptedException {
		int posted_job_index = 0;
		int list_jobs_index = 0;
		if(getNumberLeadsAvailable()==0){
			return false;
		}
		
		
		String jobLeadURL = driver.findElement(By.xpath(LumberJackXpathlocators.xpathLookup.get("LJ_LEAD_URL_PREFIX") + ++list_jobs_index + LumberJackXpathlocators.xpathLookup.get("LJ_LEAD_URL_SUFFIX"))).getAttribute("href");
		while (posted_job_index < jobs.length && jobLeadURL != null) {
			if (jobLeadURL.endsWith(jobs[posted_job_index].getId())) {
				posted_job_index++;
			}
			try{
				jobLeadURL = driver.findElement(By.xpath(LumberJackXpathlocators.xpathLookup.get("LJ_LEAD_URL_PREFIX") + ++list_jobs_index + LumberJackXpathlocators.xpathLookup.get("LJ_LEAD_URL_SUFFIX"))).getAttribute("href");
			}catch(NoSuchElementException e){
				//time to use pagination: click on the next button
				clickNextPaginationPage();
				//reset job lead count on that page (list_jobs_index)
				list_jobs_index=0;
				jobLeadURL = driver.findElement(By.xpath(LumberJackXpathlocators.xpathLookup.get("LJ_LEAD_URL_PREFIX") + ++list_jobs_index + LumberJackXpathlocators.xpathLookup.get("LJ_LEAD_URL_SUFFIX"))).getAttribute("href");
			}catch(StaleElementReferenceException e){
				//Sometimes there is a timeout when going through the list. Just retry.
			}
		}
		return posted_job_index == jobs.length;
	}
}