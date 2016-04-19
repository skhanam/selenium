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

/**
 * @author shabana.khanam
 * 
 */
public class PostingJobViaGardenSomethingElseNegativeTests extends TestScript {

	private PostingJobviaGardenJobForms underTest;

	@BeforeClass(alwaysRun = true)
	public void beforeClass() throws Exception {
		underTest = new PostingJobviaGardenJobForms(context.driver, context.getTestUrl(), scriptUtilities);
	}

	@BeforeMethod(alwaysRun = true)
	public void initTest() throws InterruptedException {
		underTest.getQuotes();
	}

	@Test(groups = { "regression" }, enabled = true)
	public void testSomethingElseAdditionalInfoValidation() throws Exception {
		underTest.fillInPage1ForJobDetailsForSomethingElse(GardenXpathLocators.xpathLookup.get("SOMETHING_ELSE_RADIO_BTN"), null);
		underTest.fillInPage2ForAdditionalInfo(null, null, null, null, 0, null);
		assertEquals(context.driver.findElement(By.xpath(GardenXpathLocators.xpathLookup.get("LENGTHGARDEN"))).getText(),
				GardenXpathLocators.assertLookup.get("LENGTHGARDENMSG"));
		assertEquals(context.driver.findElement(By.xpath(GardenXpathLocators.xpathLookup.get("STATUSXPATH"))).getText(),
				GardenXpathLocators.assertLookup.get("STATUSMSG"));
		assertEquals(context.driver.findElement(By.xpath(GardenXpathLocators.xpathLookup.get("OWNERXPATH"))).getText(),
				GardenXpathLocators.assertLookup.get("OWNERMSG"));
		assertEquals(context.driver.findElement(By.xpath(GardenXpathLocators.xpathLookup.get("TIMINGXPATH"))).getText(),
				GardenXpathLocators.assertLookup.get("TIMINGMSG"));
		assertEquals(context.driver.findElement(By.xpath(GardenXpathLocators.xpathLookup.get("POSTCODEXPATH"))).getText(),
				GardenXpathLocators.assertLookup.get("POSTCODEMSG"));
		assertEquals(context.driver.findElement(By.xpath(GardenXpathLocators.xpathLookup.get("DESCRIPTIONXPATH"))).getText(),
				GardenXpathLocators.assertLookup.get("DESCRIPTIONMSG"));

	}

	@Test(groups = { "sanity" }, enabled = true)
	public void testSomethingElseBudgetValidation() throws Exception {
		underTest.fillInPage1ForJobDetailsForSomethingElse(GardenXpathLocators.xpathLookup.get("SOMETHING_ELSE_RADIO_BTN"),
				GardenXpathLocators.xpathLookup.get("SOMETHING_ELSE_LENGTH"));
		underTest.fillInPage2ForAdditionalInfo(GardenXpathLocators.xpathLookup.get("IM_READY_TO_HIRE_RADIO_BTN"),
				GardenXpathLocators.xpathLookup.get("OWNER_OWN_AND_LIVE_RADIO_BTN"), GardenXpathLocators.xpathLookup.get("URGENTLY"),
				GardenXpathLocators.dataLookup.get("POSTCODE"), 30, TestScriptUtilities.getRandomString(30));
		underTest.fillInPage3ForBudget(null);
		assertEquals(context.driver.findElement(By.xpath(GardenXpathLocators.xpathLookup.get("BUDGETXPATH"))).getText(),
				GardenXpathLocators.assertLookup.get("BUDGETMSG"));

	}

	@Test(groups = { "regression" }, enabled = true)
	public void testSomethingElseContactValidation() throws Exception {
		underTest.fillInPage1ForJobDetailsForSomethingElse(GardenXpathLocators.xpathLookup.get("SOMETHING_ELSE_RADIO_BTN"),
				GardenXpathLocators.xpathLookup.get("SOMETHING_ELSE_LENGTH"));
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
