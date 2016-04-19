package uk.co.ratedpeople.test.functional.selenium.tmsignupvariance.varE;

import static org.testng.Assert.assertEquals;

import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import uk.co.ratedpeople.test.functional.SeleniumTestContext;
import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;

public class SignupVar_E_ScreeningDetailsPage_PASSPORTGBR_Negative {
	
	private SignUpVariantE signUpVariantE;
	private WebDriver driver;
	
	
	
	private String testUrl;
	private TestScriptUtilities scriptUtilities;
	private WebDriverWait wait;

	public static Logger logger = Logger.getLogger(SignupVar_E_ScreeningDetailsPage_PASSPORTGBR_Negative.class.getName());

	public SignupVar_E_ScreeningDetailsPage_PASSPORTGBR_Negative(SeleniumTestContext context, TestScriptUtilities scriptUtilities) {
		
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
	public String testScreeningDetailsPage(final String field, final String value, final String screeningType) {		// landing page
		String errorPath = null;

	scriptUtilities.clear(By.id(SignupVarEXpathlocators.xpathLookup.get(screeningType + "_POSTCODE")));
	scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get(screeningType + "_POSTCODE"),
			SignupVarEXpathlocators.dataLookup.get("preprod_passportGbr_postcode"));
	scriptUtilities.click(By.id(SignupVarEXpathlocators.xpathLookup.get(screeningType + "_FIND_ADDRESS_BTN")));

	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SignupVarEXpathlocators.xpathLookup.get("PASSPORT_OPTION_FIND_ADDRESS"))));
	scriptUtilities.click(By.xpath(SignupVarEXpathlocators.xpathLookup.get(screeningType + "_OPTION_FIND_ADDRESS")));
	scriptUtilities.click(By.id(SignupVarEXpathlocators.xpathLookup.get(screeningType + "_CONFIRM_BTN")));	 
	assertEquals(driver.findElement(By.xpath(".//*[@id='passportDetailsScreeningForm']/div[1]/em")).getText(), "Please select a Passport Country of Origin");
	assertEquals(driver.findElement(By.xpath(".//*[@id='passportDetailsScreeningForm']/div[7]/em")).getText(), "Please select a title");
	scriptUtilities.selectDropdown(By.id(SignupVarEXpathlocators.xpathLookup.get("SELECT_PASSPORT")), 2);
	scriptUtilities.selectDropdown(SignupVarEXpathlocators.xpathLookup.get("PASSPORTGBR_SALUTATION_TYPE"), 1);	
	
	if (field.equalsIgnoreCase("PASSPORTGBR_NUM1")) {
		scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("PASSPORTGBR_NUM1"), value);
		errorPath = SignupVarEXpathlocators.xpathLookup.get("PASSPORTGBR_NUM1_ERROR");
	} else {
		scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("PASSPORTGBR_NUM1"), SignupVarEXpathlocators.dataLookup.get("preprod_passportGbr_num1"));
	}
	
	if (field.equalsIgnoreCase("PASSPORTGBR_NUM2")) {
		scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("PASSPORTGBR_NUM2"), value);
		errorPath = SignupVarEXpathlocators.xpathLookup.get("PASSPORTGBR_NUM2_ERROR");
	} else {
		scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("PASSPORTGBR_NUM2"), SignupVarEXpathlocators.dataLookup.get("preprod_passportGbr_num2"));
	}
	
	if (field.equalsIgnoreCase("PASSPORTGBR_NUM3")) {
		scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("PASSPORTGBR_NUM3"), value);
		errorPath = SignupVarEXpathlocators.xpathLookup.get("PASSPORTGBR_NUM3_ERROR");
	} else {
		scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("PASSPORTGBR_NUM3"), SignupVarEXpathlocators.dataLookup.get("preprod_passportGbr_num3"));
	}
	
	if (field.equalsIgnoreCase("PASSPORTGBR_NUM4")) {
		scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("PASSPORTGBR_NUM4"), value);
		errorPath = SignupVarEXpathlocators.xpathLookup.get("PASSPORTGBR_NUM4_ERROR");
	} else {
		scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("PASSPORTGBR_NUM4"), SignupVarEXpathlocators.dataLookup.get("preprod_passportGbr_num4"));
	}
	
	if (field.equalsIgnoreCase("PASSPORTGBR_NUM5")) {
		scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("PASSPORTGBR_NUM5"), value);
		errorPath = SignupVarEXpathlocators.xpathLookup.get("PASSPORTGBR_NUM5_ERROR");
	} else {
		scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("PASSPORTGBR_NUM5"), SignupVarEXpathlocators.dataLookup.get("preprod_passportGbr_num5"));
	}
	
	if (field.equalsIgnoreCase("PASSPORTGBR_NUM6")) {
		scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("PASSPORTGBR_NUM6"), value);
		errorPath = SignupVarEXpathlocators.xpathLookup.get("PASSPORTGBR_NUM6_ERROR");
	} else {
		scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("PASSPORTGBR_NUM6"), SignupVarEXpathlocators.dataLookup.get("preprod_passportGbr_num6"));
	}
	
	if (field.equalsIgnoreCase("PASSPORTGBR_EXPDAY")) {
		scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("PASSPORTGBR_EXPDAY"), value);
		errorPath = SignupVarEXpathlocators.xpathLookup.get("PASSPORTGBR_EXPDAY_ERROR");
	} else {
		scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("PASSPORTGBR_EXPDAY"), SignupVarEXpathlocators.dataLookup.get("preprod_passportGbr_exp_day"));
	}
	
	if (field.equalsIgnoreCase("PASSPORTGBR_EXPMON")) {
		scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("PASSPORTGBR_EXPMON"), value);
		errorPath = SignupVarEXpathlocators.xpathLookup.get("PASSPORTGBR_EXPMON_ERROR");
	} else {
		scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("PASSPORTGBR_EXPMON"), SignupVarEXpathlocators.dataLookup.get("preprod_passportGbr_exp_mon"));
	}
	
	if (field.equalsIgnoreCase("PASSPORTGBR_EXPYEAR")) {
		scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("PASSPORTGBR_EXPYEAR"), value);
		errorPath = SignupVarEXpathlocators.xpathLookup.get("PASSPORTGBR_EXPYEAR_ERROR");
	} else {
		scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("PASSPORTGBR_EXPYEAR"), SignupVarEXpathlocators.dataLookup.get("preprod_passportGbr_exp_year"));
	}
	
	if (field.equalsIgnoreCase("PASSPORTGBR_DOB_DAY")) {
		scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("PASSPORTGBR_DOB_DAY"), value);
		errorPath = SignupVarEXpathlocators.xpathLookup.get("PASSPORTGBR_DOB_DAY_ERROR");
	} else {
		scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("PASSPORTGBR_DOB_DAY"), SignupVarEXpathlocators.dataLookup.get("preprod_passportGbr_dob_day"));
	}
	
	if (field.equalsIgnoreCase("PASSPORTGBR_DOB_MONTH")) {
		scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("PASSPORTGBR_DOB_MONTH"), value);
		errorPath = SignupVarEXpathlocators.xpathLookup.get("PASSPORTGBR_DOB_MONTH_ERROR");
	} else {
		scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("PASSPORTGBR_DOB_MONTH"), SignupVarEXpathlocators.dataLookup.get("preprod_passportGbr_dob_mon"));
	}
	
	if (field.equalsIgnoreCase("PASSPORTGBR_DOB_YEAR")) {
		scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("PASSPORTGBR_DOB_YEAR"), value);
		errorPath = SignupVarEXpathlocators.xpathLookup.get("PASSPORTGBR_DOB_YEAR_ERROR");
	} else {
		scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("PASSPORTGBR_DOB_YEAR"), SignupVarEXpathlocators.dataLookup.get("preprod_passportGbr_dob_year"));
	}
	
	if (field.equalsIgnoreCase("PASSPORTGBR_FIRST_NAME")) {
		scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("PASSPORTGBR_FIRST_NAME"), value);
		errorPath = SignupVarEXpathlocators.xpathLookup.get("PASSPORTGBR_FIRST_NAME_ERROR");
	} else {
		scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("PASSPORTGBR_FIRST_NAME"), SignupVarEXpathlocators.dataLookup.get("preprod_passportGbr_firstname"));
	}
	
	if (field.equalsIgnoreCase("PASSPORTGBR_LAST_NAME")) {
		scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("PASSPORTGBR_LAST_NAME"), value);
		errorPath = SignupVarEXpathlocators.xpathLookup.get("PASSPORTGBR_LAST_NAME_ERROR");
	} else {
		scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("PASSPORTGBR_LAST_NAME"), SignupVarEXpathlocators.dataLookup.get("preprod_passportGbr_firstname"));
	}
	
	scriptUtilities.click(By.id(SignupVarEXpathlocators.xpathLookup.get(screeningType + "_CONFIRM_BTN")));

	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(errorPath)));
	return scriptUtilities.findElement(By.xpath(errorPath)).getText();
	
	
	
	}

}
