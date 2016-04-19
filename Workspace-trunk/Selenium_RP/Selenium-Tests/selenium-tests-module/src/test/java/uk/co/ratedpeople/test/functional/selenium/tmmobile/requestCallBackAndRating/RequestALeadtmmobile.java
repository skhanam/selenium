package uk.co.ratedpeople.test.functional.selenium.tmmobile.requestCallBackAndRating;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import uk.co.ratedpeople.test.functional.SeleniumTestContext;
import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;
import uk.co.ratedpeople.test.functional.selenium.tmmobile.requestCallBackAndRating.RalXpathlocatorstmmobile;
import uk.co.ratedpeople.test.functional.selenium.tmmobile.functions.TestFunctions;
import uk.co.ratedpeople.test.functional.selenium.tmmobile.Login;

public class RequestALeadtmmobile{
	private TestScriptUtilities scriptUtils;
	private Login tmLogin;
	private WebDriver driver;
	private TestFunctions testFunctions;
	private String jobRef;
	private uk.co.ratedpeople.test.functional.selenium.functions.Login blogin;	
	

public RequestALeadtmmobile(SeleniumTestContext context, TestScriptUtilities scriptUtils) {
	this.scriptUtils = scriptUtils;
	this.driver = context.driver;
	driver = context.driver;
	testFunctions = new TestFunctions(driver);
	tmLogin = new Login(context);
	blogin = new uk.co.ratedpeople.test.functional.selenium.functions.Login(scriptUtils, context);
		}

public void requestCallBackForRPJob() throws Exception {
	    //TMDataBaseHelper.executeQuery("delete from tm_accepted_message where user_id = 374316");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		jobRef = testFunctions.homeOwnerSubmitsJobAndTradesmanBuysIt(Login.TRADESMAN, Login.TRADESMAN_PASSWORD);
		tmLogin.login();		
		/*wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(RalXpathlocatorstmmobile.xpathLookup.get("TERMS_AND_CONDITIONS"))));
		Thread.sleep(2000);
		scriptUtils.click(By.xpath(RalXpathlocatorstmmobile.xpathLookup.get("TANDC_ACCEPT_OK")));
		Thread.sleep(2000);
		scriptUtils.click(By.xpath(RalXpathlocatorstmmobile.xpathLookup.get("TANDC_CHECKBOX")));
		scriptUtils.click(By.xpath(RalXpathlocatorstmmobile.xpathLookup.get("TANDC_ACCEPT_OK")));*/
		Thread.sleep(2000);
		driver.findElement(By.id("nav-toggle")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("nav-jobs")).click();
		Thread.sleep(1000);
		testFunctions.clickOnJob(jobRef);
		/*wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(RalXpathlocatorstmmobile.xpathLookup.get("MEMBERSHIP_OFFER_MESSAGE"))));
		driver.findElement(By.id("tmBulletinOverlayDismissBtn")).click();*/
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(RalXpathlocatorstmmobile.xpathLookup.get("CUSTOMER_DETAILS"))));
		scriptUtils.click(By.id(RalXpathlocatorstmmobile.xpathLookup.get("REQUEST_CALLBACK_LINK")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(RalXpathlocatorstmmobile.xpathLookup.get("UNABLE_TO_QUOTE"))));
		scriptUtils.click(By.id(RalXpathlocatorstmmobile.xpathLookup.get("LINK_NEXT")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(RalXpathlocatorstmmobile.xpathLookup.get("CONFIRM_ALL_CHECKED"))));
		scriptUtils.click(By.id(RalXpathlocatorstmmobile.xpathLookup.get("BTN_NEXT")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(RalXpathlocatorstmmobile.xpathLookup.get("VALIDATION_CHECK"))));
		scriptUtils.click(By.id(RalXpathlocatorstmmobile.xpathLookup.get("CHECKBOX_0")));
		scriptUtils.click(By.id(RalXpathlocatorstmmobile.xpathLookup.get("CHECKBOX_1")));
		scriptUtils.click(By.id(RalXpathlocatorstmmobile.xpathLookup.get("CANCEL_LINK")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(RalXpathlocatorstmmobile.xpathLookup.get("CUSTOMER_DETAILS"))));
		scriptUtils.click(By.id(RalXpathlocatorstmmobile.xpathLookup.get("REQUEST_CALLBACK_LINK")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(RalXpathlocatorstmmobile.xpathLookup.get("UNABLE_TO_QUOTE"))));
		scriptUtils.click(By.id(RalXpathlocatorstmmobile.xpathLookup.get("LINK_NEXT")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(RalXpathlocatorstmmobile.xpathLookup.get("CONFIRM_ALL_CHECKED"))));
		scriptUtils.click(By.id(RalXpathlocatorstmmobile.xpathLookup.get("CHECKBOX_0")));
		scriptUtils.click(By.id(RalXpathlocatorstmmobile.xpathLookup.get("CHECKBOX_1")));
		scriptUtils.click(By.id(RalXpathlocatorstmmobile.xpathLookup.get("CHECKBOX_2")));
		scriptUtils.click(By.id(RalXpathlocatorstmmobile.xpathLookup.get("BTN_NEXT")));
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(RalXpathlocatorstmmobile.xpathLookup.get("CALLBACK_REQUESTED"))));
		scriptUtils.click(By.id(RalXpathlocatorstmmobile.xpathLookup.get("LINK_TO_CHECK_CALLBACK_REQUESTED")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(RalXpathlocatorstmmobile.xpathLookup.get("CALLBACK_REQUESTED_DATE_CHECK"))));
		// go back into job and check that credit requested
		driver.findElement(By.id("nav-toggle")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("nav-jobs")).click();
		Thread.sleep(1000);
		testFunctions.clickOnJob(jobRef);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(RalXpathlocatorstmmobile.xpathLookup.get("CALLBACK_REQUESTED_DATE_CHECK"))));
		Thread.sleep(5000);
		}

