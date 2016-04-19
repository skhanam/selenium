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
public class PostingJobViaFencesGatesNegativeTests extends TestScript {
	private PostingJobViaFencesJobForms underTest;
	private static final String[] GATES_TYPE_TO_INSTALL_XPATH_LIST = { ".//*[@id='descGate']/div[2]/div[1]/ul/li[1]/a[2]",
			".//*[@id='descGate']/div[2]/div[1]/ul/li[2]/a[2]" };
	private static final String[] GATES_TYPE_TO_INSTALL_XPATH_LIST_OTHER = { ".//*[@id='descGate']/div[2]/div[1]/ul/li[1]/a[2]",
			".//*[@id='descGate']/div[2]/div[1]/ul/li[3]/a[2]" };

	@BeforeClass(alwaysRun = true)
	public void beforeClass() throws Exception {
		underTest = new PostingJobViaFencesJobForms(context.driver, context.getTestUrl(), scriptUtilities);
	}

	@BeforeMethod(alwaysRun = true)
	public void initTest() throws InterruptedException {
		underTest.getQuotes();
	}

	@Test(groups = { "regression" }, enabled = true)
	public void testGatesJobDetailsValidation() throws Exception {
		underTest.fillInStage1(FencesXpathLocators.xpathLookup.get("GATES"));
		underTest.fillInGatesStage2(null, null, null, null, null);
		assertEquals(context.driver.findElement(By.xpath(FencesXpathLocators.xpathLookup.get("REQUIREMENTGATEXPATH"))).getText(),
				FencesXpathLocators.assertLookup.get("REQUIREMENTMSG"));
		assertEquals(context.driver.findElement(By.xpath(FencesXpathLocators.xpathLookup.get("MATERIALGATEXPATH"))).getText(),
				FencesXpathLocators.assertLookup.get("SUPPLYMSG"));
	}

	@Test(groups = { "sanity" }, enabled = true)
	public void testGatesReplaceJobDetailsValidation() throws Exception {
		underTest.fillInStage1(FencesXpathLocators.xpathLookup.get("GATES"));
		underTest.fillInGatesStage2(FencesXpathLocators.xpathLookup.get("GATES_JOB_REQUIRMENT_INSTALL"), null, null, null, null);
		assertEquals(context.driver.findElement(By.xpath(FencesXpathLocators.xpathLookup.get("GATEINSTALLXPATH"))).getText(),
				FencesXpathLocators.assertLookup.get("GATEINSTALLMSG"));
		assertEquals(context.driver.findElement(By.xpath(FencesXpathLocators.xpathLookup.get("SUPPLYMATERIALXPATH"))).getText(),
				FencesXpathLocators.assertLookup.get("MATERIALMSG"));
	}

	@Test(groups = { "regression" }, enabled = true)
	public void testGatesOtherJobDetailsValidation() throws Exception {
		underTest.fillInStage1(FencesXpathLocators.xpathLookup.get("GATES"));
		underTest.fillInGatesStage2(FencesXpathLocators.xpathLookup.get("GATES_JOB_REQUIRMENT_INSTALL"), GATES_TYPE_TO_INSTALL_XPATH_LIST_OTHER, null, null,
				null);
		assertEquals(context.driver.findElement(By.xpath(FencesXpathLocators.xpathLookup.get("GATETYPEXPATH"))).getText(),
				FencesXpathLocators.assertLookup.get("GATETYPEMSG"));
		assertEquals(context.driver.findElement(By.xpath(FencesXpathLocators.xpathLookup.get("SUPPLYMATERIALXPATH"))).getText(),
				FencesXpathLocators.assertLookup.get("MATERIALMSG"));
	}

	@Test(groups = { "sanity" }, enabled = true)
	public void testGatesAdditionalInfoValidation() throws Exception {
		underTest.fillInStage1(FencesXpathLocators.xpathLookup.get("GATES"));
		underTest.fillInGatesStage2(FencesXpathLocators.xpathLookup.get("GATES_JOB_REQUIRMENT_INSTALL"), GATES_TYPE_TO_INSTALL_XPATH_LIST, null, null,
				FencesXpathLocators.xpathLookup.get("GATES_SUPPLY_MATERIAL"));
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
	public void testGatesBudgetValidation() throws Exception {
		underTest.fillInStage1(FencesXpathLocators.xpathLookup.get("GATES"));
		underTest.fillInGatesStage2(FencesXpathLocators.xpathLookup.get("GATES_JOB_REQUIRMENT_INSTALL"), GATES_TYPE_TO_INSTALL_XPATH_LIST, null, null,
				FencesXpathLocators.xpathLookup.get("GATES_SUPPLY_MATERIAL"));
		underTest.fillInStage3(FencesXpathLocators.xpathLookup.get("JOB_STATUS_ID"), FencesXpathLocators.xpathLookup.get("OWNERSHIP_STATUS_ID"),
				FencesXpathLocators.xpathLookup.get("TIMING"), FencesXpathLocators.xpathLookup.get("POSTCODE"), TestScriptUtilities.getRandomString(30));
		underTest.fillInStage4(null);
		assertEquals(context.driver.findElement(By.xpath(FencesXpathLocators.xpathLookup.get("BUDGETXPATH"))).getText(),
				FencesXpathLocators.assertLookup.get("BUDGETMSG"));
	}

	@Test(groups = { "regression" }, enabled = true)
	public void testGatesContactValidation() throws Exception {
		underTest.fillInStage1(FencesXpathLocators.xpathLookup.get("GATES"));
		underTest.fillInGatesStage2(FencesXpathLocators.xpathLookup.get("GATES_JOB_REQUIRMENT_INSTALL"), GATES_TYPE_TO_INSTALL_XPATH_LIST, null, null,
				FencesXpathLocators.xpathLookup.get("GATES_SUPPLY_MATERIAL"));
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
