package uk.co.ratedpeople.test.functional.selenium.tmsignupvariance.varD;

/*     
@Author ARAVIND                 
*/
import static org.testng.Assert.assertEquals;

import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import uk.co.ratedpeople.test.functional.SeleniumTestContext;
import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;
import uk.co.ratedpeople.test.functional.selenium.tmsignupvariance.varD.SignUpVariantD;

public class SignUpVariant_D_BillingPage_Negative {
	private WebDriver driver;
	private String testUrl;
	private TestScriptUtilities scriptUtilities;
	private WebDriverWait wait;

	public static Logger logger = Logger.getLogger(SignUpVariantD.class.getName());
	public static final String THREE_D_SECURE_TIMEOUT_SELENIUM_ERROR_MSG_START = "Timed out after 30 seconds waiting for visibility of element located by By.xpath: .//*[@id='AutoNumber1']";

	public SignUpVariant_D_BillingPage_Negative(SeleniumTestContext context, TestScriptUtilities scriptUtilities) {
		this.scriptUtilities = scriptUtilities;
		this.driver = context.driver;
		this.testUrl = context.getTestUrl();
		this.wait = new WebDriverWait(driver, 30); // 30 seconds
			}
	public void PassportBillingPage(final String uniqueEmailAccountName, final String rollOnType, final String tariff, final String screeningType) throws InterruptedException {
		System.out.println(rollOnType + " " + tariff + " " + screeningType);
		testLandingPage(uniqueEmailAccountName, tariff);
		testBusinessDetailsPage(uniqueEmailAccountName, screeningType);	
		testSelectScreeningPage(uniqueEmailAccountName, screeningType);
		testPassportThroughPreprodOrTokyo(uniqueEmailAccountName, screeningType);
	}	
	
