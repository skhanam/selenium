package uk.co.ratedpeople.test.functional.selenium.coresystems.mail;

import static org.testng.Assert.assertEquals;

import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import uk.co.ratedpeople.test.functional.SeleniumTestContext;
import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;
import uk.co.ratedpeople.test.functional.selenium.coresystems.pricing.PriceJobBySkill;
import uk.co.ratedpeople.test.functional.selenium.coresystems.pricing.PricingXpathlocators;
import uk.co.ratedpeople.test.functional.selenium.functions.Login;

public class ConfirmEmailSentWithExistingHoExistingTm {
	private Login login;
	private TestScriptUtilities scriptUtils;
	private WebDriver driver;
	private PriceJobBySkill underTest;
	public static Logger logger= Logger.getLogger(" uk.co.ratedpeople.test.functional.selenium.coresystems.mail");
		
	public ConfirmEmailSentWithExistingHoExistingTm(SeleniumTestContext context, TestScriptUtilities scriptUtils) {
		this.scriptUtils = scriptUtils;
		this.driver = context.driver;
		login = new Login(scriptUtils, context);
		underTest = new PriceJobBySkill(context, scriptUtils);
	}

	public void submitJobAsExistingCustomer() 
			throws Exception {		
		underTest.chooseTradePage1("locksmiths", "150");		
		underTest.fillInPage2ForAdditionalInfo("statusREADY_TO_HIRE","ownerOWN_AND_LIVE","URGENTLY","CF101BP","Submit a job via selenium tests : Full regression testing ." );
		location();
		}
	
