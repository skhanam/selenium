package uk.co.ratedpeople.test.functional.selenium.ho.searchjobs;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import uk.co.ratedpeople.test.functional.selenium.TestScript;

/**
 * @author danthalapalli.aravind
 * 
 */
public class SearchJobsTest extends TestScript {

	private SearchJobs underTest;
	private static final String POSTCODE = "London";

	@BeforeClass
	public void beforeClass() throws Exception {
		underTest = new SearchJobs(context.getTestUrl(), scriptUtilities);
	}

	@Test(enabled = true)
	public void SearchjobsUsingSearchJobsTest() throws Exception {
		underTest.gotohomepage();
		underTest.fillinSearchjobfield("London");
		context.driver.findElement(By.id(SearchJobsXpathLocators.datalocators.get("SEARCH_BUTTON"))).click();
		WebDriverWait waiter = new WebDriverWait(context.driver, 20);

		waiter.until(ExpectedConditions.presenceOfElementLocated(By.xpath(SearchJobsXpathLocators.xpathlocators.get("HEADERTEXT_XPATH"))));
		assertEquals(context.driver.findElement(By.xpath(SearchJobsXpathLocators.xpathlocators.get("HEADERTEXT_XPATH"))).getText(),
				SearchJobsXpathLocators.datalocators.get("HEADERTEXT_TEXT"));

		context.driver.findElement(By.xpath(SearchJobsXpathLocators.xpathlocators.get("KEYWORD_XPATH"))).clear();

		context.driver.findElement(By.xpath(SearchJobsXpathLocators.xpathlocators.get("POSTCODE_XPATH"))).sendKeys(POSTCODE);

		context.driver.findElement(By.xpath(SearchJobsXpathLocators.xpathlocators.get("SEARCHBUTTON_XPATH"))).click();
		waiter.until(ExpectedConditions.elementToBeClickable(By.xpath(SearchJobsXpathLocators.xpathlocators.get("FIRSTLINK_XPATH"))));
		context.driver.findElement(By.xpath(SearchJobsXpathLocators.xpathlocators.get("FIRSTLINK_XPATH"))).click();
		waiter.until(ExpectedConditions.presenceOfElementLocated(By.xpath(SearchJobsXpathLocators.xpathlocators.get("FIRSTLINKTEXT_XPATH"))));
		assertEquals(context.driver.findElement(By.xpath(SearchJobsXpathLocators.xpathlocators.get("FIRSTLINKTEXT_XPATH"))).getText(),
				SearchJobsXpathLocators.datalocators.get("FIRSTLINKTEXT_TEXT"));
		waiter.until(ExpectedConditions.presenceOfElementLocated(By.xpath(SearchJobsXpathLocators.xpathlocators.get("ALSOBEINTRESTED_XPATH"))));

		assertEquals(context.driver.findElement(By.xpath(SearchJobsXpathLocators.xpathlocators.get("ALSOBEINTRESTED_XPATH"))).getText(),
				SearchJobsXpathLocators.datalocators.get("ALSOBEINTRESTED_TEXT"));

	}

