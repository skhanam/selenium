package uk.co.ratedpeople.test.functional.selenium.functions;

import static org.testng.Assert.assertEquals;

import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import uk.co.ratedpeople.test.functional.SeleniumTestContext;
import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;
import uk.co.ratedpeople.test.functional.selenium.coresystems.mail.MailXpathlocators;
import uk.co.ratedpeople.test.functional.selenium.coresystems.pricing.PriceJobBySkill;
import uk.co.ratedpeople.test.functional.selenium.coresystems.pricing.PricingXpathlocators;

/**
 * WARNING: currently runs as admin user, so needs fixing or deleting
 */
public class SubmitJobAsExistingCustomer {
	private Login login;
	private TestScriptUtilities scriptUtils;
	private SeleniumTestContext context;
	private PriceJobBySkill underTest;
	
	public SubmitJobAsExistingCustomer(SeleniumTestContext context, TestScriptUtilities scriptUtils) {
		this.scriptUtils = scriptUtils;
		this.context = context;
		login = new Login(scriptUtils, context);
		underTest = new PriceJobBySkill(context, scriptUtils);
	}
	
	public void submitJobAsExistingCustomer() 
			throws Exception {
		
		underTest.chooseTradePage1("flooring", "31");		
		underTest.fillInPage2ForAdditionalInfo("statusREADY_TO_HIRE","ownerOWN_AND_LIVE","URGENTLY","E173AA","Submit a job via selenium tests : Full regression testing ." );
		location();
		}
	public void location() throws Exception {
		WebDriverWait wait = new WebDriverWait(context.driver, 50);
        
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PricingXpathlocators.xpathLookup.get("FIRST_NAME"))));
		scriptUtils.fillInXpathField(PricingXpathlocators.xpathLookup.get("FIRST_NAME"),
				PricingXpathlocators.dataLookup.get("FIRST_NAME") + TestScriptUtilities.getRandomAlphabeticString(3));
		scriptUtils.fillInXpathField(PricingXpathlocators.xpathLookup.get("LAST_NAME"),
				PricingXpathlocators.dataLookup.get("LAST_NAME") + TestScriptUtilities.getRandomAlphabeticString(3));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PricingXpathlocators.xpathLookup.get("MOBILE"))));
		scriptUtils.fillInXpathField(PricingXpathlocators.xpathLookup.get("MOBILE"), PricingXpathlocators.dataLookup.get("MOBILE"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PricingXpathlocators.xpathLookup.get("CONFIRM_MOBILE"))));
		scriptUtils.fillInXpathField(PricingXpathlocators.xpathLookup.get("CONFIRM_MOBILE"), PricingXpathlocators.dataLookup.get("MOBILE"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PricingXpathlocators.xpathLookup.get("EMAIL"))));
		scriptUtils.fillInXpathField(PricingXpathlocators.xpathLookup.get("EMAIL"), MailXpathlocators.dataLookup.get("HOEMAIL") );
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PricingXpathlocators.xpathLookup.get("CONFIRM_EMAIL"))));
		scriptUtils.fillInXpathField(PricingXpathlocators.xpathLookup.get("CONFIRM_EMAIL"), MailXpathlocators.dataLookup.get("HOEMAIL") );
		scriptUtils.click(By.xpath(PricingXpathlocators.xpathLookup.get("POSTCODE")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PricingXpathlocators.xpathLookup.get("HEADER_THANKYOU"))));
		String getheaderText= scriptUtils.getValue(PricingXpathlocators.xpathLookup.get("HEADER_THANKYOU"));
		assertEquals(getheaderText,"Thank you");		
	}
		
	public String submitJobAsTP() throws Exception {
		// 10.03.2011 Works fine, no validation covered (Aleksandr)
		scriptUtils.goTo(context.getTestUrl());
		
		login.login("aleksandr01@ratedtrades.com", "password");
		scriptUtils.sleep(2000);
		scriptUtils.goTo(context.getTestUrl());
		scriptUtils.sleep(3000);
		// First page of job widget
		scriptUtils.selectDropdown("trade", 1);
		scriptUtils.sleep(2000);
		scriptUtils.selectDropdown("jobtype", 1);
		//fillInTextField("jobtitle", StringUtils.repeat("jobtitle", 5));
		scriptUtils.fillInTextField("jobdescription", StringUtils.repeat("jobdescription", 5));
		scriptUtils.click("submit-1");
		// Second page of job widget
		scriptUtils.selectDropdown("timing", 1);
		scriptUtils.selectDropdown("range", 1);
		scriptUtils.fillInTextField("postcode", "se41du");
			
		scriptUtils.click("new-user-btn");
		
		scriptUtils.click("new-user-btn");
		scriptUtils.sleep(2000);
		// Third page of job widget
		scriptUtils.click("submitUser");
		scriptUtils.sleep(5000);

		return "";
	}
	
	public void submitJobAsExistingMicro() {
		WebDriverWait wait = new WebDriverWait(context.driver, 10);
		scriptUtils.goTo(context.getTestUrl()+"/profile/integrationtest/request-a-quote");
		context.driver.switchTo().frame(0);
		scriptUtils.sleep(2000);
		scriptUtils.selectDropdown("Job_tradeId", 1);
		scriptUtils.sleep(3000);
		scriptUtils.selectDropdown("Job_jobTypeId", 1);
		scriptUtils.fillInTextField("Job_description", "11 This is a test job title. This is a test job description.This is a test job description.");
		scriptUtils.selectDropdown("Job_jobStartDate", 2);
		scriptUtils.selectDropdown("Job_jobBudgetId", 2);
		scriptUtils.fillInTextField("Job_postcode", "SW1E6DR");
		scriptUtils.sleep(3000);
		scriptUtils.click("next");
		scriptUtils.sleep(4000);
		
		scriptUtils.fillInTextField("Job_user_firstName", "firstname");
		scriptUtils.fillInTextField("Job_user_lastName", "Customer");
		scriptUtils.fillInTextField("Job_user_phoneNumber", "07700900003");
		
		scriptUtils.fillInTextField("Job_user_email", "aleksandr54@ratedtrades.com");
		System.out.println("Email: aleksandr54@ratedtrades.com");

		scriptUtils.click("submitBtn");
		wait.until(ExpectedConditions.textToBePresentInElement(By.cssSelector("h3.formHeader"), "Thank you"));
	}
	
}
