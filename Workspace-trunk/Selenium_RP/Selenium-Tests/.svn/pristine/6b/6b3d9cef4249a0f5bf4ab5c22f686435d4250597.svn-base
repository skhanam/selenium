package uk.co.ratedpeople.test.functional.selenium.tmsignupvariance.varE;

import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import uk.co.ratedpeople.test.functional.SeleniumTestContext;
import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;

public class SignUpVariant_E_BillingPage_Negative {

	private WebDriver driver;
	private String testUrl;
	private TestScriptUtilities scriptUtilities;
	private SignUpVariantE signUpVariantE;
	private WebDriverWait wait;

	public static Logger logger = Logger.getLogger(SignUpVariant_E_BillingPage_Negative.class.getName());

	public SignUpVariant_E_BillingPage_Negative(SeleniumTestContext context, TestScriptUtilities scriptUtilities) {

		signUpVariantE = new SignUpVariantE(context, scriptUtilities);
		this.scriptUtilities = scriptUtilities;
		this.driver = context.driver;
		this.testUrl = context.getTestUrl();
		this.testUrl = testUrl.replaceAll("http://", "https://");
		this.wait = new WebDriverWait(driver, 30); // 30 seconds
	}

	public String signUp(final String rollOnType, final String tariff, final String screeningType, final String uniqueEmailAccountName, final String field,
			final String value) throws Exception {
		System.out.println(rollOnType + " " + tariff + " " + screeningType);
		System.out.println("Target environment: " + this.testUrl);

		signUpVariantE.testLandingPage(tariff);
		signUpVariantE.testSelectTradesPage();
		signUpVariantE.testSelectWorkareaPage();
		signUpVariantE.testBusinessDetailsPage(uniqueEmailAccountName,tariff);
		signUpVariantE.testSelectScreeningPage(uniqueEmailAccountName, screeningType);
		signUpVariantE.testScreeningDetailsPage(uniqueEmailAccountName, screeningType);
		signUpVariantE.testSelectPlanPage(uniqueEmailAccountName, screeningType, rollOnType);
		return testBillingPage(field, value);

	}

	public String testBillingPage(final String field, final String value) {
		// landing page
		String errorPath = null;

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(SignupVarEXpathlocators.xpathLookup.get("CREDITCARD_CONFIRM_BTN"))));
		scriptUtilities.click(By.id(SignupVarEXpathlocators.xpathLookup.get("CREDITCARD_CONFIRM_BTN")));
		if (field.equalsIgnoreCase("CREDITCARD_NAME")) {
			scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("CREDITCARD_NAME"), value);
			errorPath = SignupVarEXpathlocators.xpathLookup.get("SELECT_BILLING_CARD_NAME_ERROR");
		} else {
			scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("CREDITCARD_NAME"),
					SignupVarEXpathlocators.dataLookup.get("creditcard_name"));
		}
		if (field.equalsIgnoreCase("CREDITCARD_NUM")) {
			scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("CREDITCARD_NUM"), value);
			errorPath = SignupVarEXpathlocators.xpathLookup.get("SELECT_BILLING_CARD_NUMBER_ERROR");
		} else {
			scriptUtilities
					.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("CREDITCARD_NUM"), SignupVarEXpathlocators.dataLookup.get("creditcard_num"));
		}
		if (!field.equalsIgnoreCase("CREDITCARD_MONTH")) {
			scriptUtilities.selectDropdown(By.id(SignupVarEXpathlocators.xpathLookup.get("CREDITCARD_MONTH")), 2);
		} else {
			errorPath = SignupVarEXpathlocators.xpathLookup.get("SELECT_BILLING_CARD_MONTH_ERROR");
		}
		if (!field.equalsIgnoreCase("CREDITCARD_YEAR")) {
			scriptUtilities.selectDropdown(By.id(SignupVarEXpathlocators.xpathLookup.get("CREDITCARD_YEAR")), 5);
		} else {
			if (value != null) {
				scriptUtilities.selectDropdown(By.id(SignupVarEXpathlocators.xpathLookup.get("CREDITCARD_YEAR")), Integer.parseInt(value));
				errorPath = SignupVarEXpathlocators.xpathLookup.get("SELECT_BILLING_CARD_YEAR2_ERROR");
			} else {
				errorPath = SignupVarEXpathlocators.xpathLookup.get("SELECT_BILLING_CARD_YEAR1_ERROR");
			}
		}
		if (field.equalsIgnoreCase("CREDITCARD_SECURITY_CODE")) {
			scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("CREDITCARD_SECURITY_CODE"), value);
			errorPath = SignupVarEXpathlocators.xpathLookup.get("SELECT_BILLING_CARD_CVV_ERROR");
		} else {
			scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("CREDITCARD_SECURITY_CODE"),
					SignupVarEXpathlocators.dataLookup.get("creditcard_security"));
		}
		scriptUtilities.click(By.id(SignupVarEXpathlocators.xpathLookup.get("CREDITCARD_CONFIRM_BTN")));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(errorPath)));
		return scriptUtilities.findElement(By.xpath(errorPath)).getText();
	}
}
