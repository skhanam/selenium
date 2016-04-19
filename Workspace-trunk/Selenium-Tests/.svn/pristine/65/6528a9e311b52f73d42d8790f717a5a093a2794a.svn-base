/**
 * 
 */
package uk.co.ratedpeople.test.functional.selenium.coresystems.mk3_tmbalance;

import static org.testng.Assert.assertEquals;

import java.util.logging.Logger;

import org.openqa.selenium.By;
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
public class VerifyFreeBalanceandSpecialCreditMK3 {

	public static Logger logger = Logger.getLogger("uk.co.ratedpeople.test.functional.selenium.coresystems.mk3");	
	private Login login;
	private TestScriptUtilities scriptUtils;
	private SeleniumTestContext context;
    private static final String SUPPORT_LOGIN_USER_ID ="shobha.rani@ratedpeople.com";
    private static final String SUPPORT_LOGIN_USER__PWD ="password";
    public String uniqueEmailAccountName;
    private static final String BALANCE_NEWTM_MK3 ="£30.00" ;
    private static final String BALANCE_NEWTM_SPECIAL_MK3 = "£0.00";
    private static final String BALANCE_FREE_TRAIL_MK3 ="£10.00" ;
    private static final String ANNUAL_TM_USER ="mk3.balance@ratedtrades.com";
    private static final String ANNUAL_FREE_TRAIL_USER ="trailplan.yearfree@ratedtrades.com";
    private static final String MONTHLY_TM_USER ="monthly.plan@ratedtrades.com";

	public VerifyFreeBalanceandSpecialCreditMK3(SeleniumTestContext context, TestScriptUtilities scriptUtils) {
		this.context = context;
		this.scriptUtils = scriptUtils;
		login = new Login(scriptUtils, context);
	}
	
	public void testCheckNewTMBalanceinMK3() throws Exception {
 		WebDriverWait wait = new WebDriverWait(context.driver, 50);
 		login.loginSupport(SUPPORT_LOGIN_USER_ID, SUPPORT_LOGIN_USER__PWD);
 		scriptUtils.sleep(3000);
 		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(RefreshJBillingingXPathLocators.xpathLookup.get("MK3_SEARCH"))));
 		scriptUtils.fillInTextField(RefreshJBillingingXPathLocators.xpathLookup.get("MK3_SEARCH"), MONTHLY_TM_USER);
 	    scriptUtils.click(By.xpath(RefreshJBillingingXPathLocators.xpathLookup.get("CLICK_MK3_SEARCH")));
 	    scriptUtils.sleep(3000);
 	    assertEquals(context.driver.findElement(By.id(VerifyFreeBalanceandSpecialCreditXPathlocators.xpathLookup.get("USER_ACC_BALANCE"))).getText(),BALANCE_NEWTM_MK3);
 	    assertEquals(context.driver.findElement(By.id(VerifyFreeBalanceandSpecialCreditXPathlocators.xpathLookup.get("USER_ACC_FREE_BALANCE"))).getText(),BALANCE_NEWTM_MK3);
 	    assertEquals(context.driver.findElement(By.id(VerifyFreeBalanceandSpecialCreditXPathlocators.xpathLookup.get("USER_ACC_SPE_CREDIT_BALANCE"))).getText(),BALANCE_NEWTM_SPECIAL_MK3);
 	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(RefreshJBillingingXPathLocators.xpathLookup.get("LOGOUT_MK3")))).click();
 	   scriptUtils.sleep(2000);
   }
	
	public void testCheckNewAnnualTMBalanceinMK3() throws Exception {
 		WebDriverWait wait = new WebDriverWait(context.driver, 50);
 		login.loginSupport(SUPPORT_LOGIN_USER_ID, SUPPORT_LOGIN_USER__PWD);
 		scriptUtils.sleep(3000);
 		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(RefreshJBillingingXPathLocators.xpathLookup.get("MK3_SEARCH"))));
 		scriptUtils.fillInTextField(RefreshJBillingingXPathLocators.xpathLookup.get("MK3_SEARCH"), ANNUAL_TM_USER);
 	    scriptUtils.click(By.xpath(RefreshJBillingingXPathLocators.xpathLookup.get("CLICK_MK3_SEARCH")));
 	    scriptUtils.sleep(3000);
 	    assertEquals(context.driver.findElement(By.id(VerifyFreeBalanceandSpecialCreditXPathlocators.xpathLookup.get("USER_ACC_BALANCE"))).getText(),BALANCE_NEWTM_MK3);
 	    assertEquals(context.driver.findElement(By.id(VerifyFreeBalanceandSpecialCreditXPathlocators.xpathLookup.get("USER_ACC_FREE_BALANCE"))).getText(),BALANCE_NEWTM_MK3);
 	    assertEquals(context.driver.findElement(By.id(VerifyFreeBalanceandSpecialCreditXPathlocators.xpathLookup.get("USER_ACC_SPE_CREDIT_BALANCE"))).getText(),BALANCE_NEWTM_SPECIAL_MK3);
 	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(RefreshJBillingingXPathLocators.xpathLookup.get("LOGOUT_MK3")))).click();
 	    scriptUtils.sleep(2000);
  }
	public void testChecksuspendedfreetrailplanTMBalanceinMK3() throws Exception {
 		WebDriverWait wait = new WebDriverWait(context.driver, 50);
 		login.loginSupport(SUPPORT_LOGIN_USER_ID, SUPPORT_LOGIN_USER__PWD);
 		scriptUtils.sleep(3000);
 		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(RefreshJBillingingXPathLocators.xpathLookup.get("MK3_SEARCH"))));
 		scriptUtils.fillInTextField(RefreshJBillingingXPathLocators.xpathLookup.get("MK3_SEARCH"), ANNUAL_FREE_TRAIL_USER);
 	    scriptUtils.click(By.xpath(RefreshJBillingingXPathLocators.xpathLookup.get("CLICK_MK3_SEARCH")));
 	    scriptUtils.sleep(3000);
 	    assertEquals(context.driver.findElement(By.id(VerifyFreeBalanceandSpecialCreditXPathlocators.xpathLookup.get("USER_ACC_BALANCE"))).getText(),BALANCE_FREE_TRAIL_MK3);
 	    assertEquals(context.driver.findElement(By.id(VerifyFreeBalanceandSpecialCreditXPathlocators.xpathLookup.get("USER_ACC_FREE_BALANCE"))).getText(),BALANCE_FREE_TRAIL_MK3);
 	    assertEquals(context.driver.findElement(By.id(VerifyFreeBalanceandSpecialCreditXPathlocators.xpathLookup.get("USER_ACC_SPE_CREDIT_BALANCE"))).getText(),BALANCE_NEWTM_SPECIAL_MK3);
 	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(RefreshJBillingingXPathLocators.xpathLookup.get("LOGOUT_MK3")))).click();
 	    scriptUtils.sleep(2000);
     }
}