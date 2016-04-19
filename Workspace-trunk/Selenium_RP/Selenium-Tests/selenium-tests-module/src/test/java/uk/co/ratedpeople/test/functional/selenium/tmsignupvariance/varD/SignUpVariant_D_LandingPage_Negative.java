package uk.co.ratedpeople.test.functional.selenium.tmsignupvariance.varD;

/*     
@Author ARAVIND                 
*/
import java.util.logging.Logger;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import uk.co.ratedpeople.UniqueEmailAddressGenerator;
import uk.co.ratedpeople.test.functional.SeleniumTestContext;
import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;
import uk.co.ratedpeople.test.functional.selenium.tmsignupvariance.varD.SignupVarDXpathlocators;

public class SignUpVariant_D_LandingPage_Negative {
	
	private WebDriver driver;
	private String testUrl;
	private TestScriptUtilities scriptUtilities;
	private WebDriverWait wait;
	

	public static Logger logger = Logger.getLogger(SignUpVariantD.class.getName());
	public static final String THREE_D_SECURE_TIMEOUT_SELENIUM_ERROR_MSG_START = "Timed out after 30 seconds waiting for visibility of element located by By.xpath: .//*[@id='AutoNumber1']";

	public SignUpVariant_D_LandingPage_Negative(SeleniumTestContext context, TestScriptUtilities scriptUtilities) {
		this.scriptUtilities = scriptUtilities;
		this.driver = context.driver;
		this.testUrl = context.getTestUrl();
		this.wait = new WebDriverWait(driver, 30); // 30 seconds
			}

	
	
	public void pageBusinessDetails(final String uniqueEmailAccountName, final String rollOnType, final String tariff, final String screeningType) throws InterruptedException {
		System.out.println(rollOnType + " " + tariff + " " + screeningType);
		testLandingPage(uniqueEmailAccountName, tariff);
	}

