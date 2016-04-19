package uk.co.ratedpeople.test.functional.selenium.tmmobile.functions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.util.List;

import javax.xml.xpath.XPathExpressionException;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.w3c.dom.Document;

import uk.co.ratedpeople.APIJob;
import uk.co.ratedpeople.BankAccountDetailsHelper;
import uk.co.ratedpeople.HttpResponseUtils;
import uk.co.ratedpeople.IntegrationTestUsers;
import uk.co.ratedpeople.JobImageSubmitter;
import uk.co.ratedpeople.JobPurchaseOrderSubmitter;
import uk.co.ratedpeople.JobSubmitter;
import uk.co.ratedpeople.NrpJobSubmitter;
import uk.co.ratedpeople.RestDomainXMLBeanUser;
import uk.co.ratedpeople.UserRetriever;
import uk.co.ratedpeople.XmlUtils;
import uk.co.ratedpeople.test.functional.selenium.tmmobile.membershipcampaigns.MembershipcompaignXpathlocators;

/**
 * 
 * @author craig.marcus
 * 
 */
public class TestFunctions {

	public static final String TP_INTEGRATION_TEST_TM_MOBILE_1 = "integration.test.tm.mobile1@ratedtrades.com";
	public static final String TP_INTEGRATION_TEST_TM_MOBILE_2 = "integration.test.tm.mobile2@ratedtrades.com";
	public static final String TP_INTEGRATION_TEST_TM_MOBILE_3 = "integration.test.tm.mobile3@ratedtrades.com";
	public static final String TP_INTEGRATION_TEST_TM_MOBILE_4 = "integration.test.tm.mobile4@ratedtrades.com";
	public static final String TP_INTEGRATION_TEST_TM_MOBILE_5 = "integration.test.tm.mobile5@ratedtrades.com";
	public static final String TP_INTEGRATION_TEST_TM_MOBILE_6 = "integration.test.tm.mobile6@ratedtrades.com";

	public static final String TP_INTEGRATION_TEST_TM_MOBILE_PASSWORD = "password";

	private WebDriver driver;
	private BankAccountDetailsHelper bankAccountDetailsHelper;
	private UserRetriever userRetriever;
	private JobSubmitter jobSubmitter;
	private NrpJobSubmitter nrpJobSubmitter;
	private JobImageSubmitter jobImageSubmitter;
	private JobPurchaseOrderSubmitter jobPurchaseOrderSubmitter;

	private HttpResponseUtils httpResponseUtils;
	private XmlUtils xmlUtils;

	private static String nrpHomeOwnerFirstName = "john";
	private static String nrpHomeOwnerLastName = "smith";
	private static String nrpHomeOwnerEmail = "john.smith" + Math.random() + "1@ratedtrades.com";
	private static String nrpHomeOwnerPostcode = "SW1E6DR";
	private static String nrpHomeOwnerTelephone = "02077485244";
	private static String nrpHomeOwnerMobile = "07824243421";
	private static String nrpHomeOwnerJobTypeId = "147";
	private static final String DESCRIPTION = "description";
	private static final String JOB_IMAGE_XML = "<jobimage>" + "<description>" + DESCRIPTION + "</description>" + "</jobimage>";

	public TestFunctions(WebDriver webDriver) {
		driver = webDriver;
		bankAccountDetailsHelper = new BankAccountDetailsHelper();
		userRetriever = new UserRetriever();
		jobSubmitter = new JobSubmitter();
		jobImageSubmitter = new JobImageSubmitter();
		jobPurchaseOrderSubmitter = new JobPurchaseOrderSubmitter();
		httpResponseUtils = new HttpResponseUtils();
		xmlUtils = new XmlUtils();
		nrpJobSubmitter = new NrpJobSubmitter();
	}

	// ---------- Images -----

