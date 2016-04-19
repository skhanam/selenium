/**
 * 
 */
package uk.co.ratedpeople.test.functional.selenium.local;

import static org.testng.Assert.assertEquals;

import java.util.logging.Logger;

import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;

/**
 * @author shabana.khanam
 * 
 */
public class SearchPredictive {

	public static Logger logger = Logger.getLogger(SearchPredictive.class.getName());
	private WebDriver driver;
	private String testUrl;
	private TestScriptUtilities scriptUtils;
	private static final String TRADE_SELECT_ELEMENT_ID = "jobFormTrade";
	private static final String JOBTYPE_ELEMENT_ID = "jobFormJobType";

	public SearchPredictive(WebDriver driver, String testUrl, TestScriptUtilities scriptUtils) {
		this.driver = driver;
		this.testUrl = testUrl;
		this.scriptUtils = scriptUtils;

	}

	public void searchText(String searchText, String searchStr, String browse) throws Exception {
		if (StringUtils.isNotBlank(searchText)) {
			scriptUtils.fillInXpathField(searchText, searchStr);
		}
		waitForAutoComplete();
		scriptUtils.clickXpath(browse);
	}

	public void waitForAutoComplete() throws Exception {
		Thread.sleep(3000);
		String getText = driver.findElement(By.xpath(".//*[@class='ui-menu-item']/a")).getText();
		logger.info("Here it is Text : " + getText);
		driver.findElement(By.cssSelector("li.ui-menu-item a")).click();
		// if(getText.contains(LocalXpathLocators.dataLookup.get("NORESULTS")))
		// {
		// String getTitle = driver.getTitle();
		// assertEquals(getTitle,LocalXpathLocators.assertLookup.get("LOCALPAGE"));
		// }
		// else{
		// driver.findElement(By.cssSelector("li.ui-menu-item")).click();
		// }
	}

	public void getErrorMsgPredictive() throws Exception {

		String getText = driver.findElement(By.xpath(".//*[@class='ui-corner-all ui-state-focus']")).getText();
		logger.info("Here it is Text : " + getText);

		// assertEquals(LocalXpathLocators.assertLookup.get("NORESULTS"),getText);

		assertEquals(false, scriptUtils.checkDisabled(By.xpath(LocalXpathLocators.xpathLookup.get("SEARCHBUTN"))));

	}

	public void invalidsearch(String searchText, String searchStr, String browse) throws Exception {
		searchText(searchText, searchStr, browse);

	}

	public void validateAskanExpertExists(String askanexpert, String question, String assertmsg) throws NoSuchElementException {
		if (StringUtils.isNotBlank(askanexpert)) {
			scriptUtils.fillInXpathField(askanexpert, question);
		}
		scriptUtils.click(By.xpath(LocalXpathLocators.xpathLookup.get("ASKANEXPERTBTN")));
		// String getTitle = driver.getTitle();
		// assertEquals(getTitle,assertmsg);
	}

	public void validateSocialMedia(String socialmedia, String assertMsg) throws InterruptedException {
		if (StringUtils.isNotBlank(socialmedia)) {
			scriptUtils.clickXpath(socialmedia);
			Thread.sleep(3000);
		}
		scriptUtils.getParentWindow();
		String getCurrentWinTitle = scriptUtils.getCurrentWindow();
		// String getTitle = driver.getTitle();
		logger.info("Social Media Title is : " + getCurrentWinTitle);
		assertEquals(getCurrentWinTitle, assertMsg);
	}

	public void dragAndDrop(String startElement, String lastElement) throws InterruptedException {
		// scriptUtils.findElement(By.xpath(startElement));
		// scriptUtils.findElement(By.xpath(lastElement));
		// (new Actions(driver)).dragAndDrop(scriptUtils.findElement(By.xpath(startElement)), scriptUtils.findElement(By.xpath(lastElement))).perform();
		// logger.info("In drag & drop ");

		Actions moveSliderStart = new Actions(driver);
		Actions actionStart = moveSliderStart.dragAndDropBy(scriptUtils.findElement(By.xpath(startElement)), 30, 0);
		actionStart.perform();
		Thread.sleep(1000);
		Actions moveSliderEnd = new Actions(driver);
		Actions actionEnd = moveSliderEnd.dragAndDropBy(scriptUtils.findElement(By.xpath(lastElement)), 30, 100);

		actionEnd.perform();
		Thread.sleep(1000);
	}

	public void filterAdvanced(String timing, String trade, String status, String startPrice, String endPrice) throws Exception {
		if (StringUtils.isNotBlank(timing)) {
			// scriptUtils.selectDropdown(timing, 3);
			// Select
			Select jobTypeSelect = new Select(driver.findElement(By.xpath(timing)));
			jobTypeSelect.selectByValue("720");
			Thread.sleep(3000);
		}
		if (StringUtils.isNotBlank(trade)) {
			Select jobTypeSelect = new Select(driver.findElement(By.xpath(trade)));
			jobTypeSelect.selectByValue("electrician");
			Thread.sleep(3000);
		}
		if (StringUtils.isNotBlank(status)) {
			Select jobTypeSelect = new Select(driver.findElement(By.xpath(status)));
			jobTypeSelect.selectByValue("RATED");
			Thread.sleep(3000);
		}
		dragAndDrop(startPrice, endPrice);
	}

	public void searchPostcode(String postCode, String changeLocation) throws Exception {
		// Added
		if (StringUtils.isNotBlank(postCode)) {
			scriptUtils.fillInXpathField(postCode, LocalXpathLocators.dataLookup.get("POSTCODE"));
		}
		scriptUtils.clickXpath(changeLocation);

	}

	public void findJob(String tradeCode, String jobTypeId) throws Exception {
		if (StringUtils.isNotBlank(tradeCode)) {
			WebDriverWait waitfortrade = new WebDriverWait(driver, 10);
			By byvaluetrade = By.cssSelector("#jobFormTrade > option[value='" + tradeCode + "']");
			waitfortrade.until(ExpectedConditions.presenceOfElementLocated(byvaluetrade));

			Thread.sleep(2000);

			Select jobTypeSelect = new Select(driver.findElement(By.id(TRADE_SELECT_ELEMENT_ID)));
			jobTypeSelect.selectByValue(tradeCode);
		}
		// wait a bit to give a chance for the AJAX call to populate the skill drop-down
		// and for us to select option 58 - Plumbing Repair & Maintenance
		if (StringUtils.isNotBlank(jobTypeId)) {
			By byValue = By.cssSelector("#jobFormJobType > option[value='" + jobTypeId + "']");
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.presenceOfElementLocated(byValue));

			Select tradeCodeSelect = new Select(driver.findElement(By.id(JOBTYPE_ELEMENT_ID)));
			tradeCodeSelect.selectByValue(jobTypeId);
		}

		WebDriverWait waitForButton = new WebDriverWait(this.driver, 10);
		waitForButton.until(ExpectedConditions.presenceOfElementLocated(By.xpath(LocalXpathLocators.xpathLookup.get("GOBTN"))));
		scriptUtils.clickXpath(LocalXpathLocators.xpathLookup.get("GOBTN"));
	}

	public String getTestUrl() {
		return testUrl;
	}

	public void setTestUrl(String testUrl) {
		this.testUrl = testUrl;
	}

}
