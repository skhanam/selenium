/**
 * 
 */
package uk.co.ratedpeople.test.functional.selenium.newjobforms.fences;

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
public class PostingJobViaFencesWoodenFencesNegativeTests extends TestScript {
	private static final String FENCES_JOB_REQUIRMENT_INSTALL = "FENCES_JOB_REQUIRMENT_INSTALL";
	private PostingJobViaFencesJobForms underTest;
	private static final String[] FENCES_USE_OF_FENCES_INSTALL_XPATH_LIST = { ".//*[@id='fencePanelsReplace']", ".//*[@id='fenceScreeningReplace']" };
	private static final String[] FENCES_USE_OF_FENCES_INSTALL_XPATH_LIST_OTHER = { ".//*[@id='fencePanelsReplace']", ".//*[@id='fenceOtherReplace']" };

	@BeforeClass(alwaysRun = true)
	public void beforeClass() throws Exception {
		underTest = new PostingJobViaFencesJobForms(context.driver, context.getTestUrl(), scriptUtilities);
	}

	@BeforeMethod(alwaysRun = true)
	public void initTest() throws InterruptedException {
		underTest.getQuotes();
	}

	@Test(groups = { "regression" }, enabled = true)
	public void testWoodenFencesJobDetailsValidation() throws Exception {
		underTest.fillInStage1(FencesXpathLocators.xpathLookup.get("FENCES"));
		underTest.fillInWoodenFenceStage2(null, null, null, null, null, null, null, null);
		assertEquals(context.driver.findElement(By.xpath(FencesXpathLocators.xpathLookup.get("REQUIREMENTFENCEXPATH"))).getText(),
				FencesXpathLocators.assertLookup.get("REQUIREMENTMSG"));
		assertEquals(context.driver.findElement(By.xpath(FencesXpathLocators.xpathLookup.get("MATERIALSFENCEXPATH"))).getText(),
				FencesXpathLocators.assertLookup.get("SUPPLYMSG"));
	}

	@Test(groups = { "regression" }, enabled = true)
	public void testWoodenFencesReplaceJobDetailsValidation() throws Exception {
		underTest.fillInStage1(FencesXpathLocators.xpathLookup.get("FENCES"));
		underTest.fillInWoodenFenceStage2(FencesXpathLocators.xpathLookup.get(FENCES_JOB_REQUIRMENT_INSTALL), null, null, null, null, null, null, null);
		assertEquals(context.driver.findElement(By.xpath(FencesXpathLocators.xpathLookup.get("LENGTHFENCEXPATH"))).getText(),
				FencesXpathLocators.assertLookup.get("LENGTHFENCEMSG"));
		assertEquals(context.driver.findElement(By.xpath(FencesXpathLocators.xpathLookup.get("FENCEREPLACEDXPATH"))).getText(),
				FencesXpathLocators.assertLookup.get("FENCETYPEMSG"));
		assertEquals(context.driver.findElement(By.xpath(FencesXpathLocators.xpathLookup.get("FENCEHEIGHTXPATH"))).getText(),
				FencesXpathLocators.assertLookup.get("HEIGHTMSG"));
		assertEquals(context.driver.findElement(By.xpath(FencesXpathLocators.xpathLookup.get("MATERIALSXPATH"))).getText(),
				FencesXpathLocators.assertLookup.get("MATERIALMSG"));
	}