public void requestACreditBackForRPJobOldRal() throws Exception {
	WebDriverWait wait = new WebDriverWait(driver, 10);
	jobRef = testFunctions.homeOwnerSubmitsJobAndTradesmanBuysIt(Login.TRADESMAN, Login.TRADESMAN_PASSWORD);
	tmLogin.login();
	driver.findElement(By.id("nav-toggle")).click();
	Thread.sleep(1000);
	driver.findElement(By.id("nav-jobs")).click();
	Thread.sleep(1000);
	testFunctions.clickOnJob(jobRef);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(RalXpathlocatorstmmobile.xpathLookup.get("CUSTOMER_DETAILS"))));
	scriptUtils.click(By.id(RalXpathlocatorstmmobile.xpathLookup.get("REQUEST_CALLBACK_LINK")));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(RalXpathlocatorstmmobile.xpathLookup.get("UNABLE_TO_QUOTE_OLD"))));
	scriptUtils.click(By.id(RalXpathlocatorstmmobile.xpathLookup.get("LINK_NEXT")));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(RalXpathlocatorstmmobile.xpathLookup.get("CREDITREQUEST_REASON_UNABLE_TO_CONTACT"))));
	scriptUtils.click(By.id(RalXpathlocatorstmmobile.xpathLookup.get("CREDITREQUEST_REASON_UNABLE_TO_CONTACT")));
	scriptUtils.click(By.id(RalXpathlocatorstmmobile.xpathLookup.get("BTN_NEXT")));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(RalXpathlocatorstmmobile.xpathLookup.get("CONFIRM_ALL_CHECKED_OLD"))));
	scriptUtils.click(By.id(RalXpathlocatorstmmobile.xpathLookup.get("BTN_SUBMIT")));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(RalXpathlocatorstmmobile.xpathLookup.get("VALIDATION_CHECK"))));
	scriptUtils.click(By.id(RalXpathlocatorstmmobile.xpathLookup.get("CHECKBOX_0_OLD")));
	scriptUtils.click(By.id(RalXpathlocatorstmmobile.xpathLookup.get("CHECKBOX_1_OLD")));
	scriptUtils.click(By.id(RalXpathlocatorstmmobile.xpathLookup.get("CANCEL_LINK")));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(RalXpathlocatorstmmobile.xpathLookup.get("CUSTOMER_DETAILS"))));
	scriptUtils.click(By.id(RalXpathlocatorstmmobile.xpathLookup.get("REQUEST_CALLBACK_LINK")));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(RalXpathlocatorstmmobile.xpathLookup.get("UNABLE_TO_QUOTE_OLD"))));
	scriptUtils.click(By.id(RalXpathlocatorstmmobile.xpathLookup.get("LINK_NEXT")));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(RalXpathlocatorstmmobile.xpathLookup.get("CREDITREQUEST_REASON_UNABLE_TO_CONTACT"))));
	scriptUtils.click(By.id(RalXpathlocatorstmmobile.xpathLookup.get("CREDITREQUEST_REASON_UNABLE_TO_CONTACT")));
	scriptUtils.click(By.id(RalXpathlocatorstmmobile.xpathLookup.get("BTN_NEXT")));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(RalXpathlocatorstmmobile.xpathLookup.get("CONFIRM_ALL_CHECKED_OLD"))));
	scriptUtils.click(By.id(RalXpathlocatorstmmobile.xpathLookup.get("CHECKBOX_0_OLD")));
	scriptUtils.click(By.id(RalXpathlocatorstmmobile.xpathLookup.get("CHECKBOX_1_OLD")));
	scriptUtils.click(By.id(RalXpathlocatorstmmobile.xpathLookup.get("CHECKBOX_2_OLD")));
	scriptUtils.click(By.id(RalXpathlocatorstmmobile.xpathLookup.get("BTN_SUBMIT")));
	Thread.sleep(2000);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(RalXpathlocatorstmmobile.xpathLookup.get("CALLBACK_REQUESTED"))));
	scriptUtils.click(By.id(RalXpathlocatorstmmobile.xpathLookup.get("LINK_TO_CHECK_CALLBACK_REQUESTED")));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(RalXpathlocatorstmmobile.xpathLookup.get("CALLBACK_REQUESTED_DATE_CHECK"))));
	// go back into job and check that credit requested
	driver.findElement(By.id("nav-toggle")).click();
	Thread.sleep(1000);
	driver.findElement(By.id("nav-jobs")).click();
	Thread.sleep(1000);
	testFunctions.clickOnJob(jobRef);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(RalXpathlocatorstmmobile.xpathLookup.get("CALLBACK_REQUESTED_DATE_CHECK"))));
	Thread.sleep(4000);
	}

