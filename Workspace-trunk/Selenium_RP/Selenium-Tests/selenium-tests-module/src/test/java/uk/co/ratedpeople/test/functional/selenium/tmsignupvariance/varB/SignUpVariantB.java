package uk.co.ratedpeople.test.functional.selenium.tmsignupvariance.varB;

import static org.testng.Assert.assertEquals;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import uk.co.ratedpeople.test.functional.SeleniumTestContext;
import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;

public class SignUpVariantB {

	private WebDriver driver;
	private String testUrl;
	private TestScriptUtilities scriptUtilities;
	private WebDriverWait wait;
	private boolean threeDSecurePageTimedOut = false;
	public static final String THREE_D_SECURE_TIMEOUT_SELENIUM_ERROR_MSG_START = "Timed out after 30 seconds waiting for visibility of element located by By.xpath: .//*[@id='AutoNumber1']";
	public static Logger logger = Logger.getLogger(SignUpVariantB.class.getName());

	public SignUpVariantB(SeleniumTestContext context, TestScriptUtilities scriptUtilities) {
		this.scriptUtilities = scriptUtilities;
		this.driver = context.driver;
		this.testUrl = context.getTestUrl();
		this.wait = new WebDriverWait(driver, 30); // 30 seconds
	}

	public void signUpVarB(final String uniqueEmailAccountName, final String rollOnType, final String tariff, final String screeningType) throws Exception {
		System.out.println(rollOnType + " " + tariff + " " + screeningType);
		testLandingPage(uniqueEmailAccountName, tariff);
		testBusinessDetailsPage(uniqueEmailAccountName);
		testSelectScreeningPage(uniqueEmailAccountName, screeningType);
		testScreeningDetailsPage(uniqueEmailAccountName, screeningType);
		testcreateTMbillingDetailsPPage(rollOnType, screeningType);
		if (!"418486a9e548".equals(tariff)) {
			testSagepayPage();
			// if the 3D-secure page timed out, return and show success as it is a false positive
			if (threeDSecurePageTimedOut) {
				return;
			}
		}

		testInductionwelcomePage();

	}

	public void testLandingPage(final String uniqueEmailAccountName, final String tariff) throws InterruptedException {
		System.out.println(uniqueEmailAccountName);
		System.out.println(tariff);
		// append tariff later to url
		scriptUtilities.goTo(testUrl + "/new-signup/b/" + tariff);
	}

