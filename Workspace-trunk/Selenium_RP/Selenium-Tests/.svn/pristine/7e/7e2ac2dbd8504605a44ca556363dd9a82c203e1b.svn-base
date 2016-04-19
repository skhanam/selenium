/**
 * 
 */
package uk.co.ratedpeople.test.functional.selenium.local;

import java.util.logging.Logger;

import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;

/**
 * @author shabana.khanam
 * 
 */
public class SearchPage {

	public static Logger logger = Logger.getLogger("uk.co.ratedpeople.test.functional.selenium.SearchPage");
	private WebDriver driver;
	private String testUrl;
	private TestScriptUtilities scriptUtils;
	private static final String TRADE_SELECT_ELEMENT_ID = "jobFormTrade";
	private static final String JOBTYPE_ELEMENT_ID = "jobFormJobType";

	public SearchPage(WebDriver driver, String testUrl, TestScriptUtilities scriptUtils) {
		this.driver = driver;
		this.testUrl = testUrl;
		this.scriptUtils = scriptUtils;

	}

	public void searchPostcode(String postCode, String changeLocation) throws Exception {
		// Added
		if (StringUtils.isNotBlank(postCode)) {
			scriptUtils.fillInXpathField(postCode, LocalXpathLocators.dataLookup.get("POSTCODE"));
		}
		scriptUtils.clickXpath(changeLocation);

	}

	public void findJob(String tradeCode, String jobTypeId) throws Exception {

		WebDriverWait waitfortrade = new WebDriverWait(driver, 10);
		By byvaluetrade = By.cssSelector("#jobFormTrade > option[value='" + tradeCode + "']");
		waitfortrade.until(ExpectedConditions.presenceOfElementLocated(byvaluetrade));

		Thread.sleep(2000);

		Select jobTypeSelect = new Select(driver.findElement(By.id(TRADE_SELECT_ELEMENT_ID)));
		jobTypeSelect.selectByValue(tradeCode);

		// wait a bit to give a chance for the AJAX call to populate the skill drop-down
		// and for us to select option 58 - Plumbing Repair & Maintenance
		WebDriverWait wait = new WebDriverWait(driver, 10);
		By byValue = By.cssSelector("#jobFormJobType > option[value='" + jobTypeId + "']");
		wait.until(ExpectedConditions.presenceOfElementLocated(byValue));

		Select tradeCodeSelect = new Select(driver.findElement(By.id(JOBTYPE_ELEMENT_ID)));
		tradeCodeSelect.selectByValue(jobTypeId);
		Thread.sleep(2000);
		scriptUtils.clickXpath(LocalXpathLocators.xpathLookup.get("GOBTN"));
	}

	public String getTestUrl() {
		return testUrl;
	}

	public void setTestUrl(String testUrl) {
		this.testUrl = testUrl;
	}

}