public void confirmEmailSentToHo() throws Exception {
	WebDriverWait wait = new WebDriverWait(driver, 10);
	blogin.loginSupport(RalXpathlocatorstmmobile.dataLookup.get("ADMIN_EMAIL"),RalXpathlocatorstmmobile.dataLookup.get("PASSWORD"));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(RalXpathlocatorstmmobile.xpathLookup.get("SEARCH"))));
	scriptUtils.fillInTextField(RalXpathlocatorstmmobile.xpathLookup.get("SEARCH"),RalXpathlocatorstmmobile.dataLookup.get("HOEMAIL"));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(RalXpathlocatorstmmobile.xpathLookup.get("GO_BUTTON"))));
	scriptUtils.click(By.xpath(RalXpathlocatorstmmobile.xpathLookup.get("GO_BUTTON")));
	/*if(driver.findElement(By.xpath(RalXpathlocatorstmmobile.xpathLookup.get("SELECT_HO_FROM_SEARCH"))) != null)
	{
		scriptUtils.click(By.xpath(RalXpathlocatorstmmobile.xpathLookup.get("SELECT_HO_FROM_SEARCH")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(RalXpathlocatorstmmobile.xpathLookup.get("H0_EMAIL_SENT_BUTTON"))));
		scriptUtils.click(By.xpath(RalXpathlocatorstmmobile.xpathLookup.get("H0_EMAIL_SENT_BUTTON")));
		scriptUtils.click(By.xpath(RalXpathlocatorstmmobile.xpathLookup.get("LAST_JOB_LINK")));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(RalXpathlocatorstmmobile.xpathLookup.get("MAIL_CONTENT"))));
		Thread.sleep(3000);
		scriptUtils.click(By.xpath(RalXpathlocatorstmmobile.xpathLookup.get("CHECK_SMS")));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(RalXpathlocatorstmmobile.xpathLookup.get("HO_CALL_BACK_SMS"))));
	    Thread.sleep(3000);
	}else*/
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(RalXpathlocatorstmmobile.xpathLookup.get("H0_EMAIL_SENT_BUTTON"))));
	scriptUtils.click(By.xpath(RalXpathlocatorstmmobile.xpathLookup.get("H0_EMAIL_SENT_BUTTON")));
	scriptUtils.click(By.xpath(RalXpathlocatorstmmobile.xpathLookup.get("LAST_JOB_LINK")));
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(RalXpathlocatorstmmobile.xpathLookup.get("MAIL_CONTENT"))));
	Thread.sleep(3000);
	scriptUtils.click(By.xpath(RalXpathlocatorstmmobile.xpathLookup.get("CHECK_SMS")));
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(RalXpathlocatorstmmobile.xpathLookup.get("HO_CALL_BACK_SMS"))));
    Thread.sleep(3000);
    }