	public void testLandingPage(final String uniqueEmailAccountName, final String tariff) throws InterruptedException {
		System.out.println(uniqueEmailAccountName);
		System.out.println(tariff);
		// append tariff later to url
		scriptUtilities.goTo(testUrl + "/new-signup/d/" + tariff);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(SignupVarDXpathlocators.xpathLookup.get("SALUTATION_TYPE"))));
		
	}
	public void testBusinessDetailsPage(final String uniqueEmailAccountName, final String rollOnType, final String tariff, final String screeningType) throws InterruptedException {	
		pageBusinessDetails(uniqueEmailAccountName, rollOnType, tariff, screeningType);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(SignupVarDXpathlocators.xpathLookup.get("BUSINESS_DETAILS_SUBMIT"))));
		scriptUtilities.click(By.id(SignupVarDXpathlocators.xpathLookup.get("BUSINESS_DETAILS_SUBMIT")));		
		Thread.sleep(5000);		
		assertEquals(driver.findElement(By.xpath(SignupVarDXpathlocators.xpathLookup.get("SALUTATION_TYPE_ERRORMESSAGEXPATH"))).getText(),
				SignupVarDXpathlocators.dataLookup.get("SALUTATION_TYPE_ERRORMESSAGE"));
		assertEquals(driver.findElement(By.xpath(SignupVarDXpathlocators.xpathLookup.get("FIRST_NAME_ERRORMESSAGEXPATH"))).getText(),
				SignupVarDXpathlocators.dataLookup.get("FIRST_NAME_ERRORMESSAGE"));
		assertEquals(driver.findElement(By.xpath(SignupVarDXpathlocators.xpathLookup.get("LAST_NAME_ERRORMESSAGEXPATH"))).getText(),
				SignupVarDXpathlocators.dataLookup.get("LAST_NAME_ERRORMESSAGE"));
		assertEquals(driver.findElement(By.xpath(SignupVarDXpathlocators.xpathLookup.get("SELECT_TRADE_ERRORMESSAGEXPATH"))).getText(),
				SignupVarDXpathlocators.dataLookup.get("SELECT_TRADE_ERRORMESSAGE"));
		assertEquals(driver.findElement(By.xpath(SignupVarDXpathlocators.xpathLookup.get("POSTCODE_ERRORMESSAGEXPATH"))).getText(),
				SignupVarDXpathlocators.dataLookup.get("POSTCODE_ERRORMESSAGE"));
		assertEquals(driver.findElement(By.xpath(SignupVarDXpathlocators.xpathLookup.get("EMAIL_ERRORMESSAGEXPATH"))).getText(),
				SignupVarDXpathlocators.dataLookup.get("EMAIL_ERRORMESSAGE"));
		assertEquals(driver.findElement(By.xpath(SignupVarDXpathlocators.xpathLookup.get("BUSINESS_ROLE_ERRORMESSAGEXPATH"))).getText(),
				SignupVarDXpathlocators.dataLookup.get("BUSINESS_ROLE_ERRORMESSAGE"));
		assertEquals(driver.findElement(By.xpath(SignupVarDXpathlocators.xpathLookup.get("PASSWORD_ERRORMESSAGEXPATH"))).getText(),
				SignupVarDXpathlocators.dataLookup.get("PASSWORD_ERRORMESSAGE"));
		assertEquals(driver.findElement(By.xpath(SignupVarDXpathlocators.xpathLookup.get("CONFIRM_PASSWORD_ERRORMESSAGEXPATH"))).getText(),
				SignupVarDXpathlocators.dataLookup.get("CONFIRM_PASSWORD_ERRORMESSAGE"));
		assertEquals(driver.findElement(By.xpath(SignupVarDXpathlocators.xpathLookup.get("COMPANY_NAME_ERRORMESSAGEXPATH"))).getText(),
				SignupVarDXpathlocators.dataLookup.get("COMPANY_NAME_ERRORMESSAGE"));
		assertEquals(driver.findElement(By.xpath(SignupVarDXpathlocators.xpathLookup.get("BUSINESS_TYPE_ERRORMESSAGEXPATH"))).getText(),
				SignupVarDXpathlocators.dataLookup.get("BUSINESS_TYPE_ERRORMESSAGE"));
		assertEquals(driver.findElement(By.xpath(SignupVarDXpathlocators.xpathLookup.get("BUSINESS_EMPLOYEES_ERRORMESSAGEXPATH"))).getText(),
				SignupVarDXpathlocators.dataLookup.get("BUSINESS_EMPLOYEES_ERRORMESSAGE"));		
		assertEquals(driver.findElement(By.xpath(SignupVarDXpathlocators.xpathLookup.get("MOBILE_NUM_ERRORMESSAGEXPATH"))).getText(),
				SignupVarDXpathlocators.dataLookup.get("MOBILE_NUM_ERRORMESSAGE"));	
		
	}
	
	public String testCompanyName(final String uniqueEmailAccountName,final String rollOnType, final String tariff, final String screeningType,final String companyName) throws InterruptedException {
		pageBusinessDetails(uniqueEmailAccountName, rollOnType, tariff, screeningType);
		scriptUtilities.fillInTextField(SignupVarDXpathlocators.xpathLookup.get("COMPANY_NAME"), companyName);
		scriptUtilities.click(By.id(SignupVarDXpathlocators.xpathLookup.get("BUSINESS_DETAILS_SUBMIT")));	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SignupVarDXpathlocators.xpathLookup.get("COMPANY_NAME_ERRORMESSAGEXPATH"))));
		return scriptUtilities.findElement(By.xpath(SignupVarDXpathlocators.xpathLookup.get("COMPANY_NAME_ERRORMESSAGEXPATH"))).getText();		
		}
	
	public String signUpVarDNegative(final String rollOnType, final String tariff, final String screeningType, final String uniqueEmailAccountName, final String field,
			final String value) throws Exception {		
	

		pageBusinessDetails(uniqueEmailAccountName, rollOnType, tariff,screeningType);		
		return testBusinessDetailsPage(field, value, screeningType);

	}

	public String testBusinessDetailsPage(final String field, final String value, final String screeningType) throws InterruptedException  { // landing page
		String errorPath = null;

		String uniqueEmailAccountName = new UniqueEmailAddressGenerator().generateUniqueEmailAddress();

		String mobnum1 = Integer.toString(TestScriptUtilities.getRandom6digitNumber());
		String mobnum2 = Integer.toString(TestScriptUtilities.getRandom6digitNumber());

		String mobnum = SignupVarDXpathlocators.dataLookup.get("MOBILE_NUM") + mobnum1 + mobnum2;		
		scriptUtilities.fillInTextField(SignupVarDXpathlocators.xpathLookup.get("POSTCODE"), SignupVarDXpathlocators.dataLookup.get("postcode"));
		scriptUtilities.click(By.id(SignupVarDXpathlocators.xpathLookup.get("FIND_ADDRESS_BTN")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SignupVarDXpathlocators.xpathLookup.get("ADDRESS_OPTION"))));
		scriptUtilities.click(By.xpath(SignupVarDXpathlocators.xpathLookup.get("ADDRESS_OPTION")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(SignupVarDXpathlocators.xpathLookup.get("PROPERTY_ADDRESS"))));
		
		
		if (field.equalsIgnoreCase("SALUTATION_TYPE")) {
			scriptUtilities.fillInTextField(SignupVarDXpathlocators.xpathLookup.get("SALUTATION_TYPE"), value);
			errorPath = SignupVarDXpathlocators.xpathLookup.get("SALUTATION_TYPE_ERRORMESSAGEXPATH");
		} else {
			scriptUtilities.fillInTextField(SignupVarDXpathlocators.xpathLookup.get("SALUTATION_TYPE"),
					SignupVarDXpathlocators.dataLookup.get("SALUTATION_TYPE"));
		}
		
		if (field.equalsIgnoreCase("FIRST_NAME")) {
			scriptUtilities.fillInTextField(SignupVarDXpathlocators.xpathLookup.get("FIRST_NAME"), value);
			errorPath = SignupVarDXpathlocators.xpathLookup.get("FIRST_NAME_ERRORMESSAGEXPATH");
		} else {
			scriptUtilities.fillInTextField(SignupVarDXpathlocators.xpathLookup.get("FIRST_NAME"),
					SignupVarDXpathlocators.dataLookup.get("FIRST_NAME"));
		}
		
		if (field.equalsIgnoreCase("LAST_NAME")) {
			scriptUtilities.fillInTextField(SignupVarDXpathlocators.xpathLookup.get("LAST_NAME"), value);
			errorPath = SignupVarDXpathlocators.xpathLookup.get("LAST_NAME_ERRORMESSAGEXPATH");
		} else {
			scriptUtilities.fillInTextField(SignupVarDXpathlocators.xpathLookup.get("LAST_NAME"),
					SignupVarDXpathlocators.dataLookup.get("LAST_NAME"));
		}
		
		if (field.equalsIgnoreCase("SELECT_TRADE")) {
			scriptUtilities.fillInTextField(SignupVarDXpathlocators.xpathLookup.get("LAST_NAME"), value);
			errorPath = SignupVarDXpathlocators.xpathLookup.get("SELECT_TRADE_ERRORMESSAGEXPATH");
		} else {
			scriptUtilities.selectDropdown(By.id(SignupVarDXpathlocators.xpathLookup.get("SELECT_TRADE")), 1);

		}
		
		if (field.equalsIgnoreCase("POSTCODE")) {
			scriptUtilities.fillInTextField(SignupVarDXpathlocators.xpathLookup.get("LAST_NAME"), value);
			errorPath = SignupVarDXpathlocators.xpathLookup.get("POSTCODE_ERRORMESSAGEXPATH");
		} else {
			scriptUtilities.fillInTextField(SignupVarDXpathlocators.xpathLookup.get("POSTCODE"),
					SignupVarDXpathlocators.dataLookup.get("POSTCODE"));
		}
		
		if (field.equalsIgnoreCase("EMAIL")) {
			scriptUtilities.fillInTextField(SignupVarDXpathlocators.xpathLookup.get("EMAIL"), value);
			errorPath = SignupVarDXpathlocators.xpathLookup.get("EMAIL_ERRORMESSAGEXPATH");
		} else {
			scriptUtilities.fillInTextField(SignupVarDXpathlocators.xpathLookup.get("EMAIL"), uniqueEmailAccountName);

		}
		
		if (field.equalsIgnoreCase("BUSINESS_ROLE")) {
			scriptUtilities.fillInTextField(SignupVarDXpathlocators.xpathLookup.get("BUSINESS_ROLE"), value);
			errorPath = SignupVarDXpathlocators.xpathLookup.get("BUSINESS_ROLE_ERRORMESSAGEXPATH");
		} else {
			scriptUtilities.fillInTextField(SignupVarDXpathlocators.xpathLookup.get("BUSINESS_ROLE"),
					SignupVarDXpathlocators.dataLookup.get("BUSINESS_ROLE"));
		}
				
		if (field.equalsIgnoreCase("PASSWORD")) {
			scriptUtilities.fillInTextField(SignupVarDXpathlocators.xpathLookup.get("PASSWORD"), value);
			errorPath = SignupVarDXpathlocators.xpathLookup.get("PASSWORD_ERRORMESSAGEXPATH");
		} else {
			scriptUtilities.fillInTextField(SignupVarDXpathlocators.xpathLookup.get("PASSWORD"),
					SignupVarDXpathlocators.dataLookup.get("PASSWORD"));
		}
		
		if (field.equalsIgnoreCase("CONFIRM_PASSWORD")) {
			scriptUtilities.fillInTextField(SignupVarDXpathlocators.xpathLookup.get("CONFIRM_PASSWORD"), value);
			errorPath = SignupVarDXpathlocators.xpathLookup.get("CONFIRM_PASSWORD_ERRORMESSAGEXPATH");
		} else {
			scriptUtilities.fillInTextField(SignupVarDXpathlocators.xpathLookup.get("CONFIRM_PASSWORD"),
					SignupVarDXpathlocators.dataLookup.get("CONFIRM_PASSWORD"));
		}
		
		if (field.equalsIgnoreCase("COMPANY_NAME")) {
			scriptUtilities.fillInTextField(SignupVarDXpathlocators.xpathLookup.get("COMPANY_NAME"), value);
			errorPath = SignupVarDXpathlocators.xpathLookup.get("COMPANY_NAME_ERRORMESSAGEXPATH");
		} else {
			scriptUtilities.fillInTextField(SignupVarDXpathlocators.xpathLookup.get("COMPANY_NAME"),
					SignupVarDXpathlocators.dataLookup.get("COMPANY_NAME"));
		}
		
		if (field.equalsIgnoreCase("BUSINESS_TYPE")) {
			scriptUtilities.fillInTextField(SignupVarDXpathlocators.xpathLookup.get("BUSINESS_TYPE"), value);
			errorPath = SignupVarDXpathlocators.xpathLookup.get("BUSINESS_TYPE_ERRORMESSAGEXPATH");
		} else {
			scriptUtilities.selectDropdown(By.id(SignupVarDXpathlocators.xpathLookup.get("BUSINESS_TYPE")), 1);

		}
		
		if (field.equalsIgnoreCase("BUSINESS_EMPLOYEES")) {
			scriptUtilities.fillInTextField(SignupVarDXpathlocators.xpathLookup.get("BUSINESS_EMPLOYEES"), value);
			errorPath = SignupVarDXpathlocators.xpathLookup.get("BUSINESS_EMPLOYEES_ERRORMESSAGEXPATH");
		} else {
			scriptUtilities.fillInTextField(SignupVarDXpathlocators.xpathLookup.get("BUSINESS_EMPLOYEES"),
					SignupVarDXpathlocators.dataLookup.get("BUSINESS_EMPLOYEES"));
		}
		
		if (field.equalsIgnoreCase("MOBILE_NUM")) {
			scriptUtilities.fillInTextField(SignupVarDXpathlocators.xpathLookup.get("MOBILE_NUM"), value);
			errorPath = SignupVarDXpathlocators.xpathLookup.get("MOBILE_NUM_ERRORMESSAGEXPATH");
		} else {
			scriptUtilities.fillInTextField(SignupVarDXpathlocators.xpathLookup.get("MOBILE_NUM"), mobnum);
		}

		scriptUtilities.click(By.id(SignupVarDXpathlocators.xpathLookup.get("BUSINESS_DETAILS_SUBMIT")));
	 	((JavascriptExecutor) driver).executeScript("scroll(300,0);");
        System.out.println(errorPath);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(errorPath)));
		return scriptUtilities.findElement(By.xpath(errorPath)).getText();

	}
	
	
}
