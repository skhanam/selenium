package uk.co.ratedpeople.test.functional.selenium.tmsignupvariance.varE;

import static org.testng.Assert.assertEquals;

import java.util.Random;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import uk.co.ratedpeople.test.functional.SeleniumTestContext;
import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;

public class SignUpVariant_E_BusinessDetailsPage_Negative {

	private WebDriver driver;
	private String testUrl;
	private TestScriptUtilities scriptUtilities;
	private WebDriverWait wait;

	public static Logger logger = Logger.getLogger(SignUpVariant_E_BusinessDetailsPage_Negative.class.getName());

	public SignUpVariant_E_BusinessDetailsPage_Negative(SeleniumTestContext context, TestScriptUtilities scriptUtilities) {
		this.scriptUtilities = scriptUtilities;
		this.driver = context.driver;
		this.testUrl = context.getTestUrl();
		this.testUrl = testUrl.replaceAll("http://", "https://");
		this.wait = new WebDriverWait(driver, 30); // 30 seconds
	}
	
	public void first3Page(final String rollOnType, final String tariff, final String screeningType) throws InterruptedException {
		scriptUtilities.goTo(testUrl + "/new-signup/e/enter-postcode/" + tariff);
		scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("POSTCODE"), SignupVarEXpathlocators.dataLookup.get("postcode"));
		scriptUtilities.click(By.xpath(SignupVarEXpathlocators.xpathLookup.get("VIEW_JOB_LEADS_BTN")));
				
		// select skills page
		scriptUtilities.click(By.xpath(SignupVarEXpathlocators.xpathLookup.get("AERIAL_TRADE")));
		scriptUtilities.click(By.xpath(SignupVarEXpathlocators.xpathLookup.get("CLEANER_TRADE")));
		scriptUtilities.click(By.xpath(SignupVarEXpathlocators.xpathLookup.get("HANDYMAN_TRADE")));
		scriptUtilities.click(By.xpath(SignupVarEXpathlocators.xpathLookup.get("ROOFER_TRADE")));
		scriptUtilities.click(By.xpath(SignupVarEXpathlocators.xpathLookup.get("WINDOW_TRADE")));
		scriptUtilities.click(By.xpath(SignupVarEXpathlocators.xpathLookup.get("VIEW_JOB_LEADS_FOR_YOUR_TRADE_BTN")));
		
		//select work area page
		scriptUtilities.click(By.xpath(SignupVarEXpathlocators.xpathLookup.get("MILES")));
		scriptUtilities.click(By.xpath(SignupVarEXpathlocators.xpathLookup.get("CONFIRM_WORK_AREA_BTN")));
		
