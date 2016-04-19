/**
 * 
 */
package uk.co.ratedpeople.test.functional.selenium.newjobforms.newbuilds;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import uk.co.ratedpeople.test.functional.selenium.TestScript;
import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;
import uk.co.ratedpeople.test.functional.selenium.newjobforms.common.JobFormSeleniumHelper;

/**
 * @author shabana.khanam
 * 
 */
public class PostingJobViaNewBuildNegativeTests extends TestScript {

	private PostingJobViaNewBuildJobForms underTest;

	@BeforeClass(alwaysRun = true)
	public void beforeClass() throws Exception {
		underTest = new PostingJobViaNewBuildJobForms(context.driver, context.getTestUrl(), scriptUtilities);
	}

	@BeforeMethod(alwaysRun = true)
	public void initTest() throws InterruptedException {
		scriptUtilities.getQuotes(underTest.getTestUrl(), context.driver, "9", "builder");
	}

	@Test(groups={"regression"},enabled = true)
	public void jobDetailsNewBuildExtensionNegativeTest() throws Exception {
		underTest.fillInStage1(BuildXpathLocators.xpathLookup.get("EXTENSION"));
		underTest.fillInExtensionStage2(null, null, null, null, null, null, null, null);
		assertEquals(context.driver.findElement(By.xpath(BuildXpathLocators.xpathLookup.get("ROOMS_EXTENSION"))).getText(),
				BuildXpathLocators.assertLookup.get("ROOMS_EXTENSION_MSG"));
		assertEquals(context.driver.findElement(By.xpath(BuildXpathLocators.xpathLookup.get("ROOMS_EXTENSION_OPTIONS"))).getText(),
				BuildXpathLocators.assertLookup.get("ROOMS_EXTENSION_OPTIONS_MSG"));
		assertEquals(context.driver.findElement(By.xpath(BuildXpathLocators.xpathLookup.get("FLOOR_EXTENSION"))).getText(),
				BuildXpathLocators.assertLookup.get("FLOOR_EXTENSION_MSG"));
		assertEquals(context.driver.findElement(By.xpath(BuildXpathLocators.xpathLookup.get("ARCHITECTURAL_PLANS"))).getText(),
				BuildXpathLocators.assertLookup.get("ARCHITECTURAL_PLANS_MSG"));
		assertEquals(context.driver.findElement(By.xpath(BuildXpathLocators.xpathLookup.get("PERMISSION"))).getText(),
				BuildXpathLocators.assertLookup.get("PERMISSION_MSG"));
		assertEquals(context.driver.findElement(By.xpath(BuildXpathLocators.xpathLookup.get("REGULATIONS"))).getText(),
				BuildXpathLocators.assertLookup.get("REGULATIONS_MSG"));
		assertEquals(context.driver.findElement(By.xpath(BuildXpathLocators.xpathLookup.get("LISTED_BUILDING"))).getText(),
				BuildXpathLocators.assertLookup.get("LISTED_BUILDING_MSG"));

	}

	@Test(groups={"regression"},enabled = true)
	public void jobDetailsNewBuildLoftConversionNegativeTest() throws Exception {
		underTest.fillInStage1(BuildXpathLocators.xpathLookup.get("LOFT_CONVERSION"));
		underTest.fillInLoftConversionStage2(null, null, null, null, null, null, null, null);
		assertEquals(context.driver.findElement(By.xpath(BuildXpathLocators.xpathLookup.get("TYPE_CONVERSION"))).getText(),
				BuildXpathLocators.assertLookup.get("TYPE_CONVERSION_MSG"));
		assertEquals(context.driver.findElement(By.xpath(BuildXpathLocators.xpathLookup.get("ROOM_CONVERSION"))).getText(),
				BuildXpathLocators.assertLookup.get("ROOM_CONVERSION_MSG"));
		assertEquals(context.driver.findElement(By.xpath(BuildXpathLocators.xpathLookup.get("ARCHITECTURAL_CONVERSION"))).getText(),
				BuildXpathLocators.assertLookup.get("ARCHITECTURAL_PLANS_MSG"));
		assertEquals(context.driver.findElement(By.xpath(BuildXpathLocators.xpathLookup.get("PLAN_PERM_CONVERSION"))).getText(),
				BuildXpathLocators.assertLookup.get("PERMISSION_MSG"));
		assertEquals(context.driver.findElement(By.xpath(BuildXpathLocators.xpathLookup.get("REGULATION_CONVERSION"))).getText(),
				BuildXpathLocators.assertLookup.get("REGULATIONS_MSG"));
		assertEquals(context.driver.findElement(By.xpath(BuildXpathLocators.xpathLookup.get("LIST_BUILD_CONVERSION"))).getText(),
				BuildXpathLocators.assertLookup.get("LISTED_BUILDING_MSG"));

	}

