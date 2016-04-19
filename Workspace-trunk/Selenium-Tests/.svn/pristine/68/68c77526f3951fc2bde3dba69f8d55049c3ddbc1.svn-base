/**
 * 
 */
package uk.co.ratedpeople.test.functional.selenium.featureposting;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import uk.co.ratedpeople.test.functional.SeleniumTestContext;
import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;
import uk.co.ratedpeople.test.functional.selenium.functions.Login;
import uk.co.ratedpeople.test.functional.selenium.newjobforms.common.JobFormSeleniumHelper;
import uk.co.ratedpeople.test.functional.selenium.newjobforms.plasteringnrendering.PlasteringXpathlocators;


/**
 * @author shobha.rani
 *
 */
public class UpdateFeatureJob extends TestScriptUtilities {
	public static Logger logger = Logger.getLogger("uk.co.ratedpeople.test.functional.selenium.featureposting");
	private WebDriver driver;
	private String testUrl;
	private Login login;
	private SeleniumTestContext context;	
	private TestScriptUtilities scriptUtils;
	private String userName = "shobha.rani@ratedtrades.com";
	private String password = "password";
	private String postcode = "M46 0DB";
	private static final String THANK_YOU_UPDATE_TEXT = "Thank you for updating your job";
	private static final String THANK_YOU_FEATURE_COMMS = "Thank you for upgrading to a Featured Posting";
	private static final String ADDED_DESCRIPTION = " - Text added to description";
	private static final String PAYPAL_EMAIL_ID = "adam.walker-personal@ratedpeople.com";
	private static final String PAYPAL_PASSWD = "ratedpeople1";
	private static final String PAY_DESCRIPTION = "Rated People Featu…";
	private static final String PAYPAL_PRICE = "£6.99";
	private static final String TPWEB_FEATUREPOST_WORD = "**Featured Lead**";
	private static final String TPWEB_DESCRIPTION_FEATURED = "**Featured Lead**";
	private static final String PAYPAL_CONFIRM_COMMS = "Confirm your upgrade";
	private static final String PAYPAL_CANCEL_DISPLAY_MSG = "Feature posting cancelled, no payment has been taken.";
	private static final String MK3_FP_POSTEDJOBS = "FEATURED POST";
	public UpdateFeatureJob(final SeleniumTestContext context, final TestScriptUtilities scriptUtils) {

		super(context);
		
		this.driver = context.driver;
		this.testUrl = context.getTestUrl();
		this.testUrl = testUrl.replaceAll("http://", "https://");
		new WebDriverWait(driver, 30);
		this.context = context;
		login = new Login(scriptUtils, context);
		
		
	}
	
	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public String getPostcode() {
		return postcode;
	}
	public void loginToHomeownersApp(final String userName, final String password) {
	
		String httpsUrl = context.getTestHttpsUrl();
		String hoUrl = "";
		if (httpsUrl.indexOf("preprod") != -1) {
			hoUrl = "http://homeowners.preprod";
		} else if (httpsUrl.indexOf("tokyo") != -1) {
			hoUrl = "http://homeowners-tokyo.uk.ratedpeople";
		} else {
			fail("Invalid environment");
		}

		goTo(hoUrl + "/login");

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
		clear(By.id("username"));
		fillInTextField("username", userName);
		clear(By.id("password"));
		fillInTextField("password", password);

		click(By.id("btn_login"));
	}

	public String goToJobPage() throws Exception{
		sleep(5000);
		click(By.xpath(".//*[@id='job-list']/li[1]/a/span[3]"));
		sleep(3000);
		String jobPageUrl = driver.getCurrentUrl();
		return jobPageUrl;
	}