	@Test(groups = { "regression" }, enabled = true)
	public void testWoodenFencesReplaceOtherJobDetailsValidation() throws Exception {
		underTest.fillInStage1(FencesXpathLocators.xpathLookup.get("FENCES"));
		underTest.fillInWoodenFenceStage2(FencesXpathLocators.xpathLookup.get(FENCES_JOB_REQUIRMENT_INSTALL), null, null,
				FENCES_USE_OF_FENCES_INSTALL_XPATH_LIST_OTHER, null, null, null, null);
		assertEquals(context.driver.findElement(By.xpath(FencesXpathLocators.xpathLookup.get("LENGTHFENCEXPATH"))).getText(),
				FencesXpathLocators.assertLookup.get("LENGTHFENCEMSG"));
		assertEquals(context.driver.findElement(By.xpath(FencesXpathLocators.xpathLookup.get("FENCEOTHERXPATH"))).getText(),
				FencesXpathLocators.assertLookup.get("FENCEOTHERMSG"));
		assertEquals(context.driver.findElement(By.xpath(FencesXpathLocators.xpathLookup.get("FENCEHEIGHTXPATH"))).getText(),
				FencesXpathLocators.assertLookup.get("HEIGHTMSG"));
		assertEquals(context.driver.findElement(By.xpath(FencesXpathLocators.xpathLookup.get("MATERIALSXPATH"))).getText(),
				FencesXpathLocators.assertLookup.get("MATERIALMSG"));
	}

	@Test(groups = { "sanity" }, enabled = true)
	public void testWoodenFencesAdditionalInfoValidation() throws Exception {
		underTest.fillInStage1(FencesXpathLocators.xpathLookup.get("FENCES"));
		underTest.fillInWoodenFenceStage2(FencesXpathLocators.xpathLookup.get(FENCES_JOB_REQUIRMENT_INSTALL),
				FencesXpathLocators.xpathLookup.get("FENCES_LENGTH_INSTALL_XPATH"), FencesXpathLocators.xpathLookup.get("FENCES_LENGTH_INSTALL"),
				FENCES_USE_OF_FENCES_INSTALL_XPATH_LIST, null, null, FencesXpathLocators.xpathLookup.get("FENCES_HEIGHT_INSTALL"),
				FencesXpathLocators.xpathLookup.get("FENCES_SUPPLY_MATERIAL"));
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
	public void testWoodenFencesBudgetValidation() throws Exception {
		underTest.fillInStage1(FencesXpathLocators.xpathLookup.get("FENCES"));
		underTest.fillInWoodenFenceStage2(FencesXpathLocators.xpathLookup.get(FENCES_JOB_REQUIRMENT_INSTALL),
				FencesXpathLocators.xpathLookup.get("FENCES_LENGTH_INSTALL_XPATH"), FencesXpathLocators.xpathLookup.get("FENCES_LENGTH_INSTALL"),
				FENCES_USE_OF_FENCES_INSTALL_XPATH_LIST, null, null, FencesXpathLocators.xpathLookup.get("FENCES_HEIGHT_INSTALL"),
				FencesXpathLocators.xpathLookup.get("FENCES_SUPPLY_MATERIAL"));
		underTest.fillInStage3(FencesXpathLocators.xpathLookup.get("JOB_STATUS_ID"), FencesXpathLocators.xpathLookup.get("OWNERSHIP_STATUS_ID"),
				FencesXpathLocators.xpathLookup.get("TIMING"), FencesXpathLocators.xpathLookup.get("POSTCODE"), TestScriptUtilities.getRandomString(30));
		underTest.fillInStage4(null);
		assertEquals(context.driver.findElement(By.xpath(FencesXpathLocators.xpathLookup.get("BUDGETXPATH"))).getText(),
				FencesXpathLocators.assertLookup.get("BUDGETMSG"));
	}

	@Test(groups = { "sanity" }, enabled = true)
	public void testWoodenFencesContactValidation() throws Exception {
		underTest.fillInStage1(FencesXpathLocators.xpathLookup.get("FENCES"));
		underTest.fillInWoodenFenceStage2(FencesXpathLocators.xpathLookup.get(FENCES_JOB_REQUIRMENT_INSTALL),
				FencesXpathLocators.xpathLookup.get("FENCES_LENGTH_INSTALL_XPATH"), FencesXpathLocators.xpathLookup.get("FENCES_LENGTH_INSTALL"),
				FENCES_USE_OF_FENCES_INSTALL_XPATH_LIST, null, null, FencesXpathLocators.xpathLookup.get("FENCES_HEIGHT_INSTALL"),
				FencesXpathLocators.xpathLookup.get("FENCES_SUPPLY_MATERIAL"));
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
