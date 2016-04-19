package uk.co.ratedpeople.test.functional.selenium.tmmobile.functions;

/**
 * @author danthalapalli.aravind
 */
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import uk.co.ratedpeople.test.functional.SeleniumTestContext;
import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;
import uk.co.ratedpeople.test.functional.selenium.newjobforms.common.JobFormSeleniumHelper;


public class TestForTimeIntentAndFirstSecondThirdBuy {

	
	private static final String IPD_TRADE_CODE = "bathroom";
	private static final String IPD_SKILL_TYPE_ID = "18";

	public static Logger logger = Logger.getLogger(TestForTimeIntentAndFirstSecondThirdBuy.class.getName());
	private WebDriver driver;
	private String testUrl;
	private TestScriptUtilities scriptUtils;
	private WebDriverWait wait;
	private SeleniumTestContext context;

	private boolean threeDSecurePageTimedOut = false;
	public static final int TIMEOUT_IN_SECONDS_INDUCTION_WELCOME = 60;
	public static final String THREE_D_SECURE_TIMEOUT_SELENIUM_ERROR_MSG_START = "Timed out after 30 seconds waiting for visibility of element located by By.xpath: .//*[@id='AutoNumber1']";
	public static final String INDUCTION_PAGE_TIMEOUT_BECAUSE_OF_THREE_D_SECURE_SELENIUM_ERROR_MSG_START = "Timed out after "
			+ TIMEOUT_IN_SECONDS_INDUCTION_WELCOME
			+ " seconds waiting for visibility of element located by By.xpath: .//*[@id='neutral-main-column']/section/h1";


	
	public TestForTimeIntentAndFirstSecondThirdBuy(SeleniumTestContext context, TestScriptUtilities scriptUtilities) {	
		this.scriptUtils = scriptUtilities;
		this.driver = context.driver;
		this.testUrl = context.getTestUrl();
		this.testUrl = testUrl.replaceAll("http://", "https://");
		this.wait = new WebDriverWait(driver, 30); // 30 seconds
		this.context = context;
	}

	public void getQuotes() throws InterruptedException {
		scriptUtils.getQuotes(testUrl, driver, IPD_SKILL_TYPE_ID, IPD_TRADE_CODE);
	}
	
	public void postingJobViaBathroomFirstCriticalScenario() throws Exception {
		getQuotes();
		jobDetailsPage("radioInstall");
		replacePathFirstPage();
		additionalInfoPage(5, TimeIntentAndFirstSecondThirdBuyXpathLocators.dataLookup.get("postcode"));
		thirdPage("Under £8,000");
		fourthPage();
	}
	
	public void jobDetailsPage(String pathone) throws Exception {
		scriptUtils.click(By.xpath(TimeIntentAndFirstSecondThirdBuyXpathLocators.xpathLookup.get(pathone)));
		// Wait for continue to be enabled
		WebDriverWait waitforcontinue = new WebDriverWait(driver, 10);
		waitforcontinue.until(ExpectedConditions.elementToBeClickable(By.xpath(TimeIntentAndFirstSecondThirdBuyXpathLocators.xpathLookup.get("continuestage1"))));
		scriptUtils.click(By.xpath(TimeIntentAndFirstSecondThirdBuyXpathLocators.xpathLookup.get("continuestage1")));
	}
	
	public void replacePathFirstPage() throws Exception {
		scriptUtils.clickPlusIcon(TimeIntentAndFirstSecondThirdBuyXpathLocators.xpathLookup.get("installed"), "Basin", 2);
//		scriptUtils.clickXpath(TimeIntentAndFirstSecondThirdBuyXpathLocators.xpathLookup.get("INSTALLATION"));
		scriptUtils.checkAndSelectRadioByOption(TimeIntentAndFirstSecondThirdBuyXpathLocators.xpathLookup.get("installation"), "Flooring - tiled");

		scriptUtils.checkAndSelectRadioByOption(TimeIntentAndFirstSecondThirdBuyXpathLocators.xpathLookup.get("supplying"), "Bathroom suite");

		scriptUtils.click(By.xpath(TimeIntentAndFirstSecondThirdBuyXpathLocators.xpathLookup.get("stageonereplacenext")));
	}
	public void additionalInfoPage(int lengthstring, String postcode) throws Exception {

		scriptUtils.checkAndSelectRadioByOption(TimeIntentAndFirstSecondThirdBuyXpathLocators.xpathLookup.get("ownership"), "I am the landlord");
		scriptUtils.checkAndSelectRadioByOption(TimeIntentAndFirstSecondThirdBuyXpathLocators.xpathLookup.get("intent"), "I'm ready to hire");

		scriptUtils.checkAndSelectDropDownByOption(TimeIntentAndFirstSecondThirdBuyXpathLocators.xpathLookup.get("timing"), "Within 2 weeks");

		scriptUtils.fillInXpathField(TimeIntentAndFirstSecondThirdBuyXpathLocators.xpathLookup.get("textareaadditionalinfo"), "This is the First job");

		scriptUtils.fillInTextField("postcode", postcode);

		scriptUtils.click(By.xpath(TimeIntentAndFirstSecondThirdBuyXpathLocators.xpathLookup.get("stagetwonext")));

	}
	