	public void testLandingPage(final String uniqueEmailAccountName, final String tariff) throws InterruptedException {
		System.out.println(uniqueEmailAccountName);
		System.out.println(tariff);
		// append tariff later to url
		scriptUtilities.goTo(testUrl + "/new-signup/d/" + tariff);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(SignupVarDXpathlocators.xpathLookup.get("SALUTATION_TYPE"))));
		
	}
	
	public void testScreeningDetailsPage(final String uniqueEmailAccountName, final String screeningType) throws InterruptedException {
		
		if (screeningType == "PASSPORT") {
			testPassportThroughPreprodOrTokyo(uniqueEmailAccountName, screeningType);
		}

		if (screeningType == "PASSPORTOTHER") {
			testPassportThroughPreprodOrTokyo(uniqueEmailAccountName, screeningType);
		}

	}
	
	public void testPassportThroughPreprodOrTokyo(final String uniqueEmailAccountName, final String screeningType) throws InterruptedException {

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(SignupVarDXpathlocators.xpathLookup.get(screeningType + "_NEXT_BTN"))));

		scriptUtilities.click(By.id(SignupVarDXpathlocators.xpathLookup.get(screeningType + "_NEXT_BTN")));

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
	
	public void testSelectScreeningPage(final String uniqueEmailAccountName, final String screeningType) throws InterruptedException {

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SignupVarDXpathlocators.xpathLookup.get(screeningType + "_UK"))));
		scriptUtilities.click(By.xpath(SignupVarDXpathlocators.xpathLookup.get(screeningType + "_UK")));
	}
	
	public void testBusinessDetailsPage(String uniqueEmailAccountName, String screeningType) throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(SignupVarDXpathlocators.xpathLookup.get("BUSINESS_DETAILS_SUBMIT"))));
		scriptUtilities.click(By.id(SignupVarDXpathlocators.xpathLookup.get("BUSINESS_DETAILS_SUBMIT")));
		scriptUtilities.selectDropdown(By.id(SignupVarDXpathlocators.xpathLookup.get("SALUTATION_TYPE")), 1);
		scriptUtilities.fillInTextField(SignupVarDXpathlocators.xpathLookup.get("FIRST_NAME"), SignupVarDXpathlocators.dataLookup.get("FIRST_NAME"));
		scriptUtilities.fillInTextField(SignupVarDXpathlocators.xpathLookup.get("LAST_NAME"), SignupVarDXpathlocators.dataLookup.get("LAST_NAME"));
		scriptUtilities.selectDropdown(By.id(SignupVarDXpathlocators.xpathLookup.get("SELECT_TRADE")), 1);
		scriptUtilities.fillInTextField(SignupVarDXpathlocators.xpathLookup.get("POSTCODE"), SignupVarDXpathlocators.dataLookup.get("postcode"));
		scriptUtilities.fillInTextField(SignupVarDXpathlocators.xpathLookup.get("EMAIL"), uniqueEmailAccountName);
		scriptUtilities.selectDropdown(By.id(SignupVarDXpathlocators.xpathLookup.get("BUSINESS_ROLE")), 1);
		scriptUtilities.fillInTextField(SignupVarDXpathlocators.xpathLookup.get("PASSWORD"), SignupVarDXpathlocators.dataLookup.get("PASSWORD"));
		scriptUtilities
				.fillInTextField(SignupVarDXpathlocators.xpathLookup.get("CONFIRM_PASSWORD"), SignupVarDXpathlocators.dataLookup.get("CONFIRM_PASSWORD"));
		scriptUtilities.fillInTextField(SignupVarDXpathlocators.xpathLookup.get("COMPANY_NAME"), SignupVarDXpathlocators.dataLookup.get("COMPANY_NAME"));
		scriptUtilities.selectDropdown(By.id(SignupVarDXpathlocators.xpathLookup.get("BUSINESS_TYPE")), 1);
		scriptUtilities.selectDropdown(By.id(SignupVarDXpathlocators.xpathLookup.get("BUSINESS_EMPLOYEES")), 1);
		scriptUtilities.fillInTextField(SignupVarDXpathlocators.xpathLookup.get("COMPANY_NUM"), SignupVarDXpathlocators.dataLookup.get("COMPANY_NUM"));
		scriptUtilities.fillInTextField(SignupVarDXpathlocators.xpathLookup.get("COMPANY_VAT_NUM"), SignupVarDXpathlocators.dataLookup.get("COMPANY_VAT_NUM"));

		scriptUtilities.clear(By.id(SignupVarDXpathlocators.xpathLookup.get("MOBILE_NUM")));

		String mobnum1 = Integer.toString(TestScriptUtilities.getRandom6digitNumber());
		String mobnum2 = Integer.toString(TestScriptUtilities.getRandom6digitNumber());

		String mobnum = SignupVarDXpathlocators.dataLookup.get("MOBILE_NUM") + mobnum1 + mobnum2;
		scriptUtilities.fillInTextField(SignupVarDXpathlocators.xpathLookup.get("MOBILE_NUM"), mobnum);

		// scriptUtilities.fillInTextField(SignupVarDXpathlocators.xpathLookup.get("MOBILE_NUM"),
		// SignupVarDXpathlocators.dataLookup.get("MOBILE_NUM") + 808900);

		scriptUtilities.click(By.id(SignupVarDXpathlocators.xpathLookup.get("FIND_ADDRESS_BTN")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SignupVarDXpathlocators.xpathLookup.get("ADDRESS_OPTION"))));
		scriptUtilities.click(By.xpath(SignupVarDXpathlocators.xpathLookup.get("ADDRESS_OPTION")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(SignupVarDXpathlocators.xpathLookup.get("PROPERTY_ADDRESS"))));
		scriptUtilities.click(By.id(SignupVarDXpathlocators.xpathLookup.get("BUSINESS_DETAILS_SUBMIT")));
	}
	
	public void testPassportScreeningDetailsPage(final String uniqueEmailAccountName, final String screeningType, final String dataset)
			throws InterruptedException {

		    Thread.sleep(2000);	    

			
			scriptUtilities.checkAndSelectDropDownById(SignupVarDXpathlocators.xpathLookup.get(screeningType + "_GBR"),
					SignupVarDXpathlocators.dataLookup.get("_passport_GBR"));

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(SignupVarDXpathlocators.xpathLookup.get(screeningType + "_GBR_FIRST_NAME"))));
			scriptUtilities.fillInTextField(SignupVarDXpathlocators.xpathLookup.get(screeningType + "_GBR_FIRST_NAME"),
					SignupVarDXpathlocators.dataLookup.get(dataset + "_passport_GBR_FIRST_NAME"));

			scriptUtilities.fillInTextField(SignupVarDXpathlocators.xpathLookup.get(screeningType + "_GBR_LAST_NAME"),
					SignupVarDXpathlocators.dataLookup.get(dataset + "_passport_GBR_LAST_NAME"));

			scriptUtilities.checkAndSelectDropDownById(SignupVarDXpathlocators.xpathLookup.get(screeningType + "_GBR_DOB"),
					SignupVarDXpathlocators.dataLookup.get(dataset + "_passport_GBR_DOB"));

			scriptUtilities.checkAndSelectDropDownById(SignupVarDXpathlocators.xpathLookup.get(screeningType + "_GBR_DOB_MON"),
					SignupVarDXpathlocators.dataLookup.get(dataset + "_passport_GBR_DOB_MON"));

			scriptUtilities.checkAndSelectDropDownById(SignupVarDXpathlocators.xpathLookup.get(screeningType + "_GBR_DOB_YEAR"),
					SignupVarDXpathlocators.dataLookup.get(dataset + "_passport_GBR_DOB_YEAR"));

			scriptUtilities.checkAndSelectDropDownById(SignupVarDXpathlocators.xpathLookup.get(screeningType + "_GBR_EXP"),
					SignupVarDXpathlocators.dataLookup.get(dataset + "_passport_GBR_EXP"));

			scriptUtilities.checkAndSelectDropDownById(SignupVarDXpathlocators.xpathLookup.get(screeningType + "_GBR_EXP_MON"),
					SignupVarDXpathlocators.dataLookup.get(dataset + "_passport_GBR_EXP_MON"));

			scriptUtilities.checkAndSelectDropDownById(SignupVarDXpathlocators.xpathLookup.get(screeningType + "_GBR_EXP_YEAR"),
					SignupVarDXpathlocators.dataLookup.get(dataset + "_passport_GBR_EXP_YEAR"));

			scriptUtilities.fillInTextField(SignupVarDXpathlocators.xpathLookup.get(screeningType + "_GBR_NUM"),
					SignupVarDXpathlocators.dataLookup.get(dataset + "_passport_GBR_NUM"));

			scriptUtilities.checkAndSelectDropDownById(SignupVarDXpathlocators.xpathLookup.get(screeningType + "_GBR_NEWPERSONALADDRESS"),
					SignupVarDXpathlocators.dataLookup.get(dataset + "_passport_GBR_NEWPERSONALADDRESS"));

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(SignupVarDXpathlocators.xpathLookup.get(screeningType + "_GBR_NEWPOSTCODE"))));

			scriptUtilities.fillInTextField(SignupVarDXpathlocators.xpathLookup.get(screeningType + "_GBR_NEWPOSTCODE"),
					SignupVarDXpathlocators.dataLookup.get(dataset + "_passport_GBR_NEWPOSTCODE"));

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Enter address manually"))).click();

			scriptUtilities.fillInTextField(SignupVarDXpathlocators.xpathLookup.get(screeningType + "_GBR_HOUSENAME"),
					SignupVarDXpathlocators.dataLookup.get(dataset + "_passport_GBR_HOUSENAME"));

			scriptUtilities.fillInTextField(SignupVarDXpathlocators.xpathLookup.get(screeningType + "_GBR_STREET"),
					SignupVarDXpathlocators.dataLookup.get(dataset + "_passport_GBR_STREET"));

			scriptUtilities.fillInTextField(SignupVarDXpathlocators.xpathLookup.get(screeningType + "_GBR_TOWN"),
					SignupVarDXpathlocators.dataLookup.get(dataset + "_passport_GBR_TOWN"));

			scriptUtilities.click(By.id(SignupVarDXpathlocators.xpathLookup.get(screeningType + "_NEXT_BTN")));


	}
	
	public void testPassportBillingPage(final String uniqueEmailAccountName, final String rollOnType, final String tariff, final String screeningType) throws InterruptedException {	
		PassportBillingPage(uniqueEmailAccountName, rollOnType, tariff, screeningType);
		Thread.sleep(2000);
		scriptUtilities.click(By.id(SignupVarDXpathlocators.xpathLookup.get("CREDITCARD_CONFIRM_BTN")));		
		((JavascriptExecutor) driver).executeScript("scroll(0,250);");
		Thread.sleep(2000);
		assertEquals(driver.findElement(By.xpath(SignupVarDXpathlocators.xpathLookup.get("SELECT_PAYMENTPLAN_ERRORMSGXPATH"))).getText(),
				SignupVarDXpathlocators.dataLookup.get("SELECT_PAYMENTPLAN_ERRORMSGTEXT"));
		assertEquals(driver.findElement(By.xpath(SignupVarDXpathlocators.xpathLookup.get("NAME_ONTHECARD_ERRORMSGXPATH"))).getText(),
				SignupVarDXpathlocators.dataLookup.get("NAME_ONTHECARD_ERRORMSGTEXT"));
		assertEquals(driver.findElement(By.xpath(SignupVarDXpathlocators.xpathLookup.get("CARDNUMBER_ERRORMSGXPATH"))).getText(),
				SignupVarDXpathlocators.dataLookup.get("CARDNUMBER_ERRORMSGTEXT"));
		assertEquals(driver.findElement(By.xpath(SignupVarDXpathlocators.xpathLookup.get("CARD_EXPIRY_MONTH_ERRORMSGXPATH"))).getText(),
				SignupVarDXpathlocators.dataLookup.get("CARD_EXPIRY_MONTH_ERRORMSGTEXT"));
		assertEquals(driver.findElement(By.xpath(SignupVarDXpathlocators.xpathLookup.get("CARD_EXPIRY_YEAR_ERRORMSGXPATH"))).getText(),
				SignupVarDXpathlocators.dataLookup.get("CARD_EXPIRY_YEAR_ERRORMSGTEXT"));
		assertEquals(driver.findElement(By.xpath(SignupVarDXpathlocators.xpathLookup.get("CVV_NUMBER_ERRORMSGXPATH"))).getText(),
				SignupVarDXpathlocators.dataLookup.get("CVV_NUMBER_ERRORMSGTEXT"));
	
		
	}
	
	
}
