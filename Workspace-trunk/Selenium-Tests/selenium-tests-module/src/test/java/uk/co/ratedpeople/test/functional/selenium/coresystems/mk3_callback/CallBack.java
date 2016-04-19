package uk.co.ratedpeople.test.functional.selenium.coresystems.mk3_callback;

import static org.testng.Assert.assertEquals;

import java.util.logging.Logger;

import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import uk.co.ratedpeople.test.functional.SeleniumTestContext;
import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;
import uk.co.ratedpeople.test.functional.selenium.functions.Login;

public class CallBack {
	
	public static Logger logger = Logger
			.getLogger("uk.co.ratedpeople.test.functional.selenium.coresystems");
	
	private Login login;
	private SeleniumTestContext context;
	private TestScriptUtilities scriptUtils;
		
	private static final String TIMING_SELECT_ELEMENT = "timing";
	private static final String POSTCODE_FIELD = "postcode";
	
	

     public CallBack(SeleniumTestContext context, TestScriptUtilities scriptUtils) {
    	this.context = context;
    	this.scriptUtils = scriptUtils;
		login = new Login(scriptUtils, context);
	     }

     public void submitTreeSurgeonJob() 
    		 throws Exception {
    	chooseTradePage1("tree","158");
		fillInPage2ForAdditionalInfo("statusPLANNING_BUDGETING","ownerOWN_AND_LIVE", "URGENTLY", "TW47DF","selenium test : tree surgeon specialist.");
		location();			
     	}	
	
