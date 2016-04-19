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

public class SignupVar_D_ScreeningDetailsPage_PASSPORTGBR_Negative {
	
	
	private WebDriver driver;
	private String testUrl;
	private TestScriptUtilities scriptUtilities;
	private WebDriverWait wait;

	public static Logger logger = Logger.getLogger(SignUpVariantD.class.getName());
	public static final String THREE_D_SECURE_TIMEOUT_SELENIUM_ERROR_MSG_START = "Timed out after 30 seconds waiting for visibility of element located by By.xpath: .//*[@id='AutoNumber1']";

	public SignupVar_D_ScreeningDetailsPage_PASSPORTGBR_Negative(SeleniumTestContext context, TestScriptUtilities scriptUtilities) {
		this.scriptUtilities = scriptUtilities;
		this.driver = context.driver;
		this.testUrl = context.getTestUrl();
		this.wait = new WebDriverWait(driver, 30); // 30 seconds
			}
	public void PassportGBR(final String uniqueEmailAccountName, final String rollOnType, final String tariff, final String screeningType) throws InterruptedException {
		System.out.println(rollOnType + " " + tariff + " " + screeningType);
		testLandingPage(uniqueEmailAccountName, tariff);
		testBusinessDetailsPage(uniqueEmailAccountName);	
		testSelectScreeningPage(uniqueEmailAccountName, screeningType);
	}	
	
	public void testLandingPage(final String uniqueEmailAccountName, final String tariff) throws InterruptedException {
		System.out.println(uniqueEmailAccountName);
		System.out.println(tariff);
		// append tariff later to url
		scriptUtilities.goTo(testUrl + "/new-signup/d/" + tariff);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(SignupVarDXpathlocators.xpathLookup.get("SALUTATION_TYPE"))));
		
	}
	
	public void testSelectScreeningPage(final String uniqueEmailAccountName, final String screeningType) throws InterruptedException {

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SignupVarDXpathlocators.xpathLookup.get(screeningType + "_UK"))));
		scriptUtilities.click(By.xpath(SignupVarDXpathlocators.xpathLookup.get(screeningType + "_UK")));
	}
	
	public void testBusinessDetailsPage(String uniqueEmailAccountName) throws InterruptedException {
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
	
	
	
	public void testScreeningDetailsPage(final String uniqueEmailAccountName, final String rollOnType, final String tariff, final String screeningType) throws InterruptedException {	
		PassportGBR(uniqueEmailAccountName, rollOnType, tariff, screeningType);
		Thread.sleep(2000);
		scriptUtilities.click(By.id(SignupVarDXpathlocators.xpathLookup.get(screeningType + "_NEXT_BTN")));
		((JavascriptExecutor) driver).executeScript("scroll(300,0);");
		assertEquals(driver.findElement(By.xpath(SignupVarDXpathlocators.xpathLookup.get(screeningType + "_GBR_FIRST_NAME_ERRORMSGXPATH"))).getText(),
				SignupVarDXpathlocators.dataLookup.get(screeningType + "_GBR_FIRST_NAME_ERRORMSGTEXT"));
		assertEquals(driver.findElement(By.xpath(SignupVarDXpathlocators.xpathLookup.get(screeningType + "_GBR_LAST_NAME_ERRORMSGXPATH"))).getText(),
				SignupVarDXpathlocators.dataLookup.get(screeningType + "_GBR_LAST_NAME_ERRORMSGTEXT"));
		assertEquals(driver.findElement(By.xpath(SignupVarDXpathlocators.xpathLookup.get(screeningType + "_GBR_DOB_ERRORMSGXPATH"))).getText(),
				SignupVarDXpathlocators.dataLookup.get(screeningType + "_GBR_DOB_ERRORMSGTEXT"));
		assertEquals(driver.findElement(By.xpath(SignupVarDXpathlocators.xpathLookup.get(screeningType + "_GBR_EXPDATE_ERRORMSGXPATH"))).getText(),
				SignupVarDXpathlocators.dataLookup.get(screeningType + "_GBR_EXPDATE_ERRORMSGTEXT"));
		assertEquals(driver.findElement(By.xpath(SignupVarDXpathlocators.xpathLookup.get(screeningType + "_GBR_NUM_ERRORMSGXPATH"))).getText(),
				SignupVarDXpathlocators.dataLookup.get(screeningType + "_GBR_NUM_ERRORMSGTEXT"));
	
		
	}
}
