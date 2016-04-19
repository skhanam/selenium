package uk.co.ratedpeople.test.functional.selenium.local;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

import uk.co.ratedpeople.test.functional.selenium.TestScript;
import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;

/**
 * @author shabana.khanam
 * 
 */
public class LocalPagesTest extends TestScript {

	private SearchPredictive underTest;

	@BeforeClass(alwaysRun = true)
	public void beforeClass() throws Exception {
		underTest = new SearchPredictive(context.driver, context.getTestUrl(), scriptUtilities);
	}

	@BeforeMethod(alwaysRun = true)
	public void initTest() throws InterruptedException {
		scriptUtilities.getLocalPage(underTest.getTestUrl());
	}

	@Test(groups = { "sanity" }, enabled = true)
	public void predictiveSearchTest() throws Exception {
		underTest.searchText(LocalXpathLocators.xpathLookup.get("SEARCHBOX"), LocalXpathLocators.dataLookup.get("SEARCHTEXT"),
				LocalXpathLocators.xpathLookup.get("SEARCHBUTN"));
		String getTitle = context.driver.getTitle();
		assertEquals(getTitle, LocalXpathLocators.assertLookup.get("SEARCHRESULTS"));
	}

	@Test(groups = { "sanity" }, enabled = true)
	public void askanExpertTest() throws Exception {
		underTest.validateAskanExpertExists(LocalXpathLocators.xpathLookup.get("EXPERTQUESTION"), TestScriptUtilities.getRandomString(5),
				LocalXpathLocators.assertLookup.get("ASKANEXPERTMSG"));
	}

	@Test(groups = { "regression" }, enabled = true)
	public void socialMediaTwitterTest() throws Exception {
		underTest.validateSocialMedia(LocalXpathLocators.xpathLookup.get("TWITTER"), LocalXpathLocators.assertLookup.get("TWITMSG"));
	}

	@Test(enabled = false)
	public void socialMediafacebookTest() throws Exception {
		underTest.validateSocialMedia(LocalXpathLocators.xpathLookup.get("FACEBOOK"), LocalXpathLocators.assertLookup.get("FBMSG"));
	}

	@Test(groups = { "regression" }, enabled = true)
	public void socialMediaLinkedinTest() throws Exception {
		underTest.validateSocialMedia(LocalXpathLocators.xpathLookup.get("LINKEDIN"), LocalXpathLocators.assertLookup.get("LMSG"));
	}

	@Test(groups = { "sanity" }, enabled = true)
	public void socialMediaGPlusTest() throws Exception {
		underTest.validateSocialMedia(LocalXpathLocators.xpathLookup.get("GPLUS"), LocalXpathLocators.assertLookup.get("GMSG"));
	}

	@Test(groups = { "regression" }, enabled = true)
	public void socialMediaYTubeTest() throws Exception {
		underTest.validateSocialMedia(LocalXpathLocators.xpathLookup.get("YTUBE"), LocalXpathLocators.assertLookup.get("YMSG"));
	}

	@Test(groups = { "regression" }, enabled = true)
	public void socialMediaPinterestTest() throws Exception {
		underTest.validateSocialMedia(LocalXpathLocators.xpathLookup.get("PINTST"), LocalXpathLocators.assertLookup.get("PMSG"));
	}
}
