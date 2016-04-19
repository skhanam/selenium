package uk.co.ratedpeople.test.functional.selenium.tmsignupvariance.varC;

import static org.testng.Assert.assertEquals;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import uk.co.ratedpeople.test.functional.SeleniumTestContext;
import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;

public class SignUpVariantC {

	private WebDriver driver;
	private String testUrl;
	private TestScriptUtilities scriptUtilities;
	private WebDriverWait wait;
	private boolean threeDSecurePageTimedOut = false;

	public static Logger logger = Logger.getLogger(SignUpVariantC.class.getName());

	public static final int TIMEOUT_IN_SECONDS_INDUCTION_WELCOME = 60;
	public static final String THREE_D_SECURE_TIMEOUT_SELENIUM_ERROR_MSG_START = "Timed out after 30 seconds waiting for visibility of element located by By.xpath: .//*[@id='AutoNumber1']";
	public static final String INDUCTION_PAGE_TIMEOUT_BECAUSE_OF_THREE_D_SECURE_SELENIUM_ERROR_MSG_START = "Timed out after "
			+ TIMEOUT_IN_SECONDS_INDUCTION_WELCOME
			+ " seconds waiting for visibility of element located by By.xpath: .//*[@id='neutral-main-column']/section/h1";

	public SignUpVariantC(SeleniumTestContext context, TestScriptUtilities scriptUtilities) {
		this.scriptUtilities = scriptUtilities;
		this.driver = context.driver;
		this.testUrl = context.getTestUrl();
		this.wait = new WebDriverWait(driver, TIMEOUT_IN_SECONDS_INDUCTION_WELCOME);
		this.threeDSecurePageTimedOut = false;
	}