	@Test(groups={"regression"},enabled = true)
	public void jobDetailsNewBuildGarageConversionNegativeTest() throws Exception {
		underTest.fillInStage1(BuildXpathLocators.xpathLookup.get("GARAGE_CONVERSION"));
		underTest.fillInGarageConversionStage2(null, null, null, null, null);
		assertEquals(context.driver.findElement(By.xpath(BuildXpathLocators.xpathLookup.get("ROOM_GARAGE"))).getText(),
				BuildXpathLocators.assertLookup.get("ROOM_CONVERSION_MSG"));
		assertEquals(context.driver.findElement(By.xpath(BuildXpathLocators.xpathLookup.get("ARCHITECTURAL_GARAGE"))).getText(),
				BuildXpathLocators.assertLookup.get("ARCHITECTURAL_PLANS_MSG"));
		assertEquals(context.driver.findElement(By.xpath(BuildXpathLocators.xpathLookup.get("PLAN_PERM_GARAGE"))).getText(),
				BuildXpathLocators.assertLookup.get("PERMISSION_MSG"));
		assertEquals(context.driver.findElement(By.xpath(BuildXpathLocators.xpathLookup.get("REGULATION_GARAGE"))).getText(),
				BuildXpathLocators.assertLookup.get("REGULATIONS_MSG"));

	}

	@Test(groups={"sanity"},enabled = true)
	public void additionalInfoNewBuildGarageConstructionNegativeTest() throws Exception {
		underTest.fillInStage1(BuildXpathLocators.xpathLookup.get("GARAGE_CONSTRUCTION"));
		underTest.fillInStage3(null, null, null, null, null, null);
		underTest.fillInPlanningAndBuilding(null, null, null, null, null, null);
		assertEquals(context.driver.findElement(By.xpath(BuildXpathLocators.xpathLookup.get("ARCHICHECTURAL_CONSTRUCTION"))).getText(),
				BuildXpathLocators.assertLookup.get("ARCHITECTURAL_PLANS_MSG"));
		assertEquals(context.driver.findElement(By.xpath(BuildXpathLocators.xpathLookup.get("PLAN_PERM_CONSTRUCTION"))).getText(),
				BuildXpathLocators.assertLookup.get("PERMISSION_MSG"));
		assertEquals(context.driver.findElement(By.xpath(BuildXpathLocators.xpathLookup.get("REGULATION_CONSTRUCTION"))).getText(),
				BuildXpathLocators.assertLookup.get("REGULATIONS_MSG"));
		assertEquals(context.driver.findElement(By.xpath(BuildXpathLocators.xpathLookup.get("STATUS"))).getText(),
				BuildXpathLocators.assertLookup.get("STATUS_MSG"));
		assertEquals(context.driver.findElement(By.xpath(BuildXpathLocators.xpathLookup.get("OWNERSHIP"))).getText(),
				BuildXpathLocators.assertLookup.get("OWNERSHIP_MSG"));
		assertEquals(context.driver.findElement(By.xpath(BuildXpathLocators.xpathLookup.get("TIMING"))).getText(),
				BuildXpathLocators.assertLookup.get("TIMING_MSG"));
		assertEquals(context.driver.findElement(By.xpath(BuildXpathLocators.xpathLookup.get("POSTCODE"))).getText(),
				BuildXpathLocators.assertLookup.get("POSTCODE_MSG"));
		assertEquals(context.driver.findElement(By.xpath(BuildXpathLocators.xpathLookup.get("ADDITIONAL_DETAILS"))).getText(),
				BuildXpathLocators.assertLookup.get("ADDITIONAL_DETAILS_MSG"));
	}

