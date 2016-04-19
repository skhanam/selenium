package uk.co.ratedpeople.test.functional.selenium.tmmobile;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import uk.co.ratedpeople.test.functional.selenium.TestScript;
import uk.co.ratedpeople.test.functional.selenium.tmmobile.functions.TestFunctions;
import uk.co.ratedpeople.test.functional.selenium.tmmobile.functions.TestFunctionsGasSafePartP;
import uk.co.ratedpeople.test.functional.selenium.tmmobile.functions.TestFunctionsJBilling;

/**
 * @author craig.marcus
 */
public class PurchaseJobTest extends TestScript {

	private static final String HEADER_H1_ELEMENT_ID = "header-h1";
	private static final String MSG_USE_DIFFERENT_CARD_BUTTON_SHOULD_BE_PRESENT = "Use different card button should be present";
	private static final String LINK_BUY_JOB_ELEMENT_ID = "link-buy-job";
	private static final String MSG_USE_CARD_BUTTON_SHOULD_BE_PRESENT = "Use card button should be present";
	private static final String MSG_BUY_BUTTON_SHOULD_BE_PRESENT = "Buy button should be present";
	private static final String MSG_JOB_ALERT_SHOULD_BE_IN_LIST = "Job alert should be in list";
	private static final String MSG_JOB_REF_SHOULD_NOT_BE_NULL = "Job ref should not be null";
	private static final String USE_DIFFERENT_CARD_PARTIAL_LINK_TEXT = "Change card details";
	private static final String USE_CARD_ENDING_PARTIAL_LINK_TEXT = "Use card ending 00 6";
	private static final String CREDIT_CARD_TYPE = "Visa";
	private static final Integer CV2 = 123;
	private static final String CREDIT_CARD_EXPIRY_MONTH = "12";
	private static final Integer CREDIT_CARD_EXPIRY_YEAR = 2014;
	private static final String CREDIT_CARD_NUMBER = "4929 0000 0000 6";
	private static final String HOME_OWNER_EMAIL = "homeOwnerUsername@hotmail.co.uk";
	private static final String HOME_OWNER_SURNAME = "homeOwnerSurname";
	private static final String HOME_OWNER_FIRSTNAME = "homeOwnerFirstname";
	private static final BigDecimal ONE_HUNDRED_POUNDS_AMOUNT = new BigDecimal(100.0);
	private static final BigDecimal ONE_POUND_AMOUNT = new BigDecimal(1.0);
	private static final BigDecimal ZERO_AMOUNT = new BigDecimal(0.0);
	private static final String PASSWORD = TestFunctions.TP_INTEGRATION_TEST_TM_MOBILE_PASSWORD;
	private static final Map<String, Integer> USER_NAME_TO_JBILLING_ID = new HashMap<String, Integer>();

	private Login tmLogin;
	private WebDriver driver;
	private TestFunctions testFunctions;
	private TestFunctionsJBilling testFunctionsJBilling;
	private TestFunctionsGasSafePartP testFunctionsGasSafePartP;

	@BeforeMethod
	public void setUp() throws Exception {
		driver = context.driver;
		testFunctions = new TestFunctions(driver);
		testFunctionsJBilling = new TestFunctionsJBilling(driver);
		testFunctionsGasSafePartP = new TestFunctionsGasSafePartP(driver);
		tmLogin = new Login(context);

		// TODO: we should have a better way to the jBilling id
		USER_NAME_TO_JBILLING_ID.put(TestFunctions.TP_INTEGRATION_TEST_TM_MOBILE_1, 1125);
		USER_NAME_TO_JBILLING_ID.put(TestFunctions.TP_INTEGRATION_TEST_TM_MOBILE_2, 1128);
		USER_NAME_TO_JBILLING_ID.put(TestFunctions.TP_INTEGRATION_TEST_TM_MOBILE_3, 1129);
		USER_NAME_TO_JBILLING_ID.put(TestFunctions.TP_INTEGRATION_TEST_TM_MOBILE_4, 1140);
		USER_NAME_TO_JBILLING_ID.put(TestFunctions.TP_INTEGRATION_TEST_TM_MOBILE_5, 1141);
	}
	
