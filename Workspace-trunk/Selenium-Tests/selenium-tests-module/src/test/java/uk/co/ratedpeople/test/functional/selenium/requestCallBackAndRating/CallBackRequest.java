package uk.co.ratedpeople.test.functional.selenium.requestCallBackAndRating;

import static org.testng.Assert.assertEquals;

import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import uk.co.ratedpeople.test.functional.SeleniumTestContext;
import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;
import uk.co.ratedpeople.test.functional.selenium.requestCallBackAndRating.RalXpathlocators;
import uk.co.ratedpeople.test.functional.selenium.functions.Login;

public class CallBackRequest {
	private Login login;
	private TestScriptUtilities scriptUtils;
	private WebDriver driver;
	//private PriceJobBySkill underTest;
	public static Logger logger= Logger.getLogger(" uk.co.ratedpeople.test.functional.selenium.ral");
	
	public CallBackRequest(SeleniumTestContext context, TestScriptUtilities scriptUtils) {
		this.scriptUtils = scriptUtils;
		this.driver = context.driver;
		login = new Login(scriptUtils, context);
		//underTest = new PriceJobBySkill(context, scriptUtils);
		}
	
	public void submitJobAsExistingCustomer() throws Exception {
			
		driver.get("http://preprod.preprod/");
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, 50);
		 new Select(driver.findElement(By.xpath("//*[@id='trade']"))).selectByVisibleText("Metalworker");
		 new Select(driver.findElement(By.xpath("//*[@id='jobtype']"))).selectByVisibleText("Security Grill");
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("method:submitSkillSpecificJob"))).click();
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("statusREADY_TO_HIRE"))).click();
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ownerOWN_AND_LIVE"))).click();
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ownerOWN_AND_LIVE"))).click();
		 new Select(driver.findElement(By.xpath("//*[@id='timing']"))).selectByVisibleText("Urgently");
		 driver.findElement(By.xpath("//input[@id='postcode']")).sendKeys("SW1E6AU");
		 driver.findElement(By.xpath("//html/body/div/div[2]/div/div/div/div/div/div/form/section/div[5]/textarea")).sendKeys("Submit a job via selenium tests and give rating for PMD regression testing Services required: maintainance Approximate length : 250cm-500 cm Type of work: panels, screening Posting job for testing purpose. I will supply the materials ");
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("next"))).click();
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//html/body/div/div[2]/div/div/div/div/div/div/form/section/div/p/label")));
		 new Select(driver.findElement(By.xpath("//*[@id='jobBudgetCode']"))).selectByVisibleText("Under £100");
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("next"))).click();
		 Thread.sleep(5000);
		 driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("ruhulla");
		 driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("ho");
		 driver.findElement(By.xpath("//input[@id='mobilePhone']")).sendKeys("07412463662");
		 driver.findElement(By.xpath("//input[@id='confirmPhone']")).sendKeys("07412463662");
		 driver.findElement(By.xpath("//input[@id='email']")).sendKeys("ruhhomeowner@ratedtrades.com");
		 driver.findElement(By.xpath("//input[@id='confirmEmail']")).sendKeys("ruhhomeowner@ratedtrades.com");
