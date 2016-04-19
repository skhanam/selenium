package uk.co.ratedpeople.test.functional.selenium.coresystems.pricing;

import static org.testng.Assert.assertEquals;

import java.util.logging.Logger;

import org.openqa.selenium.By;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import uk.co.ratedpeople.test.functional.SeleniumTestContext;
import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;
import uk.co.ratedpeople.test.functional.selenium.functions.Login;

public class PriceJobBySkillTimeAndIntent {
	private Login login;
	private SeleniumTestContext context;
	private TestScriptUtilities scriptUtils;
	private PriceJobBySkill postjob;
	public static Logger logger = Logger.getLogger("uk.co.ratedpeople.test.functional.selenium.coresystem");
	
     public PriceJobBySkillTimeAndIntent(SeleniumTestContext context, TestScriptUtilities scriptUtils) {
    	this.context = context;
    	this.scriptUtils = scriptUtils;
		login = new Login(scriptUtils, context);
		postjob = new PriceJobBySkill(this.context, this.scriptUtils);
		}
 
	public void submitJob1ReadyToHire() throws Exception {
		postjob.chooseTradePage1("bathroom","18");
		scriptUtils.click("radioElse");
		scriptUtils.click("stage1SelectButton");
		postjob.fillInPage2ForAdditionalInfo("statusREADY_TO_HIRE","ownerOWN_AND_LIVE", "URGENTLY", "HA02LH","selenium test : Bathroom Specialist- Bathroom Installation skill with Urgent timing :I'm ready to hire .");
		postjob.location();	
		}
	
	public void submitJob2WithPlanBudget() throws Exception {
		postjob.chooseTradePage1("bathroom","18");
		scriptUtils.click("radioElse");
		scriptUtils.click("stage1SelectButton");
		postjob.fillInPage2ForAdditionalInfo("statusPLANNING_BUDGETING","ownerOWN_AND_LIVE", "URGENTLY", "HA02LH", "selenium test : Bathroom Specialist- Bathroom Installation skill with Urgent timing : planning and budgeting .");
		postjob.location();	
		}

	public void submitJob3QuoteForInsurance() throws Exception {
		postjob.chooseTradePage1("bathroom","18");
		scriptUtils.click("radioElse");
		scriptUtils.click("stage1SelectButton");
		postjob.fillInPage2ForAdditionalInfo("statusINSURANCE_CLAIM","ownerOWN_AND_LIVE", "URGENTLY", "HA02LH", "selenium test : Bathroom Specialist- Bathroom Installation skill with Urgent timing : planning and budgeting .");
		postjob.location();	
		}

		
	public void compareBuyLeadPriceSkillTimeIntentStdTM() throws Exception {
		
		WebDriverWait wait = new WebDriverWait(context.driver, 50);
		login.loginTP(PricingXpathlocators.dataLookup.get("EMAIL5"),PricingXpathlocators.dataLookup.get("PASSWORD"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PricingXpathlocators.xpathLookup.get("JOB1_VIEW_FULL_DETAILS_XPATH"))));
		scriptUtils.clickXpath(PricingXpathlocators.xpathLookup.get("JOB1_VIEW_FULL_DETAILS_XPATH"));
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PricingXpathlocators.xpathLookup.get("JOB_PRICE"))));
		String price1 =scriptUtils.getValue(PricingXpathlocators.xpathLookup.get("JOB_PRICE"));
        logger.info(PricingXpathlocators.dataLookup.get("EMAIL5"));
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
	
	public void compareBuyLeadPriceSkillTimeIntentPaygTM() throws Exception {
		WebDriverWait wait = new WebDriverWait(context.driver, 50);
		login.loginTP(PricingXpathlocators.dataLookup.get("EMAIL6"),PricingXpathlocators.dataLookup.get("PASSWORD"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PricingXpathlocators.xpathLookup.get("JOB1_VIEW_FULL_DETAILS_XPATH"))));
		scriptUtils.clickXpath(PricingXpathlocators.xpathLookup.get("JOB1_VIEW_FULL_DETAILS_XPATH"));
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PricingXpathlocators.xpathLookup.get("JOB_PRICE"))));
		String price1 =scriptUtils.getValue(PricingXpathlocators.xpathLookup.get("JOB_PRICE"));
        logger.info(PricingXpathlocators.dataLookup.get("EMAIL6"));
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
	    logger.info("All the 3 jobs have the same " +price3);	}
}
