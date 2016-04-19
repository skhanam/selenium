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
public class LocalPagesNegativeTest extends TestScript {

	private SearchPredictive underTest;
	public static Logger logger = Logger.getLogger(LocalPagesNegativeTest.class.getName());

	@BeforeClass(alwaysRun = true)
	public void beforeClass() throws Exception {
		underTest = new SearchPredictive(context.driver, context.getTestUrl(), scriptUtilities);
	}

	@BeforeMethod(alwaysRun = true)
	public void initTest() throws InterruptedException {
		scriptUtilities.getLocalPage(underTest.getTestUrl());
	}

	/*
	 * Turn this to false as php needs to do some fixes
	 */
	@Test(groups = { "sanity" }, enabled = true)
	public void invalidPredictiveSearchTest() throws Exception {
		underTest.searchText(LocalXpathLocators.xpathLookup.get("SEARCHBOX"), LocalXpathLocators.dataLookup.get("SEARCHRANDOMTEXT"),
				LocalXpathLocators.xpathLookup.get("SEARCHBUTN"));
		//underTest.getErrorMsgPredictive();
		// assertEquals(,LocalXpathLocators.assertLookup.get("SEARCHRESULTS"));
	}

	@Test(groups = { "sanity" }, enabled = true)
	public void noQuestionTest() throws Exception {
		underTest.validateAskanExpertExists(LocalXpathLocators.xpathLookup.get("EXPERTQUESTION"), null, LocalXpathLocators.assertLookup.get("LOCALPAGE"));
		String getText = scriptUtilities.getValue(LocalXpathLocators.xpathLookup.get("ASKERROR"));
		logger.info("Here is the text  :" + getText);
		assertEquals(getText, LocalXpathLocators.assertLookup.get("ASKERRORMSG"));
	}
}