	@Test(enabled = true)
	public void testPurchaseJobPaidFullyFromACBalance() throws Exception {

		final String username = TestFunctions.TP_INTEGRATION_TEST_TM_MOBILE_2;
		final Integer jBillingUserId = USER_NAME_TO_JBILLING_ID.get(username);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		testFunctionsJBilling.removeAllCardsForTradesman(context, jBillingUserId);

		// set the free balance to 100
		testFunctionsJBilling.setAccountBalance(context, jBillingUserId, ZERO_AMOUNT, ONE_HUNDRED_POUNDS_AMOUNT, ZERO_AMOUNT);
		
		// post a gas boiler job
		String jobRef = testFunctions.addGardeningRPAlert(HOME_OWNER_FIRSTNAME, HOME_OWNER_SURNAME, HOME_OWNER_EMAIL);
		assertNotNull(jobRef, MSG_JOB_REF_SHOULD_NOT_BE_NULL);

		// let this tradesman buy it
		tmLogin.login(username, PASSWORD);

		// find the job and click on it
		WebElement jobAlertForSubmittedJob = driver.findElement(By.cssSelector("a[href^='/job-alerts/" + jobRef + "']"));
		assertNotNull(jobAlertForSubmittedJob, MSG_JOB_ALERT_SHOULD_BE_IN_LIST);

		jobAlertForSubmittedJob.click();

		assertNotNull(wait.until(ExpectedConditions.presenceOfElementLocated(By.id(LINK_BUY_JOB_ELEMENT_ID))), MSG_BUY_BUTTON_SHOULD_BE_PRESENT);

		// buy the job
		WebElement buyButton = driver.findElement(By.id(LINK_BUY_JOB_ELEMENT_ID));
		assertNotNull(buyButton, MSG_BUY_BUTTON_SHOULD_BE_PRESENT);

		buyButton.click();

			// check that we are on the gas safe page
		WebElement acButton = driver.findElement(By.partialLinkText("Use account balance"));
		assertNotNull(buyButton, "Use account balance button should be present");
		acButton.click();
		Thread.sleep(5000);
		// Assert customer details page is loaded (i.e if buying from ac balance succeeds)
		assertNotNull(wait.until(ExpectedConditions.textToBePresentInElement(By.id(HEADER_H1_ELEMENT_ID), "Customer Details")), "Customer details page is displayed if successful");
	
	}

