package uk.co.ratedpeople.test.functional.selenium.tmsignupvariance.varE;

import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import uk.co.ratedpeople.test.functional.SeleniumTestContext;
import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;

public class SignupVar_E_ScreeningDetailsPage_DL_Negative {

	private SignUpVariantE signUpVariantE;
	private WebDriver driver;
	private String testUrl;
	private TestScriptUtilities scriptUtilities;
	private WebDriverWait wait;

	public static Logger logger = Logger.getLogger(SignupVar_E_ScreeningDetailsPage_DL_Negative.class.getName());

	public SignupVar_E_ScreeningDetailsPage_DL_Negative(SeleniumTestContext context, TestScriptUtilities scriptUtilities) {
		signUpVariantE = new SignUpVariantE(context, scriptUtilities);
		this.scriptUtilities = scriptUtilities;
		this.driver = context.driver;
		this.testUrl = context.getTestUrl();
		this.testUrl = testUrl.replaceAll("http://", "https://");
		this.wait = new WebDriverWait(driver, 30); // 30 seconds
	}

	public String signUpVarE(final String rollOnType, final String tariff, final String screeningType, final String uniqueEmailAccountName, final String field,
			final String value) throws Exception {

		System.out.println(rollOnType + " " + tariff + " " + screeningType);
		System.out.println("Target environment: " + this.testUrl);

		signUpVariantE.testLandingPage(tariff);
		signUpVariantE.testSelectTradesPage();
		signUpVariantE.testSelectWorkareaPage();
		signUpVariantE.testBusinessDetailsPage(uniqueEmailAccountName, tariff);
		signUpVariantE.testSelectScreeningPage(uniqueEmailAccountName, screeningType);
		return testScreeningDetailsPage(field, value, screeningType);
	}

	public String testScreeningDetailsPage(final String field, final String value, final String screeningType) {
		// landing page
		String errorPath = null;

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(SignupVarEXpathlocators.xpathLookup.get(screeningType + "_FIND_ADDRESS"))));
		scriptUtilities.click(By.id(SignupVarEXpathlocators.xpathLookup.get(screeningType + "_FIND_ADDRESS")));
		// Thread.sleep(10000);
		scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get(screeningType + "_POSTCODE"),
				SignupVarEXpathlocators.dataLookup.get("postcode"));
		scriptUtilities.click(By.id(SignupVarEXpathlocators.xpathLookup.get(screeningType + "_FIND_ADDRESS")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SignupVarEXpathlocators.xpathLookup.get("DL_OPTION_FIND_ADDRESS"))));
		scriptUtilities.click(By.xpath(SignupVarEXpathlocators.xpathLookup.get("DL_OPTION_FIND_ADDRESS")));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(SignupVarEXpathlocators.xpathLookup.get(screeningType + "_CONFIRM_BTN"))));
		scriptUtilities.click(By.id(SignupVarEXpathlocators.xpathLookup.get(screeningType + "_CONFIRM_BTN")));

		if (field.equalsIgnoreCase("DL_NUM1")) {
			scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("DL_NUM1"), value);
			errorPath = SignupVarEXpathlocators.xpathLookup.get("DL_NUM1_ERROR");
		} else {
			scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("DL_NUM1"), SignupVarEXpathlocators.dataLookup.get("dl_num1"));
		}

		if (field.equalsIgnoreCase("DL_NUM2")) {
			scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("DL_NUM2"), value);
			errorPath = SignupVarEXpathlocators.xpathLookup.get("DL_NUM2_ERROR");
		} else {
			scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("DL_NUM2"), SignupVarEXpathlocators.dataLookup.get("dl_num2"));

		}

		if (field.equalsIgnoreCase("DL_NUM3")) {
			scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("DL_NUM3"), value);
			errorPath = SignupVarEXpathlocators.xpathLookup.get("DL_NUM3_ERROR");
		} else {
			scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("DL_NUM3"), SignupVarEXpathlocators.dataLookup.get("dl_num3"));

		}

		if (field.equalsIgnoreCase("DL_NUM4")) {
			scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("DL_NUM4"), value);
			errorPath = SignupVarEXpathlocators.xpathLookup.get("DL_NUM4_ERROR");
		} else {
			scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("DL_NUM4"), SignupVarEXpathlocators.dataLookup.get("dl_num4"));

		}

		if (!field.equalsIgnoreCase("DL_DOB")) {
			scriptUtilities.selectDropdown(By.id(SignupVarEXpathlocators.xpathLookup.get("DL_DOB")), 2);
		} else {
			errorPath = SignupVarEXpathlocators.xpathLookup.get("DL_DOB_ERROR");
		}

		if (!field.equalsIgnoreCase("DL_DOM")) {
			scriptUtilities.selectDropdown(By.id(SignupVarEXpathlocators.xpathLookup.get("DL_DOM")), 2);
		} else {
			errorPath = SignupVarEXpathlocators.xpathLookup.get("DL_DOM_ERROR");
		}

		if (!field.equalsIgnoreCase("DL_DOY")) {
			scriptUtilities.selectDropdown(By.id(SignupVarEXpathlocators.xpathLookup.get("DL_DOY")), 22);
		} else {
			errorPath = SignupVarEXpathlocators.xpathLookup.get("DL_DOY_ERROR");
		}

		if (field.equalsIgnoreCase("DL_FIRSTNAME")) {
			scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("DL_FIRSTNAME"), value);
			errorPath = SignupVarEXpathlocators.xpathLookup.get("DL_FIRSTNAME_ERROR");
		} else {
			scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("DL_FIRSTNAME"), SignupVarEXpathlocators.dataLookup.get("dl_firstname"));
		}

		if (field.equalsIgnoreCase("DL_LASTNAME")) {
			scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("DL_LASTNAME"), value);
			errorPath = SignupVarEXpathlocators.xpathLookup.get("DL_LASTNAME_ERROR");
		} else {
			scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("DL_LASTNAME"), SignupVarEXpathlocators.dataLookup.get("dl_lastname"));
		}

		if (!field.equalsIgnoreCase("DL_SALUTATION_TYPE")) {
			scriptUtilities.selectDropdown(By.id(SignupVarEXpathlocators.xpathLookup.get("DL_SALUTATION_TYPE")), 1);
		} else {
			errorPath = SignupVarEXpathlocators.xpathLookup.get("DL_SALUTATION_TYPE_ERROR");
		}

		scriptUtilities.click(By.id(SignupVarEXpathlocators.xpathLookup.get("CREDITCARD_CONFIRM_BTN")));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(errorPath)));
		return scriptUtilities.findElement(By.xpath(errorPath)).getText();
	}

}
