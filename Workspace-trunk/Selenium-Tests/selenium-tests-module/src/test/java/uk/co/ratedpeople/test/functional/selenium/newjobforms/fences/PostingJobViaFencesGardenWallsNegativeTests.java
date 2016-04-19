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
public class PostingJobViaFencesGardenWallsNegativeTests extends TestScript {
	private PostingJobViaFencesJobForms underTest;

	@BeforeClass(alwaysRun = true)
	public void beforeClass() throws Exception {
		underTest = new PostingJobViaFencesJobForms(context.driver, context.getTestUrl(), scriptUtilities);
	}

	@BeforeMethod(alwaysRun = true)
	public void initTest() throws InterruptedException {
		underTest.getQuotes();
	}

	@Test(groups={"regression"},enabled = true)
	public void testGardenWallsJobDetailsValidation() throws Exception {
		underTest.fillInStage1(FencesXpathLocators.xpathLookup.get("GARDEN_WALLS"));
		underTest.fillInGardenWallsStage2(null, null, null, null, null);
		assertEquals(context.driver.findElement(By.xpath(FencesXpathLocators.xpathLookup.get("REQUIREMENTXPATH"))).getText(),
				FencesXpathLocators.assertLookup.get("REQUIREMENTMSG"));
		assertEquals(context.driver.findElement(By.xpath(FencesXpathLocators.xpathLookup.get("MATERIALSUXPATH"))).getText(),
				FencesXpathLocators.assertLookup.get("SUPPLYMSG"));
	}

	@Test(groups={"regression"},enabled = true)
	public void testGardenWallsJobDetailsReplaceValidation() throws Exception {
		underTest.fillInStage1(FencesXpathLocators.xpathLookup.get("GARDEN_WALLS"));
		underTest.fillInGardenWallsStage2(FencesXpathLocators.xpathLookup.get("GARDEN_WALLS_JOB_REQUIRMENT_INSTALL"), null, null, null, null);
		// underTest.fillInGardenWallsStage2(GARDEN_WALLS_JOB_REQUIRMENT_INSTALL, GARDEN_WALLS_LENGTH_INSTALL_XPATH, GARDEN_WALL_LENGTH_INSTALL,
		// GARDEN_WALL_HEIGHT_INSTALL, GARDEN_WALL_SUPPLY_MATERIAL);
		assertEquals(context.driver.findElement(By.xpath(FencesXpathLocators.xpathLookup.get("LENGTHWALLXPATH"))).getText(),
				FencesXpathLocators.assertLookup.get("LENGTHMSG"));
		assertEquals(context.driver.findElement(By.xpath(FencesXpathLocators.xpathLookup.get("HEIGHTXPATH"))).getText(),
				FencesXpathLocators.assertLookup.get("HEIGHTMSG"));
		assertEquals(context.driver.findElement(By.xpath(FencesXpathLocators.xpathLookup.get("MATERIALSUXPATH"))).getText(),
				FencesXpathLocators.assertLookup.get("MATERIALMSG"));
	}