	@Test(groups={"regression"},enabled = true)
	public void additionalInfoNewBuildOutbuildingConstructionNegativeTest() throws Exception {
		underTest.fillInStage1(BuildXpathLocators.xpathLookup.get("OUTBUILDING_CONSTRUCTION"));
		underTest.fillInStage3(null, null, null, null, null, null);
		underTest.fillInPlanningAndBuilding(null, null, null, null, null, null);
		assertEquals(context.driver.findElement(By.xpath(BuildXpathLocators.xpathLookup.get("ARCHICHECTURAL_CONSTRUCTION"))).getText(),
				BuildXpathLocators.assertLookup.get("ARCHITECTURAL_PLANS_MSG"));
		assertEquals(context.driver.findElement(By.xpath(BuildXpathLocators.xpathLookup.get("PLAN_PERM_CONSTRUCTION"))).getText(),
				BuildXpathLocators.assertLookup.get("PERMISSION_MSG"));
		assertEquals(context.driver.findElement(By.xpath(BuildXpathLocators.xpathLookup.get("REGULATION_CONSTRUCTION"))).getText(),
				BuildXpathLocators.assertLookup.get("REGULATIONS_MSG"));
		assertEquals(context.driver.findElement(By.xpath(BuildXpathLocators.xpathLookup.get("STATUS"))).getText(),
				BuildXpathLocators.assertLookup.get("STATUS_MSG"));
		assertEquals(context.driver.findElement(By.xpath(BuildXpathLocators.xpathLookup.get("OWNERSHIP"))).getText(),
				BuildXpathLocators.assertLookup.get("OWNERSHIP_MSG"));
		assertEquals(context.driver.findElement(By.xpath(BuildXpathLocators.xpathLookup.get("TIMING"))).getText(),
				BuildXpathLocators.assertLookup.get("TIMING_MSG"));
		assertEquals(context.driver.findElement(By.xpath(BuildXpathLocators.xpathLookup.get("POSTCODE"))).getText(),
				BuildXpathLocators.assertLookup.get("POSTCODE_MSG"));
		assertEquals(context.driver.findElement(By.xpath(BuildXpathLocators.xpathLookup.get("ADDITIONAL_DETAILS"))).getText(),
				BuildXpathLocators.assertLookup.get("ADDITIONAL_DETAILS_MSG"));

	}

	@Test(groups={"regression"},enabled = true)
	public void additionalInfoNewBuildSomethingElseNegativeTest() throws Exception {
		underTest.fillInStage1(BuildXpathLocators.xpathLookup.get("SOMETHING_ELSE"));
		underTest.fillInStage3(null, null, null, null, null, null);
		assertEquals(context.driver.findElement(By.xpath(BuildXpathLocators.xpathLookup.get("STATUS"))).getText(),
				BuildXpathLocators.assertLookup.get("STATUS_MSG"));
		assertEquals(context.driver.findElement(By.xpath(BuildXpathLocators.xpathLookup.get("OWNERSHIP"))).getText(),
				BuildXpathLocators.assertLookup.get("OWNERSHIP_MSG"));
		assertEquals(context.driver.findElement(By.xpath(BuildXpathLocators.xpathLookup.get("TIMING"))).getText(),
				BuildXpathLocators.assertLookup.get("TIMING_MSG"));
		assertEquals(context.driver.findElement(By.xpath(BuildXpathLocators.xpathLookup.get("POSTCODE_SE"))).getText(),
				BuildXpathLocators.assertLookup.get("POSTCODE_MSG"));
		assertEquals(context.driver.findElement(By.xpath(BuildXpathLocators.xpathLookup.get("ADDITIONAL_DETAILS"))).getText(),
				BuildXpathLocators.assertLookup.get("ADDITIONAL_DETAILS_MSG"));

	}

	@Test(groups={"regression"},enabled = true)
	public void additionalInfoNegativeTests() throws Exception {
		underTest.fillInStage1(BuildXpathLocators.xpathLookup.get("EXTENSION"));
		String[] useOfExtenstionXPathList = { ".//*[@id='extensionRoomsBedrooms']", ".//*[@id='extensionRoomsDiningroom']" };

		underTest.fillInExtensionStage2("1076", useOfExtenstionXPathList, null, "973", "975", "978", "983", ".//*[@id='extensionListedUnknown']");
		underTest.fillInStage3(null, null, null, null, null, null);
		assertEquals(context.driver.findElement(By.xpath(BuildXpathLocators.xpathLookup.get("STATUS"))).getText(),
				BuildXpathLocators.assertLookup.get("STATUS_MSG"));
		assertEquals(context.driver.findElement(By.xpath(BuildXpathLocators.xpathLookup.get("OWNERSHIP"))).getText(),
				BuildXpathLocators.assertLookup.get("OWNERSHIP_MSG"));
		assertEquals(context.driver.findElement(By.xpath(BuildXpathLocators.xpathLookup.get("TIMING"))).getText(),
				BuildXpathLocators.assertLookup.get("TIMING_MSG"));
		assertEquals(context.driver.findElement(By.xpath(BuildXpathLocators.xpathLookup.get("PROPERTY_STYLE"))).getText(),
				BuildXpathLocators.assertLookup.get("PROPERTY_STYLE_MSG"));
		assertEquals(context.driver.findElement(By.xpath(BuildXpathLocators.xpathLookup.get("POSTCODE_EXT"))).getText(),
				BuildXpathLocators.assertLookup.get("POSTCODE_MSG"));
		assertEquals(context.driver.findElement(By.xpath(BuildXpathLocators.xpathLookup.get("ADDITIONAL_DETAILS"))).getText(),
				BuildXpathLocators.assertLookup.get("ADDITIONAL_DETAILS_MSG"));
	}

