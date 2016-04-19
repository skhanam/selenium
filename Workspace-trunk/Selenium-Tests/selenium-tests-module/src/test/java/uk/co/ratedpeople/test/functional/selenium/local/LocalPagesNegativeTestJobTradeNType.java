package uk.co.ratedpeople.test.functional.selenium.local;

import java.util.logging.Logger;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

import uk.co.ratedpeople.test.functional.selenium.TestScript;

/**
 * @author shabana.khanam
 * 
 */
public class LocalPagesNegativeTestJobTradeNType extends TestScript {

	private SearchPredictive underTest;
	public static Logger logger = Logger.getLogger(LocalPagesNegativeTestJobTradeNType.class.getName());

	@BeforeClass(alwaysRun = true)
	public void beforeClass() throws Exception {
		underTest = new SearchPredictive(context.driver, context.getTestUrl(), scriptUtilities);
	}

	@BeforeMethod(alwaysRun = true)
	public void initTest() throws InterruptedException {
		scriptUtilities.getLocalPage(underTest.getTestUrl());
	}

	// this test only works when run on its own; if not selenium for some unknown reason never goes beyond the first page
	@Test(groups = { "sanity" }, enabled = false)
	public void validationJobTradeNTypeTest() throws Exception {
		underTest.searchText(LocalXpathLocators.xpathLookup.get("SEARCHBOX"), LocalXpathLocators.dataLookup.get("SEARCHTEXT"),
				LocalXpathLocators.xpathLookup.get("SEARCHBUTN"));
		underTest.findJob(null, null);
		assertEquals(scriptUtilities.getValue(LocalXpathLocators.xpathLookup.get("JOBTRADELABEL")), LocalXpathLocators.assertLookup.get("TRADEMSG"));
		assertEquals(scriptUtilities.getValue(LocalXpathLocators.xpathLookup.get("JOBTYPELABEL")), LocalXpathLocators.assertLookup.get("JOBTYPEMSG"));
	}
}