	// required for initial release testing
	public Integer addHOImage(final String jobReference, final String homeOwnerUsername, final String homeOwnerPassword) throws Exception {

		// JobImageSubmitter postJobImage (with HO credentials)
		final int homeOwnerUserId = userRetriever.getUserId(homeOwnerUsername, homeOwnerPassword);
		final String uri = "/api/v1/homeowner/" + homeOwnerUserId + "/jobs/" + jobReference + "/images";
		final String imagePath = "src/main/resources/testdata/images/job/construction500x400.jpg";

		HttpResponse response = jobImageSubmitter.postJobImage(uri, JOB_IMAGE_XML, imagePath, homeOwnerUsername, homeOwnerPassword);
		assertEquals(response.getStatusLine().getStatusCode(), HttpStatus.SC_CREATED);

		Header locationHeader = response.getFirstHeader("Location");
		assertNotNull(locationHeader.getValue());
		assertTrue(locationHeader.getValue().indexOf(uri) != -1);

		return getImageId(locationHeader, uri);
	}

	// required for initial release testing
	public Integer addTMImage(final String jobReference, final String homeOwnerUsername, final String tradesmanUsername, final String tradesmanPassword)
			throws Exception {

		// JobImageSubmitter postJobImage (with TM credentials)
		final int tradesmanUserId = userRetriever.getUserId(tradesmanUsername, tradesmanPassword);

		// let the tradesman buy the job
		HttpResponse purchaseResponse = jobPurchaseOrderSubmitter.postPurchaseOrderWithoutCard(tradesmanUsername, tradesmanPassword, tradesmanUserId,
				jobReference);
		assertEquals(purchaseResponse.getStatusLine().getStatusCode(), HttpStatus.SC_CREATED);

		// now add the image
		final String uri = "/api/v1/tradesmen/" + tradesmanUserId + "/jobs/" + jobReference + "/images";
		final String imagePath = "src/main/resources/testdata/images/job/construction500x400.jpg";

		HttpResponse response = jobImageSubmitter.postJobImage(uri, JOB_IMAGE_XML, imagePath, tradesmanUsername, tradesmanPassword);
		assertEquals(response.getStatusLine().getStatusCode(), HttpStatus.SC_CREATED);

		Header locationHeader = response.getFirstHeader("Location");
		assertNotNull(locationHeader.getValue());
		assertTrue(locationHeader.getValue().indexOf(uri) != -1);

		return getImageId(locationHeader, uri);
	}

	// ---------- 3D SECURE -----

	public void enterPasswordIn3DSecureScreen(final String password) {

		System.out.println("you are being here");

		WebElement secureCodePagePasswordField = driver.findElement(By.cssSelector("input[type='password']"));
		secureCodePagePasswordField.clear();
		secureCodePagePasswordField.sendKeys(password);

		WebElement secureCodePageSubmitButton = driver.findElement(By.cssSelector("input[type='submit']"));
		secureCodePageSubmitButton.click();

	}

	// membership Campaign

	// ---------- 3D SECURE -----

	public void enterMCPasswordIn3DSecureScreen(final String password) {

		WebElement secureCodePagePasswordField = driver.findElement(By.xpath(".//*[@id='AutoNumber1']/tbody/tr[2]/td/form/table/tbody/tr[5]/td[2]/input"));
		secureCodePagePasswordField.clear();
		secureCodePagePasswordField.sendKeys(password);

		WebElement secureCodePageSubmitButton = driver.findElement(By.xpath(".//*[@id='AutoNumber1']/tbody/tr[2]/td/form/table/tbody/tr[6]/td[2]/input"));
		secureCodePageSubmitButton.click();

	}

	// ---------- SUBMITTING JOBS -----

	// required for initial release testing
	public String addGardeningRPAlert() throws Exception {
		// Same as posting a job
		APIJob jobSubmitted = jobSubmitter.submitGardeningJobForGivenUser("firstname", "lastName", IntegrationTestUsers.HOME_OWNER_1, "SW1E6AU");
		String jobReference = jobSubmitted.getId();
		System.out.println("Job submitted ref: " + jobReference);
		return jobReference;
	}

	// required for initial release testing
	public String addGardeningRPAlert(final String homeOwnerFirstname, final String homeOwnerSurname, final String homeOwnerUsername) throws Exception {
		// Same as posting a job
		APIJob jobSubmitted = jobSubmitter.submitGardeningJobForGivenUser(homeOwnerFirstname, homeOwnerSurname, homeOwnerUsername, "SW1E 6DR");
		String jobReference = jobSubmitted.getId();
		System.out.println("Job submitted ref: " + jobReference);
		return jobReference;
	}