	public void additionalInfoPage2(int lengthstring, String postcode) throws Exception {

		scriptUtils.checkAndSelectRadioByOption(TimeIntentAndFirstSecondThirdBuyXpathLocators.xpathLookup.get("ownership"), "I am the landlord");
		scriptUtils.checkAndSelectRadioByOption(TimeIntentAndFirstSecondThirdBuyXpathLocators.xpathLookup.get("intent"), "I'm ready to hire");

		scriptUtils.checkAndSelectDropDownByOption(TimeIntentAndFirstSecondThirdBuyXpathLocators.xpathLookup.get("timing"), "Within 2 weeks");

		scriptUtils.fillInXpathField(TimeIntentAndFirstSecondThirdBuyXpathLocators.xpathLookup.get("textareaadditionalinfo"), "This is the Second job");

		scriptUtils.fillInTextField("postcode", postcode);

		scriptUtils.click(By.xpath(TimeIntentAndFirstSecondThirdBuyXpathLocators.xpathLookup.get("stagetwonext")));

	}
	public void additionalInfoPage3(int lengthstring, String postcode) throws Exception {

		scriptUtils.checkAndSelectRadioByOption(TimeIntentAndFirstSecondThirdBuyXpathLocators.xpathLookup.get("ownership"), "I am the landlord");
		scriptUtils.checkAndSelectRadioByOption(TimeIntentAndFirstSecondThirdBuyXpathLocators.xpathLookup.get("intent"), "I'm ready to hire");

		scriptUtils.checkAndSelectDropDownByOption(TimeIntentAndFirstSecondThirdBuyXpathLocators.xpathLookup.get("timing"), "Within 2 weeks");

		scriptUtils.fillInXpathField(TimeIntentAndFirstSecondThirdBuyXpathLocators.xpathLookup.get("textareaadditionalinfo"), "This is the Third job");

		scriptUtils.fillInTextField("postcode", postcode);

		scriptUtils.click(By.xpath(TimeIntentAndFirstSecondThirdBuyXpathLocators.xpathLookup.get("stagetwonext")));

	}
	public void thirdPage(String budget) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 3000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(TimeIntentAndFirstSecondThirdBuyXpathLocators.xpathLookup.get("budget"))));
		scriptUtils.checkAndSelectDropDownByOption(TimeIntentAndFirstSecondThirdBuyXpathLocators.xpathLookup.get("budget"), budget);
		scriptUtils.click(By.xpath(TimeIntentAndFirstSecondThirdBuyXpathLocators.xpathLookup.get("stagethreenext")));
	}
	
	public void fourthPage() throws Exception {
		String firstName = TimeIntentAndFirstSecondThirdBuyXpathLocators.dataLookup.get("fname");
		String lastName = TimeIntentAndFirstSecondThirdBuyXpathLocators.dataLookup.get("lname");
		String email = TestScriptUtilities.getRandomString(3) + "@ratedtrades.com";
		String mobile = TimeIntentAndFirstSecondThirdBuyXpathLocators.dataLookup.get("mobile");
		
		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtils, context, firstName, lastName, mobile, mobile, email, email);
		
		String getheaderText = driver.findElement(By.xpath(TimeIntentAndFirstSecondThirdBuyXpathLocators.xpathLookup.get("headerthanku"))).getText();
		logger.info("Header Text is : " + getheaderText);
		assertEquals(getheaderText, TimeIntentAndFirstSecondThirdBuyXpathLocators.dataLookup.get("headertxt"));
		assertEquals(driver.findElement(By.xpath(TimeIntentAndFirstSecondThirdBuyXpathLocators.xpathLookup.get("TEXTUNDERTHANKYOU_XPATH"))).getText(), TimeIntentAndFirstSecondThirdBuyXpathLocators.dataLookup.get("TEXTUNDERTHANKYOU_TEXT"));
		assertEquals(driver.findElement(By.xpath(TimeIntentAndFirstSecondThirdBuyXpathLocators.xpathLookup.get("WHATHAPPENSNEXTONE_XPATH"))).getText(), TimeIntentAndFirstSecondThirdBuyXpathLocators.dataLookup.get("WHATHAPPENSNEXTONE_TEXT"));
		assertEquals(driver.findElement(By.xpath(TimeIntentAndFirstSecondThirdBuyXpathLocators.xpathLookup.get("WHATHAPPENSNEXTTWO_XPATH"))).getText(), TimeIntentAndFirstSecondThirdBuyXpathLocators.dataLookup.get("WHATHAPPENSNEXTTWO_TEXT"));
		assertEquals(driver.findElement(By.xpath(TimeIntentAndFirstSecondThirdBuyXpathLocators.xpathLookup.get("WHATHAPPENSNEXTTHREE_XPATH"))).getText(), TimeIntentAndFirstSecondThirdBuyXpathLocators.dataLookup.get("WHATHAPPENSNEXTTHREE_TEXT"));
		String getheaderText1 = driver.findElement(By.xpath(TimeIntentAndFirstSecondThirdBuyXpathLocators.xpathLookup.get("RECOMMEND_SERVICES"))).getText();
		logger.info("Header Text is : " + getheaderText1);
		assertEquals(getheaderText1, TimeIntentAndFirstSecondThirdBuyXpathLocators.dataLookup.get("RECOMMEND_SERVICESTEXT"));

		driver.findElement(By.xpath(TimeIntentAndFirstSecondThirdBuyXpathLocators.xpathLookup.get("CLICKON_FACEBOOKICON"))).click();

		String opensfacebook = driver.getWindowHandle();

		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}

		Thread.sleep(2000);

		driver.close();

		driver.switchTo().window(opensfacebook);

	}
	
	public void signUp(final String uniqueEmailAccountName, final String rollOnType, final String tariff, final String screeningType) throws Exception {
		System.out.println(rollOnType + " " + tariff + " " + screeningType);
		System.out.println("Target environment: " + this.testUrl);
		testLandingPage(tariff);
		testSelectTradesPage();
		testSelectWorkareaPage();
		testBusinessDetailsPage(uniqueEmailAccountName, tariff);
		testSelectScreeningPage(uniqueEmailAccountName, screeningType);
		testScreeningDetailsPage(uniqueEmailAccountName, screeningType);
		testSelectPlanPage(uniqueEmailAccountName, screeningType, rollOnType);
		testCreateTMbillingDetailsPPage();
		try {
			if (!"418486a9e548".equals(tariff)) {
				testSagepayPage();
			}

			testInductionwelcomePage();
		} catch (Exception e) {
			// if the 3D-secure page timed out, return and show success as it is a false positive
			logger.log(Level.INFO, "3D-Secure page may have timed out.", e);
			String exMessage = e.getMessage();
			if (exMessage != null) {
				if (exMessage.startsWith(THREE_D_SECURE_TIMEOUT_SELENIUM_ERROR_MSG_START)) {
					threeDSecurePageTimedOut = true;
				} else if (exMessage.startsWith(INDUCTION_PAGE_TIMEOUT_BECAUSE_OF_THREE_D_SECURE_SELENIUM_ERROR_MSG_START)) {
					threeDSecurePageTimedOut = true;
				} else {
					throw e;
				}
			} else {
				throw e;
			}
		}
		testInductionwelcomePage();
	}

	public void testLandingPage(final String tariff) {
		// System.out.println(uniqueEmailAccountName);
		// System.out.println(tariff);
		// append tariff later to url
		scriptUtils.goTo(testUrl + "/new-signup/e/enter-postcode/" + tariff);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(TimeIntentAndFirstSecondThirdBuyXpathLocators.xpathLookup.get("POSTCODE"))));
		scriptUtils.click(By.xpath(TimeIntentAndFirstSecondThirdBuyXpathLocators.xpathLookup.get("VIEW_JOB_LEADS_BTN")));
		scriptUtils.fillInTextField(TimeIntentAndFirstSecondThirdBuyXpathLocators.xpathLookup.get("POSTCODE"), TimeIntentAndFirstSecondThirdBuyXpathLocators.dataLookup.get("postcode"));
		scriptUtils.click(By.xpath(TimeIntentAndFirstSecondThirdBuyXpathLocators.xpathLookup.get("VIEW_JOB_LEADS_BTN")));
	}

	public void testSelectTradesPage() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(TimeIntentAndFirstSecondThirdBuyXpathLocators.xpathLookup.get("VIEW_JOB_LEADS_FOR_YOUR_TRADE_BTN"))));
		scriptUtils.click(By.xpath(TimeIntentAndFirstSecondThirdBuyXpathLocators.xpathLookup.get("VIEW_JOB_LEADS_FOR_YOUR_TRADE_BTN")));
		scriptUtils.click(By.xpath(TimeIntentAndFirstSecondThirdBuyXpathLocators.xpathLookup.get("AERIAL_TRADE")));
		scriptUtils.click(By.xpath(TimeIntentAndFirstSecondThirdBuyXpathLocators.xpathLookup.get("BATHROOM_TRADE")));
		scriptUtils.click(By.xpath(TimeIntentAndFirstSecondThirdBuyXpathLocators.xpathLookup.get("CLEANER_TRADE")));
		scriptUtils.click(By.xpath(TimeIntentAndFirstSecondThirdBuyXpathLocators.xpathLookup.get("HANDYMAN_TRADE")));
		scriptUtils.click(By.xpath(TimeIntentAndFirstSecondThirdBuyXpathLocators.xpathLookup.get("ROOFER_TRADE")));
		scriptUtils.click(By.xpath(TimeIntentAndFirstSecondThirdBuyXpathLocators.xpathLookup.get("WINDOW_TRADE")));
		scriptUtils.click(By.xpath(TimeIntentAndFirstSecondThirdBuyXpathLocators.xpathLookup.get("VIEW_JOB_LEADS_FOR_YOUR_TRADE_BTN")));
	}

	public void testSelectWorkareaPage() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(TimeIntentAndFirstSecondThirdBuyXpathLocators.xpathLookup.get("CONFIRM_WORK_AREA_BTN"))));
		scriptUtils.click(By.xpath(TimeIntentAndFirstSecondThirdBuyXpathLocators.xpathLookup.get("MILES")));
		scriptUtils.click(By.xpath(TimeIntentAndFirstSecondThirdBuyXpathLocators.xpathLookup.get("CONFIRM_WORK_AREA_BTN")));
	}

	public static char randomSeriesForThreeCharacter() {
		Random word = new Random();
		char random_3_Char = (char) (97 + word.nextInt(25));
		return random_3_Char;
		}
	
	public void testBusinessDetailsPage(String uniqueEmailAccountName, final String tariff) throws InterruptedException {

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(TimeIntentAndFirstSecondThirdBuyXpathLocators.xpathLookup.get("FINDADDRESS_BTN"))));
		scriptUtils.click(By.xpath(TimeIntentAndFirstSecondThirdBuyXpathLocators.xpathLookup.get("FINDADDRESS_BTN")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(TimeIntentAndFirstSecondThirdBuyXpathLocators.xpathLookup.get("ADDRESS_OPTION"))));
		scriptUtils.click(By.xpath(TimeIntentAndFirstSecondThirdBuyXpathLocators.xpathLookup.get("ADDRESS_OPTION")));
		scriptUtils.click(By.xpath(TimeIntentAndFirstSecondThirdBuyXpathLocators.xpathLookup.get("NEXT_PAGE")));
		scriptUtils.fillInTextField(TimeIntentAndFirstSecondThirdBuyXpathLocators.xpathLookup.get("BUSINESS_NAME"), TimeIntentAndFirstSecondThirdBuyXpathLocators.dataLookup.get("business_name") 
				+ randomSeriesForThreeCharacter());

		scriptUtils.clear(By.id(TimeIntentAndFirstSecondThirdBuyXpathLocators.xpathLookup.get("MOBILE_NUMBER")));

		String mobnum1 = Integer.toString(TestScriptUtilities.getRandom6digitNumber());
		String mobnum2 = Integer.toString(TestScriptUtilities.getRandom6digitNumber());

		String mobnum = TimeIntentAndFirstSecondThirdBuyXpathLocators.dataLookup.get("mobile_number") + mobnum1 + mobnum2;
		scriptUtils.fillInTextField(TimeIntentAndFirstSecondThirdBuyXpathLocators.xpathLookup.get("MOBILE_NUMBER"), mobnum);
		scriptUtils.fillInTextField(TimeIntentAndFirstSecondThirdBuyXpathLocators.xpathLookup.get("LANLINE_NUMBER"), TimeIntentAndFirstSecondThirdBuyXpathLocators.dataLookup.get("lanline_number"));
		scriptUtils.clear(By.id(TimeIntentAndFirstSecondThirdBuyXpathLocators.xpathLookup.get("CONTACT_NAME")));
		scriptUtils.fillInTextField(TimeIntentAndFirstSecondThirdBuyXpathLocators.xpathLookup.get("CONTACT_NAME"), TimeIntentAndFirstSecondThirdBuyXpathLocators.dataLookup.get("contact_name")
				+ randomSeriesForThreeCharacter());
		scriptUtils.clear(By.id(TimeIntentAndFirstSecondThirdBuyXpathLocators.xpathLookup.get("EMAIL_ADDRESS")));

		scriptUtils.fillInTextField(TimeIntentAndFirstSecondThirdBuyXpathLocators.xpathLookup.get("EMAIL_ADDRESS"), uniqueEmailAccountName);
		System.out.println("Email account: " + uniqueEmailAccountName);
		scriptUtils.fillInTextField(TimeIntentAndFirstSecondThirdBuyXpathLocators.xpathLookup.get("PASSWORD"), TimeIntentAndFirstSecondThirdBuyXpathLocators.dataLookup.get("password"));
		scriptUtils
				.fillInTextField(TimeIntentAndFirstSecondThirdBuyXpathLocators.xpathLookup.get("CONFIRM_PASSWORD"), TimeIntentAndFirstSecondThirdBuyXpathLocators.dataLookup.get("confirm_password"));
		scriptUtils.selectDropdown(By.id(TimeIntentAndFirstSecondThirdBuyXpathLocators.xpathLookup.get("TYPES_OF_BUSINESS")), 1);
		scriptUtils.selectDropdown(By.id(TimeIntentAndFirstSecondThirdBuyXpathLocators.xpathLookup.get("PEOPLE_IN_BUSINESS")), 1);
		scriptUtils.selectDropdown(By.id(TimeIntentAndFirstSecondThirdBuyXpathLocators.xpathLookup.get("HEAR_US")), 1);

		scriptUtils.click(By.xpath(TimeIntentAndFirstSecondThirdBuyXpathLocators.xpathLookup.get("NEXT_PAGE")));

	}

	public void testSelectScreeningPage(final String uniqueEmailAccountName, final String screeningType) throws InterruptedException {

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(TimeIntentAndFirstSecondThirdBuyXpathLocators.xpathLookup.get(screeningType + "_UK"))));
		scriptUtils.click(By.xpath(TimeIntentAndFirstSecondThirdBuyXpathLocators.xpathLookup.get(screeningType + "_UK")));
	}

	public void testScreeningDetailsPage(final String uniqueEmailAccountName, final String screeningType) throws InterruptedException {
		if("DL".equals(screeningType)) {
			testDrivingLicenseScreeningDetailsPage(uniqueEmailAccountName, screeningType);
		} else {
			fail("Invalid screening type: " + screeningType);
		}
	}

	public void testDrivingLicenseScreeningDetailsPage(final String uniqueEmailAccountName, final String screeningType) throws InterruptedException {

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(TimeIntentAndFirstSecondThirdBuyXpathLocators.xpathLookup.get(screeningType + "_FIND_ADDRESS"))));
		scriptUtils.click(By.id(TimeIntentAndFirstSecondThirdBuyXpathLocators.xpathLookup.get(screeningType + "_FIND_ADDRESS")));
		// Thread.sleep(10000);
		scriptUtils.fillInTextField(TimeIntentAndFirstSecondThirdBuyXpathLocators.xpathLookup.get(screeningType + "_POSTCODE"),
				TimeIntentAndFirstSecondThirdBuyXpathLocators.dataLookup.get("postcode"));
		scriptUtils.click(By.id(TimeIntentAndFirstSecondThirdBuyXpathLocators.xpathLookup.get(screeningType + "_FIND_ADDRESS")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(TimeIntentAndFirstSecondThirdBuyXpathLocators.xpathLookup.get("DL_OPTION_FIND_ADDRESS"))));
		scriptUtils.click(By.xpath(TimeIntentAndFirstSecondThirdBuyXpathLocators.xpathLookup.get("DL_OPTION_FIND_ADDRESS")));
		scriptUtils.click(By.id(TimeIntentAndFirstSecondThirdBuyXpathLocators.xpathLookup.get(screeningType + "_CONFIRM_BTN")));

		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id(TimeIntentAndFirstSecondThirdBuyXpathLocators.xpathLookup.get("DL_NUM1"))));

		scriptUtils.fillInTextField(TimeIntentAndFirstSecondThirdBuyXpathLocators.xpathLookup.get("DL_NUM1"), TimeIntentAndFirstSecondThirdBuyXpathLocators.dataLookup.get("dl_num1"));

		scriptUtils.fillInTextField(TimeIntentAndFirstSecondThirdBuyXpathLocators.xpathLookup.get("DL_NUM2"), TimeIntentAndFirstSecondThirdBuyXpathLocators.dataLookup.get("dl_num2"));

		scriptUtils.fillInTextField(TimeIntentAndFirstSecondThirdBuyXpathLocators.xpathLookup.get("DL_NUM3"), TimeIntentAndFirstSecondThirdBuyXpathLocators.dataLookup.get("dl_num3"));

		scriptUtils.fillInTextField(TimeIntentAndFirstSecondThirdBuyXpathLocators.xpathLookup.get("DL_NUM4"), TimeIntentAndFirstSecondThirdBuyXpathLocators.dataLookup.get("dl_num4"));

		scriptUtils.selectDropdown(By.id(TimeIntentAndFirstSecondThirdBuyXpathLocators.xpathLookup.get("DL_DOB")), 2);
		scriptUtils.selectDropdown(By.id(TimeIntentAndFirstSecondThirdBuyXpathLocators.xpathLookup.get("DL_DOM")), 2);

		scriptUtils.selectDropdown(By.id(TimeIntentAndFirstSecondThirdBuyXpathLocators.xpathLookup.get("DL_DOY")), 22);

		scriptUtils.selectDropdown(By.id(TimeIntentAndFirstSecondThirdBuyXpathLocators.xpathLookup.get("DL_GENDER")), 0);

		scriptUtils.selectDropdown(By.id(TimeIntentAndFirstSecondThirdBuyXpathLocators.xpathLookup.get("DL_SALUTATION_TYPE")), 1);

		scriptUtils.fillInTextField(TimeIntentAndFirstSecondThirdBuyXpathLocators.xpathLookup.get("DL_FIRSTNAME"), TimeIntentAndFirstSecondThirdBuyXpathLocators.dataLookup.get("dl_firstname"));

		scriptUtils.fillInTextField(TimeIntentAndFirstSecondThirdBuyXpathLocators.xpathLookup.get("DL_LASTNAME"), TimeIntentAndFirstSecondThirdBuyXpathLocators.dataLookup.get("dl_lastname"));

		scriptUtils.selectDropdown(By.id(TimeIntentAndFirstSecondThirdBuyXpathLocators.xpathLookup.get("DL_BUSINESS_ROLE")), 2);

		scriptUtils.click(By.id(TimeIntentAndFirstSecondThirdBuyXpathLocators.xpathLookup.get(screeningType + "_FIND_ADDRESS")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(TimeIntentAndFirstSecondThirdBuyXpathLocators.xpathLookup.get("DL_OPTION_FIND_ADDRESS"))));
		scriptUtils.click(By.xpath(TimeIntentAndFirstSecondThirdBuyXpathLocators.xpathLookup.get("DL_OPTION_FIND_ADDRESS")));
		scriptUtils.click(By.id(TimeIntentAndFirstSecondThirdBuyXpathLocators.xpathLookup.get(screeningType + "_CONFIRM_BTN")));
	}
	
	public void testSelectPlanPage(final String uniqueEmailAccountName, final String screeningType, final String rollonType) throws InterruptedException {

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(TimeIntentAndFirstSecondThirdBuyXpathLocators.xpathLookup.get(screeningType + "_" + rollonType + "_PLAN"))));
		scriptUtils.click(By.id(TimeIntentAndFirstSecondThirdBuyXpathLocators.xpathLookup.get(screeningType + "_" + rollonType + "_PLAN")));

	}

	public void testCreateTMbillingDetailsPPage() throws InterruptedException {

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(TimeIntentAndFirstSecondThirdBuyXpathLocators.xpathLookup.get("CREDITCARD_CONFIRM_BTN"))));
		scriptUtils.click(By.id(TimeIntentAndFirstSecondThirdBuyXpathLocators.xpathLookup.get("CREDITCARD_CONFIRM_BTN")));

		scriptUtils.fillInTextField(TimeIntentAndFirstSecondThirdBuyXpathLocators.xpathLookup.get("CREDITCARD_NAME"), TimeIntentAndFirstSecondThirdBuyXpathLocators.dataLookup.get("creditcard_name"));

		scriptUtils.fillInTextField(TimeIntentAndFirstSecondThirdBuyXpathLocators.xpathLookup.get("CREDITCARD_NUM"), TimeIntentAndFirstSecondThirdBuyXpathLocators.dataLookup.get("creditcard_num"));

		scriptUtils.selectDropdown(By.id(TimeIntentAndFirstSecondThirdBuyXpathLocators.xpathLookup.get("CREDITCARD_MONTH")), 2);
		scriptUtils.selectDropdown(By.id(TimeIntentAndFirstSecondThirdBuyXpathLocators.xpathLookup.get("CREDITCARD_YEAR")), 10);

		scriptUtils.fillInTextField(TimeIntentAndFirstSecondThirdBuyXpathLocators.xpathLookup.get("CREDITCARD_SECURITY_CODE"),
				TimeIntentAndFirstSecondThirdBuyXpathLocators.dataLookup.get("creditcard_security"));

		scriptUtils.click(By.id(TimeIntentAndFirstSecondThirdBuyXpathLocators.xpathLookup.get("CREDITCARD_CONFIRM_BTN")));

		// Thread.sleep(10000);
	}

	public void testSagepayPage() throws InterruptedException {

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(TimeIntentAndFirstSecondThirdBuyXpathLocators.xpathLookup.get("CREDITCARD_SUBMIT_BTN"))));

		scriptUtils.click(By.xpath(TimeIntentAndFirstSecondThirdBuyXpathLocators.xpathLookup.get("CREDITCARD_SUBMIT_BTN")));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(TimeIntentAndFirstSecondThirdBuyXpathLocators.xpathLookup.get("CREDITCARD_SUBMIT_BTN"))));

		scriptUtils.fillInXpathField(TimeIntentAndFirstSecondThirdBuyXpathLocators.xpathLookup.get("CREDITCARD_3D_PASSWORD"),
				TimeIntentAndFirstSecondThirdBuyXpathLocators.dataLookup.get("creditcard_3d_password"));

		scriptUtils.click(By.xpath(TimeIntentAndFirstSecondThirdBuyXpathLocators.xpathLookup.get("CREDITCARD_SUBMIT_BTN")));
	}

	private void testInductionwelcomePage() throws InterruptedException {

		this.wait = new WebDriverWait(driver, TIMEOUT_IN_SECONDS_INDUCTION_WELCOME);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(TimeIntentAndFirstSecondThirdBuyXpathLocators.xpathLookup.get("WELCOME_HEADER"))));
		// System.out.println(driver.findElement(By.xpath(TimeIntentAndFirstSecondThirdBuyXpathLocators.xpathLookup.get("WELCOME_HEADER"))).getText());
		assertEquals(driver.findElement(By.xpath(TimeIntentAndFirstSecondThirdBuyXpathLocators.xpathLookup.get("WELCOME_HEADER"))).getText(), "Welcome to Rated People");
	}

	public boolean isThreeDSecurePageTimedOut()  {
		return threeDSecurePageTimedOut;
	}

		
	
	
	
}
