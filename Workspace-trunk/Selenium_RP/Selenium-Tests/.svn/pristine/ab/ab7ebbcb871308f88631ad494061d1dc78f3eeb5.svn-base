package uk.co.ratedpeople.test.functional.selenium.local;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import uk.co.ratedpeople.test.functional.selenium.TestScript;

/**
 * @author shabana.khanam
 * 
 */
public class JobDetailsPagesTest extends TestScript {

	private JobDetailsPage underTest;

	@BeforeClass(alwaysRun = true)
	public void beforeClass() throws Exception {
		underTest = new JobDetailsPage(context.driver, context.getTestUrl(), scriptUtilities);
	}

	@BeforeMethod(alwaysRun = true)
	public void initTest() throws InterruptedException {
		scriptUtilities.getJobDetailsPage(underTest.getTestUrl());
	}

	@Test(groups = { "regression" }, enabled = true)
	public void checkAllTabsArePresent() throws Exception {
		// on tokyo this job was not bouyght by a TM
		if (underTest.getTestUrl().indexOf("tokyo") != -1) {
			underTest.checkAllTabs(
					LocalXpathLocators.xpathLookup.get("PHOTOS"),
					LocalXpathLocators.xpathLookup.get("DESCRIPTION"),
					null,
					null,
					".//*[@id='jobDetailTabs']/li[3]/a"); // third li is stats
		} else {
			underTest.checkAllTabs(
					LocalXpathLocators.xpathLookup.get("PHOTOS"),
					LocalXpathLocators.xpathLookup.get("DESCRIPTION"),
					LocalXpathLocators.xpathLookup.get("TRADESMAN"),
					LocalXpathLocators.xpathLookup.get("FEEDBACK"),
					LocalXpathLocators.xpathLookup.get("STATS"));
		}
	}

	@Test(groups = { "regression" }, enabled = true)
	public void carouselTest() throws Exception {
		underTest.carousel(LocalXpathLocators.xpathLookup.get("CAROUSEL"));
	}
}