	public void buyJob() throws Exception {
		WebDriverWait wait = new WebDriverWait(context.driver, 50);
		login.loginTP(CallBackXpathlocators.dataLookup.get("TMEMAIL"),CallBackXpathlocators.dataLookup.get("PASSWORD"));
		
		//comment for preprod
//		scriptUtils.fillInTextField("login_username","selenium.ralmk3user@ratedtrades.com");
//		scriptUtils.fillInTextField("login_password","password");
//		scriptUtils.click("login__login");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(CallBackXpathlocators.xpathLookup.get("VIEW_FULL_DETAILS"))));
		scriptUtils.click(By.linkText(CallBackXpathlocators.xpathLookup.get("VIEW_FULL_DETAILS")));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(CallBackXpathlocators.xpathLookup.get("BUY_BUTTON"))));
		scriptUtils.click(By.id(CallBackXpathlocators.xpathLookup.get("BUY_BUTTON")));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CallBackXpathlocators.xpathLookup.get("CONFIRM_BUTTON"))));
		scriptUtils.click(By.xpath(CallBackXpathlocators.xpathLookup.get("CONFIRM_BUTTON"))); // Confirm button
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CallBackXpathlocators.xpathLookup.get("MAIL_CONTACT_INFO"))));
		scriptUtils.findElement(By.xpath(CallBackXpathlocators.xpathLookup.get("MAIL_CONTACT_INFO")));
			
	}
	
	public void requestCallBackFromTM() throws Exception {
		WebDriverWait wait = new WebDriverWait(context.driver, 50);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CallBackXpathlocators.xpathLookup.get("PURCHASED_JOBS"))));
		scriptUtils.click(By.xpath(CallBackXpathlocators.xpathLookup.get("PURCHASED_JOBS")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CallBackXpathlocators.xpathLookup.get("VIEW_DETAILS"))));
		scriptUtils.click(By.xpath(CallBackXpathlocators.xpathLookup.get("VIEW_DETAILS")));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CallBackXpathlocators.xpathLookup.get("UNABLE_TO_QUOTE"))));
		scriptUtils.click(By.xpath(CallBackXpathlocators.xpathLookup.get("UNABLE_TO_QUOTE")));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CallBackXpathlocators.xpathLookup.get("RAL_SEPT_1"))));
		scriptUtils.click(By.xpath(CallBackXpathlocators.xpathLookup.get("NEXT_STEP1")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CallBackXpathlocators.xpathLookup.get("RAL_SEPT_2"))));
		scriptUtils.click(By.xpath(CallBackXpathlocators.xpathLookup.get("NEXT_STEP2")));
		scriptUtils.click(By.xpath(CallBackXpathlocators.xpathLookup.get("CONDITION_1")));
		scriptUtils.click(By.xpath(CallBackXpathlocators.xpathLookup.get("CONDITION_2")));
		scriptUtils.click(By.xpath(CallBackXpathlocators.xpathLookup.get("CANCEL")));	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CallBackXpathlocators.xpathLookup.get("UNABLE_TO_QUOTE"))));
		scriptUtils.click(By.xpath(CallBackXpathlocators.xpathLookup.get("UNABLE_TO_QUOTE")));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CallBackXpathlocators.xpathLookup.get("RAL_SEPT_1"))));
		scriptUtils.click(By.xpath(CallBackXpathlocators.xpathLookup.get("NEXT_STEP1")));
		scriptUtils.click(By.xpath(CallBackXpathlocators.xpathLookup.get("NEXT_STEP2")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CallBackXpathlocators.xpathLookup.get("RAL_SEPT_2"))));
		scriptUtils.click(By.xpath(CallBackXpathlocators.xpathLookup.get("CONDITION_1")));
		scriptUtils.click(By.xpath(CallBackXpathlocators.xpathLookup.get("CONDITION_2")));
		scriptUtils.click(By.xpath(CallBackXpathlocators.xpathLookup.get("CONDITION_3")));
		scriptUtils.click(By.xpath(CallBackXpathlocators.xpathLookup.get("NEXT_STEP2")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CallBackXpathlocators.xpathLookup.get("CALL_BACK_REQUESTED"))));
		Thread.sleep(3000);
		scriptUtils.click(By.xpath(CallBackXpathlocators.xpathLookup.get("PURCHASED_JOBS")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CallBackXpathlocators.xpathLookup.get("VIEW_DETAILS"))));
		scriptUtils.click(By.xpath(CallBackXpathlocators.xpathLookup.get("VIEW_DETAILS")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CallBackXpathlocators.xpathLookup.get("MAIL_CONTACT_INFO"))));
		context.driver.findElement(By.xpath(CallBackXpathlocators.xpathLookup.get("MAIL_CONTACT_INFO")));
		
	   }
	
	public void creditJob()	throws Exception {
		
		WebDriverWait wait = new WebDriverWait(context.driver, 50);
		login.loginSupport(CallBackXpathlocators.dataLookup.get("ADMIN_EMAIL"),CallBackXpathlocators.dataLookup.get("PASSWORD"));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(CallBackXpathlocators.xpathLookup.get("SEARCH_TEXT_AREA"))));
	    scriptUtils.findElement(By.id(CallBackXpathlocators.xpathLookup.get("SEARCH_TEXT_AREA"))).clear();
	    
	    scriptUtils.fillInTextField(CallBackXpathlocators.xpathLookup.get("SEARCH_TEXT_AREA"),CallBackXpathlocators.dataLookup.get("EMAIL"));
	    
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(CallBackXpathlocators.xpathLookup.get("GO_BUTTON"))));
		scriptUtils.click(By.id(CallBackXpathlocators.xpathLookup.get("GO_BUTTON")));
		
			
		scriptUtils.click(By.xpath(CallBackXpathlocators.xpathLookup.get("TM_PURCHASED_JOBS")));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CallBackXpathlocators.xpathLookup.get("MORE_BUTTON"))));				
		scriptUtils.click(By.xpath(CallBackXpathlocators.xpathLookup.get("MORE_BUTTON")));
	    
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CallBackXpathlocators.xpathLookup.get("PHONE_CHECKBOX"))));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CallBackXpathlocators.xpathLookup.get("EMAIL_CHECKBOX"))));
		
		scriptUtils.click(By.xpath(CallBackXpathlocators.xpathLookup.get("PHONE_CHECKBOX")));
		scriptUtils.click(By.xpath(CallBackXpathlocators.xpathLookup.get("EMAIL_CHECKBOX")));
		
		scriptUtils.click(By.xpath(CallBackXpathlocators.xpathLookup.get("CREDITJOB_BUTTON")));
				
		}
	    
	public void callBackCreditedJobMK3 () throws Exception{
		WebDriverWait wait = new WebDriverWait(context.driver, 50);
		login.loginSupport(CallBackXpathlocators.dataLookup.get("ADMIN_EMAIL"),CallBackXpathlocators.dataLookup.get("PASSWORD"));
				
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(CallBackXpathlocators.xpathLookup.get("SEARCH_TEXT_AREA"))));
	    scriptUtils.findElement(By.id(CallBackXpathlocators.xpathLookup.get("SEARCH_TEXT_AREA"))).clear();
	    
	    scriptUtils.fillInTextField(CallBackXpathlocators.xpathLookup.get("SEARCH_TEXT_AREA"),CallBackXpathlocators.dataLookup.get("EMAIL"));
	    
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(CallBackXpathlocators.xpathLookup.get("GO_BUTTON"))));
		scriptUtils.click(By.id(CallBackXpathlocators.xpathLookup.get("GO_BUTTON")));
		
		scriptUtils.click(By.xpath(CallBackXpathlocators.xpathLookup.get("TM_CALLBACKS_BUTTON")));
				
		String getHoMailContent1 = scriptUtils.getValue(CallBackXpathlocators.xpathLookup.get("CREDITED_JOB_STATUS"));
	    Assert.assertEquals(getHoMailContent1.contains(CallBackXpathlocators.dataLookup.get("JOB_STATUS")),true);   
	}
	
	public void chooseTradePage1(String tradetypeValue,String jobtypevalue) throws Exception{
		WebDriverWait wait = new WebDriverWait(context.driver, 80);
		
		scriptUtils.goTo(context.getTestUrl());
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("trade")));
		
		if (tradetypeValue != null) {
		Select tradetype = new Select(context.driver.findElement(By.id("trade")));
		tradetype.selectByValue(tradetypeValue);
		}
		if (jobtypevalue != null) {
		Select select = new Select(context.driver.findElement(By.id("jobtype")));
		select.selectByValue(jobtypevalue);
		}
		scriptUtils.click("btn-next-step");
}
	
