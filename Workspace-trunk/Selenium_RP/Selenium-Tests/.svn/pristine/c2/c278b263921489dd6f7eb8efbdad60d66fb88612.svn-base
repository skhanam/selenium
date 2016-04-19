package uk.co.ratedpeople.test.functional.selenium.coresystems.pricing;

import static org.testng.Assert.assertEquals;

import java.util.logging.Logger;

import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import uk.co.ratedpeople.test.functional.SeleniumTestContext;
import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;
import uk.co.ratedpeople.test.functional.selenium.functions.Login;

public class PriceJobBySkill {
	
	public static Logger logger = Logger
			.getLogger("uk.co.ratedpeople.test.functional.selenium.coresystems");
	
	private Login login;
	private SeleniumTestContext context;
	private TestScriptUtilities scriptUtils;
	private WebDriver driver;
	private static final String TIMING_SELECT_ELEMENT = "timing";
	private static final String POSTCODE_FIELD = "postcode";
	
	

     public PriceJobBySkill(SeleniumTestContext context, TestScriptUtilities scriptUtils) {
    	this.context = context;
    	this.scriptUtils = scriptUtils;
		login = new Login(scriptUtils, context);
		this.driver = context.driver;
	     }

     public void submitJob1WithAerialSatelliteDish() {
    	chooseTradePage1("network","73");
		fillInPage2ForAdditionalInfo("statusPLANNING_BUDGETING","ownerOWN_AND_LIVE", "URGENTLY", "HA02LH","Selenium test : Aerial and Network Specialist. ");
		location();			
     	}
     
	public void submitJob2WithAerialSatelliteDish() {
		chooseTradePage1("electrician","73");
		fillInPage2ForAdditionalInfo("statusREADY_TO_HIRE","ownerOWN_AND_LIVE", "URGENTLY", "HA02LH","Selenium test : electrician Specialist. ");
		location();					
       	}

	public void submitJob3WithAerialSatelliteDish() {
		chooseTradePage1("specialist","73");
		fillInPage2ForAdditionalInfo("statusREADY_TO_HIRE","ownerOWN_AND_LIVE", "URGENTLY", "HA02LH","Selenium test : specialist Specialist. ");
		location();
		}
		
	public void compareBuyLeadPriceStdTM() {
		
		WebDriverWait wait = new WebDriverWait(context.driver, 50);

		login.loginTP(PricingXpathlocators.dataLookup.get("EMAIL1"), PricingXpathlocators.dataLookup.get("PASSWORD"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PricingXpathlocators.xpathLookup.get("JOB1_VIEW_FULL_DETAILS_XPATH"))));
		scriptUtils.clickXpath(PricingXpathlocators.xpathLookup.get("JOB1_VIEW_FULL_DETAILS_XPATH"));
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PricingXpathlocators.xpathLookup.get("JOB_PRICE"))));
		String price1 =scriptUtils.getValue(PricingXpathlocators.xpathLookup.get("JOB_PRICE"));
		logger.info(PricingXpathlocators.dataLookup.get("EMAIL1"));
		logger.info("Job 1 "+ price1);
	    scriptUtils.click(By.xpath(PricingXpathlocators.xpathLookup.get("JOB_LEADS")));
    	    	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PricingXpathlocators.xpathLookup.get("JOB2_VIEW_FULL_DETAILS_XPATH"))));
    	scriptUtils.clickXpath(PricingXpathlocators.xpathLookup.get("JOB2_VIEW_FULL_DETAILS_XPATH"));
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PricingXpathlocators.xpathLookup.get("JOB_PRICE"))));
    	String price2=scriptUtils.getValue(PricingXpathlocators.xpathLookup.get("JOB_PRICE"));
    	logger.info("Job 2 " + price2);
    	scriptUtils.click(By.xpath(PricingXpathlocators.xpathLookup.get("JOB_LEADS")));    	
    	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PricingXpathlocators.xpathLookup.get("JOB3_VIEW_FULL_DETAILS_XPATH"))));
    	scriptUtils.clickXpath(PricingXpathlocators.xpathLookup.get("JOB3_VIEW_FULL_DETAILS_XPATH"));
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PricingXpathlocators.xpathLookup.get("JOB_PRICE"))));
    	String price3=scriptUtils.getValue(PricingXpathlocators.xpathLookup.get("JOB_PRICE"));
	    logger.info("Job 3 " +price3);
    	    	
	    assertEquals(price1, price2);
	    assertEquals(price2, price3);
	    logger.info("All the 3 jobs have the same " +price3);
		}
	
	public void compareBuyLeadPricePaygoTM() {
		WebDriverWait wait = new WebDriverWait(context.driver, 50);
		login.loginTP(PricingXpathlocators.dataLookup.get("EMAIL2"),PricingXpathlocators.dataLookup.get("PASSWORD"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PricingXpathlocators.xpathLookup.get("JOB1_VIEW_FULL_DETAILS_XPATH"))));
		scriptUtils.clickXpath(PricingXpathlocators.xpathLookup.get("JOB1_VIEW_FULL_DETAILS_XPATH"));
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PricingXpathlocators.xpathLookup.get("JOB_PRICE"))));
		String price1 =scriptUtils.getValue(PricingXpathlocators.xpathLookup.get("JOB_PRICE"));
        logger.info(PricingXpathlocators.dataLookup.get("EMAIL2"));
	    logger.info("Job 1 "+ price1);
	    scriptUtils.click(By.xpath(PricingXpathlocators.xpathLookup.get("JOB_LEADS")));
    	    	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PricingXpathlocators.xpathLookup.get("JOB2_VIEW_FULL_DETAILS_XPATH"))));
    	scriptUtils.clickXpath(PricingXpathlocators.xpathLookup.get("JOB2_VIEW_FULL_DETAILS_XPATH"));
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PricingXpathlocators.xpathLookup.get("JOB_PRICE"))));
    	String price2=scriptUtils.getValue(PricingXpathlocators.xpathLookup.get("JOB_PRICE"));
    	logger.info("Job 2 " + price2);
    	scriptUtils.click(By.xpath(PricingXpathlocators.xpathLookup.get("JOB_LEADS")));
    	
    	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PricingXpathlocators.xpathLookup.get("JOB3_VIEW_FULL_DETAILS_XPATH"))));
    	scriptUtils.clickXpath(PricingXpathlocators.xpathLookup.get("JOB3_VIEW_FULL_DETAILS_XPATH"));
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PricingXpathlocators.xpathLookup.get("JOB_PRICE"))));
    	String price3=scriptUtils.getValue(PricingXpathlocators.xpathLookup.get("JOB_PRICE"));
	    logger.info("Job 3 " +price3);
    	    	
	    assertEquals(price1, price2);
	    assertEquals(price2, price3);
	    logger.info("All the 3 jobs have the same " +price3);
     	}
	
	public void chooseTradePage1(String tradetypeValue,String jobtypevalue){
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
		scriptUtils.clearAndFillInXpathField(PricingXpathlocators.xpathLookup.get("JOB_DESCRIPTION"),additionalDetails);
	   }
		   	scriptUtils.click("next");	
			scriptUtils.sleep(2000);
		   	scriptUtils.selectDropdown("jobBudgetCode", 1);
		   	scriptUtils.click("next");			
	}


