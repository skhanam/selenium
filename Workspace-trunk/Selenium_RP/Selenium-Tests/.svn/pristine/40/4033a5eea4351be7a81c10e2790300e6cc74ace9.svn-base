/**
 * 
 */
package uk.co.ratedpeople.test.functional.selenium.newjobforms.fences;

import static org.testng.Assert.assertEquals;

import java.util.logging.Logger;

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
public class PostingJobViaFencesSomethingElseNegativeTests extends TestScript {

	private PostingJobViaFencesJobForms underTest;
	public static Logger logger = Logger
			.getLogger("uk.co.ratedpeople.test.functional.selenium.newjobforms.fences.PostingJobViaFencesSomethingElseNegativeTests");

	@BeforeClass(alwaysRun = true)
	public void beforeClass() throws Exception {
		underTest = new PostingJobViaFencesJobForms(context.driver, context.getTestUrl(), scriptUtilities);
	}

	@BeforeMethod(alwaysRun = true)
	public void initTest() throws InterruptedException {
		underTest.getQuotes();
	}

	@Test(groups = { "sanity" }, enabled = true)
	public void testBudgetValidation() throws Exception {
		underTest.fillInStage1(FencesXpathLocators.xpathLookup.get("SOMETHING_ELSE"));
		underTest.fillInStage3(FencesXpathLocators.xpathLookup.get("JOB_STATUS_ID"), FencesXpathLocators.xpathLookup.get("OWNERSHIP_STATUS_ID"),
				FencesXpathLocators.xpathLookup.get("TIMING"), FencesXpathLocators.xpathLookup.get("POSTCODE"), TestScriptUtilities.getRandomString(30));
		underTest.fillInStage4(null);
		assertEquals(context.driver.findElement(By.xpath(FencesXpathLocators.xpathLookup.get("BUDGETSTHELSEXPATH"))).getText(),
				FencesXpathLocators.assertLookup.get("BUDGETMSG"));
	}

	@Test(groups = { "regression" }, enabled = true)
	public void testAdditionalInfoValidation() throws Exception {
		underTest.fillInStage1(FencesXpathLocators.xpathLookup.get("SOMETHING_ELSE"));
		underTest.fillInStage3(null, null, null, null, null);
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
	public void testContactValidation() throws Exception {
		underTest.fillInStage1(FencesXpathLocators.xpathLookup.get("SOMETHING_ELSE"));
		underTest.fillInStage3(FencesXpathLocators.xpathLookup.get("JOB_STATUS_ID"), FencesXpathLocators.xpathLookup.get("OWNERSHIP_STATUS_ID"),
				FencesXpathLocators.xpathLookup.get("TIMING"), FencesXpathLocators.xpathLookup.get("POSTCODE"), TestScriptUtilities.getRandomString(30));
		underTest.fillInStage4(FencesXpathLocators.xpathLookup.get("BUDGET"));
		JobFormSeleniumHelper.fillInContactPageDetailsAndPostJob(scriptUtilities, context, null, null, null, null, null, null);
		assertEquals(context.driver.findElement(By.xpath(FencesXpathLocators.xpathLookup.get("FNAMEXPATH"))).getText(),
				FencesXpathLocators.assertLookup.get("FNAMEMSG"));
		assertEquals(context.driver.findElement(By.xpath(FencesXpathLocators.xpathLookup.get("LNAMEXPATH"))).getText(),
				FencesXpathLocators.assertLookup.get("LNAMEMSG"));
		assertEquals(context.driver.findElement(By.xpath(FencesXpathLocators.xpathLookup.get("PNUMBERXPATH"))).getText(),
				FencesXpathLocators.assertLookup.get("PNUMBERMSG"));
		assertEquals(context.driver.findElement(By.xpath(FencesXpathLocators.xpathLookup.get("CONFIRMPNUMBERXPATH"))).getText(),
				FencesXpathLocators.assertLookup.get("CONFIRMPNUMBERMSG"));
		assertEquals(context.driver.findElement(By.xpath(FencesXpathLocators.xpathLookup.get("MAILXPATH"))).getText(),
				FencesXpathLocators.assertLookup.get("MAILMSG"));
		assertEquals(context.driver.findElement(By.xpath(FencesXpathLocators.xpathLookup.get("CONFIRMMAILXPATH"))).getText(),
				FencesXpathLocators.assertLookup.get("CONFIRMMAILMSG"));
	}
}