public void requestRatingForRPJob() throws Exception {
	//TMDataBaseHelper.executeQuery("delete from tm_accepted_message where user_id = 374316");
	WebDriverWait wait = new WebDriverWait(driver, 10);
	jobRef = testFunctions.homeOwnerSubmitsJobAndTradesmanBuysIt(Login.TRADESMAN, Login.TRADESMAN_PASSWORD);
	tmLogin.login();
	/*wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(RalXpathlocatorstmmobile.xpathLookup.get("TERMS_AND_CONDITIONS"))));
	Thread.sleep(2000);
	scriptUtils.click(By.xpath(RalXpathlocatorstmmobile.xpathLookup.get("TANDC_ACCEPT_OK")));
	Thread.sleep(2000);
	scriptUtils.click(By.xpath(RalXpathlocatorstmmobile.xpathLookup.get("TANDC_CHECKBOX")));
	scriptUtils.click(By.xpath(RalXpathlocatorstmmobile.xpathLookup.get("TANDC_ACCEPT_OK")));*/
	Thread.sleep(2000);
	driver.findElement(By.id("nav-toggle")).click();
	Thread.sleep(1000);
	driver.findElement(By.id("nav-jobs")).click();
	Thread.sleep(1000);
	testFunctions.clickOnJob(jobRef);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(RalXpathlocatorstmmobile.xpathLookup.get("CUSTOMER_DETAILS"))));
	scriptUtils.click(By.id(RalXpathlocatorstmmobile.xpathLookup.get("REQUEST_RATING_LINK")));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(RalXpathlocatorstmmobile.xpathLookup.get("MORE_INFO"))));
	driver.findElement(By.id(RalXpathlocatorstmmobile.xpathLookup.get("NO_OF_DAYS_TO_COMPLETE_JOB"))).sendKeys("2");
	driver.findElement(By.id(RalXpathlocatorstmmobile.xpathLookup.get("PRICE_OF_THE_JOB"))).sendKeys("100.50");
	scriptUtils.click(By.id(RalXpathlocatorstmmobile.xpathLookup.get("BTN_SEND")));
	Thread.sleep(2000);
	driver.findElement(By.id("nav-toggle")).click();
	Thread.sleep(1000);
	driver.findElement(By.id("nav-jobs")).click();
	Thread.sleep(1000);
	testFunctions.clickOnJob(jobRef);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(RalXpathlocatorstmmobile.xpathLookup.get("RATING_REQUESTED_CHECK"))));
	Thread.sleep(3000);
	}
}