	@Test(groups={"regression"},enabled = true)
	public void testGardenWallsAdditionalDetailsValidation() throws Exception {
		underTest.fillInStage1(FencesXpathLocators.xpathLookup.get("GARDEN_WALLS"));
		underTest.fillInGardenWallsStage2(FencesXpathLocators.xpathLookup.get("GARDEN_WALLS_JOB_REQUIRMENT_INSTALL"),
				FencesXpathLocators.xpathLookup.get("GARDEN_WALLS_LENGTH_INSTALL_XPATH"), FencesXpathLocators.xpathLookup.get("GARDEN_WALL_LENGTH_INSTALL"),
				FencesXpathLocators.xpathLookup.get("GARDEN_WALL_HEIGHT_INSTALL"), FencesXpathLocators.xpathLookup.get("GARDEN_WALL_SUPPLY_MATERIAL"));
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

	@Test(groups={"regression"},enabled = true)
	public void testGardenWallsBudgetValidation() throws Exception {
		underTest.fillInStage1(FencesXpathLocators.xpathLookup.get("GARDEN_WALLS"));
		underTest.fillInGardenWallsStage2(FencesXpathLocators.xpathLookup.get("GARDEN_WALLS_JOB_REQUIRMENT_INSTALL"),
				FencesXpathLocators.xpathLookup.get("GARDEN_WALLS_LENGTH_INSTALL_XPATH"), FencesXpathLocators.xpathLookup.get("GARDEN_WALL_LENGTH_INSTALL"),
				FencesXpathLocators.xpathLookup.get("GARDEN_WALL_HEIGHT_INSTALL"), FencesXpathLocators.xpathLookup.get("GARDEN_WALL_SUPPLY_MATERIAL"));
		underTest.fillInStage3(FencesXpathLocators.xpathLookup.get("JOB_STATUS_ID"), FencesXpathLocators.xpathLookup.get("OWNERSHIP_STATUS_ID"),
				FencesXpathLocators.xpathLookup.get("TIMING"), FencesXpathLocators.xpathLookup.get("POSTCODE"), TestScriptUtilities.getRandomString(30));
		underTest.fillInStage4(null);
		assertEquals(context.driver.findElement(By.xpath(FencesXpathLocators.xpathLookup.get("BUDGETXPATH"))).getText(),
				FencesXpathLocators.assertLookup.get("BUDGETMSG"));
	}

	@Test(enabled = false)
	public void testGardenWallsBudgetOtherValidation() throws Exception {
		underTest.fillInStage1(FencesXpathLocators.xpathLookup.get("GARDEN_WALLS"));
		underTest.fillInGardenWallsStage2(FencesXpathLocators.xpathLookup.get("GARDEN_WALLS_JOB_REQUIRMENT_INSTALL"),
				FencesXpathLocators.xpathLookup.get("GARDEN_WALLS_LENGTH_INSTALL_XPATH"), FencesXpathLocators.xpathLookup.get("GARDEN_WALL_LENGTH_INSTALL"),
				FencesXpathLocators.xpathLookup.get("GARDEN_WALL_HEIGHT_INSTALL"), FencesXpathLocators.xpathLookup.get("GARDEN_WALL_SUPPLY_MATERIAL"));
		underTest.fillInStage3(FencesXpathLocators.xpathLookup.get("JOB_STATUS_ID"), FencesXpathLocators.xpathLookup.get("OWNERSHIP_STATUS_ID"),
				FencesXpathLocators.xpathLookup.get("TIMING"), FencesXpathLocators.xpathLookup.get("POSTCODE"), TestScriptUtilities.getRandomString(30));
		Thread.sleep(2000);
		underTest.fillInStage4(FencesXpathLocators.xpathLookup.get("BUDGETOTHER"));
		String getText = context.driver.findElement(By.xpath(FencesXpathLocators.xpathLookup.get("BUDGETOTHERXPATH"))).getText();
		Thread.sleep(2000);
		System.out.println("getText for other budget  : " + getText);
		assertEquals(context.driver.findElement(By.xpath(FencesXpathLocators.xpathLookup.get("BUDGETOTHERXPATH"))).getText(),
				FencesXpathLocators.assertLookup.get("BUDGETOTHERMSG"));
	}

	@Test(groups={"regression"},enabled = true)
	public void testGardenWallsContactValidation() throws Exception {
		underTest.fillInStage1(FencesXpathLocators.xpathLookup.get("GARDEN_WALLS"));
		underTest.fillInGardenWallsStage2(FencesXpathLocators.xpathLookup.get("GARDEN_WALLS_JOB_REQUIRMENT_INSTALL"),
				FencesXpathLocators.xpathLookup.get("GARDEN_WALLS_LENGTH_INSTALL_XPATH"), FencesXpathLocators.xpathLookup.get("GARDEN_WALL_LENGTH_INSTALL"),
				FencesXpathLocators.xpathLookup.get("GARDEN_WALL_HEIGHT_INSTALL"), FencesXpathLocators.xpathLookup.get("GARDEN_WALL_SUPPLY_MATERIAL"));
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