	public void signUpVarC(final String uniqueEmailAccountName, final String rollOnType, final String tariff, final String screeningType) throws Exception {
		System.out.println(rollOnType + " " + tariff + " " + screeningType);
		testLandingPage(uniqueEmailAccountName, tariff);
		testBusinessDetailsPage(uniqueEmailAccountName);
		testSelectScreeningPage(uniqueEmailAccountName, screeningType);
		testScreeningDetailsPage(uniqueEmailAccountName, screeningType);
		testcreateTMbillingDetailsPPage(rollOnType);
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

	public void testLandingPage(final String uniqueEmailAccountName, final String tariff) throws InterruptedException {
		System.out.println(uniqueEmailAccountName);
		System.out.println(tariff);
		// append tariff later to url
		scriptUtilities.goTo(testUrl + "/new-signup/c/landing/" + tariff);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(SignupVarCXpathlocators.xpathLookup.get("START_SIGN_UP_BTN"))));
		scriptUtilities.click(By.id(SignupVarCXpathlocators.xpathLookup.get("START_SIGN_UP_BTN")));
		scriptUtilities.selectDropdown(By.id(SignupVarCXpathlocators.xpathLookup.get("SELECT_TRADE")), 1);
		scriptUtilities.fillInTextField(SignupVarCXpathlocators.xpathLookup.get("POSTCODE"), SignupVarCXpathlocators.dataLookup.get("postcode"));
		scriptUtilities.fillInTextField(SignupVarCXpathlocators.xpathLookup.get("EMAIL"), uniqueEmailAccountName);
		scriptUtilities.click(By.id(SignupVarCXpathlocators.xpathLookup.get("START_SIGN_UP_BTN")));
	}

	public void testBusinessDetailsPage(String uniqueEmailAccountName) throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(SignupVarCXpathlocators.xpathLookup.get("BUSINESS_DETAILS_SUBMIT"))));
		scriptUtilities.click(By.id(SignupVarCXpathlocators.xpathLookup.get("BUSINESS_DETAILS_SUBMIT")));
		scriptUtilities.selectDropdown(By.id(SignupVarCXpathlocators.xpathLookup.get("SALUTATION_TYPE")), 1);
		scriptUtilities.fillInTextField(SignupVarCXpathlocators.xpathLookup.get("FIRST_NAME"), SignupVarCXpathlocators.dataLookup.get("FIRST_NAME"));
		scriptUtilities.fillInTextField(SignupVarCXpathlocators.xpathLookup.get("LAST_NAME"), SignupVarCXpathlocators.dataLookup.get("LAST_NAME"));
		scriptUtilities.selectDropdown(By.id(SignupVarCXpathlocators.xpathLookup.get("BUSINESS_ROLE")), 1);
		scriptUtilities.fillInTextField(SignupVarCXpathlocators.xpathLookup.get("PASSWORD"), SignupVarCXpathlocators.dataLookup.get("PASSWORD"));
		scriptUtilities
				.fillInTextField(SignupVarCXpathlocators.xpathLookup.get("CONFIRM_PASSWORD"), SignupVarCXpathlocators.dataLookup.get("CONFIRM_PASSWORD"));
		scriptUtilities.fillInTextField(SignupVarCXpathlocators.xpathLookup.get("COMPANY_NAME"), SignupVarCXpathlocators.dataLookup.get("COMPANY_NAME"));
		scriptUtilities.selectDropdown(By.id(SignupVarCXpathlocators.xpathLookup.get("BUSINESS_TYPE")), 1);
		scriptUtilities.selectDropdown(By.id(SignupVarCXpathlocators.xpathLookup.get("BUSINESS_EMPLOYEES")), 1);
		scriptUtilities.fillInTextField(SignupVarCXpathlocators.xpathLookup.get("COMPANY_NUM"), SignupVarCXpathlocators.dataLookup.get("COMPANY_NUM"));
		scriptUtilities.fillInTextField(SignupVarCXpathlocators.xpathLookup.get("COMPANY_VAT_NUM"), SignupVarCXpathlocators.dataLookup.get("COMPANY_VAT_NUM"));

		scriptUtilities.clear(By.id(SignupVarCXpathlocators.xpathLookup.get("MOBILE_NUM")));

		String mobnum1 = Integer.toString(TestScriptUtilities.getRandom6digitNumber());
		String mobnum2 = Integer.toString(TestScriptUtilities.getRandom6digitNumber());

		String mobnum = SignupVarCXpathlocators.dataLookup.get("MOBILE_NUM") + mobnum1 + mobnum2;
		scriptUtilities.fillInTextField(SignupVarCXpathlocators.xpathLookup.get("MOBILE_NUM"), mobnum);

		// scriptUtilities.fillInTextField(SignupVarCXpathlocators.xpathLookup.get("MOBILE_NUM"),
		// SignupVarCXpathlocators.dataLookup.get("MOBILE_NUM") + 808900);

		scriptUtilities.click(By.id(SignupVarCXpathlocators.xpathLookup.get("FIND_ADDRESS_BTN")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SignupVarCXpathlocators.xpathLookup.get("ADDRESS_OPTION"))));
		scriptUtilities.click(By.xpath(SignupVarCXpathlocators.xpathLookup.get("ADDRESS_OPTION")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(SignupVarCXpathlocators.xpathLookup.get("PROPERTY_ADDRESS"))));
		scriptUtilities.click(By.id(SignupVarCXpathlocators.xpathLookup.get("BUSINESS_DETAILS_SUBMIT")));
	}

	public void testSelectScreeningPage(final String uniqueEmailAccountName, final String screeningType) throws InterruptedException {

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SignupVarCXpathlocators.xpathLookup.get(screeningType + "_UK"))));
		scriptUtilities.click(By.xpath(SignupVarCXpathlocators.xpathLookup.get(screeningType + "_UK")));
	}

	public void testScreeningDetailsPage(final String uniqueEmailAccountName, final String screeningType) throws InterruptedException {
		if (screeningType == "DL") {
			testDrivingLicenseScreeningDetailsPage(uniqueEmailAccountName, screeningType);
		}

		if (screeningType == "PASSPORT") {
			testPassportThroughPreprodOrTokyo(uniqueEmailAccountName, screeningType);
		}

		if (screeningType == "PASSPORTOTHER") {
			testPassportThroughPreprodOrTokyo(uniqueEmailAccountName, screeningType);
		}

	}

	public void testPassportThroughPreprodOrTokyo(final String uniqueEmailAccountName, final String screeningType) throws InterruptedException {

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(SignupVarCXpathlocators.xpathLookup.get(screeningType + "_NEXT_BTN"))));

		scriptUtilities.click(By.id(SignupVarCXpathlocators.xpathLookup.get(screeningType + "_NEXT_BTN")));

		String testUrlLowercase = testUrl.toLowerCase();
		if (testUrlLowercase.indexOf("preprod") != -1 || testUrlLowercase.indexOf("pirp") != -1 || testUrlLowercase.indexOf("piserve2") != -1) {
			// preprod: use live for now
			// System.out.println("PREPROD / PIRP");
			String dataset = "preprod";
			testPassportScreeningDetailsPage(uniqueEmailAccountName, screeningType, dataset);
		} else {
			// tokyo and others: use stub
			// System.out.println("TOKYO");
			String dataset = "";
			testPassportScreeningDetailsPage(uniqueEmailAccountName, screeningType, dataset);
		}
	}

	public void testPassportScreeningDetailsPage(final String uniqueEmailAccountName, final String screeningType, final String dataset)
			throws InterruptedException {

		if (screeningType == "PASSPORT") {
			scriptUtilities.checkAndSelectDropDownById(SignupVarCXpathlocators.xpathLookup.get(screeningType + "_GBR"),
					SignupVarCXpathlocators.dataLookup.get(dataset + "_passport_GBR"));

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(SignupVarCXpathlocators.xpathLookup.get(screeningType + "_GBR_FIRST_NAME"))));
			scriptUtilities.fillInTextField(SignupVarCXpathlocators.xpathLookup.get(screeningType + "_GBR_FIRST_NAME"),
					SignupVarCXpathlocators.dataLookup.get(dataset + "_passport_GBR_FIRST_NAME"));

			scriptUtilities.fillInTextField(SignupVarCXpathlocators.xpathLookup.get(screeningType + "_GBR_LAST_NAME"),
					SignupVarCXpathlocators.dataLookup.get(dataset + "_passport_GBR_LAST_NAME"));

			scriptUtilities.checkAndSelectDropDownById(SignupVarCXpathlocators.xpathLookup.get(screeningType + "_GBR_DOB"),
					SignupVarCXpathlocators.dataLookup.get(dataset + "_passport_GBR_DOB"));

			scriptUtilities.checkAndSelectDropDownById(SignupVarCXpathlocators.xpathLookup.get(screeningType + "_GBR_DOB_MON"),
					SignupVarCXpathlocators.dataLookup.get(dataset + "_passport_GBR_DOB_MON"));

			scriptUtilities.checkAndSelectDropDownById(SignupVarCXpathlocators.xpathLookup.get(screeningType + "_GBR_DOB_YEAR"),
					SignupVarCXpathlocators.dataLookup.get(dataset + "_passport_GBR_DOB_YEAR"));

			scriptUtilities.checkAndSelectDropDownById(SignupVarCXpathlocators.xpathLookup.get(screeningType + "_GBR_EXP"),
					SignupVarCXpathlocators.dataLookup.get(dataset + "_passport_GBR_EXP"));

			scriptUtilities.checkAndSelectDropDownById(SignupVarCXpathlocators.xpathLookup.get(screeningType + "_GBR_EXP_MON"),
					SignupVarCXpathlocators.dataLookup.get(dataset + "_passport_GBR_EXP_MON"));

			scriptUtilities.checkAndSelectDropDownById(SignupVarCXpathlocators.xpathLookup.get(screeningType + "_GBR_EXP_YEAR"),
					SignupVarCXpathlocators.dataLookup.get(dataset + "_passport_GBR_EXP_YEAR"));

			scriptUtilities.fillInTextField(SignupVarCXpathlocators.xpathLookup.get(screeningType + "_GBR_NUM"),
					SignupVarCXpathlocators.dataLookup.get(dataset + "_passport_GBR_NUM"));

			scriptUtilities.checkAndSelectDropDownById(SignupVarCXpathlocators.xpathLookup.get(screeningType + "_GBR_NEWPERSONALADDRESS"),
					SignupVarCXpathlocators.dataLookup.get(dataset + "_passport_GBR_NEWPERSONALADDRESS"));

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(SignupVarCXpathlocators.xpathLookup.get(screeningType + "_GBR_NEWPOSTCODE"))));

			scriptUtilities.fillInTextField(SignupVarCXpathlocators.xpathLookup.get(screeningType + "_GBR_NEWPOSTCODE"),
					SignupVarCXpathlocators.dataLookup.get(dataset + "_passport_GBR_NEWPOSTCODE"));

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Enter address manually"))).click();

			scriptUtilities.fillInTextField(SignupVarCXpathlocators.xpathLookup.get(screeningType + "_GBR_HOUSENAME"),
					SignupVarCXpathlocators.dataLookup.get(dataset + "_passport_GBR_HOUSENAME"));

			scriptUtilities.fillInTextField(SignupVarCXpathlocators.xpathLookup.get(screeningType + "_GBR_STREET"),
					SignupVarCXpathlocators.dataLookup.get(dataset + "_passport_GBR_STREET"));

			scriptUtilities.fillInTextField(SignupVarCXpathlocators.xpathLookup.get(screeningType + "_GBR_TOWN"),
					SignupVarCXpathlocators.dataLookup.get(dataset + "_passport_GBR_TOWN"));

			scriptUtilities.click(By.id(SignupVarCXpathlocators.xpathLookup.get(screeningType + "_NEXT_BTN")));

		}

		else {

			scriptUtilities.checkAndSelectDropDownById(SignupVarCXpathlocators.xpathLookup.get(screeningType + "_OTHER"),
					SignupVarCXpathlocators.dataLookup.get(dataset + "_passport_OTHER"));

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(SignupVarCXpathlocators.xpathLookup.get(screeningType + "_OTHER_FIRST_NAME"))));
			scriptUtilities.fillInTextField(SignupVarCXpathlocators.xpathLookup.get(screeningType + "_OTHER_FIRST_NAME"),
					SignupVarCXpathlocators.dataLookup.get(dataset + "_passport_OTHER_FIRST_NAME"));

			scriptUtilities.fillInTextField(SignupVarCXpathlocators.xpathLookup.get(screeningType + "_OTHER_LAST_NAME"),
					SignupVarCXpathlocators.dataLookup.get(dataset + "_passport_OTHER_LAST_NAME"));

			scriptUtilities.checkAndSelectDropDownById(SignupVarCXpathlocators.xpathLookup.get(screeningType + "_OTHER_DOB"),
					SignupVarCXpathlocators.dataLookup.get(dataset + "_passport_OTHER_DOB"));

			scriptUtilities.checkAndSelectDropDownById(SignupVarCXpathlocators.xpathLookup.get(screeningType + "_OTHER_DOB_MON"),
					SignupVarCXpathlocators.dataLookup.get(dataset + "_passport_OTHER_DOB_MON"));

			scriptUtilities.checkAndSelectDropDownById(SignupVarCXpathlocators.xpathLookup.get(screeningType + "_OTHER_DOB_YEAR"),
					SignupVarCXpathlocators.dataLookup.get(dataset + "_passport_OTHER_DOB_YEAR"));

			scriptUtilities.checkAndSelectDropDownById(SignupVarCXpathlocators.xpathLookup.get(screeningType + "_OTHER_EXP"),
					SignupVarCXpathlocators.dataLookup.get(dataset + "_passport_OTHER_EXP"));

			scriptUtilities.checkAndSelectDropDownById(SignupVarCXpathlocators.xpathLookup.get(screeningType + "_OTHER_EXP_MON"),
					SignupVarCXpathlocators.dataLookup.get(dataset + "_passport_OTHER_EXP_MON"));

			scriptUtilities.checkAndSelectDropDownById(SignupVarCXpathlocators.xpathLookup.get(screeningType + "_OTHER_EXP_YEAR"),
					SignupVarCXpathlocators.dataLookup.get(dataset + "_passport_OTHER_EXP_YEAR"));

			scriptUtilities.fillInTextField(SignupVarCXpathlocators.xpathLookup.get(screeningType + "_OTHER_NUM"),
					SignupVarCXpathlocators.dataLookup.get(dataset + "_passport_OTHER_NUM"));

			scriptUtilities.checkAndSelectDropDownById(SignupVarCXpathlocators.xpathLookup.get(screeningType + "_OTHER_NEWPERSONALADDRESS"),
					SignupVarCXpathlocators.dataLookup.get(dataset + "_passport_OTHER_NEWPERSONALADDRESS"));

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(SignupVarCXpathlocators.xpathLookup.get(screeningType + "_OTHER_NEWPOSTCODE"))));

			scriptUtilities.fillInTextField(SignupVarCXpathlocators.xpathLookup.get(screeningType + "_OTHER_NEWPOSTCODE"),
					SignupVarCXpathlocators.dataLookup.get(dataset + "_passport_OTHER_NEWPOSTCODE"));

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Enter address manually"))).click();
			/*
			 * scriptUtilities.click(By.id(SignupVarCXpathlocators.xpathLookup .get(screeningType + "_ENTERADDRESSMANUALLY"))); scriptUtilities.sleep(3000);
			 */

			scriptUtilities.fillInTextField(SignupVarCXpathlocators.xpathLookup.get(screeningType + "_OTHER_HOUSENAME"),
					SignupVarCXpathlocators.dataLookup.get(dataset + "_passport_OTHER_HOUSENAME"));

			scriptUtilities.fillInTextField(SignupVarCXpathlocators.xpathLookup.get(screeningType + "_OTHER_STREET"),
					SignupVarCXpathlocators.dataLookup.get(dataset + "_passport_OTHER_STREET"));

			scriptUtilities.fillInTextField(SignupVarCXpathlocators.xpathLookup.get(screeningType + "_OTHER_TOWN"),
					SignupVarCXpathlocators.dataLookup.get(dataset + "_passport_OTHER_TOWN"));

			scriptUtilities.click(By.id(SignupVarCXpathlocators.xpathLookup.get(screeningType + "_NEXT_BTN")));

		}

	}

	public void testcreateTMbillingDetailsPPage(final String rollOnType) throws InterruptedException {

		if (rollOnType == "MONTHLY") {

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SignupVarCXpathlocators.xpathLookup.get("SELECT_MONTHLY_PLAN"))));
			scriptUtilities.click(By.xpath(SignupVarCXpathlocators.xpathLookup.get("SELECT_MONTHLY_PLAN")));

			scriptUtilities.fillInTextField(SignupVarCXpathlocators.xpathLookup.get("CREDITCARD_NAME"),
					SignupVarCXpathlocators.dataLookup.get("creditcard_name"));

			scriptUtilities
					.fillInTextField(SignupVarCXpathlocators.xpathLookup.get("CREDITCARD_NUM"), SignupVarCXpathlocators.dataLookup.get("creditcard_num"));

			scriptUtilities.selectDropdown(By.id(SignupVarCXpathlocators.xpathLookup.get("CREDITCARD_MONTH")), 2);
			scriptUtilities.selectDropdown(By.id(SignupVarCXpathlocators.xpathLookup.get("CREDITCARD_YEAR")), 10);

			scriptUtilities.fillInTextField(SignupVarCXpathlocators.xpathLookup.get("CREDITCARD_SECURITY_CODE"),
					SignupVarCXpathlocators.dataLookup.get("creditcard_security"));

			scriptUtilities.click(By.id(SignupVarCXpathlocators.xpathLookup.get("CREDITCARD_CONFIRM_BTN")));

		}

		if (rollOnType == "ANNUAL") {

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SignupVarCXpathlocators.xpathLookup.get("SELECT_YEARLY_PLAN"))));

			scriptUtilities.click(By.xpath(SignupVarCXpathlocators.xpathLookup.get("SELECT_YEARLY_PLAN")));

			scriptUtilities.fillInTextField(SignupVarCXpathlocators.xpathLookup.get("CREDITCARD_NAME"),
					SignupVarCXpathlocators.dataLookup.get("creditcard_name"));

			scriptUtilities
					.fillInTextField(SignupVarCXpathlocators.xpathLookup.get("CREDITCARD_NUM"), SignupVarCXpathlocators.dataLookup.get("creditcard_num"));

			scriptUtilities.selectDropdown(By.id(SignupVarCXpathlocators.xpathLookup.get("CREDITCARD_MONTH")), 2);
			scriptUtilities.selectDropdown(By.id(SignupVarCXpathlocators.xpathLookup.get("CREDITCARD_YEAR")), 10);

			scriptUtilities.fillInTextField(SignupVarCXpathlocators.xpathLookup.get("CREDITCARD_SECURITY_CODE"),
					SignupVarCXpathlocators.dataLookup.get("creditcard_security"));

			scriptUtilities.click(By.id(SignupVarCXpathlocators.xpathLookup.get("CREDITCARD_CONFIRM_BTN")));

		}
	}

	public void testSagepayPage() throws InterruptedException {

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SignupVarCXpathlocators.xpathLookup.get("CREDITCARD_SUBMIT_BTN"))));

		scriptUtilities.click(By.xpath(SignupVarCXpathlocators.xpathLookup.get("CREDITCARD_SUBMIT_BTN")));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SignupVarCXpathlocators.xpathLookup.get("CREDITCARD_SUBMIT_BTN"))));

		scriptUtilities.fillInXpathField(SignupVarCXpathlocators.xpathLookup.get("CREDITCARD_3D_PASSWORD"),
				SignupVarCXpathlocators.dataLookup.get("creditcard_3d_password"));

		scriptUtilities.click(By.xpath(SignupVarCXpathlocators.xpathLookup.get("CREDITCARD_SUBMIT_BTN")));
	}

	public void testDrivingLicenseScreeningDetailsPage(final String uniqueEmailAccountName, final String screeningType) throws InterruptedException {

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(SignupVarCXpathlocators.xpathLookup.get(screeningType + "_NEXT_BTN"))));

		scriptUtilities.click(By.id(SignupVarCXpathlocators.xpathLookup.get(screeningType + "_NEXT_BTN")));

		scriptUtilities.fillInTextField(SignupVarCXpathlocators.xpathLookup.get(screeningType + "_FIRSTNAME"),
				SignupVarCXpathlocators.dataLookup.get("DL_FIRSTNAME"));

		scriptUtilities.fillInTextField(SignupVarCXpathlocators.xpathLookup.get(screeningType + "_LASTNAME"),
				SignupVarCXpathlocators.dataLookup.get("DL_LASTNAME"));

		scriptUtilities.checkAndSelectDropDownById(SignupVarCXpathlocators.xpathLookup.get(screeningType + "_DOB"),
				SignupVarCXpathlocators.dataLookup.get("DL_DOB"));
		Thread.sleep(1000);
		scriptUtilities.checkAndSelectDropDownById(SignupVarCXpathlocators.xpathLookup.get(screeningType + "_DOM"),
				SignupVarCXpathlocators.dataLookup.get("DL_DOM"));
		scriptUtilities.checkAndSelectDropDownById(SignupVarCXpathlocators.xpathLookup.get(screeningType + "_DOY"),
				SignupVarCXpathlocators.dataLookup.get("DL_DOY"));

		scriptUtilities.fillInTextField(SignupVarCXpathlocators.xpathLookup.get(screeningType + "_LICENSE_NUM"),
				SignupVarCXpathlocators.dataLookup.get("DL_LICENSE_NUM"));

		scriptUtilities.click(By.id(SignupVarCXpathlocators.xpathLookup.get(screeningType + "_NEXT_BTN")));

		Thread.sleep(2000);
	}

	public void testInductionwelcomePage() throws InterruptedException {

		this.wait = new WebDriverWait(driver, TIMEOUT_IN_SECONDS_INDUCTION_WELCOME);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SignupVarCXpathlocators.xpathLookup.get("WELCOME_HEADER"))));
		assertEquals(driver.findElement(By.xpath(SignupVarCXpathlocators.xpathLookup.get("WELCOME_HEADER"))).getText(), "Welcome to Rated People");
	}

	public boolean isThreeDSecurePageTimedOut() {
		return threeDSecurePageTimedOut;
	}

}
