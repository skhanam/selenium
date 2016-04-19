package uk.co.ratedpeople.test.functional.selenium.local;

import static org.testng.Assert.assertEquals;

import java.util.logging.Logger;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import uk.co.ratedpeople.test.functional.selenium.TestScript;
import uk.co.ratedpeople.test.functional.selenium.newjobforms.bathroom.BathroomXpathlocators;
import uk.co.ratedpeople.test.functional.selenium.newjobforms.bathroom.PostingJobViaBathroomJobForms;
import uk.co.ratedpeople.test.functional.selenium.newjobforms.generic.PostingJobviaGenericJobForm;
import uk.co.ratedpeople.test.functional.selenium.newjobforms.internalrenovation.InternalRenovationXpathLocators;

/**
 * @author shabana.khanam
 */
public class SearchPageTest extends TestScript {

	private PostingJobviaGenericJobForm genericJobForm;
	private SearchPredictive predictiveSearch;
	private PostingJobViaBathroomJobForms jobsubmissionSkillSpecific;
	public static Logger logger = Logger.getLogger("uk.co.ratedpeople.test.functional.selenium.SearchPageTest");
	private static final String IPD_SKILL_TYPE_ID = "18";
	private static final String IPD_TRADE_CODE = "bathroom";
	private static final String GENERIC_SKILL_TYPE_ID = "69";
	private static final String GENERIC_TRADE_CODE = "network";

	@BeforeClass(alwaysRun = true)
	public void beforeClass() throws Exception {
		predictiveSearch = new SearchPredictive(context.driver, context.getTestUrl(), scriptUtilities);
		jobsubmissionSkillSpecific = new PostingJobViaBathroomJobForms(context, scriptUtilities);
		genericJobForm = new PostingJobviaGenericJobForm(context, scriptUtilities);
	}

	@BeforeMethod(alwaysRun = true)
	public void initTest() throws InterruptedException {
		scriptUtilities.getLocalPage(predictiveSearch.getTestUrl());
	}

	/*
	 * Test for job submission Skillspecific
	 */
	@Test(groups = { "sanity" }, enabled = true)
	public void postAJobSkillSpecificTest() throws Exception {
		predictiveSearch.searchText(LocalXpathLocators.xpathLookup.get("SEARCHBOX"), LocalXpathLocators.dataLookup.get("SEARCHTEXT"),
				LocalXpathLocators.xpathLookup.get("SEARCHBUTN"));
		Thread.sleep(3000);
		predictiveSearch.findJob(IPD_TRADE_CODE, IPD_SKILL_TYPE_ID);
		// underTest.findJob(IPD_TRADE_CODE, IPD_SKILL_TYPE_ID);
		String getTitle = context.driver.getTitle();
		logger.info("Title is  : " + getTitle);
		assertEquals(getTitle, LocalXpathLocators.assertLookup.get("JOBFORM"));
		logger.info("Get the current url :" + context.driver.getCurrentUrl());
		jobsubmissionSkillSpecific.jobDetailsPage("radioElse");

		jobsubmissionSkillSpecific.additionalInfoPage(31, BathroomXpathlocators.dataLookup.get("postcode"));
		jobsubmissionSkillSpecific.thirdPage("Under £500");
		jobsubmissionSkillSpecific.fourthPage();

	}

	@Test(groups = { "sanity" }, enabled = true)
	public void postAJobGeneralTest() throws Exception {
		predictiveSearch.searchText(LocalXpathLocators.xpathLookup.get("SEARCHBOX"), LocalXpathLocators.dataLookup.get("SEARCHTEXT"),
				LocalXpathLocators.xpathLookup.get("SEARCHBUTN"));
		predictiveSearch.findJob(GENERIC_TRADE_CODE, GENERIC_SKILL_TYPE_ID);
		String getTitle = context.driver.getTitle();
		logger.info("Title is  : " + getTitle);
		assertEquals(getTitle, LocalXpathLocators.assertLookup.get("JOBFORM"));
		logger.info("Get the current url :" + context.driver.getCurrentUrl());
		genericJobForm.jobDetailsGeneric();
		genericJobForm.additionalInfo(30, InternalRenovationXpathLocators.dataLookup.get("postcode"));
		genericJobForm.budget(10);
		genericJobForm.location();

	}

	@Test(groups = { "sanity", "regression" }, enabled = true)
	public void advanceSearchTest() throws Exception {
		predictiveSearch.searchText(LocalXpathLocators.xpathLookup.get("SEARCHBOX"), LocalXpathLocators.dataLookup.get("SEARCHTEXTFULL"),
				LocalXpathLocators.xpathLookup.get("SEARCHBUTN"));
		Thread.sleep(3000);
		predictiveSearch.filterAdvanced(LocalXpathLocators.xpathLookup.get("ADDEDANYTIME"), LocalXpathLocators.xpathLookup.get("TRADE"),
				LocalXpathLocators.xpathLookup.get("JOBSTATUS"), LocalXpathLocators.xpathLookup.get("SLIDERSTART"),
				LocalXpathLocators.xpathLookup.get("SLIDEREND"));
	}

	@Test(groups = { "sanity" }, enabled = true)
	public void postCodeSearchTest() throws Exception {
		predictiveSearch.searchText(LocalXpathLocators.xpathLookup.get("SEARCHBOX"), LocalXpathLocators.dataLookup.get("SEARCHTEXT"),
				LocalXpathLocators.xpathLookup.get("SEARCHBUTN"));
		Thread.sleep(3000);
		predictiveSearch.searchPostcode(LocalXpathLocators.xpathLookup.get("LOCATION"), LocalXpathLocators.xpathLookup.get("CHANGEBTN"));
	}

}
