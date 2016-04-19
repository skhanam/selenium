/**
 * 
 */
package uk.co.ratedpeople.test.functional.selenium.core.regression;

import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import uk.co.ratedpeople.test.functional.SeleniumTestContext;
import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;

/**
 * @author shabana.khanam
 *
 */
public class CreditBundles {

	public static Logger logger = Logger.getLogger("uk.co.ratedpeople.test.functional.selenium.core.regression.BuyaLead");
	private WebDriver driver;
	private WebDriverWait wait;
	private TestScriptUtilities scriptUtils;

	public  CreditBundles(SeleniumTestContext context, String testUrl, TestScriptUtilities scriptUtils) {
		this.driver = context.driver;
		this.scriptUtils = scriptUtils;
		wait = new WebDriverWait(driver, 60);
	}
	
	
	public void awardcreditBundle() throws InterruptedException{
		Thread.sleep(3000);
		scriptUtils.click(By.xpath(CreditBundleLocators.xpathLookup.get("CREDITBUNDLE")));
		Thread.sleep(3000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(CreditBundleLocators.xpathLookup.get("CREDITHEADER"))));
		scriptUtils.clearAndFillInXpathField(CreditBundleLocators.xpathLookup.get("CREDIT"), "500");
		scriptUtils.clearAndFillInXpathField(CreditBundleLocators.xpathLookup.get("COST"), "50");
		scriptUtils.click(By.xpath(CreditBundleLocators.xpathLookup.get("PAYBTN")));
		Thread.sleep(3000);
	}
}