	public void location() throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PricingXpathlocators.xpathLookup.get("FIRST_NAME"))));
		scriptUtils.fillInXpathField(PricingXpathlocators.xpathLookup.get("FIRST_NAME"),
		PricingXpathlocators.dataLookup.get("FIRST_NAME") + TestScriptUtilities.getRandomAlphabeticString(3));
		scriptUtils.fillInXpathField(PricingXpathlocators.xpathLookup.get("LAST_NAME"),
		PricingXpathlocators.dataLookup.get("LAST_NAME") + TestScriptUtilities.getRandomAlphabeticString(3));
		scriptUtils.fillInXpathField(PricingXpathlocators.xpathLookup.get("MOBILE"), PricingXpathlocators.dataLookup.get("MOBILE"));
		scriptUtils.fillInXpathField(PricingXpathlocators.xpathLookup.get("CONFIRM_MOBILE"), PricingXpathlocators.dataLookup.get("MOBILE"));
		scriptUtils.fillInXpathField(PricingXpathlocators.xpathLookup.get("EMAIL"), PricingXpathlocators.dataLookup.get("EMAIL") );
		scriptUtils.fillInXpathField(PricingXpathlocators.xpathLookup.get("CONFIRM_EMAIL"), PricingXpathlocators.dataLookup.get("CONFIRM_EMAIL") );
		scriptUtils.click(By.xpath(PricingXpathlocators.xpathLookup.get("POSTJOB")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PricingXpathlocators.xpathLookup.get("HEADER_ALMOST"))));
		String getheaderText1= scriptUtils.getValue(PricingXpathlocators.xpathLookup.get("HEADER_ALMOST"));
		assertEquals(getheaderText1,"Almost done ...");
		scriptUtils.click(By.xpath(PricingXpathlocators.xpathLookup.get("CONFIRM_POSTJOB")));
		scriptUtils.sleep(5000);
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(PricingXpathlocators.xpathLookup.get("HEADER_THANKYOU"))));
		}catch(TimeoutException e){
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("breadcrumbs-container")));
		    driver.navigate().refresh();
		    scriptUtils.sleep(2000);
			driver.switchTo().alert().accept();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(PricingXpathlocators.xpathLookup.get("HEADER_THANKYOU"))));
		}
		 assertEquals(driver.findElement(By.id("header-h1")).getText(), "Thank you");
				
	}
	
	public void buyLeadExistingCardNoBalance() {
		WebDriverWait wait = new WebDriverWait(driver, 100);
		logger.info(MailXpathlocators.dataLookup.get("TM_NAME")+ MailXpathlocators.dataLookup.get("TMEMAIL"));	
		login.loginTP(MailXpathlocators.dataLookup.get("TMEMAIL"),MailXpathlocators.dataLookup.get("PASSWORD"));
		
		// comment for preprod env
//		scriptUtils.fillInTextField("login_username","152617-19-Nov-2013-CSU@ratedtrades.com");
//		scriptUtils.fillInTextField("login_password","password");
//		scriptUtils.click("login__login");		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(MailXpathlocators.xpathLookup.get("VIEW_FULL_DETAILS"))));
		scriptUtils.click(By.xpath(MailXpathlocators.xpathLookup.get("VIEW_FULL_DETAILS")));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(MailXpathlocators.xpathLookup.get("BUY_BUTTON"))));
		scriptUtils.click(By.id(MailXpathlocators.xpathLookup.get("BUY_BUTTON")));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(MailXpathlocators.xpathLookup.get("CONFIRM_BUTTON"))));
		scriptUtils.click(By.xpath(MailXpathlocators.xpathLookup.get("CONFIRM_BUTTON"))); // Confirm button
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(MailXpathlocators.xpathLookup.get("MAIL_CONTACT_INFO"))));
		scriptUtils.findElement(By.xpath(MailXpathlocators.xpathLookup.get("MAIL_CONTACT_INFO")));
	}
	
	 public void confirmTMEmailSentWithExistingHo() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		login.loginSupport(MailXpathlocators.dataLookup.get("ADMIN_EMAIL"),MailXpathlocators.dataLookup.get("PASSWORD"));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(MailXpathlocators.xpathLookup.get("SEARCH_TEXT_AREA"))));
		scriptUtils.fillInTextField(MailXpathlocators.xpathLookup.get("SEARCH_TEXT_AREA"),MailXpathlocators.dataLookup.get("HOEMAIL"));
		Thread.sleep(10000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(MailXpathlocators.xpathLookup.get("GO_BUTTON"))));
		scriptUtils.click(By.id(MailXpathlocators.xpathLookup.get("GO_BUTTON")));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(MailXpathlocators.xpathLookup.get("H0_EMAIL_SENT_BUTTON"))));
		scriptUtils.click(By.xpath(MailXpathlocators.xpathLookup.get("H0_EMAIL_SENT_BUTTON")));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(MailXpathlocators.xpathLookup.get("LOAD"))));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(MailXpathlocators.xpathLookup.get("SEARCH_TEXT_AREA"))));
	    scriptUtils.findElement(By.id(MailXpathlocators.xpathLookup.get("SEARCH_TEXT_AREA"))).clear();
	    
	    scriptUtils.fillInTextField(MailXpathlocators.xpathLookup.get("SEARCH_TEXT_AREA"),MailXpathlocators.dataLookup.get("TMEMAIL"));
	    
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(MailXpathlocators.xpathLookup.get("GO_BUTTON"))));
		scriptUtils.click(By.id(MailXpathlocators.xpathLookup.get("GO_BUTTON")));
		
		//scriptUtils.click(By.xpath(MailXpathlocators.xpathLookup.get("TM_EMAIL_SENT_BUTTON")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Emails Sent"))).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(MailXpathlocators.xpathLookup.get("LOAD"))));				
		scriptUtils.click(By.xpath(MailXpathlocators.xpathLookup.get("LAST_JOB_LINK")));
	    
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(MailXpathlocators.xpathLookup.get("SEARCH_TEXT_AREA"))));
		
		String getHoMailContent1 = scriptUtils.getValue(MailXpathlocators.xpathLookup.get("MAIL_CONTENT"));
	    Assert.assertEquals(getHoMailContent1.contains(MailXpathlocators.dataLookup.get("OUTPUT_RESULT")),true);
	    		
    }
}
