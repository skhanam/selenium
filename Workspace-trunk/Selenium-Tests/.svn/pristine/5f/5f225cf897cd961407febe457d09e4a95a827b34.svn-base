package uk.co.ratedpeople.test.functional.selenium.tmsignupvariance.varE;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import uk.co.ratedpeople.test.functional.SeleniumTestContext;
import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;

public class SignUpVariantE {

	private WebDriver driver;
	private String testUrl;
	private TestScriptUtilities scriptUtilities;
	private WebDriverWait wait;
	private boolean threeDSecurePageTimedOut = false;

	public static final int TIMEOUT_IN_SECONDS_INDUCTION_WELCOME = 60;
	public static final String THREE_D_SECURE_TIMEOUT_SELENIUM_ERROR_MSG_START = "Timed out after 30 seconds waiting for visibility of element located by By.xpath: .//*[@id='AutoNumber1']";
	public static final String INDUCTION_PAGE_TIMEOUT_BECAUSE_OF_THREE_D_SECURE_SELENIUM_ERROR_MSG_START = "Timed out after "
			+ TIMEOUT_IN_SECONDS_INDUCTION_WELCOME
			+ " seconds waiting for visibility of element located by By.xpath: .//*[@id='neutral-main-column']/section/h1";

	public static Logger logger = Logger.getLogger(SignUpVariantE.class.getName());

	public SignUpVariantE(SeleniumTestContext context, TestScriptUtilities scriptUtilities) {
		this.scriptUtilities = scriptUtilities;
		this.driver = context.driver;
		this.testUrl = context.getTestUrl();
		this.testUrl = testUrl.replaceAll("http://", "https://");
		this.wait = new WebDriverWait(driver, 30); // 30 seconds
	}