	public void clickUpdateJob() throws Exception{
		click(By.xpath("html/body/div[2]/div/div[1]/section[2]/div/div/a"));
		sleep(3000);
		
	}
	
	
	// Mk3 HO posted jobs 
	public void verifyCCAHOFeaturepostedjobs() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		login.loginSupport(FeaturepostXpathLocators.datalookup.get("ADMIN_EMAIL"),FeaturepostXpathLocators.datalookup.get("PASSWORD"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(FeaturepostXpathLocators.xpathLookup.get("MK3_SEARCH"))));
		fillInTextField(FeaturepostXpathLocators.xpathLookup.get("MK3_SEARCH"), FeaturepostXpathLocators.datalookup.get("HO_EMAIL_ID"));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(FeaturepostXpathLocators.xpathLookup.get("MK3_GO"))));
		click(By.id(FeaturepostXpathLocators.xpathLookup.get("MK3_GO")));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FeaturepostXpathLocators.xpathLookup.get("MK3_POSTED_JOB"))));
		click(By.xpath(FeaturepostXpathLocators.xpathLookup.get("MK3_POSTED_JOB")));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(FeaturepostXpathLocators.xpathLookup.get("POSTED_JOBS_DETAILS"))));
		click(By.id(FeaturepostXpathLocators.xpathLookup.get("POSTED_JOBS_DETAILS")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FeaturepostXpathLocators.xpathLookup.get("MK3_POSTEDJOBS_FP"))));
		String Mk3_Feature_wording = this.getValue(FeaturepostXpathLocators.xpathLookup.get("MK3_POSTEDJOBS_FP"));
		assertEquals(Mk3_Feature_wording, MK3_FP_POSTEDJOBS);
		
		
		
	}
	
	public void Featurebuttonspresent() throws Exception
	{
		
		WebDriverWait wait=new 	WebDriverWait(context.driver,60); 
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(FeaturepostXpathLocators.classlocators.get("FEATURE_POST_BUTTON"))));
		//click(By.className(FeaturepostXpathLocators.classlocators.get("FEATURE_POST_BUTTON")));
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(FeaturepostXpathLocators.classlocators.get("FREE_POST_BUTTON"))));
		//click(By.className(FeaturepostXpathLocators.classlocators.get("FREE_POST_BUTTON")));
		String Feature_your_Job_wording = this.getValue(FeaturepostXpathLocators.xpathLookup.get("FEATURE_POST_WORDING"));
		assertEquals(Feature_your_Job_wording, "FEATURED POSTING - SHOW YOU'RE SERIOUS, ENSURE YOU'RE SEEN");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FeaturepostXpathLocators.xpathLookup.get("UPGRADE_AND_PAY_BUTTON"))));
		click(By.xpath(FeaturepostXpathLocators.xpathLookup.get("UPGRADE_AND_PAY_BUTTON")));
		sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FeaturepostXpathLocators.xpathLookup.get("FEATURE_POST_BUTTON"))));
		click(By.xpath(FeaturepostXpathLocators.xpathLookup.get("FEATURE_POST_BUTTON")));
		sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FeaturepostXpathLocators.xpathLookup.get("FREE_POST_BUTTON"))));
		click(By.xpath(FeaturepostXpathLocators.xpathLookup.get("FREE_POST_BUTTON")));
		sleep(2000);
			
	}
	
	
	
	
	public void freepostjobcomms() throws Exception
	{
		WebDriverWait wait=new 	WebDriverWait(context.driver,60);
		String Feature_your_Job_wording = this.getValue(FeaturepostXpathLocators.xpathLookup.get("FEATURE_POST_WORDING"));
		assertEquals(Feature_your_Job_wording, "FEATURED POSTING - SHOW YOU'RE SERIOUS, ENSURE YOU'RE SEEN");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FeaturepostXpathLocators.xpathLookup.get("UPGRADE_AND_PAY_BUTTON"))));
		click(By.xpath(FeaturepostXpathLocators.xpathLookup.get("UPGRADE_AND_PAY_BUTTON")));
		sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(FeaturepostXpathLocators.xpathLookup.get("UPDATE_DESCRIPTION"))));
		fillInTextField("JobUpdate_description", ADDED_DESCRIPTION);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FeaturepostXpathLocators.xpathLookup.get("FREE_POST_BUTTON"))));
		click(By.xpath(FeaturepostXpathLocators.xpathLookup.get("FREE_POST_BUTTON")));
		sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(FeaturepostXpathLocators.xpathLookup.get("UPDATE_YOUR_JOB_POSTING_BUTTON"))));
		click(By.id(FeaturepostXpathLocators.xpathLookup.get("UPDATE_YOUR_JOB_POSTING_BUTTON")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FeaturepostXpathLocators.xpathLookup.get("THANKYOU_UPDATING_TEXT"))));
		String thankyou_update_your_Job = this.getValue(FeaturepostXpathLocators.xpathLookup.get("THANKYOU_UPDATING_TEXT"));
		assertEquals(thankyou_update_your_Job, THANK_YOU_UPDATE_TEXT);					
	}
	
	// post job featurepost paypal
	public void Featurepostjobcomms() throws Exception
	{
		
		WebDriverWait wait=new 	WebDriverWait(context.driver,60);
		String Feature_your_Job_wording = this.getValue(FeaturepostXpathLocators.xpathLookup.get("FEATURE_POST_WORDING"));
		assertEquals(Feature_your_Job_wording, "FEATURED POSTING - SHOW YOU'RE SERIOUS, ENSURE YOU'RE SEEN");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FeaturepostXpathLocators.xpathLookup.get("UPGRADE_AND_PAY_BUTTON"))));
		click(By.xpath(FeaturepostXpathLocators.xpathLookup.get("UPGRADE_AND_PAY_BUTTON")));
		sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(FeaturepostXpathLocators.xpathLookup.get("UPDATE_DESCRIPTION"))));
		fillInTextField("JobUpdate_description", ADDED_DESCRIPTION);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FeaturepostXpathLocators.xpathLookup.get("FEATURE_POST_BUTTON"))));
		click(By.xpath(FeaturepostXpathLocators.xpathLookup.get("FEATURE_POST_BUTTON")));
		sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(FeaturepostXpathLocators.xpathLookup.get("UPDATE_YOUR_JOB_POSTING_BUTTON"))));
		click(By.id(FeaturepostXpathLocators.xpathLookup.get("UPDATE_YOUR_JOB_POSTING_BUTTON")));
		//pay througlogin.loginTPh paypal account
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(FeaturepostXpathLocators.xpathLookup.get("PAYPAL_EMAIL_ID"))));
		clear(By.id("login_email"));
		fillInTextField("login_email", PAYPAL_EMAIL_ID);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(FeaturepostXpathLocators.xpathLookup.get("PAYPAL_PWD"))));
		clear(By.id("login_password"));
		fillInTextField("login_password", PAYPAL_PASSWD);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(FeaturepostXpathLocators.xpathLookup.get("PAYPAL_LOGIN"))));
		click(By.id(FeaturepostXpathLocators.xpathLookup.get("PAYPAL_LOGIN")));
		// Assert price, description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FeaturepostXpathLocators.xpathLookup.get("PAYPAL_DESCRIPTION"))));
		String description = this.getValue(FeaturepostXpathLocators.xpathLookup.get("PAYPAL_DESCRIPTION"));
		assertEquals(description, PAY_DESCRIPTION);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FeaturepostXpathLocators.xpathLookup.get("PAYPAL_JOB_PRICE"))));
		String price = this.getValue(FeaturepostXpathLocators.xpathLookup.get("PAYPAL_JOB_PRICE"));
		assertEquals(price, PAYPAL_PRICE);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(FeaturepostXpathLocators.xpathLookup.get("PAYPAL_CONTINUE"))));
		click(By.id(FeaturepostXpathLocators.xpathLookup.get("PAYPAL_CONTINUE")));
		// Paypal Confirm page
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FeaturepostXpathLocators.xpathLookup.get("PAYPAL_CONFIRM_MSG"))));
		assertEquals(driver.findElement(By.xpath(FeaturepostXpathLocators.xpathLookup.get("PAYPAL_CONFIRM_MSG"))).getText(),PAYPAL_CONFIRM_COMMS);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(FeaturepostXpathLocators.xpathLookup.get("PAYPAL_CONFIRM_BUTTON"))));
		click(By.id(FeaturepostXpathLocators.xpathLookup.get("PAYPAL_CONFIRM_BUTTON")));		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FeaturepostXpathLocators.xpathLookup.get("FEATURE_THANK_YOU_COMMS"))));
		String thankyou_update_feature_Job = this.getValue(FeaturepostXpathLocators.xpathLookup.get("FEATURE_THANK_YOU_COMMS"));
		assertEquals(thankyou_update_feature_Job, THANK_YOU_FEATURE_COMMS);	
	}
	// Cancel job on Paypal confirm and again upgrading to feature post
	public void FeaturepostCancelandUpgradejob() throws Exception
	{
		WebDriverWait wait=new 	WebDriverWait(context.driver,60);
		String Feature_your_Job_wording = this.getValue(FeaturepostXpathLocators.xpathLookup.get("FEATURE_POST_WORDING"));
		assertEquals(Feature_your_Job_wording, "FEATURED POSTING - SHOW YOU'RE SERIOUS, ENSURE YOU'RE SEEN");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FeaturepostXpathLocators.xpathLookup.get("UPGRADE_AND_PAY_BUTTON"))));
		click(By.xpath(FeaturepostXpathLocators.xpathLookup.get("UPGRADE_AND_PAY_BUTTON")));
		sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(FeaturepostXpathLocators.xpathLookup.get("UPDATE_DESCRIPTION"))));
		fillInTextField("JobUpdate_description", ADDED_DESCRIPTION);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FeaturepostXpathLocators.xpathLookup.get("FEATURE_POST_BUTTON"))));
		click(By.xpath(FeaturepostXpathLocators.xpathLookup.get("FEATURE_POST_BUTTON")));
		sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(FeaturepostXpathLocators.xpathLookup.get("UPDATE_YOUR_JOB_POSTING_BUTTON"))));
		click(By.id(FeaturepostXpathLocators.xpathLookup.get("UPDATE_YOUR_JOB_POSTING_BUTTON")));
		//pay througlogin.loginTPh paypal account
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(FeaturepostXpathLocators.xpathLookup.get("PAYPAL_EMAIL_ID"))));
		clear(By.id("login_email"));
		fillInTextField("login_email", PAYPAL_EMAIL_ID);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(FeaturepostXpathLocators.xpathLookup.get("PAYPAL_PWD"))));
		clear(By.id("login_password"));
		fillInTextField("login_password", PAYPAL_PASSWD);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(FeaturepostXpathLocators.xpathLookup.get("PAYPAL_LOGIN"))));
		click(By.id(FeaturepostXpathLocators.xpathLookup.get("PAYPAL_LOGIN")));
		// Assert price, description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FeaturepostXpathLocators.xpathLookup.get("PAYPAL_DESCRIPTION"))));
		String description = this.getValue(FeaturepostXpathLocators.xpathLookup.get("PAYPAL_DESCRIPTION"));
		assertEquals(description, PAY_DESCRIPTION);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FeaturepostXpathLocators.xpathLookup.get("PAYPAL_JOB_PRICE"))));
		String price = this.getValue(FeaturepostXpathLocators.xpathLookup.get("PAYPAL_JOB_PRICE"));
		assertEquals(price, PAYPAL_PRICE);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(FeaturepostXpathLocators.xpathLookup.get("PAYPAL_CONTINUE"))));
		click(By.id(FeaturepostXpathLocators.xpathLookup.get("PAYPAL_CONTINUE")));
		// Paypal Confirm page
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FeaturepostXpathLocators.xpathLookup.get("PAYPAL_CONFIRM_MSG"))));
		assertEquals(driver.findElement(By.xpath(FeaturepostXpathLocators.xpathLookup.get("PAYPAL_CONFIRM_MSG"))).getText(),PAYPAL_CONFIRM_COMMS);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(FeaturepostXpathLocators.xpathLookup.get("PAYPAL_CANCEL_BUTTON"))));
		click(By.id(FeaturepostXpathLocators.xpathLookup.get("PAYPAL_CANCEL_BUTTON")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FeaturepostXpathLocators.xpathLookup.get("CANCEL_JOB_MSG"))));
		assertEquals(driver.findElement(By.xpath(FeaturepostXpathLocators.xpathLookup.get("CANCEL_JOB_MSG"))).getText(),PAYPAL_CANCEL_DISPLAY_MSG);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FeaturepostXpathLocators.xpathLookup.get("FEATURE_POST_BUTTON"))));
		click(By.xpath(FeaturepostXpathLocators.xpathLookup.get("FEATURE_POST_BUTTON")));
		sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(FeaturepostXpathLocators.xpathLookup.get("UPDATE_YOUR_JOB_POSTING_BUTTON"))));
		click(By.id(FeaturepostXpathLocators.xpathLookup.get("UPDATE_YOUR_JOB_POSTING_BUTTON")));
		//pay througlogin.loginTPh paypal account
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(FeaturepostXpathLocators.xpathLookup.get("PAYPAL_EMAIL_ID"))));
		clear(By.id("login_email"));
		fillInTextField("login_email", PAYPAL_EMAIL_ID);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(FeaturepostXpathLocators.xpathLookup.get("PAYPAL_PWD"))));
		clear(By.id("login_password"));
		fillInTextField("login_password", PAYPAL_PASSWD);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(FeaturepostXpathLocators.xpathLookup.get("PAYPAL_LOGIN"))));
		click(By.id(FeaturepostXpathLocators.xpathLookup.get("PAYPAL_LOGIN")));
		// Assert price, description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FeaturepostXpathLocators.xpathLookup.get("PAYPAL_DESCRIPTION"))));
		String description1 = this.getValue(FeaturepostXpathLocators.xpathLookup.get("PAYPAL_DESCRIPTION"));
		assertEquals(description1, PAY_DESCRIPTION);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FeaturepostXpathLocators.xpathLookup.get("PAYPAL_JOB_PRICE"))));
		String price1 = this.getValue(FeaturepostXpathLocators.xpathLookup.get("PAYPAL_JOB_PRICE"));
		assertEquals(price1, PAYPAL_PRICE);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(FeaturepostXpathLocators.xpathLookup.get("PAYPAL_CONTINUE"))));
		click(By.id(FeaturepostXpathLocators.xpathLookup.get("PAYPAL_CONTINUE")));
		// Paypal Confirm page
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FeaturepostXpathLocators.xpathLookup.get("PAYPAL_CONFIRM_MSG"))));
		assertEquals(driver.findElement(By.xpath(FeaturepostXpathLocators.xpathLookup.get("PAYPAL_CONFIRM_MSG"))).getText(),PAYPAL_CONFIRM_COMMS);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(FeaturepostXpathLocators.xpathLookup.get("PAYPAL_CONFIRM_BUTTON"))));
		click(By.id(FeaturepostXpathLocators.xpathLookup.get("PAYPAL_CONFIRM_BUTTON")));		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FeaturepostXpathLocators.xpathLookup.get("FEATURE_THANK_YOU_COMMS"))));
		String thankyou_update_feature_Job = this.getValue(FeaturepostXpathLocators.xpathLookup.get("FEATURE_THANK_YOU_COMMS"));
		assertEquals(thankyou_update_feature_Job, THANK_YOU_FEATURE_COMMS);	
	}
	
	// Cancel job on Paypal confirm and again posting Freepost job
		public void FeaturepostCancelandFreepostjob() throws Exception
		{

			WebDriverWait wait=new 	WebDriverWait(context.driver,60);
			String Feature_your_Job_wording = this.getValue(FeaturepostXpathLocators.xpathLookup.get("FEATURE_POST_WORDING"));
			assertEquals(Feature_your_Job_wording, "FEATURED POSTING - SHOW YOU'RE SERIOUS, ENSURE YOU'RE SEEN");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FeaturepostXpathLocators.xpathLookup.get("UPGRADE_AND_PAY_BUTTON"))));
			click(By.xpath(FeaturepostXpathLocators.xpathLookup.get("UPGRADE_AND_PAY_BUTTON")));
			sleep(3000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(FeaturepostXpathLocators.xpathLookup.get("UPDATE_DESCRIPTION"))));
			fillInTextField("JobUpdate_description", ADDED_DESCRIPTION);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FeaturepostXpathLocators.xpathLookup.get("FEATURE_POST_BUTTON"))));
			click(By.xpath(FeaturepostXpathLocators.xpathLookup.get("FEATURE_POST_BUTTON")));
			sleep(2000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(FeaturepostXpathLocators.xpathLookup.get("UPDATE_YOUR_JOB_POSTING_BUTTON"))));
			click(By.id(FeaturepostXpathLocators.xpathLookup.get("UPDATE_YOUR_JOB_POSTING_BUTTON")));
			//pay througlogin.loginTPh paypal account
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(FeaturepostXpathLocators.xpathLookup.get("PAYPAL_EMAIL_ID"))));
			clear(By.id("login_email"));
			fillInTextField("login_email", PAYPAL_EMAIL_ID);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(FeaturepostXpathLocators.xpathLookup.get("PAYPAL_PWD"))));
			clear(By.id("login_password"));
			fillInTextField("login_password", PAYPAL_PASSWD);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(FeaturepostXpathLocators.xpathLookup.get("PAYPAL_LOGIN"))));
			click(By.id(FeaturepostXpathLocators.xpathLookup.get("PAYPAL_LOGIN")));
			// Assert price, description
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FeaturepostXpathLocators.xpathLookup.get("PAYPAL_DESCRIPTION"))));
			String description = this.getValue(FeaturepostXpathLocators.xpathLookup.get("PAYPAL_DESCRIPTION"));
			assertEquals(description, PAY_DESCRIPTION);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FeaturepostXpathLocators.xpathLookup.get("PAYPAL_JOB_PRICE"))));
			String price = this.getValue(FeaturepostXpathLocators.xpathLookup.get("PAYPAL_JOB_PRICE"));
			assertEquals(price, PAYPAL_PRICE);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(FeaturepostXpathLocators.xpathLookup.get("PAYPAL_CONTINUE"))));
			click(By.id(FeaturepostXpathLocators.xpathLookup.get("PAYPAL_CONTINUE")));
			// Paypal Confirm page
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FeaturepostXpathLocators.xpathLookup.get("PAYPAL_CONFIRM_MSG"))));
			assertEquals(driver.findElement(By.xpath(FeaturepostXpathLocators.xpathLookup.get("PAYPAL_CONFIRM_MSG"))).getText(),PAYPAL_CONFIRM_COMMS);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(FeaturepostXpathLocators.xpathLookup.get("PAYPAL_CANCEL_BUTTON"))));
			click(By.id(FeaturepostXpathLocators.xpathLookup.get("PAYPAL_CANCEL_BUTTON")));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FeaturepostXpathLocators.xpathLookup.get("CANCEL_JOB_MSG"))));
			assertEquals(driver.findElement(By.xpath(FeaturepostXpathLocators.xpathLookup.get("CANCEL_JOB_MSG"))).getText(),PAYPAL_CANCEL_DISPLAY_MSG);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FeaturepostXpathLocators.xpathLookup.get("FREE_POST_BUTTON"))));
			click(By.xpath(FeaturepostXpathLocators.xpathLookup.get("FREE_POST_BUTTON")));
			sleep(2000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(FeaturepostXpathLocators.xpathLookup.get("UPDATE_YOUR_JOB_POSTING_BUTTON"))));
			click(By.id(FeaturepostXpathLocators.xpathLookup.get("UPDATE_YOUR_JOB_POSTING_BUTTON")));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FeaturepostXpathLocators.xpathLookup.get("THANKYOU_UPDATING_TEXT"))));
			String thankyou_update_your_Job = this.getValue(FeaturepostXpathLocators.xpathLookup.get("THANKYOU_UPDATING_TEXT"));
			assertEquals(thankyou_update_your_Job, THANK_YOU_UPDATE_TEXT);
		
		}
	
	public void Updateyourjobposting() throws Exception
	{
		WebDriverWait wait=new 	WebDriverWait(context.driver,60);
		click(By.xpath("html/body/div[2]/div/div[1]/section[2]/div/div/a"));
		sleep(3000);
		// update any description 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(FeaturepostXpathLocators.xpathLookup.get("UPDATE_YOUR_JOB_POSTING_BUTTON"))));
		click(By.id(FeaturepostXpathLocators.xpathLookup.get("UPDATE_YOUR_JOB_POSTING_BUTTON")));
		sleep(2000);
		String thankyou_update_your_Job = this.getValue(FeaturepostXpathLocators.xpathLookup.get("THANKYOU_UPDATING_TEXT"));
		assertEquals(thankyou_update_your_Job, THANK_YOU_UPDATE_TEXT);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(FeaturepostXpathLocators.classlocators.get("UPGRADE_AND_PAY_BUTTON"))));
		
		
	}
	
	public void loginTP(String TPusername, String TPpassword) {
//		logoutAdmin();
		scriptUtils.goTo(testUrl);
		scriptUtils.goTo(testUrl + "/log-in");
		scriptUtils.sleep(2000);
		WebDriverWait wait = new WebDriverWait(context.driver, 50);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tpUserName")));
	    clear(By.id("tpUserName"));
		scriptUtils.fillInTextField("tpUserName", TPusername);
		clear(By.id("tpPassword"));
		scriptUtils.fillInTextField("tpPassword", TPpassword);
		scriptUtils.click("login-as-tp-button");
		scriptUtils.sleep(3000);
	
	}
	public void loginTMapp(String username,String password){
		login.loginTP(username, password);
	}
	
	public void tmTPWebLogin() throws Exception {
		WebDriverWait wait = new WebDriverWait(context.driver, 50);
		login.loginTP(FeaturepostXpathLocators.datalookup.get("TM_DESKTOP_EMAIL"),FeaturepostXpathLocators.datalookup.get("PASSWORD"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FeaturepostXpathLocators.xpathLookup.get("VIEW_FULL_DETAILS"))));
		logger.info("Logged into TPWEB ");		
		// to assert Feature job description
		String getfeatureText= this.getValue(FeaturepostXpathLocators.xpathLookup.get("TPWEB_FEATUREPOST_XPATH")); 
		assertEquals(getfeatureText,TPWEB_FEATUREPOST_WORD);	
		logger.info("Asserted first feature post word " + getfeatureText);
		click(By.xpath(FeaturepostXpathLocators.xpathLookup.get("VIEW_FULL_DETAILS")));		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FeaturepostXpathLocators.xpathLookup.get("BUY_BUTTON"))));
		String getfeaturedText= this.getValue(FeaturepostXpathLocators.xpathLookup.get("TPWEB_JOB_DESCRIPTION"));
		assertEquals(getfeaturedText,TPWEB_DESCRIPTION_FEATURED);
		click(By.xpath(FeaturepostXpathLocators.xpathLookup.get("BUY_BUTTON")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FeaturepostXpathLocators.xpathLookup.get("CONFIRM_BUTTON"))));
		click(By.xpath(FeaturepostXpathLocators.xpathLookup.get("CONFIRM_BUTTON")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FeaturepostXpathLocators.xpathLookup.get("CONTACT_INFO"))));
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FeaturepostXpathLocators.xpathLookup.get("PURCHASED_JOBS"))));
	//	click(By.xpath(FeaturepostXpathLocators.xpathLookup.get("PURCHASED_JOBS")));
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FeaturepostXpathLocators.xpathLookup.get("VIEW_DETAILS"))));
	//	click(By.xpath(FeaturepostXpathLocators.xpathLookup.get("VIEW_DETAILS")));
	//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FeaturepostXpathLocators.xpathLookup.get("TPWEB_JOB_DESCRIPTION"))));
		//String purchase_feature_text = this.getValue(FeaturepostXpathLocators.xpathLookup.get("TPWEB_JOB_DESCRIPTION"));
		//assertEquals(purchase_feature_text, TPWEB_FEATUREPOST_WORD);
		
		//String newDescription = updateJob.updateJobDescription(jobPageUrl, ADDED_DESCRIPTION);
	//	System.out.println(newDescription.startsWith("*PRIORITY LEAD* \n Changed information:description " + DESCRIPTION + ADDED_DESCRIPTION ));
	//	assertTrue(newDescription.startsWith("*PRIORITY LEAD*" +"\nChanged information:description"));
	}
	
	public void postingJobviaNewGenericJobformDotCom(final String userName, final String postcode, final String skillTypeId, final String trade, final String description) throws Exception {
		getlandingPage("", skillTypeId, trade);
		//jobDetailsGeneric();
		additionalInfo(description, postcode);
		budget(3);
		location(userName);
	}
	
	public void getlandingPage(String passUrl, String jobTypeValue, String tradeTypeValue) throws Exception {
		scriptUtils.getQuotes(testUrl + passUrl, driver, jobTypeValue, tradeTypeValue);
	}
	public void additionalInfo(final String description, final String postcode) throws Exception {
		scriptUtils.selectDropdown(By.xpath(GenericJobformXpathLocators.xpathLookup.get("timing")), TestScriptUtilities.getRandomNumber(6));
		scriptUtils.fillInXpathField(GenericJobformXpathLocators.xpathLookup.get("textareaadditionalinfo"), description);
		scriptUtils.fillInTextField("postcode", postcode);
		scriptUtils.click(By.xpath(GenericJobformXpathLocators.xpathLookup.get("stagetwonext")));
	}




public void budget(int budget) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 3000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(GenericJobformXpathLocators.xpathLookup.get("budget"))));
		scriptUtils.selectDropdown(By.xpath(GenericJobformXpathLocators.xpathLookup.get("budget")), TestScriptUtilities.getRandomNumber(budget));
		scriptUtils.click(By.xpath(GenericJobformXpathLocators.xpathLookup.get("stagethreenext")));
		// Thread.sleep(3000);
	}

public void location(final String userName) throws Exception {
		String phone = PlasteringXpathlocators.dataLookup.get("mobile");

		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtils, context, TestScriptUtilities.getRandomAlphabeticString(3),
				TestScriptUtilities.getRandomAlphabeticString(3), phone, phone, userName, userName);

		String getheaderText = driver.findElement(By.xpath(PlasteringXpathlocators.xpathLookup.get("headerthanku"))).getText();
		logger.info("Header Text is : " + getheaderText);
		assertEquals(getheaderText, PlasteringXpathlocators.dataLookup.get("headertxt"));
	}
}