public void fillInPage2ForOtherThanLondonAdditionalInfo(String jobStatus,String ownershipStatus, String timing, String postcode,String additionalDetails ) {

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
		scriptUtils.clearAndFillInXpathField(PricingXpathlocators.xpathLookup.get("JOB_DESCRIPTION"),additionalDetails);
	   }
		   	scriptUtils.click("next");	
			scriptUtils.sleep(2000);
		   	scriptUtils.selectDropdown("jobBudgetCode", 1);
		   	scriptUtils.click("next");			
	}
  
    public void location() {
		WebDriverWait wait = new WebDriverWait(context.driver, 50);
        
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PricingXpathlocators.xpathLookup.get("FIRST_NAME"))));
		scriptUtils.fillInXpathField(PricingXpathlocators.xpathLookup.get("FIRST_NAME"),
				PricingXpathlocators.dataLookup.get("FIRST_NAME") + TestScriptUtilities.getRandomAlphabeticString(3));
		scriptUtils.fillInXpathField(PricingXpathlocators.xpathLookup.get("LAST_NAME"),
				PricingXpathlocators.dataLookup.get("LAST_NAME") + TestScriptUtilities.getRandomAlphabeticString(3));
		scriptUtils.fillInXpathField(PricingXpathlocators.xpathLookup.get("MOBILE"), PricingXpathlocators.dataLookup.get("MOBILE"));
		scriptUtils.fillInXpathField(PricingXpathlocators.xpathLookup.get("CONFIRM_MOBILE"), PricingXpathlocators.dataLookup.get("MOBILE"));
		//scriptUtils.fillInXpathField(PricingXpathlocators.xpathLookup.get("EMAIL"), "selenium"+ TestScriptUtilities.getRandomString(3)+ "@ratedtrades.com" );
		scriptUtils.fillInXpathField(PricingXpathlocators.xpathLookup.get("EMAIL"), PricingXpathlocators.dataLookup.get("EMAIL"));
		scriptUtils.fillInXpathField(PricingXpathlocators.xpathLookup.get("CONFIRM_EMAIL"), PricingXpathlocators.dataLookup.get("EMAIL"));
		scriptUtils.click(By.xpath(PricingXpathlocators.xpathLookup.get("POSTJOB")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PricingXpathlocators.xpathLookup.get("HEADER_ALMOST"))));
		String getheaderText1= scriptUtils.getValue(PricingXpathlocators.xpathLookup.get("HEADER_ALMOST"));
		assertEquals(getheaderText1,"Almost done ...");
		scriptUtils.click(By.xpath(PricingXpathlocators.xpathLookup.get("CONFIRM_POSTJOB")));
		scriptUtils.sleep(5000);
		//checking 502 error
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(PricingXpathlocators.xpathLookup.get("HEADER_THANKYOU"))));
		}catch(TimeoutException e){
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//html/body/div[1]/div[2]/div/div/section/h1")));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("breadcrumbs-container")));
		    driver.navigate().refresh();
		    scriptUtils.sleep(2000);
			driver.switchTo().alert().accept();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(PricingXpathlocators.xpathLookup.get("HEADER_THANKYOU"))));
		}
		assertEquals(driver.findElement(By.id("header-h1")).getText(), "Thank you");
		
	}
}