	@Test(enabled = true)
	public void testPurchaseJobPaidPartiallyFromACBalanceAndNewCard() throws Exception {

		final String username = TestFunctions.TP_INTEGRATION_TEST_TM_MOBILE_2;
		final String cardHolderName = username.substring(0, username.indexOf("@"));
		final Integer jBillingUserId = USER_NAME_TO_JBILLING_ID.get(username);
		WebDriverWait wait = new WebDriverWait(driver, 10);
			
		testFunctionsJBilling.removeAllCardsForTradesman(context, jBillingUserId);

		// set the free balance to 1
		testFunctionsJBilling.setAccountBalance(context, jBillingUserId, ZERO_AMOUNT, ONE_POUND_AMOUNT, ZERO_AMOUNT);

		// post a gas boiler job
		String jobRef = testFunctions.addGardeningRPAlert(HOME_OWNER_FIRSTNAME, HOME_OWNER_SURNAME, HOME_OWNER_EMAIL);
		assertNotNull(jobRef, MSG_JOB_REF_SHOULD_NOT_BE_NULL);

		// let this tradesman buy it
		tmLogin.login(username, PASSWORD);

		// find the job and click on it
		WebElement jobAlertForSubmittedJob = driver.findElement(By.cssSelector("a[href^='/job-alerts/" + jobRef + "']"));
		assertNotNull(jobAlertForSubmittedJob, MSG_JOB_ALERT_SHOULD_BE_IN_LIST);

		jobAlertForSubmittedJob.click();

		assertNotNull(wait.until(ExpectedConditions.presenceOfElementLocated(By.id(LINK_BUY_JOB_ELEMENT_ID))), MSG_BUY_BUTTON_SHOULD_BE_PRESENT);
		// buy the job
		WebElement buyButton = driver.findElement(By.id(LINK_BUY_JOB_ELEMENT_ID));
		assertNotNull(buyButton, MSG_BUY_BUTTON_SHOULD_BE_PRESENT);

		buyButton.click();

		WebElement useDifferentCardButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText(USE_DIFFERENT_CARD_PARTIAL_LINK_TEXT)));
		//assertNotNull(wait.until(ExpectedConditions.presenceOfElementLocated(By.id(LINK_BUY_JOB_ELEMENT_ID))), MSG_BUY_BUTTON_SHOULD_BE_PRESENT)
		assertNotNull(useDifferentCardButton, MSG_USE_DIFFERENT_CARD_BUTTON_SHOULD_BE_PRESENT);

		useDifferentCardButton.click();

		Thread.sleep(1000);

		testFunctions.buyJobWithNewCardUI(cardHolderName, CREDIT_CARD_NUMBER, CREDIT_CARD_TYPE, CREDIT_CARD_EXPIRY_MONTH, CREDIT_CARD_EXPIRY_YEAR, CV2);

		Thread.sleep(1000);

		testFunctions.enterPasswordIn3DSecureScreen(PASSWORD);

		// check that we are on the gas safe page
		WebElement header = driver.findElement(By.id(HEADER_H1_ELEMENT_ID));
		assertEquals(header.getText().trim(), "Customer Details");
	}

	@Test(enabled = true)
	public void testPurchaseJobPaidPartiallyFromACBalanceAndExistingCard() throws Exception {

		final String username = TestFunctions.TP_INTEGRATION_TEST_TM_MOBILE_3;
		final String cardHolderName = username.substring(0, username.indexOf("@"));
		final Integer jBillingUserId = USER_NAME_TO_JBILLING_ID.get(username);

		testFunctionsJBilling.addCardForTradesman(context, jBillingUserId, cardHolderName, CREDIT_CARD_NUMBER, CREDIT_CARD_EXPIRY_MONTH,
				CREDIT_CARD_EXPIRY_YEAR, CV2);

		// set the free balance to 1
		testFunctionsJBilling.setAccountBalance(context, jBillingUserId, ZERO_AMOUNT, ONE_POUND_AMOUNT, ZERO_AMOUNT);

		// post a gas boiler job
		String jobRef = testFunctions.addGardeningRPAlert(HOME_OWNER_FIRSTNAME, HOME_OWNER_SURNAME, HOME_OWNER_EMAIL);
		assertNotNull(jobRef, MSG_JOB_REF_SHOULD_NOT_BE_NULL);

		// let this tradesman buy it
		tmLogin.login(username, PASSWORD);

		// find the job and click on it
		WebElement jobAlertForSubmittedJob = driver.findElement(By.cssSelector("a[href^='/job-alerts/" + jobRef + "']"));
		assertNotNull(jobAlertForSubmittedJob, MSG_JOB_ALERT_SHOULD_BE_IN_LIST);

		jobAlertForSubmittedJob.click();

		Thread.sleep(5000);

		// buy the job
		WebElement buyButton = driver.findElement(By.id(LINK_BUY_JOB_ELEMENT_ID));
		assertNotNull(buyButton, MSG_BUY_BUTTON_SHOULD_BE_PRESENT);
		buyButton.click();

		Thread.sleep(5000);

		WebElement useCardButton = driver.findElement(By.partialLinkText(USE_CARD_ENDING_PARTIAL_LINK_TEXT));
		assertNotNull(useCardButton, MSG_USE_CARD_BUTTON_SHOULD_BE_PRESENT);

		useCardButton.click();

		Thread.sleep(5000);
		testFunctions.enterPasswordIn3DSecureScreen(PASSWORD);
		// check that we are on the gas safe page
		Thread.sleep(8000);
		WebElement header = driver.findElement(By.id(HEADER_H1_ELEMENT_ID));
		assertEquals(header.getText().trim(), "Customer Details");
	}

	@Test(enabled = true)
	public void testPurchaseJobPaidFullyUsingNewCard() throws Exception {

		final String username = TestFunctions.TP_INTEGRATION_TEST_TM_MOBILE_3;
		final String cardHolderName = username.substring(0, username.indexOf("@"));
		final Integer jBillingUserId = USER_NAME_TO_JBILLING_ID.get(username);

		testFunctionsJBilling.removeAllCardsForTradesman(context, jBillingUserId);

		// set the free balance to 0
		testFunctionsJBilling.setAccountBalance(context, jBillingUserId, ZERO_AMOUNT, ZERO_AMOUNT, ZERO_AMOUNT);

		// post a gas boiler job
		String jobRef = testFunctions.addGardeningRPAlert(HOME_OWNER_FIRSTNAME, HOME_OWNER_SURNAME, HOME_OWNER_EMAIL);
		assertNotNull(jobRef, MSG_JOB_REF_SHOULD_NOT_BE_NULL);

		// let this tradesman buy it
		tmLogin.login(username, PASSWORD);

		// find the job and click on it
		WebElement jobAlertForSubmittedJob = driver.findElement(By.cssSelector("a[href^='/job-alerts/" + jobRef + "']"));
		assertNotNull(jobAlertForSubmittedJob, MSG_JOB_ALERT_SHOULD_BE_IN_LIST);

		jobAlertForSubmittedJob.click();

		Thread.sleep(5000);

		// buy the job
		WebElement buyButton = driver.findElement(By.id(LINK_BUY_JOB_ELEMENT_ID));
		assertNotNull(buyButton, MSG_BUY_BUTTON_SHOULD_BE_PRESENT);

		buyButton.click();

		Thread.sleep(5000);

		WebElement useDifferentCardButton = driver.findElement(By.partialLinkText(USE_DIFFERENT_CARD_PARTIAL_LINK_TEXT));
		assertNotNull(useDifferentCardButton, MSG_USE_DIFFERENT_CARD_BUTTON_SHOULD_BE_PRESENT);

		useDifferentCardButton.click();

		Thread.sleep(1000);

		testFunctions.buyJobWithNewCardUI(cardHolderName, CREDIT_CARD_NUMBER, CREDIT_CARD_TYPE, CREDIT_CARD_EXPIRY_MONTH, CREDIT_CARD_EXPIRY_YEAR, CV2);

		Thread.sleep(1000);

		testFunctions.enterPasswordIn3DSecureScreen(PASSWORD);

		// check that we are on the gas safe page
		Thread.sleep(5000);
		WebElement header = driver.findElement(By.id(HEADER_H1_ELEMENT_ID));
		assertEquals(header.getText().trim(), "Customer Details");
	}

	@Test(enabled = true)
	public void testPurchaseJobPaidFullyUsingExistingCard() throws Exception {
		WebDriverWait wait = new WebDriverWait(context.driver, 50);
		final String username = TestFunctions.TP_INTEGRATION_TEST_TM_MOBILE_3;
		final String cardHolderName = username.substring(0, username.indexOf("@"));
		final Integer jBillingUserId = USER_NAME_TO_JBILLING_ID.get(username);

		testFunctionsJBilling.addCardForTradesman(context, jBillingUserId, cardHolderName, CREDIT_CARD_NUMBER, CREDIT_CARD_EXPIRY_MONTH,
				CREDIT_CARD_EXPIRY_YEAR, CV2);

		// set the free balance to 0
		testFunctionsJBilling.setAccountBalance(context, jBillingUserId, ZERO_AMOUNT, ZERO_AMOUNT, ZERO_AMOUNT);

		// post a gas boiler job
		String jobRef = testFunctions.addGardeningRPAlert(HOME_OWNER_FIRSTNAME, HOME_OWNER_SURNAME, HOME_OWNER_EMAIL);
		assertNotNull(jobRef, MSG_JOB_REF_SHOULD_NOT_BE_NULL);

		// let this tradesman buy it
		tmLogin.login(username, PASSWORD);

		// find the job and click on it
		WebElement jobAlertForSubmittedJob = driver.findElement(By.cssSelector("a[href^='/job-alerts/" + jobRef + "']"));
		assertNotNull(jobAlertForSubmittedJob, MSG_JOB_ALERT_SHOULD_BE_IN_LIST);

		jobAlertForSubmittedJob.click();

		Thread.sleep(5000);

		// buy the job
		WebElement buyButton = driver.findElement(By.id(LINK_BUY_JOB_ELEMENT_ID));
		assertNotNull(buyButton, MSG_BUY_BUTTON_SHOULD_BE_PRESENT);

		buyButton.click();

		Thread.sleep(5000);

		WebElement useCardButton = driver.findElement(By.partialLinkText(USE_CARD_ENDING_PARTIAL_LINK_TEXT));
		assertNotNull(useCardButton, MSG_USE_CARD_BUTTON_SHOULD_BE_PRESENT);

		useCardButton.click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(HEADER_H1_ELEMENT_ID))).getText();
		
