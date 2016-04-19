/**
 * 
 */
package uk.co.ratedpeople.test.functional.selenium.coresystems.mk3_changeplan;

import static org.testng.Assert.assertEquals;

import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import uk.co.ratedpeople.test.functional.SeleniumTestContext;
import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;
import uk.co.ratedpeople.test.functional.selenium.coresystems.mk3_refreshjbilling.RefreshJBillingingXPathLocators;
import uk.co.ratedpeople.test.functional.selenium.functions.Login;

/**
 * @author shobha.rani
 *
 */
public class ChangePlanToPromoPlan {

	public static Logger logger = Logger.getLogger("uk.co.ratedpeople.test.functional.selenium.coresystems.mk3");	
	private WebDriver driver;
	private Login login;
	public String uniqueEmailAccountName;
	private TestScriptUtilities scriptUtils;
	private SeleniumTestContext context;
	private static final String SUPPORT_LOGIN_USER_ID ="shobha.rani@ratedpeople.com";
	private static final String SUPPORT_LOGIN_USER__PWD ="password";
	private static final String CHANGE_PLAN_AT_NEXT_MSG = "Tradsman will switch to new plan on renewal.";
	
	public ChangePlanToPromoPlan(SeleniumTestContext context, TestScriptUtilities scriptUtils){
		driver = context.driver;
		this.context = context;
		this.scriptUtils = scriptUtils;
		login = new Login(scriptUtils, context);
	}
	
	public void tesChangeQuarterlyPromoplan(String uniqueEmailAccountName) throws Exception {
 		WebDriverWait wait = new WebDriverWait(context.driver, 50);
 		login.loginSupport(SUPPORT_LOGIN_USER_ID, SUPPORT_LOGIN_USER__PWD);
 		scriptUtils.sleep(3000);	
 		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(RefreshJBillingingXPathLocators.xpathLookup.get("MK3_SEARCH"))));
 		scriptUtils.fillInTextField(RefreshJBillingingXPathLocators.xpathLookup.get("MK3_SEARCH"), uniqueEmailAccountName);
 	    scriptUtils.click(By.xpath(RefreshJBillingingXPathLocators.xpathLookup.get("CLICK_MK3_SEARCH")));
 	    scriptUtils.sleep(3000);
 	    driver.findElement(By.id(RefreshJBillingingXPathLocators.xpathLookup.get("MK3_SEARCH"))).clear();
 	    scriptUtils.fillInTextField(RefreshJBillingingXPathLocators.xpathLookup.get("MK3_SEARCH"), uniqueEmailAccountName);
	    scriptUtils.click(By.xpath(RefreshJBillingingXPathLocators.xpathLookup.get("CLICK_MK3_SEARCH")));
	    scriptUtils.sleep(3000);
 	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(RefreshJBillingingXPathLocators.xpathLookup.get("CHANGE_PLAN_AT_NEXT_RENEWAL"))));
	    scriptUtils.click(By.id(RefreshJBillingingXPathLocators.xpathLookup.get("CHANGE_PLAN_AT_NEXT_RENEWAL")));
	    scriptUtils.sleep(3000);
	    scriptUtils.clickDropdown(By.id(RefreshJBillingingXPathLocators.xpathLookup.get("PROMO_PLAN")), 6);
	 	scriptUtils.clickDropdown(By.id(RefreshJBillingingXPathLocators.xpathLookup.get("RENEWAL")), 2);
	 	scriptUtils.clickDropdown(By.id(RefreshJBillingingXPathLocators.xpathLookup.get("FOLLOW_ON_PLAN")), 15);
	 	scriptUtils.click(By.id(RefreshJBillingingXPathLocators.xpathLookup.get("BUTTON_NEXT")));
	 	scriptUtils.sleep(5000);
	 	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(RefreshJBillingingXPathLocators.xpathLookup.get("BUTTON_CONFIRM_SWITCH"))));
	 	scriptUtils.click(By.id(RefreshJBillingingXPathLocators.xpathLookup.get("BUTTON_CONFIRM_SWITCH")));
	 	scriptUtils.sleep(5000);
	 	assertEquals(context.driver.findElement(By.id(RefreshJBillingingXPathLocators.xpathLookup.get("PLAN_SWITCH_MSG"))).getText(),CHANGE_PLAN_AT_NEXT_MSG);
 	    
	}
	
	public void tesChangeMonthlyPromoplan(String uniqueEmailAccountName) throws Exception {
 		WebDriverWait wait = new WebDriverWait(context.driver, 50);
 		login.loginSupport(SUPPORT_LOGIN_USER_ID, SUPPORT_LOGIN_USER__PWD);
 		scriptUtils.sleep(3000);	
 		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(RefreshJBillingingXPathLocators.xpathLookup.get("CLICK_ADMIN")))).click();
 		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(RefreshJBillingingXPathLocators.xpathLookup.get("CLICK_LUCENE_INFO")))).click();
 		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(RefreshJBillingingXPathLocators.xpathLookup.get("CLICK_UPDATE_INDEX")))).click();
 		scriptUtils.sleep(4000);
 		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(RefreshJBillingingXPathLocators.xpathLookup.get("MK3_SEARCH"))));
 	    driver.findElement(By.id(RefreshJBillingingXPathLocators.xpathLookup.get("MK3_SEARCH"))).clear();
	    scriptUtils.fillInTextField(RefreshJBillingingXPathLocators.xpathLookup.get("MK3_SEARCH"), uniqueEmailAccountName);
	    scriptUtils.click(By.xpath(RefreshJBillingingXPathLocators.xpathLookup.get("CLICK_MK3_SEARCH")));
	    scriptUtils.sleep(3000);
 	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(RefreshJBillingingXPathLocators.xpathLookup.get("CHANGE_PLAN_AT_NEXT_RENEWAL"))));
	    scriptUtils.click(By.id(RefreshJBillingingXPathLocators.xpathLookup.get("CHANGE_PLAN_AT_NEXT_RENEWAL")));
	    scriptUtils.sleep(3000);
	    scriptUtils.clickDropdown(By.id(RefreshJBillingingXPathLocators.xpathLookup.get("PROMO_PLAN")), 7);
	 	scriptUtils.clickDropdown(By.id(RefreshJBillingingXPathLocators.xpathLookup.get("RENEWAL")), 2);
	 	scriptUtils.clickDropdown(By.id(RefreshJBillingingXPathLocators.xpathLookup.get("FOLLOW_ON_PLAN")), 15);
	 	scriptUtils.click(By.id(RefreshJBillingingXPathLocators.xpathLookup.get("BUTTON_NEXT")));
	 	scriptUtils.sleep(5000);
	 	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(RefreshJBillingingXPathLocators.xpathLookup.get("BUTTON_CONFIRM_SWITCH"))));
	 	scriptUtils.click(By.id(RefreshJBillingingXPathLocators.xpathLookup.get("BUTTON_CONFIRM_SWITCH")));
	 	scriptUtils.sleep(5000);
	 	assertEquals(context.driver.findElement(By.id(RefreshJBillingingXPathLocators.xpathLookup.get("PLAN_SWITCH_MSG"))).getText(),CHANGE_PLAN_AT_NEXT_MSG);
 	    
	}
}

