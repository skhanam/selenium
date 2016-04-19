package uk.co.ratedpeople.test.functional.selenium.local;

import static org.testng.Assert.assertEquals;

import java.util.logging.Logger;

import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;

/**
 * @author shabana.khanam
 * 
 */
public class JobDetailsPage {

	public static Logger logger = Logger.getLogger("uk.co.ratedpeople.test.functional.selenium.JobDetailsPage");
	private WebDriver driver;
	private String testUrl;
	private TestScriptUtilities scriptUtils;

	public JobDetailsPage(WebDriver driver, String testUrl, TestScriptUtilities scriptUtils) {
		this.driver = driver;
		this.testUrl = testUrl;
		this.scriptUtils = scriptUtils;
	}

	public void checkAllTabs(String photo, String desc, String tradesmen, String feedback, String stats) throws InterruptedException {
		if (StringUtils.isNotBlank(photo)) {
			scriptUtils.clickXpath(photo);
			String getheaderText = driver.findElement(By.xpath(photo)).getText();
			logger.info("Header Value  : " + getheaderText);
			assertEquals(getheaderText, LocalXpathLocators.assertLookup.get("PHOTOS"));
		}
		Thread.sleep(3000);
		if (StringUtils.isNotBlank(desc)) {
			scriptUtils.clickXpath(desc);
			String getheaderText = driver.findElement(By.xpath(desc)).getText();
			logger.info("Header Value  : " + getheaderText);
			assertEquals(getheaderText, LocalXpathLocators.assertLookup.get("DESCRIP"));
		}
		Thread.sleep(3000);
		if (StringUtils.isNotBlank(tradesmen)) {
			scriptUtils.clickXpath(tradesmen);
			String getheaderText = driver.findElement(By.xpath(tradesmen)).getText();
			logger.info("Header Value  : " + getheaderText);
			assertEquals(getheaderText, LocalXpathLocators.assertLookup.get("TRADESMN"));
		}
		Thread.sleep(3000);
		if (StringUtils.isNotBlank(feedback)) {
			scriptUtils.clickXpath(feedback);
			String getheaderText = driver.findElement(By.xpath(feedback)).getText();
			logger.info("Header Value  : " + getheaderText);
			assertEquals(getheaderText, LocalXpathLocators.assertLookup.get("FBACK"));
		}
		Thread.sleep(3000);
		if (StringUtils.isNotBlank(stats)) {
			scriptUtils.clickXpath(stats);
			String getheaderText = driver.findElement(By.xpath(stats)).getText();
			logger.info("Header Value  : " + getheaderText);
			assertEquals(getheaderText, LocalXpathLocators.assertLookup.get("STATUSHEADER"));
		}

	}

	public void carousel(String carousalxpath) throws Exception {
		if (StringUtils.isNotBlank(carousalxpath)) {
			for (int i = 0; i <= 6; i++) {
				scriptUtils.clickXpath(carousalxpath);
				Thread.sleep(1000);
			}
		}
	}

	public String getTestUrl() {
		return testUrl;
	}

	public void setTestUrl(String testUrl) {
		this.testUrl = testUrl;
	}

}