/*		Thread.sleep(3000);
		// check that we are on the gas safe page
		WebElement header = driver.findElement(By.id(HEADER_H1_ELEMENT_ID));
		assertEquals(header.getText().trim(), "Customer Details");
*/	}

	@Test(enabled = true)
	public void testPurchaseJobRequiringGasSafeCertificationNoCertPaidFullyFromACBalance() throws Exception {

		final String username = TestFunctions.TP_INTEGRATION_TEST_TM_MOBILE_3;

		final String validCertName = "Watertight";
		final String validCertNumber = "215772";

		// delete all gas certifications
		List<Integer> listGasCerts = testFunctionsGasSafePartP.getListOfGasSafeCertificateIds(username, PASSWORD);
		for (int i = 0; i < listGasCerts.size(); i++) {
			Integer certificationId = listGasCerts.get(i);
			testFunctionsGasSafePartP.deleteGasSafeCertificationById(certificationId, username, PASSWORD);
		}

		// set the free balance to 100
		final Integer jBillingUserId = 1129;
		testFunctionsJBilling.setAccountBalance(context, jBillingUserId, ZERO_AMOUNT, ONE_HUNDRED_POUNDS_AMOUNT, ZERO_AMOUNT);

		// post a gas boiler job
		String jobRef = testFunctions.addGasBoilerRPAlert(HOME_OWNER_FIRSTNAME, HOME_OWNER_SURNAME, HOME_OWNER_EMAIL);
		assertNotNull(jobRef, MSG_JOB_REF_SHOULD_NOT_BE_NULL);

		// let this tradesman buy it; should be prompted for gas safe details as s/he does not have any gas safe certs any more
		tmLogin.login(username, PASSWORD);

		// find the job and click on it
		WebElement jobAlertForSubmittedJob = driver.findElement(By.cssSelector("a[href^='/job-alerts/" + jobRef + "']"));
		assertNotNull(jobAlertForSubmittedJob, MSG_JOB_ALERT_SHOULD_BE_IN_LIST);

		jobAlertForSubmittedJob.click();

		Thread.sleep(1000);

		// buy the job
		driver.findElement(By.id(LINK_BUY_JOB_ELEMENT_ID)).click();

		// click on prompt for certificate
		WebElement addCertificateButton = driver.findElement(By.cssSelector("a[href^='/jobs/" + jobRef + "/certificates/gas/new']"));
		assertNotNull(addCertificateButton, "Add certificate button should not be null");

		addCertificateButton.click();

		Thread.sleep(1000);

		// add certificate with expiry of 01/12/2015
		// the certificate details are supposed to be valid
		WebElement header = driver.findElement(By.id(HEADER_H1_ELEMENT_ID));
		assertEquals(header.getText().trim(), "Gas Safe");
		WebElement certificateNameField = driver.findElement(By.id("Certificate_name"));
		certificateNameField.clear();
		certificateNameField.sendKeys(validCertName);
		WebElement certificateNumberField = driver.findElement(By.id("Certificate_number"));
		certificateNumberField.clear();
		certificateNumberField.sendKeys(validCertNumber);
		WebElement certificateDropDownExpiryDay = driver.findElement(By.id("Certificate_expiryDateDay"));
		Select certificateSelectExpiryDay = new Select(certificateDropDownExpiryDay);
		certificateSelectExpiryDay.selectByVisibleText("16");
		WebElement certificateDropDownExpiryMonth = driver.findElement(By.id("Certificate_expiryDateMonth"));
		Select certificateSelectExpiryMonth = new Select(certificateDropDownExpiryMonth);
		certificateSelectExpiryMonth.selectByVisibleText("06");
		WebElement certificateDropDownExpiryYear = driver.findElement(By.id("Certificate_expiryDateYear"));
		Select certificateSelectExpiryYear = new Select(certificateDropDownExpiryYear);
		certificateSelectExpiryYear.selectByVisibleText("2015");
		WebElement saveButton = driver.findElement(By.id("btn-save"));
		saveButton.click();

		Thread.sleep(1000);

		// check that we are on the gas safe page
		header = driver.findElement(By.id(HEADER_H1_ELEMENT_ID));
		assertEquals(header.getText().trim(), "Gas Safe Certificate");
	}

	@Test(enabled = false)
	public void testPurchaseJobRequiringGasSafeCertificationWithCertPaidFullyFromACBalance() {

	}

	@Test(enabled = false)
	public void testPurchaseJobRequiringGasSafeCertificationCertExpiredPaidFullyFromACBalance() {

	}

	/*
	 * a) if current balance can pay for the job, this will be used. b) if not, show exiting card(s) + add new card option.
	 * src/RP/Mobile/MobileBundle/Controller/ApiController.php line 146 we will need a helper class to force this scenario. - helper required. ensure that scrum
	 * baclog reflects this
	 * 
	 * 
	 * 
	 * public void createNewJobForTradesman() throws InterruptedException {
	 * 
	 * System.out.println("Entering createNewJobForTradesman()");
	 * 
	 * try{ //submit a job - Ensure that functional.test.host=pirp2.ratedpeople.com Job jobSubmitted =
	 * jobSubmitter.submitMetalWorkerJobForExistingUser("SW1E 6DR"); jobReference = jobSubmitted.getId(); } catch(Exception e){
	 * fail("Unable to submit new job"); }
	 * 
	 * if(attemptLoginFlag == true){ tmLogin.login(); attemptLoginFlag = false; } else{ //click to job alerts driver.findElement(By.id("nav-toggle")).click();
	 * driver.findElement(By.id("nav-job-alerts")).click(); Thread.sleep(1000); }
	 * 
	 * //Job Alerts *********************** //check that we are in job alerts assertEquals(driver.findElement(By.id("header-title")).getText(),"Job Alerts");
	 * 
	 * //check that the new job is present WebElement jobWrapper = driver.findElement(By.cssSelector("a.job[data-job='"+jobReference+"']"));
	 * assertNotNull(jobWrapper); String jobSkillType = driver.findElement(By.cssSelector("a.job[data-job='"+jobReference+"'] h2")).getText();
	 * jobWrapper.click();
	 * 
	 * //Single Job View *********************** assertEquals(driver.findElement(By.id("header-inner-title")).getText(),"Account Balance");
	 * assertEquals(driver.findElement(By.id("job-skill")).getText(),jobSkillType); //check 1st to buy
	 * assertEquals(driver.findElement(By.id("job-purchase-count")).getText(),"1st to Buy");
	 * 
	 * System.out.println("Leaving createNewJobForTradesman()"); }
	 * 
	 * public void checkJobIsPurchased() throws InterruptedException {
	 * 
	 * System.out.println("Entering checkJobIsPurchased()");
	 * 
	 * Thread.sleep(5000); //the job ref is confirmed at the top of the page assertEquals(driver.findElement(By.id("header-title")).getText(),"#"+jobReference);
	 * //confirm presence of homeowner phone and email assertNotNull(driver.findElement(By.id("link-job-tel")));
	 * assertNotNull(driver.findElement(By.id("link-job-email")));
	 * 
	 * //confirm presence of both post purchase buttons assertNotNull(driver.findElement(By.id("link-job-create-invoice"))); //for
	 * assertNotNull(driver.findElement(By.partialLinkText("Request a Rating")));
	 * 
	 * /*check create an invoice page is available. This will be tested in its own class driver.findElement(By.partialLinkText("Create an Invoice")).click();
	 * assertEquals(driver.findElement(By.cssSelector("h1.page-title")).getText(),"Create an invoice"); driver.findElement(By.linkText("Cancel")).click();
	 * 
	 * //check request a rating page is available. This will be tested in its own class driver.findElement(By.linkText("Request a Rating")).click();
	 * assertEquals(driver.findElement(By.cssSelector("h1.page-title")).getText(),"Request a Rating"); driver.findElement(By.linkText("Cancel")).click();
	 * 
	 * 
	 * System.out.println("Leaving checkJobIsPurchased()"); }
	 * 
	 * 
	 * @Test public void testBuyJobWithExistingCard() throws InterruptedException {
	 * 
	 * createNewJobForTradesman();
	 * 
	 * driver.findElement(By.linkText("Buy")).click(); Thread.sleep(2000); //Buy using existing card
	 * driver.findElement(By.partialLinkText("Use card ending")).click();
	 * 
	 * checkJobIsPurchased(); }
	 * 
	 * /* Buy job with different card Take single set of details from test data. These can be used repeatedly. Only one card will remain active for TM. Old card
	 * will be discarded automatically
	 * 
	 * @Test public void testBuyJobWithDifferentCard() throws InterruptedException {
	 * 
	 * createNewJobForTradesman();
	 * 
	 * driver.findElement(By.linkText("Buy")).click(); Thread.sleep(2000); //wait for ajax load //Buy using existing card
	 * driver.findElement(By.linkText("Use different card")).click(); Thread.sleep(2000);
	 * assertEquals(driver.findElement(By.cssSelector("h1.page-title.title-lowered")).getText(),"Add New Card");
	 * 
	 * //fill in new details driver.findElement(By.id("CreditCard_name")).clear();
	 * driver.findElement(By.id("CreditCard_name")).sendKeys("First Name Last Name"); //take the 1st option Select cardTypeSelect = new
	 * Select(driver.findElement(By.id("CreditCard_type"))); assertEquals(cardTypeSelect.getOptions().get(2).getText(),"Mastercard");
	 * cardTypeSelect.selectByIndex(2); //card - Using Mastercard driver.findElement(By.id("CreditCard_cardNumber")).clear();
	 * driver.findElement(By.id("CreditCard_cardNumber")).sendKeys("5404000000000001"); //end date month Select cardMonthEnd = new
	 * Select(driver.findElement(By.id("CreditCard_expiryDateMonth"))); cardMonthEnd.selectByIndex(1); //end date year Select cardYearEnd = new
	 * Select(driver.findElement(By.id("CreditCard_expiryDateYear"))); cardYearEnd.selectByIndex(2); //cv2 driver.findElement(By.id("CreditCard_cv2")).clear();
	 * driver.findElement(By.id("CreditCard_cv2")).sendKeys("123"); //buy lead driver.findElement(By.cssSelector("button.primary-btn")).click(); //page
	 * redirects to 3d secure Thread.sleep(3000); assertEquals(driver.findElement(By.cssSelector("head title")).getText(),"3D-Authentication Simulator");
	 * driver.findElement(By.cssSelector("input[type=password]")).clear(); driver.findElement(By.cssSelector("input[type=password]")).sendKeys("password");
	 * driver.findElement(By.cssSelector("input[type=submit]")).click();
	 * 
	 * checkJobIsPurchased(); }
	 * 
	 * private String homeOwnerSubmitsJobAndTradesmanBuysIt(final Integer tradesmanUserId) throws Exception { // let a user submit a job Job jobSubmitted =
	 * jobSubmitter.submitChimneyBuildingJobForGivenUserNotWaitForQualify("firstname", "lastName", TRADESMAN, TRADESMAN_PASSWORD,"SW1E 6DR"); String
	 * jobReference = jobSubmitted.getId(); // buy a job jobPurchaseOrderSubmitter.postPurchaseOrderWithoutCard(TRADESMAN, TRADESMAN_PASSWORD, tradesmanUserId,
	 * jobReference);
	 * 
	 * return jobReference; }
	 */

}