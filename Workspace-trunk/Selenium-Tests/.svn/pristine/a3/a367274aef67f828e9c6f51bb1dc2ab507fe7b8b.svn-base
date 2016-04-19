/**
 * 
 */
package uk.co.ratedpeople.test.functional.selenium.tmmobile.membershipcampaigns;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import uk.co.ratedpeople.test.functional.selenium.TestScript;
import uk.co.ratedpeople.test.functional.selenium.tmmobile.functions.TestFunctions;
import uk.co.ratedpeople.test.functional.selenium.tmmobile.functions.TestFunctionsJBilling;

/**
 * @author shobha.rani
 * 
 */
public class MembershipcampaignwithAddNewCardTest extends TestScript {

	private TestFunctionsJBilling testFunctions;
	private TestFunctions testFunctions1;
	public static final String TRADESMAN = "TMMobileMembershipCampaigns@ratedtrades.com";
	public static final String WRONG_USERNAME = "cardtest@ratedtrades.com";
	public static final String TRADESMAN_PASSWORD = "password";
	public static final String WRONG_PASSWORD = "wrongpaord";
	final String cardHolderName = "B S R Maramreddy";
	private static final String CREDIT_CARD_TYPE = "Visa";
	private static final Integer CV2 = 123;
	private static final String CREDIT_CARD_EXPIRY_MONTH = "12";
	private static final Integer CREDIT_CARD_EXPIRY_YEAR = 2014;
	private static final String CREDIT_CARD_NUMBER = "4929 0000 0000 6";
	public static final String TP_TM_USER_NAME = "021013release@ratedtrades.com";
	public static final String TP_TM_PASSWORD = "password";
	public static final String URL_VALIDATION = "There is a problem with the link";
	public static final String LOGIN_ERROR = "Sorry, you do not qualify for this membership plan";
	public static final String WRONG_LOGIN_ERROR = "Login failed, please try again";
	public static final String LOGIN_CONFIRM_MSG = "Log-in to confirm your payment details";
	public static final String MEMBERSHIP_CAMPAIGN_URL = "/r/annual-plans/landing/c6a829131113904a25cce910cd057e0e/1/399315";
	private static final String PMD_OVERDUE_MSG = "Your membership payment is overdue. To continue buying leads please pay the invoice.";
	private static final String ASSERT_HEADER1_ID = "page-h1";
	private static final String ASSERT_HEADER2_ID = "page-h2";
	private static final String LOGIN_ERROR_MSG_ID = "login-error";
	private WebDriver driver;
	private WebDriverWait wait;

	@BeforeClass
	public void beforeClass() throws Exception {
		driver = context.driver;
		testFunctions = new TestFunctionsJBilling(context.driver);
		testFunctions1 = new TestFunctions(context.driver);
		wait = new WebDriverWait(driver, 60);
	}

	// Deleting credit card in JBilling

	@Test(enabled = false)
	public void testRemoveAllCardsForTradesman() throws Exception {
		testFunctions.removeAllCardsForTradesman(this.context, 3147); // 3174
	}

	// User Status = Overdue user ID: 388737

