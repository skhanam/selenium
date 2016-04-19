/**
 * 
 */
package uk.co.ratedpeople.test.functional.selenium.newjobforms.garden;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import uk.co.ratedpeople.test.functional.selenium.TestScript;
import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;
import uk.co.ratedpeople.test.functional.selenium.newjobforms.common.JobFormSeleniumHelper;
import uk.co.ratedpeople.test.functional.selenium.newjobforms.fences.FencesXpathLocators;

/**
 * @author shabana.khanam
 * 
 */
public class PostingJobViaGardenClearanceNegativeTests extends TestScript {

	private PostingJobviaGardenJobForms underTest;
	String[] workRequired = { GardenXpathLocators.xpathLookup.get("CLEARENCE_MOWING"), GardenXpathLocators.xpathLookup.get("CLEARENCE_SHED") };

	@BeforeClass(alwaysRun = true)
	public void beforeClass() throws Exception {
		underTest = new PostingJobviaGardenJobForms(context.driver, context.getTestUrl(), scriptUtilities);
	}

	@BeforeMethod(alwaysRun = true)
	public void initTest() throws InterruptedException {
		underTest.getQuotes();
	}

	@Test(groups = { "sanity" }, enabled = true)
	public void testClearanceJobDetailsValidation() throws Exception {

		underTest.fillInPage1ForJobDetailsForGardenMaintenance(GardenXpathLocators.xpathLookup.get("CLARANCE_RADIO_BTN"), null, null, null, null);

		assertEquals(context.driver.findElement(By.xpath(GardenXpathLocators.xpathLookup.get("CLEARANCEXPATH"))).getText(),
				GardenXpathLocators.assertLookup.get("LANDSCAPINGMSG"));
		assertEquals(context.driver.findElement(By.xpath(GardenXpathLocators.xpathLookup.get("WASTEDXPATH"))).getText(),
				GardenXpathLocators.assertLookup.get("WASTEMSG"));
		assertEquals(context.driver.findElement(By.xpath(GardenXpathLocators.xpathLookup.get("WORKDONEXPATH"))).getText(),
				GardenXpathLocators.assertLookup.get("MAINTENANCEMSG"));
		assertEquals(context.driver.findElement(By.xpath(GardenXpathLocators.xpathLookup.get("LENGTHCLEARANCEXPATH"))).getText(),
				GardenXpathLocators.assertLookup.get("APPROXLENGTHMSG"));

	}

	@Test(groups = { "regression" }, enabled = true)
	public void testClearanceAdditionalInfoValidation() throws Exception {

		underTest.fillInPage1ForJobDetailsForGardenMaintenance(GardenXpathLocators.xpathLookup.get("CLARANCE_RADIO_BTN"), workRequired,
				GardenXpathLocators.xpathLookup.get("CLEARENCE_WASTE_YES"), GardenXpathLocators.xpathLookup.get("CLEARENCE_MAINTANANCE_YES"),
				GardenXpathLocators.xpathLookup.get("CLEARANCE_LENGTH"));
		underTest.fillInPage2ForAdditionalInfo(null, null, null, null, 0, null);

		assertEquals(context.driver.findElement(By.xpath(FencesXpathLocators.xpathLookup.get("STATUSXPATH"))).getText(),
				FencesXpathLocators.assertLookup.get("STATUSMSG"));
		assertEquals(context.driver.findElement(By.xpath(FencesXpathLocators.xpathLookup.get("OWNERSHIPPATH"))).getText(),
				FencesXpathLocators.assertLookup.get("OWNERMSG"));
		assertEquals(context.driver.findElement(By.xpath(FencesXpathLocators.xpathLookup.get("TIMINGXPATH"))).getText(),
				FencesXpathLocators.assertLookup.get("TIMINGMSG"));
		assertEquals(context.driver.findElement(By.xpath(FencesXpathLocators.xpathLookup.get("POSTCODEXPATH"))).getText(),
				FencesXpathLocators.assertLookup.get("POSTCODEMSG"));
		assertEquals(context.driver.findElement(By.xpath(FencesXpathLocators.xpathLookup.get("DETAILSXPATH"))).getText(),
				FencesXpathLocators.assertLookup.get("DETAILSMSG"));
	}

	@Test(groups = { "regression" }, enabled = true)
	public void testClearanceBudgetValidation() throws Exception {

		underTest.fillInPage1ForJobDetailsForGardenMaintenance(GardenXpathLocators.xpathLookup.get("CLARANCE_RADIO_BTN"), workRequired,
				GardenXpathLocators.xpathLookup.get("CLEARENCE_WASTE_YES"), GardenXpathLocators.xpathLookup.get("CLEARENCE_MAINTANANCE_YES"),
				GardenXpathLocators.xpathLookup.get("CLEARANCE_LENGTH"));

		underTest.fillInPage2ForAdditionalInfo(GardenXpathLocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"),
				GardenXpathLocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"), GardenXpathLocators.xpathLookup.get("URGENTLY"),
				GardenXpathLocators.dataLookup.get("POSTCODE"), 30, TestScriptUtilities.getRandomString(30));

		underTest.fillInPage3ForBudget(null);

		assertEquals(context.driver.findElement(By.xpath(GardenXpathLocators.xpathLookup.get("BUDGETXPATHNEW"))).getText(),
				GardenXpathLocators.assertLookup.get("BUDGETMSG"));

	}

	@Test(groups = { "sanity" }, enabled = true)
	public void testMaintenanceContactValidation() throws Exception {

		underTest.fillInPage1ForJobDetailsForGardenMaintenance(GardenXpathLocators.xpathLookup.get("CLARANCE_RADIO_BTN"), workRequired,
				GardenXpathLocators.xpathLookup.get("CLEARENCE_WASTE_YES"), GardenXpathLocators.xpathLookup.get("CLEARENCE_MAINTANANCE_YES"),
				GardenXpathLocators.xpathLookup.get("CLEARANCE_LENGTH"));

		underTest.fillInPage2ForAdditionalInfo(GardenXpathLocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"),
				GardenXpathLocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"), GardenXpathLocators.xpathLookup.get("URGENTLY"),
				GardenXpathLocators.dataLookup.get("POSTCODE"), 30, TestScriptUtilities.getRandomString(30));

		underTest.fillInPage3ForBudget(GardenXpathLocators.dataLookup.get("BUDGET_LT_500"));

		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, null, null, null, null, null, null);
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[1]/label[2]")).getText(), "Please enter your first name");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[2]/label[2]")).getText(), "Please enter your last name");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[3]/div/label")).getText(), "Please enter your phone number");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[4]/label[2]")).getText(), "Please confirm your phone number");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[5]/div/label")).getText(), "Please enter your email address");
		assertEquals(context.driver.findElement(By.xpath(".//*[@id='contact']/div[6]/label[2]")).getText(), "Please confirm your email address");

	}

}
