package uk.co.ratedpeople.test.functional.selenium.local;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import uk.co.ratedpeople.test.functional.selenium.TestScript;

/**
 * @author shabana.khanam
 * 
 */
public class LocalPagesJobDetailsTest extends TestScript {

	private SearchPredictive underTest;

	@BeforeClass(alwaysRun = true)
	public void beforeClass() throws Exception {
		underTest = new SearchPredictive(context.driver, context.getTestUrl(), scriptUtilities);
	}

	@BeforeMethod(alwaysRun = true)
	public void initTest() throws InterruptedException {
		scriptUtilities.getLocalPage(underTest.getTestUrl());
	}

	// in its own class as it must be run on its own; if other tests are added it fails for some reason
	@Test(groups = { "regression" }, enabled = true)
	public void navigateJobDetailsTest() throws Exception {
		underTest.searchText(LocalXpathLocators.xpathLookup.get("SEARCHBOX"), LocalXpathLocators.dataLookup.get("SEARCHTEXT"),
				LocalXpathLocators.xpathLookup.get("SEARCHBUTN"));
		underTest.findJob(LocalXpathLocators.dataLookup.get(""), LocalXpathLocators.dataLookup.get(""));
	}
}
