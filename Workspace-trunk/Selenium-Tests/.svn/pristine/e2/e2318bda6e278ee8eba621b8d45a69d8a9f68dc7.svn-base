/**
 * 
 */
package uk.co.ratedpeople.test.functional.selenium.coresystems.mk3_masquerade;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import uk.co.ratedpeople.test.functional.SeleniumTestContext;
import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;
import uk.co.ratedpeople.test.functional.selenium.coresystems.mk3_tmuserstatus.CheckUserXpathlocators;
import uk.co.ratedpeople.test.functional.selenium.functions.Login;

/**
 * @author shobha.rani
 *
 */
public class LoginCheck {
	private Login login;
	private SeleniumTestContext context;
	private TestScriptUtilities scriptUtils;
	private static final String SUPPORT_LOGIN_USER1= "aaron.barwell@ratedpeople.com";
	private static final String SUPPORT_LOGIN_USER2 = "shobha.rani@ratedpeople.com";
	private static final String SEARCH_TM_USER = "111421-10-Sep-2013-@ratedtrades.com";
	private static final String SUPPORT_LOGIN_PWD="password";
	
     public LoginCheck(SeleniumTestContext context, TestScriptUtilities scriptUtils) {
    	this.context = context;
    	this.scriptUtils = scriptUtils;
		login = new Login(scriptUtils, context);
	}

     public void MasqueradeLogin() throws Exception {
 		WebDriverWait wait = new WebDriverWait(context.driver, 50);
 		login.loginSupport(SUPPORT_LOGIN_USER1, SUPPORT_LOGIN_PWD);
 		Thread.sleep(5000);
 	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(CheckUserXpathlocators.xpathLookup.get("MK3_SEARCH"))));
 		scriptUtils.fillInTextField(CheckUserXpathlocators.xpathLookup.get("MK3_SEARCH"), SEARCH_TM_USER);
 	    scriptUtils.click(By.xpath(CheckUserXpathlocators.xpathLookup.get("CLICK_MK3_SEARCH")));
 	    Thread.sleep(5000);
 	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='subnav']/ul/li[8]/a")));
 	    scriptUtils.click(By.xpath(".//*[@id='subnav']/ul/li[8]/a"));
 	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CheckUserXpathlocators.xpathLookup.get("USER_DETAILS"))));
 	    scriptUtils.click(By.xpath(CheckUserXpathlocators.xpathLookup.get("USER_DETAILS")));
 	    Thread.sleep(5000);
 	  // Switching control to login screen
        context.driver.switchTo().window("_masquerade");
        // Agent login 
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(CheckUserXpathlocators.xpathLookup.get("AGENT_MASQARADE_LOGIN"))));
 	    scriptUtils.fillInTextField(CheckUserXpathlocators.xpathLookup.get("AGENT_MASQARADE_LOGIN"), SUPPORT_LOGIN_USER2 );
		scriptUtils.fillInTextField(CheckUserXpathlocators.xpathLookup.get("AGENT_MASQARADE_PWD"), SUPPORT_LOGIN_PWD);
		scriptUtils.click(By.xpath(CheckUserXpathlocators.xpathLookup.get("CLICK_MASQAERADE_LOGIN_BUTTON")));
        Thread.sleep(3000);
		assertEquals(context.driver.findElement(By.id("asideButton")).getText(),"Edit job lead settings");
     }
     
     
     }