		//business page
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SignupVarEXpathlocators.xpathLookup.get("FINDADDRESS_BTN"))));
		scriptUtilities.click(By.xpath(SignupVarEXpathlocators.xpathLookup.get("FINDADDRESS_BTN")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SignupVarEXpathlocators.xpathLookup.get("ADDRESS_OPTION"))));
		scriptUtilities.click(By.xpath(SignupVarEXpathlocators.xpathLookup.get("ADDRESS_OPTION")));
	}
	
	public void testBusinessDetailsPage(final String rollOnType, final String tariff, final String screeningType) throws InterruptedException {
		first3Page(rollOnType,tariff,screeningType);
		scriptUtilities.click(By.xpath(SignupVarEXpathlocators.xpathLookup.get("NEXT_PAGE")));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SignupVarEXpathlocators.xpathLookup.get("BUSINESS_NAME_ERROR"))));
		scriptUtilities.findElement(By.xpath(SignupVarEXpathlocators.xpathLookup.get("BUSINESS_NAME_ERROR"))).getText();
		
		assertEquals(driver.findElement(By.xpath(SignupVarEXpathlocators.xpathLookup.get("MOBILE_NUMBER_ERROR"))).getText(),
				SignupVarEXpathlocators.assertLookup.get("MOBILE_NUMBER_ERROR"));

		assertEquals(driver.findElement(By.xpath(SignupVarEXpathlocators.xpathLookup.get("CONTACT_NAME_ERROR"))).getText(),
				SignupVarEXpathlocators.assertLookup.get("CONTACT_NAME_ERROR"));
		
		assertEquals(driver.findElement(By.xpath(SignupVarEXpathlocators.xpathLookup.get("EMAIL_ADDRESS_ERROR"))).getText(),
				SignupVarEXpathlocators.assertLookup.get("EMAIL_ADDRESS_ERROR"));
		
		assertEquals(driver.findElement(By.xpath(SignupVarEXpathlocators.xpathLookup.get("PASSWORD_ERROR"))).getText(),
				SignupVarEXpathlocators.assertLookup.get("PASSWORD_ERROR"));
		
		assertEquals(driver.findElement(By.xpath(SignupVarEXpathlocators.xpathLookup.get("CONFIRM_PASSWORD_ERROR"))).getText(),
				SignupVarEXpathlocators.assertLookup.get("CONFIRM_PASSWORD_ERROR"));
		
		assertEquals(driver.findElement(By.xpath(SignupVarEXpathlocators.xpathLookup.get("TYPES_OF_BUSINESS_ERROR"))).getText(),
				SignupVarEXpathlocators.assertLookup.get("TYPES_OF_BUSINESS_ERROR"));
		
		assertEquals(driver.findElement(By.xpath(SignupVarEXpathlocators.xpathLookup.get("PEOPLE_IN_BUSINESS_ERROR"))).getText(),
				SignupVarEXpathlocators.assertLookup.get("PEOPLE_IN_BUSINESS_ERROR"));
		
		assertEquals(driver.findElement(By.xpath(SignupVarEXpathlocators.xpathLookup.get("HEAR_US_ERROR"))).getText(),
				SignupVarEXpathlocators.assertLookup.get("HEAR_US_ERROR"));
		
	}
	
	public String testCompanyName(final String rollOnType, final String tariff, final String screeningType,final String companyName) throws InterruptedException {
		first3Page(rollOnType,tariff,screeningType);
		scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("BUSINESS_NAME"), companyName);
		scriptUtilities.click(By.xpath(SignupVarEXpathlocators.xpathLookup.get("NEXT_PAGE")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SignupVarEXpathlocators.xpathLookup.get("BUSINESS_NAME_ERROR"))));
		return scriptUtilities.findElement(By.xpath(SignupVarEXpathlocators.xpathLookup.get("BUSINESS_NAME_ERROR"))).getText();		
		}
	
	public String signUpBusinessDetailsPage(final String rollOnType, final String tariff, final String screeningType, final String mobileNumber) throws Exception {
		System.out.println(rollOnType + " " + tariff + " " + screeningType);
		System.out.println("Target environment: " + this.testUrl);
		return testMobileNumber("",	tariff,	"", mobileNumber);
		}
	
	public String signUpContactNameValidation(final String rollOnType, final String tariff, final String screeningType, final String contactName) throws Exception {
		System.out.println(rollOnType + " " + tariff + " " + screeningType);
		System.out.println("Target environment: " + this.testUrl);
		return testcontactName("",	tariff,	"", contactName);
		}

	public String signUpPasswordFieldValidation(final String rollOnType, final String tariff, final String screeningType, final String password1,final String password2) throws Exception {
		System.out.println(rollOnType + " " + tariff + " " + screeningType);
		System.out.println("Target environment: " + this.testUrl);
		return testPasswordValidation("",	tariff,	"", password1,password2);
		}
	
	public String signUpEmailIdValidation(final String rollOnType, final String tariff, final String screeningType, final String emailId) throws Exception {
		System.out.println(rollOnType + " " + tariff + " " + screeningType);
		System.out.println("Target environment: " + this.testUrl);
		return testEmailValidation("",	tariff,	"",emailId );
		}
	
	public void signUpNoBusinesstype(final String rollOnType, final String tariff, final String screeningType) throws Exception {
		System.out.println(rollOnType + " " + tariff + " " + screeningType);
		System.out.println("Target environment: " + this.testUrl);
		first3Page(rollOnType,tariff,screeningType);
		scriptUtilities.click(By.xpath(SignupVarEXpathlocators.xpathLookup.get("NEXT_PAGE")));
		assertEquals(driver.findElement(By.xpath(SignupVarEXpathlocators.xpathLookup.get("TYPES_OF_BUSINESS_ERROR"))).getText(),
				SignupVarEXpathlocators.assertLookup.get("TYPES_OF_BUSINESS_ERROR"));
		
		
		}
	
	public void signUpNoNumberOfPeople(final String rollOnType, final String tariff, final String screeningType) throws Exception {
		System.out.println(rollOnType + " " + tariff + " " + screeningType);
		System.out.println("Target environment: " + this.testUrl);
		first3Page(rollOnType,tariff,screeningType);
		scriptUtilities.click(By.xpath(SignupVarEXpathlocators.xpathLookup.get("NEXT_PAGE")));
		
		assertEquals(driver.findElement(By.xpath(SignupVarEXpathlocators.xpathLookup.get("PEOPLE_IN_BUSINESS_ERROR"))).getText(),
				SignupVarEXpathlocators.assertLookup.get("PEOPLE_IN_BUSINESS_ERROR"));
			
		}
	public void signUpNotSelectingHearaboutUs(final String rollOnType, final String tariff, final String screeningType) throws Exception {
		System.out.println(rollOnType + " " + tariff + " " + screeningType);
		System.out.println("Target environment: " + this.testUrl);
		first3Page(rollOnType,tariff,screeningType);
		scriptUtilities.click(By.xpath(SignupVarEXpathlocators.xpathLookup.get("NEXT_PAGE")));
		assertEquals(driver.findElement(By.xpath(SignupVarEXpathlocators.xpathLookup.get("HEAR_US_ERROR"))).getText(),
				SignupVarEXpathlocators.assertLookup.get("HEAR_US_ERROR"));
		
		}
	public String signUpExistingMobile(final String rollOnType, final String tariff, final String screeningType, final String mobileNumber) throws Exception {
		System.out.println(rollOnType + " " + tariff + " " + screeningType);
		System.out.println("Target environment: " + this.testUrl);
		return testExistingMobileNumber("",	tariff,	"",mobileNumber );
		}
	
	public String signUpExistingEmail(final String rollOnType, final String tariff, final String screeningType, final String emailId) throws Exception {
		System.out.println(rollOnType + " " + tariff + " " + screeningType);
		System.out.println("Target environment: " + this.testUrl);
		return testExistingEmailValidation("",	tariff,	"",emailId );
		}
	
	
	public static char randomSeriesForThreeCharacter() {
		Random word = new Random();
		char random_3_Char = (char) (97 + word.nextInt(25));
		return random_3_Char;
		}
	
	public String testMobileNumber(final String rollOnType, final String tariff, final String screeningType,final String mobileNumber) throws InterruptedException {
		first3Page(rollOnType,tariff,screeningType);		
		scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("MOBILE_NUMBER"), mobileNumber);
		scriptUtilities.click(By.xpath(SignupVarEXpathlocators.xpathLookup.get("NEXT_PAGE")));
		scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("BUSINESS_NAME"), SignupVarEXpathlocators.dataLookup.get("business_name")
				+ randomSeriesForThreeCharacter());
		scriptUtilities.clear(By.id(SignupVarEXpathlocators.xpathLookup.get("CONTACT_NAME")));
		scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("CONTACT_NAME"), SignupVarEXpathlocators.dataLookup.get("contact_name")
				+ randomSeriesForThreeCharacter());
		scriptUtilities.clear(By.id(SignupVarEXpathlocators.xpathLookup.get("EMAIL_ADDRESS")));
		String emailAccount = "sangitm@ratedtrades.com";
		scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("EMAIL_ADDRESS"), emailAccount);
		scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("PASSWORD"), SignupVarEXpathlocators.dataLookup.get("password"));
		scriptUtilities
				.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("CONFIRM_PASSWORD"), SignupVarEXpathlocators.dataLookup.get("confirm_password"));
		scriptUtilities.selectDropdown(By.id(SignupVarEXpathlocators.xpathLookup.get("TYPES_OF_BUSINESS")), 1);
		scriptUtilities.selectDropdown(By.id(SignupVarEXpathlocators.xpathLookup.get("PEOPLE_IN_BUSINESS")), 1);
		scriptUtilities.selectDropdown(By.id(SignupVarEXpathlocators.xpathLookup.get("HEAR_US")), 1);

		scriptUtilities.click(By.xpath(SignupVarEXpathlocators.xpathLookup.get("NEXT_PAGE")));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SignupVarEXpathlocators.xpathLookup.get("MOBILE_NUMBER_ERROR"))));
		return scriptUtilities.findElement(By.xpath(SignupVarEXpathlocators.xpathLookup.get("MOBILE_NUMBER_ERROR"))).getText();
	}
	

	public String testExistingMobileNumber(final String rollOnType, final String tariff, final String screeningType,final String mobileNumber) throws InterruptedException {
		first3Page(rollOnType,tariff,screeningType);		
		scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("MOBILE_NUMBER"),mobileNumber );
		scriptUtilities.click(By.xpath(SignupVarEXpathlocators.xpathLookup.get("NEXT_PAGE")));
		scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("BUSINESS_NAME"), SignupVarEXpathlocators.dataLookup.get("business_name")
				+ randomSeriesForThreeCharacter());
		scriptUtilities.clear(By.id(SignupVarEXpathlocators.xpathLookup.get("CONTACT_NAME")));
		scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("CONTACT_NAME"), SignupVarEXpathlocators.dataLookup.get("contact_name")
				+ randomSeriesForThreeCharacter());
		scriptUtilities.clear(By.id(SignupVarEXpathlocators.xpathLookup.get("EMAIL_ADDRESS")));
		String emailAccount = "sangitm@ratedtrades.com";
		scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("EMAIL_ADDRESS"), emailAccount);
		scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("PASSWORD"), SignupVarEXpathlocators.dataLookup.get("password"));
		scriptUtilities
				.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("CONFIRM_PASSWORD"), SignupVarEXpathlocators.dataLookup.get("confirm_password"));
		scriptUtilities.selectDropdown(By.id(SignupVarEXpathlocators.xpathLookup.get("TYPES_OF_BUSINESS")), 1);
		scriptUtilities.selectDropdown(By.id(SignupVarEXpathlocators.xpathLookup.get("PEOPLE_IN_BUSINESS")), 1);
		scriptUtilities.selectDropdown(By.id(SignupVarEXpathlocators.xpathLookup.get("HEAR_US")), 1);

		scriptUtilities.click(By.xpath(SignupVarEXpathlocators.xpathLookup.get("NEXT_PAGE")));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SignupVarEXpathlocators.xpathLookup.get("EXISTING_MOBILE_NUMBER_ERROR"))));
		return scriptUtilities.findElement(By.xpath(SignupVarEXpathlocators.xpathLookup.get("EXISTING_MOBILE_NUMBER_ERROR"))).getText();
	}
	
	public String testcontactName(final String rollOnType, final String tariff, final String screeningType,final String contactName) throws InterruptedException {
		first3Page(rollOnType,tariff,screeningType);		
		scriptUtilities.clear(By.id(SignupVarEXpathlocators.xpathLookup.get("MOBILE_NUMBER")));

		String mobnum1 = Integer.toString(TestScriptUtilities.getRandom6digitNumber());
		String mobnum2 = Integer.toString(TestScriptUtilities.getRandom6digitNumber());

		String mobnum = SignupVarEXpathlocators.dataLookup.get("mobile_number") + mobnum1 + mobnum2;
		scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("MOBILE_NUMBER"), mobnum);
		
		scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("BUSINESS_NAME"), SignupVarEXpathlocators.dataLookup.get("business_name")
				+ randomSeriesForThreeCharacter());
		
		scriptUtilities.clear(By.id(SignupVarEXpathlocators.xpathLookup.get("CONTACT_NAME")));
		scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("CONTACT_NAME"), contactName);
		
		scriptUtilities.clear(By.id(SignupVarEXpathlocators.xpathLookup.get("EMAIL_ADDRESS")));
		String emailAccount = "sangitm@ratedtrades.com";
		scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("EMAIL_ADDRESS"), emailAccount);
		
		scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("PASSWORD"), SignupVarEXpathlocators.dataLookup.get("password"));
		scriptUtilities
				.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("CONFIRM_PASSWORD"), SignupVarEXpathlocators.dataLookup.get("confirm_password"));
		scriptUtilities.selectDropdown(By.id(SignupVarEXpathlocators.xpathLookup.get("TYPES_OF_BUSINESS")), 1);
		scriptUtilities.selectDropdown(By.id(SignupVarEXpathlocators.xpathLookup.get("PEOPLE_IN_BUSINESS")), 1);
		scriptUtilities.selectDropdown(By.id(SignupVarEXpathlocators.xpathLookup.get("HEAR_US")), 1);

		scriptUtilities.click(By.xpath(SignupVarEXpathlocators.xpathLookup.get("NEXT_PAGE")));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SignupVarEXpathlocators.xpathLookup.get("CONTACT_NAME_ERROR"))));
		return scriptUtilities.findElement(By.xpath(SignupVarEXpathlocators.xpathLookup.get("CONTACT_NAME_ERROR"))).getText();
	}
	
	public String testPasswordValidation(final String rollOnType, final String tariff, final String screeningType,final String password1,final String password2) throws InterruptedException {
		first3Page(rollOnType,tariff,screeningType);		
		scriptUtilities.clear(By.id(SignupVarEXpathlocators.xpathLookup.get("MOBILE_NUMBER")));

		String mobnum1 = Integer.toString(TestScriptUtilities.getRandom6digitNumber());
		String mobnum2 = Integer.toString(TestScriptUtilities.getRandom6digitNumber());

		String mobnum = SignupVarEXpathlocators.dataLookup.get("mobile_number") + mobnum1 + mobnum2;
		scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("MOBILE_NUMBER"), mobnum);
		
		scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("BUSINESS_NAME"), SignupVarEXpathlocators.dataLookup.get("business_name")
				+ randomSeriesForThreeCharacter());
		
		scriptUtilities.clear(By.id(SignupVarEXpathlocators.xpathLookup.get("CONTACT_NAME")));
		scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("CONTACT_NAME"), SignupVarEXpathlocators.dataLookup.get("contact_name")
				+ randomSeriesForThreeCharacter());
		
		scriptUtilities.clear(By.id(SignupVarEXpathlocators.xpathLookup.get("EMAIL_ADDRESS")));
		String emailAccount = "sangitm@ratedtrades.com";
		scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("EMAIL_ADDRESS"), emailAccount);
		
		scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("PASSWORD"), password1);
		scriptUtilities
				.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("CONFIRM_PASSWORD"),password2);
		scriptUtilities.selectDropdown(By.id(SignupVarEXpathlocators.xpathLookup.get("TYPES_OF_BUSINESS")), 1);
		scriptUtilities.selectDropdown(By.id(SignupVarEXpathlocators.xpathLookup.get("PEOPLE_IN_BUSINESS")), 1);
		scriptUtilities.selectDropdown(By.id(SignupVarEXpathlocators.xpathLookup.get("HEAR_US")), 1);

		scriptUtilities.click(By.xpath(SignupVarEXpathlocators.xpathLookup.get("NEXT_PAGE")));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SignupVarEXpathlocators.xpathLookup.get("PASSWORD_ERROR"))));
		return scriptUtilities.findElement(By.xpath(SignupVarEXpathlocators.xpathLookup.get("PASSWORD_ERROR"))).getText();
	}
	
	public String testEmailValidation(final String rollOnType, final String tariff, final String screeningType,final String emailId) throws InterruptedException {
		first3Page(rollOnType,tariff,screeningType);		
		scriptUtilities.clear(By.id(SignupVarEXpathlocators.xpathLookup.get("MOBILE_NUMBER")));

			
		scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("MOBILE_NUMBER"), "07534444842");
		
		scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("BUSINESS_NAME"), SignupVarEXpathlocators.dataLookup.get("business_name")
				+ randomSeriesForThreeCharacter());
		
		scriptUtilities.clear(By.id(SignupVarEXpathlocators.xpathLookup.get("CONTACT_NAME")));
		scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("CONTACT_NAME"), SignupVarEXpathlocators.dataLookup.get("contact_name")
				+ randomSeriesForThreeCharacter());
		
		scriptUtilities.clear(By.id(SignupVarEXpathlocators.xpathLookup.get("EMAIL_ADDRESS")));
		scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("EMAIL_ADDRESS"), emailId);
		scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("PASSWORD"), SignupVarEXpathlocators.dataLookup.get("password"));
		scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("CONFIRM_PASSWORD"), SignupVarEXpathlocators.dataLookup.get("confirm_password"));
		
		scriptUtilities.selectDropdown(By.id(SignupVarEXpathlocators.xpathLookup.get("TYPES_OF_BUSINESS")), 1);
		scriptUtilities.selectDropdown(By.id(SignupVarEXpathlocators.xpathLookup.get("PEOPLE_IN_BUSINESS")), 1);
		scriptUtilities.selectDropdown(By.id(SignupVarEXpathlocators.xpathLookup.get("HEAR_US")), 1);

		scriptUtilities.click(By.xpath(SignupVarEXpathlocators.xpathLookup.get("NEXT_PAGE")));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SignupVarEXpathlocators.xpathLookup.get("EMAIL_ADDRESS_ERROR"))));
		return scriptUtilities.findElement(By.xpath(SignupVarEXpathlocators.xpathLookup.get("EMAIL_ADDRESS_ERROR"))).getText();
	}
	public String testExistingEmailValidation(final String rollOnType, final String tariff, final String screeningType,final String emailId) throws InterruptedException {
		first3Page(rollOnType,tariff,screeningType);		
		scriptUtilities.clear(By.id(SignupVarEXpathlocators.xpathLookup.get("MOBILE_NUMBER")));

		String mobnum1 = Integer.toString(TestScriptUtilities.getRandom6digitNumber());
		String mobnum2 = Integer.toString(TestScriptUtilities.getRandom6digitNumber());

		String mobnum = SignupVarEXpathlocators.dataLookup.get("mobile_number") + mobnum1 + mobnum2;
		scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("MOBILE_NUMBER"), mobnum);
		
		scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("BUSINESS_NAME"), SignupVarEXpathlocators.dataLookup.get("business_name")
				+ randomSeriesForThreeCharacter());
		
		scriptUtilities.clear(By.id(SignupVarEXpathlocators.xpathLookup.get("CONTACT_NAME")));
		scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("CONTACT_NAME"), SignupVarEXpathlocators.dataLookup.get("contact_name")
				+ randomSeriesForThreeCharacter());
		
		scriptUtilities.clear(By.id(SignupVarEXpathlocators.xpathLookup.get("EMAIL_ADDRESS")));
		scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("EMAIL_ADDRESS"), emailId);
		scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("PASSWORD"), SignupVarEXpathlocators.dataLookup.get("password"));
		scriptUtilities.fillInTextField(SignupVarEXpathlocators.xpathLookup.get("CONFIRM_PASSWORD"), SignupVarEXpathlocators.dataLookup.get("confirm_password"));
		
		scriptUtilities.selectDropdown(By.id(SignupVarEXpathlocators.xpathLookup.get("TYPES_OF_BUSINESS")), 1);
		scriptUtilities.selectDropdown(By.id(SignupVarEXpathlocators.xpathLookup.get("PEOPLE_IN_BUSINESS")), 1);
		scriptUtilities.selectDropdown(By.id(SignupVarEXpathlocators.xpathLookup.get("HEAR_US")), 1);

		scriptUtilities.click(By.xpath(SignupVarEXpathlocators.xpathLookup.get("NEXT_PAGE")));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SignupVarEXpathlocators.xpathLookup.get("EXISTING_EMAIL_ADDRESS_ERROR"))));
		return scriptUtilities.findElement(By.xpath(SignupVarEXpathlocators.xpathLookup.get("EXISTING_EMAIL_ADDRESS_ERROR"))).getText();
	}
	
}		