	public String addGasBoilerRPAlert(final String homeOwnerFirstname, final String homeOwnerSurname, final String homeOwnerUsername) throws Exception {
		// Same as posting a job
		APIJob jobSubmitted = jobSubmitter.submitGasBoilerJobForGivenUser(homeOwnerFirstname, homeOwnerSurname, homeOwnerUsername, "SW1E 6DR");
		String jobReference = jobSubmitted.getId();
		System.out.println("Job submitted ref: " + jobReference);
		return jobReference;
	}

	// ---------- OTHERS -----

	// required for initial release testing
	public void expireGasSafeCertification() {
		// TODO
	}

	// required for initial release testing
	public String buyJobWithNewCardRestCall(final String jobReference, final String tradesmanUsername, final String tradesmanPassword) throws Exception {

		Integer userId = userRetriever.getUserId(tradesmanUsername, tradesmanPassword);

		String creditCardDetails = "<creditcard><cardnumber>4929 0000 0000 6</cardnumber><type>VISA</type><startdate><month>1</month><year>2010</year></startdate><expirydate><month>12</month><year>2030</year></expirydate><cv2>123</cv2><name>Test user</name><address>88 the Willows</address><postcode>ab41 2de</postcode></creditcard>";

		// buy a job
		HttpResponse purchaseResponse = jobPurchaseOrderSubmitter.postPurchaseOrderWithCard(tradesmanUsername, tradesmanPassword, userId, jobReference,
				creditCardDetails);

		assertEquals(purchaseResponse.getStatusLine().getStatusCode(), HttpStatus.SC_CREATED);

		return jobReference;
	}

	public void buyJobWithNewCardUI(final String cardHolderName, final String cardNumber, final String cardType, final String expiryMonth,
			final Integer expiryYear, final Integer cv2) {

		WebElement header = driver.findElement(By.id("header-h1"));
		assertEquals(header.getText().trim(), "Add New Card");

		WebElement cardHolderNameField = driver.findElement(By.id("CreditCard_name"));
		cardHolderNameField.clear();
		cardHolderNameField.sendKeys(cardHolderName);

		WebElement cardNumberField = driver.findElement(By.id("CreditCard_cardNumber"));
		cardNumberField.clear();
		cardNumberField.sendKeys(cardNumber);

		WebElement cardTypeDropDown = driver.findElement(By.id("CreditCard_type"));
		Select cardTypeSelect = new Select(cardTypeDropDown);
		cardTypeSelect.selectByVisibleText(cardType);

		WebElement cardExpiryMonthDropDown = driver.findElement(By.id("CreditCard_expiryDateMonth"));
		Select cardExpiryMonthSelect = new Select(cardExpiryMonthDropDown);
		cardExpiryMonthSelect.selectByVisibleText(expiryMonth);

		WebElement cardExpiryYearDropDown = driver.findElement(By.id("CreditCard_expiryDateYear"));
		Select cardExpiryYearSelect = new Select(cardExpiryYearDropDown);
		cardExpiryYearSelect.selectByVisibleText(expiryYear.toString());

		WebElement cardCv2Field = driver.findElement(By.id("CreditCard_cv2"));
		cardCv2Field.clear();
		cardCv2Field.sendKeys(cv2.toString());

		WebElement saveButton = driver.findElement(By.id("btn-buy-lead"));
		saveButton.click();

	}