	@Test(groups={"regression"},enabled = true)
	public void bugetNegativeTests() throws Exception {
		underTest.fillInStage1(BuildXpathLocators.xpathLookup.get("EXTENSION"));
		String[] useOfExtenstionXPathList = { ".//*[@id='extensionRoomsBedrooms']", ".//*[@id='extensionRoomsDiningroom']" };

		underTest.fillInExtensionStage2("1076", useOfExtenstionXPathList, null, "973", "975", "978", "983", ".//*[@id='extensionListedUnknown']");
		underTest.fillInStage3(BuildXpathLocators.dataLookup.get("JOB_STATUS_ID"), BuildXpathLocators.dataLookup.get("OWNERSHIP_STATUS_ID"),
				BuildXpathLocators.dataLookup.get("TIMING"), "990", BuildXpathLocators.dataLookup.get("POSTCODE"), TestScriptUtilities.getRandomString(10));
		underTest.fillInStage4(null);
		assertEquals(context.driver.findElement(By.xpath(BuildXpathLocators.xpathLookup.get("BUDGET_XPATH"))).getText(),
				BuildXpathLocators.assertLookup.get("BUDGET_MSG"));

	}

	@Test(groups={"sanity"},enabled = true)
	public void contactNegativeTests() throws Exception {
		underTest.fillInStage1(BuildXpathLocators.xpathLookup.get("EXTENSION"));
		String[] useOfExtenstionXPathList = { ".//*[@id='extensionRoomsBedrooms']", ".//*[@id='extensionRoomsDiningroom']" };
		underTest.fillInExtensionStage2("1076", useOfExtenstionXPathList, null, "973", "975", "978", "983", ".//*[@id='extensionListedUnknown']");
		underTest.fillInStage3(BuildXpathLocators.dataLookup.get("JOB_STATUS_ID"), BuildXpathLocators.dataLookup.get("OWNERSHIP_STATUS_ID"),
				BuildXpathLocators.dataLookup.get("TIMING"), "990", BuildXpathLocators.dataLookup.get("POSTCODE"), TestScriptUtilities.getRandomString(10));
		underTest.fillInStage4(BuildXpathLocators.dataLookup.get("BUDGET_SOMETHINGELSE"));
		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, null, null, null, null, null, null);
		assertEquals(context.driver.findElement(By.xpath(BuildXpathLocators.xpathLookup.get("FIRSTNAME_ERRORMSG"))).getText(),
				BuildXpathLocators.assertLookup.get("FIRSTNAME_ERRORMSGTEXT"));
		assertEquals(context.driver.findElement(By.xpath(BuildXpathLocators.xpathLookup.get("LASTNAME_ERRORMSG"))).getText(),
				BuildXpathLocators.assertLookup.get("LASTNAME_ERRORMSGTEXT"));
		assertEquals(context.driver.findElement(By.xpath(BuildXpathLocators.xpathLookup.get("PHONENUMBER_ERRORMSG"))).getText(),
				BuildXpathLocators.assertLookup.get("PHONENUMBER_ERRORMSGTEXT"));
		assertEquals(context.driver.findElement(By.xpath(BuildXpathLocators.xpathLookup.get("EMAIL_ERRORMSG"))).getText(),
				BuildXpathLocators.assertLookup.get("EMAIL_ERRORMSGTEXT"));
		assertEquals(context.driver.findElement(By.xpath(BuildXpathLocators.xpathLookup.get("CONFIRMPHONENUMBER_ERRORMSG"))).getText(),
				BuildXpathLocators.assertLookup.get("CONFIRMPHONENUMBER_ERRORMSGTEXT"));	
		assertEquals(context.driver.findElement(By.xpath(BuildXpathLocators.xpathLookup.get("EMAIL_ERRORMSG"))).getText(),
				BuildXpathLocators.assertLookup.get("EMAIL_ERRORMSGTEXT"));
		
	}
}
