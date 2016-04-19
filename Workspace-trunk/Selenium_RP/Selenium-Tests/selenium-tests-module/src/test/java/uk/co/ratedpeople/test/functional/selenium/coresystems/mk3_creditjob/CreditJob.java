package uk.co.ratedpeople.test.functional.selenium.coresystems.mk3_creditjob;

import java.math.BigDecimal;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import uk.co.ratedpeople.test.functional.SeleniumTestContext;
import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;
import uk.co.ratedpeople.test.functional.selenium.coresystems.pricing.PriceJobBySkill;
import uk.co.ratedpeople.test.functional.selenium.functions.Login;

public class CreditJob {
	
	public static Logger logger = Logger.getLogger("uk.co.ratedpeople.test.functional.selenium.coresystems");
	
	private Login login;
	private TestScriptUtilities scriptUtils;
	private WebDriver driver;
	private PriceJobBySkill underTest;
	
	public CreditJob(SeleniumTestContext context, TestScriptUtilities scriptUtils) {
		this.scriptUtils = scriptUtils;
		this.driver = context.driver;
		login = new Login(scriptUtils, context);
		underTest = new PriceJobBySkill(context, scriptUtils);
	}

	public void submitJobAsExistingCustomer() 
			throws Exception {		
		underTest.chooseTradePage1("bricklayer", "119");		
		underTest.fillInPage2ForAdditionalInfo("statusREADY_TO_HIRE","ownerOWN_AND_LIVE","URGENTLY","AB101BH","Submit a job via selenium tests : Full regression testing ." );
		underTest.location();
		}
	
	public void buyLeadExistingCardNoBalance() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 50);
		logger.info(CreditjobXpathlocators.dataLookup.get("TM_NAME")+ CreditjobXpathlocators.dataLookup.get("TMEMAIL"));				
		login.loginTP(CreditjobXpathlocators.dataLookup.get("TMEMAIL"),CreditjobXpathlocators.dataLookup.get("PASSWORD"));
		
		//comment for preprod