	public void buyMembershipCampaignwithNewCard(final String cardHolderName, final String cardNumber, final String cardType, final String expiryMonth,
			final Integer expiryYear, final Integer cv2) {

		WebElement header = driver.findElement(By.id("page-h2"));
		assertEquals(header.getText().trim(), "Card details");
		System.out.println("you are reached this method");
		WebElement cardHolderNameField = driver.findElement(By.xpath(MembershipcompaignXpathlocators.xpathLookup.get("NAMEONTHE_CARD")));
		// driver.findElement(By.id("CreditCard_name"));
		cardHolderNameField.clear();
		cardHolderNameField.sendKeys(cardHolderName);

		WebElement cardNumberField = driver.findElement(By.id("CreditCard_cardNumber"));
		cardNumberField.clear();
		cardNumberField.sendKeys(cardNumber);

		WebElement cardTypeDropDown = driver.findElement(By.id("CreditCard_type"));
		Select cardTypeSelect = new Select(cardTypeDropDown);
		cardTypeSelect.selectByVisibleText(cardType);

		WebElement cardExpiryMonthDropDown = driver.findElement(By.id("CreditCard_expiryDateMonth"));
		Select cardExpiryMonthSelect = new Select(cardExpiryMonthDropDown);
		cardExpiryMonthSelect.selectByVisibleText(expiryMonth);

		WebElement cardExpiryYearDropDown = driver.findElement(By.id("CreditCard_expiryDateYear"));
		Select cardExpiryYearSelect = new Select(cardExpiryYearDropDown);
		cardExpiryYearSelect.selectByVisibleText(expiryYear.toString());

		WebElement cardCv2Field = driver.findElement(By.id("CreditCard_cv2"));
		cardCv2Field.clear();
		cardCv2Field.sendKeys(cv2.toString());

		WebElement updatecard = driver.findElement(By.id("addNewCardSubmit"));
		updatecard.click();
	}

	public void addCreditCardToAccount() {
		// Posting job and purchase it with a new card
	}

	public void clickOnFirstAvailableJob() throws InterruptedException {
		WebElement jobsWrapperDiv = driver.findElement(By.cssSelector("div.jobs-wrapper"));
		List<WebElement> jobList = jobsWrapperDiv.findElements(By.cssSelector("a.container.job"));
		// there should be at least 1 job since we have just bought one
		jobList.get(0).click();
		Thread.sleep(1000);
	}

	public void clickOnJob(String jobRef) throws InterruptedException {
		driver.findElement(By.cssSelector("a[data-job='" + jobRef + "']")).click();
		Thread.sleep(1000);
	}

	public void clickOnJobWithRef(String nrpJobRef) {
		driver.findElement(By.cssSelector("a.container[href^='/jobs/" + nrpJobRef + "']")).click();
	}

	public void createDefaultBankAccountDetailsWithoutVatNumber(final String tradesmanUsername, final String tradesmanPassword) throws Exception {
		Integer userId = userRetriever.getUserId(tradesmanUsername, tradesmanPassword);
		if (!bankAccountDetailsHelper.doesUserHaveBankAccountDetails(userId, tradesmanUsername, tradesmanPassword)) {
			bankAccountDetailsHelper.createDefaultBankAccountDetailsWithoutVatNumber(userId, tradesmanUsername, tradesmanPassword);
		}
	}

	public void createDefaultBankAccountDetailsWithVatNumber(final String tradesmanUsername, final String tradesmanPassword) throws Exception {
		Integer userId = userRetriever.getUserId(tradesmanUsername, tradesmanPassword);
		if (!bankAccountDetailsHelper.doesUserHaveBankAccountDetails(userId, tradesmanUsername, tradesmanPassword)) {
			bankAccountDetailsHelper.createDefaultBankAccountDetailsWithVatNumber(userId, tradesmanUsername, tradesmanPassword);
		}
	}

	public void deleteAllPurchasedJobs() {
		// there is no rest call to do this
		// use user oliviertm@ratedpeople.com in preprod as this user is not meant to have any job alerts as his postcode is on the island of Barra
	}