//		 scriptUtils.fillInXpathField(RalXpathlocators.xpathLookup.get("EMAIL"), RalXpathlocators.dataLookup.get("HOEMAIL") );
//		 scriptUtils.fillInXpathField(RalXpathlocators.xpathLookup.get("CONFIRMEMAIL"), RalXpathlocators.dataLookup.get("HOEMAIL") );
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnPostJob"))).click();
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnConfirmJob"))).click();
		 Thread.sleep(8000);
		 assertEquals(driver.findElement(By.xpath(".//*[@id='header-h1']")).getText(),"Thank you");
				
	}

	public void buyJobasExistingCustomer() throws Exception{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		logger.info(RalXpathlocators.dataLookup.get("TM_NAME")+ RalXpathlocators.dataLookup.get("TMEMAIL"));				
		login.loginTP(RalXpathlocators.dataLookup.get("TMEMAIL"),RalXpathlocators.dataLookup.get("PASSWORD"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(RalXpathlocators.xpathLookup.get("VIEW_FULL_DETAILS"))));
		scriptUtils.click(By.xpath(RalXpathlocators.xpathLookup.get("VIEW_FULL_DETAILS")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(RalXpathlocators.xpathLookup.get("BUY_BUTTON"))));
		scriptUtils.click(By.id(RalXpathlocators.xpathLookup.get("BUY_BUTTON")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(RalXpathlocators.xpathLookup.get("CONFIRM_BUTTON"))));
		scriptUtils.click(By.xpath(RalXpathlocators.xpathLookup.get("CONFIRM_BUTTON"))); // Confirm button
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(RalXpathlocators.xpathLookup.get("MAIL_CONTACT_INFO"))));
		driver.findElement(By.xpath(RalXpathlocators.xpathLookup.get("MAIL_CONTACT_INFO")));
		Thread.sleep(5000);
		}
    
	public void requestCreditBackForRPJobOldRal() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Purchased Jobs"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(RalXpathlocators.xpathLookup.get("VIEW_DETAILS"))));
		scriptUtils.click(By.xpath(RalXpathlocators.xpathLookup.get("VIEW_DETAILS")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(RalXpathlocators.xpathLookup.get("UNABLE_TO_QUOTE"))));
		scriptUtils.click(By.xpath(RalXpathlocators.xpathLookup.get("UNABLE_TO_QUOTE")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(RalXpathlocators.xpathLookup.get("STEP1_OF_3"))));
		scriptUtils.click(By.xpath(RalXpathlocators.xpathLookup.get("NEXT_STEP1")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(RalXpathlocators.xpathLookup.get("STEP2_OF_3"))));
		scriptUtils.click(By.xpath(RalXpathlocators.xpathLookup.get("CHECK_BOX1")));
		scriptUtils.click(By.xpath(RalXpathlocators.xpathLookup.get("NEXT_STEP2")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(RalXpathlocators.xpathLookup.get("STEP3_OF_3"))));
		scriptUtils.click(By.xpath(RalXpathlocators.xpathLookup.get("CONDITION_1")));
		scriptUtils.click(By.xpath(RalXpathlocators.xpathLookup.get("CONDITION_2")));
		scriptUtils.click(By.xpath(RalXpathlocators.xpathLookup.get("CONDITION_3")));
		scriptUtils.click(By.xpath(RalXpathlocators.xpathLookup.get("NEXT_STEP2")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(RalXpathlocators.xpathLookup.get("MAIL_CONTACT_INFO"))));
	}
	
	public void requestCallBackForRPJobRal() throws Exception {
		//TMDataBaseHelper.executeQuery("delete from tm_accepted_message where user_id = 392724");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Purchased Jobs"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(RalXpathlocators.xpathLookup.get("VIEW_DETAILS"))));
		scriptUtils.click(By.xpath(RalXpathlocators.xpathLookup.get("VIEW_DETAILS")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(RalXpathlocators.xpathLookup.get("UNABLE_TO_QUOTE"))));
		scriptUtils.click(By.xpath(RalXpathlocators.xpathLookup.get("UNABLE_TO_QUOTE")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(RalXpathlocators.xpathLookup.get("RAL_SEPT_1"))));
		scriptUtils.click(By.xpath(RalXpathlocators.xpathLookup.get("NEXT_STEP1")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(RalXpathlocators.xpathLookup.get("RAL_SEPT_2"))));
		scriptUtils.click(By.xpath(RalXpathlocators.xpathLookup.get("NEXT_STEP2")));
		scriptUtils.click(By.xpath(RalXpathlocators.xpathLookup.get("CONDITION_1")));
		scriptUtils.click(By.xpath(RalXpathlocators.xpathLookup.get("CONDITION_2")));
		scriptUtils.click(By.xpath(RalXpathlocators.xpathLookup.get("CANCEL")));	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(RalXpathlocators.xpathLookup.get("UNABLE_TO_QUOTE"))));
		scriptUtils.click(By.xpath(RalXpathlocators.xpathLookup.get("UNABLE_TO_QUOTE")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(RalXpathlocators.xpathLookup.get("RAL_SEPT_1"))));
		scriptUtils.click(By.xpath(RalXpathlocators.xpathLookup.get("NEXT_STEP1")));
		scriptUtils.click(By.xpath(RalXpathlocators.xpathLookup.get("NEXT_STEP2")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(RalXpathlocators.xpathLookup.get("RAL_SEPT_2"))));
		scriptUtils.click(By.xpath(RalXpathlocators.xpathLookup.get("CONDITION_1")));
		scriptUtils.click(By.xpath(RalXpathlocators.xpathLookup.get("CONDITION_2")));
		scriptUtils.click(By.xpath(RalXpathlocators.xpathLookup.get("CONDITION_3")));
		Thread.sleep(2000);
		scriptUtils.click(By.xpath(RalXpathlocators.xpathLookup.get("NEXT_STEP2")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(RalXpathlocators.xpathLookup.get("CALL_BACK_REQUESTED"))));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Purchased Jobs"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(RalXpathlocators.xpathLookup.get("VIEW_DETAILS"))));
		scriptUtils.click(By.xpath(RalXpathlocators.xpathLookup.get("VIEW_DETAILS")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(RalXpathlocators.xpathLookup.get("CALL_BACK_REQUESTED_Date"))));
		Thread.sleep(5000);
		
	}
	
	public void requestCallBackForRPJobNegative() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Purchased Jobs"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(RalXpathlocators.xpathLookup.get("VIEW_DETAILS"))));
		scriptUtils.click(By.xpath(RalXpathlocators.xpathLookup.get("VIEW_DETAILS")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(RalXpathlocators.xpathLookup.get("UNABLE_TO_QUOTE"))));
		scriptUtils.click(By.xpath(RalXpathlocators.xpathLookup.get("UNABLE_TO_QUOTE")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(RalXpathlocators.xpathLookup.get("STEP1_OF_3"))));
		scriptUtils.click(By.xpath(RalXpathlocators.xpathLookup.get("NEXT_STEP1")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(RalXpathlocators.xpathLookup.get("STEP2_OF_3"))));
		scriptUtils.click(By.xpath(RalXpathlocators.xpathLookup.get("NEXT_STEP2")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(RalXpathlocators.xpathLookup.get("CHECK_ATLEAST_ONE"))));
		scriptUtils.click(By.xpath(RalXpathlocators.xpathLookup.get("CHECK_BOX1")));
		scriptUtils.click(By.xpath(RalXpathlocators.xpathLookup.get("NEXT_STEP2")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(RalXpathlocators.xpathLookup.get("STEP3_OF_3"))));
		scriptUtils.click(By.xpath(RalXpathlocators.xpathLookup.get("NEXT_STEP2")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(RalXpathlocators.xpathLookup.get("SHOULD_ACCEPT_ALL_CONDITIONS"))));
		scriptUtils.click(By.xpath(RalXpathlocators.xpathLookup.get("CONDITION_1")));
		scriptUtils.click(By.xpath(RalXpathlocators.xpathLookup.get("CONDITION_2")));
		scriptUtils.click(By.xpath(RalXpathlocators.xpathLookup.get("CONDITION_3")));
	}
	
	public void confirmEmailSentToHO() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		login.loginSupport(RalXpathlocators.dataLookup.get("ADMIN_EMAIL"),RalXpathlocators.dataLookup.get("PASSWORD"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(RalXpathlocators.xpathLookup.get("SEARCH_TEXT_AREA"))));
		scriptUtils.fillInTextField(RalXpathlocators.xpathLookup.get("SEARCH_TEXT_AREA"),RalXpathlocators.dataLookup.get("HOEMAIL"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(RalXpathlocators.xpathLookup.get("GO_BUTTON"))));
		scriptUtils.click(By.xpath(RalXpathlocators.xpathLookup.get("GO_BUTTON")));
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(RalXpathlocators.xpathLookup.get("H0_EMAIL_SENT_BUTTON"))));
		scriptUtils.click(By.xpath(RalXpathlocators.xpathLookup.get("H0_EMAIL_SENT_BUTTON")));
		scriptUtils.click(By.xpath(RalXpathlocators.xpathLookup.get("LAST_JOB_LINK")));
	    Thread.sleep(3000);
	    scriptUtils.click(By.xpath(RalXpathlocators.xpathLookup.get("CHECK_SMS")));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(RalXpathlocators.xpathLookup.get("HO_CALL_BACK_SMS"))));
	    Thread.sleep(3000);
	}
}