//		scriptUtils.fillInTextField("login_username","165014-28-Nov-2013-@ratedtrades.com");
//		scriptUtils.fillInTextField("login_password","password");
//		scriptUtils.click("login__login");
//		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CreditjobXpathlocators.xpathLookup.get("VIEW_FULL_DETAILS"))));
		scriptUtils.click(By.xpath(CreditjobXpathlocators.xpathLookup.get("VIEW_FULL_DETAILS")));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(CreditjobXpathlocators.xpathLookup.get("BUY_BUTTON"))));
		scriptUtils.click(By.id(CreditjobXpathlocators.xpathLookup.get("BUY_BUTTON")));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CreditjobXpathlocators.xpathLookup.get("CONFIRM_BUTTON"))));
		scriptUtils.click(By.xpath(CreditjobXpathlocators.xpathLookup.get("CONFIRM_BUTTON"))); // Confirm button
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CreditjobXpathlocators.xpathLookup.get("MAIL_CONTACT_INFO"))));
		driver.findElement(By.xpath(CreditjobXpathlocators.xpathLookup.get("MAIL_CONTACT_INFO")));
	}	
	
	public void confirmTmEmailNewHoExistingTm() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 50);
		login.loginSupport(CreditjobXpathlocators.dataLookup.get("ADMIN_EMAIL"),CreditjobXpathlocators.dataLookup.get("PASSWORD"));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(CreditjobXpathlocators.xpathLookup.get("SEARCH_TEXT_AREA"))));
	    scriptUtils.findElement(By.id(CreditjobXpathlocators.xpathLookup.get("SEARCH_TEXT_AREA"))).clear();
	    
	    scriptUtils.fillInTextField(CreditjobXpathlocators.xpathLookup.get("SEARCH_TEXT_AREA"),CreditjobXpathlocators.dataLookup.get("TMEMAIL"));
	    
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CreditjobXpathlocators.xpathLookup.get("GO_BUTTON"))));
		scriptUtils.click(By.xpath(CreditjobXpathlocators.xpathLookup.get("GO_BUTTON")));
		
		scriptUtils.click(By.xpath(CreditjobXpathlocators.xpathLookup.get("TM_EMAIL_SENT_BUTTON")));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CreditjobXpathlocators.xpathLookup.get("LOAD"))));				
		scriptUtils.click(By.xpath(CreditjobXpathlocators.xpathLookup.get("LAST_JOB_LINK")));
	    
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(CreditjobXpathlocators.xpathLookup.get("SEARCH_TEXT_AREA"))));
		
		String getHoMailContent1 = scriptUtils.getValue(CreditjobXpathlocators.xpathLookup.get("MAIL_CONTENT"));
	    Assert.assertEquals(getHoMailContent1.contains(CreditjobXpathlocators.dataLookup.get("OUTPUT_RESULT")),true);
	    }
	
	public BigDecimal currentCreditValue() {
		
		WebDriverWait wait = new WebDriverWait(driver,50);		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(CreditjobXpathlocators.xpathLookup.get("SPECIAL_CREDIT"))));
	    scriptUtils.click(By.id(CreditjobXpathlocators.xpathLookup.get("SPECIAL_CREDIT")));
	    
	    String userCurrentSpecialCredit = null;
		boolean waitingForInfo = true;
		while (waitingForInfo) {
			userCurrentSpecialCredit = scriptUtils.click(By.id(CreditjobXpathlocators.xpathLookup.get("SPECIAL_CREDIT"))).getText();
			if (userCurrentSpecialCredit != null && !userCurrentSpecialCredit.equals("")) {
				waitingForInfo = false;
			}
		}
		System.out.println(userCurrentSpecialCredit);
		
		BigDecimal currentCreditAmount = new BigDecimal(userCurrentSpecialCredit.replaceAll("[£,]", ""));
				
		
		return currentCreditAmount;
	}
	
	public void creditJob()	throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver, 50);
		login.loginSupport(CreditjobXpathlocators.dataLookup.get("ADMIN_EMAIL"),CreditjobXpathlocators.dataLookup.get("PASSWORD"));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(CreditjobXpathlocators.xpathLookup.get("SEARCH_TEXT_AREA"))));
	    scriptUtils.findElement(By.id(CreditjobXpathlocators.xpathLookup.get("SEARCH_TEXT_AREA"))).clear();
	    
	    scriptUtils.fillInTextField(CreditjobXpathlocators.xpathLookup.get("SEARCH_TEXT_AREA"),CreditjobXpathlocators.dataLookup.get("TMEMAIL"));
	    
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CreditjobXpathlocators.xpathLookup.get("GO_BUTTON"))));
		scriptUtils.click(By.xpath(CreditjobXpathlocators.xpathLookup.get("GO_BUTTON")));
		
			
		scriptUtils.click(By.xpath(CreditjobXpathlocators.xpathLookup.get("TM_PURCHASED_JOBS")));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CreditjobXpathlocators.xpathLookup.get("MORE_BUTTON"))));				
		scriptUtils.click(By.xpath(CreditjobXpathlocators.xpathLookup.get("MORE_BUTTON")));
	    
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CreditjobXpathlocators.xpathLookup.get("PHONE_CHECKBOX"))));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CreditjobXpathlocators.xpathLookup.get("EMAIL_CHECKBOX"))));
		
		scriptUtils.click(By.xpath(CreditjobXpathlocators.xpathLookup.get("PHONE_CHECKBOX")));
		scriptUtils.click(By.xpath(CreditjobXpathlocators.xpathLookup.get("EMAIL_CHECKBOX")));
		
		scriptUtils.click(By.xpath(CreditjobXpathlocators.xpathLookup.get("CREDITJOB_BUTTON")));
		}
	
	public String specialCredit(BigDecimal previousCreditAmount) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, 50);
		login.loginSupport(CreditjobXpathlocators.dataLookup.get("ADMIN_EMAIL"),CreditjobXpathlocators.dataLookup.get("PASSWORD"));
		
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(CreditjobXpathlocators.xpathLookup.get("SEARCH_TEXT_AREA"))));
	    scriptUtils.findElement(By.id(CreditjobXpathlocators.xpathLookup.get("SEARCH_TEXT_AREA"))).clear();
	    
	    scriptUtils.fillInTextField(CreditjobXpathlocators.xpathLookup.get("SEARCH_TEXT_AREA"),CreditjobXpathlocators.dataLookup.get("TMEMAIL"));
	    
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CreditjobXpathlocators.xpathLookup.get("GO_BUTTON"))));
		scriptUtils.click(By.xpath(CreditjobXpathlocators.xpathLookup.get("GO_BUTTON")));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CreditjobXpathlocators.xpathLookup.get("PAYMENT_DEATILS"))));				
		scriptUtils.click(By.xpath(CreditjobXpathlocators.xpathLookup.get("PAYMENT_DEATILS")));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(CreditjobXpathlocators.xpathLookup.get("SPECIAL_CREDIT"))));
	    scriptUtils.click(By.id(CreditjobXpathlocators.xpathLookup.get("SPECIAL_CREDIT")));
	    
	    String userSpecialCredit = null;
		boolean waitingForInfo = true;
		while (waitingForInfo) {
			userSpecialCredit = scriptUtils.click(By.id(CreditjobXpathlocators.xpathLookup.get("SPECIAL_CREDIT"))).getText();
			if (userSpecialCredit != null && !userSpecialCredit.equals("")) {
				waitingForInfo = false;
			}
		}
		System.out.println(userSpecialCredit);
		
		BigDecimal newCreditAmount = new BigDecimal(userSpecialCredit.replaceAll("[,£]", ""));
		
		BigDecimal expectedNewCreditAmount = previousCreditAmount.add(BigDecimal.valueOf(4.92));
		
		Assert.assertEquals(newCreditAmount, expectedNewCreditAmount);
		
		return "";
	}
	
	}