	public void deleteBankAccountDetailsIfPresent(final String tradesmanUsername, final String tradesmanPassword) throws Exception, XPathExpressionException {
		Integer userId = userRetriever.getUserId(tradesmanUsername, tradesmanPassword);
		HttpResponse fetchResponse = bankAccountDetailsHelper.getBankAccountDetails(userId, tradesmanUsername, tradesmanPassword);
		if (fetchResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {

			Document fetchResponseDocument = this.httpResponseUtils.documentFromResponseBody(fetchResponse);

			String text = xmlUtils.asString(fetchResponseDocument, "bankaccountdetailslist/bankaccountdetails[1]/id");
			if (text != null && !text.equalsIgnoreCase("")) {
				Integer bankAccountDetailsId = Integer.parseInt(text);

				bankAccountDetailsHelper.deleteBankAccountDetails(userId, bankAccountDetailsId, tradesmanUsername, tradesmanPassword);
			}
		}
	}

	public String homeOwnerSubmitsJobAndTradesmanBuysIt(final String tmUserName, final String tmPassword) throws Exception {
		// let a user submit a job
		APIJob jobSubmitted = jobSubmitter.submitChimneyBuildingJobForGivenUser("firstname", "lastName", IntegrationTestUsers.HOME_OWNER_1, "SW1E 6DR");
		String jobReference = jobSubmitted.getId();
		System.out.println("Job submitted ref: " + jobReference);

		Integer tmUserId = retrieveTradesmanUserId(tmUserName, tmPassword);

		// buy a job
		HttpResponse purchaseResponse = jobPurchaseOrderSubmitter.postPurchaseOrderWithoutCard(tmUserName, tmPassword, tmUserId, jobReference);

		assertEquals(purchaseResponse.getStatusLine().getStatusCode(), HttpStatus.SC_CREATED);

		return jobReference;
	}

	public void tradesmanBuysJob(String jobReference, String tmUsername, String tmPassword) throws Exception {

		HttpResponse purchaseResponse = jobPurchaseOrderSubmitter.postPurchaseOrderWithoutCard(tmUsername, tmPassword,
				retrieveTradesmanUserId(tmUsername, tmPassword), jobReference);

		assertEquals(purchaseResponse.getStatusLine().getStatusCode(), HttpStatus.SC_CREATED);

	}

	public HttpResponse postNrpJob(final String tmUserName, final String tmPassword) throws Exception {
		String xmlForNrpJob = nrpJobSubmitter.getXmlForPostingNrpJob(nrpHomeOwnerFirstName, nrpHomeOwnerLastName, nrpHomeOwnerEmail, nrpHomeOwnerTelephone,
				nrpHomeOwnerMobile, nrpHomeOwnerJobTypeId, nrpHomeOwnerPostcode);

		Integer tmUserId = retrieveTradesmanUserId(tmUserName, tmPassword);

		HttpResponse postResponse = nrpJobSubmitter.postNrpJobData(tmUserId, tmUserName, tmPassword, xmlForNrpJob);

		return postResponse;
	}

	public void makeCreditRequest() {
		// CreditRequestSubmitter postCreditRequestForJob
	}

	public void scrollToId(String cssId) throws InterruptedException {
		Point hoverItem = driver.findElement(By.id(cssId)).getLocation();
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0," + (hoverItem.getY()) + ");");
		// Thread.sleep(1500);
	}

	public void executeJavascriptOnPage(String script) throws InterruptedException {

		((JavascriptExecutor) driver).executeScript(script);
		Thread.sleep(1500);
	}

	/*
	 * We do not have rest called to do these. However, what I suggest is to create a new tradesman by making them sign up. They won't have any jobs or job
	 * alerts to start off with, particularly if we give them a rarely used postcode.
	 */
	// required for initial release testing
	public void removeAllAlertsForTradesman() {
		// there is no rest call to do this
		// use user oliviertm@ratedpeople.com in preprod as this user is not meant to have any job alerts as his postcode is on the island of Barra
	}

	public void removeAllJobsForTradesman() {
		// there is no rest call to do this
		// use user oliviertm@ratedpeople.com in preprod as this user is not meant to have any job alerts as his postcode is on the island of Barra
	}

	private Integer retrieveTradesmanUserId(String username, String password) throws Exception {

		RestDomainXMLBeanUser user = userRetriever.getUser(username, password);
		Integer tradesmanUserId = Integer.parseInt(user.getId());
		return tradesmanUserId;
	}

	private Integer getImageId(final Header locationHeader, final String uri) {

		String locationHeaderValue = locationHeader.getValue();
		String imageId = locationHeaderValue.substring(locationHeaderValue.indexOf(uri) + uri.length() + 1);
		return Integer.parseInt(imageId);
	}
}
