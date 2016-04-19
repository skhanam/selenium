package uk.co.ratedpeople.test.functional.selenium.coresystems.mk3_tmuserstatus;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import uk.co.ratedpeople.test.functional.SeleniumTestContext;
import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;
import uk.co.ratedpeople.test.functional.selenium.coresystems.mk3_tmuserstatus.CheckUserXpathlocators;

public class CheckStatus extends TestScriptUtilities {
		
	public CheckStatus(SeleniumTestContext context) {
		super(context);		
	}				
	
		public void checkIsVerified(String userName, String password,String tradesman) throws Exception {
		
		WebDriverWait wait=new 	WebDriverWait(context.driver,60);
		clickIfExists(By.linkText(CheckUserXpathlocators.dataLookup.get("SUPPORT_LOGOUT")));
		goTo(context.getSupportUrl() +CheckUserXpathlocators.dataLookup.get("SUPPORT_URL") );
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(CheckUserXpathlocators.xpathLookup.get("SUPPORT_USER_NAME"))));
		clear(By.id(CheckUserXpathlocators.xpathLookup.get("SUPPORT_USER_NAME")));
		fillInTextField(CheckUserXpathlocators.xpathLookup.get("SUPPORT_USER_NAME"), userName);
		fillInTextField(CheckUserXpathlocators.xpathLookup.get("SUPPORT_PASSWORD"), password);
		click(CheckUserXpathlocators.xpathLookup.get("SUPPORT_LOGININ_BUTTON"));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CheckUserXpathlocators.xpathLookup.get("ADMIN_TAB"))));
		click(By.xpath(CheckUserXpathlocators.xpathLookup.get("ADMIN_TAB")));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(CheckUserXpathlocators.xpathLookup.get("LUCENE_INFO"))));
    	click(By.linkText(CheckUserXpathlocators.xpathLookup.get("LUCENE_INFO")));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(CheckUserXpathlocators.xpathLookup.get("UPDATE_INDEX_BUTTON"))));
		click(By.id(CheckUserXpathlocators.xpathLookup.get("UPDATE_INDEX_BUTTON")));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CheckUserXpathlocators.xpathLookup.get("MK3SUPPORT_TAB"))));
		click(By.xpath(CheckUserXpathlocators.xpathLookup.get("MK3SUPPORT_TAB")));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CheckUserXpathlocators.xpathLookup.get("SEARCH_TEXT"))));
		clearAndFillInXpathField(CheckUserXpathlocators.xpathLookup.get("SEARCH_TEXT"), tradesman);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(CheckUserXpathlocators.xpathLookup.get("GO_BUTTON"))));
		click(By.id(CheckUserXpathlocators.xpathLookup.get("GO_BUTTON")));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CheckUserXpathlocators.xpathLookup.get("CHECK_STATUS"))));
		String User_status = this.getValue(CheckUserXpathlocators.xpathLookup.get("CHECK_STATUS"));
				
		assertEquals(User_status, "VERIFIED");			
		}

		public void checkIsOverridden(String userName, String password,String tradesman) throws Exception {
			WebDriverWait wait = new WebDriverWait(context.driver,60);
			clickIfExists(By.linkText(CheckUserXpathlocators.dataLookup.get("SUPPORT_LOGOUT")));
			goTo(context.getSupportUrl() +CheckUserXpathlocators.dataLookup.get("SUPPORT_URL"));
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(CheckUserXpathlocators.xpathLookup.get("SUPPORT_USER_NAME"))));
			clear(By.id(CheckUserXpathlocators.xpathLookup.get("SUPPORT_USER_NAME")));
			fillInTextField(CheckUserXpathlocators.xpathLookup.get("SUPPORT_USER_NAME"), userName);
			fillInTextField(CheckUserXpathlocators.xpathLookup.get("SUPPORT_PASSWORD"), password);
			click(CheckUserXpathlocators.xpathLookup.get("SUPPORT_LOGININ_BUTTON"));
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CheckUserXpathlocators.xpathLookup.get("ADMIN_TAB"))));
			click(By.xpath(CheckUserXpathlocators.xpathLookup.get("ADMIN_TAB")));

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(CheckUserXpathlocators.xpathLookup.get("LUCENE_INFO"))));
        	click(By.linkText(CheckUserXpathlocators.xpathLookup.get("LUCENE_INFO")));
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(CheckUserXpathlocators.xpathLookup.get("UPDATE_INDEX_BUTTON"))));
			click(By.id(CheckUserXpathlocators.xpathLookup.get("UPDATE_INDEX_BUTTON")));
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CheckUserXpathlocators.xpathLookup.get("MK3SUPPORT_TAB"))));
			click(By.xpath(CheckUserXpathlocators.xpathLookup.get("MK3SUPPORT_TAB")));
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CheckUserXpathlocators.xpathLookup.get("SEARCH_TEXT"))));
			clearAndFillInXpathField(CheckUserXpathlocators.xpathLookup.get("SEARCH_TEXT"), tradesman);
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(CheckUserXpathlocators.xpathLookup.get("GO_BUTTON"))));
			click(By.id(CheckUserXpathlocators.xpathLookup.get("GO_BUTTON")));
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CheckUserXpathlocators.xpathLookup.get("CHECK_STATUS"))));
			String User_status = this.getValue(CheckUserXpathlocators.xpathLookup.get("CHECK_STATUS"));
					
			assertEquals(User_status, "OVERRIDDEN");	
								
		}
		
		public void checkIsNotVerified(String userName, String password,String tradesman) throws Exception {
			
			WebDriverWait wait=new 	WebDriverWait(context.driver,60);
			clickIfExists(By.linkText(CheckUserXpathlocators.dataLookup.get("SUPPORT_LOGOUT")));
			goTo(context.getSupportUrl() +CheckUserXpathlocators.dataLookup.get("SUPPORT_URL") );
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(CheckUserXpathlocators.xpathLookup.get("SUPPORT_USER_NAME"))));
			clear(By.id(CheckUserXpathlocators.xpathLookup.get("SUPPORT_USER_NAME")));
			fillInTextField(CheckUserXpathlocators.xpathLookup.get("SUPPORT_USER_NAME"), userName);
			fillInTextField(CheckUserXpathlocators.xpathLookup.get("SUPPORT_PASSWORD"), password);
			click(CheckUserXpathlocators.xpathLookup.get("SUPPORT_LOGININ_BUTTON"));
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CheckUserXpathlocators.xpathLookup.get("ADMIN_TAB"))));
			click(By.xpath(CheckUserXpathlocators.xpathLookup.get("ADMIN_TAB")));
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(CheckUserXpathlocators.xpathLookup.get("LUCENE_INFO"))));
        	click(By.linkText(CheckUserXpathlocators.xpathLookup.get("LUCENE_INFO")));

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(CheckUserXpathlocators.xpathLookup.get("UPDATE_INDEX_BUTTON"))));
			click(By.id(CheckUserXpathlocators.xpathLookup.get("UPDATE_INDEX_BUTTON")));
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CheckUserXpathlocators.xpathLookup.get("MK3SUPPORT_TAB"))));
			click(By.xpath(CheckUserXpathlocators.xpathLookup.get("MK3SUPPORT_TAB")));
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CheckUserXpathlocators.xpathLookup.get("SEARCH_TEXT"))));
			clearAndFillInXpathField(CheckUserXpathlocators.xpathLookup.get("SEARCH_TEXT"), tradesman);
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(CheckUserXpathlocators.xpathLookup.get("GO_BUTTON"))));
			click(By.id(CheckUserXpathlocators.xpathLookup.get("GO_BUTTON")));
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CheckUserXpathlocators.xpathLookup.get("CHECK_STATUS"))));
			String User_status = this.getValue(CheckUserXpathlocators.xpathLookup.get("CHECK_STATUS"));
					
			assertEquals(User_status, "NOT VERIFIED");			
			}

}