	public void signUpVarE(final String uniqueEmailAccountName, final String rollOnType, final String tariff, final String screeningType) throws Exception {
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
		scriptUtilities.goTo(testUrl + "/new-signup/e/enter-postcode/" + tariff);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(SignupVarEXpathlocators.xpathLookup.get("POSTCODE"))));
		scriptUtilities.click(By.xpath(SignupVarEXpathlocators.xpathLookup.get("VIEW_JOB_LEADS_BTN")));
		scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("POSTCODE"), SignupVarEXpathlocators.dataLookup.get("postcode"));
		scriptUtilities.click(By.xpath(SignupVarEXpathlocators.xpathLookup.get("VIEW_JOB_LEADS_BTN")));
	}

	public void testSelectTradesPage() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SignupVarEXpathlocators.xpathLookup.get("VIEW_JOB_LEADS_FOR_YOUR_TRADE_BTN"))));
		scriptUtilities.click(By.xpath(SignupVarEXpathlocators.xpathLookup.get("VIEW_JOB_LEADS_FOR_YOUR_TRADE_BTN")));
		scriptUtilities.click(By.xpath(SignupVarEXpathlocators.xpathLookup.get("AERIAL_TRADE")));
		scriptUtilities.click(By.xpath(SignupVarEXpathlocators.xpathLookup.get("CLEANER_TRADE")));
		scriptUtilities.click(By.xpath(SignupVarEXpathlocators.xpathLookup.get("HANDYMAN_TRADE")));
		scriptUtilities.click(By.xpath(SignupVarEXpathlocators.xpathLookup.get("ROOFER_TRADE")));
		scriptUtilities.click(By.xpath(SignupVarEXpathlocators.xpathLookup.get("WINDOW_TRADE")));
		scriptUtilities.click(By.xpath(SignupVarEXpathlocators.xpathLookup.get("VIEW_JOB_LEADS_FOR_YOUR_TRADE_BTN")));
	}

	public void testSelectWorkareaPage() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SignupVarEXpathlocators.xpathLookup.get("CONFIRM_WORK_AREA_BTN"))));
		scriptUtilities.click(By.xpath(SignupVarEXpathlocators.xpathLookup.get("MILES")));
		scriptUtilities.click(By.xpath(SignupVarEXpathlocators.xpathLookup.get("CONFIRM_WORK_AREA_BTN")));
	}

	public static char randomSeriesForThreeCharacter() {
		Random word = new Random();
		char random_3_Char = (char) (97 + word.nextInt(25));
		return random_3_Char;
		}
	
	public void testBusinessDetailsPage(String uniqueEmailAccountName, final String tariff) throws InterruptedException {

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SignupVarEXpathlocators.xpathLookup.get("FINDADDRESS_BTN"))));
		scriptUtilities.click(By.xpath(SignupVarEXpathlocators.xpathLookup.get("FINDADDRESS_BTN")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SignupVarEXpathlocators.xpathLookup.get("ADDRESS_OPTION"))));
		scriptUtilities.click(By.xpath(SignupVarEXpathlocators.xpathLookup.get("ADDRESS_OPTION")));
		scriptUtilities.click(By.xpath(SignupVarEXpathlocators.xpathLookup.get("NEXT_PAGE")));
		scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("BUSINESS_NAME"), SignupVarEXpathlocators.dataLookup.get("business_name") 
				+ randomSeriesForThreeCharacter());

		scriptUtilities.clear(By.id(SignupVarEXpathlocators.xpathLookup.get("MOBILE_NUMBER")));

		String mobnum1 = Integer.toString(TestScriptUtilities.getRandom6digitNumber());
		String mobnum2 = Integer.toString(TestScriptUtilities.getRandom6digitNumber());

		String mobnum = SignupVarEXpathlocators.dataLookup.get("mobile_number") + mobnum1 + mobnum2;
		scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("MOBILE_NUMBER"), mobnum);
		scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("LANLINE_NUMBER"), SignupVarEXpathlocators.dataLookup.get("lanline_number"));
		scriptUtilities.clear(By.id(SignupVarEXpathlocators.xpathLookup.get("CONTACT_NAME")));
		scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("CONTACT_NAME"), SignupVarEXpathlocators.dataLookup.get("contact_name")
				+ randomSeriesForThreeCharacter());
		scriptUtilities.clear(By.id(SignupVarEXpathlocators.xpathLookup.get("EMAIL_ADDRESS")));

		scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("EMAIL_ADDRESS"), uniqueEmailAccountName);
		System.out.println("Email account: " + uniqueEmailAccountName);
		scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("PASSWORD"), SignupVarEXpathlocators.dataLookup.get("password"));
		scriptUtilities
				.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("CONFIRM_PASSWORD"), SignupVarEXpathlocators.dataLookup.get("confirm_password"));
		scriptUtilities.selectDropdown(By.id(SignupVarEXpathlocators.xpathLookup.get("TYPES_OF_BUSINESS")), 1);
		scriptUtilities.selectDropdown(By.id(SignupVarEXpathlocators.xpathLookup.get("PEOPLE_IN_BUSINESS")), 1);
		scriptUtilities.selectDropdown(By.id(SignupVarEXpathlocators.xpathLookup.get("HEAR_US")), 1);

		scriptUtilities.click(By.xpath(SignupVarEXpathlocators.xpathLookup.get("NEXT_PAGE")));

	}

	public void testSelectScreeningPage(final String uniqueEmailAccountName, final String screeningType) throws InterruptedException {

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SignupVarEXpathlocators.xpathLookup.get(screeningType + "_UK"))));
		scriptUtilities.click(By.xpath(SignupVarEXpathlocators.xpathLookup.get(screeningType + "_UK")));
	}

	public void testScreeningDetailsPage(final String uniqueEmailAccountName, final String screeningType) throws InterruptedException {
		if ("PASSPORT".equals(screeningType)) {
			testPassportScreeningDetailsPage(uniqueEmailAccountName, screeningType);
		} else if ("DL".equals(screeningType)) {
			testDrivingLicenseScreeningDetailsPage(uniqueEmailAccountName, screeningType);
		} else if ("PASSPORTGBR".equals(screeningType)) {
			testPassportScreeningDetailsPage(uniqueEmailAccountName, screeningType);
		} else {
			fail("Invalid screening type: " + screeningType);
		}
	}

	public void testDrivingLicenseScreeningDetailsPage(final String uniqueEmailAccountName, final String screeningType) throws InterruptedException {

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(SignupVarEXpathlocators.xpathLookup.get(screeningType + "_FIND_ADDRESS"))));
		scriptUtilities.click(By.id(SignupVarEXpathlocators.xpathLookup.get(screeningType + "_FIND_ADDRESS")));
		// Thread.sleep(10000);
		scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get(screeningType + "_POSTCODE"),
				SignupVarEXpathlocators.dataLookup.get("postcode"));
		scriptUtilities.click(By.id(SignupVarEXpathlocators.xpathLookup.get(screeningType + "_FIND_ADDRESS")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SignupVarEXpathlocators.xpathLookup.get("DL_OPTION_FIND_ADDRESS"))));
		scriptUtilities.click(By.xpath(SignupVarEXpathlocators.xpathLookup.get("DL_OPTION_FIND_ADDRESS")));
		scriptUtilities.click(By.id(SignupVarEXpathlocators.xpathLookup.get(screeningType + "_CONFIRM_BTN")));

		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id(SignupVarEXpathlocators.xpathLookup.get("DL_NUM1"))));

		scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("DL_NUM1"), SignupVarEXpathlocators.dataLookup.get("dl_num1"));

		scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("DL_NUM2"), SignupVarEXpathlocators.dataLookup.get("dl_num2"));

		scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("DL_NUM3"), SignupVarEXpathlocators.dataLookup.get("dl_num3"));

		scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("DL_NUM4"), SignupVarEXpathlocators.dataLookup.get("dl_num4"));

		scriptUtilities.selectDropdown(By.id(SignupVarEXpathlocators.xpathLookup.get("DL_DOB")), 2);
		scriptUtilities.selectDropdown(By.id(SignupVarEXpathlocators.xpathLookup.get("DL_DOM")), 2);

		scriptUtilities.selectDropdown(By.id(SignupVarEXpathlocators.xpathLookup.get("DL_DOY")), 22);

		scriptUtilities.selectDropdown(By.id(SignupVarEXpathlocators.xpathLookup.get("DL_GENDER")), 0);

		scriptUtilities.selectDropdown(By.id(SignupVarEXpathlocators.xpathLookup.get("DL_SALUTATION_TYPE")), 1);

		scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("DL_FIRSTNAME"), SignupVarEXpathlocators.dataLookup.get("dl_firstname"));

		scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("DL_LASTNAME"), SignupVarEXpathlocators.dataLookup.get("dl_lastname"));

		scriptUtilities.selectDropdown(By.id(SignupVarEXpathlocators.xpathLookup.get("DL_BUSINESS_ROLE")), 2);

		scriptUtilities.click(By.id(SignupVarEXpathlocators.xpathLookup.get(screeningType + "_FIND_ADDRESS")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SignupVarEXpathlocators.xpathLookup.get("DL_OPTION_FIND_ADDRESS"))));
		scriptUtilities.click(By.xpath(SignupVarEXpathlocators.xpathLookup.get("DL_OPTION_FIND_ADDRESS")));
		scriptUtilities.click(By.id(SignupVarEXpathlocators.xpathLookup.get(screeningType + "_CONFIRM_BTN")));
	}

	public void testPassportScreeningDetailsPage(final String uniqueEmailAccountName, final String screeningType) throws InterruptedException {

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(SignupVarEXpathlocators.xpathLookup.get(screeningType + "_FIND_ADDRESS_BTN"))));

		scriptUtilities.click(By.id(SignupVarEXpathlocators.xpathLookup.get(screeningType + "_FIND_ADDRESS_BTN")));

		String testUrlLowercase = testUrl.toLowerCase();
		if (testUrlLowercase.indexOf("preprod") != -1 || testUrlLowercase.indexOf("pirp") != -1 || testUrlLowercase.indexOf("piserve2") != -1) {
			// preprod: use live for now
			// System.out.println("PREPROD / PIRP");
			String dataset = "preprod";
			testPassportdetails(uniqueEmailAccountName, screeningType, dataset);
		} else {
			// tokyo and others: use stub
			// System.out.println("TOKYO");
			String dataset = "";
			testPassportdetails(uniqueEmailAccountName, screeningType, dataset);
		}
	}

	public void testPassportdetails(final String uniqueEmailAccountName, final String screeningType, final String dataset) {

		if ("PASSPORT".equals(screeningType)) {
			scriptUtilities.clear(By.id(SignupVarEXpathlocators.xpathLookup.get(screeningType + "_POSTCODE")));
			scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get(screeningType + "_POSTCODE"),
					SignupVarEXpathlocators.dataLookup.get(dataset + "_passport_postcode"));
			scriptUtilities.click(By.id(SignupVarEXpathlocators.xpathLookup.get(screeningType + "_FIND_ADDRESS_BTN")));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Enter address manually"))).click();

			scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("PASSPORTGBR_ADDRESS_HOME_NUM"),
					SignupVarEXpathlocators.dataLookup.get("preprod_passport_property"));

			scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("PASSPORTGBR_ADDRESS_STREET"),
					SignupVarEXpathlocators.dataLookup.get("preprod_passport_street"));

			scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("PASSPORTGBR_ADDRESS_TOWN"),
					SignupVarEXpathlocators.dataLookup.get("preprod_passport_town"));

			scriptUtilities.click(By.id(SignupVarEXpathlocators.xpathLookup.get(screeningType + "_FIND_ADDRESS_BTN")));

			scriptUtilities.click(By.id(SignupVarEXpathlocators.xpathLookup.get(screeningType + "_CONFIRM_BTN")));

			scriptUtilities.selectDropdown(By.id(SignupVarEXpathlocators.xpathLookup.get("SELECT_PASSPORT")), 1);

			scriptUtilities.checkAndSelectDropDownById(SignupVarEXpathlocators.xpathLookup.get("PASSPORT_EXPDAY"),
					SignupVarEXpathlocators.dataLookup.get(dataset + "_passport_exp_day"));
			scriptUtilities.checkAndSelectDropDownById(SignupVarEXpathlocators.xpathLookup.get("PASSPORT_EXPMON"),
					SignupVarEXpathlocators.dataLookup.get(dataset + "_passport_exp_mon"));
			scriptUtilities.checkAndSelectDropDownById(SignupVarEXpathlocators.xpathLookup.get("PASSPORT_EXPYEAR"),
					SignupVarEXpathlocators.dataLookup.get(dataset + "_passport_exp_year"));
			scriptUtilities.checkAndSelectDropDownById(SignupVarEXpathlocators.xpathLookup.get("PASSPORT_DOB_DAY"),
					SignupVarEXpathlocators.dataLookup.get(dataset + "_passport_dob_day"));
			scriptUtilities.checkAndSelectDropDownById(SignupVarEXpathlocators.xpathLookup.get("PASSPORT_DOB_MONTH"),
					SignupVarEXpathlocators.dataLookup.get(dataset + "_passport_dob_mon"));
			scriptUtilities.checkAndSelectDropDownById(SignupVarEXpathlocators.xpathLookup.get("PASSPORT_DOB_YEAR"),
					SignupVarEXpathlocators.dataLookup.get(dataset + "_passport_dob_year"));

			scriptUtilities.checkAndSelectDropDownById(SignupVarEXpathlocators.xpathLookup.get("PASSPORT_GENDER"),
					SignupVarEXpathlocators.dataLookup.get(dataset + "_passport_gender"));

			scriptUtilities.checkAndSelectDropDownById(SignupVarEXpathlocators.xpathLookup.get("PASSPORT_SALUTATION_TYPE"),
					SignupVarEXpathlocators.dataLookup.get(dataset + "_passport_sal_name"));
			scriptUtilities.selectDropdown(SignupVarEXpathlocators.xpathLookup.get("PASSPORT_DESCRIBES_YOU"), 1);

			scriptUtilities.click(By.id(SignupVarEXpathlocators.xpathLookup.get(screeningType + "_CONFIRM_BTN")));

			scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("PASSPORT_NUM1"),
					SignupVarEXpathlocators.dataLookup.get(dataset + "_passport_num1"));

			scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("PASSPORT_NUM2"),
					SignupVarEXpathlocators.dataLookup.get(dataset + "_passport_num2"));

			scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("PASSPORT_NUM3"),
					SignupVarEXpathlocators.dataLookup.get(dataset + "_passport_num3"));

			scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("PASSPORT_NUM4"),
					SignupVarEXpathlocators.dataLookup.get(dataset + "_passport_num4"));

			scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("PASSPORT_NUM5"),
					SignupVarEXpathlocators.dataLookup.get(dataset + "_passport_num5"));

			scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("PASSPORT_NUM6"),
					SignupVarEXpathlocators.dataLookup.get(dataset + "_passport_num6"));

			scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("PASSPORT_NUM7"),
					SignupVarEXpathlocators.dataLookup.get(dataset + "_passport_num7"));

			scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("PASSPORT_NUM8"),
					SignupVarEXpathlocators.dataLookup.get(dataset + "_passport_num8"));

			scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("PASSPORT_NUM9"),
					SignupVarEXpathlocators.dataLookup.get(dataset + "_passport_num9"));

			scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("PASSPORT_FIRST_NAME"),
					SignupVarEXpathlocators.dataLookup.get(dataset + "_passport_firstname"));

			scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("PASSPORT_LAST_NAME"),
					SignupVarEXpathlocators.dataLookup.get(dataset + "_passport_lastname"));

			scriptUtilities.click(By.id(SignupVarEXpathlocators.xpathLookup.get(screeningType + "_CONFIRM_BTN")));

		} else if ("PASSPORTGBR".equals(screeningType)) {
			scriptUtilities.clear(By.id(SignupVarEXpathlocators.xpathLookup.get(screeningType + "_POSTCODE")));
			scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get(screeningType + "_POSTCODE"),
					SignupVarEXpathlocators.dataLookup.get(dataset + "_passportGbr_postcode"));
			scriptUtilities.click(By.id(SignupVarEXpathlocators.xpathLookup.get(screeningType + "_FIND_ADDRESS_BTN")));

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SignupVarEXpathlocators.xpathLookup.get("PASSPORT_OPTION_FIND_ADDRESS"))));
			scriptUtilities.click(By.xpath(SignupVarEXpathlocators.xpathLookup.get(screeningType + "_OPTION_FIND_ADDRESS")));

			scriptUtilities.click(By.id(SignupVarEXpathlocators.xpathLookup.get(screeningType + "_CONFIRM_BTN")));

			scriptUtilities.selectDropdown(By.id(SignupVarEXpathlocators.xpathLookup.get("SELECT_PASSPORT")), 2);

			scriptUtilities.checkAndSelectDropDownById(SignupVarEXpathlocators.xpathLookup.get("PASSPORTGBR_EXPDAY"),
					SignupVarEXpathlocators.dataLookup.get(dataset + "_passportGbr_exp_day"));
			scriptUtilities.checkAndSelectDropDownById(SignupVarEXpathlocators.xpathLookup.get("PASSPORTGBR_EXPMON"),
					SignupVarEXpathlocators.dataLookup.get(dataset + "_passportGbr_exp_mon"));
			scriptUtilities.checkAndSelectDropDownById(SignupVarEXpathlocators.xpathLookup.get("PASSPORTGBR_EXPYEAR"),
					SignupVarEXpathlocators.dataLookup.get(dataset + "_passportGbr_exp_year"));
			scriptUtilities.checkAndSelectDropDownById(SignupVarEXpathlocators.xpathLookup.get("PASSPORTGBR_DOB_DAY"),
					SignupVarEXpathlocators.dataLookup.get(dataset + "_passportGbr_dob_day"));
			scriptUtilities.checkAndSelectDropDownById(SignupVarEXpathlocators.xpathLookup.get("PASSPORTGBR_DOB_MONTH"),
					SignupVarEXpathlocators.dataLookup.get(dataset + "_passportGbr_dob_mon"));
			scriptUtilities.checkAndSelectDropDownById(SignupVarEXpathlocators.xpathLookup.get("PASSPORTGBR_DOB_YEAR"),
					SignupVarEXpathlocators.dataLookup.get(dataset + "_passportGbr_dob_year"));

			scriptUtilities.checkAndSelectDropDownById(SignupVarEXpathlocators.xpathLookup.get("PASSPORTGBR_GENDER"),
					SignupVarEXpathlocators.dataLookup.get(dataset + "_passportGbr_gender"));

			scriptUtilities.checkAndSelectDropDownById(SignupVarEXpathlocators.xpathLookup.get("PASSPORTGBR_SALUTATION_TYPE"),
					SignupVarEXpathlocators.dataLookup.get(dataset + "_passportGbr_sal_name"));
			scriptUtilities.selectDropdown(SignupVarEXpathlocators.xpathLookup.get("PASSPORTGBR_DESCRIBES_YOU"), 1);

			scriptUtilities.click(By.id(SignupVarEXpathlocators.xpathLookup.get(screeningType + "_CONFIRM_BTN")));

			scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("PASSPORTGBR_NUM1"),
					SignupVarEXpathlocators.dataLookup.get(dataset + "_passportGbr_num1"));

			scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("PASSPORTGBR_NUM2"),
					SignupVarEXpathlocators.dataLookup.get(dataset + "_passportGbr_num2"));

			scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("PASSPORTGBR_NUM3"),
					SignupVarEXpathlocators.dataLookup.get(dataset + "_passportGbr_num3"));

			scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("PASSPORTGBR_NUM4"),
					SignupVarEXpathlocators.dataLookup.get(dataset + "_passportGbr_num4"));

			scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("PASSPORTGBR_NUM5"),
					SignupVarEXpathlocators.dataLookup.get(dataset + "_passportGbr_num5"));

			scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("PASSPORTGBR_NUM6"),
					SignupVarEXpathlocators.dataLookup.get(dataset + "_passportGbr_num6"));

			scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("PASSPORTGBR_FIRST_NAME"),
					SignupVarEXpathlocators.dataLookup.get(dataset + "_passportGbr_firstname"));

			scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("PASSPORTGBR_LAST_NAME"),
					SignupVarEXpathlocators.dataLookup.get(dataset + "_passportGbr_lastname"));

			scriptUtilities.click(By.id(SignupVarEXpathlocators.xpathLookup.get(screeningType + "_CONFIRM_BTN")));

		}

	}

	public void testSelectPlanPage(final String uniqueEmailAccountName, final String screeningType, final String rollonType) throws InterruptedException {

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(SignupVarEXpathlocators.xpathLookup.get(screeningType + "_" + rollonType + "_PLAN"))));
		scriptUtilities.click(By.id(SignupVarEXpathlocators.xpathLookup.get(screeningType + "_" + rollonType + "_PLAN")));

	}

	public void testCreateTMbillingDetailsPPage() throws InterruptedException {

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(SignupVarEXpathlocators.xpathLookup.get("CREDITCARD_CONFIRM_BTN"))));
		scriptUtilities.click(By.id(SignupVarEXpathlocators.xpathLookup.get("CREDITCARD_CONFIRM_BTN")));

		scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("CREDITCARD_NAME"), SignupVarEXpathlocators.dataLookup.get("creditcard_name"));

		scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("CREDITCARD_NUM"), SignupVarEXpathlocators.dataLookup.get("creditcard_num"));

		scriptUtilities.selectDropdown(By.id(SignupVarEXpathlocators.xpathLookup.get("CREDITCARD_MONTH")), 2);
		scriptUtilities.selectDropdown(By.id(SignupVarEXpathlocators.xpathLookup.get("CREDITCARD_YEAR")), 10);

		scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("CREDITCARD_SECURITY_CODE"),
				SignupVarEXpathlocators.dataLookup.get("creditcard_security"));

		scriptUtilities.click(By.id(SignupVarEXpathlocators.xpathLookup.get("CREDITCARD_CONFIRM_BTN")));

		// Thread.sleep(10000);
	}

	public void testSagepayPage() throws InterruptedException {

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SignupVarEXpathlocators.xpathLookup.get("CREDITCARD_SUBMIT_BTN"))));

		scriptUtilities.click(By.xpath(SignupVarEXpathlocators.xpathLookup.get("CREDITCARD_SUBMIT_BTN")));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SignupVarEXpathlocators.xpathLookup.get("CREDITCARD_SUBMIT_BTN"))));

		scriptUtilities.fillInXpathField(SignupVarEXpathlocators.xpathLookup.get("CREDITCARD_3D_PASSWORD"),
				SignupVarEXpathlocators.dataLookup.get("creditcard_3d_password"));

		scriptUtilities.click(By.xpath(SignupVarEXpathlocators.xpathLookup.get("CREDITCARD_SUBMIT_BTN")));
	}

	private void testInductionwelcomePage() throws InterruptedException {

		this.wait = new WebDriverWait(driver, TIMEOUT_IN_SECONDS_INDUCTION_WELCOME);
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SignupVarEXpathlocators.xpathLookup.get("WELCOME_HEADER"))));
		}catch(TimeoutException e){
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//html/body/div[1]/div[2]/div/div/section/h1")));
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("breadcrumbs-container")));
		    driver.navigate().refresh();
		    scriptUtilities.sleep(2000);
			driver.switchTo().alert().accept();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SignupVarEXpathlocators.xpathLookup.get("WELCOME_HEADER"))));
		}		
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SignupVarEXpathlocators.xpathLookup.get("WELCOME_HEADER"))));
		// System.out.println(driver.findElement(By.xpath(SignupVarEXpathlocators.xpathLookup.get("WELCOME_HEADER"))).getText());
		assertEquals(driver.findElement(By.xpath(SignupVarEXpathlocators.xpathLookup.get("WELCOME_HEADER"))).getText(), "Welcome to Rated People");
	}

	public boolean isThreeDSecurePageTimedOut() {
		return threeDSecurePageTimedOut;
	}

}