	@Test(enabled = false)
	public void testTradesmanStatusOverdue() throws Exception {
		testFunctions.loginToJBillingAndEditUserStatus(this.context, 3174);
		context.driver.get(context.getTestUrl() + "/log-in");
		context.driver.findElement(By.xpath(MembershipcompaignXpathlocators.xpathLookup.get("TP_USERNAME"))).sendKeys(TP_TM_USER_NAME);
		context.driver.findElement(By.xpath(MembershipcompaignXpathlocators.xpathLookup.get("TP_PASSWORD"))).sendKeys(TP_TM_PASSWORD);
		context.driver.findElement(By.xpath(MembershipcompaignXpathlocators.xpathLookup.get("TM_LOGIN"))).click();
		Thread.sleep(2000);
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("overdue-banner")));
		assertEquals(context.driver.findElement(By.id("overdue-banner")).getText(), PMD_OVERDUE_MSG);
	}

	// URL VALIDATIONS

	@Test(enabled = false)
	public void testPMDURLValidation_skip1Number() throws Exception {
		context.driver.get(context.getTestHttpsTMMobileURL() + "/r/annual-plans/landing/c6a829131113904a25cce910cd057e0e/1/39931");
		assertEquals(context.driver.findElement(By.id(ASSERT_HEADER2_ID)).getText(), URL_VALIDATION);
	}

	@Test(enabled = false)
	public void testPMDURLValidation_skip2Numbers() throws Exception {
		context.driver.get(context.getTestHttpsTMMobileURL() + "/r/annual-plans/landing/c6a829131113904a25cce910cd057e0e/1/3993");
		assertEquals(context.driver.findElement(By.id(ASSERT_HEADER2_ID)).getText(), URL_VALIDATION);
	}

	@Test(enabled = false)
	public void testPMDURLValidation_skip3Numbers() throws Exception {
		context.driver.get(context.getTestHttpsTMMobileURL() + "/r/annual-plans/landing/c6a829131113904a25cce910cd057e0e/1/399");
		assertEquals(context.driver.findElement(By.id(ASSERT_HEADER2_ID)).getText(), URL_VALIDATION);
	}

	@Test(enabled = false)
	public void testTradesmancannotsharePMDOffer() throws Exception {
		context.driver.get(context.getTestHttpsTMMobileURL() + MEMBERSHIP_CAMPAIGN_URL);
		context.driver.findElement(By.xpath(MembershipcompaignXpathlocators.xpathLookup.get("PLAN1"))).click();
		assertEquals(context.driver.findElement(By.id(ASSERT_HEADER1_ID)).getText(), LOGIN_CONFIRM_MSG);
		context.driver.findElement(By.xpath(MembershipcompaignXpathlocators.xpathLookup.get("TM_MOBILE_USERNAME"))).clear();
		context.driver.findElement(By.xpath(MembershipcompaignXpathlocators.xpathLookup.get("TM_MOBILE_USERNAME"))).sendKeys(WRONG_USERNAME);

		context.driver.findElement(By.xpath(MembershipcompaignXpathlocators.xpathLookup.get("TM_MOBILE_PASSWORD"))).clear();
		context.driver.findElement(By.xpath(MembershipcompaignXpathlocators.xpathLookup.get("TM_MOBILE_PASSWORD"))).sendKeys(TRADESMAN_PASSWORD);

		context.driver.findElement(By.xpath(MembershipcompaignXpathlocators.xpathLookup.get("TM_MOBILE_LOGIN"))).click();
		Thread.sleep(2000);

		assertEquals(context.driver.findElement(By.id(LOGIN_ERROR_MSG_ID)).getText(), LOGIN_ERROR);
	}

	// Enter Incorrect User Name
	@Test(enabled = false)
	public void testTradesmancannotloginwithwrongusername() throws Exception {
		context.driver.get(context.getTestHttpsTMMobileURL() + MEMBERSHIP_CAMPAIGN_URL);
		context.driver.findElement(By.xpath(MembershipcompaignXpathlocators.xpathLookup.get("PLAN1"))).click();
		assertEquals(context.driver.findElement(By.id(ASSERT_HEADER1_ID)).getText(), LOGIN_CONFIRM_MSG);
		context.driver.findElement(By.xpath(MembershipcompaignXpathlocators.xpathLookup.get("TM_MOBILE_USERNAME"))).clear();
		context.driver.findElement(By.xpath(MembershipcompaignXpathlocators.xpathLookup.get("TM_MOBILE_USERNAME"))).sendKeys(WRONG_USERNAME);
		context.driver.findElement(By.xpath(MembershipcompaignXpathlocators.xpathLookup.get("TM_MOBILE_LOGIN"))).click();
		Thread.sleep(2000);
		assertEquals(context.driver.findElement(By.id(LOGIN_ERROR_MSG_ID)).getText(), WRONG_LOGIN_ERROR);
	}

	// Enter Incorrect Password

	@Test(enabled = false)
	public void testTradesmancannotloginwithwrongpassword() throws Exception {
		context.driver.get(context.getTestHttpsTMMobileURL() + MEMBERSHIP_CAMPAIGN_URL);
		Thread.sleep(1000);
		context.driver.findElement(By.xpath(MembershipcompaignXpathlocators.xpathLookup.get("PLAN1"))).click();
		assertEquals(context.driver.findElement(By.id(ASSERT_HEADER1_ID)).getText(), LOGIN_CONFIRM_MSG);
		context.driver.findElement(By.xpath(MembershipcompaignXpathlocators.xpathLookup.get("TM_MOBILE_USERNAME"))).clear();
		context.driver.findElement(By.xpath(MembershipcompaignXpathlocators.xpathLookup.get("TM_MOBILE_USERNAME"))).sendKeys(TRADESMAN);
		context.driver.findElement(By.xpath(MembershipcompaignXpathlocators.xpathLookup.get("TM_MOBILE_PASSWORD"))).clear();
		context.driver.findElement(By.xpath(MembershipcompaignXpathlocators.xpathLookup.get("TM_MOBILE_PASSWORD"))).sendKeys(WRONG_PASSWORD);
		context.driver.findElement(By.xpath(MembershipcompaignXpathlocators.xpathLookup.get("TM_MOBILE_LOGIN"))).click();
		Thread.sleep(2000);
		assertEquals(context.driver.findElement(By.id(LOGIN_ERROR_MSG_ID)).getText(), WRONG_LOGIN_ERROR);
	}

	// PMD Buy with new card

	@Test(enabled = false) 
	public void testTradesmanhasnoActivecardandBuywithNewcard() throws Exception {
		context.driver.get(context.getTestHttpsTMMobileURL() + MEMBERSHIP_CAMPAIGN_URL);
		context.driver.findElement(By.xpath(MembershipcompaignXpathlocators.xpathLookup.get("PLAN1"))).click();
		assertEquals(context.driver.findElement(By.id(ASSERT_HEADER1_ID)).getText(), LOGIN_CONFIRM_MSG);
		context.driver.findElement(By.xpath(MembershipcompaignXpathlocators.xpathLookup.get("TM_MOBILE_USERNAME"))).clear();
		context.driver.findElement(By.xpath(MembershipcompaignXpathlocators.xpathLookup.get("TM_MOBILE_USERNAME"))).sendKeys(TRADESMAN);
		context.driver.findElement(By.xpath(MembershipcompaignXpathlocators.xpathLookup.get("TM_MOBILE_PASSWORD"))).clear();
		context.driver.findElement(By.xpath(MembershipcompaignXpathlocators.xpathLookup.get("TM_MOBILE_PASSWORD"))).sendKeys(TRADESMAN_PASSWORD);
		context.driver.findElement(By.xpath(MembershipcompaignXpathlocators.xpathLookup.get("TM_MOBILE_LOGIN"))).click();
		Thread.sleep(2000);
		assertEquals(context.driver.findElement(By.id(ASSERT_HEADER1_ID)).getText(), "Confirm plan change");
		assertEquals(context.driver.findElement(By.id("paymentAmount")).getText(), "120");
		context.driver.findElement(By.id("payWithNewCard")).click();
		Thread.sleep(3000);
		assertEquals(context.driver.findElement(By.id(ASSERT_HEADER2_ID)).getText(), "Card details");
		Thread.sleep(2000);
		testFunctions1.buyMembershipCampaignwithNewCard(cardHolderName, CREDIT_CARD_NUMBER, CREDIT_CARD_TYPE, CREDIT_CARD_EXPIRY_MONTH,
				CREDIT_CARD_EXPIRY_YEAR, CV2);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='AutoNumber1']/tbody/tr[1]/td/table/tbody/tr/td/img[1]"))).getText();

		
	}

}