public void fillInPage2ForAdditionalInfo(String jobStatus,String ownershipStatus, String timing, String postcode,String additionalDetails ) {

	WebDriverWait wait = new WebDriverWait(context.driver, 80);
		
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(jobStatus)));
		if (StringUtils.isNotBlank(jobStatus)) {
			scriptUtils.click(By.id(jobStatus));
		}

		if (StringUtils.isNotBlank(ownershipStatus)) {
			scriptUtils.click(By.id(ownershipStatus));
		}

		if (StringUtils.isNotBlank(timing)) {
			Select timingSelect = new Select(scriptUtils.findElement(By.id(TIMING_SELECT_ELEMENT)));
			timingSelect.selectByValue(timing);
		}

		if (StringUtils.isNotBlank(postcode)) {
			scriptUtils.clear(By.id(POSTCODE_FIELD));
			scriptUtils.fillInTextField(POSTCODE_FIELD, postcode);
		}

		if (StringUtils.isNotBlank(additionalDetails)) {
		scriptUtils.clearAndFillInXpathField(CallBackXpathlocators.xpathLookup.get("JOB_DESCRIPTION"),additionalDetails);
	   }
		   	scriptUtils.click("next");	 	
		   	scriptUtils.selectDropdown("jobBudgetCode", 1);
		   	scriptUtils.click("next");			
	}
  
    public void location() throws Exception {
		WebDriverWait wait = new WebDriverWait(context.driver, 50);
        
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CallBackXpathlocators.xpathLookup.get("FIRST_NAME"))));
		scriptUtils.fillInXpathField(CallBackXpathlocators.xpathLookup.get("FIRST_NAME"),
				CallBackXpathlocators.dataLookup.get("FIRST_NAME") + TestScriptUtilities.getRandomAlphabeticString(3));
		scriptUtils.fillInXpathField(CallBackXpathlocators.xpathLookup.get("LAST_NAME"),
				CallBackXpathlocators.dataLookup.get("LAST_NAME") + TestScriptUtilities.getRandomAlphabeticString(3));
		scriptUtils.fillInXpathField(CallBackXpathlocators.xpathLookup.get("MOBILE"), CallBackXpathlocators.dataLookup.get("MOBILE"));
		scriptUtils.fillInXpathField(CallBackXpathlocators.xpathLookup.get("CONFIRM_MOBILE"), CallBackXpathlocators.dataLookup.get("MOBILE"));
		scriptUtils.fillInXpathField(CallBackXpathlocators.xpathLookup.get("EMAIL"), CallBackXpathlocators.dataLookup.get("EMAIL") );
		scriptUtils.fillInXpathField(CallBackXpathlocators.xpathLookup.get("CONFIRM_EMAIL"), CallBackXpathlocators.dataLookup.get("CONFIRM_EMAIL") );
		//scriptUtils.fillInXpathField(CallBackXpathlocators.xpathLookup.get("EMAIL"), "selenium"+ TestScriptUtilities.getRandomString(3)+ "@ratedtrades.com" );
		scriptUtils.click(By.xpath(CallBackXpathlocators.xpathLookup.get("POSTCODE")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CallBackXpathlocators.xpathLookup.get("CONFIRM_POSTJOB")))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CallBackXpathlocators.xpathLookup.get("HEADER_THANKYOU"))));
		String getheaderText= scriptUtils.getValue(CallBackXpathlocators.xpathLookup.get("HEADER_THANKYOU"));
		assertEquals(getheaderText,"Thank you");		
	}

	public void callBackScreenMK3() throws Exception {
		WebDriverWait wait = new WebDriverWait(context.driver, 50);
		login.loginSupport(CallBackXpathlocators.dataLookup.get("ADMIN_EMAIL"),CallBackXpathlocators.dataLookup.get("PASSWORD"));
				
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(CallBackXpathlocators.xpathLookup.get("SEARCH_TEXT_AREA"))));
	    scriptUtils.findElement(By.id(CallBackXpathlocators.xpathLookup.get("SEARCH_TEXT_AREA"))).clear();
	    
	    scriptUtils.fillInTextField(CallBackXpathlocators.xpathLookup.get("SEARCH_TEXT_AREA"),CallBackXpathlocators.dataLookup.get("TMEMAIL"));
	    
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(CallBackXpathlocators.xpathLookup.get("GO_BUTTON"))));
		scriptUtils.click(By.id(CallBackXpathlocators.xpathLookup.get("GO_BUTTON")));
		
		scriptUtils.click(By.linkText(CallBackXpathlocators.xpathLookup.get("TM_CALLBACKS_BUTTON")));
			
		String getHoMailContent1 = scriptUtils.getValue(CallBackXpathlocators.xpathLookup.get("CALLBACKJOB_DESCRIPTION"));
	    Assert.assertEquals(getHoMailContent1.contains(CallBackXpathlocators.dataLookup.get("DESCRIPTION")),true);    
	        
		}
	
	}
    