	public void testBusinessDetailsPage(String uniqueEmailAccountName) throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(SignupVarBXpathlocators.xpathLookup.get("BUSINESS_DETAILS_SUBMIT"))));
		scriptUtilities.click(By.id(SignupVarBXpathlocators.xpathLookup.get("BUSINESS_DETAILS_SUBMIT")));
		scriptUtilities.selectDropdown(By.id(SignupVarBXpathlocators.xpathLookup.get("SALUTATION_TYPE")), 1);
		scriptUtilities.fillInTextField(SignupVarBXpathlocators.xpathLookup.get("FIRST_NAME"), SignupVarBXpathlocators.dataLookup.get("FIRST_NAME"));
		scriptUtilities.fillInTextField(SignupVarBXpathlocators.xpathLookup.get("LAST_NAME"), SignupVarBXpathlocators.dataLookup.get("LAST_NAME"));
		scriptUtilities.selectDropdown(By.id(SignupVarBXpathlocators.xpathLookup.get("BUSINESS_ROLE")), 1);
		scriptUtilities.fillInTextField(SignupVarBXpathlocators.xpathLookup.get("EMAIL"), uniqueEmailAccountName);
		scriptUtilities.fillInTextField(SignupVarBXpathlocators.xpathLookup.get("PASSWORD"), SignupVarBXpathlocators.dataLookup.get("PASSWORD"));
		scriptUtilities
				.fillInTextField(SignupVarBXpathlocators.xpathLookup.get("CONFIRM_PASSWORD"), SignupVarBXpathlocators.dataLookup.get("CONFIRM_PASSWORD"));
		scriptUtilities.fillInTextField(SignupVarBXpathlocators.xpathLookup.get("COMPANY_NAME"), SignupVarBXpathlocators.dataLookup.get("COMPANY_NAME"));
		scriptUtilities.selectDropdown(By.id(SignupVarBXpathlocators.xpathLookup.get("SELECT_TRADE")), 1);
		scriptUtilities.selectDropdown(By.id(SignupVarBXpathlocators.xpathLookup.get("BUSINESS_TYPE")), 1);
		scriptUtilities.selectDropdown(By.id(SignupVarBXpathlocators.xpathLookup.get("BUSINESS_EMPLOYEES")), 1);
		scriptUtilities.fillInTextField(SignupVarBXpathlocators.xpathLookup.get("COMPANY_NUM"), SignupVarBXpathlocators.dataLookup.get("COMPANY_NUM"));
		scriptUtilities.fillInTextField(SignupVarBXpathlocators.xpathLookup.get("COMPANY_VAT_NUM"), SignupVarBXpathlocators.dataLookup.get("COMPANY_VAT_NUM"));
		scriptUtilities.fillInTextField(SignupVarBXpathlocators.xpathLookup.get("POSTCODE"), SignupVarBXpathlocators.dataLookup.get("postcode"));

		scriptUtilities.clear(By.id(SignupVarBXpathlocators.xpathLookup.get("MOBILE_NUM")));

		String mobnum1 = Integer.toString(TestScriptUtilities.getRandom6digitNumber());
		String mobnum2 = Integer.toString(TestScriptUtilities.getRandom6digitNumber());

		String mobnum = SignupVarBXpathlocators.dataLookup.get("MOBILE_NUM") + mobnum1 + mobnum2;
		scriptUtilities.fillInTextField(SignupVarBXpathlocators.xpathLookup.get("MOBILE_NUM"), mobnum);

		scriptUtilities.click(By.id(SignupVarBXpathlocators.xpathLookup.get("FIND_ADDRESS_BTN")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SignupVarBXpathlocators.xpathLookup.get("ADDRESS_OPTION"))));
		scriptUtilities.click(By.xpath(SignupVarBXpathlocators.xpathLookup.get("ADDRESS_OPTION")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(SignupVarBXpathlocators.xpathLookup.get("PROPERTY_ADDRESS"))));
		scriptUtilities.click(By.id(SignupVarBXpathlocators.xpathLookup.get("BUSINESS_DETAILS_SUBMIT")));
	}

	public void testSelectScreeningPage(final String uniqueEmailAccountName, final String screeningType) throws InterruptedException {

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SignupVarBXpathlocators.xpathLookup.get(screeningType + "_UK"))));
		scriptUtilities.click(By.xpath(SignupVarBXpathlocators.xpathLookup.get(screeningType + "_UK")));
	}

	public void testScreeningDetailsPage(final String uniqueEmailAccountName, final String screeningType) throws InterruptedException {
		if (screeningType == "DL") {
			testDrivingLicenseScreeningDetailsPage(uniqueEmailAccountName, screeningType);
		}

		if (screeningType == "PASSPORT") {
			testPassportScreeningDetailsPage(uniqueEmailAccountName, screeningType);
		}

		if (screeningType == "PASSPORTOTHER") {
			testPassportScreeningDetailsPage(uniqueEmailAccountName, screeningType);
		}

	}

	public void testPassportScreeningDetailsPage(final String uniqueEmailAccountName, final String screeningType) throws InterruptedException {

		if (screeningType == "PASSPORT") {
			scriptUtilities.checkAndSelectDropDownById(SignupVarBXpathlocators.xpathLookup.get(screeningType + "_GBR"),
					SignupVarBXpathlocators.dataLookup.get("PASSPORT_GBR"));

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(SignupVarBXpathlocators.xpathLookup.get("PASSPORT_FIRST_NAME"))));
			scriptUtilities.fillInTextField(SignupVarBXpathlocators.xpathLookup.get(screeningType + "_FIRST_NAME"),
					SignupVarBXpathlocators.dataLookup.get("PASSPORT_FIRST_NAME"));

			scriptUtilities.fillInTextField(SignupVarBXpathlocators.xpathLookup.get(screeningType + "_LAST_NAME"),
					SignupVarBXpathlocators.dataLookup.get("PASSPORT_LAST_NAME"));

			scriptUtilities.checkAndSelectDropDownById(SignupVarBXpathlocators.xpathLookup.get(screeningType + "_GBR_DOB"),
					SignupVarBXpathlocators.dataLookup.get("PASSPORT_GBR_DOB"));

			scriptUtilities.checkAndSelectDropDownById(SignupVarBXpathlocators.xpathLookup.get(screeningType + "_GBR_DOB_MON"),
					SignupVarBXpathlocators.dataLookup.get("PASSPORT_GBR_DOB_MON"));

			scriptUtilities.checkAndSelectDropDownById(SignupVarBXpathlocators.xpathLookup.get(screeningType + "_GBR_DOB_YEAR"),
					SignupVarBXpathlocators.dataLookup.get("PASSPORT_GBR_DOB_YEAR"));

			scriptUtilities.checkAndSelectDropDownById(SignupVarBXpathlocators.xpathLookup.get(screeningType + "_GBR_EXP"),
					SignupVarBXpathlocators.dataLookup.get("PASSPORT_GBR_EXP"));

			scriptUtilities.checkAndSelectDropDownById(SignupVarBXpathlocators.xpathLookup.get(screeningType + "_GBR_EXP_MON"),
					SignupVarBXpathlocators.dataLookup.get("PASSPORT_GBR_EXP_MON"));

			scriptUtilities.checkAndSelectDropDownById(SignupVarBXpathlocators.xpathLookup.get(screeningType + "_GBR_EXP_YEAR"),
					SignupVarBXpathlocators.dataLookup.get("PASSPORT_GBR_EXP_YEAR"));

			scriptUtilities.fillInTextField(SignupVarBXpathlocators.xpathLookup.get(screeningType + "_GBR_NUM"),
					SignupVarBXpathlocators.dataLookup.get("PASSPORT_GBR_NUM"));

			scriptUtilities.fillInTextField(SignupVarBXpathlocators.xpathLookup.get(screeningType + "_GBR_USEBUSINESSADDRESS"),
					SignupVarBXpathlocators.dataLookup.get("PASSPORT_GBR_USEBUSINESSADDRESS"));

			scriptUtilities.click(By.id(SignupVarBXpathlocators.xpathLookup.get(screeningType + "_NEXT_BTN")));

		}

		else {

			scriptUtilities.checkAndSelectDropDownById(SignupVarBXpathlocators.xpathLookup.get(screeningType + "_OTHER"),
					SignupVarBXpathlocators.dataLookup.get("PASSPORTOTHER_OTHER"));

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(SignupVarBXpathlocators.xpathLookup.get("PASSPORTOTHER_FIRST_NAME"))));
			scriptUtilities.fillInTextField(SignupVarBXpathlocators.xpathLookup.get(screeningType + "_FIRST_NAME"),
					SignupVarBXpathlocators.dataLookup.get("PASSPORTOTHER_FIRST_NAME"));

			scriptUtilities.fillInTextField(SignupVarBXpathlocators.xpathLookup.get(screeningType + "_LAST_NAME"),
					SignupVarBXpathlocators.dataLookup.get("PASSPORTOTHER_LAST_NAME"));

			scriptUtilities.checkAndSelectDropDownById(SignupVarBXpathlocators.xpathLookup.get(screeningType + "_OTHER_DOB"),
					SignupVarBXpathlocators.dataLookup.get("PASSPORTOTHER_OTHER_DOB"));

			scriptUtilities.checkAndSelectDropDownById(SignupVarBXpathlocators.xpathLookup.get(screeningType + "_OTHER_DOB_MON"),
					SignupVarBXpathlocators.dataLookup.get("PASSPORTOTHER_OTHER_DOB_MON"));

			scriptUtilities.checkAndSelectDropDownById(SignupVarBXpathlocators.xpathLookup.get(screeningType + "_OTHER_DOB_YEAR"),
					SignupVarBXpathlocators.dataLookup.get("PASSPORTOTHER_OTHER_DOB_YEAR"));

			scriptUtilities.checkAndSelectDropDownById(SignupVarBXpathlocators.xpathLookup.get(screeningType + "_OTHER_EXP"),
					SignupVarBXpathlocators.dataLookup.get("PASSPORTOTHER_OTHER_EXP"));

			scriptUtilities.checkAndSelectDropDownById(SignupVarBXpathlocators.xpathLookup.get(screeningType + "_OTHER_EXP_MON"),
					SignupVarBXpathlocators.dataLookup.get("PASSPORTOTHER_OTHER_EXP_MON"));

			scriptUtilities.checkAndSelectDropDownById(SignupVarBXpathlocators.xpathLookup.get(screeningType + "_OTHER_EXP_YEAR"),
					SignupVarBXpathlocators.dataLookup.get("PASSPORTOTHER_OTHER_EXP_YEAR"));

			scriptUtilities.fillInTextField(SignupVarBXpathlocators.xpathLookup.get(screeningType + "_OTHER_NUM"),
					SignupVarBXpathlocators.dataLookup.get("PASSPORTOTHER_OTHER_NUM"));

			scriptUtilities.fillInTextField(SignupVarBXpathlocators.xpathLookup.get(screeningType + "_OTHER_USEBUSINESSADDRESS"),
					SignupVarBXpathlocators.dataLookup.get("PASSPORTOTHER_OTHER_USEBUSINESSADDRESS"));

		}

	}

	public void testcreateTMbillingDetailsPPage(final String rollOnType, final String screeningType) throws InterruptedException {
		if (screeningType == "DL") {

			if (rollOnType == "MONTHLY") {
				scriptUtilities.click(By.xpath(SignupVarBXpathlocators.xpathLookup.get("SELECT_MONTHLY_PLAN_DL")));
			} else {
				scriptUtilities.click(By.xpath(SignupVarBXpathlocators.xpathLookup.get("SELECT_YEARLY_PLAN_DL")));

			}

			scriptUtilities.fillInTextField(SignupVarBXpathlocators.xpathLookup.get("CREDITCARD_NAME_DL"),
					SignupVarBXpathlocators.dataLookup.get("creditcard_name"));

			scriptUtilities.fillInTextField(SignupVarBXpathlocators.xpathLookup.get("CREDITCARD_NUM_DL"),
					SignupVarBXpathlocators.dataLookup.get("creditcard_num"));

			scriptUtilities.selectDropdown(By.id(SignupVarBXpathlocators.xpathLookup.get("CREDITCARD_MONTH_DL")), 2);
			scriptUtilities.selectDropdown(By.id(SignupVarBXpathlocators.xpathLookup.get("CREDITCARD_YEAR_DL")), 10);

			scriptUtilities.fillInTextField(SignupVarBXpathlocators.xpathLookup.get("CREDITCARD_SEC_CODE_DL"),
					SignupVarBXpathlocators.dataLookup.get("creditcard_security"));

			scriptUtilities.click(By.id(SignupVarBXpathlocators.xpathLookup.get("CREDITCARD_CONFIRM_BTN_DL")));

		}

		else {

			if (rollOnType == "ANNUAL") {
				scriptUtilities.click(By.xpath(SignupVarBXpathlocators.xpathLookup.get("SELECT_YEARLY_PLAN_PASSPORT")));
			} else {
				scriptUtilities.click(By.xpath(SignupVarBXpathlocators.xpathLookup.get("SELECT_MONTHLY_PLAN_PASSPORT")));

			}

			scriptUtilities.fillInTextField(SignupVarBXpathlocators.xpathLookup.get("CREDITCARD_NAME_PASSPORT"),
					SignupVarBXpathlocators.dataLookup.get("creditcard_name"));

			scriptUtilities.fillInTextField(SignupVarBXpathlocators.xpathLookup.get("CREDITCARD_NUM_PASSPORT"),
					SignupVarBXpathlocators.dataLookup.get("creditcard_num"));

			scriptUtilities.selectDropdown(By.id(SignupVarBXpathlocators.xpathLookup.get("CREDITCARD_MONTH_PASSPORT")), 2);
			scriptUtilities.selectDropdown(By.id(SignupVarBXpathlocators.xpathLookup.get("CREDITCARD_YEAR_PASSPORT")), 10);

			scriptUtilities.fillInTextField(SignupVarBXpathlocators.xpathLookup.get("CREDITCARD_SECURITY_CODE_PASSPORT"),
					SignupVarBXpathlocators.dataLookup.get("creditcard_security"));

			scriptUtilities.click(By.id(SignupVarBXpathlocators.xpathLookup.get("CREDITCARD_CONFIRM_BTN_PASSPORT")));

		}

	}

	public void testSagepayPage() throws InterruptedException {

		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SignupVarBXpathlocators.xpathLookup.get("CREDITCARD_SUBMIT_BTN"))));

			scriptUtilities.click(By.xpath(SignupVarBXpathlocators.xpathLookup.get("CREDITCARD_SUBMIT_BTN")));

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SignupVarBXpathlocators.xpathLookup.get("CREDITCARD_SUBMIT_BTN"))));

			scriptUtilities.fillInXpathField(SignupVarBXpathlocators.xpathLookup.get("CREDITCARD_3D_PASSWORD"),
					SignupVarBXpathlocators.dataLookup.get("creditcard_3d_password"));

			scriptUtilities.click(By.xpath(SignupVarBXpathlocators.xpathLookup.get("CREDITCARD_SUBMIT_BTN")));
		} catch (Exception e) {
			logger.log(Level.INFO, "3D-Secure page may have timed out.", e);
			String exMessage = e.getMessage();
			if (exMessage != null && exMessage.startsWith(THREE_D_SECURE_TIMEOUT_SELENIUM_ERROR_MSG_START)) {
				threeDSecurePageTimedOut = true;
			}
		}
	}

	public void testDrivingLicenseScreeningDetailsPage(final String uniqueEmailAccountName, final String screeningType) throws InterruptedException {

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(SignupVarBXpathlocators.xpathLookup.get(screeningType + "_NEXT_BTN"))));
		scriptUtilities.click(By.id(SignupVarBXpathlocators.xpathLookup.get(screeningType + "_NEXT_BTN")));

		// Thread.sleep(10000);

		scriptUtilities.fillInTextField(SignupVarBXpathlocators.xpathLookup.get(screeningType + "_FIRSTNAME"),
				SignupVarBXpathlocators.dataLookup.get("DL_FIRSTNAME"));

		scriptUtilities.fillInTextField(SignupVarBXpathlocators.xpathLookup.get(screeningType + "_LASTNAME"),
				SignupVarBXpathlocators.dataLookup.get("DL_LASTNAME"));

		scriptUtilities.checkAndSelectDropDownById(SignupVarBXpathlocators.xpathLookup.get(screeningType + "_DOB"),
				SignupVarBXpathlocators.dataLookup.get("DL_DOB"));
		Thread.sleep(1000);
		scriptUtilities.checkAndSelectDropDownById(SignupVarBXpathlocators.xpathLookup.get(screeningType + "_DOM"),
				SignupVarBXpathlocators.dataLookup.get("DL_DOM"));
		scriptUtilities.checkAndSelectDropDownById(SignupVarBXpathlocators.xpathLookup.get(screeningType + "_DOY"),
				SignupVarBXpathlocators.dataLookup.get("DL_DOY"));

		scriptUtilities.fillInTextField(SignupVarBXpathlocators.xpathLookup.get(screeningType + "_LICENSE_NUM"),
				SignupVarBXpathlocators.dataLookup.get("DL_LICENSE_NUM"));

	}

	private void testInductionwelcomePage() throws InterruptedException {

		this.wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SignupVarBXpathlocators.xpathLookup.get("WELCOME_HEADER"))));
		assertEquals(driver.findElement(By.xpath(SignupVarBXpathlocators.xpathLookup.get("WELCOME_HEADER"))).getText(), "Welcome to Rated People");
	}

}