	@Test(enabled = true)
	public void SelectTradeUsingSearchJobsTest() throws Exception {
		underTest.gotohomepage();
		underTest.fillinSearchjobfield("London");
		context.driver.findElement(By.id(SearchJobsXpathLocators.datalocators.get("SEARCH_BUTTON"))).click();
		WebDriverWait waiter = new WebDriverWait(context.driver, 10);

		waiter.until(ExpectedConditions.presenceOfElementLocated(By.xpath(SearchJobsXpathLocators.xpathlocators.get("HEADERTEXT_XPATH"))));
		assertEquals(context.driver.findElement(By.xpath(SearchJobsXpathLocators.xpathlocators.get("HEADERTEXT_XPATH"))).getText(),
				SearchJobsXpathLocators.datalocators.get("HEADERTEXT_TEXT"));
		waiter.until(ExpectedConditions.presenceOfElementLocated(By.xpath(SearchJobsXpathLocators.xpathlocators.get("KEYWORD_XPATH"))));
		context.driver.findElement(By.xpath(SearchJobsXpathLocators.xpathlocators.get("KEYWORD_XPATH"))).clear();

		WebElement element = context.driver.findElement(By.tagName("select"));

		List<WebElement> trade = element.findElements(By.tagName("option"));
		for (int i = 0; i < trade.size(); i++) {
			System.out.println("list of values are : " + trade.get(i).getText());
		}

		waiter.until(ExpectedConditions.elementToBeClickable(By.xpath(SearchJobsXpathLocators.xpathlocators.get("LISTOFTRADES_XPATH"))));

		context.driver.findElement(By.xpath(SearchJobsXpathLocators.xpathlocators.get("LISTOFTRADES_XPATH"))).sendKeys("aerials & networks");
		waiter.until(ExpectedConditions.elementToBeClickable(By.xpath(SearchJobsXpathLocators.xpathlocators.get("SEARCHBUTTON_XPATH"))));
		context.driver.findElement(By.xpath(SearchJobsXpathLocators.xpathlocators.get("SEARCHBUTTON_XPATH"))).click();
		waiter.until(ExpectedConditions.elementToBeClickable(By.xpath(SearchJobsXpathLocators.xpathlocators.get("FIRSTLINK_XPATH"))));
		context.driver.findElement(By.xpath(SearchJobsXpathLocators.xpathlocators.get("FIRSTLINK_XPATH"))).click();

		waiter.until(ExpectedConditions.presenceOfElementLocated(By.xpath(SearchJobsXpathLocators.xpathlocators.get("FIRSTLINKTEXT_XPATH"))));
		assertEquals(context.driver.findElement(By.xpath(SearchJobsXpathLocators.xpathlocators.get("FIRSTLINKTEXT_XPATH"))).getText(),
				SearchJobsXpathLocators.datalocators.get("arealnetworklinkText_TEXT"));

		context.driver.navigate().back();
		waiter.until(ExpectedConditions.elementToBeClickable(By.xpath(SearchJobsXpathLocators.xpathlocators.get("LISTOFTRADES_XPATH"))));
		context.driver.findElement(By.xpath(SearchJobsXpathLocators.xpathlocators.get("LISTOFTRADES_XPATH"))).sendKeys("bathrooms");
		waiter.until(ExpectedConditions.elementToBeClickable(By.xpath(SearchJobsXpathLocators.xpathlocators.get("SEARCHBUTTON_XPATH"))));
		context.driver.findElement(By.xpath(SearchJobsXpathLocators.xpathlocators.get("SEARCHBUTTON_XPATH"))).click();
		waiter.until(ExpectedConditions.elementToBeClickable(By.xpath(SearchJobsXpathLocators.xpathlocators.get("FIRSTLINK_XPATH"))));
		context.driver.findElement(By.xpath(SearchJobsXpathLocators.xpathlocators.get("FIRSTLINK_XPATH"))).click();
		waiter.until(ExpectedConditions.presenceOfElementLocated(By.xpath(SearchJobsXpathLocators.xpathlocators.get("FIRSTLINKTEXT_XPATH"))));

		assertEquals(context.driver.findElement(By.xpath(SearchJobsXpathLocators.xpathlocators.get("FIRSTLINKTEXT_XPATH"))).getText(),
				SearchJobsXpathLocators.datalocators.get("bathroomlinkText_TEXT"));

		context.driver.navigate().back();
		waiter.until(ExpectedConditions.elementToBeClickable(By.xpath(SearchJobsXpathLocators.xpathlocators.get("LISTOFTRADES_XPATH"))));
		context.driver.findElement(By.xpath(SearchJobsXpathLocators.xpathlocators.get("LISTOFTRADES_XPATH"))).sendKeys("bricklaying");
		waiter.until(ExpectedConditions.elementToBeClickable(By.xpath(SearchJobsXpathLocators.xpathlocators.get("SEARCHBUTTON_XPATH"))));
		context.driver.findElement(By.xpath(SearchJobsXpathLocators.xpathlocators.get("SEARCHBUTTON_XPATH"))).click();
		waiter.until(ExpectedConditions.elementToBeClickable(By.xpath(SearchJobsXpathLocators.xpathlocators.get("FIRSTLINK_XPATH"))));
		context.driver.findElement(By.xpath(SearchJobsXpathLocators.xpathlocators.get("FIRSTLINK_XPATH"))).click();
		waiter.until(ExpectedConditions.presenceOfElementLocated(By.xpath(SearchJobsXpathLocators.xpathlocators.get("FIRSTLINKTEXT_XPATH"))));

		assertEquals(context.driver.findElement(By.xpath(SearchJobsXpathLocators.xpathlocators.get("FIRSTLINKTEXT_XPATH"))).getText(),
				SearchJobsXpathLocators.datalocators.get("bricklayinglinkText_TEXT"));

		context.driver.navigate().back();
		waiter.until(ExpectedConditions.elementToBeClickable(By.xpath(SearchJobsXpathLocators.xpathlocators.get("LISTOFTRADES_XPATH"))));
		context.driver.findElement(By.xpath(SearchJobsXpathLocators.xpathlocators.get("LISTOFTRADES_XPATH"))).sendKeys("building");
		waiter.until(ExpectedConditions.elementToBeClickable(By.xpath(SearchJobsXpathLocators.xpathlocators.get("SEARCHBUTTON_XPATH"))));
		context.driver.findElement(By.xpath(SearchJobsXpathLocators.xpathlocators.get("SEARCHBUTTON_XPATH"))).click();
		waiter.until(ExpectedConditions.elementToBeClickable(By.xpath(SearchJobsXpathLocators.xpathlocators.get("FIRSTLINK_XPATH"))));
		context.driver.findElement(By.xpath(SearchJobsXpathLocators.xpathlocators.get("FIRSTLINK_XPATH"))).click();
		waiter.until(ExpectedConditions.presenceOfElementLocated(By.xpath(SearchJobsXpathLocators.xpathlocators.get("FIRSTLINKTEXT_XPATH"))));
		assertEquals(context.driver.findElement(By.xpath(SearchJobsXpathLocators.xpathlocators.get("FIRSTLINKTEXT_XPATH"))).getText(),
				SearchJobsXpathLocators.datalocators.get("buildinglinkText_TEXT"));

		context.driver.navigate().back();
		waiter.until(ExpectedConditions.elementToBeClickable(By.xpath(SearchJobsXpathLocators.xpathlocators.get("SEARCHBUTTON_XPATH"))));
		context.driver.findElement(By.xpath(SearchJobsXpathLocators.xpathlocators.get("LISTOFTRADES_XPATH"))).sendKeys("carpentry & joinery");
		waiter.until(ExpectedConditions.elementToBeClickable(By.xpath(SearchJobsXpathLocators.xpathlocators.get("SEARCHBUTTON_XPATH"))));
		context.driver.findElement(By.xpath(SearchJobsXpathLocators.xpathlocators.get("SEARCHBUTTON_XPATH"))).click();
		waiter.until(ExpectedConditions.elementToBeClickable(By.xpath(SearchJobsXpathLocators.xpathlocators.get("FIRSTLINK_XPATH"))));
		context.driver.findElement(By.xpath(SearchJobsXpathLocators.xpathlocators.get("FIRSTLINK_XPATH"))).click();
		waiter.until(ExpectedConditions.presenceOfElementLocated(By.xpath(SearchJobsXpathLocators.xpathlocators.get("FIRSTLINKTEXT_XPATH"))));
		assertEquals(context.driver.findElement(By.xpath(SearchJobsXpathLocators.xpathlocators.get("FIRSTLINKTEXT_XPATH"))).getText(),
				SearchJobsXpathLocators.datalocators.get("carpentry&joinerylinkText_TEXT"));

		context.driver.navigate().back();
		waiter.until(ExpectedConditions.elementToBeClickable(By.xpath(SearchJobsXpathLocators.xpathlocators.get("LISTOFTRADES_XPATH"))));
		context.driver.findElement(By.xpath(SearchJobsXpathLocators.xpathlocators.get("LISTOFTRADES_XPATH"))).sendKeys("locksmith");
		waiter.until(ExpectedConditions.elementToBeClickable(By.xpath(SearchJobsXpathLocators.xpathlocators.get("SEARCHBUTTON_XPATH"))));
		context.driver.findElement(By.xpath(SearchJobsXpathLocators.xpathlocators.get("SEARCHBUTTON_XPATH"))).click();
		waiter.until(ExpectedConditions.elementToBeClickable(By.xpath(SearchJobsXpathLocators.xpathlocators.get("FIRSTLINK_XPATH"))));

		context.driver.findElement(By.xpath(SearchJobsXpathLocators.xpathlocators.get("FIRSTLINK_XPATH"))).click();

		waiter.until(ExpectedConditions.presenceOfElementLocated(By.xpath(SearchJobsXpathLocators.xpathlocators.get("FIRSTLINKTEXT_XPATH"))));
		assertEquals(context.driver.findElement(By.xpath(SearchJobsXpathLocators.xpathlocators.get("FIRSTLINKTEXT_XPATH"))).getText(),
				SearchJobsXpathLocators.datalocators.get("locksmithlinkText_TEXT"));
		waiter.until(ExpectedConditions.elementToBeClickable(By.xpath(SearchJobsXpathLocators.xpathlocators.get("registernow_xpath"))));
		context.driver.findElement(By.xpath(SearchJobsXpathLocators.xpathlocators.get("registernow_xpath"))).click();

		waiter.until(ExpectedConditions.presenceOfElementLocated(By.xpath(SearchJobsXpathLocators.xpathlocators.get("connectwith_XPATH"))));
		assertEquals(context.driver.findElement(By.xpath(SearchJobsXpathLocators.xpathlocators.get("connectwith_XPATH"))).getText(),
				SearchJobsXpathLocators.datalocators.get("connectwithText_TEXT"));

	}

	@Test(enabled = true)
	public void SelectAllLinksSearchJobsTest() throws Exception {
		underTest.gotohomepage();
		underTest.fillinSearchjobfield("London");
		context.driver.findElement(By.id(SearchJobsXpathLocators.datalocators.get("SEARCH_BUTTON"))).click();
		WebDriverWait waiter = new WebDriverWait(context.driver, 10);

		waiter.until(ExpectedConditions.presenceOfElementLocated(By.xpath(SearchJobsXpathLocators.xpathlocators.get("HEADERTEXT_XPATH"))));

		assertEquals(context.driver.findElement(By.xpath(SearchJobsXpathLocators.xpathlocators.get("HEADERTEXT_XPATH"))).getText(),
				SearchJobsXpathLocators.datalocators.get("HEADERTEXT_TEXT"));

		waiter.until(ExpectedConditions.elementToBeClickable(By.xpath(SearchJobsXpathLocators.xpathlocators.get("KEYWORD_XPATH"))));
		context.driver.findElement(By.xpath(SearchJobsXpathLocators.xpathlocators.get("KEYWORD_XPATH"))).clear();

		waiter.until(ExpectedConditions.elementToBeClickable(By.xpath(SearchJobsXpathLocators.xpathlocators.get("FINDWORKNOWLINK_XPATH"))));
		context.driver.findElement(By.xpath(SearchJobsXpathLocators.xpathlocators.get("FINDWORKNOWLINK_XPATH"))).click();

		waiter.until(ExpectedConditions.presenceOfElementLocated(By.xpath(SearchJobsXpathLocators.xpathlocators.get("connectwith_XPATH"))));
		assertEquals(context.driver.findElement(By.xpath(SearchJobsXpathLocators.xpathlocators.get("connectwith_XPATH"))).getText(),
				SearchJobsXpathLocators.datalocators.get("connectwithText_TEXT"));
		context.driver.navigate().back();

		for (int i = 1; i <= 30; i++) {
			waiter.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='sidebar-trades-list']/ul/li[" + i + "]/a")));
			context.driver.findElement(By.xpath(".//*[@id='sidebar-trades-list']/ul/li[" + i + "]/a")).click();

		}

	}

}
